package d.b.g0.a.e1;

import android.text.TextUtils;
import d.b.g0.a.i2.i0;
import d.b.g0.a.t1.k.p0.j;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44362a;

    /* renamed from: b  reason: collision with root package name */
    public String f44363b;

    /* renamed from: c  reason: collision with root package name */
    public String f44364c;

    /* renamed from: d  reason: collision with root package name */
    public String f44365d;

    public static String a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44362a)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44363b)) {
            return bVar.f44362a;
        }
        return bVar.f44362a + "?" + bVar.f44363b;
    }

    public static String b(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44365d)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44363b)) {
            return bVar.f44365d;
        }
        return bVar.f44365d + "?" + bVar.f44363b;
    }

    public static b c(String str, String str2) {
        b bVar = new b();
        bVar.f44362a = i0.d(str);
        bVar.f44363b = i0.n(str);
        bVar.f44364c = str2;
        bVar.f44365d = j.b(bVar.f44362a);
        return bVar;
    }

    public String d() {
        return this.f44362a;
    }

    public String e() {
        return this.f44363b;
    }

    public String f() {
        return this.f44365d;
    }

    public void g(String str) {
        this.f44363b = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f44362a + "', mParams='" + this.f44363b + "', mBaseUrl='" + this.f44364c + "', mRoutePage='" + this.f44365d + "'}";
    }
}
