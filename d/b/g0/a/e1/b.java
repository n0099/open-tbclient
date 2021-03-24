package d.b.g0.a.e1;

import android.text.TextUtils;
import d.b.g0.a.i2.i0;
import d.b.g0.a.t1.k.p0.j;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44361a;

    /* renamed from: b  reason: collision with root package name */
    public String f44362b;

    /* renamed from: c  reason: collision with root package name */
    public String f44363c;

    /* renamed from: d  reason: collision with root package name */
    public String f44364d;

    public static String a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44361a)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44362b)) {
            return bVar.f44361a;
        }
        return bVar.f44361a + "?" + bVar.f44362b;
    }

    public static String b(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44364d)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44362b)) {
            return bVar.f44364d;
        }
        return bVar.f44364d + "?" + bVar.f44362b;
    }

    public static b c(String str, String str2) {
        b bVar = new b();
        bVar.f44361a = i0.d(str);
        bVar.f44362b = i0.n(str);
        bVar.f44363c = str2;
        bVar.f44364d = j.b(bVar.f44361a);
        return bVar;
    }

    public String d() {
        return this.f44361a;
    }

    public String e() {
        return this.f44362b;
    }

    public String f() {
        return this.f44364d;
    }

    public void g(String str) {
        this.f44362b = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f44361a + "', mParams='" + this.f44362b + "', mBaseUrl='" + this.f44363c + "', mRoutePage='" + this.f44364d + "'}";
    }
}
