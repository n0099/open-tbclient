package d.a.i0.a.l1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.c2.f.p0.j;
import d.a.i0.a.v2.o0;
/* loaded from: classes3.dex */
public final class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f43183e;

    /* renamed from: f  reason: collision with root package name */
    public String f43184f;

    /* renamed from: g  reason: collision with root package name */
    public String f43185g;

    /* renamed from: h  reason: collision with root package name */
    public String f43186h;

    public static String c(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f43183e)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f43184f)) {
            return bVar.f43183e;
        }
        return bVar.f43183e + "?" + bVar.f43184f;
    }

    public static String d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f43186h)) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f43184f)) {
            return bVar.f43186h;
        }
        return bVar.f43186h + "?" + bVar.f43184f;
    }

    public static b e(String str, String str2) {
        b bVar = new b();
        bVar.f43183e = o0.f(str);
        bVar.f43184f = o0.o(str);
        bVar.f43185g = str2;
        bVar.f43186h = j.b(bVar.f43183e);
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
        return this.f43183e;
    }

    public String g() {
        return this.f43184f;
    }

    public String h() {
        return this.f43186h;
    }

    public void i(String str) {
        this.f43184f = str;
    }

    public String toString() {
        return "SwanAppPageParam{mPage='" + this.f43183e + "', mParams='" + this.f43184f + "', mBaseUrl='" + this.f43185g + "', mRoutePage='" + this.f43186h + "'}";
    }
}
