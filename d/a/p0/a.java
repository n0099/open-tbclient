package d.a.p0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f63469a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63470b;

    /* renamed from: c  reason: collision with root package name */
    public String f63471c;

    /* renamed from: d  reason: collision with root package name */
    public String f63472d;

    /* renamed from: e  reason: collision with root package name */
    public String f63473e;

    /* renamed from: f  reason: collision with root package name */
    public int f63474f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        this.f63469a = z;
        this.f63470b = z2;
        this.f63471c = str;
        this.f63472d = str2;
        this.f63473e = str3;
        this.f63474f = i2;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f63471c)) {
            return this.f63471c;
        }
        return new d.a.p0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f63471c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f63469a + ", isSupport=" + this.f63470b + ", OAID='" + this.f63471c + "', EncodedOAID='" + a() + "', AAID='" + this.f63472d + "', VAID='" + this.f63473e + "', StatusCode='" + this.f63474f + "'}";
    }
}
