package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f59933b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f59934c;

    /* renamed from: d  reason: collision with root package name */
    public a f59935d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59936e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f59937f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f59938g;

    /* renamed from: h  reason: collision with root package name */
    public b f59939h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f59940i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f59941j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.reward.a f59942k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameLandscapeHorizontal(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }

    private void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, view, z) == null) {
            int i2 = z ? 1 : 153;
            if (com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
                this.f59942k.a(getContext(), i2, 1);
            } else {
                com.kwad.sdk.core.download.a.a.a(new a.C2076a(view.getContext()).a(this.f59936e).a(this.f59939h).a(view == this.f59940i).a(view == this.f59940i ? 1 : 2).a(new a.b(this, z) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TailFrameLandscapeHorizontal f59944b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59944b = this;
                        this.a = z;
                    }

                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f59944b.f59935d == null) {
                            return;
                        }
                        this.f59944b.f59935d.a(this.a);
                    }
                }));
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
            this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
            this.f59941j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.B(this.f59937f) && !com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
                TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f59934c = tailFrameBarH5Landscape;
                tailFrameBarH5Landscape.setModel(this.f59936e);
                this.f59934c.setVisibility(0);
                return;
            }
            TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
            this.f59933b = tailFrameBarAppLandscape;
            tailFrameBarAppLandscape.setModel(this.f59936e);
            this.f59933b.setVisibility(0);
            this.f59940i = this.f59933b.getTextProgressBar();
            if (!com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
                d();
            }
            new f(this.f59940i, this);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f59939h = new b(this.f59936e, this.f59938g, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeHorizontal f59943b;

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
                    this.f59943b = this;
                }

                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        super.a(i2);
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.A(this.f59943b.f59937f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.a(this.f59943b.f59936e), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.A(this.f59943b.f59937f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.m(this.f59943b.f59937f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f59943b.f59933b.a(com.kwad.sdk.core.response.a.d.j(this.f59943b.f59936e));
                        this.f59943b.f59940i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setOnClickListener(null);
            this.f59939h = null;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f59933b;
            if (tailFrameBarAppLandscape != null) {
                tailFrameBarAppLandscape.b();
                this.f59933b.setVisibility(8);
            }
            TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f59934c;
            if (tailFrameBarH5Landscape != null) {
                tailFrameBarH5Landscape.a();
                this.f59934c.setVisibility(8);
            }
            e();
        }
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, aVar) == null) {
            this.f59936e = adTemplate;
            this.f59937f = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59938g = jSONObject;
            this.f59935d = aVar;
            this.f59941j.a(this.f59936e);
            KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f59937f), this.f59936e);
            c();
            setClickable(true);
            new f(this, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.f59936e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f59942k = aVar;
        }
    }
}
