package d.b.i0.n0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f58444a;

    /* renamed from: b  reason: collision with root package name */
    public String f58445b;

    /* renamed from: c  reason: collision with root package name */
    public String f58446c;

    /* renamed from: d  reason: collision with root package name */
    public String f58447d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f58444a = jSONObject.optLong("id");
        this.f58445b = jSONObject.optString("name");
        this.f58446c = jSONObject.optString("name_show");
        this.f58447d = jSONObject.optString("portrait");
    }
}
