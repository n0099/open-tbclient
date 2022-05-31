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
public class ro3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<ym3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un3 a;

        public a(un3 un3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ym3 ym3Var, int i) {
            un3 un3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, ym3Var, i) == null) || ym3Var == null || (un3Var = this.a) == null) {
                return;
            }
            un3Var.d(ym3Var.a, ym3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ym3 parseResponse(Response response, int i) {
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
                                ym3 ym3Var = new ym3();
                                ym3Var.a = optJSONObject.optString("clickid");
                                ym3Var.b = optJSONObject.optString("dstlink");
                                return ym3Var;
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
            return (ym3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(oo3 oo3Var, AdElementInfo adElementInfo, xn3 xn3Var, un3 un3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, oo3Var, adElementInfo, xn3Var, un3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), oo3Var);
        a aVar = new a(un3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || xn3Var == null) {
            return;
        }
        xn3Var.c(c, aVar);
    }

    public static void b(String str, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xn3Var) == null) {
            xn3Var.e(str);
        }
    }

    public static String c(String str, oo3 oo3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, oo3Var)) == null) ? oo3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", oo3Var.a).replaceAll("\\{REQ_HEIGHT\\}", oo3Var.b).replaceAll("\\{WIDTH\\}", oo3Var.c).replaceAll("\\{HEIGHT\\}", oo3Var.d).replaceAll("\\{DOWN_X\\}", oo3Var.e).replaceAll("\\{DOWN_Y\\}", oo3Var.f).replaceAll("\\{UP_X\\}", oo3Var.g).replaceAll("\\{UP_Y\\}", oo3Var.h).replaceAll("\\{VIDEO_TIME\\}", oo3Var.i).replaceAll("\\{BEGIN_TIME\\}", oo3Var.j).replaceAll("\\{END_TIME\\}", oo3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", oo3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", oo3Var.m).replaceAll("\\{SCENE\\}", oo3Var.n).replaceAll("\\{TYPE\\}", oo3Var.o).replaceAll("\\{BEHAVIOR\\}", oo3Var.p).replaceAll("\\{STATUS\\}", oo3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", oo3Var.r).replaceAll("\\{CLICK_ID\\}", oo3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, xn3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), xn3Var);
        }
    }

    public static void e(oo3 oo3Var, AdElementInfo adElementInfo, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oo3Var, adElementInfo, xn3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, oo3Var), xn3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, xn3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), xn3Var);
        }
    }

    public static void g(oo3 oo3Var, AdElementInfo adElementInfo, xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, oo3Var, adElementInfo, xn3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, oo3Var), xn3Var);
        }
    }
}
