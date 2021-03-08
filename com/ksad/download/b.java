package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5294a;
    private static File b;
    private static a c;

    public static Context a() {
        return f5294a;
    }

    public static void a(Context context) {
        f5294a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        c = aVar;
    }

    public static void a(File file) {
        b = file;
    }

    public static void a(String str) {
        c.installApp(a(), str);
    }

    public static File b() {
        return b;
    }
}
