package d.a.h0.a.j2.i;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f43098a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f43099b;

    /* renamed from: c  reason: collision with root package name */
    public int f43100c;

    @NonNull
    public b a(int i2) {
        this.f43098a = i2 | this.f43098a;
        return this;
    }

    public int b() {
        return this.f43099b;
    }

    public int c() {
        return this.f43100c;
    }

    public boolean d() {
        return (this.f43098a & 1) == 1;
    }

    public void e(int i2) {
        this.f43098a = (~i2) & this.f43098a;
    }

    public void f(int i2) {
        this.f43099b = i2;
    }

    public void g(int i2) {
        this.f43100c = i2;
    }
}
