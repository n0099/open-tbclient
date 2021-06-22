package d.a.o0.x0;

import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f67051a;

    /* renamed from: b  reason: collision with root package name */
    public String f67052b;

    /* renamed from: c  reason: collision with root package name */
    public b f67053c;

    /* renamed from: d  reason: collision with root package name */
    public String f67054d;

    /* renamed from: e  reason: collision with root package name */
    public String f67055e;

    /* renamed from: f  reason: collision with root package name */
    public List<C1796a> f67056f;

    /* renamed from: d.a.o0.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1796a {

        /* renamed from: a  reason: collision with root package name */
        public String f67057a;

        public String a() {
            return this.f67057a;
        }

        public void b(String str) {
            this.f67057a = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f67058a;

        /* renamed from: b  reason: collision with root package name */
        public String f67059b;

        public String a() {
            return this.f67058a;
        }

        public String b() {
            return this.f67059b;
        }

        public void c(String str) {
            this.f67058a = str;
        }

        public void d(String str) {
            this.f67059b = str;
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
                C1796a c1796a = new C1796a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    c1796a.b(optJSONObject.optString("src"));
                    arrayList.add(c1796a);
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
        return this.f67055e;
    }

    public List<C1796a> b() {
        return this.f67056f;
    }

    public String c() {
        return this.f67051a;
    }

    public String d() {
        return this.f67052b;
    }

    public b e() {
        return this.f67053c;
    }

    public String f() {
        return this.f67054d;
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
        this.f67055e = str;
    }

    public void k(String str) {
    }

    public void l(List<C1796a> list) {
        this.f67056f = list;
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
        this.f67051a = str;
    }

    public void s(String str) {
        this.f67052b = str;
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(b bVar) {
        this.f67053c = bVar;
    }

    public void w(String str) {
    }

    public void x(String str) {
        this.f67054d = str;
    }

    public void y(String str) {
    }
}
