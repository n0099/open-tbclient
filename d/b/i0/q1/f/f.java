package d.b.i0.q1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f59403a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f59404b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59405a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1482f> f59406b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59407c;

        /* renamed from: d  reason: collision with root package name */
        public String f59408d;

        /* renamed from: e  reason: collision with root package name */
        public String f59409e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59407c = jSONObject.optString("content");
            this.f59408d = jSONObject.optString("tip_text");
            this.f59409e = jSONObject.optString("img");
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
                this.f59405a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                C1482f c1482f = new C1482f();
                c1482f.a(optJSONArray2.optJSONObject(i2));
                this.f59406b.add(c1482f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f59410a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f59411b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59410a.a(jSONObject.optJSONObject("member"));
            this.f59411b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59412a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1482f> f59413b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59414c;

        /* renamed from: d  reason: collision with root package name */
        public String f59415d;

        /* renamed from: e  reason: collision with root package name */
        public String f59416e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59414c = jSONObject.optString("content");
            this.f59415d = jSONObject.optString("tip_text");
            this.f59416e = jSONObject.optString("img");
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
                this.f59412a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                C1482f c1482f = new C1482f();
                c1482f.a(jSONObject3);
                this.f59413b.add(c1482f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f59417a;

        /* renamed from: b  reason: collision with root package name */
        public String f59418b;

        /* renamed from: c  reason: collision with root package name */
        public String f59419c;

        /* renamed from: d  reason: collision with root package name */
        public String f59420d;

        /* renamed from: e  reason: collision with root package name */
        public String f59421e;

        /* renamed from: f  reason: collision with root package name */
        public String f59422f;

        /* renamed from: g  reason: collision with root package name */
        public String f59423g;

        /* renamed from: h  reason: collision with root package name */
        public String f59424h;
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
            this.f59417a = jSONObject.optString("productId");
            this.f59418b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f59419c = jSONObject.optString("discount");
            this.f59420d = jSONObject.optString("original_cost");
            this.f59421e = jSONObject.optString("icon");
            this.i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f59422f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f59423g = jSONObject.optString("payment_pos_key");
            this.f59424h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f59425a;

        /* renamed from: b  reason: collision with root package name */
        public String f59426b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59425a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f59426b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.b.i0.q1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1482f {
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
        public String f59427a;

        /* renamed from: b  reason: collision with root package name */
        public String f59428b;

        /* renamed from: c  reason: collision with root package name */
        public e f59429c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f59427a = jSONObject.optString("name_show");
            this.f59428b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f59429c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f59403a.a(jSONObject.optJSONObject("user"));
        this.f59404b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
