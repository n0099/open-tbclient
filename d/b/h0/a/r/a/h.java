package d.b.h0.a.r.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f46420a = new h();

    public final void a(int i, JSONObject jSONObject) {
        if (i == 0) {
            c(jSONObject);
        }
    }

    public final void b() {
        d.b.h0.a.a2.g.h.a().putString("alliance_login_uk", "");
    }

    public final void c(JSONObject jSONObject) {
        d.b.h0.a.a2.g.h.a().putString("alliance_login_uk", jSONObject.optString("uk"));
    }
}
