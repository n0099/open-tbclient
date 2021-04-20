package d.b.i0.s2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f61736a;

    /* renamed from: b  reason: collision with root package name */
    public int f61737b;

    /* renamed from: c  reason: collision with root package name */
    public int f61738c;

    /* renamed from: d  reason: collision with root package name */
    public int f61739d;

    /* renamed from: e  reason: collision with root package name */
    public int f61740e;

    public i() {
        this.f61737b = 0;
        this.f61738c = 0;
        this.f61739d = 0;
        this.f61740e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f61740e++;
            } else {
                this.f61739d++;
            }
        } else if (z) {
            this.f61737b++;
        } else {
            this.f61738c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f61740e : this.f61739d : z ? this.f61737b : this.f61738c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f61736a);
            jSONObject.put("refresh_count", this.f61737b);
            jSONObject.put("loadmore_count", this.f61738c);
            jSONObject.put("loadmore_count_pb", this.f61739d);
            jSONObject.put("refresh_count_pb", this.f61740e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public i(JSONObject jSONObject) {
        this.f61737b = 0;
        this.f61738c = 0;
        this.f61739d = 0;
        this.f61740e = 0;
        if (jSONObject != null) {
            this.f61736a = jSONObject.optString("forum_name");
            this.f61737b = jSONObject.optInt("refresh_count");
            this.f61738c = jSONObject.optInt("loadmore_count");
            this.f61739d = jSONObject.optInt("loadmore_count_pb");
            this.f61740e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
