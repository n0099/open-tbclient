package d.b.j0.j1.o.j;

import android.text.TextUtils;
import d.b.j0.j1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f57798a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57799b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57800c;

    /* renamed from: d  reason: collision with root package name */
    public final String f57801d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57802e;

    /* renamed from: f  reason: collision with root package name */
    public final int f57803f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57804g;

    /* renamed from: h  reason: collision with root package name */
    public final String f57805h;
    public final String i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f57798a = jSONObject.optString("bIcon");
        this.f57799b = jSONObject.optString("bIconN");
        this.f57800c = jSONObject.optInt("bIconType");
        this.f57801d = jSONObject.optString("bSelIcon");
        this.f57802e = jSONObject.optString("bSelIconN");
        this.f57803f = jSONObject.optInt("bSelIconType");
        this.f57804g = jSONObject.optString("clickAction");
        this.f57805h = jSONObject.optString("preAction");
        this.i = jSONObject.optString("statKey");
    }

    public static int g(int i) {
        return f.a(i);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f57804g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f57801d : this.f57798a;
    }

    public String e() {
        return this.j ? this.f57802e : this.f57799b;
    }

    public int f() {
        return g(this.j ? this.f57803f : this.f57800c);
    }

    public String h() {
        return this.f57805h;
    }

    public String i() {
        return this.i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f57798a) && TextUtils.isEmpty(this.f57799b) && TextUtils.isEmpty(this.f57801d) && TextUtils.isEmpty(this.f57802e) && TextUtils.isEmpty(this.f57804g) && TextUtils.isEmpty(this.f57805h) && TextUtils.isEmpty(this.i) && this.f57800c == 0 && this.f57803f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
