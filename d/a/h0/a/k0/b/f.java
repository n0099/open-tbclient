package d.a.h0.a.k0.b;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final d.a.h0.a.t.e.b f43117b;

    public f(@NonNull String str, @NonNull d.a.h0.a.t.e.b bVar) {
        this.f43106a = str;
        this.f43117b = bVar;
    }

    @Override // d.a.h0.a.k0.b.a
    public String a(String str) {
        return d.a.h0.a.k0.a.d(str, "status", Integer.valueOf(this.f43117b.f44324b)) + d.a.h0.a.k0.a.f(str, "data", this.f43117b.f44326d) + d.a.h0.a.k0.a.e(str, "message", this.f43117b.f44325c);
    }
}
