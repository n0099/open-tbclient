package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31441a;

    /* renamed from: b  reason: collision with root package name */
    public static File f31442b;

    /* renamed from: c  reason: collision with root package name */
    public static a f31443c;

    public static Context a() {
        return f31441a;
    }

    public static void a(Context context) {
        f31441a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f31443c = aVar;
    }

    public static void a(File file) {
        f31442b = file;
    }

    public static void a(String str) {
        f31443c.installApp(a(), str);
    }

    public static File b() {
        return f31442b;
    }
}
