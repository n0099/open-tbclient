package com.tencent.turingfd.sdk.ams.au;

import com.baidu.adp.plugin.install.PluginInstallerService;
/* loaded from: classes3.dex */
public class ar {
    public static boolean a(String str, String str2) {
        int indexOf;
        if (str2 == null || (indexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String trim = str2.substring(indexOf).trim();
        if (!trim.startsWith("/data/") || trim.startsWith("/data/data/" + str + "/")) {
            return false;
        }
        boolean endsWith = trim.endsWith(PluginInstallerService.APK_LIB_SUFFIX);
        return (endsWith || (!endsWith && trim.endsWith(".jar"))) && str2.contains(y.a(y.m));
    }
}
