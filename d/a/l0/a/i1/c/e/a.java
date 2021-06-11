package d.a.l0.a.i1.c.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46426c = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public CallbackHandler f46427a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f46428b;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.f46427a = callbackHandler;
        this.f46428b = jSONObject;
    }

    public void a(String str) {
        b(str, null);
    }

    public void b(String str, JSONObject jSONObject) {
        if (this.f46428b == null) {
            return;
        }
        JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
        this.f46427a.handleSchemeDispatchCallback(this.f46428b.optString(str), wrapCallbackParamsWithEncode.toString());
        if (f46426c) {
            Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
        }
    }

    public boolean c() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.f46427a);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46426c) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.f46428b = new JSONObject(str);
        } catch (JSONException unused) {
            if (f46426c) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }
}
