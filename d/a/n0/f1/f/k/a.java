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
    public static class C1310a {

        /* renamed from: d  reason: collision with root package name */
        public long f54445d;

        /* renamed from: e  reason: collision with root package name */
        public String f54446e;

        /* renamed from: a  reason: collision with root package name */
        public String f54442a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f54443b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f54444c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f54447f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f54448g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f54449h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f54450i = 0;
        public int j = 0;
    }

    public static C1310a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1310a c1310a = new C1310a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1310a.f54442a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1310a.f54443b = optJSONObject.optString("user_id");
                c1310a.f54444c = optJSONObject.optString("nick_name");
                c1310a.f54445d = optJSONObject.optLong("caller_time");
                c1310a.f54446e = optJSONObject.optString("caller_content");
                c1310a.f54447f = optJSONObject.optLong("thread_id");
                c1310a.f54448g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1310a.f54449h = optJSONObject.optLong("post_id");
                c1310a.f54450i = optJSONObject.optInt("msg_type");
                c1310a.j = optJSONObject.optInt("remind_count");
            }
            return c1310a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
