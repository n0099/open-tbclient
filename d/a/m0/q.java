package d.a.m0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f63992a;

    /* renamed from: b  reason: collision with root package name */
    public int f63993b;

    /* renamed from: c  reason: collision with root package name */
    public String f63994c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63995d;

    /* renamed from: e  reason: collision with root package name */
    public long f63996e;

    /* renamed from: f  reason: collision with root package name */
    public long f63997f;

    /* renamed from: g  reason: collision with root package name */
    public int f63998g;

    /* renamed from: h  reason: collision with root package name */
    public String f63999h;

    /* renamed from: i  reason: collision with root package name */
    public String f64000i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public q() {
    }

    public long a() {
        return this.f63996e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f63994c;
    }

    public long d() {
        return this.f63997f;
    }

    public String e() {
        return this.f64000i;
    }

    public int f() {
        return this.f63993b;
    }

    public String g() {
        return this.f63992a;
    }

    public JSONObject h() {
        return this.f63995d;
    }

    public int i() {
        return this.f63998g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f63999h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f63996e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f63994c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f63997f = j;
    }

    public void r() {
        if (g.m().a(this.f63992a)) {
            this.f64000i = UBC.getUBCContext().h();
        }
    }

    public void s(String str) {
        this.f64000i = str;
    }

    public void t(int i2) {
        this.f63993b = i2;
    }

    public void u(String str) {
        this.f63992a = str;
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
        this.f63999h = str;
    }

    public q(String str, int i2, String str2, int i3) {
        this.f63992a = str;
        this.f63993b = i2;
        this.f63994c = str2;
        this.f63998g = i3;
    }

    public q(String str, int i2, JSONObject jSONObject, int i3) {
        this.f63992a = str;
        this.f63993b = i2;
        this.f63995d = jSONObject;
        this.f63998g = i3;
    }
}
