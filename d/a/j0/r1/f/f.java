package d.a.j0.r1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f59669a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f59670b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59671a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1509f> f59672b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59673c;

        /* renamed from: d  reason: collision with root package name */
        public String f59674d;

        /* renamed from: e  reason: collision with root package name */
        public String f59675e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59673c = jSONObject.optString("content");
            this.f59674d = jSONObject.optString("tip_text");
            this.f59675e = jSONObject.optString("img");
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
                this.f59671a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1509f c1509f = new C1509f();
                c1509f.a(optJSONArray2.optJSONObject(i3));
                this.f59672b.add(c1509f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f59676a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f59677b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59676a.a(jSONObject.optJSONObject("member"));
            this.f59677b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f59678a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1509f> f59679b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f59680c;

        /* renamed from: d  reason: collision with root package name */
        public String f59681d;

        /* renamed from: e  reason: collision with root package name */
        public String f59682e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59680c = jSONObject.optString("content");
            this.f59681d = jSONObject.optString("tip_text");
            this.f59682e = jSONObject.optString("img");
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
                this.f59678a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1509f c1509f = new C1509f();
                c1509f.a(jSONObject3);
                this.f59679b.add(c1509f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f59683a;

        /* renamed from: b  reason: collision with root package name */
        public String f59684b;

        /* renamed from: c  reason: collision with root package name */
        public String f59685c;

        /* renamed from: d  reason: collision with root package name */
        public String f59686d;

        /* renamed from: e  reason: collision with root package name */
        public String f59687e;

        /* renamed from: f  reason: collision with root package name */
        public String f59688f;

        /* renamed from: g  reason: collision with root package name */
        public String f59689g;

        /* renamed from: h  reason: collision with root package name */
        public String f59690h;

        /* renamed from: i  reason: collision with root package name */
        public long f59691i;
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
            this.f59683a = jSONObject.optString("productId");
            this.f59684b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f59685c = jSONObject.optString("discount");
            this.f59686d = jSONObject.optString("original_cost");
            this.f59687e = jSONObject.optString("icon");
            this.f59691i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f59688f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f59689g = jSONObject.optString("payment_pos_key");
            this.f59690h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f59692a;

        /* renamed from: b  reason: collision with root package name */
        public String f59693b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59692a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f59693b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.a.j0.r1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1509f {
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
        public String f59694a;

        /* renamed from: b  reason: collision with root package name */
        public String f59695b;

        /* renamed from: c  reason: collision with root package name */
        public e f59696c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f59694a = jSONObject.optString("name_show");
            this.f59695b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f59696c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f59669a.a(jSONObject.optJSONObject("user"));
        this.f59670b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
