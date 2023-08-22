package com.huawei.hms.framework.network.grs;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes10.dex */
public class GrsApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GrsApi";
    public static GrsClient grsClient;
    public transient /* synthetic */ FieldHolder $fh;

    public GrsApi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, iQueryUrlCallBack) == null) {
            if (iQueryUrlCallBack == null) {
                Logger.w(TAG, "IQueryUrlCallBack is must not null for process continue.");
                return;
            }
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null || str == null || str2 == null) {
                iQueryUrlCallBack.onCallBackFail(-6);
            } else {
                grsClient2.ayncGetGrsUrl(str, str2, iQueryUrlCallBack);
            }
        }
    }

    @Deprecated
    public static void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, iQueryUrlsCallBack) == null) {
            if (iQueryUrlsCallBack == null) {
                Logger.w(TAG, "IQueryUrlsCallBack is must not null for process continue.");
                return;
            }
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null || str == null) {
                iQueryUrlsCallBack.onCallBackFail(-6);
            } else {
                grsClient2.ayncGetGrsUrls(str, iQueryUrlsCallBack);
            }
        }
    }

    @Deprecated
    public static void clearSp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null) {
                Logger.w(TAG, "GrsApi.clearSp return because grsClient is null.");
            } else {
                grsClient2.clearSp();
            }
        }
    }

    @Deprecated
    public static boolean forceExpire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null) {
                Logger.w(TAG, "GrsApi.forceExpire return false because grsClient is null.");
                return false;
            }
            return grsClient2.forceExpire();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static CountryCodeBean getCountryCode(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, context, z)) == null) ? a.a(context, z) : (CountryCodeBean) invokeLZ.objValue;
    }

    @Deprecated
    public static int grsSdkInit(Context context, GrsBaseInfo grsBaseInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, grsBaseInfo)) == null) {
            Logger.w(TAG, "GrsApi.grsSdkInit is @Deprecated,  And Only Application Can Call Once");
            grsClient = new GrsClient(context, grsBaseInfo);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Deprecated
    public static String synGetGrsUrl(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null || str == null || str2 == null) {
                Logger.w(TAG, "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
                return null;
            }
            return grsClient2.synGetGrsUrl(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static Map<String, String> synGetGrsUrls(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            GrsClient grsClient2 = grsClient;
            if (grsClient2 == null || str == null) {
                Logger.w(TAG, "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
                return new HashMap();
            }
            return grsClient2.synGetGrsUrls(str);
        }
        return (Map) invokeL.objValue;
    }
}
