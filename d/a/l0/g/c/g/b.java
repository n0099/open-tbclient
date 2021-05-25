package d.a.l0.g.c.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f47054a;

    /* renamed from: b  reason: collision with root package name */
    public String f47055b;

    /* renamed from: c  reason: collision with root package name */
    public int f47056c;

    public b(String str, int i2, String str2) {
        this.f47054a = str;
        this.f47055b = str2;
        this.f47056c = i2;
    }

    public String a() {
        return this.f47054a;
    }

    public String b() {
        return this.f47055b;
    }

    public int c() {
        return this.f47056c;
    }

    public boolean d() {
        return TextUtils.equals(this.f47054a, "onSuccess");
    }
}
