package d.a.l0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.v2.o0;
/* loaded from: classes3.dex */
public final class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f47033e;

    /* renamed from: f  reason: collision with root package name */
    public String f47034f;

    /* renamed from: g  reason: collision with root package name */
    public String f47035g;

    /* renamed from: h  reason: collision with root package name */
    public String f47036h;

    public static String c(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f47033e)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f47034f)) {
            return bVar.f47033e;
        }
        return bVar.f47033e + "?" + bVar.f47034f;
    }

    public static String d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f47036h)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f47034f)) {
            return bVar.f47036h;
        }
        return bVar.f47036h + "?" + bVar.f47034f;
    }

    public static b e(String str, String str2) {
        b bVar = new b();
        bVar.f47033e = o0.f(str);
        bVar.f47034f = o0.o(str);
        bVar.f47035g = str2;
        bVar.f47036h = j.b(bVar.f47033e);
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
        return this.f47033e;
    }

    public String g() {
        return this.f47034f;
    }

    public String h() {
        return this.f47036h;
    }

    public void i(String str) {
        this.f47034f = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f47033e + "', mParams='" + this.f47034f + "', mBaseUrl='" + this.f47035g + "', mRoutePage='" + this.f47036h + "'}";
    }
}
