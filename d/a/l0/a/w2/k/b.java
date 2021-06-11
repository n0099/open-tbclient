package d.a.l0.a.w2.k;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f49409a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f49410b;

    /* renamed from: c  reason: collision with root package name */
    public int f49411c;

    @NonNull
    public b a(int i2) {
        this.f49409a = i2 | this.f49409a;
        return this;
    }

    public int b() {
        return this.f49410b;
    }

    public int c() {
        return this.f49411c;
    }

    public boolean d() {
        return (this.f49409a & 1) == 1;
    }

    public void e(int i2) {
        this.f49409a = (~i2) & this.f49409a;
    }

    public void f(int i2) {
        this.f49410b = i2;
    }

    public void g(int i2) {
        this.f49411c = i2;
    }
}
