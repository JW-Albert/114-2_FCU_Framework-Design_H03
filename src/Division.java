import java.util.ArrayList;
import java.util.List;

/** Composite 角色：代表一個分區（例如 East / Central / West），可包含多個 Team。 */
public class Division extends MLBComponent {

    private List<MLBComponent> children = new ArrayList<>();

    public Division(String name) {
        super(name);
    }

    @Override
    public void add(MLBComponent component) {
        children.add(component);
    }

    @Override
    public void remove(MLBComponent component) {
        children.remove(component);
    }

    @Override
    public MLBComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }
}
