package d.b.j0.r1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f61519a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f61520b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f61521a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1570f> f61522b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f61523c;

        /* renamed from: d  reason: collision with root package name */
        public String f61524d;

        /* renamed from: e  reason: collision with root package name */
        public String f61525e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61523c = jSONObject.optString("content");
            this.f61524d = jSONObject.optString("tip_text");
            this.f61525e = jSONObject.optString("img");
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
                this.f61521a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                C1570f c1570f = new C1570f();
                c1570f.a(optJSONArray2.optJSONObject(i2));
                this.f61522b.add(c1570f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f61526a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f61527b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61526a.a(jSONObject.optJSONObject("member"));
            this.f61527b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f61528a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1570f> f61529b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f61530c;

        /* renamed from: d  reason: collision with root package name */
        public String f61531d;

        /* renamed from: e  reason: collision with root package name */
        public String f61532e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61530c = jSONObject.optString("content");
            this.f61531d = jSONObject.optString("tip_text");
            this.f61532e = jSONObject.optString("img");
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
                this.f61528a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                C1570f c1570f = new C1570f();
                c1570f.a(jSONObject3);
                this.f61529b.add(c1570f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f61533a;

        /* renamed from: b  reason: collision with root package name */
        public String f61534b;

        /* renamed from: c  reason: collision with root package name */
        public String f61535c;

        /* renamed from: d  reason: collision with root package name */
        public String f61536d;

        /* renamed from: e  reason: collision with root package name */
        public String f61537e;

        /* renamed from: f  reason: collision with root package name */
        public String f61538f;

        /* renamed from: g  reason: collision with root package name */
        public String f61539g;

        /* renamed from: h  reason: collision with root package name */
        public String f61540h;
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
            this.f61533a = jSONObject.optString("productId");
            this.f61534b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f61535c = jSONObject.optString("discount");
            this.f61536d = jSONObject.optString("original_cost");
            this.f61537e = jSONObject.optString("icon");
            this.i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f61538f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f61539g = jSONObject.optString("payment_pos_key");
            this.f61540h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f61541a;

        /* renamed from: b  reason: collision with root package name */
        public String f61542b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61541a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f61542b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.b.j0.r1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1570f {
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
        public String f61543a;

        /* renamed from: b  reason: collision with root package name */
        public String f61544b;

        /* renamed from: c  reason: collision with root package name */
        public e f61545c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f61543a = jSONObject.optString("name_show");
            this.f61544b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f61545c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f61519a.a(jSONObject.optJSONObject("user"));
        this.f61520b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
