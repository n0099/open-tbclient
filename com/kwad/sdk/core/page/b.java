package com.kwad.sdk.core.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.utils.an;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements m.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f72399a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f72400b;

    /* renamed from: c  reason: collision with root package name */
    public int f72401c;

    /* renamed from: d  reason: collision with root package name */
    public View f72402d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f72403e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f72404f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f72405g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f72406h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f72407i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f72408j;
    public ViewGroup k;
    public g l;
    public com.kwad.sdk.core.webview.a m;
    public a n;
    public p o;
    public int p;
    public boolean q;
    public boolean r;

    /* loaded from: classes10.dex */
    public interface a {
        void onBackBtnClicked(View view);

        void onCloseBtnClicked(View view);
    }

    /* renamed from: com.kwad.sdk.core.page.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1998b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f72418a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f72419b;

        public C1998b(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72418a = true;
            this.f72419b = true;
            this.f72418a = z;
            this.f72419b = z2;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f72420a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f72421b;

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
                    return;
                }
            }
            this.f72420a = true;
            this.f72421b = true;
        }

        public C1998b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1998b(this.f72420a, this.f72421b) : (C1998b) invokeV.objValue;
        }

        public c a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f72421b = z;
                return this;
            }
            return (c) invokeZ.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, AdTemplate adTemplate, int i2) {
        this(context, adTemplate, i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AdTemplate) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b(Context context, AdTemplate adTemplate, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = -1;
        this.q = false;
        this.r = false;
        this.f72399a = context;
        this.f72400b = adTemplate;
        this.f72401c = i2;
        this.q = z;
        this.f72402d = LayoutInflater.from(context).inflate(R.layout.ksad_activity_ad_webview, (ViewGroup) null);
    }

    private void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, webView) == null) || webView == null || webView.getSettings() == null) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksAdWebView) == null) {
            i();
            g gVar = new g(ksAdWebView);
            this.l = gVar;
            a(ksAdWebView, gVar);
            ksAdWebView.addJavascriptInterface(this.l, "KwaiAd");
        }
    }

    private void a(KsAdWebView ksAdWebView, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, ksAdWebView, gVar) == null) {
            p pVar = new p();
            this.o = pVar;
            gVar.a(pVar);
            gVar.a(new d());
            gVar.a(new m(this));
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f72400b);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.m, bVar, new a.b(this) { // from class: com.kwad.sdk.core.page.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72414a;

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
                    this.f72414a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2006a c2006a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2006a) == null) {
                    }
                }
            }, true));
            gVar.a(new q(this.m, bVar));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.m));
            gVar.a(new n(this.m));
            gVar.a(new j(this.m));
            gVar.a(new e(this.m));
            gVar.a(new s(new s.a(this) { // from class: com.kwad.sdk.core.page.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72415a;

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
                    this.f72415a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.s.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a2 = com.kwad.sdk.core.response.b.a.a(this.f72415a.f72399a, com.kwad.sdk.core.response.b.c.i(this.f72415a.f72400b));
                        if (an.a(a2)) {
                            return;
                        }
                        com.kwad.sdk.core.download.a.b.a(this.f72415a.f72399a, this.f72415a.f72400b, a2);
                    }
                }
            }));
            o oVar = new o();
            ksAdWebView.setDeepLinkListener(new KsAdWebView.b(this, oVar) { // from class: com.kwad.sdk.core.page.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f72416a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f72417b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, oVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72417b = this;
                    this.f72416a = oVar;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72416a.c();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f72416a.d();
                    }
                }
            });
            gVar.a(oVar);
        }
    }

    private <T extends View> T b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            View view = this.f72402d;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i2);
        }
        return (T) invokeI.objValue;
    }

    private void b(C1998b c1998b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, c1998b) == null) || c1998b == null) {
            return;
        }
        if (this.f72405g != null) {
            this.f72405g.setVisibility(c1998b.f72419b ? 0 : 8);
        }
        if (this.f72404f != null) {
            this.f72404f.setVisibility(c1998b.f72418a ? 0 : 8);
        }
    }

    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            n.a aVar = new n.a();
            aVar.l = 0;
            aVar.u = this.f72401c;
            ksAdWebView.setClientParams(aVar);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f72406h = (LinearLayout) b(R.id.ksad_web_tip_bar);
            this.f72407i = (TextView) b(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) b(R.id.ksad_web_tip_close_btn);
            this.f72408j = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72413a;

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
                    this.f72413a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f72413a.f72406h.setVisibility(8);
                    }
                }
            });
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f72400b);
            boolean W = com.kwad.sdk.core.response.b.a.W(i2);
            String U = com.kwad.sdk.core.response.b.a.U(i2);
            if (!W) {
                this.f72406h.setVisibility(8);
                return;
            }
            this.f72406h.setVisibility(0);
            this.f72407i.setText(U);
            this.f72407i.setSelected(true);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.m = aVar;
            aVar.f72777b = this.f72400b;
            aVar.f72776a = 0;
            aVar.f72781f = this.f72403e;
            aVar.f72780e = this.k;
        }
    }

    private void i() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.a();
        this.l = null;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72402d : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.jshandler.m.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.p = i2;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void a(C1998b c1998b) {
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1998b) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_video_webview);
            this.f72403e = ksAdWebView;
            a((WebView) ksAdWebView);
            b(this.f72403e);
            this.f72403e.setTemplateData(this.f72400b);
            KsAdWebView ksAdWebView2 = this.f72403e;
            Context context = this.f72399a;
            AdTemplate adTemplate = this.f72400b;
            ksAdWebView2.loadUrl(com.kwad.sdk.core.response.b.a.a(context, adTemplate, com.kwad.sdk.core.response.b.c.i(adTemplate)));
            this.f72403e.a();
            this.f72403e.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72409a;

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
                    this.f72409a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.f72409a.f72406h.getVisibility() == 0) {
                        this.f72409a.f72406h.setVisibility(8);
                    }
                }
            });
            this.f72403e.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72410a;

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
                    this.f72410a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        this.f72410a.r = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f72410a.r = true;
                        if (this.f72410a.q) {
                            this.f72410a.d();
                        }
                    }
                }
            });
            TextView textView = (TextView) b(R.id.ksad_kwad_titlebar_title);
            this.f72404f = (ImageView) b(R.id.ksad_kwad_web_navi_back);
            this.f72405g = (ImageView) b(R.id.ksad_kwad_web_navi_close);
            this.k = (ViewGroup) b(R.id.ksad_landing_page_root);
            List<AdInfo> list = this.f72400b.adInfoList;
            if (list == null || list.size() <= 0 || this.f72400b.adInfoList.get(0) == null || (adBaseInfo = this.f72400b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
            } else {
                textView.setText(adBaseInfo.productName);
            }
            this.f72405g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72411a;

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
                    this.f72411a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f72411a.f72403e != null && this.f72411a.f72403e.canGoBack()) {
                            this.f72411a.f72403e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f72411a.f72400b);
                        } else if (this.f72411a.n != null) {
                            this.f72411a.n.onCloseBtnClicked(view);
                        }
                    }
                }
            });
            this.f72404f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f72412a;

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
                    this.f72412a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f72412a.f72403e != null && this.f72412a.f72403e.canGoBack()) {
                            this.f72412a.f72403e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f72412a.f72400b);
                        } else if (this.f72412a.n != null) {
                            this.f72412a.n.onBackBtnClicked(view);
                        }
                    }
                }
            });
            g();
            if (this.f72401c == 4) {
                this.f72400b.interactLandingPageShowing = true;
                h();
                a(this.f72403e);
            }
            b(c1998b);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(new c().a());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.r) {
            p pVar = this.o;
            if (pVar != null) {
                pVar.c();
            }
            View view = this.f72402d;
            if (view != null) {
                view.setVisibility(0);
            }
            p pVar2 = this.o;
            if (pVar2 != null) {
                pVar2.d();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            p pVar = this.o;
            if (pVar != null) {
                pVar.e();
            }
            View view = this.f72402d;
            if (view != null) {
                view.setVisibility(8);
            }
            p pVar2 = this.o;
            if (pVar2 != null) {
                pVar2.f();
            }
        }
    }

    public void f() {
        KsAdWebView ksAdWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ksAdWebView = this.f72403e) == null) {
            return;
        }
        ksAdWebView.b();
    }
}
