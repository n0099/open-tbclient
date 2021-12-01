package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.Preconditions;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
@Keep
/* loaded from: classes3.dex */
public class FlutterJNI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterJNI";
    @Nullable
    public static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    public static boolean initCalled;
    public static boolean loadLibraryCalled;
    @Nullable
    public static String observatoryUri;
    public static boolean prefetchDefaultFontManagerCalled;
    public static float refreshRateFPS;
    public static boolean setRefreshRateFPSCalled;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AccessibilityDelegate accessibilityDelegate;
    @Nullable
    public DeferredComponentManager deferredComponentManager;
    @NonNull
    public final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners;
    @NonNull
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    @Nullable
    public LocalizationPlugin localizationPlugin;
    @NonNull
    public final Looper mainLooper;
    @Nullable
    public Long nativeShellHolderId;
    @Nullable
    public PlatformMessageHandler platformMessageHandler;
    @Nullable
    public PlatformViewsController platformViewsController;

    /* loaded from: classes3.dex */
    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);

        void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr);
    }

    /* loaded from: classes3.dex */
    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j2);
    }

    /* loaded from: classes3.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public FlutterJNI provideFlutterJNI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new FlutterJNI() : (FlutterJNI) invokeV.objValue;
        }
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

    public static /* synthetic */ void a(long j2, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j2, size.getWidth(), size.getHeight());
    }

    public static void asyncWaitForVsync(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j2) == null) {
            AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
            if (asyncWaitForVsyncDelegate2 != null) {
                asyncWaitForVsyncDelegate2.asyncWaitForVsync(j2);
                return;
            }
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
    }

    @Nullable
    @VisibleForTesting
    public static Bitmap decodeImage(@NonNull ByteBuffer byteBuffer, final long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, j2)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: g.a.a.b.a
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                        public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, imageDecoder, imageInfo, source) == null) {
                                FlutterJNI.a(j2, imageDecoder, imageInfo, source);
                            }
                        }
                    });
                } catch (IOException e2) {
                    Log.e(TAG, "Failed to decode image", e2);
                }
            }
            return null;
        }
        return (Bitmap) invokeLJ.objValue;
    }

    private void ensureAttachedToNative() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Nullable
    public static String getObservatoryUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? observatoryUri : (String) invokeV.objValue;
    }

    private void handlePlatformMessageResponse(int i2, ByteBuffer byteBuffer) {
        PlatformMessageHandler platformMessageHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65545, this, i2, byteBuffer) == null) || (platformMessageHandler = this.platformMessageHandler) == null) {
            return;
        }
        platformMessageHandler.handlePlatformMessageResponse(i2, byteBuffer);
    }

    private native long nativeAttach(@NonNull FlutterJNI flutterJNI, boolean z);

    private native void nativeDeferredComponentInstallFailure(int i2, @NonNull String str, boolean z);

    private native void nativeDestroy(long j2);

    private native void nativeDispatchEmptyPlatformMessage(long j2, @NonNull String str, int i2);

    private native void nativeDispatchPlatformMessage(long j2, @NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeDispatchPointerDataPacket(long j2, @NonNull ByteBuffer byteBuffer, int i2);

    private native void nativeDispatchSemanticsAction(long j2, int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4);

    private native Bitmap nativeGetBitmap(long j2);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j2, int i2, int i3);

    @Deprecated
    public static native void nativeInit(@NonNull Context context, @NonNull String[] strArr, @Nullable String str, @NonNull String str2, @NonNull String str3, long j2);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j2, int i2);

    private native void nativeInvokePlatformMessageResponseCallback(long j2, int i2, @Nullable ByteBuffer byteBuffer, int i3);

    private native void nativeLoadDartDeferredLibrary(long j2, int i2, @NonNull String[] strArr);

    @NonNull
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j2);

    private native void nativeMarkTextureFrameAvailable(long j2, long j3);

    private native void nativeNotifyLowMemoryWarning(long j2);

    public static native void nativeOnVsync(long j2, long j3, long j4);

    @Deprecated
    public static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j2, long j3, @NonNull SurfaceTextureWrapper surfaceTextureWrapper);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j2, @NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager);

    private native void nativeSetAccessibilityFeatures(long j2, int i2);

    private native void nativeSetSemanticsEnabled(long j2, boolean z);

    private native void nativeSetViewportMetrics(long j2, float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    private native FlutterJNI nativeSpawn(long j2, @Nullable String str, @Nullable String str2);

    private native void nativeSurfaceChanged(long j2, int i2, int i3);

    private native void nativeSurfaceCreated(long j2, @NonNull Surface surface);

    private native void nativeSurfaceDestroyed(long j2);

    private native void nativeSurfaceWindowChanged(long j2, @NonNull Surface surface);

    private native void nativeUnregisterTexture(long j2, long j3);

    private native void nativeUpdateJavaAssetManager(long j2, @NonNull AssetManager assetManager, @NonNull String str);

    private void onPreEngineRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            for (FlutterEngine.EngineLifecycleListener engineLifecycleListener : this.engineLifecycleListeners) {
                engineLifecycleListener.onPreEngineRestart();
            }
        }
    }

    public static void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, asyncWaitForVsyncDelegate2) == null) {
            asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
        }
    }

    public static void setRefreshRateFPS(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65579, null, f2) == null) {
            if (setRefreshRateFPSCalled) {
                Log.w(TAG, "FlutterJNI.setRefreshRateFPS called more than once");
            }
            refreshRateFPS = f2;
            setRefreshRateFPSCalled = true;
        }
    }

    @UiThread
    private void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65580, this, byteBuffer, strArr) == null) {
            ensureRunningOnMainThread();
            AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.updateCustomAccessibilityActions(byteBuffer, strArr);
            }
        }
    }

    @UiThread
    private void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65581, this, byteBuffer, strArr, byteBufferArr) == null) {
            ensureRunningOnMainThread();
            AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.updateSemantics(byteBuffer, strArr, byteBufferArr);
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
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this, z));
        }
    }

    @VisibleForTesting
    public String[] computePlatformResolvedLocale(@NonNull String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
            if (this.localizationPlugin == null) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2 += 3) {
                String str = strArr[i2 + 0];
                String str2 = strArr[i2 + 1];
                String str3 = strArr[i2 + 2];
                if (Build.VERSION.SDK_INT >= 21) {
                    Locale.Builder builder = new Locale.Builder();
                    if (!str.isEmpty()) {
                        builder.setLanguage(str);
                    }
                    if (!str2.isEmpty()) {
                        builder.setRegion(str2);
                    }
                    if (!str3.isEmpty()) {
                        builder.setScript(str3);
                    }
                    arrayList.add(builder.build());
                } else {
                    arrayList.add(new Locale(str, str2));
                }
            }
            Locale resolveNativeLocale = this.localizationPlugin.resolveNativeLocale(arrayList);
            if (resolveNativeLocale == null) {
                return new String[0];
            }
            String[] strArr2 = new String[3];
            strArr2[0] = resolveNativeLocale.getLanguage();
            strArr2[1] = resolveNativeLocale.getCountry();
            if (Build.VERSION.SDK_INT >= 21) {
                strArr2[2] = resolveNativeLocale.getScript();
            } else {
                strArr2[2] = "";
            }
            return strArr2;
        }
        return (String[]) invokeL.objValue;
    }

    @UiThread
    public FlutterOverlaySurface createOverlaySurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                return platformViewsController.createOverlaySurface();
            }
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        return (FlutterOverlaySurface) invokeV.objValue;
    }

    @UiThread
    public void deferredComponentInstallFailure(int i2, @NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            ensureRunningOnMainThread();
            nativeDeferredComponentInstallFailure(i2, str, z);
        }
    }

    @UiThread
    public void destroyOverlaySurfaces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                platformViewsController.destroyOverlaySurfaces();
                return;
            }
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
    }

    @UiThread
    public void detachFromNativeAndReleaseResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        }
    }

    @UiThread
    public void dispatchEmptyPlatformMessage(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i2);
                return;
            }
            Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
        }
    }

    @UiThread
    public void dispatchPlatformMessage(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048585, this, str, byteBuffer, i2, i3) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i2, i3);
                return;
            }
            Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i3);
        }
    }

    @UiThread
    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, byteBuffer, i2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i2);
        }
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, action) == null) {
            dispatchSemanticsAction(i2, action, null);
        }
    }

    @UiThread
    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            return nativeGetBitmap(this.nativeShellHolderId.longValue());
        }
        return (Bitmap) invokeV.objValue;
    }

    @UiThread
    public boolean getIsSoftwareRenderingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? nativeGetIsSoftwareRenderingEnabled() : invokeV.booleanValue;
    }

    @VisibleForTesting
    public void handlePlatformMessage(@NonNull String str, ByteBuffer byteBuffer, int i2) {
        PlatformMessageHandler platformMessageHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, str, byteBuffer, i2) == null) || (platformMessageHandler = this.platformMessageHandler) == null) {
            return;
        }
        platformMessageHandler.handleMessageFromDart(str, byteBuffer, i2);
    }

    public void init(@NonNull Context context, @NonNull String[] strArr, @Nullable String str, @NonNull String str2, @NonNull String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, strArr, str, str2, str3, Long.valueOf(j2)}) == null) {
            if (initCalled) {
                Log.w(TAG, "FlutterJNI.init called more than once");
            }
            nativeInit(context, strArr, str, str2, str3, j2);
            initCalled = true;
        }
    }

    @UiThread
    public void invokePlatformMessageEmptyResponseCallback(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            ensureRunningOnMainThread();
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i2);
                return;
            }
            Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
        }
    }

    @UiThread
    public void invokePlatformMessageResponseCallback(int i2, @NonNull ByteBuffer byteBuffer, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3)}) == null) {
            ensureRunningOnMainThread();
            if (byteBuffer.isDirect()) {
                if (isAttached()) {
                    nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i2, byteBuffer, i3);
                    return;
                }
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
                return;
            }
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
    }

    public boolean isAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.nativeShellHolderId != null : invokeV.booleanValue;
    }

    @UiThread
    public void loadDartDeferredLibrary(int i2, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, strArr) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i2, strArr);
        }
    }

    public void loadLibrary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (loadLibraryCalled) {
                Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
            }
            System.loadLibrary("flutter");
            loadLibraryCalled = true;
        }
    }

    @UiThread
    public void markTextureFrameAvailable(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j2);
        }
    }

    public native boolean nativeFlutterTextUtilsIsEmoji(int i2);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int i2);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i2);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i2);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int i2);

    @UiThread
    public void notifyLowMemoryWarning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
        }
    }

    @UiThread
    public void onBeginFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                platformViewsController.onBeginFrame();
                return;
            }
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
    }

    @UiThread
    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                platformViewsController.onDisplayOverlaySurface(i2, i3, i4, i5, i6);
                return;
            }
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
    }

    @UiThread
    public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), flutterMutatorsStack}) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                platformViewsController.onDisplayPlatformView(i2, i3, i4, i5, i6, i7, i8, flutterMutatorsStack);
                return;
            }
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
    }

    @UiThread
    public void onEndFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            ensureRunningOnMainThread();
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null) {
                platformViewsController.onEndFrame();
                return;
            }
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
    }

    @UiThread
    @VisibleForTesting
    public void onFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            ensureRunningOnMainThread();
            for (FlutterUiDisplayListener flutterUiDisplayListener : this.flutterUiDisplayListeners) {
                flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
        }
    }

    @UiThread
    public void onSurfaceChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i2, i3);
        }
    }

    @UiThread
    public void onSurfaceCreated(@NonNull Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, surface) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
        }
    }

    @UiThread
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            onRenderingStopped();
            nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
        }
    }

    @UiThread
    public void onSurfaceWindowChanged(@NonNull Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, surface) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
        }
    }

    @VisibleForTesting
    public long performNativeAttach(@NonNull FlutterJNI flutterJNI, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048616, this, flutterJNI, z)) == null) ? nativeAttach(flutterJNI, z) : invokeLZ.longValue;
    }

    public void prefetchDefaultFontManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (prefetchDefaultFontManagerCalled) {
                Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
            }
            nativePrefetchDefaultFontManager();
            prefetchDefaultFontManagerCalled = true;
        }
    }

    @UiThread
    public void registerTexture(long j2, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048618, this, j2, surfaceTextureWrapper) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeRegisterTexture(this.nativeShellHolderId.longValue(), j2, surfaceTextureWrapper);
        }
    }

    @UiThread
    public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, engineLifecycleListener) == null) {
            ensureRunningOnMainThread();
            this.engineLifecycleListeners.remove(engineLifecycleListener);
        }
    }

    @UiThread
    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, flutterUiDisplayListener) == null) {
            ensureRunningOnMainThread();
            this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
        }
    }

    @UiThread
    public void requestDartDeferredLibrary(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            DeferredComponentManager deferredComponentManager = this.deferredComponentManager;
            if (deferredComponentManager != null) {
                deferredComponentManager.installDeferredComponent(i2, null);
            } else {
                Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
            }
        }
    }

    @UiThread
    public void runBundleAndSnapshotFromLibrary(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048622, this, str, str2, str3, assetManager) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager);
        }
    }

    @UiThread
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, accessibilityDelegate) == null) {
            ensureRunningOnMainThread();
            this.accessibilityDelegate = accessibilityDelegate;
        }
    }

    @UiThread
    public void setAccessibilityFeatures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i2);
        }
    }

    @UiThread
    public void setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, deferredComponentManager) == null) {
            ensureRunningOnMainThread();
            this.deferredComponentManager = deferredComponentManager;
            if (deferredComponentManager != null) {
                deferredComponentManager.setJNI(this);
            }
        }
    }

    @UiThread
    public void setLocalizationPlugin(@Nullable LocalizationPlugin localizationPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, localizationPlugin) == null) {
            ensureRunningOnMainThread();
            this.localizationPlugin = localizationPlugin;
        }
    }

    @UiThread
    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, platformMessageHandler) == null) {
            ensureRunningOnMainThread();
            this.platformMessageHandler = platformMessageHandler;
        }
    }

    @UiThread
    public void setPlatformViewsController(@NonNull PlatformViewsController platformViewsController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, platformViewsController) == null) {
            ensureRunningOnMainThread();
            this.platformViewsController = platformViewsController;
        }
    }

    @UiThread
    public void setSemanticsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z);
        }
    }

    @UiThread
    public void setViewportMetrics(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16)}) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
        }
    }

    @NonNull
    @UiThread
    public FlutterJNI spawn(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, str, str2)) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2);
            Long l = nativeSpawn.nativeShellHolderId;
            Preconditions.checkState((l == null || l.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
            return nativeSpawn;
        }
        return (FlutterJNI) invokeLL.objValue;
    }

    @UiThread
    public void unregisterTexture(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j2) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j2);
        }
    }

    @UiThread
    public void updateJavaAssetManager(@NonNull AssetManager assetManager, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, assetManager, str) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
        }
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        ByteBuffer byteBuffer;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, action, obj) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4)}) == null) {
            ensureRunningOnMainThread();
            ensureAttachedToNative();
            nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i2, i3, byteBuffer, i4);
        }
    }
}
