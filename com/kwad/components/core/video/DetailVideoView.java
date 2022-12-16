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
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.page.widget.b Kb;
    public b Kc;
    public SurfaceTexture Kd;
    public Surface Ke;
    public a Kf;
    public boolean Kg;
    public boolean Kh;
    public boolean Ki;
    public boolean Kj;
    public PhotoInfo.VideoInfo Kk;
    public final RectF Kl;
    public Matrix mMatrix;

    /* loaded from: classes8.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
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
        this.Kg = false;
        this.Kh = false;
        this.Ki = false;
        this.Kj = false;
        this.Kl = new RectF();
        E(context);
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
        this.Kg = false;
        this.Kh = false;
        this.Ki = false;
        this.Kj = false;
        this.Kl = new RectF();
        E(context);
    }

    private void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            this.mMatrix = new Matrix();
            this.Kb = new com.kwad.components.core.page.widget.b(context);
            addView(this.Kb, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            oZ();
        }
    }

    private void a(View view2, long j, long j2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{view2, Long.valueOf(j), Long.valueOf(j2)}) == null) || view2 == null || j == 0 || j2 == 0 || (view3 = (View) view2.getParent()) == null) {
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
        this.Kb.setLayoutParams(layoutParams);
    }

    private void oZ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.Kb.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.kwad.components.core.video.DetailVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DetailVideoView Km;

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
                    this.Km = this;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i, i2) == null) || this.Km.Kd == surfaceTexture) {
                        return;
                    }
                    this.Km.Kd = surfaceTexture;
                    this.Km.pa();
                    this.Km.Ke = new Surface(surfaceTexture);
                    if (this.Km.Kc != null) {
                        this.Km.Kc.setSurface(this.Km.Ke);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void pa() {
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (surface = this.Ke) == null) {
            return;
        }
        try {
            surface.release();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
        this.Ke = null;
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, adTemplate, i, animatorUpdateListener)) == null) {
            float height = getHeight();
            boolean I = com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, I, height / getWidth(), layoutParams, animatorUpdateListener) { // from class: com.kwad.components.core.video.DetailVideoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DetailVideoView Km;
                public final /* synthetic */ boolean Kn;
                public final /* synthetic */ float Ko;
                public final /* synthetic */ ViewGroup.LayoutParams Kp;
                public final /* synthetic */ ValueAnimator.AnimatorUpdateListener Kq;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(I), Float.valueOf(r8), layoutParams, animatorUpdateListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Km = this;
                    this.Kn = I;
                    this.Ko = r8;
                    this.Kp = layoutParams;
                    this.Kq = animatorUpdateListener;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (this.Kn) {
                            int i2 = (int) (intValue / this.Ko);
                            ViewGroup.LayoutParams layoutParams2 = this.Kp;
                            if (layoutParams2 != null) {
                                layoutParams2.height = intValue;
                                layoutParams2.width = i2;
                                this.Km.setLayoutParams(layoutParams2);
                            }
                            this.Km.adaptVideoSize(i2, intValue);
                        } else {
                            ViewGroup.LayoutParams layoutParams3 = this.Kp;
                            if (layoutParams3 != null) {
                                layoutParams3.height = intValue;
                                layoutParams3.width = -1;
                                this.Km.setLayoutParams(layoutParams3);
                            }
                        }
                        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.Kq;
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

    public final void adaptVideoSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.Kg) {
                com.kwad.sdk.b.kwai.a.e(this.Kb, i, i2);
            } else if (this.Ki) {
                com.kwad.sdk.b.kwai.a.f(this.Kb, i, i2);
            } else if (this.Kh) {
                com.kwad.sdk.b.kwai.a.d(this.Kb, i, i2);
            } else if (this.Kj) {
                a(this.Kb, i, i2);
            } else {
                View view2 = (View) this.Kb.getParent();
                if (view2 == null) {
                    return;
                }
                int width = view2.getWidth();
                int height = view2.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                PhotoInfo.VideoInfo videoInfo = this.Kk;
                if (videoInfo == null || !com.kwad.sdk.core.response.a.f.a(this.mMatrix, width, height, videoInfo)) {
                    ViewGroup.LayoutParams layoutParams = this.Kb.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
                    this.mMatrix.reset();
                    this.Kb.setTransform(this.mMatrix);
                    this.Kb.setLayoutParams(layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.Kb.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    this.Kb.setTransform(this.mMatrix);
                    this.Kb.setLayoutParams(layoutParams2);
                }
                this.Kl.set(this.Kb.getLeft(), this.Kb.getTop(), this.Kb.getRight(), this.Kb.getBottom());
            }
        }
    }

    @Nullable
    public final ValueAnimator ar(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
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
                public final /* synthetic */ DetailVideoView Km;
                public final /* synthetic */ float Ko;
                public final /* synthetic */ ViewGroup.LayoutParams Kp;

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
                    this.Km = this;
                    this.Ko = height;
                    this.Kp = layoutParams;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = this.Kp;
                        layoutParams2.height = (int) (intValue / this.Ko);
                        layoutParams2.width = intValue;
                        this.Km.setLayoutParams(layoutParams2);
                    }
                }
            });
            return ofInt;
        }
        return (ValueAnimator) invokeI.objValue;
    }

    public final void fixWidth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.Ki = z;
        }
    }

    public int getTextureViewGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.kwad.components.core.page.widget.b bVar = this.Kb;
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
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.Kb) {
                a aVar = this.Kf;
                if (aVar != null) {
                    aVar.onClickVideoView();
                    return;
                }
                return;
            }
            a aVar2 = this.Kf;
            if (aVar2 != null) {
                aVar2.onClickRootView();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            pa();
            SurfaceTexture surfaceTexture = this.Kd;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.Kd = null;
            }
        }
    }

    public void setAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.Kh = z;
        }
    }

    public void setClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.Kf = aVar;
            setOnClickListener(this);
        }
    }

    public void setForce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Kg = z;
        }
    }

    public void setHorizontalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.Kj = z;
        }
    }

    public void setMediaPlayer(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.Kc = bVar;
            Surface surface = this.Ke;
            if (surface == null || bVar == null) {
                return;
            }
            bVar.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        com.kwad.components.core.widget.g.b(this, f);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, videoInfo) == null) {
            this.Kk = videoInfo;
        }
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (bVar = this.Kb) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.Kb.requestLayout();
        }
    }
}
