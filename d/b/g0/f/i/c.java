package d.b.g0.f.i;

import androidx.annotation.NonNull;
import d.b.g0.a.p.c.w0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements w0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f48240c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.f.g.b f48241a;

    /* renamed from: b  reason: collision with root package name */
    public b f48242b;

    public c() {
        c();
    }

    public static c b() {
        if (f48240c == null) {
            synchronized (c.class) {
                if (f48240c == null) {
                    f48240c = new c();
                }
            }
        }
        return f48240c;
    }

    @Override // d.b.g0.a.p.c.w0
    public d.b.g0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (this.f48241a.e(str)) {
            return this.f48241a.a(str, jSONObject, bVar);
        }
        if (this.f48241a.f()) {
            return this.f48242b.a(str, jSONObject, bVar);
        }
        return new d.b.g0.a.t.e.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f48241a = new d.b.g0.f.g.b();
        this.f48242b = new b();
    }
}
