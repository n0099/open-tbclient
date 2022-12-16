package com.kwad.components.ad.fullscreen.b.kwai;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h.a dv;
    public ImageView eE;
    @NonNull
    public com.kwad.components.ad.reward.j.a eF;
    public g mVideoPlayStateListener;

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
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c eG;

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
                this.eG = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.eG.eE == null || com.kwad.components.ad.reward.kwai.b.fY()) {
                    return;
                }
                this.eG.eE.post(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass1 eH;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext2);
                            int i3 = newInitContext2.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext2.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.eH = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.eH.eG.eE.setSelected(false);
                            this.eH.eG.eF.c(false, false);
                        }
                    }
                });
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c eG;

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
                this.eG = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.eG.bT();
                }
            }
        };
    }

    private void bQ() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.eF = this.nM.eF;
            boolean z = false;
            this.eE.setVisibility(0);
            KsVideoPlayConfig ksVideoPlayConfig = this.nM.mVideoPlayConfig;
            if (!this.eF.iJ() && com.kwad.components.core.m.b.at(getContext()).ov()) {
                imageView = this.eE;
            } else if (ksVideoPlayConfig != null) {
                this.eE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.eF.a(this.mVideoPlayStateListener);
                this.eF.a(this.dv);
            } else {
                imageView = this.eE;
                z = true;
            }
            imageView.setSelected(z);
            this.eF.a(this.mVideoPlayStateListener);
            this.eF.a(this.dv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.eE.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if (k.b(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            } else {
                bQ();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 == (imageView = this.eE)) {
            this.eF.c(!imageView.isSelected(), true);
            ImageView imageView2 = this.eE;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.eE = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912c1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.eF.b(this.mVideoPlayStateListener);
            this.nM.eF.b(this.dv);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
