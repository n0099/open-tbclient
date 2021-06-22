package d.a.m0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.v2.o0;
/* loaded from: classes3.dex */
public final class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f47141e;

    /* renamed from: f  reason: collision with root package name */
    public String f47142f;

    /* renamed from: g  reason: collision with root package name */
    public String f47143g;

    /* renamed from: h  reason: collision with root package name */
    public String f47144h;

    public static String c(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f47141e)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f47142f)) {
            return bVar.f47141e;
        }
        return bVar.f47141e + "?" + bVar.f47142f;
    }

    public static String d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f47144h)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f47142f)) {
            return bVar.f47144h;
        }
        return bVar.f47144h + "?" + bVar.f47142f;
    }

    public static b e(String str, String str2) {
        b bVar = new b();
        bVar.f47141e = o0.f(str);
        bVar.f47142f = o0.o(str);
        bVar.f47143g = str2;
        bVar.f47144h = j.b(bVar.f47141e);
        return bVar;
    }

    @Nullable
    public String b() {
        return c(this);
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String f() {
        return this.f47141e;
    }

    public String g() {
        return this.f47142f;
    }

    public String h() {
        return this.f47144h;
    }

    public void i(String str) {
        this.f47142f = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f47141e + "', mParams='" + this.f47142f + "', mBaseUrl='" + this.f47143g + "', mRoutePage='" + this.f47144h + "'}";
    }
}
