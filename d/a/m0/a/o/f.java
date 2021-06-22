package d.a.m0.a.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public String f47652a;

    /* renamed from: b  reason: collision with root package name */
    public String f47653b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.f.i.p.b f47654c;

    /* renamed from: d  reason: collision with root package name */
    public c f47655d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.f.i.l.f f47656e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.m0.a.o.a> f47657f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.o.a f47658g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.a.o.a f47659h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f47660i;
    public d.a.m0.f.i.p.a j = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.f.i.p.a {
        public a() {
        }

        @Override // d.a.m0.f.i.p.a
        public void a(boolean z, String str) {
            if (z) {
                f.this.f47655d.b();
                f.this.f47658g.a(0);
                for (d.a.m0.a.o.a aVar : f.this.f47657f) {
                    aVar.a(0);
                    if (f.this.f47657f.contains(aVar)) {
                        f.this.f47657f.remove(aVar);
                    }
                }
                return;
            }
            f.this.f47658g.a(1001);
            for (d.a.m0.a.o.a aVar2 : f.this.f47657f) {
                aVar2.a(1001);
                if (f.this.f47657f.contains(aVar2)) {
                    f.this.f47657f.remove(aVar2);
                }
            }
        }

        @Override // d.a.m0.f.i.p.a
        public void b(boolean z, String str) {
            if (z) {
                f.this.f47659h.a(0);
            } else {
                f.this.f47659h.a(1001);
            }
        }

        @Override // d.a.m0.f.i.p.a
        public void c(boolean z, int i2) {
            f.this.f47655d.a(e.a(z));
        }

        @Override // d.a.m0.f.i.p.a
        public void onClick(int i2) {
        }

        @Override // d.a.m0.f.i.p.a
        public void onError(String str) {
            f.this.f47655d.c(e.b(str));
            d.a.m0.f.i.q.b.k(f.this.f47660i, str);
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.m0.a.o.a aVar) {
        this.f47652a = "";
        this.f47660i = new TreeMap();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f47652a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f47653b = optString;
            this.f47660i = d.a.m0.f.i.q.b.a("video", "app", optString, this.f47652a, false);
            this.f47656e = new g();
            d.a.m0.f.i.p.b bVar = new d.a.m0.f.i.p.b(d.a.m0.a.g1.f.V().getActivity(), this.f47653b, this.f47652a, false, this.j, this.f47656e);
            this.f47654c = bVar;
            bVar.k0(this.f47660i);
            this.f47657f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.m0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.m0.a.o.a aVar) {
        if (this.f47654c != null) {
            this.f47659h = aVar;
            this.f47654c.l0();
        }
    }

    @Override // d.a.m0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.m0.a.o.a aVar, c cVar) {
        this.f47655d = cVar;
        if (this.f47654c != null) {
            this.f47658g = aVar;
            if (aVar != null && !this.f47657f.contains(aVar)) {
                this.f47657f.add(aVar);
            }
            this.f47654c.e0();
        }
    }
}
