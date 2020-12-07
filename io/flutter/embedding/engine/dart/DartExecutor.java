package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.FlutterMain;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class DartExecutor implements BinaryMessenger {
    private static final String TAG = "DartExecutor";
    private final AssetManager assetManager;
    private final BinaryMessenger binaryMessenger;
    private final DartMessenger dartMessenger;
    private final FlutterJNI flutterJNI;
    private boolean isApplicationRunning = false;
    private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler = new BinaryMessenger.BinaryMessageHandler() { // from class: io.flutter.embedding.engine.dart.DartExecutor.1
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            DartExecutor.this.isolateServiceId = StringCodec.INSTANCE.decodeMessage(byteBuffer);
            if (DartExecutor.this.isolateServiceIdListener != null) {
                DartExecutor.this.isolateServiceIdListener.onIsolateServiceIdAvailable(DartExecutor.this.isolateServiceId);
            }
        }
    };
    private String isolateServiceId;
    private IsolateServiceIdListener isolateServiceIdListener;

    /* loaded from: classes9.dex */
    interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(String str);
    }

    public DartExecutor(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.flutterJNI = flutterJNI;
        this.assetManager = assetManager;
        this.dartMessenger = new DartMessenger(flutterJNI);
        this.dartMessenger.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
        this.binaryMessenger = new DefaultBinaryMessenger(this.dartMessenger);
    }

    public void onAttachedToJNI() {
        Log.v(TAG, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
    }

    public void onDetachedFromJNI() {
        Log.v(TAG, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(null);
    }

    public boolean isExecutingDart() {
        return this.isApplicationRunning;
    }

    public void executeDartEntrypoint(DartEntrypoint dartEntrypoint) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Log.v(TAG, "Executing Dart entrypoint: " + dartEntrypoint);
        this.flutterJNI.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, null, this.assetManager);
        this.isApplicationRunning = true;
    }

    public void executeDartCallback(DartCallback dartCallback) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Log.v(TAG, "Executing Dart callback: " + dartCallback);
        this.flutterJNI.runBundleAndSnapshotFromLibrary(dartCallback.pathToBundle, dartCallback.callbackHandle.callbackName, dartCallback.callbackHandle.callbackLibraryPath, dartCallback.androidAssetManager);
        this.isApplicationRunning = true;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @Deprecated
    public void send(String str, ByteBuffer byteBuffer) {
        this.binaryMessenger.send(str, byteBuffer);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @Deprecated
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        this.binaryMessenger.send(str, byteBuffer, binaryReply);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @Deprecated
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.binaryMessenger.setMessageHandler(str, binaryMessageHandler);
    }

    public int getPendingChannelResponseCount() {
        return this.dartMessenger.getPendingChannelResponseCount();
    }

    public String getIsolateServiceId() {
        return this.isolateServiceId;
    }

    public void setIsolateServiceIdListener(IsolateServiceIdListener isolateServiceIdListener) {
        this.isolateServiceIdListener = isolateServiceIdListener;
        if (this.isolateServiceIdListener != null && this.isolateServiceId != null) {
            this.isolateServiceIdListener.onIsolateServiceIdAvailable(this.isolateServiceId);
        }
    }

    /* loaded from: classes9.dex */
    public static class DartEntrypoint {
        public final String dartEntrypointFunctionName;
        public final String pathToBundle;

        public static DartEntrypoint createDefault() {
            return new DartEntrypoint(FlutterMain.findAppBundlePath(), "main");
        }

        public DartEntrypoint(String str, String str2) {
            this.pathToBundle = str;
            this.dartEntrypointFunctionName = str2;
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DartEntrypoint dartEntrypoint = (DartEntrypoint) obj;
            if (this.pathToBundle.equals(dartEntrypoint.pathToBundle)) {
                return this.dartEntrypointFunctionName.equals(dartEntrypoint.dartEntrypointFunctionName);
            }
            return false;
        }

        public int hashCode() {
            return (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode();
        }
    }

    /* loaded from: classes9.dex */
    public static class DartCallback {
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.androidAssetManager = assetManager;
            this.pathToBundle = str;
            this.callbackHandle = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
        }
    }

    /* loaded from: classes9.dex */
    private static class DefaultBinaryMessenger implements BinaryMessenger {
        private final DartMessenger messenger;

        private DefaultBinaryMessenger(DartMessenger dartMessenger) {
            this.messenger = dartMessenger;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        public void send(String str, ByteBuffer byteBuffer) {
            this.messenger.send(str, byteBuffer, null);
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            this.messenger.send(str, byteBuffer, binaryReply);
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
            this.messenger.setMessageHandler(str, binaryMessageHandler);
        }
    }
}
