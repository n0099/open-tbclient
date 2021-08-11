package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class FlutterEnginePluginRegistry implements PluginRegistry, ActivityControlSurface, ServiceControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterEnginePluginRegistry";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Activity activity;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins;
    @Nullable
    public FlutterEngineActivityPluginBinding activityPluginBinding;
    @Nullable
    public BroadcastReceiver broadcastReceiver;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins;
    @Nullable
    public FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
    @Nullable
    public ContentProvider contentProvider;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins;
    @Nullable
    public FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
    @NonNull
    public final FlutterEngine flutterEngine;
    public boolean isWaitingForActivityReattachment;
    @NonNull
    public final FlutterPlugin.FlutterPluginBinding pluginBinding;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins;
    @Nullable
    public Service service;
    @NonNull
    public final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins;
    @Nullable
    public FlutterEngineServicePluginBinding servicePluginBinding;

    /* renamed from: io.flutter.embedding.engine.FlutterEnginePluginRegistry$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FlutterLoader flutterLoader;

        public /* synthetic */ DefaultFlutterAssets(FlutterLoader flutterLoader, AnonymousClass1 anonymousClass1) {
            this(flutterLoader);
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathByName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.flutterLoader.getLookupKeyForAsset(str) : (String) invokeL.objValue;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathBySubpath(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.flutterLoader.getLookupKeyForAsset(str) : (String) invokeL.objValue;
        }

        public DefaultFlutterAssets(@NonNull FlutterLoader flutterLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.flutterLoader = flutterLoader;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathByName(@NonNull String str, @NonNull String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.flutterLoader.getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets
        public String getAssetFilePathBySubpath(@NonNull String str, @NonNull String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.flutterLoader.getLookupKeyForAsset(str, str2) : (String) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Activity activity;
        @NonNull
        public final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        public final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners;
        @NonNull
        public final Set<PluginRegistry.NewIntentListener> onNewIntentListeners;
        @NonNull
        public final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners;
        @NonNull
        public final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners;
        @NonNull
        public final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners;

        public FlutterEngineActivityPluginBinding(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, lifecycle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.onRequestPermissionsResultListeners = new HashSet();
            this.onActivityResultListeners = new HashSet();
            this.onNewIntentListeners = new HashSet();
            this.onUserLeaveHintListeners = new HashSet();
            this.onSaveInstanceStateListeners = new HashSet();
            this.activity = activity;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activityResultListener) == null) {
                this.onActivityResultListeners.add(activityResultListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, newIntentListener) == null) {
                this.onNewIntentListeners.add(newIntentListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onSaveInstanceStateListener) == null) {
                this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, userLeaveHintListener) == null) {
                this.onUserLeaveHintListeners.add(userLeaveHintListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, requestPermissionsResultListener) == null) {
                this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        @NonNull
        public Activity getActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.activity : (Activity) invokeV.objValue;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        @NonNull
        public Object getLifecycle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.hiddenLifecycleReference : invokeV.objValue;
        }

        public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
            InterceptResult invokeIIL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048583, this, i2, i3, intent)) == null) {
                while (true) {
                    for (PluginRegistry.ActivityResultListener activityResultListener : this.onActivityResultListeners) {
                        z = activityResultListener.onActivityResult(i2, i3, intent) || z;
                    }
                    return z;
                }
            }
            return invokeIIL.booleanValue;
        }

        public void onNewIntent(@Nullable Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
                for (PluginRegistry.NewIntentListener newIntentListener : this.onNewIntentListeners) {
                    newIntentListener.onNewIntent(intent);
                }
            }
        }

        public boolean onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            InterceptResult invokeILL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, strArr, iArr)) == null) {
                while (true) {
                    for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.onRequestPermissionsResultListeners) {
                        z = requestPermissionsResultListener.onRequestPermissionsResult(i2, strArr, iArr) || z;
                    }
                    return z;
                }
            }
            return invokeILL.booleanValue;
        }

        public void onRestoreInstanceState(@Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
                for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener : this.onSaveInstanceStateListeners) {
                    onSaveInstanceStateListener.onRestoreInstanceState(bundle);
                }
            }
        }

        public void onSaveInstanceState(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
                for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener : this.onSaveInstanceStateListeners) {
                    onSaveInstanceStateListener.onSaveInstanceState(bundle);
                }
            }
        }

        public void onUserLeaveHint() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.onUserLeaveHintListeners) {
                    userLeaveHintListener.onUserLeaveHint();
                }
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, activityResultListener) == null) {
                this.onActivityResultListeners.remove(activityResultListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, newIntentListener) == null) {
                this.onNewIntentListeners.remove(newIntentListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, onSaveInstanceStateListener) == null) {
                this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, userLeaveHintListener) == null) {
                this.onUserLeaveHintListeners.remove(userLeaveHintListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
        public void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, requestPermissionsResultListener) == null) {
                this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final BroadcastReceiver broadcastReceiver;

        public FlutterEngineBroadcastReceiverPluginBinding(@NonNull BroadcastReceiver broadcastReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {broadcastReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.broadcastReceiver = broadcastReceiver;
        }

        @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding
        @NonNull
        public BroadcastReceiver getBroadcastReceiver() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.broadcastReceiver : (BroadcastReceiver) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final ContentProvider contentProvider;

        public FlutterEngineContentProviderPluginBinding(@NonNull ContentProvider contentProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.contentProvider = contentProvider;
        }

        @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding
        @NonNull
        public ContentProvider getContentProvider() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentProvider : (ContentProvider) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final HiddenLifecycleReference hiddenLifecycleReference;
        @NonNull
        public final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners;
        @NonNull
        public final Service service;

        public FlutterEngineServicePluginBinding(@NonNull Service service, @Nullable Lifecycle lifecycle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {service, lifecycle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.onModeChangeListeners = new HashSet();
            this.service = service;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        public void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onModeChangeListener) == null) {
                this.onModeChangeListeners.add(onModeChangeListener);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        @Nullable
        public Object getLifecycle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hiddenLifecycleReference : invokeV.objValue;
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        @NonNull
        public Service getService() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.service : (Service) invokeV.objValue;
        }

        public void onMoveToBackground() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (ServiceAware.OnModeChangeListener onModeChangeListener : this.onModeChangeListeners) {
                    onModeChangeListener.onMoveToBackground();
                }
            }
        }

        public void onMoveToForeground() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                for (ServiceAware.OnModeChangeListener onModeChangeListener : this.onModeChangeListeners) {
                    onModeChangeListener.onMoveToForeground();
                }
            }
        }

        @Override // io.flutter.embedding.engine.plugins.service.ServicePluginBinding
        public void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener onModeChangeListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, onModeChangeListener) == null) {
                this.onModeChangeListeners.remove(onModeChangeListener);
            }
        }
    }

    public FlutterEnginePluginRegistry(@NonNull Context context, @NonNull FlutterEngine flutterEngine, @NonNull FlutterLoader flutterLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterEngine, flutterLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.plugins = new HashMap();
        this.activityAwarePlugins = new HashMap();
        this.isWaitingForActivityReattachment = false;
        this.serviceAwarePlugins = new HashMap();
        this.broadcastReceiverAwarePlugins = new HashMap();
        this.contentProviderAwarePlugins = new HashMap();
        this.flutterEngine = flutterEngine;
        this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine, flutterEngine.getDartExecutor(), flutterEngine.getRenderer(), flutterEngine.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader, null));
    }

    private void detachFromAndroidComponent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (isAttachedToActivity()) {
                detachFromActivity();
            } else if (isAttachedToService()) {
                detachFromService();
            } else if (isAttachedToBroadcastReceiver()) {
                detachFromBroadcastReceiver();
            } else if (isAttachedToContentProvider()) {
                detachFromContentProvider();
            }
        }
    }

    private boolean isAttachedToActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.activity != null : invokeV.booleanValue;
    }

    private boolean isAttachedToBroadcastReceiver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.broadcastReceiver != null : invokeV.booleanValue;
    }

    private boolean isAttachedToContentProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.contentProvider != null : invokeV.booleanValue;
    }

    private boolean isAttachedToService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.service != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.FlutterPlugin> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.service.ServiceAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.util.Map<java.lang.Class<? extends io.flutter.embedding.engine.plugins.FlutterPlugin>, io.flutter.embedding.engine.plugins.activity.ActivityAware> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.flutter.embedding.engine.FlutterEnginePluginRegistry */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void add(@NonNull FlutterPlugin flutterPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPlugin) == null) {
            if (has(flutterPlugin.getClass())) {
                Log.w(TAG, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.flutterEngine + ").");
                return;
            }
            Log.v(TAG, "Adding plugin: " + flutterPlugin);
            this.plugins.put(flutterPlugin.getClass(), flutterPlugin);
            flutterPlugin.onAttachedToEngine(this.pluginBinding);
            if (flutterPlugin instanceof ActivityAware) {
                ActivityAware activityAware = (ActivityAware) flutterPlugin;
                this.activityAwarePlugins.put(flutterPlugin.getClass(), activityAware);
                if (isAttachedToActivity()) {
                    activityAware.onAttachedToActivity(this.activityPluginBinding);
                }
            }
            if (flutterPlugin instanceof ServiceAware) {
                ServiceAware serviceAware = (ServiceAware) flutterPlugin;
                this.serviceAwarePlugins.put(flutterPlugin.getClass(), serviceAware);
                if (isAttachedToService()) {
                    serviceAware.onAttachedToService(this.servicePluginBinding);
                }
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
                this.broadcastReceiverAwarePlugins.put(flutterPlugin.getClass(), broadcastReceiverAware);
                if (isAttachedToBroadcastReceiver()) {
                    broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
                }
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
                this.contentProviderAwarePlugins.put(flutterPlugin.getClass(), contentProviderAware);
                if (isAttachedToContentProvider()) {
                    contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
                }
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void attachToActivity(@NonNull Activity activity, @NonNull Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, lifecycle) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attaching to an Activity: ");
            sb.append(activity);
            sb.append(".");
            sb.append(this.isWaitingForActivityReattachment ? " This is after a config change." : "");
            Log.v(TAG, sb.toString());
            detachFromAndroidComponent();
            this.activity = activity;
            this.activityPluginBinding = new FlutterEngineActivityPluginBinding(activity, lifecycle);
            this.flutterEngine.getPlatformViewsController().attach(activity, this.flutterEngine.getRenderer(), this.flutterEngine.getDartExecutor());
            for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                if (this.isWaitingForActivityReattachment) {
                    activityAware.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
                } else {
                    activityAware.onAttachedToActivity(this.activityPluginBinding);
                }
            }
            this.isWaitingForActivityReattachment = false;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
    public void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, broadcastReceiver, lifecycle) == null) {
            Log.v(TAG, "Attaching to BroadcastReceiver: " + broadcastReceiver);
            detachFromAndroidComponent();
            this.broadcastReceiver = broadcastReceiver;
            this.broadcastReceiverPluginBinding = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver);
            for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
                broadcastReceiverAware.onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
    public void attachToContentProvider(@NonNull ContentProvider contentProvider, @NonNull Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, contentProvider, lifecycle) == null) {
            Log.v(TAG, "Attaching to ContentProvider: " + contentProvider);
            detachFromAndroidComponent();
            this.contentProvider = contentProvider;
            this.contentProviderPluginBinding = new FlutterEngineContentProviderPluginBinding(contentProvider);
            for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
                contentProviderAware.onAttachedToContentProvider(this.contentProviderPluginBinding);
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void attachToService(@NonNull Service service, @Nullable Lifecycle lifecycle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, service, lifecycle, z) == null) {
            Log.v(TAG, "Attaching to a Service: " + service);
            detachFromAndroidComponent();
            this.service = service;
            this.servicePluginBinding = new FlutterEngineServicePluginBinding(service, lifecycle);
            for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
                serviceAware.onAttachedToService(this.servicePluginBinding);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Log.v(TAG, "Destroying.");
            detachFromAndroidComponent();
            removeAll();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void detachFromActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (isAttachedToActivity()) {
                Log.v(TAG, "Detaching from an Activity: " + this.activity);
                for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                    activityAware.onDetachedFromActivity();
                }
                this.flutterEngine.getPlatformViewsController().detach();
                this.activity = null;
                this.activityPluginBinding = null;
                return;
            }
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void detachFromActivityForConfigChanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (isAttachedToActivity()) {
                Log.v(TAG, "Detaching from an Activity for config changes: " + this.activity);
                this.isWaitingForActivityReattachment = true;
                for (ActivityAware activityAware : this.activityAwarePlugins.values()) {
                    activityAware.onDetachedFromActivityForConfigChanges();
                }
                this.flutterEngine.getPlatformViewsController().detach();
                this.activity = null;
                this.activityPluginBinding = null;
                return;
            }
            Log.e(TAG, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
    public void detachFromBroadcastReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isAttachedToBroadcastReceiver()) {
                Log.v(TAG, "Detaching from BroadcastReceiver: " + this.broadcastReceiver);
                for (BroadcastReceiverAware broadcastReceiverAware : this.broadcastReceiverAwarePlugins.values()) {
                    broadcastReceiverAware.onDetachedFromBroadcastReceiver();
                }
                return;
            }
            Log.e(TAG, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
    public void detachFromContentProvider() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (isAttachedToContentProvider()) {
                Log.v(TAG, "Detaching from ContentProvider: " + this.contentProvider);
                for (ContentProviderAware contentProviderAware : this.contentProviderAwarePlugins.values()) {
                    contentProviderAware.onDetachedFromContentProvider();
                }
                return;
            }
            Log.e(TAG, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void detachFromService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (isAttachedToService()) {
                Log.v(TAG, "Detaching from a Service: " + this.service);
                for (ServiceAware serviceAware : this.serviceAwarePlugins.values()) {
                    serviceAware.onDetachedFromService();
                }
                this.service = null;
                this.servicePluginBinding = null;
                return;
            }
            Log.e(TAG, "Attempted to detach plugins from a Service when no Service was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) ? this.plugins.get(cls) : (FlutterPlugin) invokeL.objValue;
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public boolean has(@NonNull Class<? extends FlutterPlugin> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cls)) == null) ? this.plugins.containsKey(cls) : invokeL.booleanValue;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i2, i3, intent)) == null) {
            Log.v(TAG, "Forwarding onActivityResult() to plugins.");
            if (isAttachedToActivity()) {
                return this.activityPluginBinding.onActivityResult(i2, i3, intent);
            }
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void onMoveToBackground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to background.");
            this.servicePluginBinding.onMoveToBackground();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.service.ServiceControlSurface
    public void onMoveToForeground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && isAttachedToService()) {
            Log.v(TAG, "Attached Service moved to foreground.");
            this.servicePluginBinding.onMoveToForeground();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onNewIntent(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            Log.v(TAG, "Forwarding onNewIntent() to plugins.");
            if (isAttachedToActivity()) {
                this.activityPluginBinding.onNewIntent(intent);
            } else {
                Log.e(TAG, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public boolean onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i2, strArr, iArr)) == null) {
            Log.v(TAG, "Forwarding onRequestPermissionsResult() to plugins.");
            if (isAttachedToActivity()) {
                return this.activityPluginBinding.onRequestPermissionsResult(i2, strArr, iArr);
            }
            Log.e(TAG, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        return invokeILL.booleanValue;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            Log.v(TAG, "Forwarding onRestoreInstanceState() to plugins.");
            if (isAttachedToActivity()) {
                this.activityPluginBinding.onRestoreInstanceState(bundle);
            } else {
                Log.e(TAG, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            Log.v(TAG, "Forwarding onSaveInstanceState() to plugins.");
            if (isAttachedToActivity()) {
                this.activityPluginBinding.onSaveInstanceState(bundle);
            } else {
                Log.e(TAG, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Log.v(TAG, "Forwarding onUserLeaveHint() to plugins.");
            if (isAttachedToActivity()) {
                this.activityPluginBinding.onUserLeaveHint();
            } else {
                Log.e(TAG, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void remove(@NonNull Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cls) == null) || (flutterPlugin = this.plugins.get(cls)) == null) {
            return;
        }
        Log.v(TAG, "Removing plugin: " + flutterPlugin);
        if (flutterPlugin instanceof ActivityAware) {
            if (isAttachedToActivity()) {
                ((ActivityAware) flutterPlugin).onDetachedFromActivity();
            }
            this.activityAwarePlugins.remove(cls);
        }
        if (flutterPlugin instanceof ServiceAware) {
            if (isAttachedToService()) {
                ((ServiceAware) flutterPlugin).onDetachedFromService();
            }
            this.serviceAwarePlugins.remove(cls);
        }
        if (flutterPlugin instanceof BroadcastReceiverAware) {
            if (isAttachedToBroadcastReceiver()) {
                ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
            }
            this.broadcastReceiverAwarePlugins.remove(cls);
        }
        if (flutterPlugin instanceof ContentProviderAware) {
            if (isAttachedToContentProvider()) {
                ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
            }
            this.contentProviderAwarePlugins.remove(cls);
        }
        flutterPlugin.onDetachedFromEngine(this.pluginBinding);
        this.plugins.remove(cls);
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void removeAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            remove(new HashSet(this.plugins.keySet()));
            this.plugins.clear();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void remove(@NonNull Set<Class<? extends FlutterPlugin>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, set) == null) {
            for (Class<? extends FlutterPlugin> cls : set) {
                remove(cls);
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.PluginRegistry
    public void add(@NonNull Set<FlutterPlugin> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
            for (FlutterPlugin flutterPlugin : set) {
                add(flutterPlugin);
            }
        }
    }
}
