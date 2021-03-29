package d.b.i0.i1.o.j;

import android.text.TextUtils;
import d.b.i0.i1.o.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f55930a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55931b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55932c;

    /* renamed from: d  reason: collision with root package name */
    public final String f55933d;

    /* renamed from: e  reason: collision with root package name */
    public final String f55934e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55935f;

    /* renamed from: g  reason: collision with root package name */
    public final String f55936g;

    /* renamed from: h  reason: collision with root package name */
    public final String f55937h;
    public final String i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f55930a = jSONObject.optString("bIcon");
        this.f55931b = jSONObject.optString("bIconN");
        this.f55932c = jSONObject.optInt("bIconType");
        this.f55933d = jSONObject.optString("bSelIcon");
        this.f55934e = jSONObject.optString("bSelIconN");
        this.f55935f = jSONObject.optInt("bSelIconType");
        this.f55936g = jSONObject.optString("clickAction");
        this.f55937h = jSONObject.optString("preAction");
        this.i = jSONObject.optString("statKey");
    }

    public static int g(int i) {
        return f.a(i);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f55936g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f55933d : this.f55930a;
    }

    public String e() {
        return this.j ? this.f55934e : this.f55931b;
    }

    public int f() {
        return g(this.j ? this.f55935f : this.f55932c);
    }

    public String h() {
        return this.f55937h;
    }

    public String i() {
        return this.i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f55930a) && TextUtils.isEmpty(this.f55931b) && TextUtils.isEmpty(this.f55933d) && TextUtils.isEmpty(this.f55934e) && TextUtils.isEmpty(this.f55936g) && TextUtils.isEmpty(this.f55937h) && TextUtils.isEmpty(this.i) && this.f55932c == 0 && this.f55935f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
