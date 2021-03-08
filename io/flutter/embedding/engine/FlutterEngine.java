package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes14.dex */
public class FlutterEngine {
    private static final String TAG = "FlutterEngine";
    @NonNull
    private final AccessibilityChannel accessibilityChannel;
    @NonNull
    private final DartExecutor dartExecutor;
    @NonNull
    private final EngineLifecycleListener engineLifecycleListener;
    @NonNull
    private final Set<EngineLifecycleListener> engineLifecycleListeners;
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final KeyEventChannel keyEventChannel;
    @NonNull
    private final LifecycleChannel lifecycleChannel;
    @NonNull
    private final LocalizationChannel localizationChannel;
    @NonNull
    private final NavigationChannel navigationChannel;
    @NonNull
    private final PlatformChannel platformChannel;
    @NonNull
    private final PlatformViewsController platformViewsController;
    @NonNull
    private final FlutterEnginePluginRegistry pluginRegistry;
    @NonNull
    private final FlutterRenderer renderer;
    @NonNull
    private final SettingsChannel settingsChannel;
    @NonNull
    private final SystemChannel systemChannel;
    @NonNull
    private final TextInputChannel textInputChannel;

    /* loaded from: classes14.dex */
    public interface EngineLifecycleListener {
        void onPreEngineRestart();
    }

    public FlutterEngine(@NonNull Context context) {
        this(context, null);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, z);
    }

    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, null, true);
    }

    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @Nullable String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(@NonNull Context context, @NonNull FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z) {
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() { // from class: io.flutter.embedding.engine.FlutterEngine.1
            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener engineLifecycleListener : FlutterEngine.this.engineLifecycleListeners) {
                    engineLifecycleListener.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
            }
        };
        this.flutterJNI = flutterJNI;
        flutterLoader.startInitialization(context.getApplicationContext());
        flutterLoader.ensureInitializationComplete(context, strArr);
        flutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
        attachToJni();
        this.dartExecutor = new DartExecutor(flutterJNI, context.getAssets());
        this.dartExecutor.onAttachedToJNI();
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

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative(false);
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    private void registerPlugins() {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, this);
        } catch (Exception e) {
            Log.w(TAG, "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        this.pluginRegistry.destroy();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.detachFromNativeAndReleaseResources();
    }

    public void addEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    @NonNull
    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    @NonNull
    public KeyEventChannel getKeyEventChannel() {
        return this.keyEventChannel;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    @NonNull
    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }
}
