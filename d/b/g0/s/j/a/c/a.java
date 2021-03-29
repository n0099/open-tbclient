package d.b.g0.s.j.a.c;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49388g = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public int f49389a;

    /* renamed from: b  reason: collision with root package name */
    public int f49390b;

    /* renamed from: c  reason: collision with root package name */
    public int f49391c;

    /* renamed from: d  reason: collision with root package name */
    public int f49392d;

    /* renamed from: e  reason: collision with root package name */
    public int f49393e;

    /* renamed from: f  reason: collision with root package name */
    public int f49394f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f49389a);
            jSONObject.put("audioBitrate", this.f49390b);
            jSONObject.put("videoFPS", this.f49391c);
            jSONObject.put("netSpeed", this.f49392d);
            jSONObject.put("videoWidth", this.f49393e);
            jSONObject.put("videoHeight", this.f49394f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f49388g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
