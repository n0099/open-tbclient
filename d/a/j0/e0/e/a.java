package d.a.j0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f49301a;

    /* renamed from: b  reason: collision with root package name */
    public String f49302b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49303c;

    /* renamed from: d  reason: collision with root package name */
    public String f49304d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49305e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49306f;

    /* renamed from: g  reason: collision with root package name */
    public b f49307g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f49308h = new C1112a();

    /* renamed from: d.a.j0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1112a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public C1112a() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null && str != null) {
                if (str.equals(a.this.f49302b)) {
                    a.this.f49303c = true;
                } else if (str.equals(a.this.f49304d)) {
                    a.this.f49305e = true;
                }
            }
            if (a.this.f49303c && a.this.f49305e) {
                a.this.f49306f = true;
            }
            if (a.this.f49307g == null || !a.this.f49306f) {
                return;
            }
            a.this.f49307g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f49302b;
    }

    public String l() {
        return this.f49304d;
    }

    public boolean m() {
        return this.f49306f;
    }

    public void n() {
        String str = this.f49302b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f49302b, j(), this.f49308h, 0, 0, this.f49301a, new Object[0]);
        }
        String str2 = this.f49304d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f49304d, j(), this.f49308h, 0, 0, this.f49301a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f49302b = jSONObject.optString("pic_before");
        this.f49304d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f49307g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f49301a = bdUniqueId;
    }
}
