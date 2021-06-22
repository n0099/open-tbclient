package d.a.m0.a.o0.d;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.m0.a.u.h.b f47706c;

    public f(@NonNull String str, @NonNull d.a.m0.a.u.h.b bVar) {
        this.f47689a = str;
        this.f47706c = bVar;
    }

    @Override // d.a.m0.a.o0.d.a
    public String f(String str) {
        return d.a.m0.a.o0.a.b(str, "status", Integer.valueOf(this.f47706c.f49020b)) + d.a.m0.a.o0.a.d(str, "data", this.f47706c.f49022d) + d.a.m0.a.o0.a.c(str, "message", this.f47706c.f49021c);
    }
}
