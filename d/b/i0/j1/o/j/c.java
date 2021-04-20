package d.b.i0.j1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f57389a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57390b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57391c;

    /* renamed from: d  reason: collision with root package name */
    public final String f57392d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f57389a = jSONObject.optString("moreText");
            this.f57390b = d.b.i0.j1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f57391c = d.b.i0.j1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f57392d = jSONObject.optString("moreScheme");
            return;
        }
        this.f57389a = "";
        this.f57390b = Integer.MAX_VALUE;
        this.f57391c = Integer.MAX_VALUE;
        this.f57392d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f57390b;
    }

    public int c() {
        return this.f57391c;
    }

    public String d() {
        return this.f57392d;
    }

    public String e() {
        return this.f57389a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f57389a);
    }
}
