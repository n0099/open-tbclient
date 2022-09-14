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
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes7.dex */
public final class c implements x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int FH;
    public LinearLayout FI;
    public TextView FJ;
    public TextView FK;
    public TextView FL;
    public TextView FM;
    public com.kwad.components.core.webview.a.a FN;
    public int FO;
    public a FP;
    public aa FQ;
    public int FR;
    public boolean FS;
    public boolean FT;
    public boolean FU;
    public z FV;
    public String FW;
    public boolean counterPaused;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public Context mContext;
    public Handler mHandler;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public boolean mNormalMode;
    public com.kwad.components.core.kwai.a mTitleBarHelper;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public ViewGroup zO;

    /* loaded from: classes7.dex */
    public interface a {
        void onBackBtnClicked(View view2);

        void onCloseBtnClicked(View view2);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String FC;
        public final String FD;
        public final boolean FY;
        public final boolean FZ;

        public b(C0582c c0582c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0582c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.FY = c0582c.FY;
            this.FZ = c0582c.FZ;
            this.FD = c0582c.FD;
            this.FC = c0582c.FC;
        }

        public /* synthetic */ b(C0582c c0582c, byte b) {
            this(c0582c);
        }
    }

    /* renamed from: com.kwad.components.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0582c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String FC;
        public String FD;
        public boolean FY;
        public boolean FZ;

        public C0582c() {
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
            this.FY = true;
            this.FZ = true;
        }

        public final C0582c aq(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.FC = str;
                return this;
            }
            return (C0582c) invokeL.objValue;
        }

        public final C0582c ar(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.FD = str;
                return this;
            }
            return (C0582c) invokeL.objValue;
        }

        public final C0582c as(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.FY = true;
                return this;
            }
            return (C0582c) invokeZ.objValue;
        }

        public final C0582c at(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.FZ = false;
                return this;
            }
            return (C0582c) invokeZ.objValue;
        }

        public final b nI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this, (byte) 0) : (b) invokeV.objValue;
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
        this.mHandler = new Handler(Looper.getMainLooper());
        this.counterPaused = true;
        this.FR = -1;
        this.FS = false;
        this.FT = false;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.FH = i;
        this.FS = z;
        this.zO = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0401, (ViewGroup) null);
        this.FO = com.kwad.sdk.core.config.d.sf();
    }

    public static void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, webView) == null) {
            webView.getSettings().setAllowFileAccess(true);
        }
    }

    private void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, ksAdWebView) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.mJsBridgeContext);
            this.FN = aVar;
            ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
        }
    }

    private void b(b bVar) {
        com.kwad.components.core.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, bVar) == null) || bVar == null || (aVar = this.mTitleBarHelper) == null) {
            return;
        }
        aVar.ag(bVar.FZ);
        this.mTitleBarHelper.ah(bVar.FY);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, ksAdWebView) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
            this.mJsInterface = aVar;
            b(aVar);
            ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private void b(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, aVar) == null) {
            aa aaVar = new aa();
            this.FQ = aaVar;
            aVar.a(aaVar);
            aVar.a(new x(this, this.FW));
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            aVar.a(new i(this.mJsBridgeContext, cVar, getClickListener(), true));
            aVar.a(new f(this.mJsBridgeContext, cVar, getClickListener(), true, 0, false));
            aVar.a(new ac(this.mJsBridgeContext, cVar));
            aVar.a(new p(this.mJsBridgeContext));
            aVar.a(new y(this.mJsBridgeContext));
            aVar.a(new s(this.mJsBridgeContext));
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new af(new af.a(this) { // from class: com.kwad.components.core.page.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c FX;

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
                    this.FX = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.af.a
                public final void nH() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.a.b.bt(this.FX.mAdTemplate)) {
                        com.kwad.components.core.c.kwai.b.a(new b.a().ah(this.FX.mContext).K(this.FX.mAdTemplate).ak(com.kwad.sdk.core.response.a.b.bs(this.FX.mAdTemplate)).ms());
                    }
                }
            }));
            z zVar = new z();
            this.FV = zVar;
            aVar.a(zVar);
        }
    }

    private void c(b bVar) {
        String bl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, bVar) == null) {
            this.FU = TextUtils.equals(bVar.FD, com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)));
            if (this.mNormalMode) {
                bl = bVar.FC;
            } else {
                List<AdInfo> list = this.mAdTemplate.adInfoList;
                bl = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            }
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.zO);
            this.mTitleBarHelper = aVar;
            aVar.a(new com.kwad.components.core.kwai.b(bl));
            this.mTitleBarHelper.a(new a.InterfaceC0580a(this) { // from class: com.kwad.components.core.page.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c FX;

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
                    this.FX = this;
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0580a
                public final void r(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.FX.mAdWebView == null || !this.FX.mAdWebView.canGoBack()) {
                            if (this.FX.FP != null) {
                                this.FX.FP.onBackBtnClicked(view2);
                                return;
                            }
                            return;
                        }
                        this.FX.mAdWebView.goBack();
                        if (this.FX.FU) {
                            com.kwad.sdk.core.report.a.ay(this.FX.mAdTemplate);
                        }
                    }
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0580a
                public final void s(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        if (this.FX.mAdWebView == null || !this.FX.mAdWebView.canGoBack()) {
                            if (this.FX.FP != null) {
                                this.FX.FP.onCloseBtnClicked(view2);
                                return;
                            }
                            return;
                        }
                        this.FX.mAdWebView.goBack();
                        if (this.FX.FU) {
                            com.kwad.sdk.core.report.a.ay(this.FX.mAdTemplate);
                        }
                    }
                }
            });
        }
    }

    private void clearJsInterfaceRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.components.core.webview.a aVar = this.mJsInterface;
            if (aVar != null) {
                aVar.destroy();
                this.mJsInterface = null;
            }
            com.kwad.components.core.webview.a.a aVar2 = this.FN;
            if (aVar2 != null) {
                aVar2.destroy();
                this.FN = null;
            }
        }
    }

    private <T extends View> T findViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i)) == null) {
            ViewGroup viewGroup = this.zO;
            if (viewGroup == null) {
                return null;
            }
            return (T) viewGroup.findViewById(i);
        }
        return (T) invokeI.objValue;
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.core.page.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c FX;

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
                this.FX = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? new KsAdWebView.c(this) { // from class: com.kwad.components.core.page.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c FX;

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
                this.FX = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.c
            public final void nu() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.FX.mNormalMode && this.FX.mWebTipBarLayout.getVisibility() == 0) {
                    this.FX.mWebTipBarLayout.setVisibility(8);
                }
            }
        } : (KsAdWebView.c) invokeV.objValue;
    }

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.FO;
        cVar.FO = i - 1;
        return i;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            bVar2.Fv = this.mAdWebView;
            bVar2.Gl = this.mWebContainer;
        }
    }

    private void initTipBarView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091244);
            this.mWebTipBarLayout = linearLayout;
            if (this.mNormalMode) {
                linearLayout.setVisibility(8);
                return;
            }
            this.mWebTipBarTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f091245);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091246);
            this.mWebTipBarCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c FX;

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
                    this.FX = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.FX.mWebTipBarLayout.setVisibility(8);
                    }
                }
            });
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            boolean aQ = com.kwad.sdk.core.response.a.a.aQ(bQ);
            String aM = com.kwad.sdk.core.response.a.a.aM(bQ);
            if (!aQ) {
                this.mWebTipBarLayout.setVisibility(8);
                return;
            }
            this.mWebTipBarLayout.setVisibility(0);
            this.mWebTipBarTitle.setText(aM);
            this.mWebTipBarTitle.setSelected(true);
        }
    }

    private void nA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            a((WebView) this.mAdWebView);
            this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().R(this.mAdTemplate).b(nG()).b(nC()).a(nB()).a(getOnWebViewScrollChangeListener()));
            if (com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                inflateJsBridgeContext();
                a(this.mAdWebView);
            } else if (this.FH == 4) {
                this.mAdTemplate.interactLandingPageShowing = true;
                inflateJsBridgeContext();
                b(this.mAdWebView);
            }
            this.mAdWebView.loadUrl(this.FW);
            this.mAdWebView.pp();
        }
    }

    @NonNull
    private KsAdWebView.b nB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) ? new KsAdWebView.b(this) { // from class: com.kwad.components.core.page.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c FX;

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
                this.FX = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void kU() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.FX.FV == null) {
                    return;
                }
                this.FX.FV.kU();
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void onSuccess() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.FX.FV == null) {
                    return;
                }
                this.FX.FV.onSuccess();
            }
        } : (KsAdWebView.b) invokeV.objValue;
    }

    private KsAdWebView.d nC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.core.page.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c FX;

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
                this.FX = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.FX.FT = false;
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.FX.FT = true;
                    if (this.FX.FS) {
                        this.FX.show();
                    }
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.FK.setText(nE());
            this.FM.setText(nF());
        }
    }

    private String nE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            int i = this.FO / 60;
            StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
            sb.append(i);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private String nF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            int i = this.FO % 60;
            StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
            sb.append(i);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private u.b nG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            u.b bVar = new u.b();
            bVar.abM = 0;
            bVar.FH = this.FH;
            return bVar;
        }
        return (u.b) invokeV.objValue;
    }

    private void nz() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65571, this) == null) && com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
            this.FI.setVisibility(0);
            if (!this.mAdTemplate.mRewardVerifyCalled) {
                nD();
                this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.core.page.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c FX;

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
                        this.FX = this;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.FX.counterPaused) {
                                this.FX.mHandler.postDelayed(this, 500L);
                                return;
                            }
                            if (this.FX.FO <= 0) {
                                this.FX.FJ.setText("任务已完成");
                                this.FX.FK.setVisibility(8);
                                this.FX.FL.setVisibility(8);
                                this.FX.FM.setVisibility(8);
                                g gVar = (g) com.kwad.sdk.components.c.f(g.class);
                                if (gVar != null) {
                                    gVar.notifyRewardVerify();
                                }
                            } else {
                                this.FX.nD();
                                this.FX.mHandler.postDelayed(this, 1000L);
                            }
                            c.i(this.FX);
                        }
                    }
                }, 1000L);
                return;
            }
            this.FJ.setText("任务已完成");
            this.FK.setVisibility(8);
            this.FL.setVisibility(8);
            this.FM.setVisibility(8);
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.FP = aVar;
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || this.mAdTemplate == null) {
            return;
        }
        this.FW = bVar.FD;
        this.mNormalMode = (TextUtils.isEmpty(bVar.FC) || TextUtils.isEmpty(bVar.FD)) ? false : true;
        this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09123b);
        this.mWebContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910ee);
        this.FI = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09118c);
        this.FJ = (TextView) findViewById(R.id.obfuscated_res_0x7f091189);
        this.FK = (TextView) findViewById(R.id.obfuscated_res_0x7f09118a);
        this.FL = (TextView) findViewById(R.id.obfuscated_res_0x7f091188);
        this.FM = (TextView) findViewById(R.id.obfuscated_res_0x7f09118b);
        initTipBarView();
        c(bVar);
        nA();
        b(bVar);
        nz();
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.FR = aVar.status;
        }
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityDestroy();
                this.mAdWebView = null;
            }
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
        }
    }

    public final View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zO : (View) invokeV.objValue;
    }

    public final void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            aa aaVar = this.FQ;
            if (aaVar != null) {
                aaVar.pA();
            }
            ViewGroup viewGroup = this.zO;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            aa aaVar2 = this.FQ;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.counterPaused = true;
            }
        }
    }

    public final boolean ny() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.FR == 1 : invokeV.booleanValue;
    }

    public final void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.FT) {
            aa aaVar = this.FQ;
            if (aaVar != null) {
                aaVar.py();
            }
            try {
                if (this.zO != null) {
                    this.zO.setVisibility(0);
                }
            } catch (Exception e) {
                com.kwad.components.core.b.a.b(e);
            }
            aa aaVar2 = this.FQ;
            if (aaVar2 != null) {
                aaVar2.pz();
            }
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.counterPaused = false;
            }
        }
    }
}
