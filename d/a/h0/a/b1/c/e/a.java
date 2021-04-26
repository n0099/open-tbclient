package d.a.h0.a.b1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41309c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f41310a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f41311b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f41310a = callbackHandler;
        this.f41311b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f41311b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f41310a.handleSchemeDispatchCallback(this.f41311b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f41309c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f41310a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f41309c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f41311b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f41309c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
