package d.a.h0.a.s0.g.i;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43927a;

    /* renamed from: b  reason: collision with root package name */
    public long f43928b;

    /* renamed from: c  reason: collision with root package name */
    public String f43929c;

    /* renamed from: d  reason: collision with root package name */
    public String f43930d;

    /* renamed from: e  reason: collision with root package name */
    public String f43931e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f43927a = str;
        this.f43928b = j;
        this.f43929c = str2;
        this.f43930d = str3;
        this.f43931e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f43927a) || TextUtils.isEmpty(this.f43929c) || TextUtils.isEmpty(this.f43930d) || TextUtils.isEmpty(this.f43931e) || !d.a.h0.a.s0.g.g.a.a(this.f43928b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f43927a + ";localUserId=" + this.f43928b + ";displayName=" + this.f43929c + ";rtcAppId=" + this.f43930d + ";token=" + this.f43931e;
    }
}
