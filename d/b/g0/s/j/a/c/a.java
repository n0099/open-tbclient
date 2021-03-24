package d.b.g0.s.j.a.c;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49387g = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public int f49388a;

    /* renamed from: b  reason: collision with root package name */
    public int f49389b;

    /* renamed from: c  reason: collision with root package name */
    public int f49390c;

    /* renamed from: d  reason: collision with root package name */
    public int f49391d;

    /* renamed from: e  reason: collision with root package name */
    public int f49392e;

    /* renamed from: f  reason: collision with root package name */
    public int f49393f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f49388a);
            jSONObject.put("audioBitrate", this.f49389b);
            jSONObject.put("videoFPS", this.f49390c);
            jSONObject.put("netSpeed", this.f49391d);
            jSONObject.put("videoWidth", this.f49392e);
            jSONObject.put("videoHeight", this.f49393f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f49387g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
