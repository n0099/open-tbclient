package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
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
    public final NavigationChannel navigationChannel;
    @NonNull
    public final PlatformChannel platformChannel;
    @NonNull
    public final PlatformViewsController platformViewsController;
    @NonNull
    public final FlutterEnginePluginRegistry pluginRegistry;
    @NonNull
    public final FlutterRenderer renderer;
    @NonNull
    public final SettingsChannel settingsChannel;
    @NonNull
    public final SystemChannel systemChannel;
    @NonNull
    public final TextInputChannel textInputChannel;

    /* loaded from: classes3.dex */
    public interface EngineLifecycleListener {
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
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.flutterJNI.isAttached() : invokeV.booleanValue;
    }

    private void registerPlugins() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, this);
            } catch (Exception unused) {
                Log.w(TAG, "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
            }
        }
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
            this.pluginRegistry.destroy();
            this.dartExecutor.onDetachedFromJNI();
            this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
            this.flutterJNI.detachFromNativeAndReleaseResources();
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
    public KeyEventChannel getKeyEventChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.keyEventChannel : (KeyEventChannel) invokeV.objValue;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lifecycleChannel : (LifecycleChannel) invokeV.objValue;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.localizationChannel : (LocalizationChannel) invokeV.objValue;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.navigationChannel : (NavigationChannel) invokeV.objValue;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.platformChannel : (PlatformChannel) invokeV.objValue;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.platformViewsController : (PlatformViewsController) invokeV.objValue;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.pluginRegistry : (PluginRegistry) invokeV.objValue;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.renderer : (FlutterRenderer) invokeV.objValue;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.pluginRegistry : (ServiceControlSurface) invokeV.objValue;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.settingsChannel : (SettingsChannel) invokeV.objValue;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.systemChannel : (SystemChannel) invokeV.objValue;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.textInputChannel : (TextInputChannel) invokeV.objValue;
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, engineLifecycleListener) == null) {
            this.engineLifecycleListeners.remove(engineLifecycleListener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (String[]) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (String[]) objArr2[3], ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI) {
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
    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (FlutterLoader) objArr2[1], (FlutterJNI) objArr2[2], (PlatformViewsController) objArr2[3], (String[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, flutterLoader, flutterJNI, platformViewsController, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
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
            public void onPreEngineRestart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                    for (EngineLifecycleListener engineLifecycleListener : this.this$0.engineLifecycleListeners) {
                        engineLifecycleListener.onPreEngineRestart();
                    }
                    this.this$0.platformViewsController.onPreEngineRestart();
                }
            }
        };
        this.flutterJNI = flutterJNI;
        flutterLoader.startInitialization(context.getApplicationContext());
        flutterLoader.ensureInitializationComplete(context, strArr);
        flutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
        attachToJni();
        DartExecutor dartExecutor = new DartExecutor(flutterJNI, context.getAssets());
        this.dartExecutor = dartExecutor;
        dartExecutor.onAttachedToJNI();
        this.renderer = new FlutterRenderer(flutterJNI);
        this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, flutterJNI);
        this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
        this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
        this.localizationChannel = new LocalizationChannel(this.dartExecutor);
        this.navigationChannel = new NavigationChannel(this.dartExecutor);
        this.platformChannel = new PlatformChannel(this.dartExecutor);
        this.settingsChannel = new SettingsChannel(this.dartExecutor);
        this.systemChannel = new SystemChannel(this.dartExecutor);
        this.textInputChannel = new TextInputChannel(this.dartExecutor);
        this.platformViewsController = platformViewsController;
        this.pluginRegistry = new FlutterEnginePluginRegistry(context.getApplicationContext(), this, flutterLoader);
        if (z) {
            registerPlugins();
        }
    }
}
