package d.b.i0.i1.o.j;

import android.text.TextUtils;
import d.b.i0.i1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f55929a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55930b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55931c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55932d;

    /* renamed from: e  reason: collision with root package name */
    public final String f55933e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55934f;

    /* renamed from: g  reason: collision with root package name */
    public final String f55935g;

    /* renamed from: h  reason: collision with root package name */
    public final String f55936h;
    public final String i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f55929a = jSONObject.optString("bIcon");
        this.f55930b = jSONObject.optString("bIconN");
        this.f55931c = jSONObject.optInt("bIconType");
        this.f55932d = jSONObject.optString("bSelIcon");
        this.f55933e = jSONObject.optString("bSelIconN");
        this.f55934f = jSONObject.optInt("bSelIconType");
        this.f55935g = jSONObject.optString("clickAction");
        this.f55936h = jSONObject.optString("preAction");
        this.i = jSONObject.optString("statKey");
    }

    public static int g(int i) {
        return f.a(i);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f55935g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f55932d : this.f55929a;
    }

    public String e() {
        return this.j ? this.f55933e : this.f55930b;
    }

    public int f() {
        return g(this.j ? this.f55934f : this.f55931c);
    }

    public String h() {
        return this.f55936h;
    }

    public String i() {
        return this.i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f55929a) && TextUtils.isEmpty(this.f55930b) && TextUtils.isEmpty(this.f55932d) && TextUtils.isEmpty(this.f55933e) && TextUtils.isEmpty(this.f55935g) && TextUtils.isEmpty(this.f55936h) && TextUtils.isEmpty(this.i) && this.f55931c == 0 && this.f55934f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
