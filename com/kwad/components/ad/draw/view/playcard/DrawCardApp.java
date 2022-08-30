package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.m.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAppDownloadListener br;
    public a cc;
    public ImageView cd;
    public ImageView ce;
    public TextView cf;
    public ViewGroup cg;
    public AppScoreView ch;
    public TextView ci;
    public TextView cj;
    public KsLogoView ck;
    public DrawDownloadProgressBar cl;
    public ValueAnimator cm;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public int mHeight;

    /* loaded from: classes7.dex */
    public interface a {
        void aC();

        void aD();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        E(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        E(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        E(context);
    }

    private void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0416, this);
            this.cd = (ImageView) findViewById(R.id.obfuscated_res_0x7f091056);
            this.ce = (ImageView) findViewById(R.id.obfuscated_res_0x7f09105b);
            this.cf = (TextView) findViewById(R.id.obfuscated_res_0x7f09105c);
            this.cg = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09105e);
            this.ch = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f09105d);
            this.ci = (TextView) findViewById(R.id.obfuscated_res_0x7f09105a);
            this.cj = (TextView) findViewById(R.id.obfuscated_res_0x7f091058);
            this.ck = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091062);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091059);
            this.cl = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
            this.mHeight = com.kwad.sdk.b.kwai.a.a(context, 156.0f);
        }
    }

    private void aL() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (valueAnimator = this.cm) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.cm.cancel();
    }

    private void aU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            d(this.mHeight, 0);
        }
    }

    private void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, this, i, i2) == null) {
            aL();
            ValueAnimator b = n.b(this, i, i2);
            this.cm = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.cm.setDuration(300L);
            this.cm.start();
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.br == null) {
                this.br = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: cn  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f1078cn;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f1078cn = this;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f1078cn.cl.f(com.kwad.sdk.core.response.a.a.al(this.f1078cn.mAdInfo), this.f1078cn.cl.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f1078cn.cl.f(com.kwad.sdk.core.response.a.a.aJ(this.f1078cn.mAdTemplate), this.f1078cn.cl.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f1078cn.cl.f(com.kwad.sdk.core.response.a.a.al(this.f1078cn.mAdInfo), this.f1078cn.cl.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f1078cn.cl.f(com.kwad.sdk.core.response.a.a.P(this.f1078cn.mAdInfo), this.f1078cn.cl.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.core.download.kwai.a
                    public final void onPaused(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                            super.onPaused(i);
                            this.f1078cn.cl.f(com.kwad.sdk.core.response.a.a.uU(), i);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                            DrawDownloadProgressBar drawDownloadProgressBar = this.f1078cn.cl;
                            drawDownloadProgressBar.f(i + "%", i);
                        }
                    }
                };
            }
            return this.br;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adTemplate, aVar) == null) {
            this.mAdTemplate = adTemplate;
            this.mAdInfo = d.bQ(adTemplate);
            this.cc = aVar;
            this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
            KSImageLoader.loadAppIcon(this.ce, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), adTemplate, 11);
            this.cf.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            String ah = com.kwad.sdk.core.response.a.a.ah(this.mAdInfo);
            float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
            boolean z = ai >= 3.0f;
            if (z) {
                this.ch.setScore(ai);
                this.ch.setVisibility(0);
            }
            boolean z2 = !TextUtils.isEmpty(ah);
            if (z2) {
                this.ci.setText(ah);
                this.ci.setVisibility(0);
            }
            if (z || z2) {
                this.cg.setVisibility(0);
            } else {
                this.cg.setVisibility(8);
            }
            this.ck.T(this.mAdTemplate);
            this.cj.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
            this.cd.setOnClickListener(this);
            this.cl.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public final void aT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(0, this.mHeight);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 != this.cd) {
                com.kwad.components.core.c.a.a.a(new a.C0569a(getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.cl).ae(view2 == this.cl ? 1 : 2).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: cn  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f1079cn;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f1079cn = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f1079cn.cc == null) {
                            return;
                        }
                        this.f1079cn.cc.aD();
                    }
                }));
                return;
            }
            aU();
            a aVar = this.cc;
            if (aVar != null) {
                aVar.aC();
            }
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            aL();
            this.mApkDownloadHelper = null;
        }
    }
}
