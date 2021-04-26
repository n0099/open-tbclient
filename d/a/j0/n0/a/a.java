package d.a.j0.n0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f56880a;

    /* renamed from: b  reason: collision with root package name */
    public String f56881b;

    /* renamed from: c  reason: collision with root package name */
    public String f56882c;

    /* renamed from: d  reason: collision with root package name */
    public String f56883d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f56880a = jSONObject.optLong("id");
        this.f56881b = jSONObject.optString("name");
        this.f56882c = jSONObject.optString("name_show");
        this.f56883d = jSONObject.optString("portrait");
    }
}
