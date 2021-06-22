package d.a.o0.k1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f60477a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60478b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60479c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60480d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f60477a = jSONObject.optString("moreText");
            this.f60478b = d.a.o0.k1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f60479c = d.a.o0.k1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f60480d = jSONObject.optString("moreScheme");
            return;
        }
        this.f60477a = "";
        this.f60478b = Integer.MAX_VALUE;
        this.f60479c = Integer.MAX_VALUE;
        this.f60480d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f60478b;
    }

    public int c() {
        return this.f60479c;
    }

    public String d() {
        return this.f60480d;
    }

    public String e() {
        return this.f60477a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f60477a);
    }
}
