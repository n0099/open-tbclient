package d.b.o0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64178a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64179b;

    /* renamed from: c  reason: collision with root package name */
    public String f64180c;

    /* renamed from: d  reason: collision with root package name */
    public String f64181d;

    /* renamed from: e  reason: collision with root package name */
    public String f64182e;

    /* renamed from: f  reason: collision with root package name */
    public int f64183f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.f64178a = z;
        this.f64179b = z2;
        this.f64180c = str;
        this.f64181d = str2;
        this.f64182e = str3;
        this.f64183f = i;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f64180c)) {
            return this.f64180c;
        }
        return new d.b.o0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64180c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f64178a + ", isSupport=" + this.f64179b + ", OAID='" + this.f64180c + "', EncodedOAID='" + a() + "', AAID='" + this.f64181d + "', VAID='" + this.f64182e + "', StatusCode='" + this.f64183f + "'}";
    }
}
