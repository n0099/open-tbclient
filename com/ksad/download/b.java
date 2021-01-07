package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f8208a;

    /* renamed from: b  reason: collision with root package name */
    private static File f8209b;
    private static a c;

    public static Context a() {
        return f8208a;
    }

    public static void a(Context context) {
        f8208a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        c = aVar;
    }

    public static void a(File file) {
        f8209b = file;
    }

    public static void a(String str) {
        c.installApp(a(), str);
    }

    public static File b() {
        return f8209b;
    }
}
