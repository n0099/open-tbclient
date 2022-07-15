package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d, c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public final Runnable c;

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
        this.c = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.s() == null || this.a.s().isFinishing()) {
                    return;
                }
                this.a.e();
                this.a.b.setAlpha(0.0f);
                this.a.b.animate().alpha(1.0f).setDuration(500L).start();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.b.setVisibility(0);
            this.b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            "ksad-video-top-bar".equals(str);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            if (lVar.z) {
                return;
            }
            long j = lVar.E;
            if (j == 0) {
                this.c.run();
            } else {
                az.a(this.c, j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = b(R.id.obfuscated_res_0x7f09103d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            this.b.setVisibility(8);
            az.b(this.c);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 == this.b) {
            PlayableSource j = ((com.kwad.components.ad.reward.presenter.a) this).a.j();
            if (j != null && (j.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || j.equals(PlayableSource.PENDANT_CLICK_AUTO) || j.equals(PlayableSource.PENDANT_AUTO) || j.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.b.a().b();
                return;
            }
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            e.b(lVar, lVar.m());
        }
    }
}
