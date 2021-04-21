package d.b.h0.a.b1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44036c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f44037a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f44038b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f44037a = callbackHandler;
        this.f44038b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f44038b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f44037a.handleSchemeDispatchCallback(this.f44038b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f44036c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f44037a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f44036c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f44038b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f44036c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
