package d.a.i0.a.o0.d;

import android.util.Log;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43740c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43741a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43742b;

    public d(String str, String str2) {
        this.f43741a = str;
        this.f43742b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f43740c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
