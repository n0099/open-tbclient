package com.ksad.download;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f32407a;

    /* renamed from: b  reason: collision with root package name */
    public static File f32408b;

    /* renamed from: c  reason: collision with root package name */
    public static a f32409c;

    public static Context a() {
        return f32407a;
    }

    public static void a(Context context) {
        f32407a = context.getApplicationContext();
    }

    public static void a(a aVar) {
        f32409c = aVar;
    }

    public static void a(File file) {
        f32408b = file;
    }

    public static void a(String str) {
        f32409c.installApp(a(), str);
    }

    public static File b() {
        return f32408b;
    }
}
