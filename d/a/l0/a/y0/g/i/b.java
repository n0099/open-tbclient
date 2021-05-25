package d.a.l0.a.y0.g.i;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45829a;

    /* renamed from: b  reason: collision with root package name */
    public long f45830b;

    /* renamed from: c  reason: collision with root package name */
    public String f45831c;

    /* renamed from: d  reason: collision with root package name */
    public String f45832d;

    /* renamed from: e  reason: collision with root package name */
    public String f45833e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f45829a = str;
        this.f45830b = j;
        this.f45831c = str2;
        this.f45832d = str3;
        this.f45833e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f45829a) || TextUtils.isEmpty(this.f45831c) || TextUtils.isEmpty(this.f45832d) || TextUtils.isEmpty(this.f45833e) || !d.a.l0.a.y0.g.g.a.a(this.f45830b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f45829a + ";localUserId=" + this.f45830b + ";displayName=" + this.f45831c + ";rtcAppId=" + this.f45832d + ";token=" + this.f45833e;
    }
}
