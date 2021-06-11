package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31672a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31673b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31674c;

    public static Context a() {
        return f31672a;
    }

    public static void a(Context context) {
        f31672a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31674c = aVar;
    }

    public static void a(File file) {
        f31673b = file;
    }

    public static void a(String str) {
        f31674c.installApp(a(), str);
    }

    public static File b() {
        return f31673b;
    }
}
