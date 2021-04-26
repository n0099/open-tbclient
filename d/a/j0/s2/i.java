package d.a.j0.s2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f60317a;

    /* renamed from: b  reason: collision with root package name */
    public int f60318b;

    /* renamed from: c  reason: collision with root package name */
    public int f60319c;

    /* renamed from: d  reason: collision with root package name */
    public int f60320d;

    /* renamed from: e  reason: collision with root package name */
    public int f60321e;

    public i() {
        this.f60318b = 0;
        this.f60319c = 0;
        this.f60320d = 0;
        this.f60321e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f60321e++;
            } else {
                this.f60320d++;
            }
        } else if (z) {
            this.f60318b++;
        } else {
            this.f60319c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f60321e : this.f60320d : z ? this.f60318b : this.f60319c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f60317a);
            jSONObject.put("refresh_count", this.f60318b);
            jSONObject.put("loadmore_count", this.f60319c);
            jSONObject.put("loadmore_count_pb", this.f60320d);
            jSONObject.put("refresh_count_pb", this.f60321e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public i(JSONObject jSONObject) {
        this.f60318b = 0;
        this.f60319c = 0;
        this.f60320d = 0;
        this.f60321e = 0;
        if (jSONObject != null) {
            this.f60317a = jSONObject.optString("forum_name");
            this.f60318b = jSONObject.optInt("refresh_count");
            this.f60319c = jSONObject.optInt("loadmore_count");
            this.f60320d = jSONObject.optInt("loadmore_count_pb");
            this.f60321e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
