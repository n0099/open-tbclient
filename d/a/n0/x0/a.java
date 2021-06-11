package d.a.n0.x0;

import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f66926a;

    /* renamed from: b  reason: collision with root package name */
    public String f66927b;

    /* renamed from: c  reason: collision with root package name */
    public b f66928c;

    /* renamed from: d  reason: collision with root package name */
    public String f66929d;

    /* renamed from: e  reason: collision with root package name */
    public String f66930e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1792a> f66931f;

    /* renamed from: d.a.n0.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1792a {

        /* renamed from: a  reason: collision with root package name */
        public String f66932a;

        public String a() {
            return this.f66932a;
        }

        public void b(String str) {
            this.f66932a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f66933a;

        /* renamed from: b  reason: collision with root package name */
        public String f66934b;

        public String a() {
            return this.f66933a;
        }

        public String b() {
            return this.f66934b;
        }

        public void c(String str) {
            this.f66933a = str;
        }

        public void d(String str) {
            this.f66934b = str;
        }

        public void e(String str) {
        }
    }

    public static a g(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.h(jSONObject.optString("commission"));
        aVar.i(jSONObject.optString("coupon"));
        aVar.j(jSONObject.optString("goodsId"));
        aVar.k(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                C1792a c1792a = new C1792a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    c1792a.b(optJSONObject.optString("src"));
                    arrayList.add(c1792a);
                }
            }
            aVar.l(arrayList);
        }
        aVar.m(jSONObject.optString("isBindingVideo"));
        aVar.n(jSONObject.optBoolean("isSelected"));
        aVar.o(jSONObject.optString("nid"));
        aVar.p(jSONObject.optString("originalGoodsId"));
        aVar.q(jSONObject.optString("originalPrice"));
        aVar.r(jSONObject.optString("originalTitle"));
        aVar.x(jSONObject.optString("tpName"));
        aVar.s(jSONObject.optString("price"));
        aVar.t(jSONObject.optString("saleNum"));
        aVar.u(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.c(optJSONObject2.optString("Android"));
            bVar.e(optJSONObject2.optString("IOS"));
            bVar.d(optJSONObject2.optString("h5"));
            aVar.v(bVar);
        }
        aVar.w(jSONObject.optString("title"));
        aVar.y(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }

    public String a() {
        return this.f66930e;
    }

    public List<C1792a> b() {
        return this.f66931f;
    }

    public String c() {
        return this.f66926a;
    }

    public String d() {
        return this.f66927b;
    }

    public b e() {
        return this.f66928c;
    }

    public String f() {
        return this.f66929d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f66930e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1792a> list) {
        this.f66931f = list;
    }

    public void m(String str) {
    }

    public void n(boolean z) {
    }

    public void o(String str) {
    }

    public void p(String str) {
    }

    public void q(String str) {
    }

    public void r(String str) {
        this.f66926a = str;
    }

    public void s(String str) {
        this.f66927b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f66928c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f66929d = str;
    }

    public void y(String str) {
    }
}
