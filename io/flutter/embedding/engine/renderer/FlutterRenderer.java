package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
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
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
@TargetApi(16)
/* loaded from: classes10.dex */
public class FlutterRenderer implements TextureRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public boolean isDisplayingFlutterUi;
    @NonNull
    public final AtomicLong nextTextureId;
    @Nullable
    public Surface surface;

    /* loaded from: classes10.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long id;
        public SurfaceTexture.OnFrameAvailableListener onFrameListener;
        public boolean released;
        @NonNull
        public final SurfaceTexture surfaceTexture;
        public final /* synthetic */ FlutterRenderer this$0;

        public SurfaceTextureRegistryEntry(FlutterRenderer flutterRenderer, @NonNull long j2, SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterRenderer, Long.valueOf(j2), surfaceTexture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterRenderer;
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener(this) { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SurfaceTextureRegistryEntry this$1;

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
                    this.this$1 = this;
                }

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture2) == null) || this.this$1.released) {
                        return;
                    }
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = this.this$1;
                    surfaceTextureRegistryEntry.this$0.markTextureFrameAvailable(surfaceTextureRegistryEntry.id);
                }
            };
            this.onFrameListener = onFrameAvailableListener;
            this.id = j2;
            this.surfaceTexture = surfaceTexture;
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, new Handler());
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.longValue;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.released) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
            this.surfaceTexture.release();
            this.this$0.unregisterTexture(this.id);
            this.released = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.surfaceTexture : (SurfaceTexture) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class ViewportMetrics {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float devicePixelRatio;
        public int height;
        public int paddingBottom;
        public int paddingLeft;
        public int paddingRight;
        public int paddingTop;
        public int systemGestureInsetBottom;
        public int systemGestureInsetLeft;
        public int systemGestureInsetRight;
        public int systemGestureInsetTop;
        public int viewInsetBottom;
        public int viewInsetLeft;
        public int viewInsetRight;
        public int viewInsetTop;
        public int width;

        public ViewportMetrics() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.devicePixelRatio = 1.0f;
            this.width = 0;
            this.height = 0;
            this.paddingTop = 0;
            this.paddingRight = 0;
            this.paddingBottom = 0;
            this.paddingLeft = 0;
            this.viewInsetTop = 0;
            this.viewInsetRight = 0;
            this.viewInsetBottom = 0;
            this.viewInsetLeft = 0;
            this.systemGestureInsetTop = 0;
            this.systemGestureInsetRight = 0;
            this.systemGestureInsetBottom = 0;
            this.systemGestureInsetLeft = 0;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterJNI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nextTextureId = new AtomicLong(0L);
        this.isDisplayingFlutterUi = false;
        FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterRenderer this$0;

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

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.isDisplayingFlutterUi = true;
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.isDisplayingFlutterUi = false;
                }
            }
        };
        this.flutterUiDisplayListener = flutterUiDisplayListener;
        this.flutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2) == null) {
            this.flutterJNI.markTextureFrameAvailable(j2);
        }
    }

    private void registerTexture(long j2, @NonNull SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(AdIconUtil.AD_TEXT_ID, this, j2, surfaceTexture) == null) {
            this.flutterJNI.registerTexture(j2, surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, this, j2) == null) {
            this.flutterJNI.unregisterTexture(j2);
        }
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterUiDisplayListener) == null) {
            this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
            if (this.isDisplayingFlutterUi) {
                flutterUiDisplayListener.onFlutterUiDisplayed();
            }
        }
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Log.v(TAG, "Creating a SurfaceTexture.");
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            surfaceTexture.detachFromGLContext();
            SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this, this.nextTextureId.getAndIncrement(), surfaceTexture);
            Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
            registerTexture(surfaceTextureRegistryEntry.id(), surfaceTexture);
            return surfaceTextureRegistryEntry;
        }
        return (TextureRegistry.SurfaceTextureEntry) invokeV.objValue;
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, byteBuffer, i2) == null) {
            this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i2);
        }
    }

    public void dispatchSemanticsAction(int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), byteBuffer, Integer.valueOf(i4)}) == null) {
            this.flutterJNI.dispatchSemanticsAction(i2, i3, byteBuffer, i4);
        }
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.flutterJNI.getBitmap() : (Bitmap) invokeV.objValue;
    }

    public boolean isDisplayingFlutterUi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isDisplayingFlutterUi : invokeV.booleanValue;
    }

    public boolean isSoftwareRenderingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.flutterJNI.nativeGetIsSoftwareRenderingEnabled() : invokeV.booleanValue;
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, flutterUiDisplayListener) == null) {
            this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        }
    }

    public void setAccessibilityFeatures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.flutterJNI.setAccessibilityFeatures(i2);
        }
    }

    public void setSemanticsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.flutterJNI.setSemanticsEnabled(z);
        }
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewportMetrics) == null) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.paddingLeft + ", T: " + viewportMetrics.paddingTop + ", R: " + viewportMetrics.paddingRight + ", B: " + viewportMetrics.paddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.viewInsetBottom);
            this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.paddingTop, viewportMetrics.paddingRight, viewportMetrics.paddingBottom, viewportMetrics.paddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft);
        }
    }

    public void startRenderingToSurface(@NonNull Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, surface) == null) {
            if (this.surface != null) {
                stopRenderingToSurface();
            }
            this.surface = surface;
            this.flutterJNI.onSurfaceCreated(surface);
        }
    }

    public void stopRenderingToSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.flutterJNI.onSurfaceDestroyed();
            this.surface = null;
            if (this.isDisplayingFlutterUi) {
                this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
            this.isDisplayingFlutterUi = false;
        }
    }

    public void surfaceChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.flutterJNI.onSurfaceChanged(i2, i3);
        }
    }
}
