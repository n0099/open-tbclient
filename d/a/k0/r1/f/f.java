package d.a.k0.r1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f60414a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f60415b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f60416a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1583f> f60417b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f60418c;

        /* renamed from: d  reason: collision with root package name */
        public String f60419d;

        /* renamed from: e  reason: collision with root package name */
        public String f60420e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60418c = jSONObject.optString("content");
            this.f60419d = jSONObject.optString("tip_text");
            this.f60420e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f60416a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1583f c1583f = new C1583f();
                c1583f.a(optJSONArray2.optJSONObject(i3));
                this.f60417b.add(c1583f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f60421a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f60422b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60421a.a(jSONObject.optJSONObject("member"));
            this.f60422b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f60423a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1583f> f60424b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f60425c;

        /* renamed from: d  reason: collision with root package name */
        public String f60426d;

        /* renamed from: e  reason: collision with root package name */
        public String f60427e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60425c = jSONObject.optString("content");
            this.f60426d = jSONObject.optString("tip_text");
            this.f60427e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f60423a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1583f c1583f = new C1583f();
                c1583f.a(jSONObject3);
                this.f60424b.add(c1583f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f60428a;

        /* renamed from: b  reason: collision with root package name */
        public String f60429b;

        /* renamed from: c  reason: collision with root package name */
        public String f60430c;

        /* renamed from: d  reason: collision with root package name */
        public String f60431d;

        /* renamed from: e  reason: collision with root package name */
        public String f60432e;

        /* renamed from: f  reason: collision with root package name */
        public String f60433f;

        /* renamed from: g  reason: collision with root package name */
        public String f60434g;

        /* renamed from: h  reason: collision with root package name */
        public String f60435h;

        /* renamed from: i  reason: collision with root package name */
        public long f60436i;
        public long j;
        public long k;
        public long l;
        public boolean m;
        public int n;
        public boolean o;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60428a = jSONObject.optString("productId");
            this.f60429b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f60430c = jSONObject.optString("discount");
            this.f60431d = jSONObject.optString("original_cost");
            this.f60432e = jSONObject.optString("icon");
            this.f60436i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f60433f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f60434g = jSONObject.optString("payment_pos_key");
            this.f60435h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f60437a;

        /* renamed from: b  reason: collision with root package name */
        public String f60438b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60437a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f60438b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.a.k0.r1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1583f {
        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optString("name");
            jSONObject.optLong("num");
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public String f60439a;

        /* renamed from: b  reason: collision with root package name */
        public String f60440b;

        /* renamed from: c  reason: collision with root package name */
        public e f60441c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f60439a = jSONObject.optString("name_show");
            this.f60440b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f60441c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f60414a.a(jSONObject.optJSONObject("user"));
        this.f60415b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
