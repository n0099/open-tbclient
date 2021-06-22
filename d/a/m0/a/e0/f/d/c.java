package d.a.m0.a.e0.f.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.m0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45160i = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f45161a;

    /* renamed from: b  reason: collision with root package name */
    public String f45162b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f45163c;

    /* renamed from: d  reason: collision with root package name */
    public String f45164d;

    /* renamed from: e  reason: collision with root package name */
    public String f45165e;

    /* renamed from: f  reason: collision with root package name */
    public String f45166f;

    /* renamed from: g  reason: collision with root package name */
    public String f45167g;

    /* renamed from: h  reason: collision with root package name */
    public long f45168h;

    @NonNull
    public static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f45163c = jSONObject.getJSONArray("host");
            cVar.f45162b = jSONObject.getString("appKey");
            cVar.f45161a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f45164d = jSONObject.getString("serverPort");
            cVar.f45166f = jSONObject.getString("wsServerPort");
            Uri.decode(jSONObject.optString("url"));
            cVar.f45167g = jSONObject.optString("notInHistory", "1");
            cVar.f45168h = jSONObject.optLong("coreVersion");
        } catch (JSONException unused) {
            if (f45160i) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
            }
        }
        return cVar;
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f45163c;
        return jSONArray == null ? "" : jSONArray.optString(i2);
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "http://" + str + ":" + this.f45164d + "/app.zip";
    }
}
