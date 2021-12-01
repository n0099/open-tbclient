package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.x;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.c;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes2.dex */
public class a extends g implements b.c, c.a, com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59111b;

    /* renamed from: c  reason: collision with root package name */
    public d f59112c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59113d;

    /* renamed from: e  reason: collision with root package name */
    public C2056a f59114e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f59115f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f59116g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.b.kwai.a f59117h;

    /* renamed from: com.kwad.sdk.reward.presenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2056a implements j.b, p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public KsAdWebView f59118b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f59119c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f59120d;

        /* renamed from: e  reason: collision with root package name */
        public x f59121e;

        /* renamed from: f  reason: collision with root package name */
        public b.c f59122f;

        /* renamed from: g  reason: collision with root package name */
        public b f59123g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public AdTemplate f59124h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f59125i;

        public C2056a(KsAdWebView ksAdWebView, View view, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView, view, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59125i = false;
            this.a = view;
            this.f59118b = ksAdWebView;
            this.f59122f = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                View view = this.a;
                if (view != null) {
                    view.setVisibility(0);
                }
                a(false);
            }
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, gVar) == null) {
                gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59119c, (com.kwad.sdk.core.download.a.b) null, this.f59122f));
                gVar.a(new f(this.f59119c));
                gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59119c));
                gVar.a(new p(this));
                x xVar = new x();
                this.f59121e = xVar;
                gVar.a(xVar);
                gVar.a(new k(this.f59119c));
                gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59119c));
                gVar.a(new com.kwad.sdk.core.webview.a.g());
                gVar.a(new j(this.f59119c, this));
            }
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
                if (at.a(str)) {
                    a();
                    return;
                }
                b();
                be.b(this.f59118b);
                this.f59118b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.presenter.c.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C2056a a;

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
                            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onReceivedHttpError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                            this.a.a();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }
                });
                com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59118b);
                this.f59120d = gVar;
                a(gVar);
                this.f59118b.addJavascriptInterface(this.f59120d, "KwaiAd");
                this.f59118b.loadUrl(str);
                ax.a(new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.c.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C2056a a;

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
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f59125i) {
                            return;
                        }
                        this.a.f59125i = true;
                        this.a.a();
                    }
                }, null, 1000L);
            }
        }

        private void b() {
            com.kwad.sdk.core.webview.kwai.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (gVar = this.f59120d) == null) {
                return;
            }
            gVar.a();
            this.f59120d = null;
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, this, adTemplate, viewGroup) == null) {
                com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
                this.f59119c = aVar;
                aVar.a(adTemplate);
                com.kwad.sdk.core.webview.a aVar2 = this.f59119c;
                aVar2.a = 0;
                aVar2.f57955b = null;
                aVar2.f57957d = viewGroup;
                aVar2.f57958e = this.f59118b;
                aVar2.f57956c = null;
                aVar2.f57961h = true;
            }
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, adTemplate, viewGroup) == null) {
                KsAdWebView ksAdWebView = this.f59118b;
                if (ksAdWebView != null) {
                    ksAdWebView.setBackgroundColor(0);
                    if (this.f59118b.getBackground() != null) {
                        this.f59118b.getBackground().setAlpha(0);
                    }
                }
                this.f59124h = adTemplate;
                b(adTemplate, viewGroup);
                String b2 = com.kwad.sdk.core.response.a.b.b(adTemplate);
                com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "init url: " + b2);
                a(b2);
            }
        }

        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(@NonNull j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onAdFrameValid : " + aVar.toJson());
            }
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || this.f59125i) {
                return;
            }
            this.f59125i = true;
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                a();
            }
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                this.f59123g = bVar;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "switchWebView: " + z);
                KsAdWebView ksAdWebView = this.f59118b;
                if (ksAdWebView == null) {
                    return;
                }
                ksAdWebView.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    /* loaded from: classes2.dex */
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
                return (!g() || af.e(q())) ? 8 : 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends C2056a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(KsAdWebView ksAdWebView, View view, b.c cVar) {
            super(ksAdWebView, view, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView, view, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((KsAdWebView) objArr2[0], (View) objArr2[1], (b.c) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public a() {
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
        a((Presenter) new c());
    }

    private void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, this, view, z) == null) {
            int id = view.getId();
            if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
                b(z);
            }
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context q;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, adBaseFrameLayout) == null) {
            if (!af.e(q())) {
                com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) a(R.id.ksad_reward_apk_info_stub)).inflate();
            KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.ksad_reward_apk_info_card_root);
            kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
            int size = com.kwad.sdk.core.response.a.c.i(((g) this).a.f58874g).size();
            kSFrameLayout.setRatio(0.0f);
            if (size == 0) {
                q = q();
                f2 = 136.0f;
            } else {
                q = q();
                f2 = 155.0f;
            }
            com.kwad.sdk.a.kwai.a.a(kSFrameLayout, com.kwad.sdk.a.kwai.a.a(q, f2));
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
            this.f59113d = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.f59113d, this);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f59113d);
            this.f59115f = cVar;
            cVar.a(this);
            this.f59115f.a(((g) this).a.f58874g, true);
            C2056a c2056a = new C2056a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f59113d, this);
            this.f59114e = c2056a;
            c2056a.a(new b(this) { // from class: com.kwad.sdk.reward.presenter.c.a.1
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
            });
            this.f59114e.a(((g) this).a.f58874g, adBaseFrameLayout);
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            ((g) this).a.a(q(), z ? 1 : 153, 1);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onBind");
            if (g()) {
                com.kwad.sdk.reward.b.kwai.a b2 = com.kwad.sdk.reward.b.c.b();
                this.f59117h = b2;
                ((g) this).a.z = b2;
                b2.g();
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
                ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
                this.f59111b = viewGroup;
                viewGroup.setClickable(true);
                new com.kwad.sdk.widget.f(this.f59111b, this);
                com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f59111b);
                this.f59116g = cVar;
                cVar.a(this);
                this.f59116g.a(((g) this).a.f58874g, false);
                ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
                d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f59111b, this);
                this.f59112c = dVar;
                dVar.a(((g) this).a.f58874g, adBaseFrameLayout);
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
            b(z);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && com.kwad.sdk.core.response.a.c.g(((g) this).a.f58874g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onUnbind");
            if (this.f59114e != null) {
                this.f59114e = null;
            }
            ((g) this).a.z = null;
        }
    }
}
