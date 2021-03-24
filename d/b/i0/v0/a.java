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
    public String f61964a;

    /* renamed from: b  reason: collision with root package name */
    public String f61965b;

    /* renamed from: c  reason: collision with root package name */
    public b f61966c;

    /* renamed from: d  reason: collision with root package name */
    public String f61967d;

    /* renamed from: e  reason: collision with root package name */
    public String f61968e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1635a> f61969f;

    /* renamed from: d.b.i0.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1635a {

        /* renamed from: a  reason: collision with root package name */
        public String f61970a;

        public String a() {
            return this.f61970a;
        }

        public void b(String str) {
            this.f61970a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f61971a;

        /* renamed from: b  reason: collision with root package name */
        public String f61972b;

        public String a() {
            return this.f61971a;
        }

        public String b() {
            return this.f61972b;
        }

        public void c(String str) {
            this.f61971a = str;
        }

        public void d(String str) {
            this.f61972b = str;
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
                C1635a c1635a = new C1635a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c1635a.b(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c1635a);
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
        return this.f61968e;
    }

    public List<C1635a> b() {
        return this.f61969f;
    }

    public String c() {
        return this.f61964a;
    }

    public String d() {
        return this.f61965b;
    }

    public b e() {
        return this.f61966c;
    }

    public String f() {
        return this.f61967d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f61968e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1635a> list) {
        this.f61969f = list;
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
        this.f61964a = str;
    }

    public void s(String str) {
        this.f61965b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f61966c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f61967d = str;
    }

    public void y(String str) {
    }
}
