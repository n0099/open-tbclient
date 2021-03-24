package d.b.i0.d1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.d1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1194a {

        /* renamed from: d  reason: collision with root package name */
        public long f53750d;

        /* renamed from: e  reason: collision with root package name */
        public String f53751e;

        /* renamed from: a  reason: collision with root package name */
        public String f53747a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53748b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f53749c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f53752f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f53753g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f53754h = 0;
        public int i = 0;
        public int j = 0;
    }

    public static C1194a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1194a c1194a = new C1194a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1194a.f53747a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1194a.f53748b = optJSONObject.optString("user_id");
                c1194a.f53749c = optJSONObject.optString("nick_name");
                c1194a.f53750d = optJSONObject.optLong("caller_time");
                c1194a.f53751e = optJSONObject.optString("caller_content");
                c1194a.f53752f = optJSONObject.optLong("thread_id");
                c1194a.f53753g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1194a.f53754h = optJSONObject.optLong("post_id");
                c1194a.i = optJSONObject.optInt("msg_type");
                c1194a.j = optJSONObject.optInt("remind_count");
            }
            return c1194a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
