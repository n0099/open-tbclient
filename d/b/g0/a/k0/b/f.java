package d.b.g0.a.k0.b;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.a.t.e.b f45066b;

    public f(@NonNull String str, @NonNull d.b.g0.a.t.e.b bVar) {
        this.f45055a = str;
        this.f45066b = bVar;
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        return d.b.g0.a.k0.a.d(str, "status", Integer.valueOf(this.f45066b.f46214b)) + d.b.g0.a.k0.a.f(str, "data", this.f45066b.f46216d) + d.b.g0.a.k0.a.e(str, "message", this.f45066b.f46215c);
    }
}
