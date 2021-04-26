package d.a.h0.f.i;

import androidx.annotation.NonNull;
import d.a.h0.a.p.c.w0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements w0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46030c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.f.g.b f46031a;

    /* renamed from: b  reason: collision with root package name */
    public b f46032b;

    public c() {
        c();
    }

    public static c b() {
        if (f46030c == null) {
            synchronized (c.class) {
                if (f46030c == null) {
                    f46030c = new c();
                }
            }
        }
        return f46030c;
    }

    @Override // d.a.h0.a.p.c.w0
    public d.a.h0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        if (this.f46031a.e(str)) {
            return this.f46031a.a(str, jSONObject, bVar);
        }
        if (this.f46031a.f()) {
            return this.f46032b.a(str, jSONObject, bVar);
        }
        return new d.a.h0.a.t.e.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f46031a = new d.a.h0.f.g.b();
        this.f46032b = new b();
    }
}
