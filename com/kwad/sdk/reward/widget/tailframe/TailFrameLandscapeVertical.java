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
    public ImageView f74021a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74022b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f74023c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f74024d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f74025e;

    /* renamed from: f  reason: collision with root package name */
    public b f74026f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f74027g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f74028h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f74029i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f74030j;
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
            this.f74021a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
            this.f74022b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
            this.f74023c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
            this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            KSImageLoader.loadImage(this.f74021a, com.kwad.sdk.core.response.b.a.f(this.f74028h), this.f74027g);
            KSImageLoader.loadImage(this.f74022b, com.kwad.sdk.core.response.b.a.f(this.f74028h), this.f74027g);
            KSImageLoader.loadImage(this.f74023c, com.kwad.sdk.core.response.b.a.f(this.f74028h), this.f74027g);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!com.kwad.sdk.core.response.b.a.v(this.f74028h)) {
                TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
                this.f74025e = tailFrameBarH5Landscape;
                tailFrameBarH5Landscape.setModel(this.f74027g);
                this.f74025e.setVisibility(0);
                return;
            }
            TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
            this.f74024d = tailFrameBarAppLandscape;
            tailFrameBarAppLandscape.setModel(this.f74027g);
            this.f74024d.setVisibility(0);
            this.k = this.f74024d.getTextProgressBar();
            f();
            this.k.setOnClickListener(this);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f74030j = new com.kwad.sdk.core.download.b.b(this.f74027g, this.f74029i, new c(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeVertical f74031b;

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
                    this.f74031b = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.u(this.f74031b.f74028h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.a(this.f74031b.f74027g), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.u(this.f74031b.f74028h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.j(this.f74031b.f74028h), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f74031b.f74024d.a(this.f74031b.f74028h);
                        this.f74031b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setOnClickListener(null);
            this.f74030j = null;
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
            this.f74027g = adTemplate;
            this.f74028h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f74029i = jSONObject;
            this.f74026f = bVar;
            this.l.a(this.f74027g);
            d();
            e();
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f74024d;
            if (tailFrameBarAppLandscape != null) {
                tailFrameBarAppLandscape.a();
                this.f74024d.setVisibility(8);
            }
            TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f74025e;
            if (tailFrameBarH5Landscape != null) {
                tailFrameBarH5Landscape.a();
                this.f74025e.setVisibility(8);
            }
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f74027g, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TailFrameLandscapeVertical f74032a;

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
                    this.f74032a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f74032a.f74026f == null) {
                        return;
                    }
                    this.f74032a.f74026f.a();
                }
            }, this.f74030j, view == this.k);
        }
    }
}
