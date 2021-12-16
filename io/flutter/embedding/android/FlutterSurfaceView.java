package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
/* loaded from: classes4.dex */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterSurfaceView";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public FlutterRenderer flutterRenderer;
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    public boolean isAttachedToFlutterRenderer;
    public boolean isSurfaceAvailableForRendering;
    public final boolean renderTransparently;
    public final SurfaceHolder.Callback surfaceCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterSurfaceView(@NonNull Context context) {
        this(context, null, false);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.flutterRenderer != null && getHolder() != null) {
                this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
                return;
            }
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectSurfaceFromRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            FlutterRenderer flutterRenderer = this.flutterRenderer;
            if (flutterRenderer != null) {
                flutterRenderer.stopRenderingToSurface();
                return;
            }
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.renderTransparently) {
                getHolder().setFormat(-2);
                setZOrderOnTop(true);
            }
            getHolder().addCallback(this.surfaceCallback);
            setAlpha(0.0f);
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
                this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            }
            this.flutterRenderer = flutterRenderer;
            this.isAttachedToFlutterRenderer = true;
            flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
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
                setAlpha(0.0f);
                this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
                this.flutterRenderer = null;
                this.isAttachedToFlutterRenderer = false;
                return;
            }
            Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, region)) == null) {
            if (getAlpha() < 1.0f) {
                return false;
            }
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.flutterRenderer : (FlutterRenderer) invokeV.objValue;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.flutterRenderer != null) {
                this.flutterRenderer = null;
                this.isAttachedToFlutterRenderer = false;
                return;
            }
            Log.w(TAG, "pause() invoked when no FlutterRenderer was attached.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterSurfaceView(@NonNull Context context, boolean z) {
        this(context, null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterSurfaceView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, false);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceCallback = new SurfaceHolder.Callback(this) { // from class: io.flutter.embedding.android.FlutterSurfaceView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSurfaceView this$0;

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

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i4, i5, i6) == null) {
                    Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.changeSurfaceSize(i5, i6);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                    Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
                    this.this$0.isSurfaceAvailableForRendering = true;
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.connectSurfaceToRenderer();
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                    Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
                    this.this$0.isSurfaceAvailableForRendering = false;
                    if (this.this$0.isAttachedToFlutterRenderer) {
                        this.this$0.disconnectSurfaceFromRenderer();
                    }
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener(this) { // from class: io.flutter.embedding.android.FlutterSurfaceView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSurfaceView this$0;

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

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Log.v(FlutterSurfaceView.TAG, "onFlutterUiDisplayed()");
                    this.this$0.setAlpha(1.0f);
                    if (this.this$0.flutterRenderer != null) {
                        this.this$0.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
                    }
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.renderTransparently = z;
        init();
    }
}
