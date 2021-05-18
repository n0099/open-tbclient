package d.a.k0.j1.o.j;

import android.text.TextUtils;
import d.a.k0.j1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f56470a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56471b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56472c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56473d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56474e;

    /* renamed from: f  reason: collision with root package name */
    public final int f56475f;

    /* renamed from: g  reason: collision with root package name */
    public final String f56476g;

    /* renamed from: h  reason: collision with root package name */
    public final String f56477h;

    /* renamed from: i  reason: collision with root package name */
    public final String f56478i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f56470a = jSONObject.optString("bIcon");
        this.f56471b = jSONObject.optString("bIconN");
        this.f56472c = jSONObject.optInt("bIconType");
        this.f56473d = jSONObject.optString("bSelIcon");
        this.f56474e = jSONObject.optString("bSelIconN");
        this.f56475f = jSONObject.optInt("bSelIconType");
        this.f56476g = jSONObject.optString("clickAction");
        this.f56477h = jSONObject.optString("preAction");
        this.f56478i = jSONObject.optString("statKey");
    }

    public static int g(int i2) {
        return f.a(i2);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f56476g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f56473d : this.f56470a;
    }

    public String e() {
        return this.j ? this.f56474e : this.f56471b;
    }

    public int f() {
        return g(this.j ? this.f56475f : this.f56472c);
    }

    public String h() {
        return this.f56477h;
    }

    public String i() {
        return this.f56478i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f56470a) && TextUtils.isEmpty(this.f56471b) && TextUtils.isEmpty(this.f56473d) && TextUtils.isEmpty(this.f56474e) && TextUtils.isEmpty(this.f56476g) && TextUtils.isEmpty(this.f56477h) && TextUtils.isEmpty(this.f56478i) && this.f56472c == 0 && this.f56475f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
