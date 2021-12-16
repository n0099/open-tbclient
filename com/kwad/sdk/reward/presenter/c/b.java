package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.x;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.c;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.e;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class b extends g implements b.c, c.a, e.a, com.kwad.sdk.widget.d, Observer {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static float f59707b = 0.4548105f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59708c;

    /* renamed from: d  reason: collision with root package name */
    public d f59709d;

    /* renamed from: e  reason: collision with root package name */
    public e f59710e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.b.a.a f59711f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f59712g;

    /* renamed from: h  reason: collision with root package name */
    public a f59713h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f59714i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f59715j;

    /* renamed from: k  reason: collision with root package name */
    public int f59716k;
    public long l;
    public boolean m;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.download.a.c implements j.b, p.b, Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public View f59719b;

        /* renamed from: c  reason: collision with root package name */
        public KsAdWebView f59720c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f59721d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f59722e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f59723f;

        /* renamed from: g  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f59724g;

        /* renamed from: h  reason: collision with root package name */
        public x f59725h;

        /* renamed from: i  reason: collision with root package name */
        public b.c f59726i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2118b f59727j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        public AdTemplate f59728k;

        public a(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView, view, bVar, aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59719b = view;
            this.f59720c = ksAdWebView;
            this.f59723f = bVar;
            this.f59724g = aVar;
            this.f59726i = cVar;
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, gVar) == null) {
                gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59721d, this.f59723f, this.f59726i));
                gVar.a(new f(this.f59721d));
                gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59721d));
                gVar.a(new p(this));
                x xVar = new x();
                this.f59725h = xVar;
                gVar.a(xVar);
                gVar.a(new k(this.f59721d));
                gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59721d));
                gVar.a(new com.kwad.sdk.core.webview.a.g());
                gVar.a(new j(this.f59721d, this));
                gVar.a(new t(this.f59721d, this.f59723f));
            }
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
                if (at.a(str)) {
                    c();
                    return;
                }
                d();
                be.b(this.f59720c);
                this.f59720c.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.presenter.c.b.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onReceivedHttpError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                            this.a.c();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }
                });
                com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59720c);
                this.f59722e = gVar;
                a(gVar);
                this.f59720c.addJavascriptInterface(this.f59722e, "KwaiAd");
                this.f59720c.loadUrl(str);
            }
        }

        private void a(String str, int i2) {
            InterfaceC2118b interfaceC2118b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i2) == null) || (interfaceC2118b = this.f59727j) == null) {
                return;
            }
            interfaceC2118b.a(str, i2);
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65541, this, adTemplate, viewGroup) == null) {
                com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
                this.f59721d = aVar;
                aVar.a(adTemplate);
                com.kwad.sdk.core.webview.a aVar2 = this.f59721d;
                aVar2.a = 0;
                aVar2.f58536b = null;
                aVar2.f58538d = viewGroup;
                aVar2.f58539e = this.f59720c;
                aVar2.f58537c = null;
                aVar2.f58542h = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, this) == null) {
                View view = this.f59719b;
                if (view != null) {
                    view.setVisibility(0);
                }
                a(false);
            }
        }

        private void d() {
            com.kwad.sdk.core.webview.kwai.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (gVar = this.f59722e) == null) {
                return;
            }
            gVar.a();
            this.f59722e = null;
        }

        @Override // com.kwad.sdk.core.download.a.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, viewGroup) == null) {
                KsAdWebView ksAdWebView = this.f59720c;
                if (ksAdWebView != null) {
                    ksAdWebView.setBackgroundColor(0);
                    if (this.f59720c.getBackground() != null) {
                        this.f59720c.getBackground().setAlpha(0);
                    }
                }
                this.f59728k = adTemplate;
                b(adTemplate, viewGroup);
                a(com.kwad.sdk.core.response.a.b.b(this.f59728k));
                com.kwad.sdk.reward.b.a.a aVar = this.f59724g;
                if (aVar != null) {
                    aVar.addObserver(this);
                }
                this.f59723f.a(this);
            }
        }

        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(@NonNull j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onAdFrameValid : " + aVar.toJson());
            }
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
                if (aVar.a == 1) {
                    a(true);
                } else {
                    c();
                }
            }
        }

        public void a(InterfaceC2118b interfaceC2118b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC2118b) == null) {
                this.f59727j = interfaceC2118b;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "switchWebView: " + z);
                KsAdWebView ksAdWebView = this.f59720c;
                if (ksAdWebView == null) {
                    return;
                }
                ksAdWebView.setVisibility(z ? 0 : 8);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                com.kwad.sdk.reward.b.a.a aVar = this.f59724g;
                if (aVar != null) {
                    aVar.deleteObserver(this);
                }
                this.f59723f.b(this);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                AdTemplate adTemplate = this.f59728k;
                a(adTemplate != null ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即下载", 100);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                AdTemplate adTemplate = this.f59728k;
                a(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.a(adTemplate), 100);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                AdTemplate adTemplate = this.f59728k;
                a(adTemplate != null ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即下载", 100);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                AdTemplate adTemplate = this.f59728k;
                a(adTemplate != null ? com.kwad.sdk.core.response.a.a.m(com.kwad.sdk.core.response.a.d.j(adTemplate)) : "立即打开", 100);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, observable, obj) == null) {
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "BottomCardWebViewHelper update: " + obj);
                if (obj instanceof Boolean) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    x xVar = this.f59725h;
                    if (xVar != null) {
                        xVar.a(booleanValue);
                    }
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.reward.presenter.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2118b {
        void a(String str, int i2);
    }

    /* loaded from: classes3.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (!f() || af.e(q())) ? 8 : 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(KsAdWebView ksAdWebView, View view, com.kwad.sdk.core.download.a.b bVar, com.kwad.sdk.reward.b.a.a aVar, b.c cVar) {
            super(ksAdWebView, view, bVar, aVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView, view, bVar, aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((KsAdWebView) objArr2[0], (View) objArr2[1], (com.kwad.sdk.core.download.a.b) objArr2[2], (com.kwad.sdk.reward.b.a.a) objArr2[3], (b.c) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-382286031, "Lcom/kwad/sdk/reward/presenter/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-382286031, "Lcom/kwad/sdk/reward/presenter/c/b;");
        }
    }

    public b() {
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
        this.f59716k = 15;
        this.l = -1L;
        this.m = false;
        a((Presenter) new c());
    }

    private void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view, z) == null) {
            ((g) this).a.a(q(), z ? 1 : 153, 1);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adBaseFrameLayout) == null) {
            if (!af.e(q())) {
                com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) a(R.id.ksad_reward_apk_info_stub)).inflate();
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
            this.f59712g = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.f59712g, this);
            KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.ksad_reward_apk_info_card_root);
            kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
            kSFrameLayout.post(new Runnable(this, kSFrameLayout, q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height)) { // from class: com.kwad.sdk.reward.presenter.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSFrameLayout a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ float f59717b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f59718c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, kSFrameLayout, Float.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59718c = this;
                    this.a = kSFrameLayout;
                    this.f59717b = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.getHeight();
                    }
                }
            });
            this.f59712g = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f59712g);
            this.f59714i = cVar;
            cVar.a(this);
            this.f59714i.a(((g) this).a.f59455g, false);
            a aVar = new a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f59712g, ((g) this).a.l, this.f59711f, this);
            this.f59713h = aVar;
            aVar.a(new InterfaceC2118b(this) { // from class: com.kwad.sdk.reward.presenter.c.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.sdk.reward.presenter.c.b.InterfaceC2118b
                public void a(String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                        int i3 = com.kwad.sdk.core.response.a.d.j(((g) this.a).a.f59455g).status;
                        com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i3);
                        boolean z = true;
                        this.a.f59714i.a(str, i2, (i3 == 1 || i3 == 2 || i3 == 3) ? false : false);
                    }
                }
            });
            this.f59713h.a(((g) this).a.f59455g, adBaseFrameLayout);
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.m + " completed: " + z);
            if (this.m) {
                return;
            }
            u.a(q(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
            if (z) {
                this.m = true;
            }
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.l);
            return this.l >= 0 && System.currentTimeMillis() - this.l > ((long) (this.f59716k * 1000));
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onBind");
            if (com.kwad.sdk.core.response.a.d.u(((g) this).a.f59455g)) {
                this.f59716k = com.kwad.sdk.core.config.b.az();
                com.kwad.sdk.utils.x.a().addObserver(this);
                com.kwad.sdk.reward.b.a.a a2 = com.kwad.sdk.reward.b.c.a();
                this.f59711f = a2;
                ((g) this).a.y = a2;
                a2.g();
                com.kwad.sdk.reward.b.a.a.a(this.f59711f, q(), ((g) this).a.f59455g);
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
                this.f59708c = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
                com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f59708c);
                this.f59715j = cVar;
                cVar.a(this);
                this.f59715j.a(((g) this).a.f59455g, false);
                ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
                d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f59708c, ((g) this).a.l, this.f59711f, this);
                this.f59709d = dVar;
                dVar.a(((g) this).a.f59455g, adBaseFrameLayout);
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((g) this).a.f59455g);
                e eVar = this.f59710e;
                if (eVar == null) {
                    this.f59710e = new e(com.kwad.sdk.core.response.a.a.v(j2));
                } else {
                    eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
                }
                this.f59710e.a(q(), this);
                a(adBaseFrameLayout);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.b.c
    public void a(@Nullable b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.kwad.sdk.reward.d.c.a
    public void a(com.kwad.sdk.reward.d.c cVar, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, cVar, view, z) == null) {
            ((g) this).a.a(q(), z ? 1 : 153, 1);
        }
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && ((g) this).a.y != null && f()) {
            ((g) this).a.y.h();
            if (com.kwad.sdk.utils.x.a().b()) {
                return;
            }
            this.l = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && com.kwad.sdk.core.response.a.c.g(((g) this).a.f59455g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("LaunchAppTaskPresenter", "onUnbind");
            com.kwad.sdk.utils.x.a().deleteObserver(this);
            e eVar = this.f59710e;
            if (eVar != null) {
                eVar.a(q());
            }
            a aVar = this.f59713h;
            if (aVar != null) {
                aVar.b();
                this.f59713h = null;
            }
            ((g) this).a.y = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r7.equals("ACTION_APP_GO_TO_BACKGROUND") == false) goto L31;
     */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        com.kwad.sdk.reward.b.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, observable, obj) == null) && observable.equals(com.kwad.sdk.utils.x.a()) && (obj instanceof String)) {
            String str = (String) obj;
            com.kwad.sdk.reward.b.a.a aVar2 = this.f59711f;
            if (aVar2 == null) {
                return;
            }
            com.kwad.sdk.reward.b.a.a.a(aVar2, q(), ((g) this).a.f59455g);
            char c2 = 0;
            if (!this.f59711f.k()) {
                if ("ACTION_APP_BACK_TO_FOREGROUND".equals(str)) {
                    b(false);
                    return;
                }
                return;
            }
            int hashCode = str.hashCode();
            if (hashCode != -1891028138) {
                if (hashCode == 321925954) {
                }
                c2 = 65535;
            } else {
                if (str.equals("ACTION_APP_BACK_TO_FOREGROUND")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.l = System.currentTimeMillis();
            } else if (c2 != 1) {
            } else {
                boolean e2 = e();
                if (e2 && (aVar = this.f59711f) != null) {
                    aVar.j();
                    com.kwad.sdk.reward.d.a().b();
                    ((g) this).a.f59450b.e();
                }
                b(e2);
            }
        }
    }
}
