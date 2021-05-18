package d.a.k0.w0;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63026a;

    /* renamed from: b  reason: collision with root package name */
    public String f63027b;

    /* renamed from: c  reason: collision with root package name */
    public b f63028c;

    /* renamed from: d  reason: collision with root package name */
    public String f63029d;

    /* renamed from: e  reason: collision with root package name */
    public String f63030e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1718a> f63031f;

    /* renamed from: d.a.k0.w0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1718a {

        /* renamed from: a  reason: collision with root package name */
        public String f63032a;

        public String a() {
            return this.f63032a;
        }

        public void b(String str) {
            this.f63032a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f63033a;

        /* renamed from: b  reason: collision with root package name */
        public String f63034b;

        public String a() {
            return this.f63033a;
        }

        public String b() {
            return this.f63034b;
        }

        public void c(String str) {
            this.f63033a = str;
        }

        public void d(String str) {
            this.f63034b = str;
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
                C1718a c1718a = new C1718a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    c1718a.b(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c1718a);
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
        return this.f63030e;
    }

    public List<C1718a> b() {
        return this.f63031f;
    }

    public String c() {
        return this.f63026a;
    }

    public String d() {
        return this.f63027b;
    }

    public b e() {
        return this.f63028c;
    }

    public String f() {
        return this.f63029d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f63030e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1718a> list) {
        this.f63031f = list;
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
        this.f63026a = str;
    }

    public void s(String str) {
        this.f63027b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f63028c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f63029d = str;
    }

    public void y(String str) {
    }
}
