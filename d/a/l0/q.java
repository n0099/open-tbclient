package d.a.l0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f63268a;

    /* renamed from: b  reason: collision with root package name */
    public int f63269b;

    /* renamed from: c  reason: collision with root package name */
    public String f63270c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63271d;

    /* renamed from: e  reason: collision with root package name */
    public long f63272e;

    /* renamed from: f  reason: collision with root package name */
    public long f63273f;

    /* renamed from: g  reason: collision with root package name */
    public int f63274g;

    /* renamed from: h  reason: collision with root package name */
    public String f63275h;

    /* renamed from: i  reason: collision with root package name */
    public String f63276i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public q() {
    }

    public long a() {
        return this.f63272e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f63270c;
    }

    public long d() {
        return this.f63273f;
    }

    public String e() {
        return this.f63276i;
    }

    public int f() {
        return this.f63269b;
    }

    public String g() {
        return this.f63268a;
    }

    public JSONObject h() {
        return this.f63271d;
    }

    public int i() {
        return this.f63274g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f63275h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f63272e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f63270c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f63273f = j;
    }

    public void r() {
        if (g.m().a(this.f63268a)) {
            this.f63276i = UBC.getUBCContext().g();
        }
    }

    public void s(String str) {
        this.f63276i = str;
    }

    public void t(int i2) {
        this.f63269b = i2;
    }

    public void u(String str) {
        this.f63268a = str;
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
        this.f63275h = str;
    }

    public q(String str, int i2, String str2, int i3) {
        this.f63268a = str;
        this.f63269b = i2;
        this.f63270c = str2;
        this.f63274g = i3;
    }

    public q(String str, int i2, JSONObject jSONObject, int i3) {
        this.f63268a = str;
        this.f63269b = i2;
        this.f63271d = jSONObject;
        this.f63274g = i3;
    }
}
