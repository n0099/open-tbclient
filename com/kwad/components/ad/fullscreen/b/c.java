package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.playable.PlayableSource;
/* loaded from: classes7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements f, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View ev;
    public View ew;
    public e mPlayEndPageListener;

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
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.fullscreen.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c ex;

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
                this.ex = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.ex.bM();
                }
            }
        };
        a(new com.kwad.components.ad.fullscreen.b.kwai.e());
        a(new com.kwad.components.ad.fullscreen.b.a.a());
        a(new com.kwad.components.ad.fullscreen.b.b.a());
    }

    private void bL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.ev.setVisibility(0);
            this.ew.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i = 8;
            if (this.nM.mA) {
                this.ev.setVisibility(8);
                view2 = this.ew;
            } else {
                this.ev.setVisibility(8);
                view2 = this.ew;
                i = 0;
            }
            view2.setVisibility(i);
        }
    }

    private void bN() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.nM.mA) {
            return;
        }
        this.ev.setVisibility(0);
        this.ew.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, playableSource, jVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            if (k.b(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
                this.ev.setVisibility(8);
                this.ew.setVisibility(8);
            }
            this.nM.a(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.eV().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bN();
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bM();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCreate();
            this.ev = findViewById(R.id.obfuscated_res_0x7f09111e);
            this.ew = findViewById(R.id.obfuscated_res_0x7f09111f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.b(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.b.eV().b(this);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bL();
        }
    }
}
