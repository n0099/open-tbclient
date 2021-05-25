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
    public class C0826a implements d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> {
        public C0826a() {
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
            return v.f44760i;
        }
        return new d.a.l0.a.t1.c.d.c().l(v, new b());
    }

    public d.a.l0.a.u.h.b t(String str) {
        d.a.l0.a.t1.c.b.b v = v(str);
        if (v.b()) {
            d.a.l0.a.t1.d.a.a(v.toString());
            return v.f44760i;
        }
        return new e().l(v, new C0826a());
    }

    public d.a.l0.a.u.h.b u(String str) {
        d.a.l0.a.t1.c.b.b v = v(str);
        if (v.b()) {
            d.a.l0.a.t1.d.a.a(v.toString());
            return v.f44760i;
        }
        return new d.a.l0.a.t1.c.d.d().l(v, new c());
    }

    public final d.a.l0.a.t1.c.b.b v(String str) {
        d.a.l0.a.t1.c.b.b bVar = new d.a.l0.a.t1.c.b.b();
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        bVar.f44760i = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.f44760i = new d.a.l0.a.u.h.b(201, "pluginProvider is empty");
            return bVar;
        }
        h g2 = d.a.l0.a.t1.g.b.g(optString);
        if (g2 != null) {
            String str2 = g2.r;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.f44760i = new d.a.l0.a.u.h.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.f44760i = new d.a.l0.a.u.h.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.f44760i = new d.a.l0.a.u.h.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.f44752a = str2;
                bVar.f44753b = optString;
                bVar.f44754c = optString2;
                bVar.f44755d = str3;
                bVar.f44756e = optString3;
                bVar.f44757f = optString4;
                bVar.f44758g = optJSONObject;
                bVar.f44759h = optString6;
                return bVar;
            }
        }
        bVar.f44760i = new d.a.l0.a.u.h.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }

    public final void w(d.a.l0.a.t1.c.c.a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }
}
