package com.kwad.components.ad.reward.presenter.c;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.b.f;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.components.h;
import com.kwad.sdk.utils.az;
/* loaded from: classes7.dex */
public final class c extends a implements RewardActionBarControl.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout hP;
    public e mPlayEndPageListener;
    public int ts;

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
        this.ts = 0;
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.reward.presenter.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c tt;

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
                this.tt = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.tt.hide();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.hP.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hVar, bVar) == null) {
            super.a(hVar, bVar);
            hVar.c(new f(new com.kwad.components.ad.reward.b.d(this) { // from class: com.kwad.components.ad.reward.presenter.c.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c tt;

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
                    this.tt = this;
                }

                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                        com.kwad.sdk.core.e.b.d("TkRewardActionBarPresenter", "onUpdateExtraReward : " + bVar2.gs());
                        this.tt.a(bVar2);
                    }
                }
            }));
            hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c tt;

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
                    this.tt = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.b
                public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, str) == null) && TextUtils.equals(str, "getExtraReward")) {
                        aVar.a(com.kwad.components.ad.reward.b.a.gp().gq());
                        com.kwad.components.ad.reward.b.a.gp().a(aVar);
                    }
                }
            }));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            if (cc()) {
                this.ts = this.hP.getVisibility();
                getRootView().findViewById(R.id.obfuscated_res_0x7f091259).setVisibility(8);
                this.nM.a(this.mPlayEndPageListener);
                this.nM.ml.a(this);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
            aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
            aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "ksad-video-bottom-card-v2" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hP : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.hP.setVisibility(8);
            com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.components.ad.reward.k.c(this.nM) : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
    public final void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.hP.setVisibility(0);
            RewardActionBarControl.a(aVar, this.hP, RewardActionBarControl.ShowActionBarResult.TK);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onCreate();
            this.hP = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091111);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onUnbind();
            if (cc()) {
                this.nM.b(this.mPlayEndPageListener);
                this.hP.setVisibility(this.ts);
                this.nM.ml.a((RewardActionBarControl.d) null);
            }
        }
    }
}
