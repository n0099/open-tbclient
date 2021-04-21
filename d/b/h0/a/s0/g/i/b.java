package d.b.h0.a.s0.g.i;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f46560a;

    /* renamed from: b  reason: collision with root package name */
    public long f46561b;

    /* renamed from: c  reason: collision with root package name */
    public String f46562c;

    /* renamed from: d  reason: collision with root package name */
    public String f46563d;

    /* renamed from: e  reason: collision with root package name */
    public String f46564e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f46560a = str;
        this.f46561b = j;
        this.f46562c = str2;
        this.f46563d = str3;
        this.f46564e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f46560a) || TextUtils.isEmpty(this.f46562c) || TextUtils.isEmpty(this.f46563d) || TextUtils.isEmpty(this.f46564e) || !d.b.h0.a.s0.g.g.a.a(this.f46561b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f46560a + ";localUserId=" + this.f46561b + ";displayName=" + this.f46562c + ";rtcAppId=" + this.f46563d + ";token=" + this.f46564e;
    }
}
