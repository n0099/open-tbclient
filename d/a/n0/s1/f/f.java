package d.a.n0.s1.f;

import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f64228a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f64229b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f64230a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1651f> f64231b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f64232c;

        /* renamed from: d  reason: collision with root package name */
        public String f64233d;

        /* renamed from: e  reason: collision with root package name */
        public String f64234e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64232c = jSONObject.optString("content");
            this.f64233d = jSONObject.optString("tip_text");
            this.f64234e = jSONObject.optString("img");
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
                this.f64230a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1651f c1651f = new C1651f();
                c1651f.a(optJSONArray2.optJSONObject(i3));
                this.f64231b.add(c1651f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f64235a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f64236b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64235a.a(jSONObject.optJSONObject("member"));
            this.f64236b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f64237a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1651f> f64238b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f64239c;

        /* renamed from: d  reason: collision with root package name */
        public String f64240d;

        /* renamed from: e  reason: collision with root package name */
        public String f64241e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64239c = jSONObject.optString("content");
            this.f64240d = jSONObject.optString("tip_text");
            this.f64241e = jSONObject.optString("img");
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
                this.f64237a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1651f c1651f = new C1651f();
                c1651f.a(jSONObject3);
                this.f64238b.add(c1651f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f64242a;

        /* renamed from: b  reason: collision with root package name */
        public String f64243b;

        /* renamed from: c  reason: collision with root package name */
        public String f64244c;

        /* renamed from: d  reason: collision with root package name */
        public String f64245d;

        /* renamed from: e  reason: collision with root package name */
        public String f64246e;

        /* renamed from: f  reason: collision with root package name */
        public String f64247f;

        /* renamed from: g  reason: collision with root package name */
        public String f64248g;

        /* renamed from: h  reason: collision with root package name */
        public String f64249h;

        /* renamed from: i  reason: collision with root package name */
        public long f64250i;
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
            this.f64242a = jSONObject.optString("productId");
            this.f64243b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f64244c = jSONObject.optString("discount");
            this.f64245d = jSONObject.optString("original_cost");
            this.f64246e = jSONObject.optString("icon");
            this.f64250i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f64247f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f64248g = jSONObject.optString("payment_pos_key");
            this.f64249h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64251a;

        /* renamed from: b  reason: collision with root package name */
        public String f64252b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64251a = jSONObject.optLong("props_id");
            jSONObject.optLong(ResultTB.ENDTIME);
            this.f64252b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.a.n0.s1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1651f {
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
        public String f64253a;

        /* renamed from: b  reason: collision with root package name */
        public String f64254b;

        /* renamed from: c  reason: collision with root package name */
        public e f64255c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f64253a = jSONObject.optString("name_show");
            this.f64254b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f64255c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f64228a.a(jSONObject.optJSONObject("user"));
        this.f64229b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
