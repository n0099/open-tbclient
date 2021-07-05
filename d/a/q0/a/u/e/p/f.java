package d.a.q0.a.u.e.p;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import d.a.q0.a.v2.a0;
import d.a.q0.a.v2.f0;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void s(@NonNull JSONObject jSONObject) throws JSONException {
        d.a.q0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (i2 = d.a.q0.a.a2.e.i()) != null && i2.T().f("mapp_location")) {
            d.a.q0.a.c1.d.d E = d.a.q0.a.c1.a.E();
            d.a.q0.a.c2.f.k0.b g2 = E == null ? null : E.g();
            if (g2 == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", g2.k);
            jSONObject2.put("cityCode", g2.l);
            jSONObject2.put("country", g2.f47069i);
            jSONObject2.put("district", g2.n);
            jSONObject2.put("province", g2.m);
            jSONObject2.put("street", g2.o);
            jSONObject2.put("streetNumber", g2.p);
            jSONObject2.put("coord_gcj02", u(g2, "gcj02"));
            jSONObject2.put("coord_wgs84", u(g2, CoordinateType.WGS84));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject u(@NonNull d.a.q0.a.c2.f.k0.b bVar, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] f2 = d.a.q0.a.c1.a.E().f(bVar, str);
            if (f2 != null && f2.length >= 2) {
                jSONObject.put("longitude", f2[0]);
                jSONObject.put("latitude", f2[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
            if (frameType == 1) {
                return d.a.q0.a.m2.b.i(d.a.q0.a.c1.b.i().n(), frameType);
            }
            return d.a.q0.a.m2.b.i(d.a.q0.a.h0.u.g.N().V(), frameType);
        }
        return (String) invokeL.objValue;
    }

    public final void r(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", a0.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", a0.j(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put("microphoneAuthorized", a0.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", q0.M(context));
            jSONObject.put("locationEnabled", q0.K(context));
            jSONObject.put("wifiEnabled", q0.S(context));
        }
    }

    public final void t(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, pair) == null) {
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
    }

    public d.a.q0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-SystemInfo", "start get common sys info sync");
            }
            JSONObject d2 = d.a.q0.a.r1.k.g.a.c().d("getCommonSysInfoSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("imei", q0.r());
                    d.a.q0.a.r1.k.g.a.c().h("getCommonSysInfoSync", d2);
                } catch (JSONException unused) {
                    return new d.a.q0.a.u.h.b(1001, "exec fail");
                }
            }
            return new d.a.q0.a.u.h.b(0, d2);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public final JSONObject x(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (d.a.q0.a.c1.a.Z().p()) {
                a2 = g.b(context);
            } else {
                a2 = g.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> r = d.a.q0.a.g1.f.V().r();
            Pair<Integer, Integer> y = d.a.q0.a.g1.f.V().y();
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
                if (d.a.q0.a.u.c.d.f50740c) {
                    e2.printStackTrace();
                }
            }
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + a2);
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-SystemInfo", "start get system info");
            }
            JSONObject d2 = d.a.q0.a.r1.k.g.a.c().d("getSystemInfo");
            if (d2 == null) {
                d2 = x(i());
                d.a.q0.a.r1.k.g.a.c().h("getSystemInfo", d2);
                d.a.q0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
            }
            if (d2 == null) {
                return new d.a.q0.a.u.h.b(202, "empty joData");
            }
            return new d.a.q0.a.u.h.b(0, d2);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public d.a.q0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-SystemInfo", "start get system info sync");
            }
            JSONObject d2 = d.a.q0.a.r1.k.g.a.c().d("getSystemInfoSync");
            if (d2 == null) {
                d2 = x(i());
                d.a.q0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
                d.a.q0.a.r1.k.g.a.c().h("getSystemInfo", d2);
            }
            if (d2 == null) {
                return new d.a.q0.a.u.h.b(202, "empty joData");
            }
            return new d.a.q0.a.u.h.b(0, d2);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }
}
