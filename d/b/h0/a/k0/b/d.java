package d.b.h0.a.k0.b;

import android.util.Log;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45780c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final String f45781a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45782b;

    public d(String str, String str2) {
        this.f45781a = str;
        this.f45782b = str2;
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e2) {
            if (f45780c) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
