package d.b.i0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.b.c.e.l.d;
import d.b.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f50894a;

    /* renamed from: b  reason: collision with root package name */
    public String f50895b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50896c;

    /* renamed from: d  reason: collision with root package name */
    public String f50897d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50898e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50899f;

    /* renamed from: g  reason: collision with root package name */
    public b f50900g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.e.l.c<d.b.c.j.d.a> f50901h = new C1097a();

    /* renamed from: d.b.i0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1097a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public C1097a() {
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            if (aVar != null && str != null) {
                if (str.equals(a.this.f50895b)) {
                    a.this.f50896c = true;
                } else if (str.equals(a.this.f50897d)) {
                    a.this.f50898e = true;
                }
            }
            if (a.this.f50896c && a.this.f50898e) {
                a.this.f50899f = true;
            }
            if (a.this.f50900g == null || !a.this.f50899f) {
                return;
            }
            a.this.f50900g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f50895b;
    }

    public String l() {
        return this.f50897d;
    }

    public boolean m() {
        return this.f50899f;
    }

    public void n() {
        String str = this.f50895b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f50895b, j(), this.f50901h, 0, 0, this.f50894a, new Object[0]);
        }
        String str2 = this.f50897d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f50897d, j(), this.f50901h, 0, 0, this.f50894a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f50895b = jSONObject.optString("pic_before");
        this.f50897d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f50900g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f50894a = bdUniqueId;
    }
}
