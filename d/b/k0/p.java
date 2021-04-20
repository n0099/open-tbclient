package d.b.k0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f64681a;

    /* renamed from: b  reason: collision with root package name */
    public int f64682b;

    /* renamed from: c  reason: collision with root package name */
    public String f64683c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64684d;

    /* renamed from: e  reason: collision with root package name */
    public long f64685e;

    /* renamed from: f  reason: collision with root package name */
    public long f64686f;

    /* renamed from: g  reason: collision with root package name */
    public int f64687g;

    /* renamed from: h  reason: collision with root package name */
    public String f64688h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public p() {
    }

    public long a() {
        return this.f64685e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f64683c;
    }

    public long d() {
        return this.f64686f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f64682b;
    }

    public String g() {
        return this.f64681a;
    }

    public JSONObject h() {
        return this.f64684d;
    }

    public int i() {
        return this.f64687g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f64688h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f64685e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f64683c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f64686f = j;
    }

    public void r() {
        if (g.m().a(this.f64681a)) {
            this.i = UBC.getUBCContext().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f64682b = i;
    }

    public void u(String str) {
        this.f64681a = str;
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
        this.f64688h = str;
    }

    public p(String str, int i, String str2, int i2) {
        this.f64681a = str;
        this.f64682b = i;
        this.f64683c = str2;
        this.f64687g = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.f64681a = str;
        this.f64682b = i;
        this.f64684d = jSONObject;
        this.f64687g = i2;
    }
}
