package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class b extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    public com.kwad.components.ad.draw.kwai.b aK;
    public com.kwad.components.ad.draw.b.a aL;
    public com.kwad.components.core.widget.kwai.b aM;
    public boolean aN;
    public ImageView aO;
    public View.OnClickListener aP;
    public g aQ;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public Presenter mPresenter;
    public AdBaseFrameLayout mRootContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
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
        this.aP = new View.OnClickListener(this) { // from class: com.kwad.components.ad.draw.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b aR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.aR = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    com.kwad.components.core.c.a.a.a(new a.C0577a(this.aR.aK.mRootContainer.getContext()).L(this.aR.aK.mAdTemplate).b(this.aR.aK.mApkDownloadHelper).aj(false).ae(3).a(new a.b(this) { // from class: com.kwad.components.ad.draw.b.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 aS;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.aS = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            }
                        }
                    }));
                    if (3 == com.kwad.sdk.core.response.a.a.aP(com.kwad.sdk.core.response.a.d.bQ(this.aR.aK.mAdTemplate))) {
                        this.aR.al();
                    }
                }
            }
        };
        this.aQ = new h(this) { // from class: com.kwad.components.ad.draw.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b aR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.aR = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onVideoPlayPaused();
                    this.aR.aO.setVisibility(0);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onVideoPlayStart();
                    this.aR.aO.setVisibility(8);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.onVideoPlaying();
                    this.aR.aO.setVisibility(8);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.aL.f(!this.aN);
            if (this.aN) {
                this.aL.resume();
            } else {
                this.aL.pause();
            }
            this.aN = !this.aN;
        }
    }

    private com.kwad.components.ad.draw.kwai.b ao() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.components.ad.draw.kwai.b bVar = new com.kwad.components.ad.draw.kwai.b();
            bVar.aJ = this.aJ;
            bVar.mRootContainer = this.mRootContainer;
            bVar.mAdTemplate = this.mAdTemplate;
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            bVar.aL = this.aL;
            bVar.ba = new com.kwad.components.ad.draw.a.a.a(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
                bVar.bb = new com.kwad.components.ad.i.b();
            }
            return bVar;
        }
        return (com.kwad.components.ad.draw.kwai.b) invokeV.objValue;
    }

    private Presenter ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a(new com.kwad.components.ad.draw.a.kwai.a());
            presenter.a(new com.kwad.components.ad.draw.a.b());
            presenter.a(new com.kwad.components.ad.draw.a.d());
            presenter.a(new com.kwad.components.ad.draw.a.c());
            presenter.a(new com.kwad.components.ad.draw.a.a.b());
            if (com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate)) {
                presenter.a(new com.kwad.components.ad.draw.a.a.c());
            }
            presenter.a(new com.kwad.components.ad.draw.a.b.a());
            if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
                presenter.a(new com.kwad.components.ad.draw.a.b.b());
            }
            if (com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
                presenter.a(new com.kwad.components.ad.draw.a.a());
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0426, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091209);
            this.mRootContainer = adBaseFrameLayout;
            this.aO = (ImageView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f091249);
            DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09125f);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
            this.mDetailVideoView.setOnClickListener(this.aP);
            this.aO.setOnClickListener(this.aP);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.am();
            this.aK = ao();
            Presenter ap = ap();
            this.mPresenter = ap;
            ap.B(this.mRootContainer);
            this.mPresenter.e(this.aK);
            this.aM.qi();
            this.aL.aO();
            this.aL.a(this.aQ);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.an();
            com.kwad.components.core.widget.kwai.b bVar = this.aM;
            if (bVar != null) {
                bVar.release();
            }
            com.kwad.components.ad.draw.b.a aVar = this.aL;
            if (aVar != null) {
                aVar.aP();
                this.aL.b(this.aQ);
            }
            com.kwad.components.ad.draw.kwai.b bVar2 = this.aK;
            if (bVar2 != null) {
                bVar2.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        }
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this, 70);
            this.aM = bVar;
            this.aL = new com.kwad.components.ad.draw.b.a(this.mAdTemplate, bVar, this.mDetailVideoView);
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.aJ = adInteractionListener;
        }
    }
}
