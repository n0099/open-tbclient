package d.b.g0.a.j2.i;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45047a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45048b;

    /* renamed from: c  reason: collision with root package name */
    public int f45049c;

    @NonNull
    public b a(int i) {
        this.f45047a = i | this.f45047a;
        return this;
    }

    public int b() {
        return this.f45048b;
    }

    public int c() {
        return this.f45049c;
    }

    public boolean d() {
        return (this.f45047a & 1) == 1;
    }

    public void e(int i) {
        this.f45047a = (i ^ (-1)) & this.f45047a;
    }

    public void f(int i) {
        this.f45048b = i;
    }

    public void g(int i) {
        this.f45049c = i;
    }
}
