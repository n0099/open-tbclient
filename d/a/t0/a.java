package d.a.t0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68363a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68364b;

    /* renamed from: c  reason: collision with root package name */
    public String f68365c;

    /* renamed from: d  reason: collision with root package name */
    public String f68366d;

    /* renamed from: e  reason: collision with root package name */
    public String f68367e;

    /* renamed from: f  reason: collision with root package name */
    public int f68368f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        this.f68363a = z;
        this.f68364b = z2;
        this.f68365c = str;
        this.f68366d = str2;
        this.f68367e = str3;
        this.f68368f = i2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f68365c)) {
            return this.f68365c;
        }
        return new d.a.t0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f68365c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f68363a + ", isSupport=" + this.f68364b + ", OAID='" + this.f68365c + "', EncodedOAID='" + a() + "', AAID='" + this.f68366d + "', VAID='" + this.f68367e + "', StatusCode='" + this.f68368f + "'}";
    }
}
