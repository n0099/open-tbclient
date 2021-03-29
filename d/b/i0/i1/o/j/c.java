package d.b.i0.i1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f55942a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55943b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55944c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55945d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f55942a = jSONObject.optString("moreText");
            this.f55943b = d.b.i0.i1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f55944c = d.b.i0.i1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f55945d = jSONObject.optString("moreScheme");
            return;
        }
        this.f55942a = "";
        this.f55943b = Integer.MAX_VALUE;
        this.f55944c = Integer.MAX_VALUE;
        this.f55945d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f55943b;
    }

    public int c() {
        return this.f55944c;
    }

    public String d() {
        return this.f55945d;
    }

    public String e() {
        return this.f55942a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f55942a);
    }
}
