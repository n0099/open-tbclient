package d.b.g0.s.j.a.c;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49780g = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public int f49781a;

    /* renamed from: b  reason: collision with root package name */
    public int f49782b;

    /* renamed from: c  reason: collision with root package name */
    public int f49783c;

    /* renamed from: d  reason: collision with root package name */
    public int f49784d;

    /* renamed from: e  reason: collision with root package name */
    public int f49785e;

    /* renamed from: f  reason: collision with root package name */
    public int f49786f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f49781a);
            jSONObject.put("audioBitrate", this.f49782b);
            jSONObject.put("videoFPS", this.f49783c);
            jSONObject.put("netSpeed", this.f49784d);
            jSONObject.put("videoWidth", this.f49785e);
            jSONObject.put("videoHeight", this.f49786f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f49780g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
