package d.a.i0.g.c.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f46878a;

    /* renamed from: b  reason: collision with root package name */
    public String f46879b;

    /* renamed from: c  reason: collision with root package name */
    public int f46880c;

    public b(String str, int i2, String str2) {
        this.f46878a = str;
        this.f46879b = str2;
        this.f46880c = i2;
    }

    public String a() {
        return this.f46878a;
    }

    public String b() {
        return this.f46879b;
    }

    public int c() {
        return this.f46880c;
    }

    public boolean d() {
        return TextUtils.equals(this.f46878a, "onSuccess");
    }
}
