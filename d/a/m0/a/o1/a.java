package d.a.m0.a.o1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.a2.d;
import d.a.m0.a.a2.e;
import d.a.m0.a.g1.f;
import d.a.m0.a.k;
import d.a.m0.a.p.d.m;
import d.a.m0.a.v2.q0;
import d.a.m0.r.l;
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
    public static final boolean f47712c = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f47714b = null;

    /* renamed from: a  reason: collision with root package name */
    public Context f47713a = AppRuntime.getAppContext();

    @Override // d.a.m0.r.l
    public String a() {
        return d.a.m0.a.c1.a.m().a();
    }

    @Override // d.a.m0.r.l
    public String b() {
        return d.a.m0.a.l.a();
    }

    @Override // d.a.m0.r.l
    public boolean c(String str) {
        int i2;
        m Z = d.a.m0.a.c1.a.Z();
        if (Z != null) {
            Z.getSwitch("ANDROID_UBC_SAMPLE_" + str, "");
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

    @Override // d.a.m0.r.l
    public ExecutorService d() {
        return d.a.m0.a.c1.a.p0().d();
    }

    @Override // d.a.m0.r.l
    public void e(String str, int i2, JSONArray jSONArray) {
        d.a.m0.a.c1.a.p0().e(str, i2, jSONArray);
    }

    @Override // d.a.m0.r.l
    public void f(String str, int i2) {
        d.a.m0.a.c1.a.p0().f(str, i2);
    }

    @Override // d.a.m0.r.l
    public void g(String str, String str2, int i2, String str3, int i3) {
        d.a.m0.a.c1.a.p0().g(str, str2, i2, str3, i3);
    }

    @Override // d.a.m0.r.l
    public String getAppId() {
        e F = f.V().F();
        return F != null ? F.f44533f : "";
    }

    @Override // d.a.m0.r.l
    public String getAppVersion() {
        e F = f.V().F();
        return F != null ? F.N().u1() : "";
    }

    @Override // d.a.m0.r.l
    public String getDeviceId(Context context) {
        return d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b());
    }

    @Override // d.a.m0.r.l
    public String h() {
        m Z = d.a.m0.a.c1.a.Z();
        return Z != null ? Z.q() : "";
    }

    @Override // d.a.m0.r.l
    public void i(String str, int i2, String str2) {
        d.a.m0.a.c1.a.p0().i(str, i2, str2);
    }

    @Override // d.a.m0.r.l
    public boolean j() {
        return d.a.m0.a.c1.a.Z().j();
    }

    @Override // d.a.m0.r.l
    public String k() {
        e F = f.V().F();
        return F != null ? F.L().T() : "";
    }

    @Override // d.a.m0.r.l
    public int l() {
        return d.g().l();
    }

    @Override // d.a.m0.r.l
    public d.a.m0.r.m m() {
        return d.a.m0.a.c1.a.J().m();
    }

    @Override // d.a.m0.r.l
    public String n() {
        return d.a.m0.a.m2.b.h(l());
    }

    @Override // d.a.m0.r.l
    public void o(String str, String str2, int i2, String str3, long j, int i3) {
        d.a.m0.a.c1.a.p0().o(str, str2, i2, str3, j, i3);
    }

    @Override // d.a.m0.r.l
    public String p(Context context) {
        return d.a.m0.u.b.b(context).a();
    }

    @Override // d.a.m0.r.l
    public boolean q() {
        if (this.f47714b == null) {
            d.a.m0.a.c1.a.Z().getSwitch("swan_ceres_add_counter", false);
            this.f47714b = false;
        }
        return this.f47714b.booleanValue();
    }

    @Override // d.a.m0.r.l
    public boolean r() {
        return d.a.m0.a.u1.a.a.V() && (s() || k.f46984b);
    }

    @Override // d.a.m0.r.l
    public boolean s() {
        return f47712c && PreferenceManager.getDefaultSharedPreferences(d.a.m0.a.c1.a.b()).getBoolean("KEY_UBC_DEBUG", true);
    }

    @Override // d.a.m0.r.l
    public String t() {
        String b2 = d.a.m0.a.c1.a.m().b();
        if (q0.G() || TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2;
    }

    @Override // d.a.m0.r.l
    public String u() {
        return d.a.m0.a.d0.a.b();
    }

    @Override // d.a.m0.r.l
    public String v(Context context) {
        return d.a.m0.a.c1.a.a0().h(d.a.m0.a.c1.a.b());
    }
}
