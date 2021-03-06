package de.fhg.igd.iva.colormaps.impl;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.igd.iva.colormaps.AbstractKnownColormap;
import de.fhg.igd.iva.colormaps.ColorSpace;
import de.fhg.igd.iva.colorspaces.HSL;

public class SimulaHSB3 extends AbstractKnownColormap {

	Logger _log = LoggerFactory.getLogger(getClass());
		
	@Override
	public Color getColor(double x, double y) {
		// normalize to -1..1
		double nx = (x * 2 - 1);
		double ny = (y * 2 - 1);
		double dist = max(abs(ny), abs(nx));
		double ang = (Math.atan2(ny, nx) + Math.PI) / (Math.PI * 2);
		return HSL.HSLtoRGB((float) ang, 1, (float) dist / 2f);
	}

	@Override
	public String getName() {
		return "Simula and Alhoniemi";
	}

	@Override
	public String getDescription() {
		return "HSL-based map with black center and constant saturation.";
	}

	@Override
	public List<String> getReferences() {
		return Collections.singletonList("simula1999som");
	}

	@Override
	public ColorSpace getColorSpace() {
		return ColorSpace.HSV;
	}

}
