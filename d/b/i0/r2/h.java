package d.b.i0.r2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f59843a;

    /* renamed from: b  reason: collision with root package name */
    public int f59844b;

    /* renamed from: c  reason: collision with root package name */
    public int f59845c;

    /* renamed from: d  reason: collision with root package name */
    public int f59846d;

    /* renamed from: e  reason: collision with root package name */
    public int f59847e;

    public h() {
        this.f59844b = 0;
        this.f59845c = 0;
        this.f59846d = 0;
        this.f59847e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f59847e++;
            } else {
                this.f59846d++;
            }
        } else if (z) {
            this.f59844b++;
        } else {
            this.f59845c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f59847e : this.f59846d : z ? this.f59844b : this.f59845c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f59843a);
            jSONObject.put("refresh_count", this.f59844b);
            jSONObject.put("loadmore_count", this.f59845c);
            jSONObject.put("loadmore_count_pb", this.f59846d);
            jSONObject.put("refresh_count_pb", this.f59847e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public h(JSONObject jSONObject) {
        this.f59844b = 0;
        this.f59845c = 0;
        this.f59846d = 0;
        this.f59847e = 0;
        if (jSONObject != null) {
            this.f59843a = jSONObject.optString("forum_name");
            this.f59844b = jSONObject.optInt("refresh_count");
            this.f59845c = jSONObject.optInt("loadmore_count");
            this.f59846d = jSONObject.optInt("loadmore_count_pb");
            this.f59847e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
