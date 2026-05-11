import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * 主視窗：使用 JTree 顯示 MLB 三層樹狀結構。
 * 延伸題：點選球隊節點時，底部顯示所屬聯盟與分區資訊。
 */
public class MLBViewer extends JFrame {

    private JLabel infoLabel;

    public MLBViewer() {
        setTitle("MLB Structure Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 640);

        MLBComponent mlb = buildMLBStructure();
        DefaultMutableTreeNode root = buildTreeNode(mlb);

        JTree tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // 展開全部節點
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }

        infoLabel = new JLabel("點選球隊節點以查看所屬聯盟與分區");
        infoLabel.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        // 延伸題：選取球隊（第 4 層，path 長度為 4）時顯示路徑資訊
        tree.addTreeSelectionListener(e -> {
            TreePath path = tree.getSelectionPath();
            if (path != null && path.getPathCount() == 4) {
                String league = path.getPathComponent(1).toString();
                String division = path.getPathComponent(2).toString();
                String teamName = path.getPathComponent(3).toString();
                infoLabel.setText(teamName + "  |  " + league + " > " + division);
            } else {
                infoLabel.setText("點選球隊節點以查看所屬聯盟與分區");
            }
        });

        add(new JScrollPane(tree), BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** 遞迴將 MLBComponent 轉換為 DefaultMutableTreeNode。 */
    private DefaultMutableTreeNode buildTreeNode(MLBComponent component) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(component.getName());
        for (int i = 0; i < component.getChildCount(); i++) {
            node.add(buildTreeNode(component.getChild(i)));
        }
        return node;
    }

    /** 建立完整 MLB 三層結構。 */
    private MLBComponent buildMLBStructure() {
        League mlb = new League("MLB");

        // American League
        League al = new League("American League");

        Division alEast = new Division("East");
        alEast.add(new Team("Baltimore Orioles"));
        alEast.add(new Team("Boston Red Sox"));
        alEast.add(new Team("New York Yankees"));
        alEast.add(new Team("Tampa Bay Rays"));
        alEast.add(new Team("Toronto Blue Jays"));

        Division alCentral = new Division("Central");
        alCentral.add(new Team("Chicago White Sox"));
        alCentral.add(new Team("Cleveland Guardians"));
        alCentral.add(new Team("Detroit Tigers"));
        alCentral.add(new Team("Kansas City Royals"));
        alCentral.add(new Team("Minnesota Twins"));

        Division alWest = new Division("West");
        alWest.add(new Team("Houston Astros"));
        alWest.add(new Team("Los Angeles Angels"));
        alWest.add(new Team("Oakland Athletics"));
        alWest.add(new Team("Seattle Mariners"));
        alWest.add(new Team("Texas Rangers"));

        al.add(alEast);
        al.add(alCentral);
        al.add(alWest);

        // National League
        League nl = new League("National League");

        Division nlEast = new Division("East");
        nlEast.add(new Team("Atlanta Braves"));
        nlEast.add(new Team("Miami Marlins"));
        nlEast.add(new Team("New York Mets"));
        nlEast.add(new Team("Philadelphia Phillies"));
        nlEast.add(new Team("Washington Nationals"));

        Division nlCentral = new Division("Central");
        nlCentral.add(new Team("Chicago Cubs"));
        nlCentral.add(new Team("Cincinnati Reds"));
        nlCentral.add(new Team("Milwaukee Brewers"));
        nlCentral.add(new Team("Pittsburgh Pirates"));
        nlCentral.add(new Team("St. Louis Cardinals"));

        Division nlWest = new Division("West");
        nlWest.add(new Team("Arizona Diamondbacks"));
        nlWest.add(new Team("Colorado Rockies"));
        nlWest.add(new Team("Los Angeles Dodgers"));
        nlWest.add(new Team("San Diego Padres"));
        nlWest.add(new Team("San Francisco Giants"));

        nl.add(nlEast);
        nl.add(nlCentral);
        nl.add(nlWest);

        mlb.add(al);
        mlb.add(nl);

        return mlb;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MLBViewer::new);
    }
}
