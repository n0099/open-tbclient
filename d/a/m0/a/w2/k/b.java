package d.a.m0.a.w2.k;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f49517a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f49518b;

    /* renamed from: c  reason: collision with root package name */
    public int f49519c;

    @NonNull
    public b a(int i2) {
        this.f49517a = i2 | this.f49517a;
        return this;
    }

    public int b() {
        return this.f49518b;
    }

    public int c() {
        return this.f49519c;
    }

    public boolean d() {
        return (this.f49517a & 1) == 1;
    }

    public void e(int i2) {
        this.f49517a = (~i2) & this.f49517a;
    }

    public void f(int i2) {
        this.f49518b = i2;
    }

    public void g(int i2) {
        this.f49519c = i2;
    }
}
