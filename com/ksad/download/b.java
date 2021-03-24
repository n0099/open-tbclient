package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31151a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31152b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31153c;

    public static Context a() {
        return f31151a;
    }

    public static void a(Context context) {
        f31151a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31153c = aVar;
    }

    public static void a(File file) {
        f31152b = file;
    }

    public static void a(String str) {
        f31153c.installApp(a(), str);
    }

    public static File b() {
        return f31152b;
    }
}
