/**
 * Composite pattern 的共同抽象類別，代表 MLB 結構中的任意節點。
 */
public abstract class MLBComponent {

    protected String name;

    public MLBComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(MLBComponent component);

    public abstract void remove(MLBComponent component);

    public abstract MLBComponent getChild(int index);

    public abstract int getChildCount();

    @Override
    public String toString() {
        return name;
    }
}
