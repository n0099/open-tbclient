package d.a.m0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45253h = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f45254a;

    /* renamed from: b  reason: collision with root package name */
    public String f45255b;

    /* renamed from: c  reason: collision with root package name */
    public String f45256c;

    /* renamed from: d  reason: collision with root package name */
    public String f45257d;

    /* renamed from: e  reason: collision with root package name */
    public String f45258e;

    /* renamed from: f  reason: collision with root package name */
    public String f45259f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f45260g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f45254a = jSONObject.getString("appKey");
            cVar.f45255b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.m0.a.m2.b.h(0) + "&appVersion=" + q0.D();
            cVar.f45256c = jSONObject.getString("wsUrl");
            cVar.f45257d = jSONObject.optString("notInHistory", "1");
            cVar.f45258e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
            cVar.f45259f = jSONObject.optString("slavePreload");
            cVar.f45260g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f45253h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        return b(i2, this.f45255b);
    }

    public final String b(int i2, String str) {
        if (this.f45260g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f45260g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f45260g.optString(i2);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i2) {
        return b(i2, this.f45256c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f45254a) || TextUtils.isEmpty(this.f45255b) || TextUtils.isEmpty(this.f45256c);
    }
}
