package d.a.j0.j1.o.j;

import android.text.TextUtils;
import d.a.j0.j1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f55763a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55764b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55765c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55766d;

    /* renamed from: e  reason: collision with root package name */
    public final String f55767e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55768f;

    /* renamed from: g  reason: collision with root package name */
    public final String f55769g;

    /* renamed from: h  reason: collision with root package name */
    public final String f55770h;

    /* renamed from: i  reason: collision with root package name */
    public final String f55771i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f55763a = jSONObject.optString("bIcon");
        this.f55764b = jSONObject.optString("bIconN");
        this.f55765c = jSONObject.optInt("bIconType");
        this.f55766d = jSONObject.optString("bSelIcon");
        this.f55767e = jSONObject.optString("bSelIconN");
        this.f55768f = jSONObject.optInt("bSelIconType");
        this.f55769g = jSONObject.optString("clickAction");
        this.f55770h = jSONObject.optString("preAction");
        this.f55771i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        return f.a(i2);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f55769g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f55766d : this.f55763a;
    }

    public String e() {
        return this.j ? this.f55767e : this.f55764b;
    }

    public int f() {
        return g(this.j ? this.f55768f : this.f55765c);
    }

    public String h() {
        return this.f55770h;
    }

    public String i() {
        return this.f55771i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f55763a) && TextUtils.isEmpty(this.f55764b) && TextUtils.isEmpty(this.f55766d) && TextUtils.isEmpty(this.f55767e) && TextUtils.isEmpty(this.f55769g) && TextUtils.isEmpty(this.f55770h) && TextUtils.isEmpty(this.f55771i) && this.f55765c == 0 && this.f55768f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
