package com.google.android.exoplayer2;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashSet;
/* loaded from: classes7.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.6.0";
    public static final int VERSION_INT = 2006000;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.6.0";
    public static final HashSet<String> registeredModules = new HashSet<>();
    public static String registeredModulesString = "goog.exo.core";

    public static synchronized String registeredModules() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = registeredModulesString;
        }
        return str;
    }

    public static synchronized void registerModule(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (registeredModules.add(str)) {
                registeredModulesString += StringUtil.ARRAY_ELEMENT_SEPARATOR + str;
            }
        }
    }
}
