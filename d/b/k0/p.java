package d.b.k0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f63980a;

    /* renamed from: b  reason: collision with root package name */
    public int f63981b;

    /* renamed from: c  reason: collision with root package name */
    public String f63982c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63983d;

    /* renamed from: e  reason: collision with root package name */
    public long f63984e;

    /* renamed from: f  reason: collision with root package name */
    public long f63985f;

    /* renamed from: g  reason: collision with root package name */
    public int f63986g;

    /* renamed from: h  reason: collision with root package name */
    public String f63987h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public p() {
    }

    public long a() {
        return this.f63984e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f63982c;
    }

    public long d() {
        return this.f63985f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f63981b;
    }

    public String g() {
        return this.f63980a;
    }

    public JSONObject h() {
        return this.f63983d;
    }

    public int i() {
        return this.f63986g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f63987h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f63984e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f63982c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f63985f = j;
    }

    public void r() {
        if (g.m().a(this.f63980a)) {
            this.i = UBC.getUBCContext().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f63981b = i;
    }

    public void u(String str) {
        this.f63980a = str;
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
        this.f63987h = str;
    }

    public p(String str, int i, String str2, int i2) {
        this.f63980a = str;
        this.f63981b = i;
        this.f63982c = str2;
        this.f63986g = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.f63980a = str;
        this.f63981b = i;
        this.f63983d = jSONObject;
        this.f63986g = i2;
    }
}
