package d.a.i0.a.y0.g.i;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45653a;

    /* renamed from: b  reason: collision with root package name */
    public long f45654b;

    /* renamed from: c  reason: collision with root package name */
    public String f45655c;

    /* renamed from: d  reason: collision with root package name */
    public String f45656d;

    /* renamed from: e  reason: collision with root package name */
    public String f45657e;

    public b(String str, long j, String str2, String str3, String str4) {
        this.f45653a = str;
        this.f45654b = j;
        this.f45655c = str2;
        this.f45656d = str3;
        this.f45657e = str4;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f45653a) || TextUtils.isEmpty(this.f45655c) || TextUtils.isEmpty(this.f45656d) || TextUtils.isEmpty(this.f45657e) || !d.a.i0.a.y0.g.g.a.a(this.f45654b)) ? false : true;
    }

    public String toString() {
        return "roomName=" + this.f45653a + ";localUserId=" + this.f45654b + ";displayName=" + this.f45655c + ";rtcAppId=" + this.f45656d + ";token=" + this.f45657e;
    }
}
