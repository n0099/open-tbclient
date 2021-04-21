package d.b.h0.a.h1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
import d.b.h0.a.p.c.d;
import d.b.h0.a.r1.e;
import d.b.h0.a.z0.f;
import d.b.h0.n.l;
import d.b.h0.n.m;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45332c = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f45334b = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f45333a = AppRuntime.getAppContext();

    @Override // d.b.h0.n.l
    public boolean a(String str) {
        int i;
        d N = d.b.h0.a.w0.a.N();
        if (N != null) {
            N.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
        }
        if (TextUtils.isEmpty("")) {
            return false;
        }
        try {
            i = new JSONObject("").getInt("probability");
        } catch (JSONException e2) {
            e2.printStackTrace();
            i = 0;
        }
        return new Random().nextInt(100) < i;
    }

    @Override // d.b.h0.n.l
    public String b() {
        return d.b.h0.a.l.a();
    }

    @Override // d.b.h0.n.l
    public ExecutorService c() {
        return d.b.h0.a.w0.a.c0().c();
    }

    @Override // d.b.h0.n.l
    public void d(String str, int i, JSONArray jSONArray) {
        d.b.h0.a.w0.a.c0().d(str, i, jSONArray);
    }

    @Override // d.b.h0.n.l
    public void e(String str, int i) {
        d.b.h0.a.w0.a.c0().e(str, i);
    }

    @Override // d.b.h0.n.l
    public void f(String str, String str2, int i, String str3, int i2) {
        d.b.h0.a.w0.a.c0().f(str, str2, i, str3, i2);
    }

    @Override // d.b.h0.n.l
    public String g() {
        return d.b.h0.a.w0.a.k().g();
    }

    @Override // d.b.h0.n.l
    public String getAppId() {
        e t = f.V().t();
        return t != null ? t.f46461f : "";
    }

    @Override // d.b.h0.n.l
    public String getAppVersion() {
        e t = f.V().t();
        return t != null ? t.L().n1() : "";
    }

    @Override // d.b.h0.n.l
    public int h() {
        return d.b.h0.a.r1.d.e().h();
    }

    @Override // d.b.h0.n.l
    public String i() {
        d N = d.b.h0.a.w0.a.N();
        return N != null ? N.y() : "";
    }

    @Override // d.b.h0.n.l
    public m j() {
        return d.b.h0.a.w0.a.B().j();
    }

    @Override // d.b.h0.n.l
    public void k(String str, int i, String str2) {
        d.b.h0.a.w0.a.c0().k(str, i, str2);
    }

    @Override // d.b.h0.n.l
    public String l() {
        return d.b.h0.a.b2.b.f(h());
    }

    @Override // d.b.h0.n.l
    public void m(String str, String str2, int i, String str3, long j, int i2) {
        d.b.h0.a.w0.a.c0().m(str, str2, i, str3, j, i2);
    }

    @Override // d.b.h0.n.l
    public String n(Context context) {
        return d.b.h0.a.w0.a.O().c(d.b.h0.a.w0.a.c());
    }

    @Override // d.b.h0.n.l
    public String o(Context context) {
        return d.b.h0.q.b.b(context).a();
    }

    @Override // d.b.h0.n.l
    public boolean p() {
        if (this.f45334b == null) {
            d.b.h0.a.w0.a.N().getSwitch("swan_ceres_add_counter", false);
            this.f45334b = false;
        }
        return this.f45334b.booleanValue();
    }

    @Override // d.b.h0.n.l
    public boolean q() {
        return d.b.h0.a.m1.a.a.R() && (s() || k.f45773b);
    }

    @Override // d.b.h0.n.l
    public String r(Context context) {
        return d.b.h0.a.w0.a.O().a(d.b.h0.a.w0.a.c());
    }

    @Override // d.b.h0.n.l
    public boolean s() {
        return f45332c && PreferenceManager.getDefaultSharedPreferences(d.b.h0.a.w0.a.c()).getBoolean("KEY_UBC_DEBUG", true);
    }
}
