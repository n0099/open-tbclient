package com.kwad.sdk.d.kwai;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.d.kwai.c;
import com.kwad.sdk.widget.KsAutoCloseView;
/* loaded from: classes3.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f58855b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f58856c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58857d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f58858e;

    /* renamed from: f  reason: collision with root package name */
    public KsAutoCloseView f58859f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58860g;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58857d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i2, boolean z2) {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            this.a.a(view, z, i2, z2);
            if (!com.kwad.sdk.core.config.b.aC() || (dialog = this.a.f58831c) == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            com.kwad.sdk.core.video.videoview.b bVar = this.f58858e;
            if (bVar != null) {
                bVar.k();
            }
            this.a.a(z, this.f58858e);
            this.a.f58831c.dismiss();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.a.f58830b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, adInfo)) == null) ? adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.an(adInfo) : invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.sdk.d.a.b bVar = this.a.f58833e;
            bVar.setAdTemplate(this.f58856c);
            if (com.kwad.sdk.core.response.a.a.Q(this.f58855b)) {
                bVar.a(com.kwad.sdk.core.response.a.a.I(this.f58855b).materialUrl, this.f58856c);
                bVar.a(true, true);
                bVar.a(false);
            } else {
                bVar.a(true);
                String a = com.kwad.sdk.core.response.a.a.aa(this.f58855b).a();
                if (TextUtils.isEmpty(a)) {
                    bVar.a(false, false);
                } else {
                    bVar.a(a, this.f58856c);
                    bVar.a(true, false);
                }
                com.kwad.sdk.core.video.videoview.b bVar2 = this.a.f58837i;
                this.f58858e = bVar2;
                if (bVar2.getParent() != null) {
                    ((ViewGroup) this.f58858e.getParent()).removeView(this.f58858e);
                }
                if (com.kwad.sdk.core.response.a.a.P(this.f58855b)) {
                    bVar.a(com.kwad.sdk.core.response.a.a.J(this.f58855b).height / com.kwad.sdk.core.response.a.a.J(this.f58855b).width, this.f58858e);
                }
                bVar.b(this.a.f58835g.isVideoSoundEnable());
                this.a.a(new a.b(this, com.kwad.sdk.core.response.a.a.b(this.f58855b), bVar) { // from class: com.kwad.sdk.d.kwai.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.kwad.sdk.d.a.b f58861b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f58862c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r7), bVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58862c = this;
                        this.a = r7;
                        this.f58861b = bVar;
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    @SuppressLint({"SetTextI18n"})
                    public void a(long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                            int i2 = this.a - ((int) (j2 / 1000));
                            if (i2 >= 0) {
                                this.f58861b.a(String.valueOf(i2));
                            } else {
                                this.f58861b.c();
                            }
                            if (j2 < com.kwad.sdk.core.config.b.aj() * 1000) {
                                return;
                            }
                            this.f58862c.f58857d = true;
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void b_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f58861b.a(true);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void e() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f58861b.a(false, false);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void f() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f58862c.f58858e.setVisibility(8);
                            if (this.f58862c.a.a(this.f58862c.q())) {
                                return;
                            }
                            this.f58861b.d();
                        }
                    }
                });
                bVar.a(this.f58856c, this.f58855b);
                bVar.a(true);
            }
            this.a.a(q(), this.f58855b, this.f58856c, bVar.getBlurBgView());
            if (!a(q(), this.f58855b)) {
                this.f58859f.a(false);
                return;
            }
            this.f58859f.a(true);
            f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            AdInfo adInfo = this.f58855b;
            int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
            if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
                i2 = Math.min(i2, com.kwad.sdk.core.response.a.a.b(this.f58855b));
                this.a.f58833e.c();
            }
            this.f58859f.a(i2);
            com.kwad.sdk.core.report.a.c(this.f58856c, 165, null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) p();
            this.a = cVar;
            AdTemplate adTemplate = cVar.a;
            this.f58856c = adTemplate;
            this.f58855b = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.a.f58833e.a(this.f58856c);
            this.a.f58833e.setViewListener(new com.kwad.sdk.d.a.d(this) { // from class: com.kwad.sdk.d.kwai.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.d.a.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(false);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 3, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.a.f58858e == null) {
                        return;
                    }
                    this.a.f58858e.setVideoSoundEnable(z);
                }

                @Override // com.kwad.sdk.d.a.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void b(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, true, 1, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void b(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048581, this, z) == null) {
                        this.a.f58860g = z;
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void c(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, true, 1, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void d(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 3, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void e(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 3, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void f(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 2, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void g(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 2, eVar.f58860g);
                    }
                }

                @Override // com.kwad.sdk.d.a.d
                public void h(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, view) == null) {
                        e eVar = this.a;
                        eVar.a(view, false, 2, eVar.f58860g);
                    }
                }
            });
            this.a.a(new c.a(this) { // from class: com.kwad.sdk.d.kwai.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.d.kwai.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) a(R.id.ksad_interstitial_auto_close);
            this.f58859f = ksAutoCloseView;
            ksAutoCloseView.setViewListener(new KsAutoCloseView.a(this) { // from class: com.kwad.sdk.d.kwai.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.widget.KsAutoCloseView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(true);
                    }
                }

                @Override // com.kwad.sdk.widget.KsAutoCloseView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.a(false);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.g();
            this.f58859f.setCountDownPaused(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.h();
            this.f58859f.setCountDownPaused(true);
        }
    }
}
