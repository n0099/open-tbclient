package d.a.m0.a.u.e.o;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48947e;

        public a(String str) {
            this.f48947e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                boolean a2 = d.a.m0.u.d.c.a(h.this.i(), "android.permission.READ_CONTACTS");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isAuthorized", a2);
                    h.this.d(this.f48947e, new d.a.m0.a.u.h.b(0, jSONObject));
                    h.this.u(a2);
                    return;
                } catch (JSONException e2) {
                    if (d.a.m0.a.u.c.d.f48594c) {
                        e2.printStackTrace();
                    }
                    h.this.d(this.f48947e, new d.a.m0.a.u.h.b(1001));
                    return;
                }
            }
            int b2 = iVar.b();
            h.this.d(this.f48947e, new d.a.m0.a.u.h.b(b2, d.a.m0.a.e2.c.d.f(b2)));
        }
    }

    public h(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b t(String str) {
        Object obj;
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-Base", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (bVar.isSuccess() && (obj = b2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.m0.a.u.h.b(201, "cb is empty");
            }
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.m0.a.u.h.b(201);
            }
            Q.T().g(i(), "scope_phone_contact_authorize", new a(optString));
            return new d.a.m0.a.u.h.b(0);
        }
        d.a.m0.a.e0.d.b("Api-Base", "parse fail");
        return bVar;
    }

    public final void u(boolean z) {
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46973e = String.valueOf(z);
        fVar.a("appid", d.a.m0.a.a2.d.g().getAppId());
        fVar.a("appname", d.a.m0.a.a2.d.g().r().O());
        d.a.m0.a.j2.k.u("1717", fVar);
    }
}
