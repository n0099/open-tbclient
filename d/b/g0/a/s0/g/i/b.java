package d.b.g0.a.s0.g.i;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f46231a;

    /* renamed from: b  reason: collision with root package name */
    public long f46232b;

    /* renamed from: c  reason: collision with root package name */
    public String f46233c;

    /* renamed from: d  reason: collision with root package name */
    public String f46234d;

    /* renamed from: e  reason: collision with root package name */
    public String f46235e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f46231a = str;
        this.f46232b = j;
        this.f46233c = str2;
        this.f46234d = str3;
        this.f46235e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f46231a) || TextUtils.isEmpty(this.f46233c) || TextUtils.isEmpty(this.f46234d) || TextUtils.isEmpty(this.f46235e) || !d.b.g0.a.s0.g.g.a.a(this.f46232b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f46231a + ";localUserId=" + this.f46232b + ";displayName=" + this.f46233c + ";rtcAppId=" + this.f46234d + ";token=" + this.f46235e;
    }
}
