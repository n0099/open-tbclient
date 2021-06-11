package d.a.n0.t2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f64853a;

    /* renamed from: b  reason: collision with root package name */
    public int f64854b;

    /* renamed from: c  reason: collision with root package name */
    public int f64855c;

    /* renamed from: d  reason: collision with root package name */
    public int f64856d;

    /* renamed from: e  reason: collision with root package name */
    public int f64857e;

    public j() {
        this.f64854b = 0;
        this.f64855c = 0;
        this.f64856d = 0;
        this.f64857e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f64857e++;
            } else {
                this.f64856d++;
            }
        } else if (z) {
            this.f64854b++;
        } else {
            this.f64855c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f64857e : this.f64856d : z ? this.f64854b : this.f64855c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f64853a);
            jSONObject.put("refresh_count", this.f64854b);
            jSONObject.put("loadmore_count", this.f64855c);
            jSONObject.put("loadmore_count_pb", this.f64856d);
            jSONObject.put("refresh_count_pb", this.f64857e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public j(JSONObject jSONObject) {
        this.f64854b = 0;
        this.f64855c = 0;
        this.f64856d = 0;
        this.f64857e = 0;
        if (jSONObject != null) {
            this.f64853a = jSONObject.optString("forum_name");
            this.f64854b = jSONObject.optInt("refresh_count");
            this.f64855c = jSONObject.optInt("loadmore_count");
            this.f64856d = jSONObject.optInt("loadmore_count_pb");
            this.f64857e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
