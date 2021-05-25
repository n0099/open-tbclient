package d.a.l0.h.m0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.v2.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47476a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47477b = "bbaspg_guide_";

    /* renamed from: c  reason: collision with root package name */
    public static String f47478c = "custom_guide_list";

    /* renamed from: d  reason: collision with root package name */
    public static String f47479d = "appid";

    /* renamed from: e  reason: collision with root package name */
    public static String f47480e = "shown_count";

    /* renamed from: f  reason: collision with root package name */
    public static String f47481f = "image_index";

    /* renamed from: g  reason: collision with root package name */
    public static String f47482g = "last_time";

    /* renamed from: h  reason: collision with root package name */
    public static String f47483h = "reset";

    /* renamed from: i  reason: collision with root package name */
    public static String f47484i = "duration_permission_list";

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (200 != i2 || TextUtils.isEmpty(str)) {
                if (f.f47476a) {
                    Log.e("SwanGameRevisitUtils", "回访引导配置信息下发异常");
                    return;
                }
                return;
            }
            try {
                if (f.f47476a) {
                    Log.d("SwanGameRevisitUtils", "回访引导配置信息 = " + str);
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") != 0) {
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONObject i3 = f.i();
                if (optJSONObject == null || optJSONObject.length() == 0) {
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray(f.f47484i);
                if (optJSONArray != null) {
                    h.a().putString(f.f47484i, optJSONArray.toString());
                }
                if (i3 == null) {
                    f.k(optJSONObject.toString());
                } else if (TextUtils.equals(i3.optString("version"), optJSONObject.optString("version"))) {
                } else {
                    f.g(optJSONObject, i3);
                    f.h(optJSONObject, i3);
                    f.k(optJSONObject.toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (f.f47476a) {
                Log.e("SwanGameRevisitUtils", "请求配置信息失败，err = " + exc.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47485e;

        public b(String str) {
            this.f47485e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a().putString("swan_game_guide_toast", this.f47485e);
        }
    }

    public static void g(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            if (!TextUtils.equals(jSONObject.optString(f47477b + f47483h, "0"), jSONObject2.optString(f47477b + f47483h, "-1"))) {
                jSONObject.put(f47477b + f47480e, "0");
                jSONObject.put(f47477b + f47482g, "0");
                jSONObject.put(f47477b + f47481f, "0");
            } else {
                jSONObject.put(f47477b + f47480e, jSONObject2.optString(f47477b + f47480e, "0"));
                jSONObject.put(f47477b + f47482g, jSONObject2.optString(f47477b + f47482g, "0"));
            }
        } catch (JSONException e2) {
            if (f47476a) {
                e2.printStackTrace();
            }
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray(f47478c)) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray(f47478c)) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString(f47479d, "");
            String optString2 = optJSONObject.optString(f47483h, "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString(f47479d, "-1");
                    String optString4 = optJSONObject2.optString(f47483h, "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put(f47480e, "0");
                                optJSONObject.put(f47482g, "0");
                                optJSONObject.put(f47481f, "0");
                            } else {
                                optJSONObject.put(f47480e, jSONObject2.optString(f47480e, "0"));
                                optJSONObject.put(f47482g, jSONObject2.optString(f47482g, "0"));
                                optJSONObject.put(f47481f, jSONObject2.optString(f47481f, "0"));
                            }
                        } catch (JSONException e2) {
                            if (f47476a) {
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

    public static JSONObject i() {
        String string = h.a().getString("swan_game_guide_toast", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e2) {
            if (f47476a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void j() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            return;
        }
        String q = d.a.l0.h.t.a.b().q();
        i2.X().getRequest().url(q).cookieManager(d.a.l0.a.c1.a.p().a()).requestFrom(16).requestFrom(1605).build().executeAsync(new a());
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f47476a) {
            Log.d("SwanGameRevisitUtils", "回访引导配置信息存入 = " + str);
        }
        q.j(new b(str), "swanGameGuideUpdateRunnable");
    }
}
