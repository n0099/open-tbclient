package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31152a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31153b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31154c;

    public static Context a() {
        return f31152a;
    }

    public static void a(Context context) {
        f31152a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31154c = aVar;
    }

    public static void a(File file) {
        f31153b = file;
    }

    public static void a(String str) {
        f31154c.installApp(a(), str);
    }

    public static File b() {
        return f31153b;
    }
}
