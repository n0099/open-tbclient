package d.a.o0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f64887a;

    /* renamed from: b  reason: collision with root package name */
    public int f64888b;

    /* renamed from: c  reason: collision with root package name */
    public int f64889c;

    /* renamed from: d  reason: collision with root package name */
    public long f64890d;

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f64887a = jSONObject.optInt("agree_num", -1);
        dVar.f64888b = jSONObject.optInt("share_num", -1);
        dVar.f64889c = jSONObject.optInt("reply_num", -1);
        dVar.f64890d = jSONObject.optLong("time", System.currentTimeMillis());
        return dVar;
    }
}
