package d.b.g0.a.c0.d.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44033h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f44034a;

    /* renamed from: b  reason: collision with root package name */
    public String f44035b;

    /* renamed from: c  reason: collision with root package name */
    public String f44036c;

    /* renamed from: d  reason: collision with root package name */
    public String f44037d;

    /* renamed from: e  reason: collision with root package name */
    public String f44038e;

    /* renamed from: f  reason: collision with root package name */
    public String f44039f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f44040g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f44034a = jSONObject.getString("appKey");
            cVar.f44035b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.b.g0.a.b2.b.f(0) + "&appVersion=" + k0.z();
            cVar.f44036c = jSONObject.getString("wsUrl");
            cVar.f44037d = jSONObject.optString("notInHistory", "1");
            cVar.f44038e = jSONObject.optString("masterPreload");
            cVar.f44039f = jSONObject.optString("slavePreload");
            cVar.f44040g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f44033h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i) {
        return b(i, this.f44035b);
    }

    public final String b(int i, String str) {
        if (this.f44040g != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.f44040g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f44040g.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i) {
        return b(i, this.f44036c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f44034a) || TextUtils.isEmpty(this.f44035b) || TextUtils.isEmpty(this.f44036c);
    }
}
