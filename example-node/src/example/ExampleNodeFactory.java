package example;
import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeView;
import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;

public class ExampleNodeFactory extends NodeFactory<NodeModel> {

	@Override
	public NodeModel createNodeModel() {
		return new ExampleNodeModel();
	}

	@Override
	public int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<NodeModel> createNodeView(final int viewIndex, final NodeModel nodeModel) {
		return null;
	}

	@Override
	public boolean hasDialog() {
		return false;
	}

	@Override
	public NodeDialogPane createNodeDialogPane() {
		return new DefaultNodeSettingsPane();
	}
}