package d.a.o0.o0.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61573a;

    /* renamed from: b  reason: collision with root package name */
    public String f61574b;

    /* renamed from: c  reason: collision with root package name */
    public String f61575c;

    /* renamed from: d  reason: collision with root package name */
    public String f61576d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61573a = jSONObject.optLong("id");
        this.f61574b = jSONObject.optString("name");
        this.f61575c = jSONObject.optString("name_show");
        this.f61576d = jSONObject.optString("portrait");
    }
}
