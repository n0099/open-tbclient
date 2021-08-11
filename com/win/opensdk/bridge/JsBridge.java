package com.win.opensdk.bridge;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes10.dex */
public class JsBridge {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile JsBridge f76589a;
    public transient /* synthetic */ FieldHolder $fh;

    public JsBridge() {
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

    public static JsBridge getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JsBridge jsBridge = f76589a;
            if (jsBridge == null) {
                synchronized (JsBridge.class) {
                    jsBridge = f76589a;
                    if (jsBridge == null) {
                        jsBridge = new JsBridge();
                        f76589a = jsBridge;
                    }
                }
            }
            return jsBridge;
        }
        return (JsBridge) invokeV.objValue;
    }

    public NativeMethodInjectHelper clazz(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? NativeMethodInjectHelper.getInstance().clazz(cls) : (NativeMethodInjectHelper) invokeL.objValue;
    }
}
