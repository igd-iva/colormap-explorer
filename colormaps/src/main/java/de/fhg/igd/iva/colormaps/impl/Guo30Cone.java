/*
 * Copyright 2014 Fraunhofer IGD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.fhg.igd.iva.colormaps.impl;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jubernar
 * @deprecated Ähnlich zu Guo30Gauss aber etwas schlechter in den
 *             Qualitätswerten. Daher meine Empfehlung: raus aus dem Paper [JB]
 * 
 */
@Deprecated
public class Guo30Cone extends GuoLabStyle {
	public Guo30Cone() {
		super(cone(60f), linearAB(0, 80, 0, -80));
	}

	@Override
	public String getName() {
		return "Guo et al. (Cone)";
	}

	@Override
	public String getDescription() {
		return "Guo 2005 (L*a*b*; Cone lightness; chroma linearly mapped to ab)";
	}

	@Override
	public List<String> getReferences() {
		return Arrays.asList("Guo05", "Guo06visualization");
	}

}
