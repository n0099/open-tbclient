package com.kwad.components.ad.draw.a.b;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DrawVideoTailFrame bQ;
    @Nullable
    public com.kwad.components.ad.i.b bb;
    public g mVideoPlayStateListener;

    public a() {
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
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.draw.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a bR;

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
                this.bR = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onVideoPlayCompleted();
                    if (this.bR.bb == null || !this.bR.bb.ay()) {
                        this.bR.aN();
                    } else {
                        this.bR.bQ.setVisibility(8);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.bQ.aW();
            this.bQ.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.draw.kwai.b bVar = this.aK;
            this.bb = bVar.bb;
            this.bQ.c(bVar.mAdTemplate);
            this.bQ.setAdBaseFrameLayout(this.aK.mRootContainer);
            this.bQ.setApkDownloadHelper(this.aK.mApkDownloadHelper);
            this.bQ.setVisibility(8);
            this.bQ.setAdInteractionListener(this.aK.aJ);
            this.aK.aL.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.bQ = (DrawVideoTailFrame) findViewById(R.id.obfuscated_res_0x7f091210);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            this.aK.aL.b(this.mVideoPlayStateListener);
            this.bQ.release();
        }
    }
}
