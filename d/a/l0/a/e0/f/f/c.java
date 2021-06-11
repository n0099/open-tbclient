package d.a.l0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45145h = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f45146a;

    /* renamed from: b  reason: collision with root package name */
    public String f45147b;

    /* renamed from: c  reason: collision with root package name */
    public String f45148c;

    /* renamed from: d  reason: collision with root package name */
    public String f45149d;

    /* renamed from: e  reason: collision with root package name */
    public String f45150e;

    /* renamed from: f  reason: collision with root package name */
    public String f45151f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f45152g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f45146a = jSONObject.getString("appKey");
            cVar.f45147b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.l0.a.m2.b.h(0) + "&appVersion=" + q0.D();
            cVar.f45148c = jSONObject.getString("wsUrl");
            cVar.f45149d = jSONObject.optString("notInHistory", "1");
            cVar.f45150e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
            cVar.f45151f = jSONObject.optString("slavePreload");
            cVar.f45152g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f45145h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        return b(i2, this.f45147b);
    }

    public final String b(int i2, String str) {
        if (this.f45152g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f45152g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f45152g.optString(i2);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i2) {
        return b(i2, this.f45148c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f45146a) || TextUtils.isEmpty(this.f45147b) || TextUtils.isEmpty(this.f45148c);
    }
}
