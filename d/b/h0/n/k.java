package d.b.h0.n;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f49976a;

    /* renamed from: b  reason: collision with root package name */
    public int f49977b;

    /* renamed from: c  reason: collision with root package name */
    public String f49978c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49979d;

    /* renamed from: e  reason: collision with root package name */
    public long f49980e;

    /* renamed from: f  reason: collision with root package name */
    public long f49981f;

    /* renamed from: g  reason: collision with root package name */
    public int f49982g;

    /* renamed from: h  reason: collision with root package name */
    public String f49983h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public long a() {
        return this.f49980e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f49978c;
    }

    public long d() {
        return this.f49981f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f49977b;
    }

    public String g() {
        return this.f49976a;
    }

    public JSONObject h() {
        return this.f49979d;
    }

    public int i() {
        return this.f49982g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f49983h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f49980e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f49978c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f49981f = j;
    }

    public void r() {
        if (d.g().a(this.f49976a)) {
            this.i = e.g().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f49977b = i;
    }

    public void u(String str) {
        this.f49976a = str;
    }

    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.k = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void w(String str) {
        this.f49983h = str;
    }

    public k(String str, int i, String str2, int i2, boolean z) {
        this.f49976a = str;
        this.f49977b = i;
        this.f49978c = str2;
        this.f49982g = i2;
    }
}
