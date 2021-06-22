package d.a.m0.a.o0.d;

import android.util.Log;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47698c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47699a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47700b;

    public d(String str, String str2) {
        this.f47699a = str;
        this.f47700b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f47698c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
