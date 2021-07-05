package io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class ShimRegistrar implements PluginRegistry.Registrar, FlutterPlugin, ActivityAware {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ShimRegistrar";
    public transient /* synthetic */ FieldHolder $fh;
    public ActivityPluginBinding activityPluginBinding;
    public final Set<PluginRegistry.ActivityResultListener> activityResultListeners;
    public final Map<String, Object> globalRegistrarMap;
    public final Set<PluginRegistry.NewIntentListener> newIntentListeners;
    public FlutterPlugin.FlutterPluginBinding pluginBinding;
    public final String pluginId;
    public final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners;
    public final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners;
    public final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners;

    public ShimRegistrar(@NonNull String str, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.viewDestroyListeners = new HashSet();
        this.requestPermissionsResultListeners = new HashSet();
        this.activityResultListeners = new HashSet();
        this.newIntentListeners = new HashSet();
        this.userLeaveHintListeners = new HashSet();
        this.pluginId = str;
        this.globalRegistrarMap = map;
    }

    private void addExistingListenersToActivityPluginBinding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.requestPermissionsResultListeners) {
                this.activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
            }
            for (PluginRegistry.ActivityResultListener activityResultListener : this.activityResultListeners) {
                this.activityPluginBinding.addActivityResultListener(activityResultListener);
            }
            for (PluginRegistry.NewIntentListener newIntentListener : this.newIntentListeners) {
                this.activityPluginBinding.addOnNewIntentListener(newIntentListener);
            }
            for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.userLeaveHintListeners) {
                this.activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
            }
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context activeContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activityPluginBinding == null ? context() : activity() : (Context) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Activity activity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                return activityPluginBinding.getActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activityResultListener)) == null) {
            this.activityResultListeners.add(activityResultListener);
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.addActivityResultListener(activityResultListener);
            }
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, newIntentListener)) == null) {
            this.newIntentListeners.add(newIntentListener);
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.addOnNewIntentListener(newIntentListener);
            }
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, requestPermissionsResultListener)) == null) {
            this.requestPermissionsResultListeners.add(requestPermissionsResultListener);
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
            }
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, userLeaveHintListener)) == null) {
            this.userLeaveHintListeners.add(userLeaveHintListener);
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
            }
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    @NonNull
    public PluginRegistry.Registrar addViewDestroyListener(@NonNull PluginRegistry.ViewDestroyListener viewDestroyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewDestroyListener)) == null) {
            this.viewDestroyListeners.add(viewDestroyListener);
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public Context context() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
            if (flutterPluginBinding != null) {
                return flutterPluginBinding.getApplicationContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
            if (flutterPluginBinding != null) {
                return flutterPluginBinding.getBinaryMessenger();
            }
            return null;
        }
        return (BinaryMessenger) invokeV.objValue;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activityPluginBinding) == null) {
            Log.v(TAG, "Attached to an Activity.");
            this.activityPluginBinding = activityPluginBinding;
            addExistingListenersToActivityPluginBinding();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, flutterPluginBinding) == null) {
            Log.v(TAG, "Attached to FlutterEngine.");
            this.pluginBinding = flutterPluginBinding;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Log.v(TAG, "Detached from an Activity.");
            this.activityPluginBinding = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Log.v(TAG, "Detached from an Activity for config changes.");
            this.activityPluginBinding = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, flutterPluginBinding) == null) {
            Log.v(TAG, "Detached from FlutterEngine.");
            for (PluginRegistry.ViewDestroyListener viewDestroyListener : this.viewDestroyListeners) {
                viewDestroyListener.onViewDestroy(null);
            }
            this.pluginBinding = null;
            this.activityPluginBinding = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activityPluginBinding) == null) {
            Log.v(TAG, "Reconnected to an Activity after config changes.");
            this.activityPluginBinding = activityPluginBinding;
            addExistingListenersToActivityPluginBinding();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PlatformViewRegistry platformViewRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
            if (flutterPluginBinding != null) {
                return flutterPluginBinding.getPlatformViewRegistry();
            }
            return null;
        }
        return (PlatformViewRegistry) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public PluginRegistry.Registrar publish(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            this.globalRegistrarMap.put(this.pluginId, obj);
            return this;
        }
        return (PluginRegistry.Registrar) invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public TextureRegistry textures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.pluginBinding;
            if (flutterPluginBinding != null) {
                return flutterPluginBinding.getTextureRegistry();
            }
            return null;
        }
        return (TextureRegistry) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public FlutterView view() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
        }
        return (FlutterView) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.Registrar
    public String lookupKeyForAsset(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) ? FlutterMain.getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
    }
}
