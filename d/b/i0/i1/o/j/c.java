package d.b.i0.i1.o.j;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f55941a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55942b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55943c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55944d;

    public c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f55941a = jSONObject.optString("moreText");
            this.f55942b = d.b.i0.i1.o.k.b.b(jSONObject.optString("moreColor", ""));
            this.f55943c = d.b.i0.i1.o.k.b.b(jSONObject.optString("moreColorNight", ""));
            this.f55944d = jSONObject.optString("moreScheme");
            return;
        }
        this.f55941a = "";
        this.f55942b = Integer.MAX_VALUE;
        this.f55943c = Integer.MAX_VALUE;
        this.f55944d = "";
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public int b() {
        return this.f55942b;
    }

    public int c() {
        return this.f55943c;
    }

    public String d() {
        return this.f55944d;
    }

    public String e() {
        return this.f55941a;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.f55941a);
    }
}
