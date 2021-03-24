package d.b.i0.m0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f56806a;

    /* renamed from: b  reason: collision with root package name */
    public String f56807b;

    /* renamed from: c  reason: collision with root package name */
    public String f56808c;

    /* renamed from: d  reason: collision with root package name */
    public String f56809d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f56806a = jSONObject.optLong("id");
        this.f56807b = jSONObject.optString("name");
        this.f56808c = jSONObject.optString("name_show");
        this.f56809d = jSONObject.optString("portrait");
    }
}
