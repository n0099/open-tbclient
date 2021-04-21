package d.b.h0.a.l1.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.h0.a.l1.c.d.e;
import d.b.h0.a.t.b.d;
import d.b.h0.l.k.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.h0.a.l1.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0761a implements d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> {
        public C0761a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.e0.n.b
        /* renamed from: b */
        public void a(d.b.h0.a.l1.c.c.a aVar) {
            a.this.v(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.e0.n.b
        /* renamed from: b */
        public void a(d.b.h0.a.l1.c.c.a aVar) {
            a.this.v(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.e0.n.b
        /* renamed from: b */
        public void a(d.b.h0.a.l1.c.c.a aVar) {
            a.this.v(aVar);
        }
    }

    public a(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.h0.a.t.e.b r(String str) {
        d.b.h0.a.l1.c.b.b u = u(str);
        if (u.b()) {
            d.b.h0.a.l1.d.a.a(u.toString());
            return u.i;
        }
        return new d.b.h0.a.l1.c.d.c().k(u, new b());
    }

    public d.b.h0.a.t.e.b s(String str) {
        d.b.h0.a.l1.c.b.b u = u(str);
        if (u.b()) {
            d.b.h0.a.l1.d.a.a(u.toString());
            return u.i;
        }
        return new e().k(u, new C0761a());
    }

    public d.b.h0.a.t.e.b t(String str) {
        d.b.h0.a.l1.c.b.b u = u(str);
        if (u.b()) {
            d.b.h0.a.l1.d.a.a(u.toString());
            return u.i;
        }
        return new d.b.h0.a.l1.c.d.d().k(u, new c());
    }

    public final d.b.h0.a.l1.c.b.b u(String str) {
        d.b.h0.a.l1.c.b.b bVar = new d.b.h0.a.l1.c.b.b();
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-Base", str);
        bVar.i = (d.b.h0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.i = new d.b.h0.a.t.e.b(201, "pluginProvider is empty");
            return bVar;
        }
        h f2 = d.b.h0.a.l1.g.b.f(optString);
        if (f2 != null) {
            String str2 = f2.r;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.i = new d.b.h0.a.t.e.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.i = new d.b.h0.a.t.e.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.i = new d.b.h0.a.t.e.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.f45908a = str2;
                bVar.f45909b = optString;
                bVar.f45910c = optString2;
                bVar.f45911d = str3;
                bVar.f45912e = optString3;
                bVar.f45913f = optString4;
                bVar.f45914g = optJSONObject;
                bVar.f45915h = optString6;
                return bVar;
            }
        }
        bVar.i = new d.b.h0.a.t.e.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }

    public final void v(d.b.h0.a.l1.c.c.a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }
}
