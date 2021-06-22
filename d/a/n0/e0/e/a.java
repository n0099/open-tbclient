package d.a.n0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f53126a;

    /* renamed from: b  reason: collision with root package name */
    public String f53127b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53128c;

    /* renamed from: d  reason: collision with root package name */
    public String f53129d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53130e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53131f;

    /* renamed from: g  reason: collision with root package name */
    public b f53132g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.k.d.a> f53133h = new C1180a();

    /* renamed from: d.a.n0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1180a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public C1180a() {
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
                if (str.equals(a.this.f53127b)) {
                    a.this.f53128c = true;
                } else if (str.equals(a.this.f53129d)) {
                    a.this.f53130e = true;
                }
            }
            if (a.this.f53128c && a.this.f53130e) {
                a.this.f53131f = true;
            }
            if (a.this.f53132g == null || !a.this.f53131f) {
                return;
            }
            a.this.f53132g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f53127b;
    }

    public String l() {
        return this.f53129d;
    }

    public boolean m() {
        return this.f53131f;
    }

    public void n() {
        String str = this.f53127b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f53127b, j(), this.f53133h, 0, 0, this.f53126a, new Object[0]);
        }
        String str2 = this.f53129d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f53129d, j(), this.f53133h, 0, 0, this.f53126a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f53127b = jSONObject.optString("pic_before");
        this.f53129d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f53132g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f53126a = bdUniqueId;
    }
}
