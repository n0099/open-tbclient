package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<zn3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo3 a;

        public a(vo3 vo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(zn3 zn3Var, int i) {
            vo3 vo3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, zn3Var, i) == null) || zn3Var == null || (vo3Var = this.a) == null) {
                return;
            }
            vo3Var.d(zn3Var.a, zn3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public zn3 parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response == null || response.body() == null || !response.isSuccessful()) {
                    return null;
                }
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                zn3 zn3Var = new zn3();
                                zn3Var.a = optJSONObject.optString("clickid");
                                zn3Var.b = optJSONObject.optString("dstlink");
                                return zn3Var;
                            }
                            return null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (zn3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(pp3 pp3Var, AdElementInfo adElementInfo, yo3 yo3Var, vo3 vo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, pp3Var, adElementInfo, yo3Var, vo3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), pp3Var);
        a aVar = new a(vo3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || yo3Var == null) {
            return;
        }
        yo3Var.c(c, aVar);
    }

    public static void b(String str, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, yo3Var) == null) {
            yo3Var.e(str);
        }
    }

    public static String c(String str, pp3 pp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, pp3Var)) == null) ? pp3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", pp3Var.a).replaceAll("\\{REQ_HEIGHT\\}", pp3Var.b).replaceAll("\\{WIDTH\\}", pp3Var.c).replaceAll("\\{HEIGHT\\}", pp3Var.d).replaceAll("\\{DOWN_X\\}", pp3Var.e).replaceAll("\\{DOWN_Y\\}", pp3Var.f).replaceAll("\\{UP_X\\}", pp3Var.g).replaceAll("\\{UP_Y\\}", pp3Var.h).replaceAll("\\{VIDEO_TIME\\}", pp3Var.i).replaceAll("\\{BEGIN_TIME\\}", pp3Var.j).replaceAll("\\{END_TIME\\}", pp3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", pp3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", pp3Var.m).replaceAll("\\{SCENE\\}", pp3Var.n).replaceAll("\\{TYPE\\}", pp3Var.o).replaceAll("\\{BEHAVIOR\\}", pp3Var.p).replaceAll("\\{STATUS\\}", pp3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", pp3Var.r).replaceAll("\\{CLICK_ID\\}", pp3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, yo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), yo3Var);
        }
    }

    public static void e(pp3 pp3Var, AdElementInfo adElementInfo, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pp3Var, adElementInfo, yo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, pp3Var), yo3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, yo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), yo3Var);
        }
    }

    public static void g(pp3 pp3Var, AdElementInfo adElementInfo, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, pp3Var, adElementInfo, yo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, pp3Var), yo3Var);
        }
    }
}
