package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31652a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31653b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31654c;

    public static Context a() {
        return f31652a;
    }

    public static void a(Context context) {
        f31652a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31654c = aVar;
    }

    public static void a(File file) {
        f31653b = file;
    }

    public static void a(String str) {
        f31654c.installApp(a(), str);
    }

    public static File b() {
        return f31653b;
    }
}
