package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f48298a;

    /* renamed from: b  reason: collision with root package name */
    public String f48299b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f48298a = jSONObject.optInt("state");
        fVar.f48299b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f48298a + ", msg='" + this.f48299b + "'}";
    }
}
