package com.kwad.sdk.contentalliance.detail.ad.presenter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34498b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f34499c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34500d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34501e;

    /* renamed from: f  reason: collision with root package name */
    public AdStyleInfo.PlayEndInfo.AdWebCardInfo f34502f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34503g;

    /* renamed from: h  reason: collision with root package name */
    public int f34504h;

    /* renamed from: i  reason: collision with root package name */
    public g f34505i;
    public com.kwad.sdk.core.webview.a j;
    public int k;
    public n l;
    public boolean m;
    public e n;
    public com.kwad.sdk.contentalliance.a.a o;
    public long p;
    public q.a q;
    public h.a r;
    public k.b s;

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.b$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f34507a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f34508b;

        public AnonymousClass2(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34508b = bVar;
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f34508b.f34504h = 0;
                this.f34508b.f34499c.setVisibility(4);
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f34507a = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f34509a;

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
                        this.f34509a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f34509a.f34508b.f34499c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            AnonymousClass2 anonymousClass2 = this.f34509a;
                            anonymousClass2.f34507a = null;
                            anonymousClass2.f34508b.g();
                        }
                    }
                };
                this.f34508b.f34499c.getViewTreeObserver().addOnGlobalLayoutListener(this.f34507a);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.j();
                a();
                b();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.k();
                a();
                this.f34508b.p();
                if (this.f34507a != null) {
                    this.f34508b.f34499c.getViewTreeObserver().removeOnGlobalLayoutListener(this.f34507a);
                }
            }
        }
    }

    public b() {
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
        this.f34504h = 0;
        this.k = -1;
        this.n = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34506a;

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
                this.f34506a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b.a(this.f34506a);
                    int h2 = com.kwad.sdk.core.response.b.b.h(this.f34506a.f34500d);
                    if (h2 <= 0) {
                        h2 = 1;
                    }
                    if (((com.kwad.sdk.contentalliance.detail.b) this.f34506a).f34553a.b()) {
                        if (this.f34506a.f34501e == null) {
                            return;
                        }
                    } else if (this.f34506a.f34504h == 1 || (this.f34506a.f34504h - 1) % h2 == 0) {
                        this.f34506a.q();
                        return;
                    } else if (this.f34506a.f34501e == null) {
                        return;
                    }
                    this.f34506a.f34501e.h();
                }
            }
        };
        this.o = new AnonymousClass2(this);
        this.q = new q.a(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34510a;

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
                this.f34510a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.q.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f34510a.f34501e != null) {
                        this.f34510a.f34501e.h();
                    }
                    this.f34510a.r();
                }
            }
        };
        this.r = new h.a(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34511a;

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
                this.f34511a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34511a.r();
                }
            }
        };
        this.s = new k.b(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34512a;

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
                this.f34512a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f34512a.k = i4;
                    com.kwad.sdk.core.d.a.b("AdPlayEndWebPresenter", "position:" + ((com.kwad.sdk.contentalliance.detail.b) this.f34512a).f34553a.f34582i + " load time:" + (System.currentTimeMillis() - this.f34512a.p));
                }
            }
        };
    }

    public static /* synthetic */ int a(b bVar) {
        int i2 = bVar.f34504h;
        bVar.f34504h = i2 + 1;
        return i2;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f34503g, null));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
            gVar.a(new c(this.j));
            gVar.a(new k(this.s));
            n nVar = new n();
            this.l = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.j, this.f34503g));
            gVar.a(new h(this.r));
            gVar.a(new j(this.j));
            gVar.a(new q(this.q));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.a aVar = this.j;
            aVar.f36790b = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            aVar.f36789a = 0;
            AdBaseFrameLayout adBaseFrameLayout = this.f34498b;
            aVar.f36791c = adBaseFrameLayout;
            aVar.f36793e = adBaseFrameLayout;
            aVar.f36794f = this.f34499c;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f34499c.setVisibility(4);
            this.f34499c.setBackgroundColor(0);
            this.f34499c.getBackground().setAlpha(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f34499c.setVisibility(4);
            h();
            this.k = -1;
            this.p = System.currentTimeMillis();
            this.f34499c.loadUrl(this.f34502f.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            p();
            ar.a(this.f34499c);
            g gVar = new g(this.f34499c);
            this.f34505i = gVar;
            a(gVar);
            this.f34499c.addJavascriptInterface(this.f34505i, "KwaiAd");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (gVar = this.f34505i) == null) {
            return;
        }
        gVar.a();
        this.f34505i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (this.k != 1) {
                s();
                return;
            }
            n nVar = this.l;
            if (nVar != null) {
                nVar.c();
            }
            this.f34499c.setVisibility(0);
            n nVar2 = this.l;
            if (nVar2 != null) {
                nVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && ao.a((View) this.f34499c, 50, false)) {
            n nVar = this.l;
            if (nVar != null) {
                nVar.e();
            }
            this.f34499c.setVisibility(4);
            n nVar2 = this.l;
            if (nVar2 != null) {
                nVar2.f();
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            int i2 = this.k;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("AdPlayEndWebPresenter", "show webCard fail, reason: " + str);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.f34500d = adTemplate;
            this.m = !com.kwad.sdk.core.response.b.b.p(adTemplate);
            this.f34499c.setVisibility(8);
            if (this.m) {
                return;
            }
            this.f34502f = com.kwad.sdk.core.response.b.b.q(this.f34500d).playEndInfo.adWebCardInfo;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34501e = cVar.m;
            this.f34503g = cVar.o;
            if (this.j == null) {
                this.j = new com.kwad.sdk.core.webview.a();
                f();
            }
            e();
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.f34501e;
            if (bVar != null) {
                bVar.a(this.n);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (this.m) {
                return;
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.f34501e;
            if (bVar != null) {
                bVar.b(this.n);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34498b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34499c = (WebView) b(R.id.ksad_play_end_web_card);
        }
    }
}
