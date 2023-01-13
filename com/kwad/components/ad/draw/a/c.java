package com.kwad.components.ad.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup bh;
    public TextView bi;
    public TextView bj;
    public TextView bk;
    public DrawDownloadProgressBar bl;
    public ValueAnimator bm;
    public int bn;
    public int bo;
    public int bp;
    public KsLogoView bq;
    public KsAppDownloadListener br;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public g mVideoPlayStateListener;

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
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.draw.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bs;

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
                this.bs = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    int i3 = (j2 > (this.bs.bp * 1000) ? 1 : (j2 == (this.bs.bp * 1000) ? 0 : -1));
                    c cVar = this.bs;
                    if (i3 >= 0) {
                        cVar.aK.ba.aw();
                        return;
                    }
                    int i4 = (j2 > (cVar.bo * 1000) ? 1 : (j2 == (cVar.bo * 1000) ? 0 : -1));
                    c cVar2 = this.bs;
                    if (i4 >= 0) {
                        cVar2.au();
                    } else if (j2 >= cVar2.bn * 1000) {
                        this.bs.as();
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.br = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.draw.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c bs;

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
                this.bs = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.bs.bk.setText(com.kwad.sdk.core.response.a.a.al(this.bs.mAdInfo));
                    this.bs.bl.f(com.kwad.sdk.core.response.a.a.al(this.bs.mAdInfo), this.bs.bl.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.bs.bk.setText(com.kwad.sdk.core.response.a.a.aJ(this.bs.mAdTemplate));
                    this.bs.bl.f(com.kwad.sdk.core.response.a.a.aJ(this.bs.mAdTemplate), this.bs.bl.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.bs.bk.setText(com.kwad.sdk.core.response.a.a.al(this.bs.mAdInfo));
                    this.bs.bl.f(com.kwad.sdk.core.response.a.a.al(this.bs.mAdInfo), this.bs.bl.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.bs.bk.setText(com.kwad.sdk.core.response.a.a.P(this.bs.mAdInfo));
                    this.bs.bl.f(com.kwad.sdk.core.response.a.a.P(this.bs.mAdInfo), this.bs.bl.getMax());
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i3) == null) {
                    super.onPaused(i3);
                    this.bs.bk.setText(com.kwad.sdk.core.response.a.a.uU());
                    this.bs.bl.f(com.kwad.sdk.core.response.a.a.uU(), i3);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                    TextView textView = this.bs.bk;
                    textView.setText(i3 + "%");
                    DrawDownloadProgressBar drawDownloadProgressBar = this.bs.bl;
                    drawDownloadProgressBar.f(i3 + "%", i3);
                }
            }
        };
    }

    private void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0593a(this.bh.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(i).aj(z).a(new a.b(this) { // from class: com.kwad.components.ad.draw.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c bs;

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
                    this.bs = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.bs.mAdTemplate, 1, this.bs.aK.mRootContainer.getTouchCoords());
                        if (this.bs.aK.aJ != null) {
                            this.bs.aK.aJ.onAdClicked();
                        }
                    }
                }
            }));
        }
    }

    private void ar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.bn = com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
            this.bo = com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
            this.bp = com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.bk.getVisibility() == 0 || this.bl.getVisibility() == 0) {
            return;
        }
        this.bk.setOnClickListener(this);
        this.bk.setVisibility(0);
        TextView textView = this.bk;
        ValueAnimator b = n.b(textView, 0, com.kwad.sdk.b.kwai.a.a(textView.getContext(), 44.0f));
        this.bm = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bm.setDuration(300L);
        this.bm.start();
    }

    private void at() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (valueAnimator = this.bm) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.bm.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.bl.getVisibility() == 0) {
            return;
        }
        this.bl.setOnClickListener(this);
        this.bl.setVisibility(0);
        this.bk.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.aK.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mApkDownloadHelper = this.aK.mApkDownloadHelper;
            ar();
            this.bq.T(this.mAdTemplate);
            this.bk.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.bk.setVisibility(8);
            this.bl.f(com.kwad.sdk.core.response.a.a.al(this.mAdInfo), this.bl.getMax());
            this.bl.setVisibility(8);
            this.bh.setVisibility(0);
            this.bh.setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                this.bi.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
                this.bi.setVisibility(0);
                com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
                if (cVar != null) {
                    cVar.b(this.br);
                }
            } else {
                this.bi.setVisibility(8);
            }
            this.bj.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
            this.aK.aL.a(this.mVideoPlayStateListener);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2 == this.bh) {
                au();
                a(false, 2);
            } else if (view2 == this.bk) {
                au();
                a(true, 1);
            } else if (view2 == this.bl) {
                a(true, 1);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910f6);
            this.bi = (TextView) findViewById(R.id.obfuscated_res_0x7f0910fa);
            this.bj = (TextView) findViewById(R.id.obfuscated_res_0x7f0910f8);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910f9);
            this.bk = (TextView) findViewById(R.id.obfuscated_res_0x7f0910f7);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f0910f5);
            this.bl = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            at();
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null && (ksAppDownloadListener = this.br) != null) {
                cVar.c(ksAppDownloadListener);
            }
            this.aK.aL.b(this.mVideoPlayStateListener);
        }
    }
}
