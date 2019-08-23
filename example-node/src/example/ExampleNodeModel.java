package example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.knime.base.data.xml.SvgCell;
import org.knime.base.data.xml.SvgImageContent;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.port.PortObject;
import org.knime.core.node.port.PortObjectSpec;
import org.knime.core.node.port.PortType;
import org.knime.core.node.port.image.ImagePortObject;
import org.knime.core.node.port.image.ImagePortObjectSpec;
import org.knime.core.util.FileUtil;

public class ExampleNodeModel extends NodeModel {

	private static final PortType[] IN_TYPES = {};
	private static final PortType[] OUT_TYPES = { ImagePortObject.TYPE };

	private static final ImagePortObjectSpec SVG_SPEC = new ImagePortObjectSpec(SvgCell.TYPE);

	protected ExampleNodeModel() {
		super(IN_TYPES, OUT_TYPES);
	}

	@Override
	protected PortObject[] execute(PortObject[] inData, ExecutionContext exec) throws Exception {
		try (InputStream fis = FileUtil
				.openInputStream("https://www.knime.com/themes/custom/bootstrap_knime/logo.svg")) {
			final SvgImageContent content = new SvgImageContent(fis);
			final ImagePortObject imgObj = new ImagePortObject(content, SVG_SPEC);
			return new PortObject[] { imgObj };
		}
	}

	@Override
	protected void loadInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
	}

	@Override
	protected void saveInternals(File nodeInternDir, ExecutionMonitor exec)
			throws IOException, CanceledExecutionException {
	}

	@Override
	protected PortObjectSpec[] configure(PortObjectSpec[] inSpecs) throws InvalidSettingsException {
		return new PortObjectSpec[] { SVG_SPEC };
	}

	@Override
	protected void saveSettingsTo(NodeSettingsWO settings) {
	}

	@Override
	protected void validateSettings(NodeSettingsRO settings) throws InvalidSettingsException {
	}

	@Override
	protected void loadValidatedSettingsFrom(NodeSettingsRO settings) throws InvalidSettingsException {
	}

	@Override
	protected void reset() {
	}
}
