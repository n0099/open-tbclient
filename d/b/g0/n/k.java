package d.b.g0.n;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f49255a;

    /* renamed from: b  reason: collision with root package name */
    public int f49256b;

    /* renamed from: c  reason: collision with root package name */
    public String f49257c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49258d;

    /* renamed from: e  reason: collision with root package name */
    public long f49259e;

    /* renamed from: f  reason: collision with root package name */
    public long f49260f;

    /* renamed from: g  reason: collision with root package name */
    public int f49261g;

    /* renamed from: h  reason: collision with root package name */
    public String f49262h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public long a() {
        return this.f49259e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f49257c;
    }

    public long d() {
        return this.f49260f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f49256b;
    }

    public String g() {
        return this.f49255a;
    }

    public JSONObject h() {
        return this.f49258d;
    }

    public int i() {
        return this.f49261g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f49262h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f49259e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f49257c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f49260f = j;
    }

    public void r() {
        if (d.g().a(this.f49255a)) {
            this.i = e.g().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f49256b = i;
    }

    public void u(String str) {
        this.f49255a = str;
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
        this.f49262h = str;
    }

    public k(String str, int i, String str2, int i2, boolean z) {
        this.f49255a = str;
        this.f49256b = i;
        this.f49257c = str2;
        this.f49261g = i2;
    }
}
