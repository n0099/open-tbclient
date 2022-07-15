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
public class rp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<yn3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo3 a;

        public a(uo3 uo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(yn3 yn3Var, int i) {
            uo3 uo3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, yn3Var, i) == null) || yn3Var == null || (uo3Var = this.a) == null) {
                return;
            }
            uo3Var.d(yn3Var.a, yn3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public yn3 parseResponse(Response response, int i) {
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
                                yn3 yn3Var = new yn3();
                                yn3Var.a = optJSONObject.optString("clickid");
                                yn3Var.b = optJSONObject.optString("dstlink");
                                return yn3Var;
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
            return (yn3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(op3 op3Var, AdElementInfo adElementInfo, xo3 xo3Var, uo3 uo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, op3Var, adElementInfo, xo3Var, uo3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), op3Var);
        a aVar = new a(uo3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || xo3Var == null) {
            return;
        }
        xo3Var.c(c, aVar);
    }

    public static void b(String str, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xo3Var) == null) {
            xo3Var.e(str);
        }
    }

    public static String c(String str, op3 op3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, op3Var)) == null) ? op3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", op3Var.a).replaceAll("\\{REQ_HEIGHT\\}", op3Var.b).replaceAll("\\{WIDTH\\}", op3Var.c).replaceAll("\\{HEIGHT\\}", op3Var.d).replaceAll("\\{DOWN_X\\}", op3Var.e).replaceAll("\\{DOWN_Y\\}", op3Var.f).replaceAll("\\{UP_X\\}", op3Var.g).replaceAll("\\{UP_Y\\}", op3Var.h).replaceAll("\\{VIDEO_TIME\\}", op3Var.i).replaceAll("\\{BEGIN_TIME\\}", op3Var.j).replaceAll("\\{END_TIME\\}", op3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", op3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", op3Var.m).replaceAll("\\{SCENE\\}", op3Var.n).replaceAll("\\{TYPE\\}", op3Var.o).replaceAll("\\{BEHAVIOR\\}", op3Var.p).replaceAll("\\{STATUS\\}", op3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", op3Var.r).replaceAll("\\{CLICK_ID\\}", op3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), xo3Var);
        }
    }

    public static void e(op3 op3Var, AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, op3Var, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, op3Var), xo3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), xo3Var);
        }
    }

    public static void g(op3 op3Var, AdElementInfo adElementInfo, xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, op3Var, adElementInfo, xo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, op3Var), xo3Var);
        }
    }
}
