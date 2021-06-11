package d.a.l0.a.t1.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.t1.c.d.e;
import d.a.l0.a.u.c.d;
import d.a.l0.n.h.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.a.l0.a.t1.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0882a implements d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> {
        public C0882a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.l0.a.t1.c.c.a aVar) {
            a.this.w(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.l0.a.t1.c.c.a aVar) {
            a.this.w(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.l0.a.t1.c.c.a aVar) {
            a.this.w(aVar);
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b s(String str) {
        d.a.l0.a.t1.c.b.b v = v(str);
        if (v.b()) {
            d.a.l0.a.t1.d.a.a(v.toString());
            return v.f48434i;
        }
        return new d.a.l0.a.t1.c.d.c().l(v, new b());
    }

    public d.a.l0.a.u.h.b t(String str) {
        d.a.l0.a.t1.c.b.b v = v(str);
        if (v.b()) {
            d.a.l0.a.t1.d.a.a(v.toString());
            return v.f48434i;
        }
        return new e().l(v, new C0882a());
    }

    public d.a.l0.a.u.h.b u(String str) {
        d.a.l0.a.t1.c.b.b v = v(str);
        if (v.b()) {
            d.a.l0.a.t1.d.a.a(v.toString());
            return v.f48434i;
        }
        return new d.a.l0.a.t1.c.d.d().l(v, new c());
    }

    public final d.a.l0.a.t1.c.b.b v(String str) {
        d.a.l0.a.t1.c.b.b bVar = new d.a.l0.a.t1.c.b.b();
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        bVar.f48434i = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.f48434i = new d.a.l0.a.u.h.b(201, "pluginProvider is empty");
            return bVar;
        }
        h g2 = d.a.l0.a.t1.g.b.g(optString);
        if (g2 != null) {
            String str2 = g2.r;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.f48434i = new d.a.l0.a.u.h.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.f48434i = new d.a.l0.a.u.h.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.f48434i = new d.a.l0.a.u.h.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.f48426a = str2;
                bVar.f48427b = optString;
                bVar.f48428c = optString2;
                bVar.f48429d = str3;
                bVar.f48430e = optString3;
                bVar.f48431f = optString4;
                bVar.f48432g = optJSONObject;
                bVar.f48433h = optString6;
                return bVar;
            }
        }
        bVar.f48434i = new d.a.l0.a.u.h.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }

    public final void w(d.a.l0.a.t1.c.c.a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }
}
