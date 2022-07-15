package com.kwad.components.core.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.a.g;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.kwai.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes5.dex */
public final class c implements u.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public w C;
    public String D;
    public Context a;
    public AdTemplate b;
    public int c;
    public ViewGroup d;
    public KsAdWebView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public Handler k;
    public boolean l;
    public LinearLayout m;
    public TextView n;
    public ImageView o;
    public ViewGroup p;
    public com.kwad.components.core.webview.a q;
    public com.kwad.components.core.webview.a.a r;
    public com.kwad.sdk.core.webview.b s;
    public int t;
    public com.kwad.components.core.kwai.a u;
    public a v;
    public x w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public interface a {
        void onBackBtnClicked(View view2);

        void onCloseBtnClicked(View view2);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;

        public b(C0515c c0515c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0515c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0515c.a;
            this.b = c0515c.b;
            this.c = c0515c.d;
            this.d = c0515c.c;
        }

        public /* synthetic */ b(C0515c c0515c, byte b) {
            this(c0515c);
        }
    }

    /* renamed from: com.kwad.components.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0515c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public String c;
        public String d;

        public C0515c() {
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
            this.a = true;
            this.b = true;
        }

        public final b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, (byte) 0) : (b) invokeV.objValue;
        }

        public final C0515c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (C0515c) invokeL.objValue;
        }

        public final C0515c a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.a = true;
                return this;
            }
            return (C0515c) invokeZ.objValue;
        }

        public final C0515c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (C0515c) invokeL.objValue;
        }

        public final C0515c b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.b = false;
                return this;
            }
            return (C0515c) invokeZ.objValue;
        }
    }

    public c(Context context, AdTemplate adTemplate, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new Handler(Looper.getMainLooper());
        this.l = true;
        this.x = -1;
        this.y = false;
        this.z = false;
        this.a = context;
        this.b = adTemplate;
        this.c = i;
        this.y = z;
        this.d = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d03f9, (ViewGroup) null);
        this.t = com.kwad.sdk.core.config.d.R();
    }

    private <T extends View> T a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            ViewGroup viewGroup = this.d;
            if (viewGroup == null) {
                return null;
            }
            return (T) viewGroup.findViewById(i);
        }
        return (T) invokeI.objValue;
    }

    public static void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webView) == null) {
            webView.getSettings().setAllowFileAccess(true);
        }
    }

    private void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ksAdWebView) == null) {
            p();
            com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.s);
            this.r = aVar;
            ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            x xVar = new x();
            this.w = xVar;
            aVar.a(xVar);
            aVar.a(new u(this, this.D));
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.b);
            aVar.a(new f(this.s, bVar, r(), true));
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.s, bVar, r(), true, 0, false));
            aVar.a(new z(this.s, bVar));
            aVar.a(new m(this.s));
            aVar.a(new v(this.s));
            aVar.a(new p(this.s));
            aVar.a(new i(this.s));
            aVar.a(new ac(new ac.a(this) { // from class: com.kwad.components.core.page.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.components.core.webview.jshandler.ac.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.a.b.x(this.a.b)) {
                        com.kwad.components.core.c.kwai.b.a(new b.a().a(this.a.a).a(this.a.b).a(com.kwad.sdk.core.response.a.b.w(this.a.b)).a());
                    }
                }
            }));
            w wVar = new w();
            this.C = wVar;
            aVar.a(wVar);
        }
    }

    private void b(b bVar) {
        com.kwad.components.core.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bVar) == null) || bVar == null || (aVar = this.u) == null) {
            return;
        }
        aVar.a(bVar.b);
        this.u.b(bVar.a);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            p();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
            this.q = aVar;
            a(aVar);
            ksAdWebView.addJavascriptInterface(this.q, "KwaiAd");
        }
    }

    private void c(b bVar) {
        String aC;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bVar) == null) {
            this.B = TextUtils.equals(bVar.c, com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.i(this.b)));
            if (this.A) {
                aC = bVar.d;
            } else {
                List<AdInfo> list = this.b.adInfoList;
                aC = (list == null || list.size() <= 0 || this.b.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.aC(com.kwad.sdk.core.response.a.d.i(this.b));
            }
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.d);
            this.u = aVar;
            aVar.a(new com.kwad.components.core.kwai.b(aC));
            this.u.a(new a.InterfaceC0513a(this) { // from class: com.kwad.components.core.page.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
                public final void a(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.e == null || !this.a.e.canGoBack()) {
                            if (this.a.v != null) {
                                this.a.v.onBackBtnClicked(view2);
                                return;
                            }
                            return;
                        }
                        this.a.e.goBack();
                        if (this.a.B) {
                            com.kwad.sdk.core.report.a.j(this.a.b);
                        }
                    }
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
                public final void b(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        if (this.a.e == null || !this.a.e.canGoBack()) {
                            if (this.a.v != null) {
                                this.a.v.onCloseBtnClicked(view2);
                                return;
                            }
                            return;
                        }
                        this.a.e.goBack();
                        if (this.a.B) {
                            com.kwad.sdk.core.report.a.j(this.a.b);
                        }
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && com.kwad.sdk.core.response.a.d.q(this.b)) {
            this.f.setVisibility(0);
            if (!this.b.mRewardVerifyCalled) {
                k();
                this.k.postDelayed(new Runnable(this) { // from class: com.kwad.components.core.page.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.a.l) {
                                this.a.k.postDelayed(this, 500L);
                                return;
                            }
                            if (this.a.t <= 0) {
                                this.a.g.setText("任务已完成");
                                this.a.h.setVisibility(8);
                                this.a.i.setVisibility(8);
                                this.a.j.setVisibility(8);
                                g gVar = (g) com.kwad.sdk.components.c.a(g.class);
                                if (gVar != null) {
                                    gVar.a();
                                }
                            } else {
                                this.a.k();
                                this.a.k.postDelayed(this, 1000L);
                            }
                            c.i(this.a);
                        }
                    }
                }, 1000L);
                return;
            }
            this.g.setText("任务已完成");
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            a((WebView) this.e);
            this.e.setClientConfig(this.e.getClientConfig().a(this.b).a(q()).a(j()).a(h()).a(i()));
            if (com.kwad.sdk.core.response.a.a.f(com.kwad.sdk.core.response.a.d.i(this.b))) {
                o();
                a(this.e);
            } else if (this.c == 4) {
                this.b.interactLandingPageShowing = true;
                o();
                b(this.e);
            }
            this.e.loadUrl(this.D);
            this.e.b();
        }
    }

    @NonNull
    private KsAdWebView.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? new KsAdWebView.b(this) { // from class: com.kwad.components.core.page.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.C == null) {
                    return;
                }
                this.a.C.c();
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.C == null) {
                    return;
                }
                this.a.C.d();
            }
        } : (KsAdWebView.b) invokeV.objValue;
    }

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.t;
        cVar.t = i - 1;
        return i;
    }

    @NonNull
    private KsAdWebView.c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? new KsAdWebView.c(this) { // from class: com.kwad.components.core.page.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.core.webview.KsAdWebView.c
            public final void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.A && this.a.m.getVisibility() == 0) {
                    this.a.m.setVisibility(8);
                }
            }
        } : (KsAdWebView.c) invokeV.objValue;
    }

    private KsAdWebView.d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.core.page.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    this.a.z = false;
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.z = true;
                    if (this.a.y) {
                        this.a.c();
                    }
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.h.setText(l());
            this.j.setText(m());
        }
    }

    private String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            int i = this.t / 60;
            StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
            sb.append(i);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            int i = this.t % 60;
            StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
            sb.append(i);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.obfuscated_res_0x7f0911f2);
            this.m = linearLayout;
            if (this.A) {
                linearLayout.setVisibility(8);
                return;
            }
            this.n = (TextView) a(R.id.obfuscated_res_0x7f0911f3);
            ImageView imageView = (ImageView) a(R.id.obfuscated_res_0x7f0911f4);
            this.o = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.m.setVisibility(8);
                    }
                }
            });
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.b);
            boolean aj = com.kwad.sdk.core.response.a.a.aj(i);
            String af = com.kwad.sdk.core.response.a.a.af(i);
            if (!aj) {
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(0);
            this.n.setText(af);
            this.n.setSelected(true);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.s = bVar;
            bVar.a(this.b);
            com.kwad.sdk.core.webview.b bVar2 = this.s;
            bVar2.a = 0;
            bVar2.e = this.e;
            bVar2.d = this.p;
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            com.kwad.components.core.webview.a aVar = this.q;
            if (aVar != null) {
                aVar.a();
                this.q = null;
            }
            com.kwad.components.core.webview.a.a aVar2 = this.r;
            if (aVar2 != null) {
                aVar2.a();
                this.r = null;
            }
        }
    }

    private u.b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            u.b bVar = new u.b();
            bVar.p = 0;
            bVar.C = this.c;
            return bVar;
        }
        return (u.b) invokeV.objValue;
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.core.page.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.v = aVar;
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || this.b == null) {
            return;
        }
        this.D = bVar.c;
        this.A = (TextUtils.isEmpty(bVar.d) || TextUtils.isEmpty(bVar.c)) ? false : true;
        this.e = (KsAdWebView) a(R.id.obfuscated_res_0x7f0911e9);
        this.p = (ViewGroup) a(R.id.obfuscated_res_0x7f09107e);
        this.f = (LinearLayout) a(R.id.obfuscated_res_0x7f091138);
        this.g = (TextView) a(R.id.obfuscated_res_0x7f091135);
        this.h = (TextView) a(R.id.obfuscated_res_0x7f091136);
        this.i = (TextView) a(R.id.obfuscated_res_0x7f091134);
        this.j = (TextView) a(R.id.obfuscated_res_0x7f091137);
        n();
        c(bVar);
        g();
        b(bVar);
        f();
    }

    @Override // com.kwad.components.core.webview.jshandler.u.b
    public final void a(u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.x = aVar.a;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x == 1 : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.z) {
            x xVar = this.w;
            if (xVar != null) {
                xVar.c();
            }
            ViewGroup viewGroup = this.d;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            x xVar2 = this.w;
            if (xVar2 != null) {
                xVar2.d();
            }
            if (com.kwad.sdk.core.response.a.d.q(this.b)) {
                this.l = false;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            x xVar = this.w;
            if (xVar != null) {
                xVar.e();
            }
            ViewGroup viewGroup = this.d;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            x xVar2 = this.w;
            if (xVar2 != null) {
                xVar2.f();
            }
            if (com.kwad.sdk.core.response.a.d.q(this.b)) {
                this.l = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            KsAdWebView ksAdWebView = this.e;
            if (ksAdWebView != null) {
                ksAdWebView.c();
                this.e = null;
            }
            if (com.kwad.sdk.core.response.a.d.q(this.b)) {
                this.k.removeCallbacksAndMessages(null);
            }
        }
    }
}
