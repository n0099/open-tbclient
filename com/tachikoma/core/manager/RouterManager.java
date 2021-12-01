package com.tachikoma.core.manager;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IRouterInner;
import com.tachikoma.core.bridge.JSContext;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class RouterManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile RouterManager routerManager;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<JSContext, IRouterInner> routers;

    public RouterManager() {
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
        this.routers = new HashMap<>();
    }

    public static RouterManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (routerManager == null) {
                synchronized (RouterManager.class) {
                    if (routerManager == null) {
                        routerManager = new RouterManager();
                    }
                }
            }
            return routerManager;
        }
        return (RouterManager) invokeV.objValue;
    }

    public void navigateTo(JSContext jSContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSContext, str) == null) || TextUtils.isEmpty(str) || jSContext == null) {
            return;
        }
        try {
            this.routers.get(jSContext).navigateTo(Uri.parse(str));
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public void registerRouter(JSContext jSContext, IRouterInner iRouterInner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSContext, iRouterInner) == null) || jSContext == null || iRouterInner == null) {
            return;
        }
        this.routers.put(jSContext, iRouterInner);
    }

    public void unRegisterRouter(JSContext jSContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSContext) == null) || jSContext == null) {
            return;
        }
        this.routers.remove(jSContext);
    }
}
