package d.a.j0.e1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.j0.e1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1220a {

        /* renamed from: d  reason: collision with root package name */
        public long f53548d;

        /* renamed from: e  reason: collision with root package name */
        public String f53549e;

        /* renamed from: a  reason: collision with root package name */
        public String f53545a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53546b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f53547c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f53550f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f53551g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f53552h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f53553i = 0;
        public int j = 0;
    }

    public static C1220a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1220a c1220a = new C1220a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1220a.f53545a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1220a.f53546b = optJSONObject.optString("user_id");
                c1220a.f53547c = optJSONObject.optString("nick_name");
                c1220a.f53548d = optJSONObject.optLong("caller_time");
                c1220a.f53549e = optJSONObject.optString("caller_content");
                c1220a.f53550f = optJSONObject.optLong("thread_id");
                c1220a.f53551g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1220a.f53552h = optJSONObject.optLong("post_id");
                c1220a.f53553i = optJSONObject.optInt("msg_type");
                c1220a.j = optJSONObject.optInt("remind_count");
            }
            return c1220a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
