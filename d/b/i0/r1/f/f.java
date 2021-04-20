package d.b.i0.r1.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public g f61098a = new g();

    /* renamed from: b  reason: collision with root package name */
    public b f61099b = new b();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f61100a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1547f> f61101b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f61102c;

        /* renamed from: d  reason: collision with root package name */
        public String f61103d;

        /* renamed from: e  reason: collision with root package name */
        public String f61104e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61102c = jSONObject.optString("content");
            this.f61103d = jSONObject.optString("tip_text");
            this.f61104e = jSONObject.optString("img");
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
                this.f61100a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                C1547f c1547f = new C1547f();
                c1547f.a(optJSONArray2.optJSONObject(i2));
                this.f61101b.add(c1547f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f61105a = new c();

        /* renamed from: b  reason: collision with root package name */
        public a f61106b = new a();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61105a.a(jSONObject.optJSONObject("member"));
            this.f61106b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f61107a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<C1547f> f61108b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public String f61109c;

        /* renamed from: d  reason: collision with root package name */
        public String f61110d;

        /* renamed from: e  reason: collision with root package name */
        public String f61111e;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61109c = jSONObject.optString("content");
            this.f61110d = jSONObject.optString("tip_text");
            this.f61111e = jSONObject.optString("img");
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
                this.f61107a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("right");
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                C1547f c1547f = new C1547f();
                c1547f.a(jSONObject3);
                this.f61108b.add(c1547f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f61112a;

        /* renamed from: b  reason: collision with root package name */
        public String f61113b;

        /* renamed from: c  reason: collision with root package name */
        public String f61114c;

        /* renamed from: d  reason: collision with root package name */
        public String f61115d;

        /* renamed from: e  reason: collision with root package name */
        public String f61116e;

        /* renamed from: f  reason: collision with root package name */
        public String f61117f;

        /* renamed from: g  reason: collision with root package name */
        public String f61118g;

        /* renamed from: h  reason: collision with root package name */
        public String f61119h;
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
            this.f61112a = jSONObject.optString("productId");
            this.f61113b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f61114c = jSONObject.optString("discount");
            this.f61115d = jSONObject.optString("original_cost");
            this.f61116e = jSONObject.optString("icon");
            this.i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f61117f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f61118g = jSONObject.optString("payment_pos_key");
            this.f61119h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f61120a;

        /* renamed from: b  reason: collision with root package name */
        public String f61121b;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61120a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f61121b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: d.b.i0.r1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1547f {
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
        public String f61122a;

        /* renamed from: b  reason: collision with root package name */
        public String f61123b;

        /* renamed from: c  reason: collision with root package name */
        public e f61124c = new e();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f61122a = jSONObject.optString("name_show");
            this.f61123b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f61124c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f61098a.a(jSONObject.optJSONObject("user"));
        this.f61099b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
