package d.b.h0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.b.c.e.l.d;
import d.b.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f50558a;

    /* renamed from: b  reason: collision with root package name */
    public String f50559b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50560c;

    /* renamed from: d  reason: collision with root package name */
    public String f50561d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50562e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50563f;

    /* renamed from: g  reason: collision with root package name */
    public b f50564g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.e.l.c<d.b.c.j.d.a> f50565h = new C1075a();

    /* renamed from: d.b.h0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1075a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public C1075a() {
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
                if (str.equals(a.this.f50559b)) {
                    a.this.f50560c = true;
                } else if (str.equals(a.this.f50561d)) {
                    a.this.f50562e = true;
                }
            }
            if (a.this.f50560c && a.this.f50562e) {
                a.this.f50563f = true;
            }
            if (a.this.f50564g == null || !a.this.f50563f) {
                return;
            }
            a.this.f50564g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f50559b;
    }

    public String l() {
        return this.f50561d;
    }

    public boolean m() {
        return this.f50563f;
    }

    public void n() {
        String str = this.f50559b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f50559b, j(), this.f50565h, 0, 0, this.f50558a, new Object[0]);
        }
        String str2 = this.f50561d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f50561d, j(), this.f50565h, 0, 0, this.f50558a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f50559b = jSONObject.optString("pic_before");
        this.f50561d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f50564g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f50558a = bdUniqueId;
    }
}
