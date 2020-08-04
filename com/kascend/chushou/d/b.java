package com.kascend.chushou.d;

import android.app.Activity;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {
    private static WeakReference<Activity> a;

    public static String a() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.dOp() : "";
    }

    public static String b() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.aef() : "";
    }

    public static String c() {
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.b.b.class);
        return bVar != null ? bVar.getSdkVersion() : "";
    }

    public static String d() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.a.a.class);
        return aVar != null ? aVar.getString("token", "") : "";
    }

    public static void a(Activity activity) {
        a = new WeakReference<>(activity);
    }

    public static void b(Activity activity) {
        if (a != null) {
            a.clear();
        }
        a = null;
    }

    @Nullable
    public static Activity e() {
        if (a != null) {
            return a.get();
        }
        return null;
    }
}
