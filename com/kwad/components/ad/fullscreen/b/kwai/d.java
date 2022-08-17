package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView eI;
    public TextView eJ;
    public View eK;
    public com.kwad.components.ad.reward.d.d eL;
    public AdTemplate mAdTemplate;
    public g mVideoPlayStateListener;

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
        this.eK = null;
        this.eL = new com.kwad.components.ad.reward.d.d(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d eM;

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
                this.eM = this;
            }

            @Override // com.kwad.components.ad.reward.d.d
            public final void bV() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.eM.bU();
                }
            }
        };
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d eM;

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
                this.eM = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < com.kwad.sdk.core.response.a.a.W(com.kwad.sdk.core.response.a.d.bQ(this.eM.mAdTemplate))) {
                    return;
                }
                this.eM.bU();
            }
        };
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            k kVar = this.nM;
            this.mAdTemplate = kVar.mAdTemplate;
            kVar.eF.a(this.mVideoPlayStateListener);
            this.nM.mr.add(this.eL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.eK.getVisibility() == 0) {
            return;
        }
        this.eK.setAlpha(0.0f);
        this.eK.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d eM;

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
                this.eM = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.eM.eK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.eK.setOnClickListener(this);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 == this.eK) {
            k kVar = this.nM;
            com.kwad.components.ad.reward.presenter.e.a(kVar, false, kVar.fB());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.eI = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c8);
            this.eJ = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ee);
            if (TextUtils.isEmpty(com.kwad.components.ad.fullscreen.kwai.b.bD())) {
                if (com.kwad.components.ad.fullscreen.kwai.b.bC() == 0) {
                    imageView = this.eI;
                    i = R.drawable.obfuscated_res_0x7f080c2e;
                } else {
                    imageView = this.eI;
                    i = R.drawable.obfuscated_res_0x7f080c8a;
                }
                imageView.setImageResource(i);
                this.eJ.setVisibility(8);
                view2 = this.eI;
            } else {
                this.eJ.setText(com.kwad.components.ad.fullscreen.kwai.b.bD());
                this.eI.setVisibility(8);
                view2 = this.eJ;
            }
            this.eK = view2;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.eF.b(this.mVideoPlayStateListener);
            this.nM.mr.remove(this.eL);
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
