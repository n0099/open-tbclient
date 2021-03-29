package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f47906a;

    /* renamed from: b  reason: collision with root package name */
    public String f47907b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f47906a = jSONObject.optInt("state");
        fVar.f47907b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f47906a + ", msg='" + this.f47907b + "'}";
    }
}
