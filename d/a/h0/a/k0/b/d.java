package d.a.h0.a.k0.b;

import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43109c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43110a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43111b;

    public d(String str, String str2) {
        this.f43110a = str;
        this.f43111b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f43109c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
