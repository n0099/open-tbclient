package d.b.h0.a.k0.b;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.h0.a.t.e.b f45788b;

    public f(@NonNull String str, @NonNull d.b.h0.a.t.e.b bVar) {
        this.f45777a = str;
        this.f45788b = bVar;
    }

    @Override // d.b.h0.a.k0.b.a
    public String a(String str) {
        return d.b.h0.a.k0.a.d(str, "status", Integer.valueOf(this.f45788b.f46936b)) + d.b.h0.a.k0.a.f(str, "data", this.f45788b.f46938d) + d.b.h0.a.k0.a.e(str, "message", this.f45788b.f46937c);
    }
}
