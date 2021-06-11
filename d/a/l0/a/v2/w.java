package d.a.l0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.JSONUtils;
import com.baidu.tbadk.core.util.StringHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49178a = d.a.l0.a.k.f46875a;

    public static <T> T a(JSONObject jSONObject, String str, Class<T> cls) {
        if (jSONObject == null) {
            return null;
        }
        T t = (T) jSONObject.opt(str);
        if (cls.isInstance(t)) {
            if (f49178a) {
                String obj = t.toString();
                if (((t instanceof JSONObject) || (t instanceof JSONArray)) && obj.length() > 30) {
                    obj = obj.substring(0, 30) + StringHelper.STRING_MORE;
                }
                if (f49178a) {
                    Log.d(JSONUtils.TAG, "json: " + str + "=" + obj);
                }
            }
            return t;
        }
        if (f49178a) {
            if (t == null) {
                Log.w(JSONUtils.TAG, "Json has no value by name: '" + str + "'!");
            } else {
                Log.w(JSONUtils.TAG, "Value of '" + str + "' is not a instance of '" + cls.getSimpleName() + "'!");
            }
        }
        return null;
    }

    public static float b(JSONObject jSONObject, String str, float f2) {
        return jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2);
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        return (JSONArray) a(jSONObject, str, JSONArray.class);
    }

    @NonNull
    public static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f49178a) {
                Log.w(JSONUtils.TAG, "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }

    public static JSONArray e(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e2) {
            if (f49178a) {
                Log.w(JSONUtils.TAG, "JSONArray parsed error!!", e2);
            }
            return new JSONArray();
        }
    }

    public static JSONObject f(JSONObject jSONObject, String str, Object obj) {
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
