package d.a.k0.f1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.k0.f1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1326a {

        /* renamed from: a  reason: collision with root package name */
        public int f54800a;

        /* renamed from: b  reason: collision with root package name */
        public String f54801b;

        /* renamed from: c  reason: collision with root package name */
        public String f54802c;

        /* renamed from: d  reason: collision with root package name */
        public String f54803d;

        /* renamed from: e  reason: collision with root package name */
        public String f54804e;

        /* renamed from: f  reason: collision with root package name */
        public String f54805f;

        /* renamed from: g  reason: collision with root package name */
        public String f54806g;

        /* renamed from: h  reason: collision with root package name */
        public int f54807h;
    }

    public static C1326a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1326a c1326a = new C1326a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1326a.f54801b = optJSONObject.optString("content");
                c1326a.f54802c = optJSONObject.optString("quote_content");
                c1326a.f54803d = optJSONObject.optString("fname");
                c1326a.f54804e = optJSONObject.optString("thread_id");
                c1326a.f54805f = optJSONObject.optString("post_id");
                c1326a.f54807h = optJSONObject.optInt("type");
                c1326a.f54806g = optJSONObject.optString("title");
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
                    c1326a.f54800a = optJSONObject3.optInt("gender");
                }
            }
            return c1326a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
