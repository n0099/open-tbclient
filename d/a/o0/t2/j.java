package d.a.o0.t2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f64978a;

    /* renamed from: b  reason: collision with root package name */
    public int f64979b;

    /* renamed from: c  reason: collision with root package name */
    public int f64980c;

    /* renamed from: d  reason: collision with root package name */
    public int f64981d;

    /* renamed from: e  reason: collision with root package name */
    public int f64982e;

    public j() {
        this.f64979b = 0;
        this.f64980c = 0;
        this.f64981d = 0;
        this.f64982e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f64982e++;
            } else {
                this.f64981d++;
            }
        } else if (z) {
            this.f64979b++;
        } else {
            this.f64980c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f64982e : this.f64981d : z ? this.f64979b : this.f64980c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f64978a);
            jSONObject.put("refresh_count", this.f64979b);
            jSONObject.put("loadmore_count", this.f64980c);
            jSONObject.put("loadmore_count_pb", this.f64981d);
            jSONObject.put("refresh_count_pb", this.f64982e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public j(JSONObject jSONObject) {
        this.f64979b = 0;
        this.f64980c = 0;
        this.f64981d = 0;
        this.f64982e = 0;
        if (jSONObject != null) {
            this.f64978a = jSONObject.optString("forum_name");
            this.f64979b = jSONObject.optInt("refresh_count");
            this.f64980c = jSONObject.optInt("loadmore_count");
            this.f64981d = jSONObject.optInt("loadmore_count_pb");
            this.f64982e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
