package d.a.l0.a.u.e.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44836d = k.f43199a;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44837e;

        public a(String str) {
            this.f44837e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            d.a.l0.a.u.h.b bVar = new d.a.l0.a.u.h.b();
            String t = d.this.t(iVar);
            if (TextUtils.isEmpty(t)) {
                bVar.f45238b = 1001;
                bVar.f45239c = "openid is empty";
                d.this.d(this.f44837e, bVar);
                return;
            }
            bVar.d("openid", t);
            bVar.f45238b = 0;
            d.this.d(this.f44837e, bVar);
        }
    }

    public d(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (f44836d) {
            Log.d("Api-GetOpenId", "start getOpenId action, params = " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-GetOpenId", str);
        if (!((d.a.l0.a.u.h.b) b2.first).a()) {
            d.a.l0.a.e0.d.b("Api-GetOpenId", "parse failed, params = " + str);
            return (d.a.l0.a.u.h.b) b2.first;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (f44836d) {
            Log.d("Api-GetOpenId", "cb: " + optString);
        }
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(202, "cb is required");
        }
        d.a.l0.a.e2.c.j.d f2 = d.a.l0.a.a2.d.g().y().a().b().f(d.a.l0.a.a2.d.g());
        f2.p(new a(optString));
        f2.a();
        return new d.a.l0.a.u.h.b(0);
    }

    public final String t(i<JSONObject> iVar) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        return (!iVar.c() || (jSONObject = iVar.f41736a) == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? "" : optJSONObject.optString("openid");
    }
}
