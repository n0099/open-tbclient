package d.a.l0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.v2.o0;
/* loaded from: classes3.dex */
public final class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f43357e;

    /* renamed from: f  reason: collision with root package name */
    public String f43358f;

    /* renamed from: g  reason: collision with root package name */
    public String f43359g;

    /* renamed from: h  reason: collision with root package name */
    public String f43360h;

    public static String c(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f43357e)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f43358f)) {
            return bVar.f43357e;
        }
        return bVar.f43357e + "?" + bVar.f43358f;
    }

    public static String d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f43360h)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f43358f)) {
            return bVar.f43360h;
        }
        return bVar.f43360h + "?" + bVar.f43358f;
    }

    public static b e(String str, String str2) {
        b bVar = new b();
        bVar.f43357e = o0.f(str);
        bVar.f43358f = o0.o(str);
        bVar.f43359g = str2;
        bVar.f43360h = j.b(bVar.f43357e);
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
        return this.f43357e;
    }

    public String g() {
        return this.f43358f;
    }

    public String h() {
        return this.f43360h;
    }

    public void i(String str) {
        this.f43358f = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f43357e + "', mParams='" + this.f43358f + "', mBaseUrl='" + this.f43359g + "', mRoutePage='" + this.f43360h + "'}";
    }
}
