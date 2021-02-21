package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes3.dex */
public class AegonLoggingDispatcher {
    public static i pYp;

    @Keep
    public static void Log(int i, String str, String str2) {
        i iVar = pYp;
        if (iVar != null) {
            iVar.a(i, str, str2);
        }
    }
}
