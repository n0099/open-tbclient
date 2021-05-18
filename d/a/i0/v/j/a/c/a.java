package d.a.i0.v.j.a.c;

import android.util.Log;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48373g = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public int f48374a;

    /* renamed from: b  reason: collision with root package name */
    public int f48375b;

    /* renamed from: c  reason: collision with root package name */
    public int f48376c;

    /* renamed from: d  reason: collision with root package name */
    public int f48377d;

    /* renamed from: e  reason: collision with root package name */
    public int f48378e;

    /* renamed from: f  reason: collision with root package name */
    public int f48379f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f48374a);
            jSONObject.put("audioBitrate", this.f48375b);
            jSONObject.put("videoFPS", this.f48376c);
            jSONObject.put("netSpeed", this.f48377d);
            jSONObject.put("videoWidth", this.f48378e);
            jSONObject.put("videoHeight", this.f48379f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f48373g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
