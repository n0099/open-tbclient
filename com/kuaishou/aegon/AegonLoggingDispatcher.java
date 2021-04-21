package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes6.dex */
public class AegonLoggingDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static d f31992a;

    @Keep
    public static void Log(int i, String str, String str2) {
        d dVar = f31992a;
        if (dVar != null) {
            dVar.a(i, str, str2);
        }
    }
}
