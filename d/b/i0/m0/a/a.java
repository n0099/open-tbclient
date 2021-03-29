package d.b.i0.m0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f56807a;

    /* renamed from: b  reason: collision with root package name */
    public String f56808b;

    /* renamed from: c  reason: collision with root package name */
    public String f56809c;

    /* renamed from: d  reason: collision with root package name */
    public String f56810d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f56807a = jSONObject.optLong("id");
        this.f56808b = jSONObject.optString("name");
        this.f56809c = jSONObject.optString("name_show");
        this.f56810d = jSONObject.optString("portrait");
    }
}
