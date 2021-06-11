package d.a.n0.k1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f60352a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60353b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60354c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60355d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f60352a = jSONObject.optString("moreText");
            this.f60353b = d.a.n0.k1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f60354c = d.a.n0.k1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f60355d = jSONObject.optString("moreScheme");
            return;
        }
        this.f60352a = "";
        this.f60353b = Integer.MAX_VALUE;
        this.f60354c = Integer.MAX_VALUE;
        this.f60355d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f60353b;
    }

    public int c() {
        return this.f60354c;
    }

    public String d() {
        return this.f60355d;
    }

    public String e() {
        return this.f60352a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f60352a);
    }
}
