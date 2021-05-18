package d.a.i0.g.f;

import androidx.annotation.NonNull;
import d.a.i0.a.p.d.f1;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements f1 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46904c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.g.d.b f46905a;

    /* renamed from: b  reason: collision with root package name */
    public b f46906b;

    public c() {
        c();
    }

    public static c b() {
        if (f46904c == null) {
            synchronized (c.class) {
                if (f46904c == null) {
                    f46904c = new c();
                }
            }
        }
        return f46904c;
    }

    @Override // d.a.i0.a.p.d.f1
    public d.a.i0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.i0.a.u0.b bVar) {
        if (this.f46905a.e(str)) {
            return this.f46905a.a(str, jSONObject, bVar);
        }
        if (this.f46905a.f()) {
            return this.f46906b.a(str, jSONObject, bVar);
        }
        return new d.a.i0.a.u.h.b(10001, "authorize fail.");
    }

    public final void c() {
        this.f46905a = new d.a.i0.g.d.b();
        this.f46906b = new b();
    }
}
