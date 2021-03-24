package d.b.g0.a.i2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.JSONUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44790a = d.b.g0.a.k.f45050a;

    public static float a(JSONObject jSONObject, String str, float f2) {
        return jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2);
    }

    public static JSONObject b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f44790a) {
                Log.w(JSONUtils.TAG, "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }

    public static JSONArray c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e2) {
            if (f44790a) {
                Log.w(JSONUtils.TAG, "JSONArray parsed error!!", e2);
            }
            return new JSONArray();
        }
    }

    public static JSONObject d(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
