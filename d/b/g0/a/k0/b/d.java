package d.b.g0.a.k0.b;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45058c = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public final String f45059a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45060b;

    public d(String str, String str2) {
        this.f45059a = str;
        this.f45060b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f45058c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
