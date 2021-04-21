package d.b.j0.r1.g;

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
    public e f61555a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f61556b = new ArrayList();

    /* renamed from: d.b.j0.r1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1571a {

        /* renamed from: a  reason: collision with root package name */
        public String f61557a;

        /* renamed from: b  reason: collision with root package name */
        public String f61558b;

        /* renamed from: c  reason: collision with root package name */
        public String f61559c;

        /* renamed from: d  reason: collision with root package name */
        public String f61560d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61557a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f61558b = jSONObject.optString("title");
            this.f61559c = jSONObject.optString("desc");
            this.f61560d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f61561a;

        /* renamed from: b  reason: collision with root package name */
        public long f61562b;

        /* renamed from: c  reason: collision with root package name */
        public long f61563c;

        /* renamed from: d  reason: collision with root package name */
        public String f61564d;

        public boolean a() {
            long j = this.f61561a;
            return (j == 1 || j == 2) && this.f61562b > this.f61563c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61561a = jSONObject.optInt("props_id");
            this.f61562b = jSONObject.optLong("end_time");
            this.f61563c = jSONObject.optLong("now_time");
            this.f61564d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f61565a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1571a> f61566b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61565a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                C1571a c1571a = new C1571a();
                c1571a.a(jSONObject2);
                this.f61566b.add(c1571a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f61567a;

        /* renamed from: b  reason: collision with root package name */
        public long f61568b;

        public boolean a() {
            return this.f61567a >= 0 && this.f61568b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f61567a = jSONObject.optLong("scores_money");
            this.f61568b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f61569a;

        /* renamed from: b  reason: collision with root package name */
        public String f61570b;

        /* renamed from: c  reason: collision with root package name */
        public String f61571c;

        /* renamed from: d  reason: collision with root package name */
        public b f61572d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f61573e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f61569a = jSONObject.optString("id");
            this.f61570b = jSONObject.optString("name");
            this.f61571c = jSONObject.optString("portrait");
            this.f61572d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f61573e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f61555a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i));
            this.f61556b.add(cVar);
        }
    }
}
