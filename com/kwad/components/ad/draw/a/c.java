package com.kwad.components.ad.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.n;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public TextView e;
    public DrawDownloadProgressBar f;
    public AdTemplate g;
    public AdInfo h;
    @Nullable
    public com.kwad.components.core.c.a.b i;
    public ValueAnimator j;
    public int k;
    public int l;
    public int m;
    public KsLogoView n;
    public g o;
    public KsAppDownloadListener p;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new h(this) { // from class: com.kwad.components.ad.draw.a.c.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    int i3 = (j2 > (this.a.m * 1000) ? 1 : (j2 == (this.a.m * 1000) ? 0 : -1));
                    c cVar = this.a;
                    if (i3 >= 0) {
                        ((com.kwad.components.ad.draw.kwai.a) cVar).a.f.a();
                        return;
                    }
                    int i4 = (j2 > (cVar.l * 1000) ? 1 : (j2 == (cVar.l * 1000) ? 0 : -1));
                    c cVar2 = this.a;
                    if (i4 >= 0) {
                        cVar2.h();
                    } else if (j2 >= cVar2.k * 1000) {
                        this.a.e();
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.p = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.draw.a.c.2
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    super.a(i3);
                    this.a.e.setText(com.kwad.sdk.core.response.a.a.a());
                    this.a.f.a(com.kwad.sdk.core.response.a.a.a(), i3);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.e.setText(com.kwad.sdk.core.response.a.a.H(this.a.h));
                    this.a.f.a(com.kwad.sdk.core.response.a.a.H(this.a.h), this.a.f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.e.setText(com.kwad.sdk.core.response.a.a.a(this.a.g));
                    this.a.f.a(com.kwad.sdk.core.response.a.a.a(this.a.g), this.a.f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.e.setText(com.kwad.sdk.core.response.a.a.H(this.a.h));
                    this.a.f.a(com.kwad.sdk.core.response.a.a.H(this.a.h), this.a.f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.e.setText(com.kwad.sdk.core.response.a.a.n(this.a.h));
                    this.a.f.a(com.kwad.sdk.core.response.a.a.n(this.a.h), this.a.f.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                    TextView textView = this.a.e;
                    textView.setText(i3 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.a.f;
                    drawDownloadProgressBar.a(i3 + "%", i3);
                }
            }
        };
    }

    private void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(this.b.getContext()).a(this.g).a(this.i).a(i).a(z).a(new a.b(this) { // from class: com.kwad.components.ad.draw.a.c.3
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.a.g, 1, ((com.kwad.components.ad.draw.kwai.a) this.a).a.b.getTouchCoords());
                        if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onAdClicked();
                        }
                    }
                }
            }));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.k = com.kwad.sdk.core.response.a.a.ab(this.h);
            this.l = com.kwad.sdk.core.response.a.a.ac(this.h);
            this.m = com.kwad.sdk.core.response.a.a.ad(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.e.getVisibility() == 0 || this.f.getVisibility() == 0) {
            return;
        }
        this.e.setOnClickListener(this);
        this.e.setVisibility(0);
        TextView textView = this.e;
        ValueAnimator a = n.a(textView, 0, com.kwad.sdk.b.kwai.a.a(textView.getContext(), 44.0f));
        this.j = a;
        a.setInterpolator(new DecelerateInterpolator(2.0f));
        this.j.setDuration(300L);
        this.j.start();
    }

    private void g() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (valueAnimator = this.j) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.j.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.f.getVisibility() == 0) {
            return;
        }
        this.f.setOnClickListener(this);
        this.f.setVisibility(0);
        this.e.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.components.ad.draw.kwai.a) this).a.c;
            this.g = adTemplate;
            this.h = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.i = ((com.kwad.components.ad.draw.kwai.a) this).a.d;
            d();
            this.n.a(this.g);
            this.e.setText(com.kwad.sdk.core.response.a.a.H(this.h));
            this.e.setVisibility(8);
            this.f.a(com.kwad.sdk.core.response.a.a.H(this.h), this.f.getMax());
            this.f.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.I(this.h)) {
                this.c.setText(com.kwad.sdk.core.response.a.a.A(this.h));
                this.c.setVisibility(0);
                com.kwad.components.core.c.a.b bVar = this.i;
                if (bVar != null) {
                    bVar.a(this.p);
                }
            } else {
                this.c.setVisibility(8);
            }
            this.d.setText(com.kwad.sdk.core.response.a.a.z(this.h));
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (ViewGroup) b(R.id.obfuscated_res_0x7f090fe9);
            this.c = (TextView) b(R.id.obfuscated_res_0x7f090fed);
            this.d = (TextView) b(R.id.obfuscated_res_0x7f090feb);
            this.n = (KsLogoView) b(R.id.obfuscated_res_0x7f090fec);
            this.e = (TextView) b(R.id.obfuscated_res_0x7f090fea);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) b(R.id.obfuscated_res_0x7f090fe8);
            this.f = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            g();
            com.kwad.components.core.c.a.b bVar = this.i;
            if (bVar != null && (ksAppDownloadListener = this.p) != null) {
                bVar.b(ksAppDownloadListener);
            }
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.o);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.b) {
                h();
                a(false, 2);
            } else if (view2 == this.e) {
                h();
                a(true, 1);
            } else if (view2 == this.f) {
                a(true, 1);
            }
        }
    }
}
