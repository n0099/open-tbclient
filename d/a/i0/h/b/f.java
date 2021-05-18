package d.a.i0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f46974a;

    /* renamed from: b  reason: collision with root package name */
    public String f46975b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f46974a = jSONObject.optInt("state");
        fVar.f46975b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f46974a + ", msg='" + this.f46975b + "'}";
    }
}
