package d.a.m0.g.c.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f50836a;

    /* renamed from: b  reason: collision with root package name */
    public String f50837b;

    /* renamed from: c  reason: collision with root package name */
    public int f50838c;

    public b(String str, int i2, String str2) {
        this.f50836a = str;
        this.f50837b = str2;
        this.f50838c = i2;
    }

    public String a() {
        return this.f50836a;
    }

    public String b() {
        return this.f50837b;
    }

    public int c() {
        return this.f50838c;
    }

    public boolean d() {
        return TextUtils.equals(this.f50836a, "onSuccess");
    }
}
