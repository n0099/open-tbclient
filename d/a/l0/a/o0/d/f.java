package d.a.l0.a.o0.d;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.l0.a.u.h.b f47598c;

    public f(@NonNull String str, @NonNull d.a.l0.a.u.h.b bVar) {
        this.f47581a = str;
        this.f47598c = bVar;
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        return d.a.l0.a.o0.a.b(str, "status", Integer.valueOf(this.f47598c.f48912b)) + d.a.l0.a.o0.a.d(str, "data", this.f47598c.f48914d) + d.a.l0.a.o0.a.c(str, "message", this.f47598c.f48913c);
    }
}
