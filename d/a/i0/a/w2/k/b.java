package d.a.i0.a.w2.k;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45559a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45560b;

    /* renamed from: c  reason: collision with root package name */
    public int f45561c;

    @NonNull
    public b a(int i2) {
        this.f45559a = i2 | this.f45559a;
        return this;
    }

    public int b() {
        return this.f45560b;
    }

    public int c() {
        return this.f45561c;
    }

    public boolean d() {
        return (this.f45559a & 1) == 1;
    }

    public void e(int i2) {
        this.f45559a = (~i2) & this.f45559a;
    }

    public void f(int i2) {
        this.f45560b = i2;
    }

    public void g(int i2) {
        this.f45561c = i2;
    }
}
