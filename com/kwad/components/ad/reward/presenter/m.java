package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class m extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener;
    public float pY;
    public n qa;
    public boolean qb;
    public KsToastView qh;
    public boolean qi;
    public boolean qj;
    public Runnable qk;
    public boolean ql;

    public m(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qi = false;
        this.qj = false;
        this.ql = false;
        this.qb = false;
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.presenter.m.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m qm;

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
                this.qm = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.qm.qh.setVisibility(8);
                }
            }
        };
        this.qa = nVar;
    }

    private synchronized void gY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this) {
                if (this.qb) {
                    return;
                }
                com.kwad.sdk.core.report.a.d(this.nM.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
                this.qb = true;
            }
        }
    }

    private void hd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.qk = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.m.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m qm;

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
                    this.qm = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.qm.ql) {
                        return;
                    }
                    if (this.qm.qh != null) {
                        this.qm.qh.setVisibility(8);
                    }
                    com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_AUTO);
                }
            };
        }
    }

    private void he() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            bd.c(this.qk);
            this.qk = null;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.nM.a(this.mPlayEndPageListener);
        }
    }

    public final void hb() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.qj) {
            return;
        }
        gY();
        this.qj = true;
        this.qh.setVisibility(0);
        this.qh.U(3);
        hd();
        bd.a(this.qk, null, 3000L);
    }

    public final void hc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.qj = false;
            this.qh.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            KsToastView ksToastView = (KsToastView) findViewById(R.id.obfuscated_res_0x7f09129e);
            this.qh = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.reward.presenter.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m qm;

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
                    this.qm = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.qm.ql = true;
                        this.qm.qh.setVisibility(8);
                        com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_CLICK_AUTO);
                    }
                }
            });
            this.pY = com.kwad.components.ad.reward.kwai.b.gb();
            this.qi = com.kwad.components.ad.reward.kwai.b.gc() && com.kwad.components.ad.reward.kwai.b.gd();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            he();
            this.nM.b(this.mPlayEndPageListener);
        }
    }
}
