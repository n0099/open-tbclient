package d.b.g0.a.k0.b;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.a.t.e.b f45459b;

    public f(@NonNull String str, @NonNull d.b.g0.a.t.e.b bVar) {
        this.f45448a = str;
        this.f45459b = bVar;
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        return d.b.g0.a.k0.a.d(str, "status", Integer.valueOf(this.f45459b.f46607b)) + d.b.g0.a.k0.a.f(str, "data", this.f45459b.f46609d) + d.b.g0.a.k0.a.e(str, "message", this.f45459b.f46608c);
    }
}
