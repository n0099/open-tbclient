package d.a.h0.a.e1;

import android.text.TextUtils;
import d.a.h0.a.i2.i0;
import d.a.h0.a.t1.k.p0.j;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f42392a;

    /* renamed from: b  reason: collision with root package name */
    public String f42393b;

    /* renamed from: c  reason: collision with root package name */
    public String f42394c;

    /* renamed from: d  reason: collision with root package name */
    public String f42395d;

    public static String a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f42392a)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f42393b)) {
            return bVar.f42392a;
        }
        return bVar.f42392a + "?" + bVar.f42393b;
    }

    public static String b(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f42395d)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f42393b)) {
            return bVar.f42395d;
        }
        return bVar.f42395d + "?" + bVar.f42393b;
    }

    public static b c(String str, String str2) {
        b bVar = new b();
        bVar.f42392a = i0.d(str);
        bVar.f42393b = i0.n(str);
        bVar.f42394c = str2;
        bVar.f42395d = j.b(bVar.f42392a);
        return bVar;
    }

    public String d() {
        return this.f42392a;
    }

    public String e() {
        return this.f42393b;
    }

    public String f() {
        return this.f42395d;
    }

    public void g(String str) {
        this.f42393b = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f42392a + "', mParams='" + this.f42393b + "', mBaseUrl='" + this.f42394c + "', mRoutePage='" + this.f42395d + "'}";
    }
}
