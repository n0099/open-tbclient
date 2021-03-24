package d.b.g0.a.b1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43314c = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f43315a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43316b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f43315a = callbackHandler;
        this.f43316b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f43316b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f43315a.handleSchemeDispatchCallback(this.f43316b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f43314c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f43315a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f43314c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f43316b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f43314c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
