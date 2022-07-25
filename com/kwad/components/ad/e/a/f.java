package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class f extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView cw;
    public TextView cx;
    public ViewGroup jY;
    public TextView jZ;
    public KsAppDownloadListener ka;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    public f() {
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
        this.ka = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.e.a.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f kb;

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
                this.kb = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.kb.jZ.setText(com.kwad.sdk.core.response.a.a.al(this.kb.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.kb.jZ.setText(com.kwad.sdk.core.response.a.a.aJ(this.kb.mAdTemplate));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.kb.jZ.setText(com.kwad.sdk.core.response.a.a.al(this.kb.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.kb.jZ.setText("立即打开");
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i3) == null) {
                }
            }
        };
    }

    private void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0352a(this.jY.getContext()).L(this.mAdTemplate).ae(i).b(this.mApkDownloadHelper).a(new a.b(this) { // from class: com.kwad.components.ad.e.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f kb;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.kb = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.kb.mAdTemplate, 2, this.kb.jL.jK.getTouchCoords());
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 12);
            this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            this.jZ.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.ka);
            }
            this.jY.setOnClickListener(this);
            this.jY.setVisibility(0);
        }
    }

    private void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.jL.jC.i(this.jY);
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.jL.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mApkDownloadHelper = this.jL.mApkDownloadHelper;
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f kb;

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
                    this.kb = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayCompleted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.kb.er();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                            com.kwad.components.core.b.a.b(th);
                        }
                    }
                }
            };
            this.mVideoPlayStateListener = hVar;
            this.jL.jM.a(hVar);
            this.jY.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2 == this.jY) {
                G(2);
                notifyAdClick();
            } else if (view2 == this.jZ) {
                G(1);
                notifyAdClick();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.jY = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09119c);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fec);
            this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f090fee);
            this.jZ = (TextView) findViewById(R.id.obfuscated_res_0x7f090fe9);
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.c(this.ka);
            }
        }
    }
}
