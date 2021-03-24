package d.b.g0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f47905a;

    /* renamed from: b  reason: collision with root package name */
    public String f47906b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f47905a = jSONObject.optInt("state");
        fVar.f47906b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f47905a + ", msg='" + this.f47906b + "'}";
    }
}
