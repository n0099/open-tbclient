package d.b.o0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64891a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64892b;

    /* renamed from: c  reason: collision with root package name */
    public String f64893c;

    /* renamed from: d  reason: collision with root package name */
    public String f64894d;

    /* renamed from: e  reason: collision with root package name */
    public String f64895e;

    /* renamed from: f  reason: collision with root package name */
    public int f64896f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.f64891a = z;
        this.f64892b = z2;
        this.f64893c = str;
        this.f64894d = str2;
        this.f64895e = str3;
        this.f64896f = i;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f64893c)) {
            return this.f64893c;
        }
        return new d.b.o0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64893c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f64891a + ", isSupport=" + this.f64892b + ", OAID='" + this.f64893c + "', EncodedOAID='" + a() + "', AAID='" + this.f64894d + "', VAID='" + this.f64895e + "', StatusCode='" + this.f64896f + "'}";
    }
}
