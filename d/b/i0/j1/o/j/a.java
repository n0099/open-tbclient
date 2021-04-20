package d.b.i0.j1.o.j;

import android.text.TextUtils;
import d.b.i0.j1.o.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f57377a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57378b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57379c;

    /* renamed from: d  reason: collision with root package name */
    public final String f57380d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57381e;

    /* renamed from: f  reason: collision with root package name */
    public final int f57382f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57383g;

    /* renamed from: h  reason: collision with root package name */
    public final String f57384h;
    public final String i;
    public boolean j = false;
    public boolean k = false;

    public a(JSONObject jSONObject) {
        this.f57377a = jSONObject.optString("bIcon");
        this.f57378b = jSONObject.optString("bIconN");
        this.f57379c = jSONObject.optInt("bIconType");
        this.f57380d = jSONObject.optString("bSelIcon");
        this.f57381e = jSONObject.optString("bSelIconN");
        this.f57382f = jSONObject.optInt("bSelIconType");
        this.f57383g = jSONObject.optString("clickAction");
        this.f57384h = jSONObject.optString("preAction");
        this.i = jSONObject.optString("statKey");
    }

    public static int g(int i) {
        return f.a(i);
    }

    public boolean a() {
        return f() > 0;
    }

    public String b() {
        return this.f57383g;
    }

    public boolean c() {
        return this.j;
    }

    public String d() {
        return this.j ? this.f57380d : this.f57377a;
    }

    public String e() {
        return this.j ? this.f57381e : this.f57378b;
    }

    public int f() {
        return g(this.j ? this.f57382f : this.f57379c);
    }

    public String h() {
        return this.f57384h;
    }

    public String i() {
        return this.i;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return (TextUtils.isEmpty(this.f57377a) && TextUtils.isEmpty(this.f57378b) && TextUtils.isEmpty(this.f57380d) && TextUtils.isEmpty(this.f57381e) && TextUtils.isEmpty(this.f57383g) && TextUtils.isEmpty(this.f57384h) && TextUtils.isEmpty(this.i) && this.f57379c == 0 && this.f57382f == 0) ? false : true;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(boolean z) {
        this.k = z;
    }
}
