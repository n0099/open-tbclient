package d.a.l0.g.f;

import androidx.annotation.NonNull;
import d.a.l0.a.p.d.f1;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements f1 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f50754c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.g.d.b f50755a;

    /* renamed from: b  reason: collision with root package name */
    public b f50756b;

    public c() {
        c();
    }

    public static c b() {
        if (f50754c == null) {
            synchronized (c.class) {
                if (f50754c == null) {
                    f50754c = new c();
                }
            }
        }
        return f50754c;
    }

    @Override // d.a.l0.a.p.d.f1
    public d.a.l0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (this.f50755a.e(str)) {
            return this.f50755a.a(str, jSONObject, bVar);
        }
        if (this.f50755a.f()) {
            return this.f50756b.a(str, jSONObject, bVar);
        }
        return new d.a.l0.a.u.h.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f50755a = new d.a.l0.g.d.b();
        this.f50756b = new b();
    }
}
