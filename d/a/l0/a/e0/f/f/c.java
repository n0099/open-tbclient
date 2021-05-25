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
    public static final boolean f41469h = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f41470a;

    /* renamed from: b  reason: collision with root package name */
    public String f41471b;

    /* renamed from: c  reason: collision with root package name */
    public String f41472c;

    /* renamed from: d  reason: collision with root package name */
    public String f41473d;

    /* renamed from: e  reason: collision with root package name */
    public String f41474e;

    /* renamed from: f  reason: collision with root package name */
    public String f41475f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f41476g;

    public static c e(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.f41470a = jSONObject.getString("appKey");
            cVar.f41471b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.l0.a.m2.b.h(0) + "&appVersion=" + q0.D();
            cVar.f41472c = jSONObject.getString("wsUrl");
            cVar.f41473d = jSONObject.optString("notInHistory", "1");
            cVar.f41474e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
            cVar.f41475f = jSONObject.optString("slavePreload");
            cVar.f41476g = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException unused) {
            if (f41469h) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                return null;
            }
            return null;
        }
    }

    public String a(int i2) {
        return b(i2, this.f41471b);
    }

    public final String b(int i2, String str) {
        if (this.f41476g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f41476g.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.f41476g.optString(i2);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
        }
        return str;
    }

    public String c(int i2) {
        return b(i2, this.f41472c);
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f41470a) || TextUtils.isEmpty(this.f41471b) || TextUtils.isEmpty(this.f41472c);
    }
}
