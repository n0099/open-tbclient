package d.a.l0.a.e0.f.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.l0.a.k;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45118e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f45119a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f45120b;

    /* renamed from: c  reason: collision with root package name */
    public String f45121c;

    /* renamed from: d  reason: collision with root package name */
    public String f45122d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f45120b = jSONObject.getJSONArray("host");
            cVar.f45119a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f45121c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f45122d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f45118e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f45120b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i2);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f45121c;
    }
}
