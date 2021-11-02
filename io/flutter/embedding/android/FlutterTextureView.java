package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
/* loaded from: classes3.dex */
public class FlutterTextureView extends TextureView implements RenderSurface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterTextureView";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public FlutterRenderer flutterRenderer;
    public boolean isAttachedToFlutterRenderer;
    public boolean isSurfaceAvailableForRendering;
    @Nullable
    public Surface renderSurface;
    public final TextureView.SurfaceTextureListener surfaceTextureListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterTextureView(@NonNull Context context) {
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i2, i3) == null) {
            if (this.flutterRenderer != null) {
                Log.v(TAG, "Notifying FlutterRenderer that Android surface size has changed to " + i2 + " x " + i3);
                this.flutterRenderer.surfaceChanged(i2, i3);
                return;
            }
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectSurfaceToRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.flutterRenderer != null && getSurfaceTexture() != null) {
                Surface surface = new Surface(getSurfaceTexture());
                this.renderSurface = surface;
                this.flutterRenderer.startRenderingToSurface(surface);
                return;
            }
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectSurfaceFromRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            FlutterRenderer flutterRenderer = this.flutterRenderer;
            if (flutterRenderer != null) {
                flutterRenderer.stopRenderingToSurface();
                this.renderSurface.release();
                this.renderSurface = null;
                return;
            }
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setSurfaceTextureListener(this.surfaceTextureListener);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterRenderer) == null) {
            Log.v(TAG, "Attaching to FlutterRenderer.");
            if (this.flutterRenderer != null) {
                Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
                this.flutterRenderer.stopRenderingToSurface();
            }
            this.flutterRenderer = flutterRenderer;
            this.isAttachedToFlutterRenderer = true;
            if (this.isSurfaceAvailableForRendering) {
                Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
                connectSurfaceToRenderer();
            }
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.flutterRenderer != null) {
                if (getWindowToken() != null) {
                    Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                    disconnectSurfaceFromRenderer();
                }
                this.flutterRenderer = null;
                this.isAttachedToFlutterRenderer = false;
                return;
            }
            Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterRenderer : (FlutterRenderer) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterTextureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener(this) { // from class: io.flutter.embedding.android.FlutterTextureView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterTextureView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i4, i5) == null) {
                    Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureAvailable()");
                    this.this$0.isSurfaceAvailableForRendering = true;
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.connectSurfaceToRenderer();
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                    Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                    this.this$0.isSurfaceAvailableForRendering = false;
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.disconnectSurfaceFromRenderer();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i4, i5) == null) {
                    Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.changeSurfaceSize(i4, i5);
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, surfaceTexture) == null) {
                }
            }
        };
        init();
    }
}
