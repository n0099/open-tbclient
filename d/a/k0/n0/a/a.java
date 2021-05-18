package d.a.k0.n0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f57587a;

    /* renamed from: b  reason: collision with root package name */
    public String f57588b;

    /* renamed from: c  reason: collision with root package name */
    public String f57589c;

    /* renamed from: d  reason: collision with root package name */
    public String f57590d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f57587a = jSONObject.optLong("id");
        this.f57588b = jSONObject.optString("name");
        this.f57589c = jSONObject.optString("name_show");
        this.f57590d = jSONObject.optString("portrait");
    }
}
