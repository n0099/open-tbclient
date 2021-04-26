package d.a.j0.j1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f55776a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55777b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55778c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55779d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f55776a = jSONObject.optString("moreText");
            this.f55777b = d.a.j0.j1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f55778c = d.a.j0.j1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f55779d = jSONObject.optString("moreScheme");
            return;
        }
        this.f55776a = "";
        this.f55777b = Integer.MAX_VALUE;
        this.f55778c = Integer.MAX_VALUE;
        this.f55779d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f55777b;
    }

    public int c() {
        return this.f55778c;
    }

    public String d() {
        return this.f55779d;
    }

    public String e() {
        return this.f55776a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f55776a);
    }
}
