package d.a.l0.h.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f50824a;

    /* renamed from: b  reason: collision with root package name */
    public String f50825b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        fVar.f50824a = jSONObject.optInt("state");
        fVar.f50825b = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.f50824a + ", msg='" + this.f50825b + "'}";
    }
}
