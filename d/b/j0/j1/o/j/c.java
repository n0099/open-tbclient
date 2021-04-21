package d.b.j0.j1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f57810a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57811b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57812c;

    /* renamed from: d  reason: collision with root package name */
    public final String f57813d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f57810a = jSONObject.optString("moreText");
            this.f57811b = d.b.j0.j1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f57812c = d.b.j0.j1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f57813d = jSONObject.optString("moreScheme");
            return;
        }
        this.f57810a = "";
        this.f57811b = Integer.MAX_VALUE;
        this.f57812c = Integer.MAX_VALUE;
        this.f57813d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f57811b;
    }

    public int c() {
        return this.f57812c;
    }

    public String d() {
        return this.f57813d;
    }

    public String e() {
        return this.f57810a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f57810a);
    }
}
