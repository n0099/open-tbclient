package com.kwad.sdk.d.kwai;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.a.j;
import com.kwad.sdk.core.webview.a.k;
import com.kwad.sdk.core.webview.a.n;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.aa;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.u;
import com.kwad.sdk.d.kwai.c;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static float f58262c = 0.61f;

    /* renamed from: d  reason: collision with root package name */
    public static float f58263d = 0.8f;

    /* renamed from: e  reason: collision with root package name */
    public static float f58264e = 0.768f;

    /* renamed from: f  reason: collision with root package name */
    public static float f58265f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f58266g = 0.749f;

    /* renamed from: h  reason: collision with root package name */
    public static float f58267h = 0.637f;
    public transient /* synthetic */ FieldHolder $fh;
    public k A;
    public s B;
    @Nullable
    public u C;
    public boolean D;
    public com.kwad.sdk.core.j.f E;
    public com.kwad.sdk.core.j.d F;
    public final Runnable G;
    public p.b H;
    @NonNull
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f58268b;

    /* renamed from: i  reason: collision with root package name */
    public c f58269i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f58270j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58271k;
    public AdTemplate l;
    public boolean m;
    public KSFrameLayout n;
    public KSFrameLayout o;
    public Handler p;
    public Dialog q;
    public KsAdWebView r;
    @Nullable
    public com.kwad.sdk.core.download.a.b s;
    public int t;
    public List<Integer> u;
    public com.kwad.sdk.core.video.videoview.b v;
    public ImageView w;
    @NonNull
    public KsAdVideoPlayConfig x;
    public ImageView y;
    public a.b z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1144122740, "Lcom/kwad/sdk/d/kwai/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1144122740, "Lcom/kwad/sdk/d/kwai/d;");
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
        this.p = new Handler(Looper.getMainLooper());
        this.t = -1;
        this.D = false;
        this.F = new com.kwad.sdk.core.j.e(this) { // from class: com.kwad.sdk.d.kwai.d.1
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

            @Override // com.kwad.sdk.core.j.e, com.kwad.sdk.core.j.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onPageVisible");
                    if (this.a.B != null) {
                        this.a.B.c();
                        this.a.B.d();
                    }
                }
            }

            @Override // com.kwad.sdk.core.j.e, com.kwad.sdk.core.j.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onPageInvisible");
                    if (this.a.B != null) {
                        this.a.B.e();
                        this.a.B.f();
                    }
                }
            }
        };
        this.G = new Runnable(this) { // from class: com.kwad.sdk.d.kwai.d.12
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
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "rollBackRunnable run");
                    this.a.r();
                    this.a.f58269i.b();
                }
            }
        };
        this.H = new p.b(this) { // from class: com.kwad.sdk.d.kwai.d.11
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

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.a.m || this.a.D) {
                    return;
                }
                this.a.t = aVar.a;
                if (this.a.t != 1) {
                    this.a.b("3");
                    return;
                }
                this.a.r.setVisibility(0);
                com.kwad.sdk.core.report.d.a(this.a.l);
                this.a.p.removeCallbacksAndMessages(null);
                ax.b(this.a.G);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.d.kwai.d.4
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

            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) {
                    com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + this.a.D);
                    if (this.a.D || (adInfo = this.a.f58268b) == null || !com.kwad.sdk.core.response.a.a.P(adInfo)) {
                        return;
                    }
                    c cVar = this.a.f58269i;
                    d dVar = this.a;
                    boolean a = cVar.a(dVar.a, dVar.f58268b);
                    d dVar2 = this.a;
                    dVar2.a(dVar2.f58268b, videoPosition, dVar2.o, a);
                    this.a.o.setVisibility(0);
                    this.a.r.setVisibility(0);
                }
            }
        }) : (WebCardVideoPositionHandler) invokeV.objValue;
    }

    private aa B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            aa aaVar = new aa(q(), this.l);
            aaVar.a(new aa.a(this) { // from class: com.kwad.sdk.d.kwai.d.5
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

                @Override // com.kwad.sdk.core.webview.jshandler.aa.a
                public boolean a() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.a.A != null) {
                            this.a.A.a(false);
                        }
                        ax.a(new Runnable(this) { // from class: com.kwad.sdk.d.kwai.d.5.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass5 a;

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
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.a.q == null) {
                                    return;
                                }
                                this.a.a.q.dismiss();
                                if (this.a.a.f58269i.f58249b != null) {
                                    this.a.a.f58269i.f58249b.onAdClosed();
                                }
                            }
                        });
                        boolean z = !this.a.f58269i.f58257j;
                        if (z) {
                            this.a.f58269i.a(true, this.a.f58269i.f58256i);
                        }
                        return z;
                    }
                    return invokeV2.booleanValue;
                }
            });
            return aaVar;
        }
        return (aa) invokeV.objValue;
    }

    @NonNull
    private i C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new i(new i.b(this) { // from class: com.kwad.sdk.d.kwai.d.6
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

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.a.q == null) {
                    return;
                }
                this.a.p.post(new Runnable(this, i2) { // from class: com.kwad.sdk.d.kwai.d.6.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass6 f58273b;

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
                        this.f58273b = this;
                        this.a = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.f58273b.a.q.dismiss();
                            this.f58273b.a.f58269i.a(this.a == 3, this.f58273b.a.v);
                            if (this.f58273b.a.f58269i.f58249b != null) {
                                this.f58273b.a.f58269i.f58249b.onAdClosed();
                            }
                        }
                    }
                });
            }
        }) : (i) invokeV.objValue;
    }

    private k D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            k kVar = new k(this) { // from class: com.kwad.sdk.d.kwai.d.7
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

                @Override // com.kwad.sdk.core.webview.a.i, com.kwad.sdk.core.webview.kwai.a
                public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        if (this.a.v.d()) {
                            com.kwad.sdk.core.webview.a.kwai.f fVar = new com.kwad.sdk.core.webview.a.kwai.f();
                            fVar.f57967b = false;
                            fVar.f57968c = false;
                            fVar.a = 0;
                            cVar.a(fVar);
                        }
                        if (this.a.v.i()) {
                            com.kwad.sdk.core.webview.a.kwai.f fVar2 = new com.kwad.sdk.core.webview.a.kwai.f();
                            fVar2.f57967b = false;
                            fVar2.f57968c = true;
                            fVar2.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(this.a.f58271k.a()));
                            cVar.a(fVar2);
                        }
                    }
                }
            };
            this.A = kVar;
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.video.videoview.b bVar = this.f58269i.f58256i;
            if (bVar != null) {
                bVar.k();
            }
            this.f58269i.f58250c.dismiss();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f58269i.f58249b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new com.kwad.sdk.core.webview.jshandler.a(this.f58271k, this.s, new b.c(this) { // from class: com.kwad.sdk.d.kwai.d.8
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

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (this.a.f58269i.f58249b != null) {
                    this.a.f58269i.f58249b.onAdClicked();
                }
                if (this.a.f58269i.f58250c == null || !com.kwad.sdk.core.config.b.aC()) {
                    return;
                }
                this.a.f58269i.f58250c.dismiss();
            }
        }) : (com.kwad.sdk.core.webview.jshandler.a) invokeV.objValue;
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.b G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new com.kwad.sdk.core.webview.jshandler.b(this.f58271k, this.s, new b.c(this) { // from class: com.kwad.sdk.d.kwai.d.9
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

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (this.a.f58269i.f58249b != null) {
                    this.a.f58269i.f58249b.onAdClicked();
                }
                if (this.a.f58269i.f58250c == null || !com.kwad.sdk.core.config.b.aC()) {
                    return;
                }
                this.a.f58269i.f58250c.dismiss();
            }
        }) : (com.kwad.sdk.core.webview.jshandler.b) invokeV.objValue;
    }

    public static float a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z && z2) {
                return 1.7777778f;
            }
            if (z) {
                return 0.749f;
            }
            return s();
        }
        return invokeCommon.floatValue;
    }

    public static ViewGroup.LayoutParams a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            boolean z2 = com.kwad.sdk.core.config.b.q() == 0;
            int i3 = (int) (i2 * (z ? z2 ? f58263d : f58262c : z2 ? f58265f : f58264e));
            return new ViewGroup.LayoutParams(i3, (int) (i3 * (z ? 1.7777778f : 0.749f)));
        }
        return (ViewGroup.LayoutParams) invokeCommon.objValue;
    }

    public static ViewGroup.MarginLayoutParams a(Context context, WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, videoPosition, marginLayoutParams)) == null) {
            marginLayoutParams.topMargin = videoPosition.topMargin;
            marginLayoutParams.leftMargin = videoPosition.leftMargin;
            marginLayoutParams.width = videoPosition.width;
            marginLayoutParams.height = videoPosition.height;
            return marginLayoutParams;
        }
        return (ViewGroup.MarginLayoutParams) invokeLLL.objValue;
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, marginLayoutParams, marginLayoutParams2) == null) {
            marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
            marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
            marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
            marginLayoutParams2.width = marginLayoutParams.width;
            marginLayoutParams2.height = marginLayoutParams.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{adInfo, videoPosition, kSFrameLayout, Boolean.valueOf(z)}) == null) {
            kSFrameLayout.setWidthBasedRatio(!z);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + marginLayoutParams.height);
            a(this.a, videoPosition, marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
            float L = com.kwad.sdk.core.response.a.a.L(adInfo);
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + L);
            if (z && L > 0.0f) {
                int i2 = marginLayoutParams.width;
                int i3 = marginLayoutParams.height;
                int i4 = (int) (i3 / L);
                marginLayoutParams.width = i4;
                marginLayoutParams.leftMargin += (i2 - i4) / 2;
                if (i4 != 0) {
                    float f2 = i3 / i4;
                    com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "cardParams ratio: " + f2);
                    kSFrameLayout.setRatio(f2);
                }
            }
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
            kSFrameLayout.setLayoutParams(marginLayoutParams);
            if (z) {
                this.w.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                a(marginLayoutParams2, marginLayoutParams3);
                this.w.setLayoutParams(marginLayoutParams3);
                this.f58269i.a(this.a, adInfo, this.l, this.w);
            } else {
                this.w.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                kSFrameLayout.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.kwad.sdk.d.kwai.d.10
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
                    public void getOutline(View view, Outline outline) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view, outline) == null) {
                            outline.setRect(0, 0, view.getWidth(), view.getHeight());
                        }
                    }
                });
                kSFrameLayout.setClipToOutline(true);
            }
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, gVar) == null) {
            gVar.a(G());
            gVar.a(F());
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(y());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f58271k));
            gVar.a(x());
            gVar.a(w());
            gVar.a(C());
            s sVar = new s();
            this.B = sVar;
            gVar.a(sVar);
            this.f58269i.a(z());
            gVar.a(D());
            gVar.a(A());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58271k));
            gVar.a(u());
            gVar.a(new p(this.H));
            gVar.a(t());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f58271k));
            gVar.a(B());
            if (v() != null) {
                gVar.a(this.C);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            i();
            be.b(this.r);
            this.r.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.d.kwai.d.14
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

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.a.b("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.r);
            this.f58270j = gVar;
            a(gVar);
            this.r.addJavascriptInterface(this.f58270j, "KwaiAd");
            this.r.loadUrl(str);
            ax.a(this.G, null, 3000L);
        }
    }

    public static ViewGroup.LayoutParams b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            boolean z = com.kwad.sdk.core.config.b.q() == 0;
            float f2 = z ? 0.749f : 0.8f;
            int i3 = (int) (i2 * (z ? f58266g : f58267h));
            return new ViewGroup.LayoutParams((int) (i3 / f2), i3);
        }
        return (ViewGroup.LayoutParams) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "handleWebViewError " + str);
            this.p.removeCallbacksAndMessages(null);
            if (this.m) {
                return;
            }
            this.m = true;
            AdTemplate adTemplate = this.l;
            com.kwad.sdk.core.report.d.c(adTemplate, com.kwad.sdk.core.response.a.b.n(adTemplate), str);
            this.p.post(new Runnable(this) { // from class: com.kwad.sdk.d.kwai.d.15
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
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.r();
                        this.a.f58269i.b();
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f58271k = aVar;
            aVar.a(this.f58269i.a);
            com.kwad.sdk.core.webview.a aVar2 = this.f58271k;
            aVar2.a = 0;
            aVar2.f57955b = null;
            aVar2.f57957d = this.n;
            aVar2.f57958e = this.r;
            aVar2.f57956c = null;
        }
    }

    private void i() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (gVar = this.f58270j) == null) {
            return;
        }
        gVar.a();
        this.f58270j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            boolean K = com.kwad.sdk.core.response.a.a.K(this.f58268b);
            boolean e2 = af.e(this.a);
            float a = a(e2, K);
            this.f58269i.f58252e.setRatio(a);
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a);
            ViewGroup.LayoutParams a2 = e2 ? a(bb.b(this.a), K) : b(bb.a(this.a));
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.n.findViewById(R.id.ksad_interstitial_native);
            viewGroup.setVisibility(0);
            ViewParent parent = this.f58269i.f58252e.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f58269i.f58252e);
            }
            viewGroup.addView(this.f58269i.f58252e);
            this.f58269i.f58252e.a(a2.width, a2.height);
            this.v.requestLayout();
            this.D = true;
        }
    }

    public static float s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return com.kwad.sdk.core.config.b.q() == 0 ? 0.749f : 0.8f;
        }
        return invokeV.floatValue;
    }

    private t t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) ? new t(this.f58271k, this.s) : (t) invokeV.objValue;
    }

    private com.kwad.sdk.core.webview.jshandler.d u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) {
            com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.f58271k);
            dVar.a(new d.b(this) { // from class: com.kwad.sdk.d.kwai.d.16
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

                @Override // com.kwad.sdk.core.webview.jshandler.d.b
                public void a(d.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f57994b = bb.a(this.a.a);
                        aVar.a = bb.a(this.a.a);
                    }
                }
            });
            return dVar;
        }
        return (com.kwad.sdk.core.webview.jshandler.d) invokeV.objValue;
    }

    private u v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) {
            u a = u.a(q(), this.l);
            this.C = a;
            if (a != null) {
                a.a(new u.b(this) { // from class: com.kwad.sdk.d.kwai.d.17
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

                    @Override // com.kwad.sdk.core.webview.jshandler.u.b
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            if (i2 == u.f58078b) {
                                this.a.f58269i.a(this.a.q(), this.a.l);
                                this.a.f58269i.a(true, this.a.f58269i.f58256i);
                            }
                            this.a.E();
                        }
                    }
                });
            }
            return this.C;
        }
        return (u) invokeV.objValue;
    }

    private n w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            n nVar = new n();
            nVar.a(new n.a(this) { // from class: com.kwad.sdk.d.kwai.d.18
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

                @Override // com.kwad.sdk.core.webview.a.n.a
                public void a(com.kwad.sdk.core.webview.a.kwai.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        this.a.v.setVideoSoundEnable(!bVar.a);
                    }
                }
            });
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    @NonNull
    private j x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) ? new j(this) { // from class: com.kwad.sdk.d.kwai.d.19
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

            @Override // com.kwad.sdk.core.webview.a.i, com.kwad.sdk.core.webview.kwai.a
            public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    com.kwad.sdk.core.webview.a.kwai.b bVar = new com.kwad.sdk.core.webview.a.kwai.b();
                    bVar.a = !this.a.x.isVideoSoundEnable();
                    cVar.a(bVar);
                }
            }
        } : (j) invokeV.objValue;
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.j y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, this)) == null) ? new com.kwad.sdk.core.webview.jshandler.j(this.f58271k, new j.b(this) { // from class: com.kwad.sdk.d.kwai.d.2
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

            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        }) : (com.kwad.sdk.core.webview.jshandler.j) invokeV.objValue;
    }

    private a.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, this)) == null) {
            a.b bVar = new a.b(this, new com.kwad.sdk.core.webview.a.kwai.f()) { // from class: com.kwad.sdk.d.kwai.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.a.kwai.f a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f58272b;

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
                    this.f58272b = this;
                    this.a = r7;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                        com.kwad.sdk.core.webview.a.kwai.f fVar = this.a;
                        fVar.f57967b = false;
                        fVar.f57968c = false;
                        fVar.a = (int) Math.ceil(((float) j2) / 1000.0f);
                        this.f58272b.A.a(this.a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.webview.a.kwai.f fVar = this.a;
                        fVar.f57967b = false;
                        fVar.f57968c = false;
                        fVar.a = 0;
                        this.f58272b.A.a(this.a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (this.f58272b.y.getVisibility() == 0) {
                            this.f58272b.y.setVisibility(8);
                        }
                        com.kwad.sdk.core.webview.a.kwai.f fVar = this.a;
                        fVar.f57967b = false;
                        fVar.f57968c = false;
                        fVar.a = (int) Math.ceil(((float) this.f58272b.v.getCurrentPosition()) / 1000.0f);
                        this.f58272b.A.a(this.a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.webview.a.kwai.f fVar = this.a;
                        fVar.f57967b = false;
                        fVar.f57968c = true;
                        this.a.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(this.f58272b.f58271k.a()));
                        this.f58272b.A.a(this.a);
                    }
                }
            };
            this.z = bVar;
            return bVar;
        }
        return (a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) p();
            this.f58269i = cVar;
            this.D = false;
            this.q = cVar.f58250c;
            this.x = cVar.f58254g;
            this.s = cVar.f58251d;
            AdTemplate adTemplate = cVar.a;
            this.l = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f58268b = j2;
            this.u = com.kwad.sdk.core.response.a.a.S(j2);
            this.v = this.f58269i.f58256i;
            this.E.a(this.F);
            this.E.a();
            f();
            e();
            this.f58269i.a(new c.b(this) { // from class: com.kwad.sdk.d.kwai.d.13
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

                @Override // com.kwad.sdk.d.kwai.c.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.t == 1) {
                        this.a.r.reload();
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
            this.p.removeCallbacksAndMessages(null);
            this.E.b(this.F);
            this.E.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            KsAdWebView ksAdWebView = (KsAdWebView) m().findViewById(R.id.ksad_web_card_webView);
            this.r = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.r.setVisibility(4);
            this.E = new com.kwad.sdk.core.j.f(this.r, 70);
            this.n = (KSFrameLayout) m().findViewById(R.id.ksad_container);
            this.o = (KSFrameLayout) m().findViewById(R.id.ksad_video_container);
            this.y = (ImageView) m().findViewById(R.id.ksad_video_first_frame_container);
            this.w = (ImageView) m().findViewById(R.id.ksad_interstitial_video_blur);
            this.a = q();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d_();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String n = com.kwad.sdk.core.response.a.b.n(this.l);
            if (TextUtils.isEmpty(n)) {
                b("1");
            } else {
                a(n);
            }
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g();
            u uVar = this.C;
            if (uVar != null) {
                uVar.e();
            }
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.h();
            u uVar = this.C;
            if (uVar != null) {
                uVar.d();
            }
        }
    }
}
