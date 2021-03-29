package d.b.i0.e1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.i0.e1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1233a {

        /* renamed from: a  reason: collision with root package name */
        public int f54352a;

        /* renamed from: b  reason: collision with root package name */
        public String f54353b;

        /* renamed from: c  reason: collision with root package name */
        public String f54354c;

        /* renamed from: d  reason: collision with root package name */
        public String f54355d;

        /* renamed from: e  reason: collision with root package name */
        public String f54356e;

        /* renamed from: f  reason: collision with root package name */
        public String f54357f;

        /* renamed from: g  reason: collision with root package name */
        public String f54358g;

        /* renamed from: h  reason: collision with root package name */
        public int f54359h;
    }

    public static C1233a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1233a c1233a = new C1233a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1233a.f54353b = optJSONObject.optString("content");
                c1233a.f54354c = optJSONObject.optString("quote_content");
                c1233a.f54355d = optJSONObject.optString("fname");
                c1233a.f54356e = optJSONObject.optString("thread_id");
                c1233a.f54357f = optJSONObject.optString("post_id");
                c1233a.f54359h = optJSONObject.optInt("type");
                c1233a.f54358g = optJSONObject.optString("title");
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
                    c1233a.f54352a = optJSONObject3.optInt("gender");
                }
            }
            return c1233a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
