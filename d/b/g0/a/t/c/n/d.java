package d.b.g0.a.t.c.n;

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
import d.b.g0.a.i2.c0;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.t.b.d {
    public d(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void r(@NonNull JSONObject jSONObject) throws JSONException {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || !y.R().f("mapp_location")) {
            return;
        }
        d.b.g0.a.w0.c.d w = d.b.g0.a.w0.a.w();
        d.b.g0.a.t1.k.k0.b i = w == null ? null : w.i();
        if (i == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("city", i.k);
        jSONObject2.put("cityCode", i.l);
        jSONObject2.put("country", i.i);
        jSONObject2.put("district", i.n);
        jSONObject2.put("province", i.m);
        jSONObject2.put("street", i.o);
        jSONObject2.put("streetNumber", i.p);
        jSONObject2.put("coord_gcj02", t(i, "gcj02"));
        jSONObject2.put("coord_wgs84", t(i, CoordinateType.WGS84));
        jSONObject.put("cacheLocation", jSONObject2);
    }

    public static JSONObject t(@NonNull d.b.g0.a.t1.k.k0.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] f2 = d.b.g0.a.w0.a.w().f(bVar, str);
        if (f2 != null && f2.length >= 2) {
            jSONObject.put("longitude", f2[0]);
            jSONObject.put("latitude", f2[1]);
        }
        return jSONObject;
    }

    public static String v(Context context) {
        int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
        if (frameType == 1) {
            return d.b.g0.a.b2.b.g(d.b.g0.g.m.a.m().s(), frameType);
        }
        return d.b.g0.a.b2.b.g(d.b.g0.a.e0.w.d.L().T(), frameType);
    }

    public final void q(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.j(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", k0.J(context));
        jSONObject.put("locationEnabled", k0.H(context));
        jSONObject.put("wifiEnabled", k0.N(context));
    }

    public final void s(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int H = h0.H(c0.b(context));
        int H2 = h0.H(((Integer) pair.first).intValue());
        int H3 = h0.H(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomDialogData.POS_LEFT, 0);
        jSONObject2.put("right", H2);
        jSONObject2.put("top", H);
        jSONObject2.put("width", H2);
        jSONObject2.put(TipsConfigItem.TipConfigData.BOTTOM, H3);
        jSONObject2.put("height", H3 - H);
        jSONObject.put("safeArea", jSONObject2);
    }

    public d.b.g0.a.t.e.b u() {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", k0.r());
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException unused) {
            return new d.b.g0.a.t.e.b(1001, "exec fail");
        }
    }

    public final JSONObject w(Context context) {
        JSONObject a2;
        if (d.b.g0.a.w0.a.N().v()) {
            a2 = e.b(context);
        } else {
            a2 = e.a(context);
        }
        if (a2 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> G = d.b.g0.a.z0.f.V().G();
        Pair<Integer, Integer> c2 = d.b.g0.a.z0.f.V().c();
        try {
            a2.put("SDKVersion", v(context));
            a2.put("windowWidth", (int) (((Integer) G.first).intValue() / displayMetrics.density));
            a2.put("windowHeight", (int) (((Integer) G.second).intValue() / displayMetrics.density));
            a2.put("screenWidth", h0.H(((Integer) c2.first).intValue()));
            a2.put("screenHeight", h0.H(((Integer) c2.second).intValue()));
            r(a2);
            q(context, a2);
            s(context, a2, c2);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + a2);
        }
        return a2;
    }

    public d.b.g0.a.t.e.b x() {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject w = w(h());
        if (w == null) {
            return new d.b.g0.a.t.e.b(202, "empty joData");
        }
        return new d.b.g0.a.t.e.b(0, w);
    }

    public d.b.g0.a.t.e.b y() {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject w = w(h());
        if (w == null) {
            return new d.b.g0.a.t.e.b(202, "empty joData");
        }
        return new d.b.g0.a.t.e.b(0, w);
    }
}
