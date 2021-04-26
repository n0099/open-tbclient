package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
@Keep
/* loaded from: classes7.dex */
public class FlutterJNI {
    public static final String TAG = "FlutterJNI";
    @Nullable
    public static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    @Nullable
    public static String observatoryUri;
    public static float refreshRateFPS;
    @Nullable
    public AccessibilityDelegate accessibilityDelegate;
    @NonNull
    public final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    @NonNull
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    @NonNull
    public final Looper mainLooper = Looper.getMainLooper();
    @Nullable
    public Long nativePlatformViewId;
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* loaded from: classes7.dex */
    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);

        void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);
    }

    /* loaded from: classes7.dex */
    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j);
    }

    public static void asyncWaitForVsync(long j) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(j);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    private void ensureAttachedToNative() {
        if (this.nativePlatformViewId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativePlatformViewId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Nullable
    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private void handlePlatformMessage(@NonNull String str, byte[] bArr, int i2) {
        PlatformMessageHandler platformMessageHandler = this.platformMessageHandler;
        if (platformMessageHandler != null) {
            platformMessageHandler.handleMessageFromDart(str, bArr, i2);
        }
    }

    private void handlePlatformMessageResponse(int i2, byte[] bArr) {
        PlatformMessageHandler platformMessageHandler = this.platformMessageHandler;
        if (platformMessageHandler != null) {
            platformMessageHandler.handlePlatformMessageResponse(i2, bArr);
        }
    }

    private native long nativeAttach(@NonNull FlutterJNI flutterJNI, boolean z);

    private native void nativeDestroy(long j);

    private native void nativeDispatchEmptyPlatformMessage(long j, @NonNull String str, int i2);

    private native void nativeDispatchPlatformMessage(long j, @NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeDispatchPointerDataPacket(long j, @NonNull ByteBuffer byteBuffer, int i2);

    private native void nativeDispatchSemanticsAction(long j, int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4);

    private native Bitmap nativeGetBitmap(long j);

    public static native void nativeInit(@NonNull Context context, @NonNull String[] strArr, @Nullable String str, @NonNull String str2, @NonNull String str3);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j, int i2);

    private native void nativeInvokePlatformMessageResponseCallback(long j, int i2, @Nullable ByteBuffer byteBuffer, int i3);

    @NonNull
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j);

    private native void nativeMarkTextureFrameAvailable(long j, long j2);

    public static native void nativeOnVsync(long j, long j2, long j3);

    public static native void nativeRecordStartTimestamp(long j);

    private native void nativeRegisterTexture(long j, long j2, @NonNull SurfaceTexture surfaceTexture);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j, @NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager);

    private native void nativeSetAccessibilityFeatures(long j, int i2);

    private native void nativeSetSemanticsEnabled(long j, boolean z);

    private native void nativeSetViewportMetrics(long j, float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    private native void nativeSurfaceChanged(long j, int i2, int i3);

    private native void nativeSurfaceCreated(long j, @NonNull Surface surface);

    private native void nativeSurfaceDestroyed(long j);

    private native void nativeUnregisterTexture(long j, long j2);

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener engineLifecycleListener : this.engineLifecycleListeners) {
            engineLifecycleListener.onPreEngineRestart();
        }
    }

    public static void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    public static void setRefreshRateFPS(float f2) {
        refreshRateFPS = f2;
    }

    @UiThread
    private void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
    }

    @UiThread
    private void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.updateSemantics(byteBuffer, strArr);
        }
    }

    @UiThread
    public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    @UiThread
    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    @UiThread
    public void attachToNative(boolean z) {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativePlatformViewId = Long.valueOf(nativeAttach(this, z));
    }

    @UiThread
    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativePlatformViewId.longValue());
        this.nativePlatformViewId = null;
    }

    @UiThread
    public void dispatchEmptyPlatformMessage(@NonNull String str, int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), str, i2);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
    }

    @UiThread
    public void dispatchPlatformMessage(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, int i3) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), str, byteBuffer, i2, i3);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i3);
    }

    @UiThread
    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), byteBuffer, i2);
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action) {
        dispatchSemanticsAction(i2, action, null);
    }

    @UiThread
    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativePlatformViewId.longValue());
    }

    @UiThread
    public void invokePlatformMessageEmptyResponseCallback(int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), i2);
            return;
        }
        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
    }

    @UiThread
    public void invokePlatformMessageResponseCallback(int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), i2, byteBuffer, i3);
            return;
        }
        Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
    }

    public boolean isAttached() {
        return this.nativePlatformViewId != null;
    }

    @UiThread
    public void markTextureFrameAvailable(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), j);
    }

    @UiThread
    public native boolean nativeGetIsSoftwareRenderingEnabled();

    @UiThread
    @VisibleForTesting
    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    @UiThread
    @VisibleForTesting
    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
            flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
    }

    @UiThread
    public void onSurfaceChanged(int i2, int i3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativePlatformViewId.longValue(), i2, i3);
    }

    @UiThread
    public void onSurfaceCreated(@NonNull Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativePlatformViewId.longValue(), surface);
    }

    @UiThread
    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
    }

    @UiThread
    public void registerTexture(long j, @NonNull SurfaceTexture surfaceTexture) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativePlatformViewId.longValue(), j, surfaceTexture);
    }

    @UiThread
    public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    @UiThread
    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    @UiThread
    public void runBundleAndSnapshotFromLibrary(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), str, str2, str3, assetManager);
    }

    @UiThread
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate;
    }

    @UiThread
    public void setAccessibilityFeatures(int i2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), i2);
    }

    @UiThread
    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler;
    }

    @UiThread
    public void setSemanticsEnabled(boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), z);
    }

    @UiThread
    public void setViewportMetrics(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), f2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
    }

    @UiThread
    public void unregisterTexture(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativePlatformViewId.longValue(), j);
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        ByteBuffer byteBuffer;
        int i3;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(obj);
            i3 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i3 = 0;
        }
        dispatchSemanticsAction(i2, action.value, byteBuffer, i3);
    }

    @UiThread
    public void dispatchSemanticsAction(int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), i2, i3, byteBuffer, i4);
    }
}
