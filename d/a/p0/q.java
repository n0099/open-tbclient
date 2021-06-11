package d.a.p0;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f67723a;

    /* renamed from: b  reason: collision with root package name */
    public int f67724b;

    /* renamed from: c  reason: collision with root package name */
    public String f67725c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67726d;

    /* renamed from: e  reason: collision with root package name */
    public long f67727e;

    /* renamed from: f  reason: collision with root package name */
    public long f67728f;

    /* renamed from: g  reason: collision with root package name */
    public int f67729g;

    /* renamed from: h  reason: collision with root package name */
    public String f67730h;

    /* renamed from: i  reason: collision with root package name */
    public String f67731i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public q() {
    }

    public long a() {
        return this.f67727e;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.f67725c;
    }

    public long d() {
        return this.f67728f;
    }

    public String e() {
        return this.f67731i;
    }

    public int f() {
        return this.f67724b;
    }

    public String g() {
        return this.f67723a;
    }

    public JSONObject h() {
        return this.f67726d;
    }

    public int i() {
        return this.f67729g;
    }

    public JSONArray j() {
        return this.k;
    }

    public String k() {
        return this.f67730h;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.f67727e = j;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.f67725c = str;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(long j) {
        this.f67728f = j;
    }

    public void r() {
        if (g.m().a(this.f67723a)) {
            this.f67731i = UBC.getUBCContext().h();
        }
    }

    public void s(String str) {
        this.f67731i = str;
    }

    public void t(int i2) {
        this.f67724b = i2;
    }

    public void u(String str) {
        this.f67723a = str;
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
        this.f67730h = str;
    }

    public q(String str, int i2, String str2, int i3) {
        this.f67723a = str;
        this.f67724b = i2;
        this.f67725c = str2;
        this.f67729g = i3;
    }

    public q(String str, int i2, JSONObject jSONObject, int i3) {
        this.f67723a = str;
        this.f67724b = i2;
        this.f67726d = jSONObject;
        this.f67729g = i3;
    }
}
