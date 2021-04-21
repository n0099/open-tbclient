package d.b.j0.n0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f58865a;

    /* renamed from: b  reason: collision with root package name */
    public String f58866b;

    /* renamed from: c  reason: collision with root package name */
    public String f58867c;

    /* renamed from: d  reason: collision with root package name */
    public String f58868d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f58865a = jSONObject.optLong("id");
        this.f58866b = jSONObject.optString("name");
        this.f58867c = jSONObject.optString("name_show");
        this.f58868d = jSONObject.optString("portrait");
    }
}
