package d.a.i0.a.i1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42576c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f42577a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f42578b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f42577a = callbackHandler;
        this.f42578b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f42578b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f42577a.handleSchemeDispatchCallback(this.f42578b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f42576c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f42577a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f42576c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f42578b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f42576c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
