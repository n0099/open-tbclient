package d.b.j0.s2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f62157a;

    /* renamed from: b  reason: collision with root package name */
    public int f62158b;

    /* renamed from: c  reason: collision with root package name */
    public int f62159c;

    /* renamed from: d  reason: collision with root package name */
    public int f62160d;

    /* renamed from: e  reason: collision with root package name */
    public int f62161e;

    public i() {
        this.f62158b = 0;
        this.f62159c = 0;
        this.f62160d = 0;
        this.f62161e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f62161e++;
            } else {
                this.f62160d++;
            }
        } else if (z) {
            this.f62158b++;
        } else {
            this.f62159c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f62161e : this.f62160d : z ? this.f62158b : this.f62159c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f62157a);
            jSONObject.put("refresh_count", this.f62158b);
            jSONObject.put("loadmore_count", this.f62159c);
            jSONObject.put("loadmore_count_pb", this.f62160d);
            jSONObject.put("refresh_count_pb", this.f62161e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public i(JSONObject jSONObject) {
        this.f62158b = 0;
        this.f62159c = 0;
        this.f62160d = 0;
        this.f62161e = 0;
        if (jSONObject != null) {
            this.f62157a = jSONObject.optString("forum_name");
            this.f62158b = jSONObject.optInt("refresh_count");
            this.f62159c = jSONObject.optInt("loadmore_count");
            this.f62160d = jSONObject.optInt("loadmore_count_pb");
            this.f62161e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
