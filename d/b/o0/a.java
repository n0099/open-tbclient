package d.b.o0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64177a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64178b;

    /* renamed from: c  reason: collision with root package name */
    public String f64179c;

    /* renamed from: d  reason: collision with root package name */
    public String f64180d;

    /* renamed from: e  reason: collision with root package name */
    public String f64181e;

    /* renamed from: f  reason: collision with root package name */
    public int f64182f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.f64177a = z;
        this.f64178b = z2;
        this.f64179c = str;
        this.f64180d = str2;
        this.f64181e = str3;
        this.f64182f = i;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f64179c)) {
            return this.f64179c;
        }
        return new d.b.o0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64179c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f64177a + ", isSupport=" + this.f64178b + ", OAID='" + this.f64179c + "', EncodedOAID='" + a() + "', AAID='" + this.f64180d + "', VAID='" + this.f64181e + "', StatusCode='" + this.f64182f + "'}";
    }
}
