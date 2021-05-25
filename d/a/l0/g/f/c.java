package d.a.l0.g.f;

import androidx.annotation.NonNull;
import d.a.l0.a.p.d.f1;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements f1 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f47080c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.g.d.b f47081a;

    /* renamed from: b  reason: collision with root package name */
    public b f47082b;

    public c() {
        c();
    }

    public static c b() {
        if (f47080c == null) {
            synchronized (c.class) {
                if (f47080c == null) {
                    f47080c = new c();
                }
            }
        }
        return f47080c;
    }

    @Override // d.a.l0.a.p.d.f1
    public d.a.l0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (this.f47081a.e(str)) {
            return this.f47081a.a(str, jSONObject, bVar);
        }
        if (this.f47081a.f()) {
            return this.f47082b.a(str, jSONObject, bVar);
        }
        return new d.a.l0.a.u.h.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f47081a = new d.a.l0.g.d.b();
        this.f47082b = new b();
    }
}
