package com.kwad.sdk.contentalliance.detail.ad.presenter.a;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.AdDownloadProgressBar;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34469b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34470c;

    /* renamed from: d  reason: collision with root package name */
    public AdDownloadProgressBar f34471d;

    /* renamed from: e  reason: collision with root package name */
    public AdDownloadProgressBar f34472e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f34473f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f34474g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f34475h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f34476i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
    public com.kwad.sdk.contentalliance.detail.video.b k;
    public com.kwad.sdk.contentalliance.a.a l;
    public e m;
    public KsAppDownloadListener n;

    public a() {
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
        this.l = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34477a;

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
                this.f34477a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.k();
                    this.f34477a.s();
                    this.f34477a.t();
                }
            }
        };
        this.m = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34478a;

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
                this.f34478a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.f34478a.t();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 >= com.kwad.sdk.core.response.b.b.g(this.f34478a.f34475h)) {
                    return;
                }
                int i4 = (j2 > com.kwad.sdk.core.response.b.b.f(this.f34478a.f34475h) ? 1 : (j2 == com.kwad.sdk.core.response.b.b.f(this.f34478a.f34475h) ? 0 : -1));
                a aVar = this.f34478a;
                if (i4 >= 0) {
                    aVar.p();
                } else if (j2 >= com.kwad.sdk.core.response.b.b.e(aVar.f34475h)) {
                    this.f34478a.g();
                }
            }
        };
        this.n = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34479a;

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
                this.f34479a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    float f2 = i4;
                    this.f34479a.f34471d.a(com.kwad.sdk.core.response.b.a.b(this.f34479a.f34476i, i4), f2);
                    this.f34479a.f34472e.a(com.kwad.sdk.core.response.b.a.b(this.f34479a.f34476i, i4), f2);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34479a.f34471d.setText(com.kwad.sdk.core.response.b.a.x(this.f34479a.f34476i));
                    this.f34479a.f34472e.setText(com.kwad.sdk.core.response.b.a.x(this.f34479a.f34476i));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34479a.f34471d.setText(com.kwad.sdk.core.response.b.a.a(this.f34479a.f34475h));
                    this.f34479a.f34472e.setText(com.kwad.sdk.core.response.b.a.a(this.f34479a.f34475h));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34479a.f34471d.setText(com.kwad.sdk.core.response.b.a.x(this.f34479a.f34476i));
                    this.f34479a.f34472e.setText(com.kwad.sdk.core.response.b.a.x(this.f34479a.f34476i));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f34479a.f34471d.setText(com.kwad.sdk.core.response.b.a.b());
                    this.f34479a.f34472e.setText(com.kwad.sdk.core.response.b.a.b());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    float f2 = i4;
                    this.f34479a.f34471d.a(com.kwad.sdk.core.response.b.a.a(this.f34479a.f34476i, i4), f2);
                    this.f34479a.f34472e.a(com.kwad.sdk.core.response.b.a.a(this.f34479a.f34476i, i4), f2);
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f34471d.setProgressDrawable(Color.parseColor("#4D36384B"));
            this.f34471d.setTextColor(Color.parseColor("#66FFFFFF"));
            this.f34471d.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_gray), null, ao.a(o(), 2.0f));
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f34472e.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.f34472e.a(null, null, o().getResources().getDrawable(R.drawable.ksad_btn_arrow_light), null, ao.a(o(), 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.f34471d.getVisibility() == 0 || this.f34472e.getVisibility() == 0) {
            return;
        }
        v();
        h();
        this.f34471d.setAlpha(1.0f);
        this.f34471d.setVisibility(0);
        this.f34471d.setOnClickListener(this);
        ViewGroup viewGroup = this.f34470c;
        ValueAnimator d2 = am.d(viewGroup, 0, ao.a(viewGroup.getContext(), 39.0f));
        this.f34473f = d2;
        d2.start();
    }

    private void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (valueAnimator = this.f34473f) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f34473f.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.f34472e.getVisibility() == 0) {
            return;
        }
        q();
        this.f34470c.setVisibility(0);
        this.f34472e.setOnClickListener(this);
        ValueAnimator a2 = am.a(this.f34471d, this.f34472e);
        this.f34474g = a2;
        a2.start();
    }

    private void q() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (valueAnimator = this.f34474g) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f34474g.cancel();
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            h();
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            q();
            this.f34472e.setAlpha(1.0f);
            this.f34472e.setVisibility(8);
            this.f34470c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            h();
            this.f34471d.setAlpha(1.0f);
            this.f34471d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f34475h, 1, this.f34469b.getTouchCoords());
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            com.kwad.sdk.core.report.b.c(this.f34475h, 19, null);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.f34475h = adTemplate;
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f34476i = j;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.j = cVar.o;
            this.k = cVar.m;
            this.f34471d.setText(com.kwad.sdk.core.response.b.a.x(j));
            this.f34471d.setVisibility(8);
            this.f34472e.setText(com.kwad.sdk.core.response.b.a.x(this.f34476i));
            this.f34472e.setProgressDrawable(Color.parseColor(com.kwad.sdk.core.response.b.a.X(this.f34476i)));
            this.f34472e.setVisibility(8);
            com.kwad.sdk.core.download.b.b bVar = this.j;
            if (bVar != null) {
                bVar.a(this.n);
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.a(this.m);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            r();
            com.kwad.sdk.core.download.b.b bVar = this.j;
            if (bVar != null) {
                bVar.b(this.n);
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.b(this.m);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34469b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34470c = (ViewGroup) b(R.id.ksad_progress_container);
            this.f34471d = (AdDownloadProgressBar) b(R.id.ksad_translate_progress);
            this.f34472e = (AdDownloadProgressBar) b(R.id.ksad_light_progress);
            e();
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            com.kwad.sdk.core.download.b.b.a(this.j, true);
            com.kwad.sdk.core.download.b.a.a(this.f34471d.getContext(), this.f34475h, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34480a;

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
                    this.f34480a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34480a.u();
                    }
                }
            }, this.j);
        }
    }
}
