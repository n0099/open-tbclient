package d.b.h0.s.j.a.c;

import android.util.Log;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f50109g = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public int f50110a;

    /* renamed from: b  reason: collision with root package name */
    public int f50111b;

    /* renamed from: c  reason: collision with root package name */
    public int f50112c;

    /* renamed from: d  reason: collision with root package name */
    public int f50113d;

    /* renamed from: e  reason: collision with root package name */
    public int f50114e;

    /* renamed from: f  reason: collision with root package name */
    public int f50115f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f50110a);
            jSONObject.put("audioBitrate", this.f50111b);
            jSONObject.put("videoFPS", this.f50112c);
            jSONObject.put("netSpeed", this.f50113d);
            jSONObject.put("videoWidth", this.f50114e);
            jSONObject.put("videoHeight", this.f50115f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f50109g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
