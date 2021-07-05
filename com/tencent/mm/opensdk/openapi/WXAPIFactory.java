package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes7.dex */
public class WXAPIFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.PaySdk.WXFactory";
    public transient /* synthetic */ FieldHolder $fh;

    public WXAPIFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? createWXAPI(context, str, true) : (IWXAPI) invokeLL.objValue;
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) {
            Log.d("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + str + ", checkSignature = " + z);
            return new WXApiImplV10(context, str, z);
        }
        return (IWXAPI) invokeLLZ.objValue;
    }
}
