package com.kwad.components.ad.reward.presenter.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class d extends a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout fl;
    public e mPlayEndPageListener;

    public d() {
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
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.reward.presenter.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d tu;

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
                this.tu = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.a.a.Z(com.kwad.sdk.core.response.a.d.bQ(this.tu.nM.mAdTemplate))) {
                    this.tu.fl.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, playableSource, jVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            if (cc()) {
                this.nM.a(this.mPlayEndPageListener);
                com.kwad.components.ad.reward.b.eV().a(this);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.b.kwai.a.aI(getContext())) + 0.5f);
            aVar.height = 44;
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.nM.mA) {
            this.fl.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            if (!this.nM.mA || com.kwad.sdk.core.response.a.a.Z(bQ)) {
                return;
            }
            this.fl.setVisibility(0);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-top-bar" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.fl : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            kVar.mA = false;
            kVar.D(false);
            this.fl.setVisibility(8);
            com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.components.ad.reward.k.a(this.nM) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onCreate();
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091183);
            this.fl = frameLayout;
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onUnbind();
            if (cc()) {
                this.nM.b(this.mPlayEndPageListener);
                com.kwad.components.ad.reward.b.eV().b(this);
            }
        }
    }
}
