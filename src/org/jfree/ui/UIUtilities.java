/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ---------------
 * TextAnchor.java
 * ---------------
 * (C) Copyright 2002-2005, by Object Refinery Limited.
 *
 * Original Author:  Thomas Morgner (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: UIUtilities.java,v 1.4 2005/06/01 14:12:29 taqua Exp $
 *
 * Changes:
 * --------
 * 25-Jul-2002 : Version 1 (TM);
 */
package org.jfree.ui;

import java.awt.Color;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;

/**
 * A utility class to tune the Metal look and feel.
 *
 * @author Thomas Morgner
 */
public class UIUtilities {

    /**
     * Private constructor prevents object creation.
     */
    private UIUtilities() {
    }

    /**
     * Set up the user interface.
     */
    public static void setupUI() {
        try {
            final String classname = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(classname);
        }
        catch (Exception e) { 
            e.printStackTrace();
        }

        final UIDefaults defaults = UIManager.getDefaults();

        defaults.put(
            "PopupMenu.border", 
            new BorderUIResource.EtchedBorderUIResource(
                EtchedBorder.RAISED, defaults.getColor("controlShadow"), 
                defaults.getColor("controlLtHighlight")
            )
        );

        final MatteBorder matteborder = new MatteBorder(1, 1, 1, 1, Color.black);
        final EmptyBorder emptyborder = new MatteBorder(2, 2, 2, 2, defaults.getColor("control"));
        final BorderUIResource.CompoundBorderUIResource compBorder
            = new BorderUIResource.CompoundBorderUIResource(emptyborder, matteborder);
        final BorderUIResource.EmptyBorderUIResource emptyBorderUI
            = new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0);
        defaults.put("SplitPane.border", emptyBorderUI);
        defaults.put("Table.scrollPaneBorder", emptyBorderUI);
        defaults.put("ComboBox.border", compBorder);
        defaults.put("TextField.border", compBorder);
        defaults.put("TextArea.border", compBorder);
        defaults.put("CheckBox.border", compBorder);
        defaults.put("ScrollPane.border", emptyBorderUI);

    }

}
