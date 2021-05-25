package d.a.n0.s1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f60537a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f60538b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f60539a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1595f> f60540b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f60541c;

        /* renamed from: d  reason: collision with root package name */
        public String f60542d;

        /* renamed from: e  reason: collision with root package name */
        public String f60543e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60541c = jSONObject.optString("content");
            this.f60542d = jSONObject.optString("tip_text");
            this.f60543e = jSONObject.optString("img");
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
                this.f60539a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1595f c1595f = new C1595f();
                c1595f.a(optJSONArray2.optJSONObject(i3));
                this.f60540b.add(c1595f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f60544a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f60545b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60544a.a(jSONObject.optJSONObject("member"));
            this.f60545b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f60546a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1595f> f60547b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f60548c;

        /* renamed from: d  reason: collision with root package name */
        public String f60549d;

        /* renamed from: e  reason: collision with root package name */
        public String f60550e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60548c = jSONObject.optString("content");
            this.f60549d = jSONObject.optString("tip_text");
            this.f60550e = jSONObject.optString("img");
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
                this.f60546a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1595f c1595f = new C1595f();
                c1595f.a(jSONObject3);
                this.f60547b.add(c1595f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f60551a;

        /* renamed from: b  reason: collision with root package name */
        public String f60552b;

        /* renamed from: c  reason: collision with root package name */
        public String f60553c;

        /* renamed from: d  reason: collision with root package name */
        public String f60554d;

        /* renamed from: e  reason: collision with root package name */
        public String f60555e;

        /* renamed from: f  reason: collision with root package name */
        public String f60556f;

        /* renamed from: g  reason: collision with root package name */
        public String f60557g;

        /* renamed from: h  reason: collision with root package name */
        public String f60558h;

        /* renamed from: i  reason: collision with root package name */
        public long f60559i;
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
            this.f60551a = jSONObject.optString("productId");
            this.f60552b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f60553c = jSONObject.optString("discount");
            this.f60554d = jSONObject.optString("original_cost");
            this.f60555e = jSONObject.optString("icon");
            this.f60559i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f60556f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f60557g = jSONObject.optString("payment_pos_key");
            this.f60558h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f60560a;

        /* renamed from: b  reason: collision with root package name */
        public String f60561b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60560a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f60561b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.a.n0.s1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1595f {
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
        public String f60562a;

        /* renamed from: b  reason: collision with root package name */
        public String f60563b;

        /* renamed from: c  reason: collision with root package name */
        public e f60564c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f60562a = jSONObject.optString("name_show");
            this.f60563b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f60564c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f60537a.a(jSONObject.optJSONObject("user"));
        this.f60538b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
