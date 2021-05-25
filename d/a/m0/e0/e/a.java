package d.a.m0.e0.e;

import com.baidu.adp.BdUniqueId;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f49345a;

    /* renamed from: b  reason: collision with root package name */
    public String f49346b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49347c;

    /* renamed from: d  reason: collision with root package name */
    public String f49348d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49349e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49350f;

    /* renamed from: g  reason: collision with root package name */
    public b f49351g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f49352h = new C1121a();

    /* renamed from: d.a.m0.e0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1121a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public C1121a() {
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
                if (str.equals(a.this.f49346b)) {
                    a.this.f49347c = true;
                } else if (str.equals(a.this.f49348d)) {
                    a.this.f49349e = true;
                }
            }
            if (a.this.f49347c && a.this.f49349e) {
                a.this.f49350f = true;
            }
            if (a.this.f49351g == null || !a.this.f49350f) {
                return;
            }
            a.this.f49351g.a();
        }
    }

    public int j() {
        return 45;
    }

    public String k() {
        return this.f49346b;
    }

    public String l() {
        return this.f49348d;
    }

    public boolean m() {
        return this.f49350f;
    }

    public void n() {
        String str = this.f49346b;
        if (str != null && !k.isEmpty(str)) {
            d.h().k(this.f49346b, j(), this.f49352h, 0, 0, this.f49345a, new Object[0]);
        }
        String str2 = this.f49348d;
        if (str2 == null || k.isEmpty(str2)) {
            return;
        }
        d.h().k(this.f49348d, j(), this.f49352h, 0, 0, this.f49345a, new Object[0]);
    }

    public void o(JSONObject jSONObject) {
        this.f49346b = jSONObject.optString("pic_before");
        this.f49348d = jSONObject.optString("pic_after");
    }

    public void p(b bVar) {
        this.f49351g = bVar;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f49345a = bdUniqueId;
    }
}
