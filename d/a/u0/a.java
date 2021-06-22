package d.a.u0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68467a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68468b;

    /* renamed from: c  reason: collision with root package name */
    public String f68469c;

    /* renamed from: d  reason: collision with root package name */
    public String f68470d;

    /* renamed from: e  reason: collision with root package name */
    public String f68471e;

    /* renamed from: f  reason: collision with root package name */
    public int f68472f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        this.f68467a = z;
        this.f68468b = z2;
        this.f68469c = str;
        this.f68470d = str2;
        this.f68471e = str3;
        this.f68472f = i2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f68469c)) {
            return this.f68469c;
        }
        return new d.a.u0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f68469c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f68467a + ", isSupport=" + this.f68468b + ", OAID='" + this.f68469c + "', EncodedOAID='" + a() + "', AAID='" + this.f68470d + "', VAID='" + this.f68471e + "', StatusCode='" + this.f68472f + "'}";
    }
}
