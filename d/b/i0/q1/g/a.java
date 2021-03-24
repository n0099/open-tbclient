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
    public e f59439a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f59440b = new ArrayList();

    /* renamed from: d.b.i0.q1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1483a {

        /* renamed from: a  reason: collision with root package name */
        public String f59441a;

        /* renamed from: b  reason: collision with root package name */
        public String f59442b;

        /* renamed from: c  reason: collision with root package name */
        public String f59443c;

        /* renamed from: d  reason: collision with root package name */
        public String f59444d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59441a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f59442b = jSONObject.optString("title");
            this.f59443c = jSONObject.optString("desc");
            this.f59444d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f59445a;

        /* renamed from: b  reason: collision with root package name */
        public long f59446b;

        /* renamed from: c  reason: collision with root package name */
        public long f59447c;

        /* renamed from: d  reason: collision with root package name */
        public String f59448d;

        public boolean a() {
            long j = this.f59445a;
            return (j == 1 || j == 2) && this.f59446b > this.f59447c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59445a = jSONObject.optInt("props_id");
            this.f59446b = jSONObject.optLong("end_time");
            this.f59447c = jSONObject.optLong("now_time");
            this.f59448d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f59449a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1483a> f59450b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59449a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                C1483a c1483a = new C1483a();
                c1483a.a(jSONObject2);
                this.f59450b.add(c1483a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f59451a;

        /* renamed from: b  reason: collision with root package name */
        public long f59452b;

        public boolean a() {
            return this.f59451a >= 0 && this.f59452b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f59451a = jSONObject.optLong("scores_money");
            this.f59452b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f59453a;

        /* renamed from: b  reason: collision with root package name */
        public String f59454b;

        /* renamed from: c  reason: collision with root package name */
        public String f59455c;

        /* renamed from: d  reason: collision with root package name */
        public b f59456d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f59457e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59453a = jSONObject.optString("id");
            this.f59454b = jSONObject.optString("name");
            this.f59455c = jSONObject.optString("portrait");
            this.f59456d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f59457e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f59439a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i));
            this.f59440b.add(cVar);
        }
    }
}
