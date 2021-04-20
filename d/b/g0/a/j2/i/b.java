package d.b.g0.a.j2.i;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45440a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45441b;

    /* renamed from: c  reason: collision with root package name */
    public int f45442c;

    @NonNull
    public b a(int i) {
        this.f45440a = i | this.f45440a;
        return this;
    }

    public int b() {
        return this.f45441b;
    }

    public int c() {
        return this.f45442c;
    }

    public boolean d() {
        return (this.f45440a & 1) == 1;
    }

    public void e(int i) {
        this.f45440a = (~i) & this.f45440a;
    }

    public void f(int i) {
        this.f45441b = i;
    }

    public void g(int i) {
        this.f45442c = i;
    }
}
