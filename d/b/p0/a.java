package d.b.p0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65155a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65156b;

    /* renamed from: c  reason: collision with root package name */
    public String f65157c;

    /* renamed from: d  reason: collision with root package name */
    public String f65158d;

    /* renamed from: e  reason: collision with root package name */
    public String f65159e;

    /* renamed from: f  reason: collision with root package name */
    public int f65160f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.f65155a = z;
        this.f65156b = z2;
        this.f65157c = str;
        this.f65158d = str2;
        this.f65159e = str3;
        this.f65160f = i;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f65157c)) {
            return this.f65157c;
        }
        return new d.b.p0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f65157c.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.f65155a + ", isSupport=" + this.f65156b + ", OAID='" + this.f65157c + "', EncodedOAID='" + a() + "', AAID='" + this.f65158d + "', VAID='" + this.f65159e + "', StatusCode='" + this.f65160f + "'}";
    }
}
