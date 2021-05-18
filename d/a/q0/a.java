package d.a.q0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64466a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64467b;

    /* renamed from: c  reason: collision with root package name */
    public String f64468c;

    /* renamed from: d  reason: collision with root package name */
    public String f64469d;

    /* renamed from: e  reason: collision with root package name */
    public String f64470e;

    /* renamed from: f  reason: collision with root package name */
    public int f64471f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        this.f64466a = z;
        this.f64467b = z2;
        this.f64468c = str;
        this.f64469d = str2;
        this.f64470e = str3;
        this.f64471f = i2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f64468c)) {
            return this.f64468c;
        }
        return new d.a.q0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64468c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f64466a + ", isSupport=" + this.f64467b + ", OAID='" + this.f64468c + "', EncodedOAID='" + a() + "', AAID='" + this.f64469d + "', VAID='" + this.f64470e + "', StatusCode='" + this.f64471f + "'}";
    }
}
