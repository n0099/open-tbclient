package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.widget.g;
import com.kwad.components.ad.interstitial.widget.h;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class d extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g fB;
    public com.kwad.components.ad.interstitial.widget.b fC;
    @NonNull
    public KsAdVideoPlayConfig fD;
    public h fE;
    public KsInterstitialAd.AdInteractionListener fo;
    public Activity mActivity;
    public AdTemplate mAdTemplate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Activity activity, @NonNull AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, adTemplate, ksVideoPlayConfig, adInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fE = new h(this) { // from class: com.kwad.components.ad.interstitial.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d fF;

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
                this.fF = this;
            }

            @Override // com.kwad.components.ad.interstitial.widget.h
            public final void k(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    com.kwad.sdk.core.report.a.i(this.fF.mAdTemplate, z ? 2 : 1);
                    this.fF.ch();
                }
            }
        };
        this.mActivity = activity;
        this.fo = adInteractionListener;
        this.fD = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.kwai.b.ci()).build();
        setOwnerActivity(activity);
        this.mAdTemplate = adTemplate;
        initView();
    }

    private boolean cg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            return com.kwad.sdk.core.response.a.a.bt(bQ) && com.kwad.components.ad.interstitial.a.a.cp() < com.kwad.sdk.core.response.a.a.bw(bQ);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.fB.removeAllViews();
            com.kwad.components.ad.interstitial.widget.b cVar = cg() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.mActivity)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.mActivity));
            this.fC = cVar;
            cVar.a(this.mAdTemplate, this, this.fD, this.fo);
            this.fB.addView(this.fC);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.fC = cg() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.mActivity)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.mActivity));
            g gVar = new g(Wrapper.wrapContextIfNeed(this.mActivity));
            this.fB = gVar;
            gVar.setOrientationChangeListener(this.fE);
            this.fB.removeAllViews();
            this.fB.addView(this.fC);
        }
    }

    public final boolean cf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (isShowing() || this.mActivity == null || this.mActivity.isFinishing()) {
                    return true;
                }
                show();
                com.kwad.components.ad.interstitial.a.b.I(this.mActivity);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            com.kwad.sdk.kwai.kwai.c.rd().rg();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.fo;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && com.kwad.components.ad.interstitial.kwai.b.cm()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.fB);
            this.fC.a(this.mAdTemplate, this, this.fD, this.fo);
            setCanceledOnTouchOutside(false);
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStart();
            com.kwad.sdk.core.e.b.d("InterstitialDialog", "onStart");
            setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                this.fC.dM();
            } else {
                this.fC.dN();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.fo = adInteractionListener;
            com.kwad.components.ad.interstitial.widget.b bVar = this.fC;
            if (bVar != null) {
                bVar.setAdInteractionListener(adInteractionListener);
            }
        }
    }
}
