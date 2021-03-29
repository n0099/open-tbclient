package d.b.i0.v0;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61965a;

    /* renamed from: b  reason: collision with root package name */
    public String f61966b;

    /* renamed from: c  reason: collision with root package name */
    public b f61967c;

    /* renamed from: d  reason: collision with root package name */
    public String f61968d;

    /* renamed from: e  reason: collision with root package name */
    public String f61969e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1636a> f61970f;

    /* renamed from: d.b.i0.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1636a {

        /* renamed from: a  reason: collision with root package name */
        public String f61971a;

        public String a() {
            return this.f61971a;
        }

        public void b(String str) {
            this.f61971a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f61972a;

        /* renamed from: b  reason: collision with root package name */
        public String f61973b;

        public String a() {
            return this.f61972a;
        }

        public String b() {
            return this.f61973b;
        }

        public void c(String str) {
            this.f61972a = str;
        }

        public void d(String str) {
            this.f61973b = str;
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                C1636a c1636a = new C1636a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c1636a.b(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c1636a);
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
        return this.f61969e;
    }

    public List<C1636a> b() {
        return this.f61970f;
    }

    public String c() {
        return this.f61965a;
    }

    public String d() {
        return this.f61966b;
    }

    public b e() {
        return this.f61967c;
    }

    public String f() {
        return this.f61968d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f61969e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1636a> list) {
        this.f61970f = list;
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
        this.f61965a = str;
    }

    public void s(String str) {
        this.f61966b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f61967c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f61968d = str;
    }

    public void y(String str) {
    }
}
