package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31770a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31771b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31772c;

    public static Context a() {
        return f31770a;
    }

    public static void a(Context context) {
        f31770a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31772c = aVar;
    }

    public static void a(File file) {
        f31771b = file;
    }

    public static void a(String str) {
        f31772c.installApp(a(), str);
    }

    public static File b() {
        return f31771b;
    }
}
