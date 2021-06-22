package d.a.o0.s1.f;

import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f64353a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f64354b = new b();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f64355a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1655f> f64356b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f64357c;

        /* renamed from: d  reason: collision with root package name */
        public String f64358d;

        /* renamed from: e  reason: collision with root package name */
        public String f64359e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64357c = jSONObject.optString("content");
            this.f64358d = jSONObject.optString("tip_text");
            this.f64359e = jSONObject.optString("img");
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
                this.f64355a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1655f c1655f = new C1655f();
                c1655f.a(optJSONArray2.optJSONObject(i3));
                this.f64356b.add(c1655f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f64360a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f64361b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64360a.a(jSONObject.optJSONObject("member"));
            this.f64361b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f64362a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1655f> f64363b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f64364c;

        /* renamed from: d  reason: collision with root package name */
        public String f64365d;

        /* renamed from: e  reason: collision with root package name */
        public String f64366e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64364c = jSONObject.optString("content");
            this.f64365d = jSONObject.optString("tip_text");
            this.f64366e = jSONObject.optString("img");
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
                this.f64362a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1655f c1655f = new C1655f();
                c1655f.a(jSONObject3);
                this.f64363b.add(c1655f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f64367a;

        /* renamed from: b  reason: collision with root package name */
        public String f64368b;

        /* renamed from: c  reason: collision with root package name */
        public String f64369c;

        /* renamed from: d  reason: collision with root package name */
        public String f64370d;

        /* renamed from: e  reason: collision with root package name */
        public String f64371e;

        /* renamed from: f  reason: collision with root package name */
        public String f64372f;

        /* renamed from: g  reason: collision with root package name */
        public String f64373g;

        /* renamed from: h  reason: collision with root package name */
        public String f64374h;

        /* renamed from: i  reason: collision with root package name */
        public long f64375i;
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
            this.f64367a = jSONObject.optString("productId");
            this.f64368b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f64369c = jSONObject.optString("discount");
            this.f64370d = jSONObject.optString("original_cost");
            this.f64371e = jSONObject.optString("icon");
            this.f64375i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f64372f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f64373g = jSONObject.optString("payment_pos_key");
            this.f64374h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64376a;

        /* renamed from: b  reason: collision with root package name */
        public String f64377b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64376a = jSONObject.optLong("props_id");
            jSONObject.optLong(ResultTB.ENDTIME);
            this.f64377b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.a.o0.s1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1655f {
        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optString("name");
            jSONObject.optLong("num");
        }
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public String f64378a;

        /* renamed from: b  reason: collision with root package name */
        public String f64379b;

        /* renamed from: c  reason: collision with root package name */
        public e f64380c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f64378a = jSONObject.optString("name_show");
            this.f64379b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f64380c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f64353a.a(jSONObject.optJSONObject("user"));
        this.f64354b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
