/*
*  Copyright (c) 2005-2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.server.extensions;


import org.wso2.carbon.server.CarbonLaunchExtension;
import org.wso2.carbon.server.LauncherConstants;
import org.wso2.carbon.server.util.Utils;

import java.io.File;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;


/**
 * This class will read the extension folder and create extension bundles.
 * User need to drop the classic jars that needed to be extended in ${carbon.home}/extensions
 * folder.
 */
public class SystemBundleExtensionCreator implements CarbonLaunchExtension {

    private static final String EXTENSIONS_DIR =
            "repository" + File.separator + "components" + File.separator + "extensions";

    private static final String EXTENSION_PREFIX = "org.wso2.carbon.framework.extension.";

    public void perform() {
        File dropinsFolder = new File(Utils.getCarbonComponentRepo(), "dropins");

        File dir = Utils.getBundleDirectory(EXTENSIONS_DIR);
        File[] files = dir.listFiles(new Utils.JarFileFilter());
        if (files != null) {
            for (File file : files) {
                try {
                    Manifest mf = new Manifest();
                    Attributes attribs = mf.getMainAttributes();
                    attribs.putValue(LauncherConstants.FRAGMENT_HOST, "system.bundle; extension:=framework");
                    Utils.createBundle(file, dropinsFolder, mf, EXTENSION_PREFIX);
                } catch (IOException e) {
                    System.err.println("Cannot create framework extension bundle from jar file " +
                                       file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }
}
