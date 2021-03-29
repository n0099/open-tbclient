package d.b.g0.a.s0.g.i;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45839a;

    /* renamed from: b  reason: collision with root package name */
    public long f45840b;

    /* renamed from: c  reason: collision with root package name */
    public String f45841c;

    /* renamed from: d  reason: collision with root package name */
    public String f45842d;

    /* renamed from: e  reason: collision with root package name */
    public String f45843e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f45839a = str;
        this.f45840b = j;
        this.f45841c = str2;
        this.f45842d = str3;
        this.f45843e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f45839a) || TextUtils.isEmpty(this.f45841c) || TextUtils.isEmpty(this.f45842d) || TextUtils.isEmpty(this.f45843e) || !d.b.g0.a.s0.g.g.a.a(this.f45840b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f45839a + ";localUserId=" + this.f45840b + ";displayName=" + this.f45841c + ";rtcAppId=" + this.f45842d + ";token=" + this.f45843e;
    }
}
