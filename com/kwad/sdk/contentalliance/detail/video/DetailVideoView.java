package com.kwad.sdk.contentalliance.detail.video;

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
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.g;
/* loaded from: classes2.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.page.widget.c a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f57162b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f57163c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f57164d;

    /* renamed from: e  reason: collision with root package name */
    public a f57165e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57166f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57167g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57168h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57169i;

    /* renamed from: j  reason: collision with root package name */
    public Matrix f57170j;

    /* renamed from: k  reason: collision with root package name */
    public PhotoInfo.VideoInfo f57171k;
    public final RectF l;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57166f = false;
        this.f57167g = false;
        this.f57168h = false;
        this.f57169i = false;
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
        this.f57166f = false;
        this.f57167g = false;
        this.f57168h = false;
        this.f57169i = false;
        this.l = new RectF();
        a(context);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) || this.a.f57164d == surfaceTexture) {
                        return;
                    }
                    this.a.f57164d = surfaceTexture;
                    this.a.b();
                    this.a.f57162b = new Surface(surfaceTexture);
                    if (this.a.f57163c != null) {
                        this.a.f57163c.a(this.a.f57162b);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                        return false;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
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
            this.f57170j = new Matrix();
            this.a = new com.kwad.sdk.core.page.widget.c(context);
            addView(this.a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            a();
        }
    }

    private void a(View view, long j2, long j3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{view, Long.valueOf(j2), Long.valueOf(j3)}) == null) || view == null || j2 == 0 || j3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f2 = ((float) j2) / ((float) j3);
        float f3 = height * f2;
        float f4 = width;
        if (f3 > f4) {
            height = (int) (f4 / f2);
        } else {
            width = (int) f3;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (surface = this.f57162b) == null) {
            return;
        }
        try {
            surface.release();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f57162b = null;
    }

    public void a(int i2) {
        com.kwad.sdk.core.page.widget.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (cVar = this.a) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = cVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
            this.a.requestLayout();
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f57166f) {
                com.kwad.sdk.a.kwai.a.b(this.a, i2, i3);
            } else if (this.f57168h) {
                com.kwad.sdk.a.kwai.a.c(this.a, i2, i3);
            } else if (this.f57167g) {
                com.kwad.sdk.a.kwai.a.a(this.a, i2, i3);
            } else if (this.f57169i) {
                a(this.a, i2, i3);
            } else {
                View view = (View) this.a.getParent();
                if (view == null) {
                    return;
                }
                int width = view.getWidth();
                int height = view.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                PhotoInfo.VideoInfo videoInfo = this.f57171k;
                if (videoInfo == null || !bb.a(this.f57170j, width, height, videoInfo)) {
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                    this.f57170j.reset();
                    this.a.setTransform(this.f57170j);
                    this.a.setLayoutParams(layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.a.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    this.a.setTransform(this.f57170j);
                    this.a.setLayoutParams(layoutParams2);
                }
                this.l.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f57168h = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.a) {
                a aVar = this.f57165e;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            a aVar2 = this.f57165e;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            b();
            SurfaceTexture surfaceTexture = this.f57164d;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f57164d = null;
            }
        }
    }

    public void setAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f57167g = z;
        }
    }

    public void setClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f57165e = aVar;
            setOnClickListener(this);
        }
    }

    public void setForce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57166f = z;
        }
    }

    public void setHorizontalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f57169i = z;
        }
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f57163c = aVar;
            Surface surface = this.f57162b;
            if (surface == null || aVar == null) {
                return;
            }
            aVar.a(surface);
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048586, this, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        g.a(this, f2);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, videoInfo) == null) {
            this.f57171k = videoInfo;
        }
    }
}
