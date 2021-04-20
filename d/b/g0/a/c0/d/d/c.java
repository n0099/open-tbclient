package d.b.g0.a.c0.d.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import d.b.g0.a.k;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44008e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f44009a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f44010b;

    /* renamed from: c  reason: collision with root package name */
    public String f44011c;

    /* renamed from: d  reason: collision with root package name */
    public String f44012d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f44010b = jSONObject.getJSONArray("host");
            cVar.f44009a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f44011c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f44012d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f44008e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i) {
        JSONArray jSONArray = this.f44010b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f44011c;
    }
}
