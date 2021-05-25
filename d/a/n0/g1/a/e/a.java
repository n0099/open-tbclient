package d.a.n0.g1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.n0.g1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1344a {

        /* renamed from: a  reason: collision with root package name */
        public int f54988a;

        /* renamed from: b  reason: collision with root package name */
        public String f54989b;

        /* renamed from: c  reason: collision with root package name */
        public String f54990c;

        /* renamed from: d  reason: collision with root package name */
        public String f54991d;

        /* renamed from: e  reason: collision with root package name */
        public String f54992e;

        /* renamed from: f  reason: collision with root package name */
        public String f54993f;

        /* renamed from: g  reason: collision with root package name */
        public String f54994g;

        /* renamed from: h  reason: collision with root package name */
        public int f54995h;
    }

    public static C1344a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1344a c1344a = new C1344a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1344a.f54989b = optJSONObject.optString("content");
                c1344a.f54990c = optJSONObject.optString("quote_content");
                c1344a.f54991d = optJSONObject.optString("fname");
                c1344a.f54992e = optJSONObject.optString("thread_id");
                c1344a.f54993f = optJSONObject.optString("post_id");
                c1344a.f54995h = optJSONObject.optInt("type");
                c1344a.f54994g = optJSONObject.optString("title");
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
                    c1344a.f54988a = optJSONObject3.optInt("gender");
                }
            }
            return c1344a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
