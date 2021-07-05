package com.yy.mobile.framework.revenuesdk.payapi.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public class HiidoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HiidoUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public HiidoUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                RLog.error(TAG, "getHdid error context null", new Object[0]);
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            String hdidSync = HiidoSDK.instance().getHdidSync(context);
            if (hdidSync != null) {
                RLog.debug(TAG, "getHdid hdid:" + hdidSync);
            } else {
                RLog.error(TAG, "getHdid hdid null", new Object[0]);
            }
            RLog.debug(TAG, "getHdid cost time = " + (System.currentTimeMillis() - currentTimeMillis));
            return hdidSync == null ? "" : hdidSync;
        }
        return (String) invokeL.objValue;
    }
}
