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
public class tp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<ao3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo3 a;

        public a(wo3 wo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ao3 ao3Var, int i) {
            wo3 wo3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, ao3Var, i) == null) || ao3Var == null || (wo3Var = this.a) == null) {
                return;
            }
            wo3Var.d(ao3Var.a, ao3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ao3 parseResponse(Response response, int i) {
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
                                ao3 ao3Var = new ao3();
                                ao3Var.a = optJSONObject.optString("clickid");
                                ao3Var.b = optJSONObject.optString("dstlink");
                                return ao3Var;
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
            return (ao3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(qp3 qp3Var, AdElementInfo adElementInfo, zo3 zo3Var, wo3 wo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, qp3Var, adElementInfo, zo3Var, wo3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), qp3Var);
        a aVar = new a(wo3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || zo3Var == null) {
            return;
        }
        zo3Var.c(c, aVar);
    }

    public static void b(String str, zo3 zo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, zo3Var) == null) {
            zo3Var.e(str);
        }
    }

    public static String c(String str, qp3 qp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, qp3Var)) == null) ? qp3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", qp3Var.a).replaceAll("\\{REQ_HEIGHT\\}", qp3Var.b).replaceAll("\\{WIDTH\\}", qp3Var.c).replaceAll("\\{HEIGHT\\}", qp3Var.d).replaceAll("\\{DOWN_X\\}", qp3Var.e).replaceAll("\\{DOWN_Y\\}", qp3Var.f).replaceAll("\\{UP_X\\}", qp3Var.g).replaceAll("\\{UP_Y\\}", qp3Var.h).replaceAll("\\{VIDEO_TIME\\}", qp3Var.i).replaceAll("\\{BEGIN_TIME\\}", qp3Var.j).replaceAll("\\{END_TIME\\}", qp3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", qp3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", qp3Var.m).replaceAll("\\{SCENE\\}", qp3Var.n).replaceAll("\\{TYPE\\}", qp3Var.o).replaceAll("\\{BEHAVIOR\\}", qp3Var.p).replaceAll("\\{STATUS\\}", qp3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", qp3Var.r).replaceAll("\\{CLICK_ID\\}", qp3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, zo3 zo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, zo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), zo3Var);
        }
    }

    public static void e(qp3 qp3Var, AdElementInfo adElementInfo, zo3 zo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qp3Var, adElementInfo, zo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, qp3Var), zo3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, zo3 zo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, zo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), zo3Var);
        }
    }

    public static void g(qp3 qp3Var, AdElementInfo adElementInfo, zo3 zo3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, qp3Var, adElementInfo, zo3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, qp3Var), zo3Var);
        }
    }
}
