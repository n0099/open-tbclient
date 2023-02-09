package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes8.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAppDownloadListener br;
    public ImageView cw;
    public TextView cx;
    public TextView cz;
    public TextView dh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public AppScoreView wH;
    public TextProgressBar wI;
    public View wJ;
    public a wM;

    /* loaded from: classes8.dex */
    public interface a {
        void R(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        initView();
    }

    private void b(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, view2, z) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0598a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wI).ae(view2 == this.wJ ? 1 : 2).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean rl;
                public final /* synthetic */ ActionBarAppPortrait wN;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.wN = this;
                    this.rl = z;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.wN.wM == null) {
                        return;
                    }
                    this.wN.wM.R(this.rl);
                }
            }));
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.br == null) {
                this.br = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ActionBarAppPortrait wN;

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
                        this.wN = this;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.al(this.wN.mAdInfo), 0);
                            this.wN.wJ.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.aJ(this.wN.mAdTemplate), 0);
                            this.wN.wJ.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.al(this.wN.mAdInfo), 0);
                            this.wN.wJ.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.P(this.wN.mAdInfo), 0);
                            this.wN.wJ.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.core.download.kwai.a
                    public final void onPaused(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.aX(i), i);
                            this.wN.wJ.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                            this.wN.wI.f(com.kwad.sdk.core.response.a.a.aW(i), i);
                            this.wN.wJ.setVisibility(8);
                        }
                    }
                };
            }
            return this.br;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0490, this);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091159);
            this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f09115d);
            this.dh = (TextView) findViewById(R.id.obfuscated_res_0x7f091155);
            this.wH = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f09115c);
            this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f091158);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091157);
            this.wI = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
            this.wI.setTextColor(-1);
            this.wJ = findViewById(R.id.obfuscated_res_0x7f091190);
        }
    }

    private void jg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            String ah = com.kwad.sdk.core.response.a.a.ah(this.mAdInfo);
            boolean z = !TextUtils.isEmpty(ah);
            float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
            boolean z2 = ai >= 3.0f;
            if (z && z2) {
                ((LinearLayout.LayoutParams) this.cx.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
                ((LinearLayout.LayoutParams) this.wH.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
                this.cz.setText(ah);
                this.cz.setVisibility(0);
                this.wH.setVisibility(0);
                this.wH.setScore(ai);
                this.dh.setVisibility(8);
            } else if (z) {
                this.cz.setText(ah);
                this.cz.setVisibility(0);
                this.wH.setVisibility(8);
                this.dh.setVisibility(8);
            } else if (z2) {
                this.cz.setVisibility(8);
                this.wH.setScore(ai);
                this.wH.setVisibility(0);
                this.dh.setVisibility(8);
            } else {
                this.dh.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
                this.cz.setVisibility(8);
                this.wH.setVisibility(8);
                this.dh.setVisibility(0);
            }
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, cVar, aVar) == null) {
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.wM = aVar;
            this.mApkDownloadHelper = cVar;
            KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(bQ), adTemplate, 12);
            this.cx.setText(com.kwad.sdk.core.response.a.a.bl(this.mAdInfo));
            jg();
            this.wI.f(com.kwad.sdk.core.response.a.a.al(this.mAdInfo), 0);
            com.kwad.components.core.c.a.c cVar2 = this.mApkDownloadHelper;
            if (cVar2 != null) {
                cVar2.b(getAppDownloadListener());
            }
            setClickable(true);
            new f(this, this);
            new f(this.wJ, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            b(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }
}
