package d.a.n0.k1.o.j;

import android.text.TextUtils;
import d.a.n0.k1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f60339a;

    /* renamed from: b  reason: collision with root package name */
    public final String f60340b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60341c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60342d;

    /* renamed from: e  reason: collision with root package name */
    public final String f60343e;

    /* renamed from: f  reason: collision with root package name */
    public final int f60344f;

    /* renamed from: g  reason: collision with root package name */
    public final String f60345g;

    /* renamed from: h  reason: collision with root package name */
    public final String f60346h;

    /* renamed from: i  reason: collision with root package name */
    public final String f60347i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f60339a = jSONObject.optString("bIcon");
        this.f60340b = jSONObject.optString("bIconN");
        this.f60341c = jSONObject.optInt("bIconType");
        this.f60342d = jSONObject.optString("bSelIcon");
        this.f60343e = jSONObject.optString("bSelIconN");
        this.f60344f = jSONObject.optInt("bSelIconType");
        this.f60345g = jSONObject.optString("clickAction");
        this.f60346h = jSONObject.optString("preAction");
        this.f60347i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        return f.a(i2);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f60345g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f60342d : this.f60339a;
    }

    public String e() {
        return this.j ? this.f60343e : this.f60340b;
    }

    public int f() {
        return g(this.j ? this.f60344f : this.f60341c);
    }

    public String h() {
        return this.f60346h;
    }

    public String i() {
        return this.f60347i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f60339a) && TextUtils.isEmpty(this.f60340b) && TextUtils.isEmpty(this.f60342d) && TextUtils.isEmpty(this.f60343e) && TextUtils.isEmpty(this.f60345g) && TextUtils.isEmpty(this.f60346h) && TextUtils.isEmpty(this.f60347i) && this.f60341c == 0 && this.f60344f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
