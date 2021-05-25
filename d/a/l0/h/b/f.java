package d.a.l0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f47150a;

    /* renamed from: b  reason: collision with root package name */
    public String f47151b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f47150a = jSONObject.optInt("state");
        fVar.f47151b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f47150a + ", msg='" + this.f47151b + "'}";
    }
}
