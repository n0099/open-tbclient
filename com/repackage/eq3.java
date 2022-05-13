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
/* loaded from: classes6.dex */
public class eq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<lo3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hp3 a;

        public a(hp3 hp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hp3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(lo3 lo3Var, int i) {
            hp3 hp3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, lo3Var, i) == null) || lo3Var == null || (hp3Var = this.a) == null) {
                return;
            }
            hp3Var.d(lo3Var.a, lo3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public lo3 parseResponse(Response response, int i) {
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
                                lo3 lo3Var = new lo3();
                                lo3Var.a = optJSONObject.optString("clickid");
                                lo3Var.b = optJSONObject.optString("dstlink");
                                return lo3Var;
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
            return (lo3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(bq3 bq3Var, AdElementInfo adElementInfo, kp3 kp3Var, hp3 hp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, bq3Var, adElementInfo, kp3Var, hp3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), bq3Var);
        a aVar = new a(hp3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || kp3Var == null) {
            return;
        }
        kp3Var.c(c, aVar);
    }

    public static void b(String str, kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, kp3Var) == null) {
            kp3Var.e(str);
        }
    }

    public static String c(String str, bq3 bq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bq3Var)) == null) ? bq3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", bq3Var.a).replaceAll("\\{REQ_HEIGHT\\}", bq3Var.b).replaceAll("\\{WIDTH\\}", bq3Var.c).replaceAll("\\{HEIGHT\\}", bq3Var.d).replaceAll("\\{DOWN_X\\}", bq3Var.e).replaceAll("\\{DOWN_Y\\}", bq3Var.f).replaceAll("\\{UP_X\\}", bq3Var.g).replaceAll("\\{UP_Y\\}", bq3Var.h).replaceAll("\\{VIDEO_TIME\\}", bq3Var.i).replaceAll("\\{BEGIN_TIME\\}", bq3Var.j).replaceAll("\\{END_TIME\\}", bq3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", bq3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", bq3Var.m).replaceAll("\\{SCENE\\}", bq3Var.n).replaceAll("\\{TYPE\\}", bq3Var.o).replaceAll("\\{BEHAVIOR\\}", bq3Var.p).replaceAll("\\{STATUS\\}", bq3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", bq3Var.r).replaceAll("\\{CLICK_ID\\}", bq3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, kp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), kp3Var);
        }
    }

    public static void e(bq3 bq3Var, AdElementInfo adElementInfo, kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bq3Var, adElementInfo, kp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, bq3Var), kp3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, kp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), kp3Var);
        }
    }

    public static void g(bq3 bq3Var, AdElementInfo adElementInfo, kp3 kp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, bq3Var, adElementInfo, kp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, bq3Var), kp3Var);
        }
    }
}
