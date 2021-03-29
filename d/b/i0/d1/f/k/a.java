package d.b.i0.d1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.i0.d1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1195a {

        /* renamed from: d  reason: collision with root package name */
        public long f53751d;

        /* renamed from: e  reason: collision with root package name */
        public String f53752e;

        /* renamed from: a  reason: collision with root package name */
        public String f53748a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53749b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f53750c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f53753f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f53754g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f53755h = 0;
        public int i = 0;
        public int j = 0;
    }

    public static C1195a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1195a c1195a = new C1195a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1195a.f53748a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1195a.f53749b = optJSONObject.optString("user_id");
                c1195a.f53750c = optJSONObject.optString("nick_name");
                c1195a.f53751d = optJSONObject.optLong("caller_time");
                c1195a.f53752e = optJSONObject.optString("caller_content");
                c1195a.f53753f = optJSONObject.optLong("thread_id");
                c1195a.f53754g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1195a.f53755h = optJSONObject.optLong("post_id");
                c1195a.i = optJSONObject.optInt("msg_type");
                c1195a.j = optJSONObject.optInt("remind_count");
            }
            return c1195a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
