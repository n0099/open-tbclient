package com.sina.weibo.sdk.network.intercept;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.network.IRequestIntercept;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class GlobalInterceptHelper {
    public static /* synthetic */ Interceptable $ic;
    public static GlobalInterceptHelper globalInterceptHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, IRequestIntercept> globalIntercept;

    public GlobalInterceptHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HashMap<String, IRequestIntercept> hashMap = new HashMap<>();
        this.globalIntercept = hashMap;
        hashMap.put(GuestParamInterception.class.getName(), new GuestParamInterception());
        this.globalIntercept.put(CommonParamInterception.class.getName(), new CommonParamInterception());
    }

    public static GlobalInterceptHelper init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (globalInterceptHelper == null) {
                globalInterceptHelper = new GlobalInterceptHelper();
            }
            return globalInterceptHelper;
        }
        return (GlobalInterceptHelper) invokeV.objValue;
    }

    public void addIntercept(String str, IRequestIntercept iRequestIntercept) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, iRequestIntercept) == null) {
            this.globalIntercept.put(str, iRequestIntercept);
        }
    }

    public HashMap<String, IRequestIntercept> getGlobalIntercept() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, IRequestIntercept> hashMap = this.globalIntercept;
            return hashMap == null ? new HashMap<>() : hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void removeIntercept(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.globalIntercept.containsKey(str)) {
            this.globalIntercept.remove(str);
        }
    }
}
