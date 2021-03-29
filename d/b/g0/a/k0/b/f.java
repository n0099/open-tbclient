package d.b.g0.a.k0.b;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.a.t.e.b f45067b;

    public f(@NonNull String str, @NonNull d.b.g0.a.t.e.b bVar) {
        this.f45056a = str;
        this.f45067b = bVar;
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        return d.b.g0.a.k0.a.d(str, "status", Integer.valueOf(this.f45067b.f46215b)) + d.b.g0.a.k0.a.f(str, "data", this.f45067b.f46217d) + d.b.g0.a.k0.a.e(str, "message", this.f45067b.f46216c);
    }
}
