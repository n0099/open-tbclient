package d.a.m0.a.y0.g.i;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f49611a;

    /* renamed from: b  reason: collision with root package name */
    public long f49612b;

    /* renamed from: c  reason: collision with root package name */
    public String f49613c;

    /* renamed from: d  reason: collision with root package name */
    public String f49614d;

    /* renamed from: e  reason: collision with root package name */
    public String f49615e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f49611a = str;
        this.f49612b = j;
        this.f49613c = str2;
        this.f49614d = str3;
        this.f49615e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f49611a) || TextUtils.isEmpty(this.f49613c) || TextUtils.isEmpty(this.f49614d) || TextUtils.isEmpty(this.f49615e) || !d.a.m0.a.y0.g.g.a.a(this.f49612b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f49611a + ";localUserId=" + this.f49612b + ";displayName=" + this.f49613c + ";rtcAppId=" + this.f49614d + ";token=" + this.f49615e;
    }
}
