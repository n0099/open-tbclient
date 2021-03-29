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
    public static final boolean f43616e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f43617a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f43618b;

    /* renamed from: c  reason: collision with root package name */
    public String f43619c;

    /* renamed from: d  reason: collision with root package name */
    public String f43620d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f43618b = jSONObject.getJSONArray("host");
            cVar.f43617a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f43619c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f43620d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f43616e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i) {
        JSONArray jSONArray = this.f43618b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f43619c;
    }
}
