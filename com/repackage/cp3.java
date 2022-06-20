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
/* loaded from: classes5.dex */
public class cp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ResponseCallback<jn3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo3 a;

        public a(fo3 fo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(jn3 jn3Var, int i) {
            fo3 fo3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jn3Var, i) == null) || jn3Var == null || (fo3Var = this.a) == null) {
                return;
            }
            fo3Var.d(jn3Var.a, jn3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public jn3 parseResponse(Response response, int i) {
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
                                jn3 jn3Var = new jn3();
                                jn3Var.a = optJSONObject.optString("clickid");
                                jn3Var.b = optJSONObject.optString("dstlink");
                                return jn3Var;
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
            return (jn3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(zo3 zo3Var, AdElementInfo adElementInfo, io3 io3Var, fo3 fo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, zo3Var, adElementInfo, io3Var, fo3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), zo3Var);
        a aVar = new a(fo3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || io3Var == null) {
            return;
        }
        io3Var.c(c, aVar);
    }

    public static void b(String str, io3 io3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, io3Var) == null) {
            io3Var.e(str);
        }
    }

    public static String c(String str, zo3 zo3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, zo3Var)) == null) ? zo3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", zo3Var.a).replaceAll("\\{REQ_HEIGHT\\}", zo3Var.b).replaceAll("\\{WIDTH\\}", zo3Var.c).replaceAll("\\{HEIGHT\\}", zo3Var.d).replaceAll("\\{DOWN_X\\}", zo3Var.e).replaceAll("\\{DOWN_Y\\}", zo3Var.f).replaceAll("\\{UP_X\\}", zo3Var.g).replaceAll("\\{UP_Y\\}", zo3Var.h).replaceAll("\\{VIDEO_TIME\\}", zo3Var.i).replaceAll("\\{BEGIN_TIME\\}", zo3Var.j).replaceAll("\\{END_TIME\\}", zo3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", zo3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", zo3Var.m).replaceAll("\\{SCENE\\}", zo3Var.n).replaceAll("\\{TYPE\\}", zo3Var.o).replaceAll("\\{BEHAVIOR\\}", zo3Var.p).replaceAll("\\{STATUS\\}", zo3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", zo3Var.r).replaceAll("\\{CLICK_ID\\}", zo3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, io3 io3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, io3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), io3Var);
        }
    }

    public static void e(zo3 zo3Var, AdElementInfo adElementInfo, io3 io3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zo3Var, adElementInfo, io3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, zo3Var), io3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, io3 io3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, io3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), io3Var);
        }
    }

    public static void g(zo3 zo3Var, AdElementInfo adElementInfo, io3 io3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, zo3Var, adElementInfo, io3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, zo3Var), io3Var);
        }
    }
}
