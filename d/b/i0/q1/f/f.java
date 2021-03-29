package d.b.i0.q1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f59404a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f59405b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59406a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1483f> f59407b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59408c;

        /* renamed from: d  reason: collision with root package name */
        public String f59409d;

        /* renamed from: e  reason: collision with root package name */
        public String f59410e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59408c = jSONObject.optString("content");
            this.f59409d = jSONObject.optString("tip_text");
            this.f59410e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f59406a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                C1483f c1483f = new C1483f();
                c1483f.a(optJSONArray2.optJSONObject(i2));
                this.f59407b.add(c1483f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f59411a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f59412b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59411a.a(jSONObject.optJSONObject("member"));
            this.f59412b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59413a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1483f> f59414b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59415c;

        /* renamed from: d  reason: collision with root package name */
        public String f59416d;

        /* renamed from: e  reason: collision with root package name */
        public String f59417e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59415c = jSONObject.optString("content");
            this.f59416d = jSONObject.optString("tip_text");
            this.f59417e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f59413a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                C1483f c1483f = new C1483f();
                c1483f.a(jSONObject3);
                this.f59414b.add(c1483f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f59418a;

        /* renamed from: b  reason: collision with root package name */
        public String f59419b;

        /* renamed from: c  reason: collision with root package name */
        public String f59420c;

        /* renamed from: d  reason: collision with root package name */
        public String f59421d;

        /* renamed from: e  reason: collision with root package name */
        public String f59422e;

        /* renamed from: f  reason: collision with root package name */
        public String f59423f;

        /* renamed from: g  reason: collision with root package name */
        public String f59424g;

        /* renamed from: h  reason: collision with root package name */
        public String f59425h;
        public long i;
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
            this.f59418a = jSONObject.optString("productId");
            this.f59419b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f59420c = jSONObject.optString("discount");
            this.f59421d = jSONObject.optString("original_cost");
            this.f59422e = jSONObject.optString("icon");
            this.i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f59423f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f59424g = jSONObject.optString("payment_pos_key");
            this.f59425h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f59426a;

        /* renamed from: b  reason: collision with root package name */
        public String f59427b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59426a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f59427b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.b.i0.q1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1483f {
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
        public String f59428a;

        /* renamed from: b  reason: collision with root package name */
        public String f59429b;

        /* renamed from: c  reason: collision with root package name */
        public e f59430c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f59428a = jSONObject.optString("name_show");
            this.f59429b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f59430c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f59404a.a(jSONObject.optJSONObject("user"));
        this.f59405b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
