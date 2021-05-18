package d.a.k0.e1.f.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.k0.e1.f.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1292a {

        /* renamed from: d  reason: collision with root package name */
        public long f54255d;

        /* renamed from: e  reason: collision with root package name */
        public String f54256e;

        /* renamed from: a  reason: collision with root package name */
        public String f54252a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f54253b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f54254c = null;

        /* renamed from: f  reason: collision with root package name */
        public long f54257f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f54258g = null;

        /* renamed from: h  reason: collision with root package name */
        public long f54259h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f54260i = 0;
        public int j = 0;
    }

    public static C1292a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1292a c1292a = new C1292a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                c1292a.f54252a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                c1292a.f54253b = optJSONObject.optString("user_id");
                c1292a.f54254c = optJSONObject.optString("nick_name");
                c1292a.f54255d = optJSONObject.optLong("caller_time");
                c1292a.f54256e = optJSONObject.optString("caller_content");
                c1292a.f54257f = optJSONObject.optLong("thread_id");
                c1292a.f54258g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                optJSONObject.optString("forum_name");
                c1292a.f54259h = optJSONObject.optLong("post_id");
                c1292a.f54260i = optJSONObject.optInt("msg_type");
                c1292a.j = optJSONObject.optInt("remind_count");
            }
            return c1292a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
