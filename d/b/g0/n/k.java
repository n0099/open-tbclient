package d.b.g0.n;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f49647a;

    /* renamed from: b  reason: collision with root package name */
    public int f49648b;

    /* renamed from: c  reason: collision with root package name */
    public String f49649c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49650d;

    /* renamed from: e  reason: collision with root package name */
    public long f49651e;

    /* renamed from: f  reason: collision with root package name */
    public long f49652f;

    /* renamed from: g  reason: collision with root package name */
    public int f49653g;

    /* renamed from: h  reason: collision with root package name */
    public String f49654h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public long a() {
        return this.f49651e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f49649c;
    }

    public long d() {
        return this.f49652f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f49648b;
    }

    public String g() {
        return this.f49647a;
    }

    public JSONObject h() {
        return this.f49650d;
    }

    public int i() {
        return this.f49653g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f49654h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f49651e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f49649c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f49652f = j;
    }

    public void r() {
        if (d.g().a(this.f49647a)) {
            this.i = e.g().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f49648b = i;
    }

    public void u(String str) {
        this.f49647a = str;
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
        this.f49654h = str;
    }

    public k(String str, int i, String str2, int i2, boolean z) {
        this.f49647a = str;
        this.f49648b = i;
        this.f49649c = str2;
        this.f49653g = i2;
    }
}
