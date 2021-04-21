package d.b.h0.a.t1.k.g0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.e0.l.d;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.i0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.v;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f47076d = "SwanAppPageForbidden";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f47077e = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47078a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f47079b;

    /* renamed from: c  reason: collision with root package name */
    public String f47080c;

    /* renamed from: d.b.h0.a.t1.k.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0867a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f47083g;

        public RunnableC0867a(a aVar, f fVar, String str, d dVar) {
            this.f47081e = fVar;
            this.f47082f = str;
            this.f47083g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b i = this.f47081e.i(this.f47082f);
            i.n(f.f44734g, f.i);
            i.j(this.f47083g);
            i.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f47084a = new a(null);
    }

    public /* synthetic */ a(RunnableC0867a runnableC0867a) {
        this();
    }

    public static a c() {
        return b.f47084a;
    }

    public boolean a(d.b.h0.a.e1.b bVar) {
        boolean z = false;
        if (bVar != null && d.b.h0.a.u.a.e(d.b.h0.a.r1.d.e().s().L())) {
            if (!this.f47078a) {
                i();
            }
            z = (g(bVar.f45083a) || g(bVar.f45086d)) ? true : true;
            if (f47077e) {
                String str = f47076d;
                Log.d(str, "check, hitPath = " + z + " params = " + bVar.toString());
            }
            return z;
        }
        return false;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && d.b.h0.a.u.a.e(d.b.h0.a.r1.d.e().s().L())) {
            String d2 = i0.d(str);
            if (!TextUtils.isEmpty(d2) && d2.startsWith("/")) {
                d2 = d2.substring(1);
            }
            if (!this.f47078a) {
                i();
            }
            boolean g2 = g(d2);
            if (f47077e) {
                String str2 = f47076d;
                Log.d(str2, "check, hitPath = " + g2 + " path = " + str);
            }
            return g2;
        }
        return false;
    }

    public final String d(String str) {
        return str + "_forbidden_path";
    }

    public String e() {
        return this.f47080c;
    }

    public final String f(String str) {
        return str + "_forbidden_tips";
    }

    public final boolean g(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.f47079b) == null || list.isEmpty()) {
            return false;
        }
        return this.f47079b.contains(str);
    }

    public void h(String str, d.b.h0.a.e1.b bVar) {
        f W;
        String a2;
        if (bVar == null || (W = d.b.h0.a.z0.f.V().W()) == null || (W.m() instanceof d)) {
            return;
        }
        if (g(bVar.f45086d)) {
            a2 = d.b.h0.a.e1.b.b(bVar);
        } else {
            a2 = d.b.h0.a.e1.b.a(bVar);
        }
        if (f47077e) {
            String str2 = f47076d;
            Log.d(str2, "jump from " + str + " ; path = " + a2);
        }
        e s = d.b.h0.a.r1.d.e().s();
        b.a J = s.J();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = s.getAppId();
        forbiddenInfo.appKey = s.B();
        forbiddenInfo.appTitle = J.J();
        forbiddenInfo.forbiddenReason = e();
        forbiddenInfo.launchSource = J.S();
        forbiddenInfo.launchPath = a2;
        forbiddenInfo.enableSlidingFlag = 0;
        k(forbiddenInfo);
        k0.X(new RunnableC0867a(this, W, str, d.E2(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, forbiddenInfo)));
    }

    public final void i() {
        d.b.h0.a.a2.g.b a2 = h.a();
        String B = d.b.h0.a.r1.d.e().s().B();
        String string = a2.getString(d(B), null);
        if (f47077e) {
            String str = f47076d;
            Log.d(str, "readDataSwanKv, appKey = " + B + " ; tips = " + this.f47080c + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.f47079b = null;
            this.f47080c = null;
        } else {
            JSONArray c2 = v.c(string);
            int length = c2.length();
            this.f47079b = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = c2.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.f47079b.add(optString);
                }
            }
            this.f47080c = a2.getString(f(B), null);
        }
        this.f47078a = true;
    }

    public void j() {
        if (f47077e) {
            Log.d(f47076d, "releaseData");
        }
        this.f47078a = false;
        this.f47080c = null;
        List<String> list = this.f47079b;
        if (list != null) {
            list.clear();
            this.f47079b = null;
        }
    }

    public final void k(ForbiddenInfo forbiddenInfo) {
        e O = e.O();
        if (O == null) {
            return;
        }
        O.s();
        SwanAppActivity n = O.n();
        if (n == null) {
            return;
        }
        String g2 = d.b.h0.a.b2.b.g(d.b.h0.a.z0.f.V().L(), O.L().F());
        d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
        aVar.j(10L);
        aVar.h(48L);
        aVar.c("path forbiddeon");
        forbiddenInfo.forbiddenDetail = n.getString(d.b.h0.a.h.aiapps_open_failed_detail_format, k0.z(), g2, String.valueOf(aVar.a()));
    }

    public void l(JSONArray jSONArray, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String d2 = d(str2);
        String f2 = f(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            String jSONArray2 = jSONArray.toString();
            h.a().edit().putString(d2, jSONArray2).putString(f2, str).apply();
            if (f47077e) {
                String str3 = f47076d;
                Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
                return;
            }
            return;
        }
        h.a().edit().remove(d2).remove(f2).apply();
        if (f47077e) {
            String str4 = f47076d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public a() {
        this.f47078a = false;
    }
}
