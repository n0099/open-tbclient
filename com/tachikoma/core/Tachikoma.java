package com.tachikoma.core;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.ILogInner;
import com.tachikoma.core.api.ITKExceptionHandlerInner;
import com.tachikoma.core.base.TKPerformancePlugin;
import com.tachikoma.core.bridge.Env;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.manager.TKExportManager;
import com.tachikoma.core.module.handler.TKLifeCycle;
import com.tachikoma.core.utility.TKAsync;
import com.tachikoma.core.utility.TKContextUtil;
import java.util.Map;
/* loaded from: classes3.dex */
public class Tachikoma {
    public static /* synthetic */ Interceptable $ic;
    public static final Tachikoma instance;
    public static Application sApplication;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> config;
    public ITKExceptionHandlerInner mExceptionHandlerInner;
    public Handler mHandler;
    public volatile boolean mInit;
    public TKExportManager mTKExportManager;
    public ILogInner mTKLog;
    public TKPerformancePlugin performancePlugin;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502420286, "Lcom/tachikoma/core/Tachikoma;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502420286, "Lcom/tachikoma/core/Tachikoma;");
                return;
            }
        }
        instance = new Tachikoma();
    }

    public Tachikoma() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInit = false;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static Tachikoma getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? instance : (Tachikoma) invokeV.objValue;
    }

    public void asyncNewTKJSContext(TKJSContextInitCallback tKJSContextInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tKJSContextInitCallback) == null) {
            TKAsync.execute(new Runnable(this, tKJSContextInitCallback) { // from class: com.tachikoma.core.Tachikoma.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Tachikoma this$0;
                public final /* synthetic */ TKJSContextInitCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tKJSContextInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = tKJSContextInitCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TKJSContext tKJSContext = new TKJSContext(Tachikoma.sApplication, this.this$0.mTKExportManager);
                        tKJSContext.onCreate();
                        tKJSContext.context().getContextRef().getLocker().release();
                        this.this$0.mHandler.post(new Runnable(this, tKJSContext) { // from class: com.tachikoma.core.Tachikoma.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;
                            public final /* synthetic */ TKJSContext val$context;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, tKJSContext};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$context = tKJSContext;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.val$context.context().getContextRef().getLocker().acquire();
                                    this.this$1.val$callback.onSuccess(this.val$context);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public Map<String, Object> getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.config : (Map) invokeV.objValue;
    }

    public TKExportManager getTKExportManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTKExportManager : (TKExportManager) invokeV.objValue;
    }

    public void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, application) == null) {
            sApplication = application;
            TKContextUtil.init(application);
            Env.initEnvironment(application);
            TKExportManager tKExportManager = TKExportManager.getInstance();
            this.mTKExportManager = tKExportManager;
            tKExportManager.onCreate();
            registerLifeCycle(application);
        }
    }

    public boolean isInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mInit : invokeV.booleanValue;
    }

    public ILogInner logger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTKLog : (ILogInner) invokeV.objValue;
    }

    @Deprecated
    public TKJSContext newTKJSContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TKJSContext tKJSContext = new TKJSContext(sApplication, this.mTKExportManager);
            tKJSContext.onCreate();
            return tKJSContext;
        }
        return (TKJSContext) invokeV.objValue;
    }

    public TKJSContext newTKJSContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            TKJSContext tKJSContext = new TKJSContext(context, this.mTKExportManager);
            tKJSContext.onCreate();
            return tKJSContext;
        }
        return (TKJSContext) invokeL.objValue;
    }

    public TKJSContext newTKJSContext(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            TKJSContext tKJSContext = new TKJSContext(viewGroup.getContext(), viewGroup, this.mTKExportManager);
            tKJSContext.onCreate();
            return tKJSContext;
        }
        return (TKJSContext) invokeL.objValue;
    }

    public void printPerformance(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) || getInstance().performancePlugin == null) {
            return;
        }
        getInstance().performancePlugin.printPerformance(str, i2);
    }

    public void registerLifeCycle(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, application) == null) {
            application.registerActivityLifecycleCallbacks(new TKLifeCycle.ActivityLifecycleCallbacksProxy());
        }
    }

    public void setConfig(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            this.config = map;
        }
    }

    public void setExceptionHandler(ITKExceptionHandlerInner iTKExceptionHandlerInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iTKExceptionHandlerInner) == null) {
            this.mExceptionHandlerInner = iTKExceptionHandlerInner;
        }
    }

    public void setInitResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mInit = z;
        }
    }

    public void setLoggerDelegate(ILogInner iLogInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iLogInner) == null) {
            this.mTKLog = iLogInner;
        }
    }

    public void setPerformancePlugin(TKPerformancePlugin tKPerformancePlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tKPerformancePlugin) == null) {
            this.performancePlugin = tKPerformancePlugin;
        }
    }
}
