package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes5.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.page.widget.b a;
    public Surface b;
    public b c;
    public SurfaceTexture d;
    public a e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Matrix j;
    public PhotoInfo.VideoInfo k;
    public final RectF l;

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.l = new RectF();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.l = new RectF();
        a(context);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.kwad.components.core.video.DetailVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DetailVideoView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i, i2) == null) || this.a.d == surfaceTexture) {
                        return;
                    }
                    this.a.d = surfaceTexture;
                    this.a.b();
                    this.a.b = new Surface(surfaceTexture);
                    if (this.a.c != null) {
                        this.a.c.a(this.a.b);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                        return false;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i, i2) == null) {
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, surfaceTexture) == null) {
                    }
                }
            });
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            this.j = new Matrix();
            this.a = new com.kwad.components.core.page.widget.b(context);
            addView(this.a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            a();
        }
    }

    private void a(View view2, long j, long j2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{view2, Long.valueOf(j), Long.valueOf(j2)}) == null) || view2 == null || j == 0 || j2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view2.getLayoutParams();
        float f = ((float) j) / ((float) j2);
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (surface = this.b) == null) {
            return;
        }
        try {
            surface.release();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
        }
        this.b = null;
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, adTemplate, i, animatorUpdateListener)) == null) {
            float height = getHeight();
            boolean j = com.kwad.sdk.core.response.a.a.j(com.kwad.sdk.core.response.a.d.i(adTemplate));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, j, height / getWidth(), layoutParams, animatorUpdateListener) { // from class: com.kwad.components.core.video.DetailVideoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ float b;
                public final /* synthetic */ ViewGroup.LayoutParams c;
                public final /* synthetic */ ValueAnimator.AnimatorUpdateListener d;
                public final /* synthetic */ DetailVideoView e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(j), Float.valueOf(r8), layoutParams, animatorUpdateListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = j;
                    this.b = r8;
                    this.c = layoutParams;
                    this.d = animatorUpdateListener;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (this.a) {
                            int i2 = (int) (intValue / this.b);
                            ViewGroup.LayoutParams layoutParams2 = this.c;
                            if (layoutParams2 != null) {
                                layoutParams2.height = intValue;
                                layoutParams2.width = i2;
                                this.e.setLayoutParams(layoutParams2);
                            }
                            this.e.a(i2, intValue);
                        } else {
                            ViewGroup.LayoutParams layoutParams3 = this.c;
                            if (layoutParams3 != null) {
                                layoutParams3.height = intValue;
                                layoutParams3.width = -1;
                                this.e.setLayoutParams(layoutParams3);
                            }
                        }
                        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.d;
                        if (animatorUpdateListener2 != null) {
                            animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                        }
                    }
                }
            });
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ofInt.setDuration(500L);
            ofInt.setInterpolator(create);
            return ofInt;
        }
        return (ValueAnimator) invokeLIL.objValue;
    }

    public final void a(int i) {
        com.kwad.components.core.page.widget.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (bVar = this.a) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.a.requestLayout();
        }
    }

    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.f) {
                com.kwad.sdk.b.kwai.a.b(this.a, i, i2);
            } else if (this.h) {
                com.kwad.sdk.b.kwai.a.c(this.a, i, i2);
            } else if (this.g) {
                com.kwad.sdk.b.kwai.a.a(this.a, i, i2);
            } else if (this.i) {
                a(this.a, i, i2);
            } else {
                View view2 = (View) this.a.getParent();
                if (view2 == null) {
                    return;
                }
                int width = view2.getWidth();
                int height = view2.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                PhotoInfo.VideoInfo videoInfo = this.k;
                if (videoInfo == null || !com.kwad.sdk.core.response.a.f.a(this.j, width, height, videoInfo)) {
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
                    this.j.reset();
                    this.a.setTransform(this.j);
                    this.a.setLayoutParams(layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.a.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    this.a.setTransform(this.j);
                    this.a.setLayoutParams(layoutParams2);
                }
                this.l.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h = true;
        }
    }

    @Nullable
    public final ValueAnimator b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            float width = getWidth();
            float height = width / getHeight();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt((int) width, i);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, height, layoutParams) { // from class: com.kwad.components.core.video.DetailVideoView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float a;
                public final /* synthetic */ ViewGroup.LayoutParams b;
                public final /* synthetic */ DetailVideoView c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(height), layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = height;
                    this.b = layoutParams;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = this.b;
                        layoutParams2.height = (int) (intValue / this.a);
                        layoutParams2.width = intValue;
                        this.c.setLayoutParams(layoutParams2);
                    }
                }
            });
            return ofInt;
        }
        return (ValueAnimator) invokeI.objValue;
    }

    public int getTextureViewGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.components.core.page.widget.b bVar = this.a;
            if (bVar == null) {
                return 17;
            }
            ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                return ((FrameLayout.LayoutParams) layoutParams).gravity;
            }
            return 17;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            b();
            SurfaceTexture surfaceTexture = this.d;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.d = null;
            }
        }
    }

    public void setAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = z;
        }
    }

    public void setClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.e = aVar;
            setOnClickListener(this);
        }
    }

    public void setForce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f = z;
        }
    }

    public void setHorizontalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
    }

    public void setMediaPlayer(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.c = bVar;
            Surface surface = this.b;
            if (surface == null || bVar == null) {
                return;
            }
            bVar.a(surface);
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        com.kwad.components.core.widget.g.a(this, f);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoInfo) == null) {
            this.k = videoInfo;
        }
    }
}
