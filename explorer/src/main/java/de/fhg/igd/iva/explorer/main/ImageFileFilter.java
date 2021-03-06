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


package de.fhg.igd.iva.explorer.main;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.imageio.spi.ImageReaderWriterSpi;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.common.base.Joiner;

/**
 * A {@link FileFilter} for {@link JFileChooser},
 * based on {@link ImageIO} image readers, very similar
 * to {@link FileNameExtensionFilter}. <br/>
 *
 * It also supports {@link #equals(Object)} properly and provides a
 * {@link Comparator}
 * @author Martin Steiger
 */
class ImageFileFilter extends FileFilter
{
	private final ImageReaderWriterSpi provider;

	/**
	 * @param reader
	 */
	ImageFileFilter(ImageReaderWriterSpi reader)
	{
		this.provider = reader;
	}

	@Override
	public String getDescription()
	{
//		String desc = provider.getDescription(Locale.getDefault());
		String[] sufs = provider.getFileSuffixes();
		String matches = Joiner.on("; *.").join(sufs);
		String primary = provider.getFormatNames()[0];
		return primary.toUpperCase() + " (*." + matches + ")";
	}

	@Override
	public boolean accept(File f)
	{
		String[] sufs = provider.getFileSuffixes();
		String name = f.getName().toLowerCase();

		for (String suf : sufs) {
			if (name.endsWith(suf.toLowerCase()))
				return true;
		}

		return false;
	}
}

