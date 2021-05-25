package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31581a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31582b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31583c;

    public static Context a() {
        return f31581a;
    }

    public static void a(Context context) {
        f31581a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31583c = aVar;
    }

    public static void a(File file) {
        f31582b = file;
    }

    public static void a(String str) {
        f31583c.installApp(a(), str);
    }

    public static File b() {
        return f31582b;
    }
}
