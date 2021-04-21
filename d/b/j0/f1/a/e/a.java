package d.b.j0.f1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.j0.f1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1315a {

        /* renamed from: a  reason: collision with root package name */
        public int f56214a;

        /* renamed from: b  reason: collision with root package name */
        public String f56215b;

        /* renamed from: c  reason: collision with root package name */
        public String f56216c;

        /* renamed from: d  reason: collision with root package name */
        public String f56217d;

        /* renamed from: e  reason: collision with root package name */
        public String f56218e;

        /* renamed from: f  reason: collision with root package name */
        public String f56219f;

        /* renamed from: g  reason: collision with root package name */
        public String f56220g;

        /* renamed from: h  reason: collision with root package name */
        public int f56221h;
    }

    public static C1315a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1315a c1315a = new C1315a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1315a.f56215b = optJSONObject.optString("content");
                c1315a.f56216c = optJSONObject.optString("quote_content");
                c1315a.f56217d = optJSONObject.optString("fname");
                c1315a.f56218e = optJSONObject.optString("thread_id");
                c1315a.f56219f = optJSONObject.optString("post_id");
                c1315a.f56221h = optJSONObject.optInt("type");
                c1315a.f56220g = optJSONObject.optString("title");
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
                    c1315a.f56214a = optJSONObject3.optInt("gender");
                }
            }
            return c1315a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
