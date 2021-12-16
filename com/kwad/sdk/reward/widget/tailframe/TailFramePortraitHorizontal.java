package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f59957b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f59958c;

    /* renamed from: d  reason: collision with root package name */
    public a f59959d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59960e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f59961f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f59962g;

    /* renamed from: h  reason: collision with root package name */
    public b f59963h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f59964i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f59965j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.reward.a f59966k;
    public View l;
    public View m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFramePortraitHorizontal(Context context) {
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
    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            if (com.kwad.sdk.core.response.a.d.v(this.f59960e)) {
                this.f59966k.a(getContext(), z ? 1 : 153, 1);
            } else {
                com.kwad.sdk.core.download.a.a.a(new a.C2076a(view.getContext()).a(this.f59960e).a(this.f59963h).a(view == this.f59964i).a(view == this.f59964i ? 1 : 2).a(new a.b(this, z) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TailFramePortraitHorizontal f59968b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59968b = this;
                        this.a = z;
                    }

                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f59968b.f59959d == null) {
                            return;
                        }
                        this.f59968b.f59959d.a(this.a);
                    }
                }));
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.l = LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
            this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
            this.f59965j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
            this.m = findViewById(R.id.video_cover);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f59961f);
            int i2 = J.width;
            int i3 = J.height;
            int c2 = com.kwad.sdk.a.kwai.a.c(getContext());
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = (int) (c2 * (i3 / i2));
            KSImageLoader.loadImage(this.a, J.coverUrl, this.f59960e);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.B(this.f59961f) && !com.kwad.sdk.core.response.a.d.v(this.f59960e)) {
                TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f59958c = tailFrameBarH5PortraitHorizontal;
                tailFrameBarH5PortraitHorizontal.setModel(this.f59960e);
                this.f59958c.setVisibility(0);
                return;
            }
            TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
            this.f59957b = tailFrameBarAppPortraitHorizontal;
            tailFrameBarAppPortraitHorizontal.a(this.f59960e);
            this.f59957b.setVisibility(0);
            this.f59964i = this.f59957b.getTextProgressBar();
            if (!com.kwad.sdk.core.response.a.d.v(this.f59960e)) {
                e();
            }
            new f(this.f59964i, this);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f59963h = new b(this.f59960e, this.f59962g, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFramePortraitHorizontal f59967b;

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
                    this.f59967b = this;
                }

                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.A(this.f59967b.f59961f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.a(this.f59967b.f59960e), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.A(this.f59967b.f59961f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.m(this.f59967b.f59961f), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f59967b.f59957b.a(this.f59967b.f59961f);
                        this.f59967b.f59964i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            setOnClickListener(null);
            this.f59963h = null;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f59957b;
            if (tailFrameBarAppPortraitHorizontal != null) {
                tailFrameBarAppPortraitHorizontal.b();
                this.f59957b.setVisibility(8);
            }
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f59958c;
            if (tailFrameBarH5PortraitHorizontal != null) {
                tailFrameBarH5PortraitHorizontal.a();
                this.f59958c.setVisibility(8);
            }
            f();
        }
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, aVar) == null) {
            this.f59960e = adTemplate;
            if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
                this.m.setVisibility(8);
                this.f59965j.setVisibility(8);
                this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            }
            this.f59961f = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59962g = jSONObject;
            this.f59959d = aVar;
            this.f59965j.a(this.f59960e);
            c();
            d();
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
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.f59960e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f59966k = aVar;
        }
    }
}
