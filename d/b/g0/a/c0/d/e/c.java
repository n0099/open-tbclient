package d.b.g0.a.c0.d.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43640h = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f43641a;

    /* renamed from: b  reason: collision with root package name */
    public String f43642b;

    /* renamed from: c  reason: collision with root package name */
    public String f43643c;

    /* renamed from: d  reason: collision with root package name */
    public String f43644d;

    /* renamed from: e  reason: collision with root package name */
    public String f43645e;

    /* renamed from: f  reason: collision with root package name */
    public String f43646f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f43647g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f43641a = jSONObject.getString("appKey");
            cVar.f43642b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.b.g0.a.b2.b.f(0) + "&appVersion=" + k0.z();
            cVar.f43643c = jSONObject.getString("wsUrl");
            cVar.f43644d = jSONObject.optString("notInHistory", "1");
            cVar.f43645e = jSONObject.optString("masterPreload");
            cVar.f43646f = jSONObject.optString("slavePreload");
            cVar.f43647g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f43640h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i) {
        return b(i, this.f43642b);
    }

    public final String b(int i, String str) {
        if (this.f43647g != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.f43647g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f43647g.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i) {
        return b(i, this.f43643c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f43641a) || TextUtils.isEmpty(this.f43642b) || TextUtils.isEmpty(this.f43643c);
    }
}
