/** Leaf 角色：代表個別球隊，不允許新增子節點。 */
public class Team extends MLBComponent {

    public Team(String name) {
        super(name);
    }

    @Override
    public void add(MLBComponent component) {
        throw new UnsupportedOperationException("Team 是葉節點，不能新增子節點");
    }

    @Override
    public void remove(MLBComponent component) {
        throw new UnsupportedOperationException("Team 是葉節點，不能移除子節點");
    }

    @Override
    public MLBComponent getChild(int index) {
        throw new UnsupportedOperationException("Team 是葉節點，沒有子節點");
    }

    @Override
    public int getChildCount() {
        return 0;
    }
}
