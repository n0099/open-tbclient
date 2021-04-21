package d.b.h0.f.i;

import androidx.annotation.NonNull;
import d.b.h0.a.p.c.w0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements w0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f48569c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.f.g.b f48570a;

    /* renamed from: b  reason: collision with root package name */
    public b f48571b;

    public c() {
        c();
    }

    public static c b() {
        if (f48569c == null) {
            synchronized (c.class) {
                if (f48569c == null) {
                    f48569c = new c();
                }
            }
        }
        return f48569c;
    }

    @Override // d.b.h0.a.p.c.w0
    public d.b.h0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.b.h0.a.p0.b bVar) {
        if (this.f48570a.e(str)) {
            return this.f48570a.a(str, jSONObject, bVar);
        }
        if (this.f48570a.f()) {
            return this.f48571b.a(str, jSONObject, bVar);
        }
        return new d.b.h0.a.t.e.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f48570a = new d.b.h0.f.g.b();
        this.f48571b = new b();
    }
}
