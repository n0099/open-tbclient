package d.b.i0.q1.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f59440a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f59441b = new ArrayList();

    /* renamed from: d.b.i0.q1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1484a {

        /* renamed from: a  reason: collision with root package name */
        public String f59442a;

        /* renamed from: b  reason: collision with root package name */
        public String f59443b;

        /* renamed from: c  reason: collision with root package name */
        public String f59444c;

        /* renamed from: d  reason: collision with root package name */
        public String f59445d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59442a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f59443b = jSONObject.optString("title");
            this.f59444c = jSONObject.optString("desc");
            this.f59445d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f59446a;

        /* renamed from: b  reason: collision with root package name */
        public long f59447b;

        /* renamed from: c  reason: collision with root package name */
        public long f59448c;

        /* renamed from: d  reason: collision with root package name */
        public String f59449d;

        public boolean a() {
            long j = this.f59446a;
            return (j == 1 || j == 2) && this.f59447b > this.f59448c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59446a = jSONObject.optInt("props_id");
            this.f59447b = jSONObject.optLong("end_time");
            this.f59448c = jSONObject.optLong("now_time");
            this.f59449d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f59450a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1484a> f59451b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59450a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                C1484a c1484a = new C1484a();
                c1484a.a(jSONObject2);
                this.f59451b.add(c1484a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f59452a;

        /* renamed from: b  reason: collision with root package name */
        public long f59453b;

        public boolean a() {
            return this.f59452a >= 0 && this.f59453b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f59452a = jSONObject.optLong("scores_money");
            this.f59453b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f59454a;

        /* renamed from: b  reason: collision with root package name */
        public String f59455b;

        /* renamed from: c  reason: collision with root package name */
        public String f59456c;

        /* renamed from: d  reason: collision with root package name */
        public b f59457d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f59458e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59454a = jSONObject.optString("id");
            this.f59455b = jSONObject.optString("name");
            this.f59456c = jSONObject.optString("portrait");
            this.f59457d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f59458e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f59440a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i));
            this.f59441b.add(cVar);
        }
    }
}
