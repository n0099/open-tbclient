package d.b.h0.a.e1;

import android.text.TextUtils;
import d.b.h0.a.i2.i0;
import d.b.h0.a.t1.k.p0.j;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45083a;

    /* renamed from: b  reason: collision with root package name */
    public String f45084b;

    /* renamed from: c  reason: collision with root package name */
    public String f45085c;

    /* renamed from: d  reason: collision with root package name */
    public String f45086d;

    public static String a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f45083a)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f45084b)) {
            return bVar.f45083a;
        }
        return bVar.f45083a + "?" + bVar.f45084b;
    }

    public static String b(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f45086d)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f45084b)) {
            return bVar.f45086d;
        }
        return bVar.f45086d + "?" + bVar.f45084b;
    }

    public static b c(String str, String str2) {
        b bVar = new b();
        bVar.f45083a = i0.d(str);
        bVar.f45084b = i0.n(str);
        bVar.f45085c = str2;
        bVar.f45086d = j.b(bVar.f45083a);
        return bVar;
    }

    public String d() {
        return this.f45083a;
    }

    public String e() {
        return this.f45084b;
    }

    public String f() {
        return this.f45086d;
    }

    public void g(String str) {
        this.f45084b = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f45083a + "', mParams='" + this.f45084b + "', mBaseUrl='" + this.f45085c + "', mRoutePage='" + this.f45086d + "'}";
    }
}
