package d.a.m0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f50932a;

    /* renamed from: b  reason: collision with root package name */
    public String f50933b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f50932a = jSONObject.optInt("state");
        fVar.f50933b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f50932a + ", msg='" + this.f50933b + "'}";
    }
}
