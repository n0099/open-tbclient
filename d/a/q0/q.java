package d.a.q0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f68137a;

    /* renamed from: b  reason: collision with root package name */
    public int f68138b;

    /* renamed from: c  reason: collision with root package name */
    public String f68139c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f68140d;

    /* renamed from: e  reason: collision with root package name */
    public long f68141e;

    /* renamed from: f  reason: collision with root package name */
    public long f68142f;

    /* renamed from: g  reason: collision with root package name */
    public int f68143g;

    /* renamed from: h  reason: collision with root package name */
    public String f68144h;

    /* renamed from: i  reason: collision with root package name */
    public String f68145i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public q() {
    }

    public long a() {
        return this.f68141e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f68139c;
    }

    public long d() {
        return this.f68142f;
    }

    public String e() {
        return this.f68145i;
    }

    public int f() {
        return this.f68138b;
    }

    public String g() {
        return this.f68137a;
    }

    public JSONObject h() {
        return this.f68140d;
    }

    public int i() {
        return this.f68143g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f68144h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f68141e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f68139c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f68142f = j;
    }

    public void r() {
        if (g.m().a(this.f68137a)) {
            this.f68145i = UBC.getUBCContext().h();
        }
    }

    public void s(String str) {
        this.f68145i = str;
    }

    public void t(int i2) {
        this.f68138b = i2;
    }

    public void u(String str) {
        this.f68137a = str;
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
        this.f68144h = str;
    }

    public q(String str, int i2, String str2, int i3) {
        this.f68137a = str;
        this.f68138b = i2;
        this.f68139c = str2;
        this.f68143g = i3;
    }

    public q(String str, int i2, JSONObject jSONObject, int i3) {
        this.f68137a = str;
        this.f68138b = i2;
        this.f68140d = jSONObject;
        this.f68143g = i3;
    }
}
