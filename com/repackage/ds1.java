package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ds1 extends tr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements qe3<us1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds1 a;

        public a(ds1 ds1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ds1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.qe3
        public us1 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject d = iu2.c().d("getSystemInfo");
                if (d == null) {
                    ds1 ds1Var = this.a;
                    d = ds1Var.G(ds1Var.getContext());
                    iu2.c().h("getSystemInfo", d);
                    iu2.c().h("getSystemInfoSync", d);
                }
                if (d == null) {
                    return new us1(202, "empty joData");
                }
                return new us1(0, d);
            }
            return (us1) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qe3 b;
        public final /* synthetic */ ds1 c;

        public b(ds1 ds1Var, String str, qe3 qe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds1Var, str, qe3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ds1Var;
            this.a = str;
            this.b = qe3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, (us1) this.b.call());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void B(@NonNull JSONObject jSONObject) throws JSONException {
        u03 L;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (L = u03.L()) != null && L.d0().f("mapp_location")) {
            uk2 I = bk2.I();
            t33 h = I == null ? null : I.h();
            if (h == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", h.k);
            jSONObject2.put("cityCode", h.l);
            jSONObject2.put("country", h.i);
            jSONObject2.put("district", h.n);
            jSONObject2.put("province", h.m);
            jSONObject2.put("street", h.o);
            jSONObject2.put("streetNumber", h.p);
            jSONObject2.put("coord_gcj02", D(h, "gcj02"));
            jSONObject2.put("coord_wgs84", D(h, CoordinateType.WGS84));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject D(@NonNull t33 t33Var, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, t33Var, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] g = bk2.I().g(t33Var, str);
            if (g != null && g.length >= 2) {
                jSONObject.put("longitude", g[0]);
                jSONObject.put("latitude", g[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
            if (frameType == 1) {
                return z93.i(ck2.i().n(), frameType);
            }
            return z93.i(o72.U().d0(), frameType);
        }
        return (String) invokeL.objValue;
    }

    public final void A(@NonNull JSONObject jSONObject) throws JSONException {
        u03 L;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && (L = u03.L()) != null && L.d0().f("mapp_set_user_agent")) {
            jSONObject.put(TTDownloadField.TT_USERAGENT, k74.b().a());
        }
    }

    public final void C(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, pair) == null) {
            int O = le3.O(de3.e(context));
            int O2 = le3.O(((Integer) pair.first).intValue());
            int O3 = le3.O(((Integer) pair.second).intValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", 0);
            jSONObject2.put("right", O2);
            jSONObject2.put("top", O);
            jSONObject2.put("width", O2);
            jSONObject2.put("bottom", O3);
            jSONObject2.put("height", O3 - O);
            jSONObject.put("safeArea", jSONObject2);
        }
    }

    public us1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getCommonSysInfoSync", false);
            JSONObject d = iu2.c().d("getCommonSysInfoSync");
            if (d == null) {
                try {
                    d = new JSONObject();
                    d.put("imei", oe3.r());
                    iu2.c().h("getCommonSysInfoSync", d);
                } catch (JSONException unused) {
                    return new us1(1001, "exec fail");
                }
            }
            return new us1(0, d);
        }
        return (us1) invokeV.objValue;
    }

    public final JSONObject G(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (bk2.g0().o()) {
                a2 = es1.b(context);
            } else {
                a2 = es1.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> r = hm2.U().r();
            Pair<Integer, Integer> x = hm2.U().x();
            try {
                a2.put("SDKVersion", F(context));
                a2.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", le3.O(((Integer) x.first).intValue()));
                a2.put("screenHeight", le3.O(((Integer) x.second).intValue()));
                a2.put("privacyMode", bk2.y0().c());
                B(a2);
                z(context, a2);
                C(context, a2, x);
                A(a2);
            } catch (JSONException e) {
                p("json put data fail", e, false);
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public us1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSystemInfo", false);
            return I(null);
        }
        return (us1) invokeV.objValue;
    }

    public us1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSystemInfoAsync", false);
            a aVar = new a(this);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("cb");
                    if (!TextUtils.isEmpty(optString)) {
                        od3.k(new b(this, optString, aVar), "SystemInfoApi");
                        return us1.f();
                    }
                } catch (JSONException e) {
                    p("json put data fail", e, false);
                }
            }
            return aVar.call();
        }
        return (us1) invokeL.objValue;
    }

    public us1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getSystemInfoSync", false);
            JSONObject d = iu2.c().d("getSystemInfoSync");
            if (d == null) {
                d = G(getContext());
                iu2.c().h("getSystemInfoSync", d);
                iu2.c().h("getSystemInfo", d);
            }
            if (d == null) {
                return new us1(202, "empty joData");
            }
            return new us1(0, d);
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "SystemInfoApi" : (String) invokeV.objValue;
    }

    public final void z(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", yd3.j(context, "android.permission.CAMERA"));
            jSONObject.put("locationAuthorized", yd3.j(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put("microphoneAuthorized", yd3.j(context, "android.permission.RECORD_AUDIO"));
            jSONObject.put("notificationAuthorized", oe3.N(context));
            jSONObject.put("locationEnabled", oe3.L(context));
            jSONObject.put("wifiEnabled", oe3.V(context));
        }
    }
}
