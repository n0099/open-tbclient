package d.a.o0.g1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.o0.g1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1404a {

        /* renamed from: a  reason: collision with root package name */
        public int f58802a;

        /* renamed from: b  reason: collision with root package name */
        public String f58803b;

        /* renamed from: c  reason: collision with root package name */
        public String f58804c;

        /* renamed from: d  reason: collision with root package name */
        public String f58805d;

        /* renamed from: e  reason: collision with root package name */
        public String f58806e;

        /* renamed from: f  reason: collision with root package name */
        public String f58807f;

        /* renamed from: g  reason: collision with root package name */
        public String f58808g;

        /* renamed from: h  reason: collision with root package name */
        public int f58809h;
    }

    public static C1404a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1404a c1404a = new C1404a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1404a.f58803b = optJSONObject.optString("content");
                c1404a.f58804c = optJSONObject.optString("quote_content");
                c1404a.f58805d = optJSONObject.optString("fname");
                c1404a.f58806e = optJSONObject.optString("thread_id");
                c1404a.f58807f = optJSONObject.optString("post_id");
                c1404a.f58809h = optJSONObject.optInt("type");
                c1404a.f58808g = optJSONObject.optString("title");
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
                    c1404a.f58802a = optJSONObject3.optInt("gender");
                }
            }
            return c1404a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
