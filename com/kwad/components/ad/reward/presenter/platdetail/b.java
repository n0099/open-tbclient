package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, new f().aI(z ? 1 : 153).b(this.nM.mRootContainer.getTouchCoords()), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    private void b(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view2, z) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0354a(view2.getContext()).L(this.mAdTemplate).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean rl;
                public final /* synthetic */ b rm;

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
                    this.rm = this;
                    this.rl = z;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.rm.P(this.rl);
                    }
                }
            }).b(this.mApkDownloadHelper).aj(false).ae(3));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            k kVar = this.nM;
            this.mAdTemplate = kVar.mAdTemplate;
            this.mApkDownloadHelper = kVar.mApkDownloadHelper;
            new com.kwad.sdk.widget.f(this.mDetailVideoView, this);
            this.mDetailVideoView.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.ay(d.bQ(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
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

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f09120c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            this.mDetailVideoView.setClickListener(null);
        }
    }
}
