package d.b.g0.a.s0.g.i;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45838a;

    /* renamed from: b  reason: collision with root package name */
    public long f45839b;

    /* renamed from: c  reason: collision with root package name */
    public String f45840c;

    /* renamed from: d  reason: collision with root package name */
    public String f45841d;

    /* renamed from: e  reason: collision with root package name */
    public String f45842e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f45838a = str;
        this.f45839b = j;
        this.f45840c = str2;
        this.f45841d = str3;
        this.f45842e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f45838a) || TextUtils.isEmpty(this.f45840c) || TextUtils.isEmpty(this.f45841d) || TextUtils.isEmpty(this.f45842e) || !d.b.g0.a.s0.g.g.a.a(this.f45839b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f45838a + ";localUserId=" + this.f45839b + ";displayName=" + this.f45840c + ";rtcAppId=" + this.f45841d + ";token=" + this.f45842e;
    }
}
