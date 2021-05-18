package d.a.k0.s2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f60968a;

    /* renamed from: b  reason: collision with root package name */
    public int f60969b;

    /* renamed from: c  reason: collision with root package name */
    public int f60970c;

    /* renamed from: d  reason: collision with root package name */
    public long f60971d;

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f60968a = jSONObject.optInt("agree_num", -1);
        dVar.f60969b = jSONObject.optInt("share_num", -1);
        dVar.f60970c = jSONObject.optInt("reply_num", -1);
        dVar.f60971d = jSONObject.optLong("time", System.currentTimeMillis());
        return dVar;
    }
}
