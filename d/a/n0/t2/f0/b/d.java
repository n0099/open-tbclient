package d.a.n0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f61070a;

    /* renamed from: b  reason: collision with root package name */
    public int f61071b;

    /* renamed from: c  reason: collision with root package name */
    public int f61072c;

    /* renamed from: d  reason: collision with root package name */
    public long f61073d;

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f61070a = jSONObject.optInt("agree_num", -1);
        dVar.f61071b = jSONObject.optInt("share_num", -1);
        dVar.f61072c = jSONObject.optInt("reply_num", -1);
        dVar.f61073d = jSONObject.optLong("time", System.currentTimeMillis());
        return dVar;
    }
}
