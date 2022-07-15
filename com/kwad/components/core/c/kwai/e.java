package com.kwad.components.core.c.kwai;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.t;
/* loaded from: classes5.dex */
public final class e extends c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b b;
    public b.C0509b c;
    public AdTemplate d;
    public com.kwad.components.core.c.a.b e;
    public KsAdWebView f;
    public com.kwad.components.core.webview.a g;
    public com.kwad.sdk.core.webview.b h;
    public x i;
    public Runnable j;
    public boolean k;
    public com.kwad.sdk.core.webview.a.kwai.a l;
    public o.b m;
    public n.b n;
    public u.b o;

    public e() {
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
        this.k = false;
        this.l = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.core.c.kwai.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.b.a("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + this.a.k);
                    this.a.k = true;
                }
            }
        };
        this.m = new o.b(this) { // from class: com.kwad.components.core.c.kwai.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.o.b
            public final void a(o.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.b.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
                    this.a.f.setTranslationY((float) (aVar.a + aVar.d));
                }
            }
        };
        this.n = new n.b(this) { // from class: com.kwad.components.core.c.kwai.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.n.b
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    com.kwad.sdk.core.d.b.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
                    this.a.l();
                }
            }
        };
        this.o = new u.b(this) { // from class: com.kwad.components.core.c.kwai.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.b.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
                    if (aVar.a == 1) {
                        this.a.k();
                        return;
                    }
                    this.a.l();
                    if (this.a.u() != null) {
                        t.a(this.a.u(), com.kwad.sdk.utils.u.b(this.a.u()));
                    }
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            aVar.a(new f(this.h, this.e, this.l));
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.h, this.e, this.l, 1));
            aVar.a(new i(this.h));
            aVar.a(new l(this.h));
            aVar.a(new h(this.h));
            aVar.a(new o(this.h, this.m));
            aVar.a(new u(this.o, this.c.c));
            x xVar = new x();
            this.i = xVar;
            aVar.a(xVar);
            aVar.a(new z(this.h, this.e));
            aVar.a(new n(this.n));
            aVar.a(new p(this.h));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f.setVisibility(8);
            this.f.a();
            j();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.h = bVar;
            bVar.a(((c) this).a.c);
            com.kwad.sdk.core.webview.b bVar2 = this.h;
            AdBaseFrameLayout adBaseFrameLayout = ((c) this).a.d;
            bVar2.b = adBaseFrameLayout;
            bVar2.d = adBaseFrameLayout;
            bVar2.e = this.f;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            i();
            this.f.loadUrl(this.c.c);
            this.f.postDelayed(h(), 1500L);
            this.f.setBackgroundColor(0);
            this.f.getBackground().setAlpha(0);
            this.f.setVisibility(0);
        }
    }

    private Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.j == null) {
                this.j = new Runnable(this) { // from class: com.kwad.components.core.c.kwai.e.2
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                            this.a.l();
                            if (this.a.u() != null) {
                                t.a(this.a.u(), com.kwad.sdk.utils.u.b(this.a.u()));
                            }
                        }
                    }
                };
            }
            return this.j;
        }
        return (Runnable) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            com.kwad.sdk.core.d.b.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
            j();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.f);
            this.g = aVar;
            a(aVar);
            this.f.addJavascriptInterface(this.g, "KwaiAd");
        }
    }

    private void j() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a();
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (runnable = this.j) == null) {
            return;
        }
        this.f.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            com.kwad.sdk.core.d.b.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.k);
            if (this.f.getVisibility() != 0) {
                return;
            }
            x xVar = this.i;
            if (xVar != null) {
                xVar.e();
            }
            this.f.setVisibility(4);
            x xVar2 = this.i;
            if (xVar2 != null) {
                xVar2.f();
            }
            if (this.k) {
                com.kwad.sdk.core.report.a.m(this.d);
            }
            b bVar = this.b;
            if (bVar == null || !bVar.isShowing()) {
                return;
            }
            this.b.a(this.k);
        }
    }

    @Override // com.kwad.components.core.c.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            d dVar = ((c) this).a;
            this.b = dVar.a;
            this.c = dVar.b;
            this.d = dVar.c;
            dVar.d.setOnClickListener(this);
            this.e = ((c) this).a.e;
            e();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e_();
            d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.f = (KsAdWebView) b(R.id.obfuscated_res_0x7f091039);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            k();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            com.kwad.sdk.core.report.a.m(this.d);
            b bVar = this.b;
            if (bVar != null) {
                bVar.dismiss();
            }
        }
    }
}
