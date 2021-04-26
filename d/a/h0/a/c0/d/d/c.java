package d.a.h0.a.c0.d.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.h0.a.k;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41622e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f41623a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f41624b;

    /* renamed from: c  reason: collision with root package name */
    public String f41625c;

    /* renamed from: d  reason: collision with root package name */
    public String f41626d;

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41624b = jSONObject.getJSONArray("host");
            cVar.f41623a = jSONObject.getString("appKey");
            jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            cVar.f41625c = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.f41626d = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException unused) {
            if (f41622e) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        JSONArray jSONArray = this.f41624b;
        if (jSONArray == null) {
            return "";
        }
        String optString = jSONArray.optString(i2);
        if (TextUtils.isEmpty(optString)) {
            return "";
        }
        return "http://" + optString + ":" + this.f41625c;
    }
}
