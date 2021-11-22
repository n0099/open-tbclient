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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class FlutterJNI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterJNI";
    @Nullable
    public static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    @Nullable
    public static String observatoryUri;
    public static float refreshRateFPS;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AccessibilityDelegate accessibilityDelegate;
    @NonNull
    public final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners;
    @NonNull
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    @NonNull
    public final Looper mainLooper;
    @Nullable
    public Long nativePlatformViewId;
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* loaded from: classes2.dex */
    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);

        void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);
    }

    /* loaded from: classes2.dex */
    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2046519475, "Lio/flutter/embedding/engine/FlutterJNI;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2046519475, "Lio/flutter/embedding/engine/FlutterJNI;");
        }
    }

    public FlutterJNI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.engineLifecycleListeners = new CopyOnWriteArraySet();
        this.flutterUiDisplayListeners = new CopyOnWriteArraySet();
        this.mainLooper = Looper.getMainLooper();
    }

    public static void asyncWaitForVsync(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
            if (asyncWaitForVsyncDelegate2 != null) {
                asyncWaitForVsyncDelegate2.asyncWaitForVsync(j);
                return;
            }
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
    }

    private void ensureAttachedToNative() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.nativePlatformViewId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.nativePlatformViewId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Nullable
    public static String getObservatoryUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? observatoryUri : (String) invokeV.objValue;
    }

    private void handlePlatformMessage(@NonNull String str, byte[] bArr, int i2) {
        PlatformMessageHandler platformMessageHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, this, str, bArr, i2) == null) || (platformMessageHandler = this.platformMessageHandler) == null) {
            return;
        }
        platformMessageHandler.handleMessageFromDart(str, bArr, i2);
    }

    private void handlePlatformMessageResponse(int i2, byte[] bArr) {
        PlatformMessageHandler platformMessageHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65544, this, i2, bArr) == null) || (platformMessageHandler = this.platformMessageHandler) == null) {
            return;
        }
        platformMessageHandler.handlePlatformMessageResponse(i2, bArr);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            for (FlutterEngine.EngineLifecycleListener engineLifecycleListener : this.engineLifecycleListeners) {
                engineLifecycleListener.onPreEngineRestart();
            }
        }
    }

    public static void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, asyncWaitForVsyncDelegate2) == null) {
            asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
        }
    }

    public static void setRefreshRateFPS(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65570, null, f2) == null) {
            refreshRateFPS = f2;
        }
    }

    @UiThread
    private void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, this, byteBuffer, strArr) == null) {
            ensureRunningOnMainThread();
            AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.updateCustomAccessibilityActions(byteBuffer, strArr);
            }
        }
    }

    @UiThread
    private void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, this, byteBuffer, strArr) == null) {
            ensureRunningOnMainThread();
            AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.updateSemantics(byteBuffer, strArr);
            }
        }
    }

    @UiThread
    public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engineLifecycleListener) == null) {
            ensureRunningOnMainThread();
            this.engineLifecycleListeners.add(engineLifecycleListener);
        }
    }

    @UiThread
    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterUiDisplayListener) == null) {
            ensureRunningOnMainThread();
            this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
        }
    }

    @UiThread
    public void attachToNative(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            ensureRunningOnMainThread();
            ensureNotAttachedToNative();
            this.nativePlatformViewId = Long.valueOf(nativeAttach(this, z));
        }
    }

    @UiThread
    public void detachFromNativeAndReleaseResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDestroy(this.nativePlatformViewId.longValue());
            this.nativePlatformViewId = null;
        }
    }

    @UiThread
    public void dispatchEmptyPlatformMessage(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), str, i2);
                return;
            }
            Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
        }
    }

    @UiThread
    public void dispatchPlatformMessage(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, str, byteBuffer, i2, i3) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), str, byteBuffer, i2, i3);
                return;
            }
            Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i3);
        }
    }

    @UiThread
    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, byteBuffer, i2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), byteBuffer, i2);
        }
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, action) == null) {
            dispatchSemanticsAction(i2, action, null);
        }
    }

    @UiThread
    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            return nativeGetBitmap(this.nativePlatformViewId.longValue());
        }
        return (Bitmap) invokeV.objValue;
    }

    @UiThread
    public void invokePlatformMessageEmptyResponseCallback(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), i2);
                return;
            }
            Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
        }
    }

    @UiThread
    public void invokePlatformMessageResponseCallback(int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3)}) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), i2, byteBuffer, i3);
                return;
            }
            Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
        }
    }

    public boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.nativePlatformViewId != null : invokeV.booleanValue;
    }

    @UiThread
    public void markTextureFrameAvailable(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), j);
        }
    }

    @UiThread
    public native boolean nativeGetIsSoftwareRenderingEnabled();

    @UiThread
    @VisibleForTesting
    public void onFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ensureRunningOnMainThread();
            for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
                flutterUiDisplayListener.onFlutterUiDisplayed();
            }
        }
    }

    @UiThread
    @VisibleForTesting
    public void onRenderingStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ensureRunningOnMainThread();
            for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
                flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
        }
    }

    @UiThread
    public void onSurfaceChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSurfaceChanged(this.nativePlatformViewId.longValue(), i2, i3);
        }
    }

    @UiThread
    public void onSurfaceCreated(@NonNull Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surface) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSurfaceCreated(this.nativePlatformViewId.longValue(), surface);
        }
    }

    @UiThread
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            onRenderingStopped();
            nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
        }
    }

    @UiThread
    public void registerTexture(long j, @NonNull SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048597, this, j, surfaceTexture) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeRegisterTexture(this.nativePlatformViewId.longValue(), j, surfaceTexture);
        }
    }

    @UiThread
    public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, engineLifecycleListener) == null) {
            ensureRunningOnMainThread();
            this.engineLifecycleListeners.remove(engineLifecycleListener);
        }
    }

    @UiThread
    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, flutterUiDisplayListener) == null) {
            ensureRunningOnMainThread();
            this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
        }
    }

    @UiThread
    public void runBundleAndSnapshotFromLibrary(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, str2, str3, assetManager) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), str, str2, str3, assetManager);
        }
    }

    @UiThread
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, accessibilityDelegate) == null) {
            ensureRunningOnMainThread();
            this.accessibilityDelegate = accessibilityDelegate;
        }
    }

    @UiThread
    public void setAccessibilityFeatures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), i2);
        }
    }

    @UiThread
    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, platformMessageHandler) == null) {
            ensureRunningOnMainThread();
            this.platformMessageHandler = platformMessageHandler;
        }
    }

    @UiThread
    public void setSemanticsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), z);
        }
    }

    @UiThread
    public void setViewportMetrics(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)}) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), f2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
        }
    }

    @UiThread
    public void unregisterTexture(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeUnregisterTexture(this.nativePlatformViewId.longValue(), j);
        }
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        ByteBuffer byteBuffer;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, action, obj) == null) {
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
    }

    @UiThread
    public void dispatchSemanticsAction(int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4)}) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), i2, i3, byteBuffer, i4);
        }
    }
}
