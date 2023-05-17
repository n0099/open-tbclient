package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import javax.annotation.Nullable;
@DoNotOptimize
@TargetApi(18)
/* loaded from: classes9.dex */
public class Api18TraceUtils {
    public static final int MAX_SECTION_NAME_LENGTH = 127;

    public static void endSection() {
        Trace.endSection();
    }

    public static void beginTraceSection(String str, @Nullable String str2, String str3) {
        String str4 = str + str2 + str3;
        if (str4.length() > 127 && str2 != null) {
            int length = (127 - str.length()) - str3.length();
            str4 = str + str2.substring(0, length) + str3;
        }
        Trace.beginSection(str4);
    }
}
