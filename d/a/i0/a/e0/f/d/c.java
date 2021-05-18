package d.a.i0.a.e0.f.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.i0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f41202i = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f41203a;

    /* renamed from: b  reason: collision with root package name */
    public String f41204b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f41205c;

    /* renamed from: d  reason: collision with root package name */
    public String f41206d;

    /* renamed from: e  reason: collision with root package name */
    public String f41207e;

    /* renamed from: f  reason: collision with root package name */
    public String f41208f;

    /* renamed from: g  reason: collision with root package name */
    public String f41209g;

    /* renamed from: h  reason: collision with root package name */
    public long f41210h;

    @NonNull
    public static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41205c = jSONObject.getJSONArray("host");
            cVar.f41204b = jSONObject.getString("appKey");
            cVar.f41203a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f41206d = jSONObject.getString("serverPort");
            cVar.f41208f = jSONObject.getString("wsServerPort");
            Uri.decode(jSONObject.optString("url"));
            cVar.f41209g = jSONObject.optString("notInHistory", "1");
            cVar.f41210h = jSONObject.optLong("coreVersion");
        } catch (JSONException unused) {
            if (f41202i) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
            }
        }
        return cVar;
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f41205c;
        return jSONArray == null ? "" : jSONArray.optString(i2);
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "http://" + str + ":" + this.f41206d + "/app.zip";
    }
}
