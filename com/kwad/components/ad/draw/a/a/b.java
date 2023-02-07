package com.kwad.components.ad.draw.a.a;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DrawCardApp bC;
    public DrawCardH5 bD;
    public ViewGroup bh;
    public a.InterfaceC0548a bz;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

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
        this.bz = new a.InterfaceC0548a(this) { // from class: com.kwad.components.ad.draw.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b bE;

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
                this.bE = this;
            }

            @Override // com.kwad.components.ad.draw.a.a.a.InterfaceC0548a
            public final void ax() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.bE.ax();
                }
            }
        };
    }

    private void aA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.bh.setVisibility(8);
            this.bD.a(this.mAdTemplate, new DrawCardH5.a(this) { // from class: com.kwad.components.ad.draw.a.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b bE;

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
                    this.bE = this;
                }

                @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
                public final void aC() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.bE.bh.setVisibility(0);
                    }
                }

                @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
                public final void aD() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.bE.aB();
                    }
                }
            });
            this.bD.setVisibility(0);
            this.bD.aT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 29, this.aK.mRootContainer.getTouchCoords());
            KsDrawAd.AdInteractionListener adInteractionListener = this.aK.aJ;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                az();
            } else {
                aA();
            }
        }
    }

    private void az() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.bh.setVisibility(8);
            this.bC.a(this.mAdTemplate, new DrawCardApp.a(this) { // from class: com.kwad.components.ad.draw.a.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b bE;

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
                    this.bE = this;
                }

                @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
                public final void aC() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.bE.bh.setVisibility(0);
                    }
                }

                @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
                public final void aD() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.bE.aB();
                    }
                }
            });
            this.bC.setVisibility(0);
            this.bC.aT();
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.aK.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = d.bQ(adTemplate);
            this.aK.ba.a(this.bz);
            this.bC.setVisibility(8);
            this.bD.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091139);
            this.bC = (DrawCardApp) findViewById(R.id.obfuscated_res_0x7f091158);
            this.bD = (DrawCardH5) findViewById(R.id.obfuscated_res_0x7f091161);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            this.bC.release();
            this.bD.release();
            this.aK.ba.a((a.InterfaceC0548a) null);
        }
    }
}
