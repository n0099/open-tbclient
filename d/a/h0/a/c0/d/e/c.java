package d.a.h0.a.c0.d.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41649h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f41650a;

    /* renamed from: b  reason: collision with root package name */
    public String f41651b;

    /* renamed from: c  reason: collision with root package name */
    public String f41652c;

    /* renamed from: d  reason: collision with root package name */
    public String f41653d;

    /* renamed from: e  reason: collision with root package name */
    public String f41654e;

    /* renamed from: f  reason: collision with root package name */
    public String f41655f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f41656g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41650a = jSONObject.getString("appKey");
            cVar.f41651b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.h0.a.b2.b.f(0) + "&appVersion=" + k0.z();
            cVar.f41652c = jSONObject.getString("wsUrl");
            cVar.f41653d = jSONObject.optString("notInHistory", "1");
            cVar.f41654e = jSONObject.optString("masterPreload");
            cVar.f41655f = jSONObject.optString("slavePreload");
            cVar.f41656g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f41649h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        return b(i2, this.f41651b);
    }

    public final String b(int i2, String str) {
        if (this.f41656g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f41656g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f41656g.optString(i2);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i2) {
        return b(i2, this.f41652c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f41650a) || TextUtils.isEmpty(this.f41651b) || TextUtils.isEmpty(this.f41652c);
    }
}
