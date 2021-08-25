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
    public ViewGroup f72613b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f72614c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f72615d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f72616e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f72617f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f72618g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f72619h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72620i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f72621j;
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
            public final /* synthetic */ b f72622a;

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
                this.f72622a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    int i4 = (j3 > (this.f72622a.m * 1000) ? 1 : (j3 == (this.f72622a.m * 1000) ? 0 : -1));
                    b bVar = this.f72622a;
                    if (i4 >= 0) {
                        ((com.kwad.sdk.draw.a.a) bVar).f72586a.f72592f.a();
                        return;
                    }
                    int i5 = (j3 > (bVar.l * 1000) ? 1 : (j3 == (bVar.l * 1000) ? 0 : -1));
                    b bVar2 = this.f72622a;
                    if (i5 >= 0) {
                        bVar2.o();
                    } else if (j3 >= bVar2.k * 1000) {
                        this.f72622a.f();
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
            public final /* synthetic */ b f72623b;

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
                this.f72623b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    super.a(i4);
                    this.f72623b.f72616e.setText(com.kwad.sdk.core.response.b.a.a());
                    this.f72623b.f72617f.a(com.kwad.sdk.core.response.b.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f72623b.f72616e.setText(com.kwad.sdk.core.response.b.a.u(this.f72623b.f72619h));
                    this.f72623b.f72617f.a(com.kwad.sdk.core.response.b.a.u(this.f72623b.f72619h), this.f72623b.f72617f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f72623b.f72616e.setText(com.kwad.sdk.core.response.b.a.a(this.f72623b.f72618g));
                    this.f72623b.f72617f.a(com.kwad.sdk.core.response.b.a.a(this.f72623b.f72618g), this.f72623b.f72617f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f72623b.f72616e.setText(com.kwad.sdk.core.response.b.a.u(this.f72623b.f72619h));
                    this.f72623b.f72617f.a(com.kwad.sdk.core.response.b.a.u(this.f72623b.f72619h), this.f72623b.f72617f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f72623b.f72616e.setText(com.kwad.sdk.core.response.b.a.j(this.f72623b.f72619h));
                    this.f72623b.f72617f.a(com.kwad.sdk.core.response.b.a.j(this.f72623b.f72619h), this.f72623b.f72617f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    TextView textView = this.f72623b.f72616e;
                    textView.setText(i4 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.f72623b.f72617f;
                    drawDownloadProgressBar.a(i4 + "%", i4);
                }
            }
        };
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            com.kwad.sdk.core.download.b.a.a(this.f72613b.getContext(), this.f72618g, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.draw.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72624a;

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
                    this.f72624a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.f72624a.f72618g, 1, ((com.kwad.sdk.draw.a.a) this.f72624a).f72586a.f72588b.getTouchCoords());
                        if (((com.kwad.sdk.draw.a.a) this.f72624a).f72586a.f72587a != null) {
                            ((com.kwad.sdk.draw.a.a) this.f72624a).f72586a.f72587a.onAdClicked();
                        }
                    }
                }
            }, this.f72620i, z);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.k = com.kwad.sdk.core.response.b.a.Q(this.f72619h);
            this.l = com.kwad.sdk.core.response.b.a.R(this.f72619h);
            this.m = com.kwad.sdk.core.response.b.a.S(this.f72619h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f72616e.getVisibility() == 0 || this.f72617f.getVisibility() == 0) {
            return;
        }
        this.f72616e.setOnClickListener(this);
        this.f72616e.setVisibility(0);
        TextView textView = this.f72616e;
        ValueAnimator a2 = at.a(textView, 0, av.a(textView.getContext(), 44.0f));
        this.f72621j = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f72621j.setDuration(300L);
        this.f72621j.start();
    }

    private void n() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (valueAnimator = this.f72621j) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f72621j.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.f72617f.getVisibility() == 0) {
            return;
        }
        this.f72617f.setOnClickListener(this);
        this.f72617f.setVisibility(0);
        this.f72616e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f72586a.f72589c;
            this.f72618g = adTemplate;
            this.f72619h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f72620i = ((com.kwad.sdk.draw.a.a) this).f72586a.f72590d;
            e();
            this.n.a(this.f72618g);
            this.f72616e.setText(com.kwad.sdk.core.response.b.a.u(this.f72619h));
            this.f72616e.setVisibility(8);
            this.f72617f.a(com.kwad.sdk.core.response.b.a.u(this.f72619h), this.f72617f.getMax());
            this.f72617f.setVisibility(8);
            this.f72613b.setVisibility(0);
            this.f72613b.setOnClickListener(this);
            if (com.kwad.sdk.core.response.b.a.v(this.f72619h)) {
                this.f72614c.setText(com.kwad.sdk.core.response.b.a.o(this.f72619h));
                this.f72614c.setVisibility(0);
                com.kwad.sdk.core.download.b.b bVar = this.f72620i;
                if (bVar != null) {
                    bVar.a(this.p);
                }
            } else {
                this.f72614c.setVisibility(8);
            }
            this.f72615d.setText(com.kwad.sdk.core.response.b.a.m(this.f72619h));
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f72613b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f72614c = (TextView) a(R.id.ksad_ad_normal_title);
            this.f72615d = (TextView) a(R.id.ksad_ad_normal_des);
            this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
            this.f72616e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
            this.f72617f = drawDownloadProgressBar;
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
            com.kwad.sdk.core.download.b.b bVar = this.f72620i;
            if (bVar != null && (ksAppDownloadListener = this.p) != null) {
                bVar.b(ksAppDownloadListener);
            }
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.b(this.o);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f72613b) {
                o();
                a(false);
                return;
            }
            if (view == this.f72616e) {
                o();
            } else if (view != this.f72617f) {
                return;
            }
            a(true);
        }
    }
}
