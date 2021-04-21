package d.b.h0.g.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f48627a;

    /* renamed from: b  reason: collision with root package name */
    public String f48628b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f48627a = jSONObject.optInt("state");
        fVar.f48628b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f48627a + ", msg='" + this.f48628b + "'}";
    }
}
