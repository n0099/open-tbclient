package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Deprecated
/* loaded from: classes8.dex */
public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterPluginRegistry";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public final List<PluginRegistry.ActivityResultListener> mActivityResultListeners;
    public Context mAppContext;
    public FlutterView mFlutterView;
    public FlutterNativeView mNativeView;
    public final List<PluginRegistry.NewIntentListener> mNewIntentListeners;
    public final PlatformViewsController mPlatformViewsController;
    public final Map<String, Object> mPluginMap;
    public final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners;
    public final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners;
    public final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners;

    /* loaded from: classes8.dex */
    public class FlutterRegistrar implements PluginRegistry.Registrar {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String pluginKey;
        public final /* synthetic */ FlutterPluginRegistry this$0;

        public FlutterRegistrar(FlutterPluginRegistry flutterPluginRegistry, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterPluginRegistry, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterPluginRegistry;
            this.pluginKey = str;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context activeContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.mActivity != null ? this.this$0.mActivity : this.this$0.mAppContext : (Context) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Activity activity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mActivity : (Activity) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activityResultListener)) == null) {
                this.this$0.mActivityResultListeners.add(activityResultListener);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, newIntentListener)) == null) {
                this.this$0.mNewIntentListeners.add(newIntentListener);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, requestPermissionsResultListener)) == null) {
                this.this$0.mRequestPermissionsResultListeners.add(requestPermissionsResultListener);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, userLeaveHintListener)) == null) {
                this.this$0.mUserLeaveHintListeners.add(userLeaveHintListener);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewDestroyListener)) == null) {
                this.this$0.mViewDestroyListeners.add(viewDestroyListener);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context context() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.this$0.mAppContext : (Context) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? FlutterMain.getLookupKeyForAsset(str) : (String) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public BinaryMessenger messenger() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.this$0.mNativeView : (BinaryMessenger) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PlatformViewRegistry platformViewRegistry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.this$0.mPlatformViewsController.getRegistry() : (PlatformViewRegistry) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar publish(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                this.this$0.mPluginMap.put(this.pluginKey, obj);
                return this;
            }
            return (PluginRegistry.Registrar) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public TextureRegistry textures() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.this$0.mFlutterView : (TextureRegistry) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public FlutterView view() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.this$0.mFlutterView : (FlutterView) invokeV.objValue;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) ? FlutterMain.getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
        }
    }

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterNativeView, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPluginMap = new LinkedHashMap(0);
        this.mRequestPermissionsResultListeners = new ArrayList(0);
        this.mActivityResultListeners = new ArrayList(0);
        this.mNewIntentListeners = new ArrayList(0);
        this.mUserLeaveHintListeners = new ArrayList(0);
        this.mViewDestroyListeners = new ArrayList(0);
        this.mNativeView = flutterNativeView;
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }

    public void attach(FlutterView flutterView, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, flutterView, activity) == null) {
            this.mFlutterView = flutterView;
            this.mActivity = activity;
            this.mPlatformViewsController.attach(activity, flutterView, flutterView.getDartExecutor());
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mPlatformViewsController.onDetachedFromJNI();
        }
    }

    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mPlatformViewsController.detach();
            this.mPlatformViewsController.onDetachedFromJNI();
            this.mFlutterView = null;
            this.mActivity = null;
        }
    }

    public PlatformViewsController getPlatformViewsController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlatformViewsController : (PlatformViewsController) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mPluginMap.containsKey(str) : invokeL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, intent)) == null) {
            for (PluginRegistry.ActivityResultListener activityResultListener : this.mActivityResultListeners) {
                if (activityResultListener.onActivityResult(i2, i3, intent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
            for (PluginRegistry.NewIntentListener newIntentListener : this.mNewIntentListeners) {
                if (newIntentListener.onNewIntent(intent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onPreEngineRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mPlatformViewsController.onPreEngineRestart();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr)) == null) {
            for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.mRequestPermissionsResultListeners) {
                if (requestPermissionsResultListener.onRequestPermissionsResult(i2, strArr, iArr)) {
                    return true;
                }
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.mUserLeaveHintListeners) {
                userLeaveHintListener.onUserLeaveHint();
            }
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ViewDestroyListener
    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, flutterNativeView)) == null) {
            boolean z = false;
            for (PluginRegistry.ViewDestroyListener viewDestroyListener : this.mViewDestroyListeners) {
                if (viewDestroyListener.onViewDestroy(flutterNativeView)) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!this.mPluginMap.containsKey(str)) {
                this.mPluginMap.put(str, null);
                return new FlutterRegistrar(this, str);
            }
            throw new IllegalStateException("Plugin key " + str + " is already in use");
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (T) this.mPluginMap.get(str) : (T) invokeL.objValue;
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterEngine, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPluginMap = new LinkedHashMap(0);
        this.mRequestPermissionsResultListeners = new ArrayList(0);
        this.mActivityResultListeners = new ArrayList(0);
        this.mNewIntentListeners = new ArrayList(0);
        this.mUserLeaveHintListeners = new ArrayList(0);
        this.mViewDestroyListeners = new ArrayList(0);
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }
}
