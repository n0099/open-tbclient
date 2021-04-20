package d.b.i0.w0;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63631a;

    /* renamed from: b  reason: collision with root package name */
    public String f63632b;

    /* renamed from: c  reason: collision with root package name */
    public b f63633c;

    /* renamed from: d  reason: collision with root package name */
    public String f63634d;

    /* renamed from: e  reason: collision with root package name */
    public String f63635e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1693a> f63636f;

    /* renamed from: d.b.i0.w0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1693a {

        /* renamed from: a  reason: collision with root package name */
        public String f63637a;

        public String a() {
            return this.f63637a;
        }

        public void b(String str) {
            this.f63637a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f63638a;

        /* renamed from: b  reason: collision with root package name */
        public String f63639b;

        public String a() {
            return this.f63638a;
        }

        public String b() {
            return this.f63639b;
        }

        public void c(String str) {
            this.f63638a = str;
        }

        public void d(String str) {
            this.f63639b = str;
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
                C1693a c1693a = new C1693a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c1693a.b(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c1693a);
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
        return this.f63635e;
    }

    public List<C1693a> b() {
        return this.f63636f;
    }

    public String c() {
        return this.f63631a;
    }

    public String d() {
        return this.f63632b;
    }

    public b e() {
        return this.f63633c;
    }

    public String f() {
        return this.f63634d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f63635e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1693a> list) {
        this.f63636f = list;
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
        this.f63631a = str;
    }

    public void s(String str) {
        this.f63632b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f63633c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f63634d = str;
    }

    public void y(String str) {
    }
}
