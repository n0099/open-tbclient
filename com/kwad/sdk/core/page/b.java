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
    public Context f71865a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f71866b;

    /* renamed from: c  reason: collision with root package name */
    public int f71867c;

    /* renamed from: d  reason: collision with root package name */
    public View f71868d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f71869e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f71870f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f71871g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f71872h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f71873i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f71874j;
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
    public static class C1992b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f71884a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71885b;

        public C1992b(boolean z, boolean z2) {
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
            this.f71884a = true;
            this.f71885b = true;
            this.f71884a = z;
            this.f71885b = z2;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f71886a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71887b;

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
            this.f71886a = true;
            this.f71887b = true;
        }

        public C1992b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1992b(this.f71886a, this.f71887b) : (C1992b) invokeV.objValue;
        }

        public c a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f71887b = z;
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
        this.f71865a = context;
        this.f71866b = adTemplate;
        this.f71867c = i2;
        this.q = z;
        this.f71868d = LayoutInflater.from(context).inflate(R.layout.ksad_activity_ad_webview, (ViewGroup) null);
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
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f71866b);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.m, bVar, new a.b(this) { // from class: com.kwad.sdk.core.page.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71880a;

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
                    this.f71880a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2000a c2000a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) {
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
                public final /* synthetic */ b f71881a;

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
                    this.f71881a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.s.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a2 = com.kwad.sdk.core.response.b.a.a(this.f71881a.f71865a, com.kwad.sdk.core.response.b.c.i(this.f71881a.f71866b));
                        if (an.a(a2)) {
                            return;
                        }
                        com.kwad.sdk.core.download.a.b.a(this.f71881a.f71865a, this.f71881a.f71866b, a2);
                    }
                }
            }));
            o oVar = new o();
            ksAdWebView.setDeepLinkListener(new KsAdWebView.b(this, oVar) { // from class: com.kwad.sdk.core.page.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f71882a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f71883b;

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
                    this.f71883b = this;
                    this.f71882a = oVar;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71882a.c();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f71882a.d();
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
            View view = this.f71868d;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i2);
        }
        return (T) invokeI.objValue;
    }

    private void b(C1992b c1992b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, c1992b) == null) || c1992b == null) {
            return;
        }
        if (this.f71871g != null) {
            this.f71871g.setVisibility(c1992b.f71885b ? 0 : 8);
        }
        if (this.f71870f != null) {
            this.f71870f.setVisibility(c1992b.f71884a ? 0 : 8);
        }
    }

    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            n.a aVar = new n.a();
            aVar.l = 0;
            aVar.u = this.f71867c;
            ksAdWebView.setClientParams(aVar);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f71872h = (LinearLayout) b(R.id.ksad_web_tip_bar);
            this.f71873i = (TextView) b(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) b(R.id.ksad_web_tip_close_btn);
            this.f71874j = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71879a;

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
                    this.f71879a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71879a.f71872h.setVisibility(8);
                    }
                }
            });
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f71866b);
            boolean W = com.kwad.sdk.core.response.b.a.W(i2);
            String U = com.kwad.sdk.core.response.b.a.U(i2);
            if (!W) {
                this.f71872h.setVisibility(8);
                return;
            }
            this.f71872h.setVisibility(0);
            this.f71873i.setText(U);
            this.f71873i.setSelected(true);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.m = aVar;
            aVar.f72243b = this.f71866b;
            aVar.f72242a = 0;
            aVar.f72247f = this.f71869e;
            aVar.f72246e = this.k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71868d : (View) invokeV.objValue;
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

    public void a(C1992b c1992b) {
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1992b) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_video_webview);
            this.f71869e = ksAdWebView;
            a((WebView) ksAdWebView);
            b(this.f71869e);
            this.f71869e.setTemplateData(this.f71866b);
            KsAdWebView ksAdWebView2 = this.f71869e;
            Context context = this.f71865a;
            AdTemplate adTemplate = this.f71866b;
            ksAdWebView2.loadUrl(com.kwad.sdk.core.response.b.a.a(context, adTemplate, com.kwad.sdk.core.response.b.c.i(adTemplate)));
            this.f71869e.a();
            this.f71869e.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71875a;

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
                    this.f71875a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.f71875a.f71872h.getVisibility() == 0) {
                        this.f71875a.f71872h.setVisibility(8);
                    }
                }
            });
            this.f71869e.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71876a;

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
                    this.f71876a = this;
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
                        this.f71876a.r = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f71876a.r = true;
                        if (this.f71876a.q) {
                            this.f71876a.d();
                        }
                    }
                }
            });
            TextView textView = (TextView) b(R.id.ksad_kwad_titlebar_title);
            this.f71870f = (ImageView) b(R.id.ksad_kwad_web_navi_back);
            this.f71871g = (ImageView) b(R.id.ksad_kwad_web_navi_close);
            this.k = (ViewGroup) b(R.id.ksad_landing_page_root);
            List<AdInfo> list = this.f71866b.adInfoList;
            if (list == null || list.size() <= 0 || this.f71866b.adInfoList.get(0) == null || (adBaseInfo = this.f71866b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
            } else {
                textView.setText(adBaseInfo.productName);
            }
            this.f71871g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71877a;

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
                    this.f71877a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f71877a.f71869e != null && this.f71877a.f71869e.canGoBack()) {
                            this.f71877a.f71869e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f71877a.f71866b);
                        } else if (this.f71877a.n != null) {
                            this.f71877a.n.onCloseBtnClicked(view);
                        }
                    }
                }
            });
            this.f71870f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71878a;

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
                    this.f71878a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f71878a.f71869e != null && this.f71878a.f71869e.canGoBack()) {
                            this.f71878a.f71869e.goBack();
                            com.kwad.sdk.core.report.a.l(this.f71878a.f71866b);
                        } else if (this.f71878a.n != null) {
                            this.f71878a.n.onBackBtnClicked(view);
                        }
                    }
                }
            });
            g();
            if (this.f71867c == 4) {
                this.f71866b.interactLandingPageShowing = true;
                h();
                a(this.f71869e);
            }
            b(c1992b);
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
            View view = this.f71868d;
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
            View view = this.f71868d;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ksAdWebView = this.f71869e) == null) {
            return;
        }
        ksAdWebView.b();
    }
}
