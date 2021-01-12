package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes4.dex */
public class AegonLoggingDispatcher {
    public static i pNK;

    @Keep
    public static void Log(int i, String str, String str2) {
        i iVar = pNK;
        if (iVar != null) {
            iVar.a(i, str, str2);
        }
    }
}
