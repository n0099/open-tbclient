package com.kwad.components.ad.reward.presenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public final class r extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailVideoView mj;
    public ViewGroup rd;
    public FrameLayout re;
    public ImageView rf;
    public ViewGroup.LayoutParams rg;

    public r() {
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
        this.rg = null;
    }

    private void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.re.addView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.re, false), -1, -1);
        }
    }

    private void hp() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            boolean z = !ag.cB(getContext());
            boolean aY = com.kwad.sdk.core.response.a.a.aY(bQ);
            boolean z2 = com.kwad.sdk.core.response.a.a.bD(bQ) && com.kwad.components.ad.reward.kwai.b.gj();
            boolean z3 = com.kwad.components.ad.reward.k.o(this.nM.mAdTemplate) || com.kwad.components.ad.reward.k.p(this.nM.mAdTemplate) || aY || z2;
            if (!z || !z3) {
                this.rd.setVisibility(8);
                return;
            }
            this.rd.setVisibility(z2 ? 4 : 0);
            if (aY) {
                this.rf.setVisibility(8);
                i = R.layout.obfuscated_res_0x7f0d0446;
            } else {
                i = R.layout.obfuscated_res_0x7f0d03ff;
            }
            P(i);
            if (!com.kwad.sdk.core.response.a.a.ay(bQ)) {
                this.mj.updateTextureViewGravity(17);
            } else {
                this.mj.updateTextureViewGravity(21);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            ViewGroup.LayoutParams layoutParams = this.mj.getLayoutParams();
            if (layoutParams != null) {
                this.rg = new ViewGroup.LayoutParams(layoutParams);
            }
            hp();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mj = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091220);
            this.rd = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091115);
            this.rf = (ImageView) findViewById(R.id.obfuscated_res_0x7f091116);
            this.re = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091117);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            if (this.rg == null || (detailVideoView = this.mj) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = this.rg;
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                this.mj.setLayoutParams(layoutParams);
            }
            this.rg = null;
        }
    }
}
