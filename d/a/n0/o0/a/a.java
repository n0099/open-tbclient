package d.a.n0.o0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61448a;

    /* renamed from: b  reason: collision with root package name */
    public String f61449b;

    /* renamed from: c  reason: collision with root package name */
    public String f61450c;

    /* renamed from: d  reason: collision with root package name */
    public String f61451d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61448a = jSONObject.optLong("id");
        this.f61449b = jSONObject.optString("name");
        this.f61450c = jSONObject.optString("name_show");
        this.f61451d = jSONObject.optString("portrait");
    }
}
