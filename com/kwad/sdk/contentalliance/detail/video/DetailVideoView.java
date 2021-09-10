package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.av;
/* loaded from: classes10.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.page.widget.c f71388a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f71389b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f71390c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f71391d;

    /* renamed from: e  reason: collision with root package name */
    public a f71392e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71393f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71394g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71395h;

    /* renamed from: i  reason: collision with root package name */
    public Matrix f71396i;

    /* renamed from: j  reason: collision with root package name */
    public PhotoInfo.VideoInfo f71397j;
    public final RectF k;

    /* loaded from: classes10.dex */
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
        this.f71393f = false;
        this.f71394g = false;
        this.f71395h = false;
        this.k = new RectF();
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
        this.f71393f = false;
        this.f71394g = false;
        this.f71395h = false;
        this.k = new RectF();
        a(context);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f71388a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DetailVideoView f71398a;

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
                    this.f71398a = this;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) || this.f71398a.f71391d == surfaceTexture) {
                        return;
                    }
                    this.f71398a.f71391d = surfaceTexture;
                    this.f71398a.b();
                    this.f71398a.f71389b = new Surface(surfaceTexture);
                    if (this.f71398a.f71390c != null) {
                        this.f71398a.f71390c.a(this.f71398a.f71389b);
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f71396i = new Matrix();
            this.f71388a = new com.kwad.sdk.core.page.widget.c(context);
            addView(this.f71388a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            a();
        }
    }

    private void a(View view, long j2, long j3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{view, Long.valueOf(j2), Long.valueOf(j3)}) == null) || view == null || j2 == 0 || j3 == 0 || (view2 = (View) view.getParent()) == null) {
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
        this.f71388a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (surface = this.f71389b) == null) {
            return;
        }
        try {
            surface.release();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f71389b = null;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (this.f71394g) {
                av.b(this.f71388a, i2, i3);
            } else if (this.f71393f) {
                av.a(this.f71388a, i2, i3);
            } else if (this.f71395h) {
                a(this.f71388a, i2, i3);
            } else {
                View view = (View) this.f71388a.getParent();
                if (view == null) {
                    return;
                }
                int width = view.getWidth();
                int height = view.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                PhotoInfo.VideoInfo videoInfo = this.f71397j;
                if (videoInfo == null || !av.a(this.f71396i, width, height, videoInfo)) {
                    ViewGroup.LayoutParams layoutParams = this.f71388a.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                    this.f71396i.reset();
                    this.f71388a.setTransform(this.f71396i);
                    this.f71388a.setLayoutParams(layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.f71388a.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    this.f71388a.setTransform(this.f71396i);
                    this.f71388a.setLayoutParams(layoutParams2);
                }
                this.k.set(this.f71388a.getLeft(), this.f71388a.getTop(), this.f71388a.getRight(), this.f71388a.getBottom());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (view == this.f71388a) {
                a aVar = this.f71392e;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            a aVar2 = this.f71392e;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            b();
            SurfaceTexture surfaceTexture = this.f71391d;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f71391d = null;
            }
        }
    }

    public void setAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f71393f = z;
        }
    }

    public void setClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f71392e = aVar;
            setOnClickListener(this);
        }
    }

    public void setHorizontalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f71395h = z;
        }
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f71390c = aVar;
            Surface surface = this.f71389b;
            if (surface == null || aVar == null) {
                return;
            }
            aVar.a(surface);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoInfo) == null) {
            this.f71397j = videoInfo;
        }
    }
}
