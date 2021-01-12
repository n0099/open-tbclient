package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7908a;

    /* renamed from: b  reason: collision with root package name */
    private static File f7909b;
    private static a c;

    public static Context a() {
        return f7908a;
    }

    public static void a(Context context) {
        f7908a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        c = aVar;
    }

    public static void a(File file) {
        f7909b = file;
    }

    public static void a(String str) {
        c.installApp(a(), str);
    }

    public static File b() {
        return f7909b;
    }
}
