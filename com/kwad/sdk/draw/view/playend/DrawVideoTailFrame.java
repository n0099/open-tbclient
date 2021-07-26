package com.kwad.sdk.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f35734a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35735b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f35736c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f35737d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsAppDownloadListener f35738e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35739f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f35740g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35741h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35742i;
    public AppScoreView j;
    public TextView k;
    public TextView l;
    public DrawDownloadProgressBar m;
    public ViewGroup n;
    public TextView o;
    public TextView p;
    public KsDrawAd.AdInteractionListener q;
    public KsLogoView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_draw_video_tailframe, this);
            this.f35739f = (ImageView) findViewById(R.id.ksad_video_cover);
            this.f35740g = (ViewGroup) findViewById(R.id.ksad_app_container);
            this.f35741h = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f35742i = (TextView) findViewById(R.id.ksad_app_name);
            this.j = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.k = (TextView) findViewById(R.id.ksad_app_download_count);
            this.l = (TextView) findViewById(R.id.ksad_app_ad_desc);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.m = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(15);
            this.n = (ViewGroup) findViewById(R.id.ksad_h5_container);
            this.o = (TextView) findViewById(R.id.ksad_h5_ad_desc);
            this.p = (TextView) findViewById(R.id.ksad_h5_open_btn);
            this.r = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new c(this) { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DrawVideoTailFrame f35743b;

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
                this.f35743b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    super.a(i2);
                    this.f35743b.m.a(a.a(), i2);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f35743b.m.a(a.u(this.f35743b.f35736c), this.f35743b.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f35743b.m.a(a.a(this.f35743b.f35735b), this.f35743b.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f35743b.m.a(a.u(this.f35743b.f35736c), this.f35743b.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f35743b.m.a(a.j(this.f35743b.f35736c), this.f35743b.m.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    DrawDownloadProgressBar drawDownloadProgressBar = this.f35743b.m;
                    drawDownloadProgressBar.a(i2 + "%", i2);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f35737d) == null) {
            return;
        }
        KsAppDownloadListener ksAppDownloadListener = this.f35738e;
        if (ksAppDownloadListener != null) {
            bVar.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener appDownloadListener = getAppDownloadListener();
        this.f35738e = appDownloadListener;
        this.f35737d.a(appDownloadListener);
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f35735b = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f35736c = i2;
            AdInfo.AdMaterialInfo.MaterialFeature C = a.C(i2);
            String str = C.coverUrl;
            this.r.a(adTemplate);
            if (!TextUtils.isEmpty(str)) {
                int i3 = C.width;
                int i4 = C.height;
                if (i3 > 0 && i3 > i4) {
                    int c2 = av.c(getContext());
                    if (getWidth() != 0) {
                        c2 = getWidth();
                    }
                    ViewGroup.LayoutParams layoutParams = this.f35739f.getLayoutParams();
                    layoutParams.width = c2;
                    layoutParams.height = (int) (c2 * (i4 / i3));
                }
                KSImageLoader.loadImage(this.f35739f, str, this.f35735b);
            }
            if (a.v(this.f35736c)) {
                KSImageLoader.loadAppIcon(this.f35741h, a.n(this.f35736c), this.f35735b, 11);
                this.f35742i.setText(a.o(this.f35736c));
                float s = a.s(this.f35736c);
                if (s >= 3.0f) {
                    this.j.setScore(s);
                    this.j.setVisibility(0);
                }
                this.k.setText(a.r(this.f35736c));
                this.l.setText(a.m(this.f35736c));
                this.f35740g.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.o.setText(a.m(this.f35736c));
                this.p.setText(a.u(this.f35736c));
                this.f35740g.setVisibility(8);
                this.n.setVisibility(0);
            }
            this.m.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public void b() {
        b bVar;
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f35737d) == null || (ksAppDownloadListener = this.f35738e) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f35735b, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.draw.view.playend.DrawVideoTailFrame.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DrawVideoTailFrame f35744a;

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
                    this.f35744a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35744a.q != null) {
                            this.f35744a.q.onAdClicked();
                        }
                        com.kwad.sdk.core.report.a.a(this.f35744a.f35735b, 2, this.f35744a.f35734a.getTouchCoords());
                    }
                }
            }, this.f35737d, view == this.m);
        }
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adBaseFrameLayout) == null) {
            this.f35734a = adBaseFrameLayout;
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.q = adInteractionListener;
        }
    }

    public void setApkDownloadHelper(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f35737d = bVar;
        }
    }
}
