package d.a.l0.g.c.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f50728a;

    /* renamed from: b  reason: collision with root package name */
    public String f50729b;

    /* renamed from: c  reason: collision with root package name */
    public int f50730c;

    public b(String str, int i2, String str2) {
        this.f50728a = str;
        this.f50729b = str2;
        this.f50730c = i2;
    }

    public String a() {
        return this.f50728a;
    }

    public String b() {
        return this.f50729b;
    }

    public int c() {
        return this.f50730c;
    }

    public boolean d() {
        return TextUtils.equals(this.f50728a, "onSuccess");
    }
}
