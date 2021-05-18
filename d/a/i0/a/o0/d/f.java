package d.a.i0.a.o0.d;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.i0.a.u.h.b f43748c;

    public f(@NonNull String str, @NonNull d.a.i0.a.u.h.b bVar) {
        this.f43731a = str;
        this.f43748c = bVar;
    }

    @Override // d.a.i0.a.o0.d.a
    public String f(String str) {
        return d.a.i0.a.o0.a.b(str, "status", Integer.valueOf(this.f43748c.f45062b)) + d.a.i0.a.o0.a.d(str, "data", this.f43748c.f45064d) + d.a.i0.a.o0.a.c(str, "message", this.f43748c.f45063c);
    }
}
