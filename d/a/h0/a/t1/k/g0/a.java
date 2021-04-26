package d.a.h0.a.t1.k.g0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.e0.l.d;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static String f44468d = "SwanAppPageForbidden";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44469e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44470a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f44471b;

    /* renamed from: c  reason: collision with root package name */
    public String f44472c;

    /* renamed from: d.a.h0.a.t1.k.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0806a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f44475g;

        public RunnableC0806a(a aVar, f fVar, String str, d dVar) {
            this.f44473e = fVar;
            this.f44474f = str;
            this.f44475g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b i2 = this.f44473e.i(this.f44474f);
            i2.n(f.f42031g, f.f42033i);
            i2.j(this.f44475g);
            i2.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44476a = new a(null);
    }

    public /* synthetic */ a(RunnableC0806a runnableC0806a) {
        this();
    }

    public static a c() {
        return b.f44476a;
    }

    public boolean a(d.a.h0.a.e1.b bVar) {
        boolean z = false;
        if (bVar != null && d.a.h0.a.u.a.e(d.a.h0.a.r1.d.e().p().L())) {
            if (!this.f44470a) {
                i();
            }
            z = (g(bVar.f42392a) || g(bVar.f42395d)) ? true : true;
            if (f44469e) {
                String str = f44468d;
                Log.d(str, "check, hitPath = " + z + " params = " + bVar.toString());
            }
            return z;
        }
        return false;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && d.a.h0.a.u.a.e(d.a.h0.a.r1.d.e().p().L())) {
            String d2 = i0.d(str);
            if (!TextUtils.isEmpty(d2) && d2.startsWith("/")) {
                d2 = d2.substring(1);
            }
            if (!this.f44470a) {
                i();
            }
            boolean g2 = g(d2);
            if (f44469e) {
                String str2 = f44468d;
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
        return this.f44472c;
    }

    public final String f(String str) {
        return str + "_forbidden_tips";
    }

    public final boolean g(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.f44471b) == null || list.isEmpty()) {
            return false;
        }
        return this.f44471b.contains(str);
    }

    public void h(String str, d.a.h0.a.e1.b bVar) {
        f W;
        String a2;
        if (bVar == null || (W = d.a.h0.a.z0.f.V().W()) == null || (W.m() instanceof d)) {
            return;
        }
        if (g(bVar.f42395d)) {
            a2 = d.a.h0.a.e1.b.b(bVar);
        } else {
            a2 = d.a.h0.a.e1.b.a(bVar);
        }
        if (f44469e) {
            String str2 = f44468d;
            Log.d(str2, "jump from " + str + " ; path = " + a2);
        }
        e p = d.a.h0.a.r1.d.e().p();
        b.a J = p.J();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = p.getAppId();
        forbiddenInfo.appKey = p.B();
        forbiddenInfo.appTitle = J.J();
        forbiddenInfo.forbiddenReason = e();
        forbiddenInfo.launchSource = J.S();
        forbiddenInfo.launchPath = a2;
        forbiddenInfo.enableSlidingFlag = 0;
        k(forbiddenInfo);
        k0.X(new RunnableC0806a(this, W, str, d.D2(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, forbiddenInfo)));
    }

    public final void i() {
        d.a.h0.a.a2.g.b a2 = h.a();
        String B = d.a.h0.a.r1.d.e().p().B();
        String string = a2.getString(d(B), null);
        if (f44469e) {
            String str = f44468d;
            Log.d(str, "readDataSwanKv, appKey = " + B + " ; tips = " + this.f44472c + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.f44471b = null;
            this.f44472c = null;
        } else {
            JSONArray c2 = v.c(string);
            int length = c2.length();
            this.f44471b = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = c2.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    this.f44471b.add(optString);
                }
            }
            this.f44472c = a2.getString(f(B), null);
        }
        this.f44470a = true;
    }

    public void j() {
        if (f44469e) {
            Log.d(f44468d, "releaseData");
        }
        this.f44470a = false;
        this.f44472c = null;
        List<String> list = this.f44471b;
        if (list != null) {
            list.clear();
            this.f44471b = null;
        }
    }

    public final void k(ForbiddenInfo forbiddenInfo) {
        e O = e.O();
        if (O == null) {
            return;
        }
        O.p();
        SwanAppActivity v = O.v();
        if (v == null) {
            return;
        }
        String g2 = d.a.h0.a.b2.b.g(d.a.h0.a.z0.f.V().N(), O.L().F());
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(10L);
        aVar.h(48L);
        aVar.c("path forbiddeon");
        forbiddenInfo.forbiddenDetail = v.getString(d.a.h0.a.h.aiapps_open_failed_detail_format, k0.z(), g2, String.valueOf(aVar.a()));
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
            if (f44469e) {
                String str3 = f44468d;
                Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
                return;
            }
            return;
        }
        h.a().edit().remove(d2).remove(f2).apply();
        if (f44469e) {
            String str4 = f44468d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public a() {
        this.f44470a = false;
    }
}
