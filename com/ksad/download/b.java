package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31536a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31537b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31538c;

    public static Context a() {
        return f31536a;
    }

    public static void a(Context context) {
        f31536a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31538c = aVar;
    }

    public static void a(File file) {
        f31537b = file;
    }

    public static void a(String str) {
        f31538c.installApp(a(), str);
    }

    public static File b() {
        return f31537b;
    }
}
