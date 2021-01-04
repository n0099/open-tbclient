package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f8207a;

    /* renamed from: b  reason: collision with root package name */
    private static File f8208b;
    private static a c;

    public static Context a() {
        return f8207a;
    }

    public static void a(Context context) {
        f8207a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        c = aVar;
    }

    public static void a(File file) {
        f8208b = file;
    }

    public static void a(String str) {
        c.installApp(a(), str);
    }

    public static File b() {
        return f8208b;
    }
}
