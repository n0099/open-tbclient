package d.a.n0.x0;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63211a;

    /* renamed from: b  reason: collision with root package name */
    public String f63212b;

    /* renamed from: c  reason: collision with root package name */
    public b f63213c;

    /* renamed from: d  reason: collision with root package name */
    public String f63214d;

    /* renamed from: e  reason: collision with root package name */
    public String f63215e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1735a> f63216f;

    /* renamed from: d.a.n0.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1735a {

        /* renamed from: a  reason: collision with root package name */
        public String f63217a;

        public String a() {
            return this.f63217a;
        }

        public void b(String str) {
            this.f63217a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f63218a;

        /* renamed from: b  reason: collision with root package name */
        public String f63219b;

        public String a() {
            return this.f63218a;
        }

        public String b() {
            return this.f63219b;
        }

        public void c(String str) {
            this.f63218a = str;
        }

        public void d(String str) {
            this.f63219b = str;
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
                C1735a c1735a = new C1735a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    c1735a.b(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c1735a);
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
        return this.f63215e;
    }

    public List<C1735a> b() {
        return this.f63216f;
    }

    public String c() {
        return this.f63211a;
    }

    public String d() {
        return this.f63212b;
    }

    public b e() {
        return this.f63213c;
    }

    public String f() {
        return this.f63214d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f63215e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1735a> list) {
        this.f63216f = list;
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
        this.f63211a = str;
    }

    public void s(String str) {
        this.f63212b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f63213c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f63214d = str;
    }

    public void y(String str) {
    }
}
