package d.a.o0.f1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.o0.f1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1370a {

        /* renamed from: d  reason: collision with root package name */
        public long f58259d;

        /* renamed from: e  reason: collision with root package name */
        public String f58260e;

        /* renamed from: a  reason: collision with root package name */
        public String f58256a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f58257b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f58258c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f58261f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f58262g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f58263h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f58264i = 0;
        public int j = 0;
    }

    public static C1370a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1370a c1370a = new C1370a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1370a.f58256a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1370a.f58257b = optJSONObject.optString("user_id");
                c1370a.f58258c = optJSONObject.optString("nick_name");
                c1370a.f58259d = optJSONObject.optLong("caller_time");
                c1370a.f58260e = optJSONObject.optString("caller_content");
                c1370a.f58261f = optJSONObject.optLong("thread_id");
                c1370a.f58262g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1370a.f58263h = optJSONObject.optLong("post_id");
                c1370a.f58264i = optJSONObject.optInt("msg_type");
                c1370a.j = optJSONObject.optInt("remind_count");
            }
            return c1370a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
