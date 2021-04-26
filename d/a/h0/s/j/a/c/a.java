package d.a.h0.s.j.a.c;

import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47642g = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public int f47643a;

    /* renamed from: b  reason: collision with root package name */
    public int f47644b;

    /* renamed from: c  reason: collision with root package name */
    public int f47645c;

    /* renamed from: d  reason: collision with root package name */
    public int f47646d;

    /* renamed from: e  reason: collision with root package name */
    public int f47647e;

    /* renamed from: f  reason: collision with root package name */
    public int f47648f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f47643a);
            jSONObject.put("audioBitrate", this.f47644b);
            jSONObject.put("videoFPS", this.f47645c);
            jSONObject.put("netSpeed", this.f47646d);
            jSONObject.put("videoWidth", this.f47647e);
            jSONObject.put("videoHeight", this.f47648f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f47642g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
