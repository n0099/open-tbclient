package d.a.k0.s2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f61059a;

    /* renamed from: b  reason: collision with root package name */
    public int f61060b;

    /* renamed from: c  reason: collision with root package name */
    public int f61061c;

    /* renamed from: d  reason: collision with root package name */
    public int f61062d;

    /* renamed from: e  reason: collision with root package name */
    public int f61063e;

    public j() {
        this.f61060b = 0;
        this.f61061c = 0;
        this.f61062d = 0;
        this.f61063e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f61063e++;
            } else {
                this.f61062d++;
            }
        } else if (z) {
            this.f61060b++;
        } else {
            this.f61061c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f61063e : this.f61062d : z ? this.f61060b : this.f61061c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f61059a);
            jSONObject.put("refresh_count", this.f61060b);
            jSONObject.put("loadmore_count", this.f61061c);
            jSONObject.put("loadmore_count_pb", this.f61062d);
            jSONObject.put("refresh_count_pb", this.f61063e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public j(JSONObject jSONObject) {
        this.f61060b = 0;
        this.f61061c = 0;
        this.f61062d = 0;
        this.f61063e = 0;
        if (jSONObject != null) {
            this.f61059a = jSONObject.optString("forum_name");
            this.f61060b = jSONObject.optInt("refresh_count");
            this.f61061c = jSONObject.optInt("loadmore_count");
            this.f61062d = jSONObject.optInt("loadmore_count_pb");
            this.f61063e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
