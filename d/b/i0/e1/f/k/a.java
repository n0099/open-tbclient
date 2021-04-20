package d.b.i0.e1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.e1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1258a {

        /* renamed from: d  reason: collision with root package name */
        public long f55273d;

        /* renamed from: e  reason: collision with root package name */
        public String f55274e;

        /* renamed from: a  reason: collision with root package name */
        public String f55270a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55271b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f55272c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f55275f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f55276g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f55277h = 0;
        public int i = 0;
        public int j = 0;
    }

    public static C1258a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1258a c1258a = new C1258a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1258a.f55270a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1258a.f55271b = optJSONObject.optString("user_id");
                c1258a.f55272c = optJSONObject.optString("nick_name");
                c1258a.f55273d = optJSONObject.optLong("caller_time");
                c1258a.f55274e = optJSONObject.optString("caller_content");
                c1258a.f55275f = optJSONObject.optLong("thread_id");
                c1258a.f55276g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1258a.f55277h = optJSONObject.optLong("post_id");
                c1258a.i = optJSONObject.optInt("msg_type");
                c1258a.j = optJSONObject.optInt("remind_count");
            }
            return c1258a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
