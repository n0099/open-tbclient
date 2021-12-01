package com.tachikoma.core.module.handler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
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
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.base.NativeModule;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.utility.V8Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKLifeCycle implements NativeModule {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public V8Object mV8AssociatedObject;

    /* loaded from: classes3.dex */
    public static class ActivityLifecycleCallbacksProxy implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<TKJSContext, TKLifeCycle> mCallBackMaps;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1171970941, "Lcom/tachikoma/core/module/handler/TKLifeCycle$ActivityLifecycleCallbacksProxy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1171970941, "Lcom/tachikoma/core/module/handler/TKLifeCycle$ActivityLifecycleCallbacksProxy;");
                    return;
                }
            }
            mCallBackMaps = new HashMap();
        }

        public ActivityLifecycleCallbacksProxy() {
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

        public static void registerLifecycleCallbacks(@NonNull TKJSContext tKJSContext, @NonNull TKLifeCycle tKLifeCycle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tKJSContext, tKLifeCycle) == null) {
                mCallBackMaps.put(tKJSContext, tKLifeCycle);
            }
        }

        public static void unRegisterLifecycleCallbacks(@NonNull TKJSContext tKJSContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, tKJSContext) == null) {
                mCallBackMaps.remove(tKJSContext);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityCreated(activity, bundle);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityDestroyed(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityPaused(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityResumed(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityStarted(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                for (Map.Entry<TKJSContext, TKLifeCycle> entry : mCallBackMaps.entrySet()) {
                    entry.getValue().onActivityStopped(activity);
                }
            }
        }
    }

    public TKLifeCycle(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mV8AssociatedObject = ((V8Object) Objects.requireNonNull(V8Proxy.getAssociateJsObject(list))).twin();
        ActivityLifecycleCallbacksProxy.registerLifecycleCallbacks(V8Proxy.getTKContext(list), this);
    }

    private void safelyCallLifecycle(String str, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, activity) == null) {
            try {
                if (V8Proxy.isV8Valid(this.mV8AssociatedObject)) {
                    this.mV8AssociatedObject.executeJSFunction(str, Integer.valueOf(activity.hashCode()));
                }
            } catch (Exception e2) {
                Logger.logE("safelyCallLifecycle", e2);
            }
        }
    }

    @Override // com.tachikoma.core.base.NativeModule
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            V8Proxy.release(this.mV8AssociatedObject);
        }
    }

    @Override // com.tachikoma.core.base.NativeModule
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "LifeCycle" : (String) invokeV.objValue;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            safelyCallLifecycle("onActivityCreated", activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            safelyCallLifecycle("onActivityDestroyed", activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            safelyCallLifecycle("onActivityPaused", activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            safelyCallLifecycle("onActivityResumed", activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
            safelyCallLifecycle("onActivitySaveInstanceState", activity);
        }
    }

    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            safelyCallLifecycle("onActivityStarted", activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            safelyCallLifecycle("onActivityStopped", activity);
        }
    }
}
