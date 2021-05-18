package d.a.i0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41295h = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f41296a;

    /* renamed from: b  reason: collision with root package name */
    public String f41297b;

    /* renamed from: c  reason: collision with root package name */
    public String f41298c;

    /* renamed from: d  reason: collision with root package name */
    public String f41299d;

    /* renamed from: e  reason: collision with root package name */
    public String f41300e;

    /* renamed from: f  reason: collision with root package name */
    public String f41301f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f41302g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41296a = jSONObject.getString("appKey");
            cVar.f41297b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.i0.a.m2.b.h(0) + "&appVersion=" + q0.D();
            cVar.f41298c = jSONObject.getString("wsUrl");
            cVar.f41299d = jSONObject.optString("notInHistory", "1");
            cVar.f41300e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
            cVar.f41301f = jSONObject.optString("slavePreload");
            cVar.f41302g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f41295h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        return b(i2, this.f41297b);
    }

    public final String b(int i2, String str) {
        if (this.f41302g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f41302g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f41302g.optString(i2);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i2) {
        return b(i2, this.f41298c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f41296a) || TextUtils.isEmpty(this.f41297b) || TextUtils.isEmpty(this.f41298c);
    }
}
