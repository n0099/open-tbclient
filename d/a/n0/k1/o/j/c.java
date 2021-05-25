package d.a.n0.k1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f56663a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56664b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56665c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56666d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f56663a = jSONObject.optString("moreText");
            this.f56664b = d.a.n0.k1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f56665c = d.a.n0.k1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f56666d = jSONObject.optString("moreScheme");
            return;
        }
        this.f56663a = "";
        this.f56664b = Integer.MAX_VALUE;
        this.f56665c = Integer.MAX_VALUE;
        this.f56666d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f56664b;
    }

    public int c() {
        return this.f56665c;
    }

    public String d() {
        return this.f56666d;
    }

    public String e() {
        return this.f56663a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f56663a);
    }
}
