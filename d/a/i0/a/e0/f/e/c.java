package d.a.i0.a.e0.f.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.i0.a.k;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41268e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f41269a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f41270b;

    /* renamed from: c  reason: collision with root package name */
    public String f41271c;

    /* renamed from: d  reason: collision with root package name */
    public String f41272d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41270b = jSONObject.getJSONArray("host");
            cVar.f41269a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f41271c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f41272d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f41268e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f41270b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i2);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f41271c;
    }
}
