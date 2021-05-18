package d.a.i0.a.o;

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
    public String f43694a;

    /* renamed from: b  reason: collision with root package name */
    public String f43695b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.f.i.p.b f43696c;

    /* renamed from: d  reason: collision with root package name */
    public c f43697d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.f.i.l.f f43698e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.i0.a.o.a> f43699f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.o.a f43700g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.a.o.a f43701h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f43702i;
    public d.a.i0.f.i.p.a j = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.f.i.p.a {
        public a() {
        }

        @Override // d.a.i0.f.i.p.a
        public void a(boolean z, String str) {
            if (z) {
                f.this.f43697d.b();
                f.this.f43700g.a(0);
                for (d.a.i0.a.o.a aVar : f.this.f43699f) {
                    aVar.a(0);
                    if (f.this.f43699f.contains(aVar)) {
                        f.this.f43699f.remove(aVar);
                    }
                }
                return;
            }
            f.this.f43700g.a(1001);
            for (d.a.i0.a.o.a aVar2 : f.this.f43699f) {
                aVar2.a(1001);
                if (f.this.f43699f.contains(aVar2)) {
                    f.this.f43699f.remove(aVar2);
                }
            }
        }

        @Override // d.a.i0.f.i.p.a
        public void b(boolean z, String str) {
            if (z) {
                f.this.f43701h.a(0);
            } else {
                f.this.f43701h.a(1001);
            }
        }

        @Override // d.a.i0.f.i.p.a
        public void c(boolean z, int i2) {
            f.this.f43697d.a(e.a(z));
        }

        @Override // d.a.i0.f.i.p.a
        public void onClick(int i2) {
        }

        @Override // d.a.i0.f.i.p.a
        public void onError(String str) {
            f.this.f43697d.c(e.b(str));
            d.a.i0.f.i.q.b.k(f.this.f43702i, str);
        }
    }

    public f(@NonNull JSONObject jSONObject, c cVar, d.a.i0.a.o.a aVar) {
        this.f43694a = "";
        this.f43702i = new TreeMap();
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.f43694a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.f43695b = optString;
            this.f43702i = d.a.i0.f.i.q.b.a("video", "app", optString, this.f43694a, false);
            this.f43698e = new g();
            d.a.i0.f.i.p.b bVar = new d.a.i0.f.i.p.b(d.a.i0.a.g1.f.V().getActivity(), this.f43695b, this.f43694a, false, this.j, this.f43698e);
            this.f43696c = bVar;
            bVar.k0(this.f43702i);
            this.f43699f = new CopyOnWriteArrayList();
            b(jSONObject, aVar, cVar);
            return;
        }
        aVar.a(202);
    }

    @Override // d.a.i0.a.o.b
    public synchronized void a(JSONObject jSONObject, d.a.i0.a.o.a aVar) {
        if (this.f43696c != null) {
            this.f43701h = aVar;
            this.f43696c.l0();
        }
    }

    @Override // d.a.i0.a.o.b
    public synchronized void b(JSONObject jSONObject, d.a.i0.a.o.a aVar, c cVar) {
        this.f43697d = cVar;
        if (this.f43696c != null) {
            this.f43700g = aVar;
            if (aVar != null && !this.f43699f.contains(aVar)) {
                this.f43699f.add(aVar);
            }
            this.f43696c.e0();
        }
    }
}
