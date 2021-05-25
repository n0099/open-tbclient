package d.a.l0.a.o0.d;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.l0.a.u.h.b f43922c;

    public f(@NonNull String str, @NonNull d.a.l0.a.u.h.b bVar) {
        this.f43905a = str;
        this.f43922c = bVar;
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        return d.a.l0.a.o0.a.b(str, "status", Integer.valueOf(this.f43922c.f45238b)) + d.a.l0.a.o0.a.d(str, "data", this.f43922c.f45240d) + d.a.l0.a.o0.a.c(str, "message", this.f43922c.f45239c);
    }
}
