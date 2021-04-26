package d.a.h0.n;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f47505a;

    /* renamed from: b  reason: collision with root package name */
    public int f47506b;

    /* renamed from: c  reason: collision with root package name */
    public String f47507c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f47508d;

    /* renamed from: e  reason: collision with root package name */
    public long f47509e;

    /* renamed from: f  reason: collision with root package name */
    public long f47510f;

    /* renamed from: g  reason: collision with root package name */
    public int f47511g;

    /* renamed from: h  reason: collision with root package name */
    public String f47512h;

    /* renamed from: i  reason: collision with root package name */
    public String f47513i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public long a() {
        return this.f47509e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f47507c;
    }

    public long d() {
        return this.f47510f;
    }

    public String e() {
        return this.f47513i;
    }

    public int f() {
        return this.f47506b;
    }

    public String g() {
        return this.f47505a;
    }

    public JSONObject h() {
        return this.f47508d;
    }

    public int i() {
        return this.f47511g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f47512h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f47509e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f47507c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f47510f = j;
    }

    public void r() {
        if (d.g().a(this.f47505a)) {
            this.f47513i = e.g().g();
        }
    }

    public void s(String str) {
        this.f47513i = str;
    }

    public void t(int i2) {
        this.f47506b = i2;
    }

    public void u(String str) {
        this.f47505a = str;
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
        this.f47512h = str;
    }

    public k(String str, int i2, String str2, int i3, boolean z) {
        this.f47505a = str;
        this.f47506b = i2;
        this.f47507c = str2;
        this.f47511g = i3;
    }
}
