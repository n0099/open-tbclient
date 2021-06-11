package d.a.l0.a.h0.t.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.e0.d;
import d.a.l0.a.h0.g.f;
import d.a.l0.a.h0.t.c.b;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46272a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46273b;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_next_page_res_load", 0);
        f46273b = false;
        d.h("SwanAppSlaveTopPages", "swan_top_page_res_load - " + f46273b);
        j();
    }

    public static b.a a(@NonNull d.a.l0.a.p.e.b<?> bVar, @NonNull PMSAppInfo pMSAppInfo) {
        Set<String> k = k(pMSAppInfo);
        if (k != null && k.size() > 0) {
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.versionCode);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String str2 = e.C0617e.i(str, valueOf).getPath() + File.separator;
                b bVar2 = new b();
                for (String str3 : k) {
                    if (g(str2, str3)) {
                        bVar2.a(e(bVar, d.a.l0.a.l1.b.e(o0.g(str3), str2)));
                    }
                }
                return bVar2.b();
            }
        }
        return null;
    }

    public static d.a.l0.a.l1.b b() {
        SwanAppActivity x;
        f J;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || (x = Q.x()) == null || x.isFinishing() || x.isDestroyed() || (J = d.a.l0.a.g1.f.V().J()) == null) {
            return null;
        }
        return J.Z2();
    }

    public static void c(@NonNull PMSAppInfo pMSAppInfo, @Nullable b.a aVar) {
    }

    public static b.a d(@NonNull PMSAppInfo pMSAppInfo) {
        return null;
    }

    public static d.a.l0.a.o0.d.b e(d.a.l0.a.p.e.b<?> bVar, d.a.l0.a.l1.b bVar2) {
        return d.a.l0.a.h0.u.d.a(d.a.l0.a.c2.f.p0.a.a(bVar, bVar2, ""));
    }

    public static JSONObject f(PMSAppInfo pMSAppInfo) {
        return d.a.l0.a.l1.d.d.f().i(pMSAppInfo);
    }

    public static boolean g(String str, String str2) {
        return e.C(str, str2);
    }

    public static void h(d.a.l0.a.p.e.b<?> bVar) {
        PMSAppInfo f0;
        if (f46273b && bVar != null) {
            long currentTimeMillis = f46272a ? System.currentTimeMillis() : 0L;
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q == null || (f0 = Q.L().f0()) == null) {
                return;
            }
            b.a d2 = d(f0);
            if (d2 == null) {
                d2 = a(bVar, f0);
                c(f0, d2);
            }
            if (d2 != null) {
                g.N().I0(bVar.b(), d2);
            }
            if (f46272a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static Set<String> i(@NonNull JSONObject jSONObject) {
        if (jSONObject.length() <= 0) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                linkedHashSet.add(next);
            }
        }
        if (f46272a) {
            Log.d("SwanAppSlaveTopPages", "get top pages - " + linkedHashSet);
        }
        return linkedHashSet;
    }

    public static void j() {
    }

    public static Set<String> k(@NonNull PMSAppInfo pMSAppInfo) {
        if (f46272a) {
            d.a.l0.a.l1.b b2 = b();
            Log.d("SwanAppSlaveTopPages", "current page - " + b2);
        }
        JSONObject f2 = f(pMSAppInfo);
        if (f2 == null || f2.length() <= 0) {
            return null;
        }
        if (f46272a) {
            Log.d("SwanAppSlaveTopPages", "pages info - " + f2);
        }
        return i(f2);
    }
}
