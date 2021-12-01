package com.kwad.sdk.core.page;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.core.webview.jshandler.r;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.y;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.core.webview.kwai.h;
import com.kwad.sdk.utils.at;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements p.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57544b;

    /* renamed from: c  reason: collision with root package name */
    public int f57545c;

    /* renamed from: d  reason: collision with root package name */
    public View f57546d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f57547e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57548f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57549g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f57550h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57551i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f57552j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f57553k;
    public TextView l;
    public Handler m;
    public boolean n;
    public LinearLayout o;
    public TextView p;
    public ImageView q;
    public ViewGroup r;
    public g s;
    public h t;
    public com.kwad.sdk.core.webview.a u;
    public int v;
    public a w;
    public s x;
    public int y;
    public boolean z;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackBtnClicked(View view);

        void onCloseBtnClicked(View view);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f57555b;

        /* renamed from: c  reason: collision with root package name */
        public final String f57556c;

        /* renamed from: d  reason: collision with root package name */
        public final String f57557d;

        public b(C2023c c2023c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2023c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c2023c.a;
            this.f57555b = c2023c.f57558b;
            this.f57556c = c2023c.f57560d;
            this.f57557d = c2023c.f57559c;
        }
    }

    /* renamed from: com.kwad.sdk.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2023c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57558b;

        /* renamed from: c  reason: collision with root package name */
        public String f57559c;

        /* renamed from: d  reason: collision with root package name */
        public String f57560d;

        public C2023c() {
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
            this.a = true;
            this.f57558b = true;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (b) invokeV.objValue;
        }

        public C2023c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f57559c = str;
                return this;
            }
            return (C2023c) invokeL.objValue;
        }

        public C2023c a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.a = z;
                return this;
            }
            return (C2023c) invokeZ.objValue;
        }

        public C2023c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f57560d = str;
                return this;
            }
            return (C2023c) invokeL.objValue;
        }

        public C2023c b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f57558b = z;
                return this;
            }
            return (C2023c) invokeZ.objValue;
        }
    }

    public c(Context context, AdTemplate adTemplate, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new Handler(Looper.getMainLooper());
        this.n = true;
        this.v = com.kwad.sdk.core.config.b.aA();
        this.y = -1;
        this.z = false;
        this.A = false;
        this.a = context;
        this.f57544b = adTemplate;
        this.f57545c = i2;
        this.z = z;
        this.f57546d = LayoutInflater.from(context).inflate(R.layout.ksad_activity_ad_webview, (ViewGroup) null);
    }

    private <T extends View> T a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            View view = this.f57546d;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i2);
        }
        return (T) invokeI.objValue;
    }

    private void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, webView) == null) {
            webView.getSettings().setAllowFileAccess(true);
        }
    }

    private void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ksAdWebView) == null) {
            m();
            h hVar = new h(ksAdWebView, this.u);
            this.t = hVar;
            ksAdWebView.addJavascriptInterface(hVar, "KwaiAdForThird");
        }
    }

    private void a(KsAdWebView ksAdWebView, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksAdWebView, gVar) == null) {
            s sVar = new s();
            this.x = sVar;
            gVar.a(sVar);
            gVar.a(new p(this));
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f57544b);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.u, bVar, n(), true));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.u, bVar, n(), true));
            gVar.a(new t(this.u, bVar));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.h(this.u));
            gVar.a(new q(this.u));
            gVar.a(new k(this.u));
            gVar.a(new f(this.u));
            gVar.a(new y(new y.a(this) { // from class: com.kwad.sdk.core.page.c.7
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

                @Override // com.kwad.sdk.core.webview.jshandler.y.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String a2 = com.kwad.sdk.core.response.a.a.a(this.a.a, com.kwad.sdk.core.response.a.d.j(this.a.f57544b));
                        if (at.a(a2)) {
                            return;
                        }
                        com.kwad.sdk.core.download.kwai.b.a(this.a.a, this.a.f57544b, a2);
                    }
                }
            }));
            r rVar = new r();
            ksAdWebView.setDeepLinkListener(new KsAdWebView.b(this, rVar) { // from class: com.kwad.sdk.core.page.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f57554b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57554b = this;
                    this.a = rVar;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.c();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.d();
                    }
                }
            });
            gVar.a(rVar);
        }
    }

    private void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f57549g != null) {
            this.f57549g.setVisibility(bVar.f57555b ? 0 : 8);
        }
        if (this.f57548f != null) {
            this.f57548f.setVisibility(bVar.a ? 0 : 8);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            m();
            g gVar = new g(ksAdWebView);
            this.s = gVar;
            a(ksAdWebView, gVar);
            ksAdWebView.addJavascriptInterface(this.s, "KwaiAd");
        }
    }

    private void c(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, ksAdWebView) == null) {
            p.a aVar = new p.a();
            aVar.n = 0;
            aVar.w = this.f57545c;
            ksAdWebView.setClientParams(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.f57552j.setText(i());
            this.l.setText(j());
        }
    }

    private String i() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int i2 = this.v / 60;
            if (i2 >= 10) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
                sb.append("0");
            }
            sb.append(i2);
            sb.append("");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private String j() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i2 = this.v % 60;
            if (i2 >= 10) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
                sb.append("0");
            }
            sb.append(i2);
            sb.append("");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ksad_web_tip_bar);
            this.o = linearLayout;
            if (this.B) {
                linearLayout.setVisibility(8);
                return;
            }
            this.p = (TextView) a(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) a(R.id.ksad_web_tip_close_btn);
            this.q = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.c.6
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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.o.setVisibility(8);
                    }
                }
            });
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f57544b);
            boolean af = com.kwad.sdk.core.response.a.a.af(j2);
            String ab = com.kwad.sdk.core.response.a.a.ab(j2);
            if (!af) {
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(0);
            this.p.setText(ab);
            this.p.setSelected(true);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.u = aVar;
            aVar.a(this.f57544b);
            com.kwad.sdk.core.webview.a aVar2 = this.u;
            aVar2.a = 0;
            aVar2.f57958e = this.f57547e;
            aVar2.f57957d = this.r;
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            g gVar = this.s;
            if (gVar != null) {
                gVar.a();
                this.s = null;
            }
            h hVar = this.t;
            if (hVar != null) {
                hVar.a();
                this.t = null;
            }
        }
    }

    @NonNull
    private b.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) ? new b.c(this) { // from class: com.kwad.sdk.core.page.c.9
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
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        } : (b.c) invokeV.objValue;
    }

    public static /* synthetic */ int o(c cVar) {
        int i2 = cVar.v;
        cVar.v = i2 - 1;
        return i2;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57546d : (View) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.w = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar) {
        AdInfo.AdBaseInfo adBaseInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) != null) {
            return;
        }
        this.B = (TextUtils.isEmpty(bVar.f57557d) || TextUtils.isEmpty(bVar.f57556c)) ? false : true;
        this.f57547e = (KsAdWebView) a(R.id.ksad_video_webview);
        TextView textView = (TextView) a(R.id.ksad_kwad_titlebar_title);
        this.f57548f = (ImageView) a(R.id.ksad_kwad_web_navi_back);
        a((WebView) this.f57547e);
        c(this.f57547e);
        this.f57547e.setTemplateData(this.f57544b);
        this.f57547e.loadUrl(bVar.f57556c);
        this.f57547e.b();
        this.f57547e.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.c.1
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

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.a.B && this.a.o.getVisibility() == 0) {
                    this.a.o.setVisibility(8);
                }
            }
        });
        this.f57547e.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.c.2
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
                    this.a.A = false;
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.A = true;
                    if (this.a.z) {
                        this.a.e();
                    }
                }
            }
        });
        this.f57549g = (ImageView) a(R.id.ksad_kwad_web_navi_close);
        this.r = (ViewGroup) a(R.id.ksad_landing_page_root);
        if (this.B) {
            str = bVar.f57557d;
        } else {
            List<AdInfo> list = this.f57544b.adInfoList;
            if (list == null || list.size() <= 0 || this.f57544b.adInfoList.get(0) == null || (adBaseInfo = this.f57544b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
                this.f57549g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.c.3
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

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.a.f57547e != null && this.a.f57547e.canGoBack()) {
                                this.a.f57547e.goBack();
                                com.kwad.sdk.core.report.a.l(this.a.f57544b);
                            } else if (this.a.w != null) {
                                this.a.w.onCloseBtnClicked(view);
                            }
                        }
                    }
                });
                this.f57548f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.c.4
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

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.a.f57547e != null && this.a.f57547e.canGoBack()) {
                                this.a.f57547e.goBack();
                                com.kwad.sdk.core.report.a.l(this.a.f57544b);
                            } else if (this.a.w != null) {
                                this.a.w.onBackBtnClicked(view);
                            }
                        }
                    }
                });
                if (this.f57544b != null) {
                    return;
                }
                k();
                if (com.kwad.sdk.core.response.a.a.d(com.kwad.sdk.core.response.a.d.j(this.f57544b))) {
                    l();
                    a(this.f57547e);
                } else if (this.f57545c == 4) {
                    this.f57544b.interactLandingPageShowing = true;
                    l();
                    b(this.f57547e);
                }
                b(bVar);
                this.f57550h = (LinearLayout) a(R.id.ksad_reward_land_page_open_tip);
                this.f57551i = (TextView) a(R.id.ksad_reward_land_page_open_desc);
                this.f57552j = (TextView) a(R.id.ksad_reward_land_page_open_minute);
                this.f57553k = (TextView) a(R.id.ksad_reward_land_page_open_colon);
                this.l = (TextView) a(R.id.ksad_reward_land_page_open_second);
                if (com.kwad.sdk.core.response.a.d.v(this.f57544b)) {
                    this.f57550h.setVisibility(0);
                    if (!this.f57544b.mRewardVerifyCalled) {
                        h();
                        this.m.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.core.page.c.5
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
                            @SuppressLint({"SetTextI18n"})
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (this.a.n) {
                                        this.a.m.postDelayed(this, 500L);
                                        return;
                                    }
                                    if (this.a.v <= 0) {
                                        this.a.f57551i.setText("任务已完成");
                                        this.a.f57552j.setVisibility(8);
                                        this.a.f57553k.setVisibility(8);
                                        this.a.l.setVisibility(8);
                                        com.kwad.sdk.reward.d.a().b();
                                    } else {
                                        this.a.h();
                                        this.a.m.postDelayed(this, 1000L);
                                    }
                                    c.o(this.a);
                                }
                            }
                        }, 1000L);
                        return;
                    }
                    this.f57551i.setText("任务已完成");
                    this.f57552j.setVisibility(8);
                    this.f57553k.setVisibility(8);
                    this.l.setVisibility(8);
                    return;
                }
                return;
            }
            str = adBaseInfo.productName;
        }
        textView.setText(str);
        this.f57549g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = objArr;
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (this.a.f57547e != null && this.a.f57547e.canGoBack()) {
                        this.a.f57547e.goBack();
                        com.kwad.sdk.core.report.a.l(this.a.f57544b);
                    } else if (this.a.w != null) {
                        this.a.w.onCloseBtnClicked(view);
                    }
                }
            }
        });
        this.f57548f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = objArr;
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (this.a.f57547e != null && this.a.f57547e.canGoBack()) {
                        this.a.f57547e.goBack();
                        com.kwad.sdk.core.report.a.l(this.a.f57544b);
                    } else if (this.a.w != null) {
                        this.a.w.onBackBtnClicked(view);
                    }
                }
            }
        });
        if (this.f57544b != null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.y = aVar.a;
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57548f : (View) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57549g : (View) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.y == 1 : invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.A) {
            s sVar = this.x;
            if (sVar != null) {
                sVar.c();
            }
            View view = this.f57546d;
            if (view != null) {
                view.setVisibility(0);
            }
            s sVar2 = this.x;
            if (sVar2 != null) {
                sVar2.d();
            }
            if (com.kwad.sdk.core.response.a.d.v(this.f57544b)) {
                this.n = false;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            s sVar = this.x;
            if (sVar != null) {
                sVar.e();
            }
            View view = this.f57546d;
            if (view != null) {
                view.setVisibility(8);
            }
            s sVar2 = this.x;
            if (sVar2 != null) {
                sVar2.f();
            }
            if (com.kwad.sdk.core.response.a.d.v(this.f57544b)) {
                this.n = true;
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            KsAdWebView ksAdWebView = this.f57547e;
            if (ksAdWebView != null) {
                ksAdWebView.c();
                this.f57547e = null;
            }
            if (com.kwad.sdk.core.response.a.d.v(this.f57544b)) {
                this.m.removeCallbacksAndMessages(null);
            }
        }
    }
}
