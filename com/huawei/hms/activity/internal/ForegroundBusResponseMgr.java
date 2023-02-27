package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ForegroundBusResponseMgr {
    public static /* synthetic */ Interceptable $ic;
    public static final ForegroundBusResponseMgr INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, BusResponseCallback> callbackMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1407932128, "Lcom/huawei/hms/activity/internal/ForegroundBusResponseMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1407932128, "Lcom/huawei/hms/activity/internal/ForegroundBusResponseMgr;");
                return;
            }
        }
        INSTANCE = new ForegroundBusResponseMgr();
    }

    public ForegroundBusResponseMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.callbackMap = new HashMap();
    }

    public static ForegroundBusResponseMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE;
        }
        return (ForegroundBusResponseMgr) invokeV.objValue;
    }

    public BusResponseCallback get(String str) {
        InterceptResult invokeL;
        BusResponseCallback busResponseCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (this.callbackMap) {
                busResponseCallback = this.callbackMap.get(str);
            }
            return busResponseCallback;
        }
        return (BusResponseCallback) invokeL.objValue;
    }

    public void unRegisterObserver(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.callbackMap) {
            this.callbackMap.remove(str);
        }
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, busResponseCallback) == null) && !TextUtils.isEmpty(str) && busResponseCallback != null) {
            synchronized (this.callbackMap) {
                if (!this.callbackMap.containsKey(str)) {
                    this.callbackMap.put(str, busResponseCallback);
                }
            }
        }
    }
}
