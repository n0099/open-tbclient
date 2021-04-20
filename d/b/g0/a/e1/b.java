package d.b.g0.a.e1;

import android.text.TextUtils;
import d.b.g0.a.i2.i0;
import d.b.g0.a.t1.k.p0.j;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44754a;

    /* renamed from: b  reason: collision with root package name */
    public String f44755b;

    /* renamed from: c  reason: collision with root package name */
    public String f44756c;

    /* renamed from: d  reason: collision with root package name */
    public String f44757d;

    public static String a(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44754a)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44755b)) {
            return bVar.f44754a;
        }
        return bVar.f44754a + "?" + bVar.f44755b;
    }

    public static String b(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44757d)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f44755b)) {
            return bVar.f44757d;
        }
        return bVar.f44757d + "?" + bVar.f44755b;
    }

    public static b c(String str, String str2) {
        b bVar = new b();
        bVar.f44754a = i0.d(str);
        bVar.f44755b = i0.n(str);
        bVar.f44756c = str2;
        bVar.f44757d = j.b(bVar.f44754a);
        return bVar;
    }

    public String d() {
        return this.f44754a;
    }

    public String e() {
        return this.f44755b;
    }

    public String f() {
        return this.f44757d;
    }

    public void g(String str) {
        this.f44755b = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f44754a + "', mParams='" + this.f44755b + "', mBaseUrl='" + this.f44756c + "', mRoutePage='" + this.f44757d + "'}";
    }
}
