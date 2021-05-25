package d.a.l0.v.j.a.c;

import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48549g = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public int f48550a;

    /* renamed from: b  reason: collision with root package name */
    public int f48551b;

    /* renamed from: c  reason: collision with root package name */
    public int f48552c;

    /* renamed from: d  reason: collision with root package name */
    public int f48553d;

    /* renamed from: e  reason: collision with root package name */
    public int f48554e;

    /* renamed from: f  reason: collision with root package name */
    public int f48555f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f48550a);
            jSONObject.put("audioBitrate", this.f48551b);
            jSONObject.put("videoFPS", this.f48552c);
            jSONObject.put("netSpeed", this.f48553d);
            jSONObject.put("videoWidth", this.f48554e);
            jSONObject.put("videoHeight", this.f48555f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f48549g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
