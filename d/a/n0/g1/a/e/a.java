package d.a.n0.g1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.n0.g1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1400a {

        /* renamed from: a  reason: collision with root package name */
        public int f58677a;

        /* renamed from: b  reason: collision with root package name */
        public String f58678b;

        /* renamed from: c  reason: collision with root package name */
        public String f58679c;

        /* renamed from: d  reason: collision with root package name */
        public String f58680d;

        /* renamed from: e  reason: collision with root package name */
        public String f58681e;

        /* renamed from: f  reason: collision with root package name */
        public String f58682f;

        /* renamed from: g  reason: collision with root package name */
        public String f58683g;

        /* renamed from: h  reason: collision with root package name */
        public int f58684h;
    }

    public static C1400a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1400a c1400a = new C1400a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1400a.f58678b = optJSONObject.optString("content");
                c1400a.f58679c = optJSONObject.optString("quote_content");
                c1400a.f58680d = optJSONObject.optString("fname");
                c1400a.f58681e = optJSONObject.optString("thread_id");
                c1400a.f58682f = optJSONObject.optString("post_id");
                c1400a.f58684h = optJSONObject.optInt("type");
                c1400a.f58683g = optJSONObject.optString("title");
                optJSONObject.optInt("thread_type");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("quote_user");
                if (optJSONObject2 != null) {
                    optJSONObject2.optString("id");
                    optJSONObject2.optString("portrait");
                    optJSONObject2.optInt("gender");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("replyer");
                if (optJSONObject3 != null) {
                    optJSONObject3.optString("id");
                    c1400a.f58677a = optJSONObject3.optInt("gender");
                }
            }
            return c1400a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
