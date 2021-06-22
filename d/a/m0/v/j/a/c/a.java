package d.a.m0.v.j.a.c;

import android.util.Log;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f52331g = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public int f52332a;

    /* renamed from: b  reason: collision with root package name */
    public int f52333b;

    /* renamed from: c  reason: collision with root package name */
    public int f52334c;

    /* renamed from: d  reason: collision with root package name */
    public int f52335d;

    /* renamed from: e  reason: collision with root package name */
    public int f52336e;

    /* renamed from: f  reason: collision with root package name */
    public int f52337f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.f52332a);
            jSONObject.put("audioBitrate", this.f52333b);
            jSONObject.put("videoFPS", this.f52334c);
            jSONObject.put("netSpeed", this.f52335d);
            jSONObject.put("videoWidth", this.f52336e);
            jSONObject.put("videoHeight", this.f52337f);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            if (f52331g) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }
}
