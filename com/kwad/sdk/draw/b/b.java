package com.kwad.sdk.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.draw.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f73112b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73113c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73114d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73115e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f73116f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f73117g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f73118h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73119i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f73120j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public d o;
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
        this.o = new e(this) { // from class: com.kwad.sdk.draw.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73121a;

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
                this.f73121a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    int i4 = (j3 > (this.f73121a.m * 1000) ? 1 : (j3 == (this.f73121a.m * 1000) ? 0 : -1));
                    b bVar = this.f73121a;
                    if (i4 >= 0) {
                        ((com.kwad.sdk.draw.a.a) bVar).f73085a.f73091f.a();
                        return;
                    }
                    int i5 = (j3 > (bVar.l * 1000) ? 1 : (j3 == (bVar.l * 1000) ? 0 : -1));
                    b bVar2 = this.f73121a;
                    if (i5 >= 0) {
                        bVar2.o();
                    } else if (j3 >= bVar2.k * 1000) {
                        this.f73121a.f();
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.p = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.draw.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f73122b;

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
                this.f73122b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    super.a(i4);
                    this.f73122b.f73115e.setText(com.kwad.sdk.core.response.b.a.a());
                    this.f73122b.f73116f.a(com.kwad.sdk.core.response.b.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f73122b.f73115e.setText(com.kwad.sdk.core.response.b.a.u(this.f73122b.f73118h));
                    this.f73122b.f73116f.a(com.kwad.sdk.core.response.b.a.u(this.f73122b.f73118h), this.f73122b.f73116f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f73122b.f73115e.setText(com.kwad.sdk.core.response.b.a.a(this.f73122b.f73117g));
                    this.f73122b.f73116f.a(com.kwad.sdk.core.response.b.a.a(this.f73122b.f73117g), this.f73122b.f73116f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f73122b.f73115e.setText(com.kwad.sdk.core.response.b.a.u(this.f73122b.f73118h));
                    this.f73122b.f73116f.a(com.kwad.sdk.core.response.b.a.u(this.f73122b.f73118h), this.f73122b.f73116f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f73122b.f73115e.setText(com.kwad.sdk.core.response.b.a.j(this.f73122b.f73118h));
                    this.f73122b.f73116f.a(com.kwad.sdk.core.response.b.a.j(this.f73122b.f73118h), this.f73122b.f73116f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    TextView textView = this.f73122b.f73115e;
                    textView.setText(i4 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.f73122b.f73116f;
                    drawDownloadProgressBar.a(i4 + "%", i4);
                }
            }
        };
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            com.kwad.sdk.core.download.b.a.a(this.f73112b.getContext(), this.f73117g, new a.InterfaceC1990a(this) { // from class: com.kwad.sdk.draw.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f73123a;

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
                    this.f73123a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1990a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.f73123a.f73117g, 1, ((com.kwad.sdk.draw.a.a) this.f73123a).f73085a.f73087b.getTouchCoords());
                        if (((com.kwad.sdk.draw.a.a) this.f73123a).f73085a.f73086a != null) {
                            ((com.kwad.sdk.draw.a.a) this.f73123a).f73085a.f73086a.onAdClicked();
                        }
                    }
                }
            }, this.f73119i, z);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.k = com.kwad.sdk.core.response.b.a.Q(this.f73118h);
            this.l = com.kwad.sdk.core.response.b.a.R(this.f73118h);
            this.m = com.kwad.sdk.core.response.b.a.S(this.f73118h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f73115e.getVisibility() == 0 || this.f73116f.getVisibility() == 0) {
            return;
        }
        this.f73115e.setOnClickListener(this);
        this.f73115e.setVisibility(0);
        TextView textView = this.f73115e;
        ValueAnimator a2 = at.a(textView, 0, av.a(textView.getContext(), 44.0f));
        this.f73120j = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f73120j.setDuration(300L);
        this.f73120j.start();
    }

    private void n() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (valueAnimator = this.f73120j) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f73120j.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.f73116f.getVisibility() == 0) {
            return;
        }
        this.f73116f.setOnClickListener(this);
        this.f73116f.setVisibility(0);
        this.f73115e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f73085a.f73088c;
            this.f73117g = adTemplate;
            this.f73118h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f73119i = ((com.kwad.sdk.draw.a.a) this).f73085a.f73089d;
            e();
            this.n.a(this.f73117g);
            this.f73115e.setText(com.kwad.sdk.core.response.b.a.u(this.f73118h));
            this.f73115e.setVisibility(8);
            this.f73116f.a(com.kwad.sdk.core.response.b.a.u(this.f73118h), this.f73116f.getMax());
            this.f73116f.setVisibility(8);
            this.f73112b.setVisibility(0);
            this.f73112b.setOnClickListener(this);
            if (com.kwad.sdk.core.response.b.a.v(this.f73118h)) {
                this.f73113c.setText(com.kwad.sdk.core.response.b.a.o(this.f73118h));
                this.f73113c.setVisibility(0);
                com.kwad.sdk.core.download.b.b bVar = this.f73119i;
                if (bVar != null) {
                    bVar.a(this.p);
                }
            } else {
                this.f73113c.setVisibility(8);
            }
            this.f73114d.setText(com.kwad.sdk.core.response.b.a.m(this.f73118h));
            ((com.kwad.sdk.draw.a.a) this).f73085a.f73090e.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73112b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f73113c = (TextView) a(R.id.ksad_ad_normal_title);
            this.f73114d = (TextView) a(R.id.ksad_ad_normal_des);
            this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
            this.f73115e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
            this.f73116f = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            n();
            com.kwad.sdk.core.download.b.b bVar = this.f73119i;
            if (bVar != null && (ksAppDownloadListener = this.p) != null) {
                bVar.b(ksAppDownloadListener);
            }
            ((com.kwad.sdk.draw.a.a) this).f73085a.f73090e.b(this.o);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f73112b) {
                o();
                a(false);
                return;
            }
            if (view == this.f73115e) {
                o();
            } else if (view != this.f73116f) {
                return;
            }
            a(true);
        }
    }
}
