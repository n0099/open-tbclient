package com.tachikoma.core.utility;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.debug.TKDebuggerUtils;
/* loaded from: classes3.dex */
public class TKContextUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Context ApplicationContext;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKContextUtil self;

    public TKContextUtil() {
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
        this.self = this;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context context = ApplicationContext;
            if (context == null) {
                try {
                    Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                    if (application != null) {
                        ApplicationContext = application;
                        return application;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    Application application2 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
                    if (application2 != null) {
                        ApplicationContext = application2;
                        return application2;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                throw new IllegalStateException("ContextHolder is not initialed, it is recommend to init with application context.");
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            ApplicationContext = context.getApplicationContext();
            if (TKDebuggerUtils.hasDebugger(context.getClassLoader())) {
                TKDebuggerUtils.initializeTKDebugger(context);
            }
        }
    }
}
