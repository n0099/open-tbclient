package d.a.h0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f46091a;

    /* renamed from: b  reason: collision with root package name */
    public String f46092b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f46091a = jSONObject.optInt("state");
        fVar.f46092b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f46091a + ", msg='" + this.f46092b + "'}";
    }
}
