package d.b.k0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f63981a;

    /* renamed from: b  reason: collision with root package name */
    public int f63982b;

    /* renamed from: c  reason: collision with root package name */
    public String f63983c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63984d;

    /* renamed from: e  reason: collision with root package name */
    public long f63985e;

    /* renamed from: f  reason: collision with root package name */
    public long f63986f;

    /* renamed from: g  reason: collision with root package name */
    public int f63987g;

    /* renamed from: h  reason: collision with root package name */
    public String f63988h;
    public String i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public p() {
    }

    public long a() {
        return this.f63985e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f63983c;
    }

    public long d() {
        return this.f63986f;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.f63982b;
    }

    public String g() {
        return this.f63981a;
    }

    public JSONObject h() {
        return this.f63984d;
    }

    public int i() {
        return this.f63987g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f63988h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f63985e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f63983c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f63986f = j;
    }

    public void r() {
        if (g.m().a(this.f63981a)) {
            this.i = UBC.getUBCContext().i();
        }
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(int i) {
        this.f63982b = i;
    }

    public void u(String str) {
        this.f63981a = str;
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
        this.f63988h = str;
    }

    public p(String str, int i, String str2, int i2) {
        this.f63981a = str;
        this.f63982b = i;
        this.f63983c = str2;
        this.f63987g = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.f63981a = str;
        this.f63982b = i;
        this.f63984d = jSONObject;
        this.f63987g = i2;
    }
}
