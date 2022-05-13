package com.repackage;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = hu3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(ju3.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = hu3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(iu3.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u03 a;

        public c(u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                try {
                    if (new JSONObject(str).getInt("errno") != 0) {
                        c93 a = i93.a();
                        a.putInt("swangame_valid__" + this.a.N(), 0);
                        return;
                    }
                    c93 a2 = i93.a();
                    a2.putInt("swangame_valid__" + this.a.N(), 1);
                    hu3.g("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public static void b() {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (a0 = u03.a0()) == null || c() || !bk2.h0().e(bk2.c())) {
            return;
        }
        if (d()) {
            g("1");
        } else {
            az3.a().getRequest().cookieManager(bk2.q().a()).url(kx3.b().a()).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new c(a0));
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                return true;
            }
            c93 a2 = i93.a();
            StringBuilder sb = new StringBuilder();
            sb.append("swangame_valid__");
            sb.append(a0.N());
            return a2.getInt(sb.toString(), -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                return false;
            }
            c93 a2 = i93.a();
            StringBuilder sb = new StringBuilder();
            sb.append("swangame_valid__");
            sb.append(a0.N());
            return 1 == a2.getInt(sb.toString(), -1);
        }
        return invokeV.booleanValue;
    }

    public static JSONObject e(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, dVar)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno", -1) != 0) {
                    dVar.onFail(jSONObject.optString("errmsg"));
                    return null;
                }
                return jSONObject.optJSONObject("data");
            } catch (Exception e) {
                dVar.onFail(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void f() {
        u03 a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (a0 = u03.a0()) != null && d() && bk2.h0().e(bk2.c())) {
            az3.a().getRequest().cookieManager(bk2.q().a()).url(kx3.b().i()).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void g(String str) {
        u03 a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && (a0 = u03.a0()) != null && d() && bk2.h0().e(bk2.c())) {
            String h = bk2.h0().h(bk2.c());
            if (TextUtils.isEmpty(h)) {
                return;
            }
            String d2 = zg4.d(Base64.encode(h.getBytes(), 0), false);
            String i = bk2.h0().i(bk2.c());
            if (!TextUtils.isEmpty(i) && i.length() > 32) {
                i = i.substring(0, 32);
            }
            az3.a().getRequest().cookieManager(bk2.q().a()).url(kx3.b().q()).addUrlParam("sessionId", d2).addUrlParam("deviceId", i).addUrlParam("behaviorType", str).addUrlParam("behaviorTime", String.valueOf(System.currentTimeMillis() / 1000)).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, dVar) == null) || dVar == null) {
            return;
        }
        u03 a0 = u03.a0();
        if (a0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        az3.a().getRequest().cookieManager(bk2.q().a()).url(kx3.b().j()).addUrlParam("appkey", a0.N()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new b(dVar));
    }

    public static void i(long j, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65544, null, j, dVar) == null) || dVar == null) {
            return;
        }
        u03 a0 = u03.a0();
        if (a0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        az3.a().getRequest().cookieManager(bk2.q().a()).url(kx3.b().h()).addUrlParam("appkey", a0.N()).addUrlParam("duration", String.valueOf(j)).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new a(dVar));
    }
}
