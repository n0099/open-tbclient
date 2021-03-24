package d.b.i0.r2;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f59842a;

    /* renamed from: b  reason: collision with root package name */
    public int f59843b;

    /* renamed from: c  reason: collision with root package name */
    public int f59844c;

    /* renamed from: d  reason: collision with root package name */
    public int f59845d;

    /* renamed from: e  reason: collision with root package name */
    public int f59846e;

    public h() {
        this.f59843b = 0;
        this.f59844c = 0;
        this.f59845d = 0;
        this.f59846e = 0;
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.f59846e++;
            } else {
                this.f59845d++;
            }
        } else if (z) {
            this.f59843b++;
        } else {
            this.f59844c++;
        }
    }

    public int b(boolean z, boolean z2) {
        return z2 ? z ? this.f59846e : this.f59845d : z ? this.f59843b : this.f59844c;
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.f59842a);
            jSONObject.put("refresh_count", this.f59843b);
            jSONObject.put("loadmore_count", this.f59844c);
            jSONObject.put("loadmore_count_pb", this.f59845d);
            jSONObject.put("refresh_count_pb", this.f59846e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public h(JSONObject jSONObject) {
        this.f59843b = 0;
        this.f59844c = 0;
        this.f59845d = 0;
        this.f59846e = 0;
        if (jSONObject != null) {
            this.f59842a = jSONObject.optString("forum_name");
            this.f59843b = jSONObject.optInt("refresh_count");
            this.f59844c = jSONObject.optInt("loadmore_count");
            this.f59845d = jSONObject.optInt("loadmore_count_pb");
            this.f59846e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
