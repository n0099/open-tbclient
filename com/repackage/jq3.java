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
public class jq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<qo3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public a(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(qo3 qo3Var, int i) {
            mp3 mp3Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, qo3Var, i) == null) || qo3Var == null || (mp3Var = this.a) == null) {
                return;
            }
            mp3Var.d(qo3Var.a, qo3Var.b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public qo3 parseResponse(Response response, int i) {
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
                                qo3 qo3Var = new qo3();
                                qo3Var.a = optJSONObject.optString("clickid");
                                qo3Var.b = optJSONObject.optString("dstlink");
                                return qo3Var;
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
            return (qo3) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(gq3 gq3Var, AdElementInfo adElementInfo, pp3 pp3Var, mp3 mp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, gq3Var, adElementInfo, pp3Var, mp3Var) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c = c(adElementInfo.getClickUrl(), gq3Var);
        a aVar = new a(mp3Var);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || pp3Var == null) {
            return;
        }
        pp3Var.c(c, aVar);
    }

    public static void b(String str, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, pp3Var) == null) {
            pp3Var.e(str);
        }
    }

    public static String c(String str, gq3 gq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, gq3Var)) == null) ? gq3Var == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", gq3Var.a).replaceAll("\\{REQ_HEIGHT\\}", gq3Var.b).replaceAll("\\{WIDTH\\}", gq3Var.c).replaceAll("\\{HEIGHT\\}", gq3Var.d).replaceAll("\\{DOWN_X\\}", gq3Var.e).replaceAll("\\{DOWN_Y\\}", gq3Var.f).replaceAll("\\{UP_X\\}", gq3Var.g).replaceAll("\\{UP_Y\\}", gq3Var.h).replaceAll("\\{VIDEO_TIME\\}", gq3Var.i).replaceAll("\\{BEGIN_TIME\\}", gq3Var.j).replaceAll("\\{END_TIME\\}", gq3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", gq3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", gq3Var.m).replaceAll("\\{SCENE\\}", gq3Var.n).replaceAll("\\{TYPE\\}", gq3Var.o).replaceAll("\\{BEHAVIOR\\}", gq3Var.p).replaceAll("\\{STATUS\\}", gq3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", gq3Var.r).replaceAll("\\{CLICK_ID\\}", gq3Var.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, pp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), pp3Var);
        }
    }

    public static void e(gq3 gq3Var, AdElementInfo adElementInfo, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gq3Var, adElementInfo, pp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, gq3Var), pp3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, pp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), pp3Var);
        }
    }

    public static void g(gq3 gq3Var, AdElementInfo adElementInfo, pp3 pp3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, gq3Var, adElementInfo, pp3Var) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, gq3Var), pp3Var);
        }
    }
}
