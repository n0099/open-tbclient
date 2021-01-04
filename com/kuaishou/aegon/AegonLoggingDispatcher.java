package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes5.dex */
public class AegonLoggingDispatcher {
    public static i pQC;

    @Keep
    public static void Log(int i, String str, String str2) {
        i iVar = pQC;
        if (iVar != null) {
            iVar.a(i, str, str2);
        }
    }
}
