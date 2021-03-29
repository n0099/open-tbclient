package d.b.g0.f.i;

import androidx.annotation.NonNull;
import d.b.g0.a.p.c.w0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements w0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f47848c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.f.g.b f47849a;

    /* renamed from: b  reason: collision with root package name */
    public b f47850b;

    public c() {
        c();
    }

    public static c b() {
        if (f47848c == null) {
            synchronized (c.class) {
                if (f47848c == null) {
                    f47848c = new c();
                }
            }
        }
        return f47848c;
    }

    @Override // d.b.g0.a.p.c.w0
    public d.b.g0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (this.f47849a.e(str)) {
            return this.f47849a.a(str, jSONObject, bVar);
        }
        if (this.f47849a.f()) {
            return this.f47850b.a(str, jSONObject, bVar);
        }
        return new d.b.g0.a.t.e.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f47849a = new d.b.g0.f.g.b();
        this.f47850b = new b();
    }
}
