package d.a.l0.a.e0.f.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.l0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f41376i = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f41377a;

    /* renamed from: b  reason: collision with root package name */
    public String f41378b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f41379c;

    /* renamed from: d  reason: collision with root package name */
    public String f41380d;

    /* renamed from: e  reason: collision with root package name */
    public String f41381e;

    /* renamed from: f  reason: collision with root package name */
    public String f41382f;

    /* renamed from: g  reason: collision with root package name */
    public String f41383g;

    /* renamed from: h  reason: collision with root package name */
    public long f41384h;

    @NonNull
    public static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41379c = jSONObject.getJSONArray("host");
            cVar.f41378b = jSONObject.getString("appKey");
            cVar.f41377a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f41380d = jSONObject.getString("serverPort");
            cVar.f41382f = jSONObject.getString("wsServerPort");
            Uri.decode(jSONObject.optString("url"));
            cVar.f41383g = jSONObject.optString("notInHistory", "1");
            cVar.f41384h = jSONObject.optLong("coreVersion");
        } catch (JSONException unused) {
            if (f41376i) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
            }
        }
        return cVar;
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f41379c;
        return jSONArray == null ? "" : jSONArray.optString(i2);
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "http://" + str + ":" + this.f41380d + "/app.zip";
    }
}
