package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7910a;

    /* renamed from: b  reason: collision with root package name */
    private static File f7911b;
    private static a c;

    public static Context a() {
        return f7910a;
    }

    public static void a(Context context) {
        f7910a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        c = aVar;
    }

    public static void a(File file) {
        f7911b = file;
    }

    public static void a(String str) {
        c.installApp(a(), str);
    }

    public static File b() {
        return f7911b;
    }
}
