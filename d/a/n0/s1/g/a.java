package d.a.n0.s1.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e f64266a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f64267b = new ArrayList();

    /* renamed from: d.a.n0.s1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1652a {

        /* renamed from: a  reason: collision with root package name */
        public String f64268a;

        /* renamed from: b  reason: collision with root package name */
        public String f64269b;

        /* renamed from: c  reason: collision with root package name */
        public String f64270c;

        /* renamed from: d  reason: collision with root package name */
        public String f64271d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64268a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f64269b = jSONObject.optString("title");
            this.f64270c = jSONObject.optString("desc");
            this.f64271d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f64272a;

        /* renamed from: b  reason: collision with root package name */
        public long f64273b;

        /* renamed from: c  reason: collision with root package name */
        public long f64274c;

        /* renamed from: d  reason: collision with root package name */
        public String f64275d;

        public boolean a() {
            long j = this.f64272a;
            return (j == 1 || j == 2) && this.f64273b > this.f64274c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64272a = jSONObject.optInt("props_id");
            this.f64273b = jSONObject.optLong(ResultTB.ENDTIME);
            this.f64274c = jSONObject.optLong("now_time");
            this.f64275d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f64276a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1652a> f64277b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64276a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1652a c1652a = new C1652a();
                c1652a.a(jSONObject2);
                this.f64277b.add(c1652a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f64278a;

        /* renamed from: b  reason: collision with root package name */
        public long f64279b;

        public boolean a() {
            return this.f64278a >= 0 && this.f64279b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f64278a = jSONObject.optLong("scores_money");
            this.f64279b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f64280a;

        /* renamed from: b  reason: collision with root package name */
        public String f64281b;

        /* renamed from: c  reason: collision with root package name */
        public String f64282c;

        /* renamed from: d  reason: collision with root package name */
        public b f64283d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f64284e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f64280a = jSONObject.optString("id");
            this.f64281b = jSONObject.optString("name");
            this.f64282c = jSONObject.optString("portrait");
            this.f64283d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f64284e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f64266a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f64267b.add(cVar);
        }
    }
}
