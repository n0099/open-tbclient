package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class FlutterNativeView implements BinaryMessenger {
    private static final String TAG = "FlutterNativeView";
    private boolean applicationIsRunning;
    private final DartExecutor dartExecutor;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Context mContext;
    private final FlutterJNI mFlutterJNI;
    private FlutterView mFlutterView;
    private final FlutterPluginRegistry mPluginRegistry;

    public FlutterNativeView(Context context) {
        this(context, false);
    }

    public FlutterNativeView(Context context, boolean z) {
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.view.FlutterNativeView.1
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                if (FlutterNativeView.this.mFlutterView != null) {
                    FlutterNativeView.this.mFlutterView.onFirstFrame();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.mContext = context;
        this.mPluginRegistry = new FlutterPluginRegistry(this, context);
        this.mFlutterJNI = new FlutterJNI();
        this.mFlutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.dartExecutor = new DartExecutor(this.mFlutterJNI, context.getAssets());
        this.mFlutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        attach(this, z);
        assertAttached();
    }

    public void detachFromFlutterView() {
        this.mPluginRegistry.detach();
        this.mFlutterView = null;
    }

    public void destroy() {
        this.mPluginRegistry.destroy();
        this.dartExecutor.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        this.mFlutterJNI.detachFromNativeAndReleaseResources();
        this.applicationIsRunning = false;
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mPluginRegistry;
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mPluginRegistry.attach(flutterView, activity);
    }

    public boolean isAttached() {
        return this.mFlutterJNI.isAttached();
    }

    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        if (flutterRunArguments.entrypoint == null) {
            throw new AssertionError("An entrypoint must be specified");
        }
        assertAttached();
        if (this.applicationIsRunning) {
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        this.mFlutterJNI.runBundleAndSnapshotFromLibrary(flutterRunArguments.bundlePath, flutterRunArguments.entrypoint, flutterRunArguments.libraryPath, this.mContext.getResources().getAssets());
        this.applicationIsRunning = true;
    }

    public boolean isApplicationRunning() {
        return this.applicationIsRunning;
    }

    public static String getObservatoryUri() {
        return FlutterJNI.getObservatoryUri();
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer) {
        this.dartExecutor.getBinaryMessenger().send(str, byteBuffer);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + str);
        } else {
            this.dartExecutor.getBinaryMessenger().send(str, byteBuffer, binaryReply);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.dartExecutor.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterJNI getFlutterJNI() {
        return this.mFlutterJNI;
    }

    private void attach(FlutterNativeView flutterNativeView, boolean z) {
        this.mFlutterJNI.attachToNative(z);
        this.dartExecutor.onAttachedToJNI();
    }

    /* loaded from: classes9.dex */
    private final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        private EngineLifecycleListenerImpl() {
        }

        @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
        public void onPreEngineRestart() {
            if (FlutterNativeView.this.mFlutterView != null) {
                FlutterNativeView.this.mFlutterView.resetAccessibilityTree();
            }
            if (FlutterNativeView.this.mPluginRegistry != null) {
                FlutterNativeView.this.mPluginRegistry.onPreEngineRestart();
            }
        }
    }
}
