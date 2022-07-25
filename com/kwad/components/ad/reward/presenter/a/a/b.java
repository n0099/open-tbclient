package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View sK;
    public final Runnable sL;

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
                return;
            }
        }
        this.sL = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b sM;

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
                this.sM = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.sM.getActivity() == null || this.sM.getActivity().isFinishing()) {
                    return;
                }
                this.sM.hS();
                this.sM.sK.setAlpha(0.0f);
                this.sM.sK.animate().alpha(1.0f).setDuration(500L).start();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.sK.setVisibility(0);
            this.sK.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if (k.a(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void hR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k kVar = this.nM;
            if (kVar.mF) {
                return;
            }
            long j = kVar.mO;
            if (j == 0) {
                this.sL.run();
            } else {
                bd.runOnUiThreadDelay(this.sL, j);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && view2 == this.sK) {
            PlayableSource fz = this.nM.fz();
            if (fz != null && (fz.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fz.equals(PlayableSource.PENDANT_CLICK_AUTO) || fz.equals(PlayableSource.PENDANT_AUTO) || fz.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.b.eV().eW();
                return;
            }
            k kVar = this.nM;
            e.b(kVar, kVar.fC());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.sK = findViewById(R.id.obfuscated_res_0x7f091034);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            this.sK.setVisibility(8);
            bd.c(this.sL);
            com.kwad.components.core.webview.b.c.a.pR().b(this);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            "ksad-video-top-bar".equals(str);
        }
    }
}
