package d.a.m0.a.e0.f.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.m0.a.k;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45226e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f45227a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f45228b;

    /* renamed from: c  reason: collision with root package name */
    public String f45229c;

    /* renamed from: d  reason: collision with root package name */
    public String f45230d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f45228b = jSONObject.getJSONArray("host");
            cVar.f45227a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f45229c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f45230d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f45226e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f45228b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i2);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f45229c;
    }
}
