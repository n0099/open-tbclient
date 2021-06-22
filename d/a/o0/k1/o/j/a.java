package d.a.o0.k1.o.j;

import android.text.TextUtils;
import d.a.o0.k1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f60464a;

    /* renamed from: b  reason: collision with root package name */
    public final String f60465b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60466c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60467d;

    /* renamed from: e  reason: collision with root package name */
    public final String f60468e;

    /* renamed from: f  reason: collision with root package name */
    public final int f60469f;

    /* renamed from: g  reason: collision with root package name */
    public final String f60470g;

    /* renamed from: h  reason: collision with root package name */
    public final String f60471h;

    /* renamed from: i  reason: collision with root package name */
    public final String f60472i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f60464a = jSONObject.optString("bIcon");
        this.f60465b = jSONObject.optString("bIconN");
        this.f60466c = jSONObject.optInt("bIconType");
        this.f60467d = jSONObject.optString("bSelIcon");
        this.f60468e = jSONObject.optString("bSelIconN");
        this.f60469f = jSONObject.optInt("bSelIconType");
        this.f60470g = jSONObject.optString("clickAction");
        this.f60471h = jSONObject.optString("preAction");
        this.f60472i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        return f.a(i2);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f60470g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f60467d : this.f60464a;
    }

    public String e() {
        return this.j ? this.f60468e : this.f60465b;
    }

    public int f() {
        return g(this.j ? this.f60469f : this.f60466c);
    }

    public String h() {
        return this.f60471h;
    }

    public String i() {
        return this.f60472i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f60464a) && TextUtils.isEmpty(this.f60465b) && TextUtils.isEmpty(this.f60467d) && TextUtils.isEmpty(this.f60468e) && TextUtils.isEmpty(this.f60470g) && TextUtils.isEmpty(this.f60471h) && TextUtils.isEmpty(this.f60472i) && this.f60466c == 0 && this.f60469f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
