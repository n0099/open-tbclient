package d.a.p0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f64005a;

    /* renamed from: b  reason: collision with root package name */
    public int f64006b;

    /* renamed from: c  reason: collision with root package name */
    public String f64007c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64008d;

    /* renamed from: e  reason: collision with root package name */
    public long f64009e;

    /* renamed from: f  reason: collision with root package name */
    public long f64010f;

    /* renamed from: g  reason: collision with root package name */
    public int f64011g;

    /* renamed from: h  reason: collision with root package name */
    public String f64012h;

    /* renamed from: i  reason: collision with root package name */
    public String f64013i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public q() {
    }

    public long a() {
        return this.f64009e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f64007c;
    }

    public long d() {
        return this.f64010f;
    }

    public String e() {
        return this.f64013i;
    }

    public int f() {
        return this.f64006b;
    }

    public String g() {
        return this.f64005a;
    }

    public JSONObject h() {
        return this.f64008d;
    }

    public int i() {
        return this.f64011g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f64012h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f64009e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f64007c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f64010f = j;
    }

    public void r() {
        if (g.m().a(this.f64005a)) {
            this.f64013i = UBC.getUBCContext().h();
        }
    }

    public void s(String str) {
        this.f64013i = str;
    }

    public void t(int i2) {
        this.f64006b = i2;
    }

    public void u(String str) {
        this.f64005a = str;
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
        this.f64012h = str;
    }

    public q(String str, int i2, String str2, int i3) {
        this.f64005a = str;
        this.f64006b = i2;
        this.f64007c = str2;
        this.f64011g = i3;
    }

    public q(String str, int i2, JSONObject jSONObject, int i3) {
        this.f64005a = str;
        this.f64006b = i2;
        this.f64008d = jSONObject;
        this.f64011g = i3;
    }
}
