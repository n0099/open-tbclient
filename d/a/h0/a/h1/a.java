package d.a.h0.a.h1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import d.a.h0.a.p.c.d;
import d.a.h0.a.r1.e;
import d.a.h0.a.z0.f;
import d.a.h0.n.l;
import d.a.h0.n.m;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42647c = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f42649b = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f42648a = AppRuntime.getAppContext();

    @Override // d.a.h0.n.l
    public boolean a(String str) {
        int i2;
        d N = d.a.h0.a.w0.a.N();
        if (N != null) {
            N.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
        }
        if (TextUtils.isEmpty("")) {
            return false;
        }
        try {
            i2 = new JSONObject("").getInt("probability");
        } catch (JSONException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return new Random().nextInt(100) < i2;
    }

    @Override // d.a.h0.n.l
    public ExecutorService b() {
        return d.a.h0.a.w0.a.c0().b();
    }

    @Override // d.a.h0.n.l
    public void c(String str, int i2, JSONArray jSONArray) {
        d.a.h0.a.w0.a.c0().c(str, i2, jSONArray);
    }

    @Override // d.a.h0.n.l
    public void d(String str, int i2) {
        d.a.h0.a.w0.a.c0().d(str, i2);
    }

    @Override // d.a.h0.n.l
    public void e(String str, String str2, int i2, String str3, int i3) {
        d.a.h0.a.w0.a.c0().e(str, str2, i2, str3, i3);
    }

    @Override // d.a.h0.n.l
    public String f() {
        return d.a.h0.a.w0.a.k().f();
    }

    @Override // d.a.h0.n.l
    public String g() {
        d N = d.a.h0.a.w0.a.N();
        return N != null ? N.o() : "";
    }

    @Override // d.a.h0.n.l
    public String getAppId() {
        e F = f.V().F();
        return F != null ? F.f43823f : "";
    }

    @Override // d.a.h0.n.l
    public String getAppVersion() {
        e F = f.V().F();
        return F != null ? F.L().n1() : "";
    }

    @Override // d.a.h0.n.l
    public void h(String str, int i2, String str2) {
        d.a.h0.a.w0.a.c0().h(str, i2, str2);
    }

    @Override // d.a.h0.n.l
    public String i() {
        return d.a.h0.a.l.a();
    }

    @Override // d.a.h0.n.l
    public int j() {
        return d.a.h0.a.r1.d.e().j();
    }

    @Override // d.a.h0.n.l
    public m k() {
        return d.a.h0.a.w0.a.B().k();
    }

    @Override // d.a.h0.n.l
    public String l() {
        return d.a.h0.a.b2.b.f(j());
    }

    @Override // d.a.h0.n.l
    public void m(String str, String str2, int i2, String str3, long j, int i3) {
        d.a.h0.a.w0.a.c0().m(str, str2, i2, str3, j, i3);
    }

    @Override // d.a.h0.n.l
    public String n(Context context) {
        return d.a.h0.q.b.b(context).a();
    }

    @Override // d.a.h0.n.l
    public boolean o() {
        if (this.f42649b == null) {
            d.a.h0.a.w0.a.N().getSwitch("swan_ceres_add_counter", false);
            this.f42649b = false;
        }
        return this.f42649b.booleanValue();
    }

    @Override // d.a.h0.n.l
    public boolean p() {
        return d.a.h0.a.m1.a.a.R() && (q() || k.f43102b);
    }

    @Override // d.a.h0.n.l
    public boolean q() {
        return f42647c && PreferenceManager.getDefaultSharedPreferences(d.a.h0.a.w0.a.c()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // d.a.h0.n.l
    public String r(Context context) {
        return d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c());
    }

    @Override // d.a.h0.n.l
    public String s(Context context) {
        return d.a.h0.a.w0.a.O().e(d.a.h0.a.w0.a.c());
    }
}
