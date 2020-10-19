package com.kascend.chushou.d;

import android.app.Activity;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<Activity> f4082a;

    public static String a() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.eij() : "";
    }

    public static String b() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.aok() : "";
    }

    public static String c() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.getSdkVersion() : "";
    }

    public static String d() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.a.a.class);
        return aVar != null ? aVar.getString("token", "") : "";
    }

    public static void a(Activity activity) {
        f4082a = new WeakReference<>(activity);
    }

    public static void b(Activity activity) {
        if (f4082a != null) {
            f4082a.clear();
        }
        f4082a = null;
    }

    @Nullable
    public static Activity egf() {
        if (f4082a != null) {
            return f4082a.get();
        }
        return null;
    }
}
