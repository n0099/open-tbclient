package d.a.n0.k1.o.j;

import android.text.TextUtils;
import d.a.n0.k1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f56650a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56651b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56652c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56653d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56654e;

    /* renamed from: f  reason: collision with root package name */
    public final int f56655f;

    /* renamed from: g  reason: collision with root package name */
    public final String f56656g;

    /* renamed from: h  reason: collision with root package name */
    public final String f56657h;

    /* renamed from: i  reason: collision with root package name */
    public final String f56658i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f56650a = jSONObject.optString("bIcon");
        this.f56651b = jSONObject.optString("bIconN");
        this.f56652c = jSONObject.optInt("bIconType");
        this.f56653d = jSONObject.optString("bSelIcon");
        this.f56654e = jSONObject.optString("bSelIconN");
        this.f56655f = jSONObject.optInt("bSelIconType");
        this.f56656g = jSONObject.optString("clickAction");
        this.f56657h = jSONObject.optString("preAction");
        this.f56658i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        return f.a(i2);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f56656g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f56653d : this.f56650a;
    }

    public String e() {
        return this.j ? this.f56654e : this.f56651b;
    }

    public int f() {
        return g(this.j ? this.f56655f : this.f56652c);
    }

    public String h() {
        return this.f56657h;
    }

    public String i() {
        return this.f56658i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f56650a) && TextUtils.isEmpty(this.f56651b) && TextUtils.isEmpty(this.f56653d) && TextUtils.isEmpty(this.f56654e) && TextUtils.isEmpty(this.f56656g) && TextUtils.isEmpty(this.f56657h) && TextUtils.isEmpty(this.f56658i) && this.f56652c == 0 && this.f56655f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
