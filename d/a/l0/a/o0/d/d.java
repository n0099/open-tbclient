package d.a.l0.a.o0.d;

import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47590c = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47591a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47592b;

    public d(String str, String str2) {
        this.f47591a = str;
        this.f47592b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f47590c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
