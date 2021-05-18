package d.a.k0.j1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f56483a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56484b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56485c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56486d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f56483a = jSONObject.optString("moreText");
            this.f56484b = d.a.k0.j1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f56485c = d.a.k0.j1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f56486d = jSONObject.optString("moreScheme");
            return;
        }
        this.f56483a = "";
        this.f56484b = Integer.MAX_VALUE;
        this.f56485c = Integer.MAX_VALUE;
        this.f56486d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f56484b;
    }

    public int c() {
        return this.f56485c;
    }

    public String d() {
        return this.f56486d;
    }

    public String e() {
        return this.f56483a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f56483a);
    }
}
