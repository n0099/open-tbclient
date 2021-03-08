package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes3.dex */
public class AegonLoggingDispatcher {
    public static i pZd;

    @Keep
    public static void Log(int i, String str, String str2) {
        i iVar = pZd;
        if (iVar != null) {
            iVar.a(i, str, str2);
        }
    }
}
