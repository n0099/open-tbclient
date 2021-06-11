package d.a.n0.f1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.n0.f1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1366a {

        /* renamed from: d  reason: collision with root package name */
        public long f58134d;

        /* renamed from: e  reason: collision with root package name */
        public String f58135e;

        /* renamed from: a  reason: collision with root package name */
        public String f58131a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f58132b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f58133c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f58136f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f58137g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f58138h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f58139i = 0;
        public int j = 0;
    }

    public static C1366a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1366a c1366a = new C1366a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1366a.f58131a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1366a.f58132b = optJSONObject.optString("user_id");
                c1366a.f58133c = optJSONObject.optString("nick_name");
                c1366a.f58134d = optJSONObject.optLong("caller_time");
                c1366a.f58135e = optJSONObject.optString("caller_content");
                c1366a.f58136f = optJSONObject.optLong("thread_id");
                c1366a.f58137g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1366a.f58138h = optJSONObject.optLong("post_id");
                c1366a.f58139i = optJSONObject.optInt("msg_type");
                c1366a.j = optJSONObject.optInt("remind_count");
            }
            return c1366a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
