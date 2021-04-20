package d.b.i0.f1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.f1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1292a {

        /* renamed from: a  reason: collision with root package name */
        public int f55793a;

        /* renamed from: b  reason: collision with root package name */
        public String f55794b;

        /* renamed from: c  reason: collision with root package name */
        public String f55795c;

        /* renamed from: d  reason: collision with root package name */
        public String f55796d;

        /* renamed from: e  reason: collision with root package name */
        public String f55797e;

        /* renamed from: f  reason: collision with root package name */
        public String f55798f;

        /* renamed from: g  reason: collision with root package name */
        public String f55799g;

        /* renamed from: h  reason: collision with root package name */
        public int f55800h;
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
                optJSONObject.optString("title");
                c1292a.f55794b = optJSONObject.optString("content");
                c1292a.f55795c = optJSONObject.optString("quote_content");
                c1292a.f55796d = optJSONObject.optString("fname");
                c1292a.f55797e = optJSONObject.optString("thread_id");
                c1292a.f55798f = optJSONObject.optString("post_id");
                c1292a.f55800h = optJSONObject.optInt("type");
                c1292a.f55799g = optJSONObject.optString("title");
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
                    c1292a.f55793a = optJSONObject3.optInt("gender");
                }
            }
            return c1292a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
