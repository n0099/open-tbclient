package com.tachikoma.core.manager;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.bridge.IComponentRegister;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.timer.KTTimer;
import com.tachikoma.core.utility.Console;
/* loaded from: classes4.dex */
public class W3CMoudleManager implements IComponentRegister {
    public static /* synthetic */ Interceptable $ic;
    public static W3CMoudleManager moudleManager;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1203549849, "Lcom/tachikoma/core/manager/W3CMoudleManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1203549849, "Lcom/tachikoma/core/manager/W3CMoudleManager;");
                return;
            }
        }
        moudleManager = new W3CMoudleManager();
    }

    public W3CMoudleManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static W3CMoudleManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? moudleManager : (W3CMoudleManager) invokeV.objValue;
    }

    @Override // com.tachikoma.core.bridge.IComponentRegister
    public boolean register(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void registerW3CObject(JSContext jSContext, TKJSContext tKJSContext, V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSContext, tKJSContext, v8) == null) {
            Console console = new Console();
            IHostEnvInner iHostEnvInner = (IHostEnvInner) TKModuleManager.getInstance().getHandler(tKJSContext, IHostEnvInner.class);
            if (iHostEnvInner != null) {
                console.setShowLog(iHostEnvInner.isShowLog());
            }
            V8Object makeObject = jSContext.makeObject();
            v8.add("console", makeObject);
            makeObject.registerJavaMethod(console, TbConfig.TMP_LOG_DIR_NAME, TbConfig.TMP_LOG_DIR_NAME, new Class[]{String.class});
            makeObject.registerJavaMethod(console, NotificationCompat.CATEGORY_ERROR, NotificationCompat.CATEGORY_ERROR, new Class[]{String.class});
            makeObject.close();
            KTTimer kTTimer = new KTTimer();
            v8.registerJavaMethod(kTTimer, "setInterval", "setInterval", new Class[]{V8Function.class, Long.TYPE});
            v8.registerJavaMethod(kTTimer, "clearInterval", "clearInterval", new Class[]{Integer.TYPE});
            v8.registerJavaMethod(kTTimer, "setTimeout", "setTimeout", new Class[]{V8Function.class, Long.TYPE});
            v8.registerJavaMethod(kTTimer, "clearTimeout", "clearTimeout", new Class[]{Integer.TYPE});
        }
    }
}
