package d.a.i0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f48473a;

    /* renamed from: b  reason: collision with root package name */
    public String f48474b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48475c;

    /* renamed from: d  reason: collision with root package name */
    public String f48476d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48477e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48478f;

    /* renamed from: g  reason: collision with root package name */
    public b f48479g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f48480h = new C1036a();

    /* renamed from: d.a.i0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1036a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public C1036a() {
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
                if (str.equals(a.this.f48474b)) {
                    a.this.f48475c = true;
                } else if (str.equals(a.this.f48476d)) {
                    a.this.f48477e = true;
                }
            }
            if (a.this.f48475c && a.this.f48477e) {
                a.this.f48478f = true;
            }
            if (a.this.f48479g == null || !a.this.f48478f) {
                return;
            }
            a.this.f48479g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f48474b;
    }

    public String l() {
        return this.f48476d;
    }

    public boolean m() {
        return this.f48478f;
    }

    public void n() {
        String str = this.f48474b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f48474b, j(), this.f48480h, 0, 0, this.f48473a, new Object[0]);
        }
        String str2 = this.f48476d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f48476d, j(), this.f48480h, 0, 0, this.f48473a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f48474b = jSONObject.optString("pic_before");
        this.f48476d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f48479g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f48473a = bdUniqueId;
    }
}
