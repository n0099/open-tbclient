package d.b.g0.a.b1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43315c = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f43316a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43317b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f43316a = callbackHandler;
        this.f43317b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f43317b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f43316a.handleSchemeDispatchCallback(this.f43317b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f43315c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f43316a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f43315c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f43317b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f43315c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
