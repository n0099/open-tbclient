package io.flutter.embedding.engine;

import android.content.Context;
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
/* loaded from: classes9.dex */
public class FlutterEngine {
    private static final String TAG = "FlutterEngine";
    private final AccessibilityChannel accessibilityChannel;
    private final DartExecutor dartExecutor;
    private final EngineLifecycleListener engineLifecycleListener;
    private final Set<EngineLifecycleListener> engineLifecycleListeners;
    private final FlutterJNI flutterJNI;
    private final KeyEventChannel keyEventChannel;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private final NavigationChannel navigationChannel;
    private final PlatformChannel platformChannel;
    private final PlatformViewsController platformViewsController;
    private final FlutterEnginePluginRegistry pluginRegistry;
    private final FlutterRenderer renderer;
    private final SettingsChannel settingsChannel;
    private final SystemChannel systemChannel;
    private final TextInputChannel textInputChannel;

    /* loaded from: classes9.dex */
    public interface EngineLifecycleListener {
        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, null);
    }

    public FlutterEngine(Context context, String[] strArr) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, true);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z) {
        this(context, FlutterLoader.getInstance(), new FlutterJNI(), strArr, z);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] strArr, boolean z) {
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

    public void addEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    public KeyEventChannel getKeyEventChannel() {
        return this.keyEventChannel;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }
}
