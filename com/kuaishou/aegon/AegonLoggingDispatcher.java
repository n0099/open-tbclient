package com.kuaishou.aegon;

import androidx.annotation.Keep;
/* loaded from: classes6.dex */
public class AegonLoggingDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static d f32247a;

    @Keep
    public static void Log(int i2, String str, String str2) {
        d dVar = f32247a;
        if (dVar != null) {
            dVar.a(i2, str, str2);
        }
    }
}
