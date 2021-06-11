package d.a.l0.a.o;

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
    public String f47544a;

    /* renamed from: b  reason: collision with root package name */
    public String f47545b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.i.p.b f47546c;

    /* renamed from: d  reason: collision with root package name */
    public c f47547d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.f.i.l.f f47548e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.l0.a.o.a> f47549f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.o.a f47550g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.o.a f47551h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f47552i;
    public d.a.l0.f.i.p.a j = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.f.i.p.a {
        public a() {
        }

        @Override // d.a.l0.f.i.p.a
        public void a(boolean z, String str) {
            if (z) {
                f.this.f47547d.b();
                f.this.f47550g.a(0);
                for (d.a.l0.a.o.a aVar : f.this.f47549f) {
                    aVar.a(0);
                    if (f.this.f47549f.contains(aVar)) {
                        f.this.f47549f.remove(aVar);
                    }
                }
                return;
            }
            f.this.f47550g.a(1001);
            for (d.a.l0.a.o.a aVar2 : f.this.f47549f) {
                aVar2.a(1001);
                if (f.this.f47549f.contains(aVar2)) {
                    f.this.f47549f.remove(aVar2);
                }
            }
        }

        @Override // d.a.l0.f.i.p.a
        public void b(boolean z, String str) {
            if (z) {
                f.this.f47551h.a(0);
            } else {
                f.this.f47551h.a(1001);
            }
        }

        @Override // d.a.l0.f.i.p.a
        public void c(boolean z, int i2) {
            f.this.f47547d.a(e.a(z));
        }

        @Override // d.a.l0.f.i.p.a
        public void onClick(int i2) {
        }

        @Override // d.a.l0.f.i.p.a
        public void onError(String str) {
            f.this.f47547d.c(e.b(str));
            d.a.l0.f.i.q.b.k(f.this.f47552i, str);
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.l0.a.o.a aVar) {
        this.f47544a = "";
        this.f47552i = new TreeMap();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f47544a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f47545b = optString;
            this.f47552i = d.a.l0.f.i.q.b.a("video", "app", optString, this.f47544a, false);
            this.f47548e = new g();
            d.a.l0.f.i.p.b bVar = new d.a.l0.f.i.p.b(d.a.l0.a.g1.f.V().getActivity(), this.f47545b, this.f47544a, false, this.j, this.f47548e);
            this.f47546c = bVar;
            bVar.k0(this.f47552i);
            this.f47549f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.l0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.l0.a.o.a aVar) {
        if (this.f47546c != null) {
            this.f47551h = aVar;
            this.f47546c.l0();
        }
    }

    @Override // d.a.l0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.l0.a.o.a aVar, c cVar) {
        this.f47547d = cVar;
        if (this.f47546c != null) {
            this.f47550g = aVar;
            if (aVar != null && !this.f47549f.contains(aVar)) {
                this.f47549f.add(aVar);
            }
            this.f47546c.e0();
        }
    }
}
