package d.a.i0.a.u.e.p;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import d.a.i0.a.v2.a0;
import d.a.i0.a.v2.f0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.i0.a.u.c.d {
    public f(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void s(@NonNull JSONObject jSONObject) throws JSONException {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null || !i2.T().f("mapp_location")) {
            return;
        }
        d.a.i0.a.c1.d.d E = d.a.i0.a.c1.a.E();
        d.a.i0.a.c2.f.k0.b h2 = E == null ? null : E.h();
        if (h2 == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("city", h2.k);
        jSONObject2.put("cityCode", h2.l);
        jSONObject2.put("country", h2.f40961i);
        jSONObject2.put("district", h2.n);
        jSONObject2.put("province", h2.m);
        jSONObject2.put("street", h2.o);
        jSONObject2.put("streetNumber", h2.p);
        jSONObject2.put("coord_gcj02", u(h2, "gcj02"));
        jSONObject2.put("coord_wgs84", u(h2, CoordinateType.WGS84));
        jSONObject.put("cacheLocation", jSONObject2);
    }

    public static JSONObject u(@NonNull d.a.i0.a.c2.f.k0.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] g2 = d.a.i0.a.c1.a.E().g(bVar, str);
        if (g2 != null && g2.length >= 2) {
            jSONObject.put("longitude", g2[0]);
            jSONObject.put("latitude", g2[1]);
        }
        return jSONObject;
    }

    public static String w(Context context) {
        int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
        if (frameType == 1) {
            return d.a.i0.a.m2.b.i(d.a.i0.a.c1.b.i().n(), frameType);
        }
        return d.a.i0.a.m2.b.i(d.a.i0.a.h0.u.g.N().V(), frameType);
    }

    public final void r(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", a0.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", a0.j(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", a0.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", q0.M(context));
        jSONObject.put("locationEnabled", q0.K(context));
        jSONObject.put("wifiEnabled", q0.S(context));
    }

    public final void t(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int K = n0.K(f0.e(context));
        int K2 = n0.K(((Integer) pair.first).intValue());
        int K3 = n0.K(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomDialogData.POS_LEFT, 0);
        jSONObject2.put("right", K2);
        jSONObject2.put("top", K);
        jSONObject2.put("width", K2);
        jSONObject2.put(TipsConfigItem.TipConfigData.BOTTOM, K3);
        jSONObject2.put("height", K3 - K);
        jSONObject.put("safeArea", jSONObject2);
    }

    public d.a.i0.a.u.h.b v() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject d2 = d.a.i0.a.r1.k.g.a.c().d("getCommonSysInfoSync");
        if (d2 == null) {
            try {
                d2 = new JSONObject();
                d2.put("imei", q0.r());
                d.a.i0.a.r1.k.g.a.c().h("getCommonSysInfoSync", d2);
            } catch (JSONException unused) {
                return new d.a.i0.a.u.h.b(1001, "exec fail");
            }
        }
        return new d.a.i0.a.u.h.b(0, d2);
    }

    public final JSONObject x(Context context) {
        JSONObject a2;
        if (d.a.i0.a.c1.a.Z().p()) {
            a2 = g.b(context);
        } else {
            a2 = g.a(context);
        }
        if (a2 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> r = d.a.i0.a.g1.f.V().r();
        Pair<Integer, Integer> y = d.a.i0.a.g1.f.V().y();
        try {
            a2.put("SDKVersion", w(context));
            a2.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
            a2.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
            a2.put("screenWidth", n0.K(((Integer) y.first).intValue()));
            a2.put("screenHeight", n0.K(((Integer) y.second).intValue()));
            s(a2);
            r(context, a2);
            t(context, a2, y);
        } catch (JSONException e2) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e2.printStackTrace();
            }
        }
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + a2);
        }
        return a2;
    }

    public d.a.i0.a.u.h.b y() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject d2 = d.a.i0.a.r1.k.g.a.c().d("getSystemInfo");
        if (d2 == null) {
            d2 = x(i());
            d.a.i0.a.r1.k.g.a.c().h("getSystemInfo", d2);
            d.a.i0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
        }
        if (d2 == null) {
            return new d.a.i0.a.u.h.b(202, "empty joData");
        }
        return new d.a.i0.a.u.h.b(0, d2);
    }

    public d.a.i0.a.u.h.b z() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject d2 = d.a.i0.a.r1.k.g.a.c().d("getSystemInfoSync");
        if (d2 == null) {
            d2 = x(i());
            d.a.i0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
            d.a.i0.a.r1.k.g.a.c().h("getSystemInfo", d2);
        }
        if (d2 == null) {
            return new d.a.i0.a.u.h.b(202, "empty joData");
        }
        return new d.a.i0.a.u.h.b(0, d2);
    }
}
