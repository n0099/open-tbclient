package d.a.m0.g.f;

import androidx.annotation.NonNull;
import d.a.m0.a.p.d.f1;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements f1 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f50862c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.g.d.b f50863a;

    /* renamed from: b  reason: collision with root package name */
    public b f50864b;

    public c() {
        c();
    }

    public static c b() {
        if (f50862c == null) {
            synchronized (c.class) {
                if (f50862c == null) {
                    f50862c = new c();
                }
            }
        }
        return f50862c;
    }

    @Override // d.a.m0.a.p.d.f1
    public d.a.m0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.m0.a.u0.b bVar) {
        if (this.f50863a.e(str)) {
            return this.f50863a.a(str, jSONObject, bVar);
        }
        if (this.f50863a.f()) {
            return this.f50864b.a(str, jSONObject, bVar);
        }
        return new d.a.m0.a.u.h.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f50863a = new d.a.m0.g.d.b();
        this.f50864b = new b();
    }
}
