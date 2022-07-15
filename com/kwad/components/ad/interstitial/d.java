package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.widget.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public com.kwad.components.ad.interstitial.widget.b b;
    public AdTemplate c;
    @NonNull
    public KsAdVideoPlayConfig d;
    public Activity e;
    public KsInterstitialAd.AdInteractionListener f;
    public g g;

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
        this.g = new g(this) { // from class: com.kwad.components.ad.interstitial.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                this.a = this;
            }

            @Override // com.kwad.components.ad.interstitial.widget.g
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.d();
                }
            }
        };
        this.e = activity;
        this.f = adInteractionListener;
        this.d = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.kwai.b.a()).build();
        setOwnerActivity(activity);
        this.c = adTemplate;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwad.components.ad.interstitial.widget.b cVar = c() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.e)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.e));
            this.b = cVar;
            cVar.setOrientationChangeListener(this.g);
            this.b.a(this.c, this, this.d, this.f);
            FrameLayout frameLayout = new FrameLayout(Wrapper.wrapContextIfNeed(this.e));
            this.a = frameLayout;
            frameLayout.removeAllViews();
            this.a.addView(this.b);
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.c);
            return com.kwad.sdk.core.response.a.a.aK(i) && com.kwad.components.ad.interstitial.a.a.a() < com.kwad.sdk.core.response.a.a.aN(i);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.a.removeAllViews();
            com.kwad.components.ad.interstitial.widget.b cVar = c() ? new com.kwad.components.ad.interstitial.widget.c(Wrapper.wrapContextIfNeed(this.e)) : new com.kwad.components.ad.interstitial.widget.e(Wrapper.wrapContextIfNeed(this.e));
            this.b = cVar;
            cVar.setOrientationChangeListener(this.g);
            this.b.a(this.c, this, this.d, this.f);
            this.a.addView(this.b);
        }
    }

    public final void a(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adInteractionListener) == null) {
            this.f = adInteractionListener;
            com.kwad.components.ad.interstitial.widget.b bVar = this.b;
            if (bVar != null) {
                bVar.setAdInteractionListener(adInteractionListener);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (isShowing() || this.e == null || this.e.isFinishing()) {
                    return true;
                }
                show();
                com.kwad.components.ad.interstitial.a.b.a(this.e);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && com.kwad.components.ad.interstitial.kwai.b.e()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.a);
            setCanceledOnTouchOutside(false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStart();
            com.kwad.sdk.core.d.b.a("InterstitialDialog", "onStart");
            setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
            com.kwad.sdk.core.d.b.a("InterstitialDialog", "onWindowFocusChanged , hasFocus: " + z);
            if (z) {
                this.b.a();
            } else {
                this.b.b();
            }
        }
    }
}
