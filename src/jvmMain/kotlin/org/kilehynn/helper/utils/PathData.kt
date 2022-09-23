package org.kilehynn.helper.utils

import java.io.File


data class PathData(val path: File)

val MODS_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Electronic Arts" + File.separator + "The Sims 4" + File.separator + "Mods"
val TO_TEST_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "5050 Helper" + File.separator + "ToTest"
val TESTED_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "5050 Helper" + File.separator + "Tested"