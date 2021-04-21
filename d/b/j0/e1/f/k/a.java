package d.b.j0.e1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.j0.e1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1281a {

        /* renamed from: d  reason: collision with root package name */
        public long f55694d;

        /* renamed from: e  reason: collision with root package name */
        public String f55695e;

        /* renamed from: a  reason: collision with root package name */
        public String f55691a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55692b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f55693c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f55696f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f55697g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f55698h = 0;
        public int i = 0;
        public int j = 0;
    }

    public static C1281a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1281a c1281a = new C1281a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1281a.f55691a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1281a.f55692b = optJSONObject.optString("user_id");
                c1281a.f55693c = optJSONObject.optString("nick_name");
                c1281a.f55694d = optJSONObject.optLong("caller_time");
                c1281a.f55695e = optJSONObject.optString("caller_content");
                c1281a.f55696f = optJSONObject.optLong("thread_id");
                c1281a.f55697g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1281a.f55698h = optJSONObject.optLong("post_id");
                c1281a.i = optJSONObject.optInt("msg_type");
                c1281a.j = optJSONObject.optInt("remind_count");
            }
            return c1281a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
