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
    public String f43868a;

    /* renamed from: b  reason: collision with root package name */
    public String f43869b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.i.p.b f43870c;

    /* renamed from: d  reason: collision with root package name */
    public c f43871d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.f.i.l.f f43872e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.l0.a.o.a> f43873f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.o.a f43874g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.o.a f43875h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f43876i;
    public d.a.l0.f.i.p.a j = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.f.i.p.a {
        public a() {
        }

        @Override // d.a.l0.f.i.p.a
        public void a(boolean z, String str) {
            if (z) {
                f.this.f43871d.b();
                f.this.f43874g.a(0);
                for (d.a.l0.a.o.a aVar : f.this.f43873f) {
                    aVar.a(0);
                    if (f.this.f43873f.contains(aVar)) {
                        f.this.f43873f.remove(aVar);
                    }
                }
                return;
            }
            f.this.f43874g.a(1001);
            for (d.a.l0.a.o.a aVar2 : f.this.f43873f) {
                aVar2.a(1001);
                if (f.this.f43873f.contains(aVar2)) {
                    f.this.f43873f.remove(aVar2);
                }
            }
        }

        @Override // d.a.l0.f.i.p.a
        public void b(boolean z, String str) {
            if (z) {
                f.this.f43875h.a(0);
            } else {
                f.this.f43875h.a(1001);
            }
        }

        @Override // d.a.l0.f.i.p.a
        public void c(boolean z, int i2) {
            f.this.f43871d.a(e.a(z));
        }

        @Override // d.a.l0.f.i.p.a
        public void onClick(int i2) {
        }

        @Override // d.a.l0.f.i.p.a
        public void onError(String str) {
            f.this.f43871d.c(e.b(str));
            d.a.l0.f.i.q.b.k(f.this.f43876i, str);
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.l0.a.o.a aVar) {
        this.f43868a = "";
        this.f43876i = new TreeMap();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f43868a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f43869b = optString;
            this.f43876i = d.a.l0.f.i.q.b.a("video", "app", optString, this.f43868a, false);
            this.f43872e = new g();
            d.a.l0.f.i.p.b bVar = new d.a.l0.f.i.p.b(d.a.l0.a.g1.f.V().getActivity(), this.f43869b, this.f43868a, false, this.j, this.f43872e);
            this.f43870c = bVar;
            bVar.k0(this.f43876i);
            this.f43873f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.l0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.l0.a.o.a aVar) {
        if (this.f43870c != null) {
            this.f43875h = aVar;
            this.f43870c.l0();
        }
    }

    @Override // d.a.l0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.l0.a.o.a aVar, c cVar) {
        this.f43871d = cVar;
        if (this.f43870c != null) {
            this.f43874g = aVar;
            if (aVar != null && !this.f43873f.contains(aVar)) {
                this.f43873f.add(aVar);
            }
            this.f43870c.e0();
        }
    }
}
