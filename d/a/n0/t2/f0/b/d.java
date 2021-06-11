package d.a.n0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f64762a;

    /* renamed from: b  reason: collision with root package name */
    public int f64763b;

    /* renamed from: c  reason: collision with root package name */
    public int f64764c;

    /* renamed from: d  reason: collision with root package name */
    public long f64765d;

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f64762a = jSONObject.optInt("agree_num", -1);
        dVar.f64763b = jSONObject.optInt("share_num", -1);
        dVar.f64764c = jSONObject.optInt("reply_num", -1);
        dVar.f64765d = jSONObject.optLong("time", System.currentTimeMillis());
        return dVar;
    }
}
