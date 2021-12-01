package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class FlutterEngine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterEngine";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AccessibilityChannel accessibilityChannel;
    @NonNull
    public final DartExecutor dartExecutor;
    @NonNull
    public final DeferredComponentChannel deferredComponentChannel;
    @NonNull
    public final EngineLifecycleListener engineLifecycleListener;
    @NonNull
    public final Set<EngineLifecycleListener> engineLifecycleListeners;
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final KeyEventChannel keyEventChannel;
    @NonNull
    public final LifecycleChannel lifecycleChannel;
    @NonNull
    public final LocalizationChannel localizationChannel;
    @NonNull
    public final LocalizationPlugin localizationPlugin;
    @NonNull
    public final MouseCursorChannel mouseCursorChannel;
    @NonNull
    public final NavigationChannel navigationChannel;
    @NonNull
    public final PlatformChannel platformChannel;
    @NonNull
    public final PlatformViewsController platformViewsController;
    @NonNull
    public final FlutterEngineConnectionRegistry pluginRegistry;
    @NonNull
    public final FlutterRenderer renderer;
    @NonNull
    public final RestorationChannel restorationChannel;
    @NonNull
    public final SettingsChannel settingsChannel;
    @NonNull
    public final SystemChannel systemChannel;
    @NonNull
    public final TextInputChannel textInputChannel;

    /* loaded from: classes3.dex */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void attachToJni() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Log.v(TAG, "Attaching to JNI.");
            this.flutterJNI.attachToNative(false);
            if (!isAttachedToJni()) {
                throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
            }
        }
    }

    private boolean isAttachedToJni() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.flutterJNI.isAttached() : invokeV.booleanValue;
    }

    public void addEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engineLifecycleListener) == null) {
            this.engineLifecycleListeners.add(engineLifecycleListener);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.v(TAG, "Destroying.");
            for (EngineLifecycleListener engineLifecycleListener : this.engineLifecycleListeners) {
                engineLifecycleListener.onEngineWillDestroy();
            }
            this.pluginRegistry.destroy();
            this.platformViewsController.onDetachedFromJNI();
            this.dartExecutor.onDetachedFromJNI();
            this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
            this.flutterJNI.setDeferredComponentManager(null);
            this.flutterJNI.detachFromNativeAndReleaseResources();
            if (FlutterInjector.instance().deferredComponentManager() != null) {
                FlutterInjector.instance().deferredComponentManager().destroy();
                this.deferredComponentChannel.setDeferredComponentManager(null);
            }
        }
    }

    @NonNull
    public AccessibilityChannel getAccessibilityChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.accessibilityChannel : (AccessibilityChannel) invokeV.objValue;
    }

    @NonNull
    public ActivityControlSurface getActivityControlSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pluginRegistry : (ActivityControlSurface) invokeV.objValue;
    }

    @NonNull
    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pluginRegistry : (BroadcastReceiverControlSurface) invokeV.objValue;
    }

    @NonNull
    public ContentProviderControlSurface getContentProviderControlSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pluginRegistry : (ContentProviderControlSurface) invokeV.objValue;
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.dartExecutor : (DartExecutor) invokeV.objValue;
    }

    @NonNull
    public DeferredComponentChannel getDeferredComponentChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.deferredComponentChannel : (DeferredComponentChannel) invokeV.objValue;
    }

    @NonNull
    public KeyEventChannel getKeyEventChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.keyEventChannel : (KeyEventChannel) invokeV.objValue;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.lifecycleChannel : (LifecycleChannel) invokeV.objValue;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.localizationChannel : (LocalizationChannel) invokeV.objValue;
    }

    @NonNull
    public LocalizationPlugin getLocalizationPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.localizationPlugin : (LocalizationPlugin) invokeV.objValue;
    }

    @NonNull
    public MouseCursorChannel getMouseCursorChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mouseCursorChannel : (MouseCursorChannel) invokeV.objValue;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.navigationChannel : (NavigationChannel) invokeV.objValue;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.platformChannel : (PlatformChannel) invokeV.objValue;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.platformViewsController : (PlatformViewsController) invokeV.objValue;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.pluginRegistry : (PluginRegistry) invokeV.objValue;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.renderer : (FlutterRenderer) invokeV.objValue;
    }

    @NonNull
    public RestorationChannel getRestorationChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.restorationChannel : (RestorationChannel) invokeV.objValue;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.pluginRegistry : (ServiceControlSurface) invokeV.objValue;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.settingsChannel : (SettingsChannel) invokeV.objValue;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.systemChannel : (SystemChannel) invokeV.objValue;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.textInputChannel : (TextInputChannel) invokeV.objValue;
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, engineLifecycleListener) == null) {
            this.engineLifecycleListeners.remove(engineLifecycleListener);
        }
    }

    @NonNull
    public FlutterEngine spawn(@NonNull Context context, @NonNull DartExecutor.DartEntrypoint dartEntrypoint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, context, dartEntrypoint)) == null) {
            if (isAttachedToJni()) {
                return new FlutterEngine(context, (FlutterLoader) null, this.flutterJNI.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary));
            }
            throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
        }
        return (FlutterEngine) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, null, null, strArr, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (String[]) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z) {
        this(context, null, null, strArr, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (String[]) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z, boolean z2) {
        this(context, null, null, new PlatformViewsController(), strArr, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (PlatformViewsController) objArr2[3], (String[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (String[]) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (PlatformViewsController) objArr2[3], (String[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, platformViewsController, strArr, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI, platformViewsController, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (PlatformViewsController) objArr2[3], (String[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z, boolean z2) {
        AssetManager assets;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI, platformViewsController, strArr, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener(this) { // from class: io.flutter.embedding.engine.FlutterEngine.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterEngine this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                    for (EngineLifecycleListener engineLifecycleListener : this.this$0.engineLifecycleListeners) {
                        engineLifecycleListener.onPreEngineRestart();
                    }
                    this.this$0.platformViewsController.onPreEngineRestart();
                    this.this$0.restorationChannel.clearData();
                }
            }
        };
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI = flutterJNI == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI;
        this.flutterJNI = flutterJNI;
        DartExecutor dartExecutor = new DartExecutor(flutterJNI, assets);
        this.dartExecutor = dartExecutor;
        dartExecutor.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, flutterJNI);
        this.deferredComponentChannel = new DeferredComponentChannel(this.dartExecutor);
        this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
        this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
        this.localizationChannel = new LocalizationChannel(this.dartExecutor);
        this.mouseCursorChannel = new MouseCursorChannel(this.dartExecutor);
        this.navigationChannel = new NavigationChannel(this.dartExecutor);
        this.platformChannel = new PlatformChannel(this.dartExecutor);
        this.restorationChannel = new RestorationChannel(this.dartExecutor, z2);
        this.settingsChannel = new SettingsChannel(this.dartExecutor);
        this.systemChannel = new SystemChannel(this.dartExecutor);
        this.textInputChannel = new TextInputChannel(this.dartExecutor);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(this.deferredComponentChannel);
        }
        this.localizationPlugin = new LocalizationPlugin(context, this.localizationChannel);
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI.setPlatformViewsController(platformViewsController);
        flutterJNI.setLocalizationPlugin(this.localizationPlugin);
        flutterJNI.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI.isAttached()) {
            attachToJni();
        }
        this.renderer = new FlutterRenderer(flutterJNI);
        this.platformViewsController = platformViewsController;
        platformViewsController.onAttachedToJNI();
        this.pluginRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader);
        if (z && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
    }
}
