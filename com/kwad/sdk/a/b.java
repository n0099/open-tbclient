package com.kwad.sdk.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.a.b.a f71393a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f71394b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsAdVideoPlayConfig f71395c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f71396d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f71397e;

    /* renamed from: f  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f71398f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Activity activity, @NonNull AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(Wrapper.wrapContextIfNeed(activity));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, adTemplate, ksVideoPlayConfig, adInteractionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71396d = new Handler(Looper.getMainLooper());
        this.f71397e = activity;
        this.f71398f = adInteractionListener;
        this.f71395c = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(true).build();
        setOwnerActivity(activity);
        this.f71394b = adTemplate;
        if (this.f71393a == null) {
            com.kwad.sdk.a.b.a aVar = new com.kwad.sdk.a.b.a(Wrapper.wrapContextIfNeed(activity));
            this.f71393a = aVar;
            aVar.a(this.f71394b, this, this.f71395c, adInteractionListener);
        }
    }

    public void a(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adInteractionListener) == null) {
            this.f71398f = adInteractionListener;
            com.kwad.sdk.a.b.a aVar = this.f71393a;
            if (aVar != null) {
                aVar.setAdInteractionListener(adInteractionListener);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (isShowing()) {
                    return true;
                }
                this.f71396d.post(new Runnable(this) { // from class: com.kwad.sdk.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f71399a;

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
                        this.f71399a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f71399a.f71397e.isFinishing()) {
                            return;
                        }
                        this.f71399a.show();
                        this.f71399a.f71398f.onAdShow();
                        com.kwad.sdk.core.report.a.a(this.f71399a.f71394b, (JSONObject) null);
                    }
                });
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            this.f71398f.onPageDismiss();
            this.f71396d.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c.ag()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.f71393a);
            setCanceledOnTouchOutside(false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.sdk.a.b.a aVar = this.f71393a;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStart();
            setTitle((CharSequence) null);
        }
    }
}
