package d.a.n0.o0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f57759a;

    /* renamed from: b  reason: collision with root package name */
    public String f57760b;

    /* renamed from: c  reason: collision with root package name */
    public String f57761c;

    /* renamed from: d  reason: collision with root package name */
    public String f57762d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f57759a = jSONObject.optLong("id");
        this.f57760b = jSONObject.optString("name");
        this.f57761c = jSONObject.optString("name_show");
        this.f57762d = jSONObject.optString("portrait");
    }
}
