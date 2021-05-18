package d.a.k0.r1.g;

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
    public e f60452a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f60453b = new ArrayList();

    /* renamed from: d.a.k0.r1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1584a {

        /* renamed from: a  reason: collision with root package name */
        public String f60454a;

        /* renamed from: b  reason: collision with root package name */
        public String f60455b;

        /* renamed from: c  reason: collision with root package name */
        public String f60456c;

        /* renamed from: d  reason: collision with root package name */
        public String f60457d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60454a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f60455b = jSONObject.optString("title");
            this.f60456c = jSONObject.optString("desc");
            this.f60457d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f60458a;

        /* renamed from: b  reason: collision with root package name */
        public long f60459b;

        /* renamed from: c  reason: collision with root package name */
        public long f60460c;

        /* renamed from: d  reason: collision with root package name */
        public String f60461d;

        public boolean a() {
            long j = this.f60458a;
            return (j == 1 || j == 2) && this.f60459b > this.f60460c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60458a = jSONObject.optInt("props_id");
            this.f60459b = jSONObject.optLong("end_time");
            this.f60460c = jSONObject.optLong("now_time");
            this.f60461d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f60462a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1584a> f60463b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60462a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1584a c1584a = new C1584a();
                c1584a.a(jSONObject2);
                this.f60463b.add(c1584a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f60464a;

        /* renamed from: b  reason: collision with root package name */
        public long f60465b;

        public boolean a() {
            return this.f60464a >= 0 && this.f60465b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f60464a = jSONObject.optLong("scores_money");
            this.f60465b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f60466a;

        /* renamed from: b  reason: collision with root package name */
        public String f60467b;

        /* renamed from: c  reason: collision with root package name */
        public String f60468c;

        /* renamed from: d  reason: collision with root package name */
        public b f60469d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f60470e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f60466a = jSONObject.optString("id");
            this.f60467b = jSONObject.optString("name");
            this.f60468c = jSONObject.optString("portrait");
            this.f60469d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f60470e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f60452a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f60453b.add(cVar);
        }
    }
}
