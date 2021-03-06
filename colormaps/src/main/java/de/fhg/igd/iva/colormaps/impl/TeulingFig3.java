package de.fhg.igd.iva.colormaps.impl;

import java.awt.Color;

public class TeulingFig3 extends TeulingStyle {

	@Override
	public Color getColor(double x, double y) {
		double r = getChannel(x, y, Direction.SOUTH_EAST, 1 - 0.32);
		double g = getChannel(x, y, Direction.SOUTH_WEST, 0.5);
		double b = getChannel(x, y, Direction.NORTH_WEST, 0.32);
		double w = getWhitening(x, y, 0.5);
		r = clampSafe(r+w, 0.1f);
		g = clampSafe(g+w, 0.1f);
		b = clampSafe(b+w, 0.1f);
		return new Color((float)r, (float)g, (float)b);
	}

	@Override
	public String getDescription() {
		return "See Teuling paper fig. 3 / 4 (c). This colormap is as described, not as shown in the paper. Orientation as in Fig. 4";
//		return "See Teuling paper fig. 3 / 4 (c). Note: In the paper, (at least) the green channel is "
//				+ "not maxed out in the SW corner, suggesting there are more tweaks than described. This colormap "
//				+ "is as described, not as shown in the paper. Orientation as in Fig. 4";
	}

	@Override
	public String getName() {
		return "Teuling et al. Fig. 3";
	}
}
