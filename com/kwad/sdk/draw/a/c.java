package com.kwad.sdk.draw.a;

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
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.draw.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f58349b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58350c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58351d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58352e;

    /* renamed from: f  reason: collision with root package name */
    public DrawDownloadProgressBar f58353f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f58354g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f58355h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58356i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f58357j;

    /* renamed from: k  reason: collision with root package name */
    public int f58358k;
    public int l;
    public int m;
    public KsLogoView n;
    public com.kwad.sdk.contentalliance.detail.video.d o;
    public KsAppDownloadListener p;

    public c() {
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
        this.o = new e(this) { // from class: com.kwad.sdk.draw.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    int i4 = (j3 > (this.a.m * 1000) ? 1 : (j3 == (this.a.m * 1000) ? 0 : -1));
                    c cVar = this.a;
                    if (i4 >= 0) {
                        ((com.kwad.sdk.draw.kwai.a) cVar).a.f58382f.a();
                        return;
                    }
                    int i5 = (j3 > (cVar.l * 1000) ? 1 : (j3 == (cVar.l * 1000) ? 0 : -1));
                    c cVar2 = this.a;
                    if (i5 >= 0) {
                        cVar2.h();
                    } else if (j3 >= cVar2.f58358k * 1000) {
                        this.a.f();
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
        this.p = new com.kwad.sdk.core.download.a.c(this) { // from class: com.kwad.sdk.draw.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f58359b;

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
                this.f58359b = this;
            }

            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    super.a(i4);
                    this.f58359b.f58352e.setText(com.kwad.sdk.core.response.a.a.a());
                    this.f58359b.f58353f.a(com.kwad.sdk.core.response.a.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f58359b.f58352e.setText(com.kwad.sdk.core.response.a.a.A(this.f58359b.f58355h));
                    this.f58359b.f58353f.a(com.kwad.sdk.core.response.a.a.A(this.f58359b.f58355h), this.f58359b.f58353f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f58359b.f58352e.setText(com.kwad.sdk.core.response.a.a.a(this.f58359b.f58354g));
                    this.f58359b.f58353f.a(com.kwad.sdk.core.response.a.a.a(this.f58359b.f58354g), this.f58359b.f58353f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f58359b.f58352e.setText(com.kwad.sdk.core.response.a.a.A(this.f58359b.f58355h));
                    this.f58359b.f58353f.a(com.kwad.sdk.core.response.a.a.A(this.f58359b.f58355h), this.f58359b.f58353f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f58359b.f58352e.setText(com.kwad.sdk.core.response.a.a.m(this.f58359b.f58355h));
                    this.f58359b.f58353f.a(com.kwad.sdk.core.response.a.a.m(this.f58359b.f58355h), this.f58359b.f58353f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    TextView textView = this.f58359b.f58352e;
                    textView.setText(i4 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.f58359b.f58353f;
                    drawDownloadProgressBar.a(i4 + "%", i4);
                }
            }
        };
    }

    private void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.f58349b.getContext()).a(this.f58354g).a(this.f58356i).a(i2).a(z).a(new a.b(this) { // from class: com.kwad.sdk.draw.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.a.f58354g, 1, ((com.kwad.sdk.draw.kwai.a) this.a).a.f58378b.getTouchCoords());
                        if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onAdClicked();
                        }
                    }
                }
            }));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f58358k = com.kwad.sdk.core.response.a.a.X(this.f58355h);
            this.l = com.kwad.sdk.core.response.a.a.Y(this.f58355h);
            this.m = com.kwad.sdk.core.response.a.a.Z(this.f58355h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f58352e.getVisibility() == 0 || this.f58353f.getVisibility() == 0) {
            return;
        }
        this.f58352e.setOnClickListener(this);
        this.f58352e.setVisibility(0);
        TextView textView = this.f58352e;
        ValueAnimator a = az.a(textView, 0, com.kwad.sdk.a.kwai.a.a(textView.getContext(), 44.0f));
        this.f58357j = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f58357j.setDuration(300L);
        this.f58357j.start();
    }

    private void g() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (valueAnimator = this.f58357j) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.f58357j.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.f58353f.getVisibility() == 0) {
            return;
        }
        this.f58353f.setOnClickListener(this);
        this.f58353f.setVisibility(0);
        this.f58352e.setVisibility(8);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f58379c;
            this.f58354g = adTemplate;
            this.f58355h = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f58356i = ((com.kwad.sdk.draw.kwai.a) this).a.f58380d;
            e();
            this.n.a(this.f58354g);
            this.f58352e.setText(com.kwad.sdk.core.response.a.a.A(this.f58355h));
            this.f58352e.setVisibility(8);
            this.f58353f.a(com.kwad.sdk.core.response.a.a.A(this.f58355h), this.f58353f.getMax());
            this.f58353f.setVisibility(8);
            this.f58349b.setVisibility(0);
            this.f58349b.setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.B(this.f58355h)) {
                this.f58350c.setText(com.kwad.sdk.core.response.a.a.t(this.f58355h));
                this.f58350c.setVisibility(0);
                com.kwad.sdk.core.download.a.b bVar = this.f58356i;
                if (bVar != null) {
                    bVar.a(this.p);
                }
            } else {
                this.f58350c.setVisibility(8);
            }
            this.f58351d.setText(com.kwad.sdk.core.response.a.a.s(this.f58355h));
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            g();
            com.kwad.sdk.core.download.a.b bVar = this.f58356i;
            if (bVar != null && (ksAppDownloadListener = this.p) != null) {
                bVar.b(ksAppDownloadListener);
            }
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.b(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58349b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f58350c = (TextView) a(R.id.ksad_ad_normal_title);
            this.f58351d = (TextView) a(R.id.ksad_ad_normal_des);
            this.n = (KsLogoView) a(R.id.ksad_ad_normal_logo);
            this.f58352e = (TextView) a(R.id.ksad_ad_normal_convert_btn);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) a(R.id.ksad_ad_light_convert_btn);
            this.f58353f = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f58349b) {
                h();
                a(false, 2);
                return;
            }
            if (view == this.f58352e) {
                h();
            } else if (view != this.f58353f) {
                return;
            }
            a(true, 1);
        }
    }
}
