package d.a.t0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64645a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64646b;

    /* renamed from: c  reason: collision with root package name */
    public String f64647c;

    /* renamed from: d  reason: collision with root package name */
    public String f64648d;

    /* renamed from: e  reason: collision with root package name */
    public String f64649e;

    /* renamed from: f  reason: collision with root package name */
    public int f64650f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        this.f64645a = z;
        this.f64646b = z2;
        this.f64647c = str;
        this.f64648d = str2;
        this.f64649e = str3;
        this.f64650f = i2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f64647c)) {
            return this.f64647c;
        }
        return new d.a.t0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64647c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f64645a + ", isSupport=" + this.f64646b + ", OAID='" + this.f64647c + "', EncodedOAID='" + a() + "', AAID='" + this.f64648d + "', VAID='" + this.f64649e + "', StatusCode='" + this.f64650f + "'}";
    }
}
