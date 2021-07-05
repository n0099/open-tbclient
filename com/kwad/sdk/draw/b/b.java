package com.kwad.sdk.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37058b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37059c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37060d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37061e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f37062f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f37063g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f37064h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37065i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public e o;
    public KsAppDownloadListener p;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new f(this) { // from class: com.kwad.sdk.draw.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37066a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37066a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    int i4 = (j2 > (this.f37066a.m * 1000) ? 1 : (j2 == (this.f37066a.m * 1000) ? 0 : -1));
                    b bVar = this.f37066a;
                    if (i4 >= 0) {
                        ((com.kwad.sdk.draw.a.a) bVar).f37034a.f37040f.a();
                        return;
                    }
                    int i5 = (j2 > (bVar.l * 1000) ? 1 : (j2 == (bVar.l * 1000) ? 0 : -1));
                    b bVar2 = this.f37066a;
                    if (i5 >= 0) {
                        bVar2.p();
                    } else if (j2 >= bVar2.k * 1000) {
                        this.f37066a.g();
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.p = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.draw.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37067a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37067a = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37067a.f37061e.setText(com.kwad.sdk.core.response.b.a.w(this.f37067a.f37064h));
                    this.f37067a.f37062f.a(com.kwad.sdk.core.response.b.a.w(this.f37067a.f37064h), this.f37067a.f37062f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f37067a.f37061e.setText(com.kwad.sdk.core.response.b.a.a(this.f37067a.f37063g));
                    this.f37067a.f37062f.a(com.kwad.sdk.core.response.b.a.a(this.f37067a.f37063g), this.f37067a.f37062f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f37067a.f37061e.setText(com.kwad.sdk.core.response.b.a.w(this.f37067a.f37064h));
                    this.f37067a.f37062f.a(com.kwad.sdk.core.response.b.a.w(this.f37067a.f37064h), this.f37067a.f37062f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f37067a.f37061e.setText(com.kwad.sdk.core.response.b.a.b());
                    this.f37067a.f37062f.a(com.kwad.sdk.core.response.b.a.b(), this.f37067a.f37062f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    TextView textView = this.f37067a.f37061e;
                    textView.setText(i4 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.f37067a.f37062f;
                    drawDownloadProgressBar.a(i4 + "%", i4);
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.k = com.kwad.sdk.core.response.b.a.R(this.f37064h);
            this.l = com.kwad.sdk.core.response.b.a.S(this.f37064h);
            this.m = com.kwad.sdk.core.response.b.a.T(this.f37064h);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.download.b.a.a(this.f37058b.getContext(), this.f37063g, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.draw.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37068a;

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
                    this.f37068a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.a(this.f37068a.f37063g, 1, ((com.kwad.sdk.draw.a.a) this.f37068a).f37034a.f37036b.getTouchCoords());
                        if (((com.kwad.sdk.draw.a.a) this.f37068a).f37034a.f37035a != null) {
                            ((com.kwad.sdk.draw.a.a) this.f37068a).f37034a.f37035a.onAdClicked();
                        }
                    }
                }
            }, this.f37065i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.f37061e.getVisibility() == 0 || this.f37062f.getVisibility() == 0) {
            return;
        }
        this.f37061e.setOnClickListener(this);
        this.f37061e.setVisibility(0);
        TextView textView = this.f37061e;
        ValueAnimator a2 = am.a(textView, 0, ao.a(textView.getContext(), 44.0f));
        this.j = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (valueAnimator = this.j) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.j.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.f37062f.getVisibility() == 0) {
            return;
        }
        this.f37062f.setOnClickListener(this);
        this.f37062f.setVisibility(0);
        this.f37061e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f37034a.f37037c;
            this.f37063g = adTemplate;
            this.f37064h = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f37065i = ((com.kwad.sdk.draw.a.a) this).f37034a.f37038d;
            e();
            this.n.a(this.f37063g);
            this.f37061e.setText(com.kwad.sdk.core.response.b.a.w(this.f37064h));
            this.f37061e.setVisibility(8);
            this.f37062f.a(com.kwad.sdk.core.response.b.a.w(this.f37064h), this.f37062f.getMax());
            this.f37062f.setVisibility(8);
            this.f37058b.setVisibility(0);
            this.f37058b.setOnClickListener(this);
            if (com.kwad.sdk.core.response.b.a.y(this.f37064h)) {
                this.f37059c.setText(com.kwad.sdk.core.response.b.a.q(this.f37064h));
                this.f37059c.setVisibility(0);
                com.kwad.sdk.core.download.b.b bVar = this.f37065i;
                if (bVar != null) {
                    bVar.a(this.p);
                }
            } else {
                this.f37059c.setVisibility(8);
            }
            this.f37060d.setText(com.kwad.sdk.core.response.b.a.n(this.f37064h));
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37039e.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            h();
            com.kwad.sdk.core.download.b.b bVar = this.f37065i;
            if (bVar != null && (ksAppDownloadListener = this.p) != null) {
                bVar.b(ksAppDownloadListener);
            }
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37039e.b(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37058b = (ViewGroup) b(R.id.ksad_ad_normal_container);
            this.f37059c = (TextView) b(R.id.ksad_ad_normal_title);
            this.f37060d = (TextView) b(R.id.ksad_ad_normal_des);
            this.n = (KsLogoView) b(R.id.ksad_ad_normal_logo);
            this.f37061e = (TextView) b(R.id.ksad_ad_normal_convert_btn);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.ksad_ad_light_convert_btn);
            this.f37062f = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f37058b || view == this.f37061e) {
                p();
            } else if (view != this.f37062f) {
                return;
            }
            f();
        }
    }
}
