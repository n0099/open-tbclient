package d.b.i0.e1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.e1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1232a {

        /* renamed from: a  reason: collision with root package name */
        public int f54351a;

        /* renamed from: b  reason: collision with root package name */
        public String f54352b;

        /* renamed from: c  reason: collision with root package name */
        public String f54353c;

        /* renamed from: d  reason: collision with root package name */
        public String f54354d;

        /* renamed from: e  reason: collision with root package name */
        public String f54355e;

        /* renamed from: f  reason: collision with root package name */
        public String f54356f;

        /* renamed from: g  reason: collision with root package name */
        public String f54357g;

        /* renamed from: h  reason: collision with root package name */
        public int f54358h;
    }

    public static C1232a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1232a c1232a = new C1232a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1232a.f54352b = optJSONObject.optString("content");
                c1232a.f54353c = optJSONObject.optString("quote_content");
                c1232a.f54354d = optJSONObject.optString("fname");
                c1232a.f54355e = optJSONObject.optString("thread_id");
                c1232a.f54356f = optJSONObject.optString("post_id");
                c1232a.f54358h = optJSONObject.optInt("type");
                c1232a.f54357g = optJSONObject.optString("title");
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
                    c1232a.f54351a = optJSONObject3.optInt("gender");
                }
            }
            return c1232a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
