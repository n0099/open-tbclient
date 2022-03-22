package com.kuaishou.tachikoma.api;

import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.bridge.TKJSContext;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class TKJSBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKJSContext mTKContext;

    public TKJSBridge(TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTKContext = tKJSContext;
    }

    public void addJavascriptInterface(Object obj, String str) {
        Method[] methods;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) || (methods = obj.getClass().getMethods()) == null) {
            return;
        }
        HashMap<String, Class[]> hashMap = new HashMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(JavascriptInterface.class)) {
                hashMap.put(method.getName(), method.getParameterTypes());
            }
        }
        this.mTKContext.registerJavaScriptInterface(obj, str, hashMap);
    }

    public void callJS(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.mTKContext.context().evaluateScript(str, str2, null);
        }
    }
}
