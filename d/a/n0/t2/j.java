package d.a.n0.t2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f61161a;

    /* renamed from: b  reason: collision with root package name */
    public int f61162b;

    /* renamed from: c  reason: collision with root package name */
    public int f61163c;

    /* renamed from: d  reason: collision with root package name */
    public int f61164d;

    /* renamed from: e  reason: collision with root package name */
    public int f61165e;

    public j() {
        this.f61162b = 0;
        this.f61163c = 0;
        this.f61164d = 0;
        this.f61165e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f61165e++;
            } else {
                this.f61164d++;
            }
        } else if (z) {
            this.f61162b++;
        } else {
            this.f61163c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f61165e : this.f61164d : z ? this.f61162b : this.f61163c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f61161a);
            jSONObject.put("refresh_count", this.f61162b);
            jSONObject.put("loadmore_count", this.f61163c);
            jSONObject.put("loadmore_count_pb", this.f61164d);
            jSONObject.put("refresh_count_pb", this.f61165e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public j(JSONObject jSONObject) {
        this.f61162b = 0;
        this.f61163c = 0;
        this.f61164d = 0;
        this.f61165e = 0;
        if (jSONObject != null) {
            this.f61161a = jSONObject.optString("forum_name");
            this.f61162b = jSONObject.optInt("refresh_count");
            this.f61163c = jSONObject.optInt("loadmore_count");
            this.f61164d = jSONObject.optInt("loadmore_count_pb");
            this.f61165e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
