package d.a.i0.a.v0;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.a.v2.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45090a = k.f43025a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45091e;

        public a(String str) {
            this.f45091e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a().putString("swan_guide_toast", this.f45091e);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            if (!TextUtils.equals(jSONObject.optString("bbasp_guide_reset", "0"), jSONObject2.optString("bbasp_guide_reset", "-1"))) {
                jSONObject.put("bbasp_guide_shown_count", "0");
                jSONObject.put("bbasp_guide_last_time", "0");
                jSONObject.put("bbasp_guide_image_index", "0");
            } else {
                jSONObject.put("bbasp_guide_shown_count", jSONObject2.optString("bbasp_guide_shown_count", "0"));
                jSONObject.put("bbasp_guide_last_time", jSONObject2.optString("bbasp_guide_last_time", "0"));
            }
            if (!TextUtils.equals(jSONObject.optString("bbaspg_guide_reset", "0"), jSONObject2.optString("bbaspg_guide_reset", "-1"))) {
                jSONObject.put("bbaspg_guide_shown_count", "0");
                jSONObject.put("bbaspg_guide_last_time", "0");
                jSONObject.put("bbaspg_guide_image_index", "0");
                return;
            }
            jSONObject.put("bbaspg_guide_shown_count", jSONObject2.optString("bbaspg_guide_shown_count", "0"));
            jSONObject.put("bbaspg_guide_last_time", jSONObject2.optString("bbaspg_guide_last_time", "0"));
        } catch (JSONException e2) {
            if (f45090a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray("custom_guide_list")) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray("custom_guide_list")) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString("appid", "");
            String optString2 = optJSONObject.optString("reset", "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString("appid", "-1");
                    String optString4 = optJSONObject2.optString("reset", "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put("shown_count", "0");
                                optJSONObject.put("last_time", "0");
                                optJSONObject.put("image_index", "0");
                            } else {
                                optJSONObject.put("shown_count", jSONObject2.optString("shown_count", "0"));
                                optJSONObject.put("last_time", jSONObject2.optString("last_time", "0"));
                                optJSONObject.put("image_index", jSONObject2.optString("image_index", "0"));
                            }
                        } catch (JSONException e2) {
                            if (f45090a) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        i3++;
                    }
                }
            }
        }
    }

    public static String c() {
        return "guide_pull_toast";
    }

    public static JSONObject d() {
        String string = h.a().getString("swan_guide_toast", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e2) {
            if (f45090a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static String e() {
        String string = h.a().getString("guide_toast_version", "0");
        if (f45090a) {
            Log.d("SwanAppGuideToast", "version = " + string);
        }
        return string;
    }

    public static void f(JSONObject jSONObject) {
        if (f45090a) {
            Log.d("SwanAppGuideToast", "processGuide guideObject = " + jSONObject);
        }
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null || TextUtils.equals(e(), optString)) {
            return;
        }
        JSONObject d2 = d();
        if (d2 == null) {
            g(optJSONObject.toString());
            return;
        }
        a(optJSONObject, d2);
        b(optJSONObject, d2);
        g(optJSONObject.toString());
        h.a().putString("guide_toast_version", optString);
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new a(str), "swanGuideUpdateRunnable");
    }
}
