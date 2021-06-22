package d.a.o0.s1.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f64391a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f64392b = new ArrayList();

    /* renamed from: d.a.o0.s1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1656a {

        /* renamed from: a  reason: collision with root package name */
        public String f64393a;

        /* renamed from: b  reason: collision with root package name */
        public String f64394b;

        /* renamed from: c  reason: collision with root package name */
        public String f64395c;

        /* renamed from: d  reason: collision with root package name */
        public String f64396d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64393a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f64394b = jSONObject.optString("title");
            this.f64395c = jSONObject.optString("desc");
            this.f64396d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f64397a;

        /* renamed from: b  reason: collision with root package name */
        public long f64398b;

        /* renamed from: c  reason: collision with root package name */
        public long f64399c;

        /* renamed from: d  reason: collision with root package name */
        public String f64400d;

        public boolean a() {
            long j = this.f64397a;
            return (j == 1 || j == 2) && this.f64398b > this.f64399c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64397a = jSONObject.optInt("props_id");
            this.f64398b = jSONObject.optLong(ResultTB.ENDTIME);
            this.f64399c = jSONObject.optLong("now_time");
            this.f64400d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f64401a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1656a> f64402b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64401a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1656a c1656a = new C1656a();
                c1656a.a(jSONObject2);
                this.f64402b.add(c1656a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f64403a;

        /* renamed from: b  reason: collision with root package name */
        public long f64404b;

        public boolean a() {
            return this.f64403a >= 0 && this.f64404b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f64403a = jSONObject.optLong("scores_money");
            this.f64404b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f64405a;

        /* renamed from: b  reason: collision with root package name */
        public String f64406b;

        /* renamed from: c  reason: collision with root package name */
        public String f64407c;

        /* renamed from: d  reason: collision with root package name */
        public b f64408d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f64409e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64405a = jSONObject.optString("id");
            this.f64406b = jSONObject.optString("name");
            this.f64407c = jSONObject.optString("portrait");
            this.f64408d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f64409e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f64391a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f64392b.add(cVar);
        }
    }
}
