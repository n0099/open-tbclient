package d.a.l0.a.w2.k;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45735a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45736b;

    /* renamed from: c  reason: collision with root package name */
    public int f45737c;

    @NonNull
    public b a(int i2) {
        this.f45735a = i2 | this.f45735a;
        return this;
    }

    public int b() {
        return this.f45736b;
    }

    public int c() {
        return this.f45737c;
    }

    public boolean d() {
        return (this.f45735a & 1) == 1;
    }

    public void e(int i2) {
        this.f45735a = (~i2) & this.f45735a;
    }

    public void f(int i2) {
        this.f45736b = i2;
    }

    public void g(int i2) {
        this.f45737c = i2;
    }
}
