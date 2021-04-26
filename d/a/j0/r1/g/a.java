package d.a.j0.r1.g;

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
    public e f59707a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<c> f59708b = new ArrayList();

    /* renamed from: d.a.j0.r1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1510a {

        /* renamed from: a  reason: collision with root package name */
        public String f59709a;

        /* renamed from: b  reason: collision with root package name */
        public String f59710b;

        /* renamed from: c  reason: collision with root package name */
        public String f59711c;

        /* renamed from: d  reason: collision with root package name */
        public String f59712d;

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59709a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f59710b = jSONObject.optString("title");
            this.f59711c = jSONObject.optString("desc");
            this.f59712d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f59713a;

        /* renamed from: b  reason: collision with root package name */
        public long f59714b;

        /* renamed from: c  reason: collision with root package name */
        public long f59715c;

        /* renamed from: d  reason: collision with root package name */
        public String f59716d;

        public boolean a() {
            long j = this.f59713a;
            return (j == 1 || j == 2) && this.f59714b > this.f59715c;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59713a = jSONObject.optInt("props_id");
            this.f59714b = jSONObject.optLong("end_time");
            this.f59715c = jSONObject.optLong("now_time");
            this.f59716d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f59717a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1510a> f59718b = new ArrayList<>();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59717a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1510a c1510a = new C1510a();
                c1510a.a(jSONObject2);
                this.f59718b.add(c1510a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f59719a;

        /* renamed from: b  reason: collision with root package name */
        public long f59720b;

        public boolean a() {
            return this.f59719a >= 0 && this.f59720b >= 0;
        }

        public void b(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f59719a = jSONObject.optLong("scores_money");
            this.f59720b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f59721a;

        /* renamed from: b  reason: collision with root package name */
        public String f59722b;

        /* renamed from: c  reason: collision with root package name */
        public String f59723c;

        /* renamed from: d  reason: collision with root package name */
        public b f59724d = new b();

        /* renamed from: e  reason: collision with root package name */
        public d f59725e = new d();

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f59721a = jSONObject.optString("id");
            this.f59722b = jSONObject.optString("name");
            this.f59723c = jSONObject.optString("portrait");
            this.f59724d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f59725e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f59707a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f59708b.add(cVar);
        }
    }
}
