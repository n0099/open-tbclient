package com.kwad.components.ad.draw.view.playend;

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
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.kwai.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsDrawAd.AdInteractionListener aJ;
    public KsLogoView bq;
    @Nullable
    public KsAppDownloadListener br;
    public TextView cA;
    public DrawDownloadProgressBar cB;
    public ViewGroup cC;
    public TextView cD;
    public TextView cE;
    public AdBaseFrameLayout ct;
    public ImageView cu;
    public ViewGroup cv;
    public ImageView cw;
    public TextView cx;
    public AppScoreView cy;
    public TextView cz;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public c mApkDownloadHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawVideoTailFrame(@NonNull Context context) {
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
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0419, this);
            this.cu = (ImageView) findViewById(R.id.obfuscated_res_0x7f091200);
            this.cv = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09103d);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091042);
            this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f091044);
            this.cy = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091045);
            this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f091041);
            this.cA = (TextView) findViewById(R.id.obfuscated_res_0x7f09103c);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091040);
            this.cB = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(15);
            this.cC = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091098);
            this.cD = (TextView) findViewById(R.id.obfuscated_res_0x7f091097);
            this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f09109b);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091089);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new a(this) { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DrawVideoTailFrame cF;

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
                this.cF = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.cF.cB.f(com.kwad.sdk.core.response.a.a.al(this.cF.mAdInfo), this.cF.cB.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.cF.cB.f(com.kwad.sdk.core.response.a.a.aJ(this.cF.mAdTemplate), this.cF.cB.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.cF.cB.f(com.kwad.sdk.core.response.a.a.al(this.cF.mAdInfo), this.cF.cB.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.cF.cB.f(com.kwad.sdk.core.response.a.a.P(this.cF.mAdInfo), this.cF.cB.getMax());
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                    super.onPaused(i);
                    this.cF.cB.f(com.kwad.sdk.core.response.a.a.uU(), i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    DrawDownloadProgressBar drawDownloadProgressBar = this.cF.cB;
                    drawDownloadProgressBar.f(i + "%", i);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    public final void aW() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.mApkDownloadHelper) == null) {
            return;
        }
        KsAppDownloadListener ksAppDownloadListener = this.br;
        if (ksAppDownloadListener != null) {
            cVar.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener appDownloadListener = getAppDownloadListener();
        this.br = appDownloadListener;
        this.mApkDownloadHelper.b(appDownloadListener);
    }

    public final void c(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.mAdInfo = bQ;
            AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(bQ);
            String str = au.coverUrl;
            this.bq.T(adTemplate);
            if (!TextUtils.isEmpty(str)) {
                int i = au.width;
                int i2 = au.height;
                if (i > 0 && i > i2) {
                    int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext());
                    if (getWidth() != 0) {
                        screenWidth = getWidth();
                    }
                    ViewGroup.LayoutParams layoutParams = this.cu.getLayoutParams();
                    layoutParams.width = screenWidth;
                    layoutParams.height = (int) (screenWidth * (i2 / i));
                }
                KSImageLoader.loadImage(this.cu, str, this.mAdTemplate);
            }
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 11);
                this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
                float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
                if (ai >= 3.0f) {
                    this.cy.setScore(ai);
                    this.cy.setVisibility(0);
                }
                this.cz.setText(com.kwad.sdk.core.response.a.a.ah(this.mAdInfo));
                this.cA.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
                this.cv.setVisibility(0);
                this.cC.setVisibility(8);
            } else {
                this.cD.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
                this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
                this.cv.setVisibility(8);
                this.cC.setVisibility(0);
            }
            this.cB.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0354a(getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.cB ? 1 : 2).aj(view2 == this.cB).a(new a.b(this) { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DrawVideoTailFrame cF;

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
                    this.cF = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.cF.aJ != null) {
                            this.cF.aJ.onAdClicked();
                        }
                        com.kwad.sdk.core.report.a.a(this.cF.mAdTemplate, 2, this.cF.ct.getTouchCoords());
                    }
                }
            }));
        }
    }

    public final void release() {
        c cVar;
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.mApkDownloadHelper) == null || (ksAppDownloadListener = this.br) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adBaseFrameLayout) == null) {
            this.ct = adBaseFrameLayout;
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.aJ = adInteractionListener;
        }
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.mApkDownloadHelper = cVar;
        }
    }
}
