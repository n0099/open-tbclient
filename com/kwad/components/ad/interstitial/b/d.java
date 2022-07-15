package com.kwad.components.ad.interstitial.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.kwai.kwai.a;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.b.j;
import com.kwad.components.core.webview.b.k;
import com.kwad.components.core.webview.b.kwai.q;
import com.kwad.components.core.webview.b.s;
import com.kwad.components.core.webview.b.t;
import com.kwad.components.core.webview.b.y;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class d extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 400;
    public static float g = 0.8f;
    public static float h = 1.0f;
    public static float i = 0.749f;
    public transient /* synthetic */ FieldHolder $fh;
    public t A;
    public x B;
    @Nullable
    public com.kwad.components.ad.f.kwai.kwai.a C;
    public boolean D;
    public com.kwad.components.core.widget.kwai.b E;
    public com.kwad.sdk.core.g.b F;
    public final Runnable G;
    public p.a H;
    public u.b I;
    @NonNull
    public Context a;
    public AdInfo b;
    public y c;
    public com.kwad.sdk.core.f.d d;
    public Vibrator e;
    public c j;
    public com.kwad.components.core.webview.a k;
    public com.kwad.sdk.core.webview.b l;
    public AdTemplate m;
    public boolean n;
    public KSFrameLayout o;
    public KSFrameLayout p;
    public Handler q;
    public Dialog r;
    public KsAdWebView s;
    @Nullable
    public com.kwad.components.core.c.a.b t;
    public int u;
    public com.kwad.sdk.core.video.videoview.a v;
    public ImageView w;
    @NonNull
    public KsAdVideoPlayConfig x;
    public ImageView y;
    public a.b z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228459822, "Lcom/kwad/components/ad/interstitial/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228459822, "Lcom/kwad/components/ad/interstitial/b/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new Handler(Looper.getMainLooper());
        this.u = -1;
        this.D = false;
        this.F = new com.kwad.sdk.core.g.c(this) { // from class: com.kwad.components.ad.interstitial.b.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.g.c, com.kwad.sdk.core.g.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "onPageInvisible");
                    if (this.a.B != null) {
                        this.a.B.e();
                        this.a.B.f();
                    }
                }
            }

            @Override // com.kwad.sdk.core.g.c, com.kwad.sdk.core.g.b
            public final void m_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "onPageVisible");
                    if (this.a.B != null) {
                        this.a.B.c();
                        this.a.B.d();
                    }
                }
            }
        };
        this.G = new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "rollBackRunnable run");
                    this.a.b("4");
                }
            }
        };
        this.H = new p.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.p.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.m.mPvReported || this.a.j.h || this.a.j.b == null) {
                    return;
                }
                this.a.j.b.onAdShow();
            }
        };
        this.I = new u.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.a.n || this.a.D) {
                    return;
                }
                this.a.u = aVar.a;
                if (this.a.u != 1) {
                    this.a.b("3");
                    return;
                }
                this.a.s.setVisibility(0);
                com.kwad.components.core.i.a.a().a(this.a.m);
                this.a.q.removeCallbacksAndMessages(null);
                az.b(this.a.G);
                if (this.a.C != null) {
                    this.a.C.c();
                }
            }
        };
    }

    @NonNull
    private WebCardVideoPositionHandler A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) {
                    com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + this.a.D);
                    if (this.a.D || (adInfo = this.a.b) == null || !com.kwad.sdk.core.response.a.a.W(adInfo)) {
                        return;
                    }
                    c unused = this.a.j;
                    d dVar = this.a;
                    boolean a = c.a(dVar.a, dVar.b);
                    d dVar2 = this.a;
                    dVar2.a(dVar2.b, videoPosition, dVar2.p, a);
                    this.a.p.setVisibility(0);
                    this.a.s.setVisibility(0);
                }
            }
        }) : (WebCardVideoPositionHandler) invokeV.objValue;
    }

    private ae B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ae aeVar = new ae(u(), this.m);
            aeVar.a(new ae.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // com.kwad.components.core.webview.jshandler.ae.a
                public final boolean j_() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.a.A != null) {
                            this.a.A.a(false);
                        }
                        az.a(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass7 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.a.r == null) {
                                    return;
                                }
                                this.a.a.r.dismiss();
                                if (this.a.a.j.h || this.a.a.j.b == null) {
                                    return;
                                }
                                this.a.a.j.b.onAdClosed();
                            }
                        });
                        boolean z = !this.a.j.m;
                        if (z) {
                            this.a.j.a(true, this.a.j.l);
                        }
                        return z;
                    }
                    return invokeV2.booleanValue;
                }
            });
            return aeVar;
        }
        return (ae) invokeV.objValue;
    }

    private t.a C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new t.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.jshandler.t.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.a.a, new AdWebViewActivityProxy.a.C0514a().a(bVar.b).b(bVar.a).a(this.a.m).a());
                }
            }
        } : (t.a) invokeV.objValue;
    }

    @NonNull
    private n D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? new n(new n.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.jshandler.n.b
            public final void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.a.r == null) {
                    return;
                }
                this.a.q.post(new Runnable(this, i2) { // from class: com.kwad.components.ad.interstitial.b.d.9.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;
                    public final /* synthetic */ AnonymousClass9 b;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = i2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            if (!this.b.a.j.h && this.a == 0 && !this.b.a.j.f && !this.b.a.j.g && com.kwad.components.ad.interstitial.c.a.a(this.b.a.j)) {
                                this.b.a.j.g = true;
                                com.kwad.components.ad.interstitial.a.b.b(this.b.a.a);
                                return;
                            }
                            this.b.a.r.dismiss();
                            this.b.a.j.a(this.a == 3, this.b.a.v);
                            if (this.b.a.j.h || this.b.a.j.b == null) {
                                return;
                            }
                            this.b.a.j.b.onAdClosed();
                        }
                    }
                });
            }
        }) : (n) invokeV.objValue;
    }

    private com.kwad.components.core.webview.b.t E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            com.kwad.components.core.webview.b.t tVar = new com.kwad.components.core.webview.b.t(this) { // from class: com.kwad.components.ad.interstitial.b.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // com.kwad.components.core.webview.b.t, com.kwad.components.core.webview.b.m, com.kwad.sdk.core.webview.kwai.a
                public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        if (this.a.v.d()) {
                            q qVar = new q();
                            qVar.b = false;
                            qVar.c = false;
                            qVar.a = 0;
                            cVar.a(qVar);
                        }
                        if (this.a.v.h()) {
                            q qVar2 = new q();
                            qVar2.b = false;
                            qVar2.c = true;
                            qVar2.a = com.kwad.sdk.core.response.a.a.c(com.kwad.sdk.core.response.a.d.i(this.a.l.a()));
                            cVar.a(qVar2);
                        }
                    }
                }
            };
            this.A = tVar;
            return tVar;
        }
        return (com.kwad.components.core.webview.b.t) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.video.videoview.a aVar = this.j.l;
            if (aVar != null) {
                aVar.i();
            }
            this.j.c.dismiss();
            c cVar = this.j;
            if (cVar.h || (adInteractionListener = cVar.b) == null) {
                return;
            }
            adInteractionListener.onAdClosed();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.d G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new com.kwad.components.core.webview.jshandler.d(this.l, this.t, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (!this.a.j.h && this.a.j.b != null) {
                    this.a.j.b.onAdClicked();
                }
                this.a.j.f = true;
                if (!this.a.j.h) {
                    this.a.j.c();
                }
                if (this.a.j.c == null || !com.kwad.components.ad.interstitial.kwai.b.g()) {
                    return;
                }
                this.a.j.c.dismiss();
            }
        }) : (com.kwad.components.core.webview.jshandler.d) invokeV.objValue;
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.f H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new com.kwad.components.core.webview.jshandler.f(this.l, this.t, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (!this.a.j.h && this.a.j.b != null) {
                    this.a.j.b.onAdClicked();
                }
                this.a.j.f = true;
                if (!this.a.j.h) {
                    this.a.j.c();
                }
                if (this.a.j.c == null || !com.kwad.components.ad.interstitial.kwai.b.g()) {
                    return;
                }
                this.a.j.c.dismiss();
            }
        }) : (com.kwad.components.core.webview.jshandler.f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            float s = com.kwad.sdk.core.response.a.b.s(this.m);
            if (this.d == null) {
                com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(s);
                this.d = dVar;
                dVar.a(new com.kwad.sdk.core.f.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

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

                    @Override // com.kwad.sdk.core.f.b
                    public final void a(double d) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
                            if (com.kwad.sdk.b.kwai.a.a(this.a.o, 100)) {
                                this.a.a(d);
                            }
                            az.a(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.16.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass16 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                                        this.a.a.d.a();
                                    }
                                }
                            }, null, 500L);
                        }
                    }

                    @Override // com.kwad.sdk.core.f.b
                    public final void d() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                });
            }
            this.d.a(s);
            this.d.a(u());
        }
    }

    private void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            String t = com.kwad.sdk.core.response.a.b.t(this.m);
            if (TextUtils.isEmpty(t)) {
                b("1");
            } else {
                a(t);
            }
        }
    }

    public static float a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? (z && z2) ? 1.7777778f : 0.749f : invokeCommon.floatValue;
    }

    public static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, videoPosition, marginLayoutParams)) == null) {
            marginLayoutParams.topMargin = videoPosition.topMargin;
            marginLayoutParams.leftMargin = videoPosition.leftMargin;
            marginLayoutParams.width = videoPosition.width;
            marginLayoutParams.height = videoPosition.height;
            return marginLayoutParams;
        }
        return (ViewGroup.MarginLayoutParams) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Double.valueOf(d)}) == null) {
            this.j.a(new c.b(u()).b(true).a(d).a(2).a(this.o.getTouchCoords()).b(Cea708Decoder.COMMAND_DF5));
            az.a(u(), this.e);
        }
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, marginLayoutParams, marginLayoutParams2) == null) {
            marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
            marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
            marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
            marginLayoutParams2.width = marginLayoutParams.width;
            marginLayoutParams2.height = marginLayoutParams.height;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, aVar, str) == null) {
            aVar.a(H());
            aVar.a(G());
            aVar.a(new j());
            aVar.a(y());
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.l));
            aVar.a(x());
            aVar.a(w());
            aVar.a(D());
            x xVar = new x();
            this.B = xVar;
            aVar.a(xVar);
            this.j.a(z());
            aVar.a(E());
            aVar.a(A());
            aVar.a(new l(this.l));
            aVar.a(n());
            aVar.a(new u(this.I, str));
            aVar.a(l());
            p pVar = new p(this.l);
            pVar.a(this.H);
            aVar.a(pVar);
            aVar.a(B());
            aVar.a(new com.kwad.components.core.webview.jshandler.t(C()));
            if (com.kwad.sdk.core.response.a.b.g(com.kwad.sdk.core.response.a.d.i(this.m))) {
                aVar.a(k());
            }
            if (v() != null) {
                aVar.a(this.C);
            }
            aVar.a(m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{adInfo, videoPosition, kSFrameLayout, Boolean.valueOf(z)}) == null) {
            kSFrameLayout.setWidthBasedRatio(!z);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
            com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + marginLayoutParams.height);
            a(videoPosition, marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
            float S = com.kwad.sdk.core.response.a.a.S(adInfo);
            com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + S);
            if (!z || S <= 0.0f) {
                kSFrameLayout.setRatio(0.0f);
            } else {
                int i2 = marginLayoutParams.width;
                int i3 = marginLayoutParams.height;
                int i4 = (int) (i3 / S);
                marginLayoutParams.width = i4;
                marginLayoutParams.leftMargin += (i2 - i4) / 2;
                if (i4 != 0) {
                    float f2 = i3 / i4;
                    com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "cardParams ratio: " + f2);
                    kSFrameLayout.setRatio(f2);
                }
            }
            com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
            kSFrameLayout.setLayoutParams(marginLayoutParams);
            float dimension = u().getResources().getDimension(R.dimen.obfuscated_res_0x7f070374);
            WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel = videoPosition.cornerRadius;
            if (kSAdJSCornerModel != null) {
                kSFrameLayout.a((float) kSAdJSCornerModel.topLeft, (float) kSAdJSCornerModel.topRight, (float) kSAdJSCornerModel.bottomRight, (float) kSAdJSCornerModel.bottomLeft);
            } else if (marginLayoutParams.width > marginLayoutParams.height) {
                kSFrameLayout.a(dimension, dimension, 0.0f, 0.0f);
            } else {
                kSFrameLayout.a(dimension, dimension, dimension, dimension);
            }
            if (z) {
                this.w.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                a(marginLayoutParams2, marginLayoutParams3);
                this.w.setLayoutParams(marginLayoutParams3);
                this.j.a(this.a, adInfo, this.m, this.w);
            } else {
                this.w.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                kSFrameLayout.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.kwad.components.ad.interstitial.b.d.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view2, Outline outline) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, outline) == null) {
                            outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                        }
                    }
                });
                kSFrameLayout.setClipToOutline(true);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            i();
            this.s.setClientConfig(this.s.getClientConfig().a(this.m).a(h()));
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.s);
            this.k = aVar;
            a(aVar, str);
            this.s.addJavascriptInterface(this.k, "KwaiAd");
            this.s.loadUrl(str);
            az.a(this.G, null, 3000L);
        }
    }

    public static ViewGroup.LayoutParams b(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = (int) (i2 * (z ? g : h));
            return new ViewGroup.LayoutParams(i3, (int) (i3 * (z ? 1.7777778f : 0.749f)));
        }
        return (ViewGroup.LayoutParams) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, str) == null) {
            com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "handleWebViewError " + str);
            com.kwad.sdk.core.f.d dVar = this.d;
            if (dVar != null) {
                dVar.b(u());
            }
            this.q.removeCallbacksAndMessages(null);
            if (this.n) {
                return;
            }
            this.n = true;
            com.kwad.components.core.i.a a = com.kwad.components.core.i.a.a();
            AdTemplate adTemplate = this.m;
            a.c(adTemplate, com.kwad.sdk.core.response.a.b.t(adTemplate), str);
            this.q.post(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.d.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.j();
                        this.a.j.b();
                    }
                }
            });
        }
    }

    public static ViewGroup.LayoutParams c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            int i3 = (int) (i2 * i);
            return new ViewGroup.LayoutParams((int) (i3 / 0.749f), i3);
        }
        return (ViewGroup.LayoutParams) invokeI.objValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.l = bVar;
            bVar.a(this.j.a);
            int i2 = !com.kwad.sdk.utils.ae.e(this.a) ? 1 : 0;
            com.kwad.sdk.core.webview.b bVar2 = this.l;
            bVar2.a = i2;
            KSFrameLayout kSFrameLayout = this.o;
            bVar2.b = kSFrameLayout;
            bVar2.d = kSFrameLayout;
            bVar2.e = this.s;
            bVar2.c = null;
        }
    }

    @NonNull
    private KsAdWebView.d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.interstitial.b.d.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    this.a.b("1");
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void i() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a();
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            boolean R = com.kwad.sdk.core.response.a.a.R(this.b);
            boolean e = com.kwad.sdk.utils.ae.e(this.a);
            float a = a(e, R);
            com.kwad.sdk.core.d.b.a("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a);
            this.j.e.setRatio(a);
            ViewGroup viewGroup = (ViewGroup) this.o.findViewById(R.id.obfuscated_res_0x7f09106a);
            viewGroup.setVisibility(0);
            viewGroup.post(new Runnable(this, e, R, viewGroup) { // from class: com.kwad.components.ad.interstitial.b.d.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ ViewGroup c;
                public final /* synthetic */ d d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(e), Boolean.valueOf(R), viewGroup};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = this;
                    this.a = e;
                    this.b = R;
                    this.c = viewGroup;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ViewGroup.LayoutParams b = this.a ? d.b(this.d.o.getWidth(), this.b) : d.c(this.d.o.getHeight());
                        this.d.s.setVisibility(8);
                        this.d.p.setVisibility(8);
                        ViewParent parent = this.d.j.e.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.d.j.e);
                        }
                        this.c.addView(this.d.j.e);
                        this.d.j.e.a(b.width, b.height);
                        this.d.v.requestLayout();
                        this.d.D = true;
                    }
                }
            });
        }
    }

    @NonNull
    private y k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) {
            y yVar = new y(new y.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // com.kwad.components.core.webview.jshandler.y.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.I();
                    }
                }
            });
            this.c = yVar;
            return yVar;
        }
        return (y) invokeV.objValue;
    }

    private z l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) ? new z(this.l, this.t) : (z) invokeV.objValue;
    }

    private k m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) {
            com.kwad.components.core.webview.b.kwai.g gVar = new com.kwad.components.core.webview.b.kwai.g();
            gVar.b = this.j.n;
            return new k(gVar);
        }
        return (k) invokeV.objValue;
    }

    private com.kwad.components.core.webview.jshandler.h n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, this)) == null) {
            com.kwad.components.core.webview.jshandler.h hVar = new com.kwad.components.core.webview.jshandler.h(this.l);
            hVar.a(new h.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // com.kwad.components.core.webview.jshandler.h.b
                public final void a(h.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.b = com.kwad.sdk.b.kwai.a.b(this.a.a);
                        aVar.a = com.kwad.sdk.b.kwai.a.b(this.a.a);
                    }
                }
            });
            return hVar;
        }
        return (com.kwad.components.core.webview.jshandler.h) invokeV.objValue;
    }

    private com.kwad.components.ad.f.kwai.kwai.a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) {
            com.kwad.components.ad.f.kwai.kwai.a a = com.kwad.components.ad.f.kwai.kwai.a.a(this.m);
            this.C = a;
            if (a != null) {
                a.a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.23
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

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

                    @Override // com.kwad.components.ad.f.kwai.kwai.a.b
                    public final void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            if (i2 == com.kwad.components.ad.f.kwai.kwai.a.b) {
                                this.a.j.a(this.a.u(), this.a.m);
                                this.a.j.a(true, this.a.j.l);
                            }
                            this.a.F();
                        }
                    }
                });
            }
            return this.C;
        }
        return (com.kwad.components.ad.f.kwai.kwai.a) invokeV.objValue;
    }

    private com.kwad.components.core.webview.b.y w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) {
            com.kwad.components.core.webview.b.y yVar = new com.kwad.components.core.webview.b.y();
            yVar.a(new y.a(this) { // from class: com.kwad.components.ad.interstitial.b.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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

                @Override // com.kwad.components.core.webview.b.y.a
                public final void a(com.kwad.components.core.webview.b.kwai.h hVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar) == null) {
                        this.a.v.setVideoSoundEnable(!hVar.a);
                    }
                }
            });
            return yVar;
        }
        return (com.kwad.components.core.webview.b.y) invokeV.objValue;
    }

    @NonNull
    private s x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, this)) == null) ? new s(this) { // from class: com.kwad.components.ad.interstitial.b.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.b.m, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    com.kwad.components.core.webview.b.kwai.h hVar = new com.kwad.components.core.webview.b.kwai.h();
                    hVar.a = !this.a.x.isVideoSoundEnable();
                    cVar.a(hVar);
                }
            }
        } : (s) invokeV.objValue;
    }

    @NonNull
    private o y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, this)) == null) ? new o(this.l, new o.b(this) { // from class: com.kwad.components.ad.interstitial.b.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.webview.jshandler.o.b
            public final void a(o.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        }) : (o) invokeV.objValue;
    }

    private a.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, this)) == null) {
            a.b bVar = new a.b(this, new q()) { // from class: com.kwad.components.ad.interstitial.b.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ q a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = r7;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                        q qVar = this.a;
                        qVar.b = false;
                        qVar.c = false;
                        qVar.a = (int) Math.ceil(((float) j) / 1000.0f);
                        this.b.A.a(this.a);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void f_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        q qVar = this.a;
                        qVar.b = false;
                        qVar.c = false;
                        qVar.a = 0;
                        this.b.A.a(this.a);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void g_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (this.b.y.getVisibility() == 0) {
                            this.b.y.setVisibility(8);
                        }
                        q qVar = this.a;
                        qVar.b = false;
                        qVar.c = false;
                        qVar.a = (int) Math.ceil(((float) this.b.v.getCurrentPosition()) / 1000.0f);
                        this.b.A.a(this.a);
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void h_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        q qVar = this.a;
                        qVar.b = false;
                        qVar.c = true;
                        this.a.a = com.kwad.sdk.core.response.a.a.c(com.kwad.sdk.core.response.a.d.i(this.b.l.a()));
                        this.b.A.a(this.a);
                    }
                }
            };
            this.z = bVar;
            return bVar;
        }
        return (a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) t();
            this.j = cVar;
            this.D = false;
            this.r = cVar.c;
            this.x = cVar.j;
            this.t = cVar.d;
            AdTemplate adTemplate = cVar.a;
            this.m = adTemplate;
            this.b = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.v = this.j.l;
            this.E.a(this.F);
            this.E.b();
            g();
            J();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            com.kwad.components.ad.f.kwai.kwai.a aVar = this.C;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e();
            com.kwad.components.ad.f.kwai.kwai.a aVar = this.C;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e_();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.i_();
            KsAdWebView ksAdWebView = (KsAdWebView) q().findViewById(R.id.obfuscated_res_0x7f0911ec);
            this.s = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.s.setVisibility(4);
            this.E = new com.kwad.components.core.widget.kwai.b(this.s, 100);
            this.o = (KSFrameLayout) q().findViewById(R.id.obfuscated_res_0x7f09101b);
            this.p = (KSFrameLayout) q().findViewById(R.id.obfuscated_res_0x7f0911c3);
            this.y = (ImageView) q().findViewById(R.id.obfuscated_res_0x7f0911d3);
            this.w = (ImageView) q().findViewById(R.id.obfuscated_res_0x7f091072);
            Context u = u();
            this.a = u;
            if (u != null) {
                this.e = (Vibrator) u.getSystemService("vibrator");
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.k_();
            this.q.removeCallbacksAndMessages(null);
            this.E.b(this.F);
            this.E.c();
            com.kwad.sdk.core.f.d dVar = this.d;
            if (dVar != null) {
                dVar.b(u());
            }
        }
    }
}
