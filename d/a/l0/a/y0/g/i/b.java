package d.a.l0.a.y0.g.i;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f49503a;

    /* renamed from: b  reason: collision with root package name */
    public long f49504b;

    /* renamed from: c  reason: collision with root package name */
    public String f49505c;

    /* renamed from: d  reason: collision with root package name */
    public String f49506d;

    /* renamed from: e  reason: collision with root package name */
    public String f49507e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f49503a = str;
        this.f49504b = j;
        this.f49505c = str2;
        this.f49506d = str3;
        this.f49507e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f49503a) || TextUtils.isEmpty(this.f49505c) || TextUtils.isEmpty(this.f49506d) || TextUtils.isEmpty(this.f49507e) || !d.a.l0.a.y0.g.g.a.a(this.f49504b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f49503a + ";localUserId=" + this.f49504b + ";displayName=" + this.f49505c + ";rtcAppId=" + this.f49506d + ";token=" + this.f49507e;
    }
}
