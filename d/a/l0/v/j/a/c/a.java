package d.a.l0.v.j.a.c;

import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f52223g = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public int f52224a;

    /* renamed from: b  reason: collision with root package name */
    public int f52225b;

    /* renamed from: c  reason: collision with root package name */
    public int f52226c;

    /* renamed from: d  reason: collision with root package name */
    public int f52227d;

    /* renamed from: e  reason: collision with root package name */
    public int f52228e;

    /* renamed from: f  reason: collision with root package name */
    public int f52229f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f52224a);
            jSONObject.put("audioBitrate", this.f52225b);
            jSONObject.put("videoFPS", this.f52226c);
            jSONObject.put("netSpeed", this.f52227d);
            jSONObject.put("videoWidth", this.f52228e);
            jSONObject.put("videoHeight", this.f52229f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f52223g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
