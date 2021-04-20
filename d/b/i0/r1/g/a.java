package d.b.i0.r1.g;

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
    public e f61134a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f61135b = new ArrayList();

    /* renamed from: d.b.i0.r1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1548a {

        /* renamed from: a  reason: collision with root package name */
        public String f61136a;

        /* renamed from: b  reason: collision with root package name */
        public String f61137b;

        /* renamed from: c  reason: collision with root package name */
        public String f61138c;

        /* renamed from: d  reason: collision with root package name */
        public String f61139d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61136a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f61137b = jSONObject.optString("title");
            this.f61138c = jSONObject.optString("desc");
            this.f61139d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f61140a;

        /* renamed from: b  reason: collision with root package name */
        public long f61141b;

        /* renamed from: c  reason: collision with root package name */
        public long f61142c;

        /* renamed from: d  reason: collision with root package name */
        public String f61143d;

        public boolean a() {
            long j = this.f61140a;
            return (j == 1 || j == 2) && this.f61141b > this.f61142c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61140a = jSONObject.optInt("props_id");
            this.f61141b = jSONObject.optLong("end_time");
            this.f61142c = jSONObject.optLong("now_time");
            this.f61143d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f61144a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1548a> f61145b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61144a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                C1548a c1548a = new C1548a();
                c1548a.a(jSONObject2);
                this.f61145b.add(c1548a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f61146a;

        /* renamed from: b  reason: collision with root package name */
        public long f61147b;

        public boolean a() {
            return this.f61146a >= 0 && this.f61147b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f61146a = jSONObject.optLong("scores_money");
            this.f61147b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f61148a;

        /* renamed from: b  reason: collision with root package name */
        public String f61149b;

        /* renamed from: c  reason: collision with root package name */
        public String f61150c;

        /* renamed from: d  reason: collision with root package name */
        public b f61151d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f61152e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61148a = jSONObject.optString("id");
            this.f61149b = jSONObject.optString("name");
            this.f61150c = jSONObject.optString("portrait");
            this.f61151d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f61152e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f61134a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i));
            this.f61135b.add(cVar);
        }
    }
}
