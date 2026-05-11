# Framework Design Homework 3

## Intro:
    這是一個軟體框架的作業，需要使用 JAVA 開發一個簡單的程式。題目要求如下:
    使用 Composite 設計模式實作 MLB 聯盟與球隊結構。設計一套類別架構，能表示
    聯盟 (League)、分區 (Division)、球隊 (Team) 三層結構，並使用 JTree 顯示出
    MLB 完整資料。

## 程式碼風格規範:
    - 使用物件導向化: 切勿將程式碼都實作在 main 函數中，應適當使用封裝、介面與相關功能。
    - 變數命名: 變數名稱應當與其功能相同，使用小駝峰進行命名。
    - class 命名: 使用大駝峰命名法命名。
    - 簡單化: 這只是一個小作業不是商品，只要求功能不要求完整功能，達成題目要求即可。
    - 註釋: 應在合理處加上註解，不應過多也不應過少。
    - 文件化: 建立 `README.md` 文件，完整說明其運作

## 設計目標（Composite Pattern）
    - 定義共同的抽象類別或介面 `MLBComponent`，統一描述聯盟、分區、球隊的操作。
    - `League`、`Division` 為 **Composite** 角色，可包含其他 `MLBComponent` 子節點。
    - `Team` 為 **Leaf** 角色，代表個別球隊，不能再新增子節點。
    - 以 `JTree` 呈現完整 MLB 三層樹狀結構。

## 建議架構（最小可交付版本）
    - `MLBComponent`（抽象類別或介面）
        - `void add(MLBComponent component)`
        - `void remove(MLBComponent component)`
        - `MLBComponent getChild(int index)`
        - `String getName()`
    - `League` 類別（Composite）
        - 代表整個聯盟，例如 American League / National League
        - 可包含多個 `Division`
    - `Division` 類別（Composite）
        - 代表分區，例如 East / Central / West
        - 可包含多個 `Team`
    - `Team` 類別（Leaf）
        - 代表個別球隊，例如 Baltimore Orioles
        - `add()` / `remove()` 應拋出例外或無作用（不允許新增子節點）

    MLB 樹狀結構範例：
    ```
    MLB
     ├── American League
     │    ├── East
     │    │    ├── Baltimore Orioles
     │    │    ├── Boston Red Sox
     │    │    └── ...
     │    └── Central
     │         └── ...
     └── National League
          └── East
               └── ...
    ```

## JTree UI 需求（最小面板）
    - 視窗標題：自行命名（例：MLB Structure Viewer）
    - 元件建議：
        - 使用 `JTree` 顯示完整 MLB 三層樹狀結構
        - 根節點為 MLB，第一層為聯盟，第二層為分區，第三層為球隊
    - 延伸題（選做）：
        - 點選球隊（Leaf）節點時，在畫面顯示該球隊所屬的聯盟與分區資訊

## 交付文件
    - PDF文件: 使用 MarkDown 先撰寫好文件後，轉換為 PDF
    - 文件內容:
        - 姓名: 王建葦
        - 學號: D1210799
        - 班級: 資訊三乙
        - 題目: MLB 棒球大聯盟
        - 設計方法概述
        - 程式、執行畫面及其說明
        - 參考資料
        - AI 使用狀況與心得
        - 概述提問的內容，以及 AI 的回答
        - 你手動(沒有用AI)的部份
        - 心得（AI的實用性、限制、對你學習的影響）

## 驗收清單（你交作業前自測）
    - `MLBComponent` 介面/抽象類別定義了 `add()`、`remove()`、`getChild()`、`getName()`
    - `League` 與 `Division` 為 Composite 角色，可包含子節點
    - `Team` 為 Leaf 角色，不允許新增子節點
    - `JTree` 正確顯示 MLB 完整三層結構
    - `README.md` 有：如何執行、操作方式、主要類別說明與 Composite 設計概述