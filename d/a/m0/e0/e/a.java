package d.a.m0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f53019a;

    /* renamed from: b  reason: collision with root package name */
    public String f53020b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53021c;

    /* renamed from: d  reason: collision with root package name */
    public String f53022d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53023e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53024f;

    /* renamed from: g  reason: collision with root package name */
    public b f53025g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.k.d.a> f53026h = new C1177a();

    /* renamed from: d.a.m0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1177a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public C1177a() {
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
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null && str != null) {
                if (str.equals(a.this.f53020b)) {
                    a.this.f53021c = true;
                } else if (str.equals(a.this.f53022d)) {
                    a.this.f53023e = true;
                }
            }
            if (a.this.f53021c && a.this.f53023e) {
                a.this.f53024f = true;
            }
            if (a.this.f53025g == null || !a.this.f53024f) {
                return;
            }
            a.this.f53025g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f53020b;
    }

    public String l() {
        return this.f53022d;
    }

    public boolean m() {
        return this.f53024f;
    }

    public void n() {
        String str = this.f53020b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f53020b, j(), this.f53026h, 0, 0, this.f53019a, new Object[0]);
        }
        String str2 = this.f53022d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f53022d, j(), this.f53026h, 0, 0, this.f53019a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f53020b = jSONObject.optString("pic_before");
        this.f53022d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f53025g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f53019a = bdUniqueId;
    }
}
