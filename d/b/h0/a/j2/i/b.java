package d.b.h0.a.j2.i;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f45769a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f45770b;

    /* renamed from: c  reason: collision with root package name */
    public int f45771c;

    @NonNull
    public b a(int i) {
        this.f45769a = i | this.f45769a;
        return this;
    }

    public int b() {
        return this.f45770b;
    }

    public int c() {
        return this.f45771c;
    }

    public boolean d() {
        return (this.f45769a & 1) == 1;
    }

    public void e(int i) {
        this.f45769a = (~i) & this.f45769a;
    }

    public void f(int i) {
        this.f45770b = i;
    }

    public void g(int i) {
        this.f45771c = i;
    }
}
