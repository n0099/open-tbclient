package d.b.h0.a.c0.d.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44362h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f44363a;

    /* renamed from: b  reason: collision with root package name */
    public String f44364b;

    /* renamed from: c  reason: collision with root package name */
    public String f44365c;

    /* renamed from: d  reason: collision with root package name */
    public String f44366d;

    /* renamed from: e  reason: collision with root package name */
    public String f44367e;

    /* renamed from: f  reason: collision with root package name */
    public String f44368f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f44369g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f44363a = jSONObject.getString("appKey");
            cVar.f44364b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.b.h0.a.b2.b.f(0) + "&appVersion=" + k0.z();
            cVar.f44365c = jSONObject.getString("wsUrl");
            cVar.f44366d = jSONObject.optString("notInHistory", "1");
            cVar.f44367e = jSONObject.optString("masterPreload");
            cVar.f44368f = jSONObject.optString("slavePreload");
            cVar.f44369g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f44362h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i) {
        return b(i, this.f44364b);
    }

    public final String b(int i, String str) {
        if (this.f44369g != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.f44369g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f44369g.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i) {
        return b(i, this.f44365c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f44363a) || TextUtils.isEmpty(this.f44364b) || TextUtils.isEmpty(this.f44365c);
    }
}
