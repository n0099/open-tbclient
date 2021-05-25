package d.a.n0.s1.g;

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
    public e f60575a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f60576b = new ArrayList();

    /* renamed from: d.a.n0.s1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1596a {

        /* renamed from: a  reason: collision with root package name */
        public String f60577a;

        /* renamed from: b  reason: collision with root package name */
        public String f60578b;

        /* renamed from: c  reason: collision with root package name */
        public String f60579c;

        /* renamed from: d  reason: collision with root package name */
        public String f60580d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60577a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f60578b = jSONObject.optString("title");
            this.f60579c = jSONObject.optString("desc");
            this.f60580d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f60581a;

        /* renamed from: b  reason: collision with root package name */
        public long f60582b;

        /* renamed from: c  reason: collision with root package name */
        public long f60583c;

        /* renamed from: d  reason: collision with root package name */
        public String f60584d;

        public boolean a() {
            long j = this.f60581a;
            return (j == 1 || j == 2) && this.f60582b > this.f60583c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60581a = jSONObject.optInt("props_id");
            this.f60582b = jSONObject.optLong("end_time");
            this.f60583c = jSONObject.optLong("now_time");
            this.f60584d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f60585a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1596a> f60586b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60585a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1596a c1596a = new C1596a();
                c1596a.a(jSONObject2);
                this.f60586b.add(c1596a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f60587a;

        /* renamed from: b  reason: collision with root package name */
        public long f60588b;

        public boolean a() {
            return this.f60587a >= 0 && this.f60588b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f60587a = jSONObject.optLong("scores_money");
            this.f60588b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f60589a;

        /* renamed from: b  reason: collision with root package name */
        public String f60590b;

        /* renamed from: c  reason: collision with root package name */
        public String f60591c;

        /* renamed from: d  reason: collision with root package name */
        public b f60592d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f60593e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60589a = jSONObject.optString("id");
            this.f60590b = jSONObject.optString("name");
            this.f60591c = jSONObject.optString("portrait");
            this.f60592d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f60593e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f60575a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f60576b.add(cVar);
        }
    }
}
