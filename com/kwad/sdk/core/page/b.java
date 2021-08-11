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
    public Context f71665a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f71666b;

    /* renamed from: c  reason: collision with root package name */
    public int f71667c;

    /* renamed from: d  reason: collision with root package name */
    public View f71668d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f71669e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f71670f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f71671g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f71672h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f71673i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f71674j;
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
    public static class C1988b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f71684a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71685b;

        public C1988b(boolean z, boolean z2) {
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
            this.f71684a = true;
            this.f71685b = true;
            this.f71684a = z;
            this.f71685b = z2;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f71686a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71687b;

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
            this.f71686a = true;
            this.f71687b = true;
        }

        public C1988b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1988b(this.f71686a, this.f71687b) : (C1988b) invokeV.objValue;
        }

        public c a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f71687b = z;
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
        this.f71665a = context;
        this.f71666b = adTemplate;
        this.f71667c = i2;
        this.q = z;
        this.f71668d = LayoutInflater.from(context).inflate(R.layout.ksad_activity_ad_webview, (ViewGroup) null);
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
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f71666b);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.m, bVar, new a.b(this) { // from class: com.kwad.sdk.core.page.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71680a;

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
                    this.f71680a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C1996a c1996a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1996a) == null) {
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
                public final /* synthetic */ b f71681a;

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
                    this.f71681a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.s.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a2 = com.kwad.sdk.core.response.b.a.a(this.f71681a.f71665a, com.kwad.sdk.core.response.b.c.i(this.f71681a.f71666b));
                        if (an.a(a2)) {
                            return;
                        }
                        com.kwad.sdk.core.download.a.b.a(this.f71681a.f71665a, this.f71681a.f71666b, a2);
                    }
                }
            }));
            o oVar = new o();
            ksAdWebView.setDeepLinkListener(new KsAdWebView.b(this, oVar) { // from class: com.kwad.sdk.core.page.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f71682a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f71683b;

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
                    this.f71683b = this;
                    this.f71682a = oVar;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71682a.c();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f71682a.d();
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
            View view = this.f71668d;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i2);
        }
        return (T) invokeI.objValue;
    }

    private void b(C1988b c1988b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, c1988b) == null) || c1988b == null) {
            return;
        }
        if (this.f71671g != null) {
            this.f71671g.setVisibility(c1988b.f71685b ? 0 : 8);
        }
        if (this.f71670f != null) {
            this.f71670f.setVisibility(c1988b.f71684a ? 0 : 8);
        }
    }

    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            n.a aVar = new n.a();
            aVar.l = 0;
            aVar.u = this.f71667c;
            ksAdWebView.setClientParams(aVar);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f71672h = (LinearLayout) b(R.id.ksad_web_tip_bar);
            this.f71673i = (TextView) b(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) b(R.id.ksad_web_tip_close_btn);
            this.f71674j = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71679a;

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
                    this.f71679a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71679a.f71672h.setVisibility(8);
                    }
                }
            });
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f71666b);
            boolean W = com.kwad.sdk.core.response.b.a.W(i2);
            String U = com.kwad.sdk.core.response.b.a.U(i2);
            if (!W) {
                this.f71672h.setVisibility(8);
                return;
            }
            this.f71672h.setVisibility(0);
            this.f71673i.setText(U);
            this.f71673i.setSelected(true);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.m = aVar;
            aVar.f72043b = this.f71666b;
            aVar.f72042a = 0;
            aVar.f72047f = this.f71669e;
            aVar.f72046e = this.k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71668d : (View) invokeV.objValue;
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

    public void a(C1988b c1988b) {
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1988b) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_video_webview);
            this.f71669e = ksAdWebView;
            a((WebView) ksAdWebView);
            b(this.f71669e);
            this.f71669e.setTemplateData(this.f71666b);
            KsAdWebView ksAdWebView2 = this.f71669e;
            Context context = this.f71665a;
            AdTemplate adTemplate = this.f71666b;
            ksAdWebView2.loadUrl(com.kwad.sdk.core.response.b.a.a(context, adTemplate, com.kwad.sdk.core.response.b.c.i(adTemplate)));
            this.f71669e.a();
            this.f71669e.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71675a;

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
                    this.f71675a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.f71675a.f71672h.getVisibility() == 0) {
                        this.f71675a.f71672h.setVisibility(8);
                    }
                }
            });
            this.f71669e.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71676a;

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
                    this.f71676a = this;
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
                        this.f71676a.r = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f71676a.r = true;
                        if (this.f71676a.q) {
                            this.f71676a.d();
                        }
                    }
                }
            });
            TextView textView = (TextView) b(R.id.ksad_kwad_titlebar_title);
            this.f71670f = (ImageView) b(R.id.ksad_kwad_web_navi_back);
            this.f71671g = (ImageView) b(R.id.ksad_kwad_web_navi_close);
            this.k = (ViewGroup) b(R.id.ksad_landing_page_root);
            List<AdInfo> list = this.f71666b.adInfoList;
            if (list == null || list.size() <= 0 || this.f71666b.adInfoList.get(0) == null || (adBaseInfo = this.f71666b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
            } else {
                textView.setText(adBaseInfo.productName);
            }
            this.f71671g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71677a;

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
                    this.f71677a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f71677a.f71669e != null && this.f71677a.f71669e.canGoBack()) {
                            this.f71677a.f71669e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f71677a.f71666b);
                        } else if (this.f71677a.n != null) {
                            this.f71677a.n.onCloseBtnClicked(view);
                        }
                    }
                }
            });
            this.f71670f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71678a;

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
                    this.f71678a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f71678a.f71669e != null && this.f71678a.f71669e.canGoBack()) {
                            this.f71678a.f71669e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f71678a.f71666b);
                        } else if (this.f71678a.n != null) {
                            this.f71678a.n.onBackBtnClicked(view);
                        }
                    }
                }
            });
            g();
            if (this.f71667c == 4) {
                this.f71666b.interactLandingPageShowing = true;
                h();
                a(this.f71669e);
            }
            b(c1988b);
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
            View view = this.f71668d;
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
            View view = this.f71668d;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ksAdWebView = this.f71669e) == null) {
            return;
        }
        ksAdWebView.b();
    }
}
