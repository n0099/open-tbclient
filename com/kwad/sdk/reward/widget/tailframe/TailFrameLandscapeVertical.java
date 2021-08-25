package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements View.OnClickListener, a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f73487a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f73488b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f73489c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f73490d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f73491e;

    /* renamed from: f  reason: collision with root package name */
    public b f73492f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f73493g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f73494h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f73495i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73496j;
    public TextProgressBar k;
    public KsLogoView l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameLandscapeVertical(Context context) {
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
    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
            this.f73487a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
            this.f73488b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
            this.f73489c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
            this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            KSImageLoader.loadImage(this.f73487a, com.kwad.sdk.core.response.b.a.f(this.f73494h), this.f73493g);
            KSImageLoader.loadImage(this.f73488b, com.kwad.sdk.core.response.b.a.f(this.f73494h), this.f73493g);
            KSImageLoader.loadImage(this.f73489c, com.kwad.sdk.core.response.b.a.f(this.f73494h), this.f73493g);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!com.kwad.sdk.core.response.b.a.v(this.f73494h)) {
                TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f73491e = tailFrameBarH5Landscape;
                tailFrameBarH5Landscape.setModel(this.f73493g);
                this.f73491e.setVisibility(0);
                return;
            }
            TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
            this.f73490d = tailFrameBarAppLandscape;
            tailFrameBarAppLandscape.setModel(this.f73493g);
            this.f73490d.setVisibility(0);
            this.k = this.f73490d.getTextProgressBar();
            f();
            this.k.setOnClickListener(this);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f73496j = new com.kwad.sdk.core.download.b.b(this.f73493g, this.f73495i, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeVertical f73497b;

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
                    this.f73497b = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.u(this.f73497b.f73494h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.a(this.f73497b.f73493g), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.u(this.f73497b.f73494h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.j(this.f73497b.f73494h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f73497b.f73490d.a(this.f73497b.f73494h);
                        this.f73497b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setOnClickListener(null);
            this.f73496j = null;
        }
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, bVar) == null) {
            this.f73493g = adTemplate;
            this.f73494h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f73495i = jSONObject;
            this.f73492f = bVar;
            this.l.a(this.f73493g);
            d();
            e();
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f73490d;
            if (tailFrameBarAppLandscape != null) {
                tailFrameBarAppLandscape.a();
                this.f73490d.setVisibility(8);
            }
            TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f73491e;
            if (tailFrameBarH5Landscape != null) {
                tailFrameBarH5Landscape.a();
                this.f73491e.setVisibility(8);
            }
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f73493g, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeVertical f73498a;

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
                    this.f73498a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f73498a.f73492f == null) {
                        return;
                    }
                    this.f73498a.f73492f.a();
                }
            }, this.f73496j, view == this.k);
        }
    }
}
