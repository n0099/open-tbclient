package d.a.j0.f1.a.e;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.j0.f1.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1254a {

        /* renamed from: a  reason: collision with root package name */
        public int f54093a;

        /* renamed from: b  reason: collision with root package name */
        public String f54094b;

        /* renamed from: c  reason: collision with root package name */
        public String f54095c;

        /* renamed from: d  reason: collision with root package name */
        public String f54096d;

        /* renamed from: e  reason: collision with root package name */
        public String f54097e;

        /* renamed from: f  reason: collision with root package name */
        public String f54098f;

        /* renamed from: g  reason: collision with root package name */
        public String f54099g;

        /* renamed from: h  reason: collision with root package name */
        public int f54100h;
    }

    public static C1254a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1254a c1254a = new C1254a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                optJSONObject.optString("title");
                c1254a.f54094b = optJSONObject.optString("content");
                c1254a.f54095c = optJSONObject.optString("quote_content");
                c1254a.f54096d = optJSONObject.optString("fname");
                c1254a.f54097e = optJSONObject.optString("thread_id");
                c1254a.f54098f = optJSONObject.optString("post_id");
                c1254a.f54100h = optJSONObject.optInt("type");
                c1254a.f54099g = optJSONObject.optString("title");
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
                    c1254a.f54093a = optJSONObject3.optInt("gender");
                }
            }
            return c1254a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
