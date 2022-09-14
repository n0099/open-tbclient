package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bc;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdVideoPlayConfig cN;
    public ViewGroup jP;
    public ImageView jQ;
    public TextView jR;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cN = ksAdVideoPlayConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.jP.getVisibility() == 0) {
            this.jP.setVisibility(8);
        }
    }

    private boolean f(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, adInfo)) == null) {
            if (ae.isNetworkConnected(getContext())) {
                KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
                if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                        return true;
                    }
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                        return ae.isWifiConnected(getContext());
                    }
                    if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                        return false;
                    }
                    if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                        return ae.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ae.isMobileConnected(getContext()));
                    }
                }
                if (com.kwad.sdk.core.response.a.a.bi(adInfo)) {
                    return true;
                }
                return com.kwad.sdk.core.response.a.a.bj(adInfo) && ae.isWifiConnected(getContext());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        ViewGroup viewGroup;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate);
            if (f(bQ)) {
                viewGroup = this.jP;
                i = 8;
            } else {
                this.jR.setText(bc.v(com.kwad.sdk.core.response.a.a.B(bQ) * 1000));
                this.jQ.setOnClickListener(this);
                this.jL.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
                viewGroup = this.jP;
                i = 0;
            }
            viewGroup.setVisibility(i);
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a jS;

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
                    this.jS = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.onVideoPlayStart();
                        this.jS.ep();
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        super.onVideoPlaying();
                        this.jS.ep();
                    }
                }
            };
            this.mVideoPlayStateListener = hVar;
            this.jL.jM.a(hVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 == this.jQ) {
            this.jL.jM.ex();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.jP = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091090);
            this.jQ = (ImageView) findViewById(R.id.obfuscated_res_0x7f091091);
            this.jR = (TextView) findViewById(R.id.obfuscated_res_0x7f091092);
        }
    }
}
