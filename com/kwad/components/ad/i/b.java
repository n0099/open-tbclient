package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View BT;
    public List<AdTemplate> Ca;
    @NonNull
    public List<c> Cb;
    public boolean Cc;
    public String Cd;
    public c.a Ce;
    public a Cf;
    @Nullable
    public InterfaceC0559b Cg;
    public KsAdWebView bF;
    public int bH;
    public aa bI;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public q.b bL;
    public x.b bM;
    public FrameLayout bS;
    public AdBaseFrameLayout ct;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public ae uF;

    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.kwad.components.ad.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0559b {
        void hk();
    }

    public b() {
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
        this.Ca = new ArrayList();
        this.Cb = new ArrayList();
        this.bH = -1;
        this.Cc = false;
        this.bL = new q.b(this) { // from class: com.kwad.components.ad.i.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b Ch;

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
                this.Ch = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.Ch.kV();
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.i.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b Ch;

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
                this.Ch = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.Ch.bH = aVar.status;
                    com.kwad.sdk.core.e.b.i("PlayEndWebCard", this.Ch.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + this.Ch.Cd);
                    if (aVar.isSuccess() && this.Ch.Cg != null) {
                        this.Ch.Cg.hk();
                    }
                }
            }
        };
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Ca = new ArrayList();
        this.Cb = new ArrayList();
        this.bH = -1;
        this.Cc = false;
        this.bL = new q.b(this) { // from class: com.kwad.components.ad.i.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b Ch;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Ch = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.Ch.kV();
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.i.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b Ch;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Ch = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.Ch.bH = aVar.status;
                    com.kwad.sdk.core.e.b.i("PlayEndWebCard", this.Ch.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + this.Ch.Cd);
                    if (aVar.isSuccess() && this.Ch.Cg != null) {
                        this.Ch.Cg.hk();
                    }
                }
            }
        };
        this.mReportExtData = jSONObject;
        this.Cd = str;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            clearJsInterfaceRegister();
            this.bF.getSettings().setAllowFileAccess(true);
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private void aM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int i = this.bH;
            String str = i == -1 ? com.alipay.sdk.data.a.O : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.e.b.w("PlayEndWebCard", "show webCard fail, reason: " + str);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    public static int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? R.layout.obfuscated_res_0x7f0d0424 : invokeV.intValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.i.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b Ch;

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
                this.Ch = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.Ch.Cc = false;
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
                    b bVar = this.Ch;
                    bVar.Cc = true;
                    bVar.fm();
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = this.mScreenOrientation;
            bVar2.agd = this.ct;
            bVar2.Gl = this.bS;
            bVar2.Fv = this.bF;
            bVar2.mReportExtData = this.mReportExtData;
            b(bVar2);
        }
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, frameLayout, adBaseFrameLayout, adTemplate, cVar) == null) {
            a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
        }
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, cVar, Integer.valueOf(i)}) == null) {
            this.Cb.add(cVar);
            this.ct = adBaseFrameLayout;
            this.bS = frameLayout;
            this.mScreenOrientation = i;
            this.mAdTemplate = adTemplate;
            fh();
            inflateJsBridgeContext();
        }
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<com.kwad.components.core.c.a.c> list2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{frameLayout, adBaseFrameLayout, list, list2, Integer.valueOf(i)}) == null) {
            this.Cb = list2;
            this.ct = adBaseFrameLayout;
            this.bS = frameLayout;
            this.mScreenOrientation = i;
            if (list != null && list.size() > 0) {
                this.Ca = list;
                this.mAdTemplate = list.get(0);
            }
            fh();
            inflateJsBridgeContext();
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.Cf = aVar;
        }
    }

    public final void a(@Nullable InterfaceC0559b interfaceC0559b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC0559b) == null) {
            this.Cg = interfaceC0559b;
            this.bS.setVisibility(4);
            this.bH = -1;
            String l = l(this.mAdTemplate);
            com.kwad.sdk.core.e.b.d("PlayEndWebCard", "startPreloadWebView url : " + l);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            aF();
            fl();
            this.bF.loadUrl(l);
        }
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (this.Cb.size() <= 1 || this.Ca.size() <= 1) {
                com.kwad.components.core.c.a.c cVar = this.Cb.get(0);
                aVar.a(new i(this.mJsBridgeContext, cVar, this.bJ));
                aVar.a(new f(this.mJsBridgeContext, cVar, this.bJ));
                aVar.a(new ac(this.mJsBridgeContext, cVar));
            } else {
                aVar.a(new i(this.mJsBridgeContext, this.Cb.get(0), this.bJ));
                aVar.a(new f(this.mJsBridgeContext, this.Cb, this.bJ));
                aVar.a(new u(this.Ca, this.Cb));
            }
            ae aeVar = new ae();
            this.uF = aeVar;
            aVar.a(aeVar);
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(new k(this.mJsBridgeContext));
            aVar.a(new x(this.bM, l(this.mAdTemplate)));
            aa aaVar = new aa();
            this.bI = aaVar;
            aVar.a(aaVar);
            aVar.a(new q(this.bL));
            aVar.a(new s(this.mJsBridgeContext));
            com.kwad.components.core.webview.jshandler.c cVar2 = new com.kwad.components.core.webview.jshandler.c();
            cVar2.b(new c.a(this) { // from class: com.kwad.components.ad.i.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b Ch;

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
                    this.Ch = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.c.a
                public final void onPlayAgainClick() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.Ch.Ce == null) {
                        return;
                    }
                    this.Ch.Ce.onPlayAgainClick();
                }
            });
            aVar.a(cVar2);
        }
    }

    public final void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.Ce = aVar;
        }
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.bJ = aVar;
        }
    }

    public final void af(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.uF.af(true);
        }
    }

    public final boolean ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!bs()) {
                FrameLayout frameLayout = this.bS;
                if (frameLayout != null) {
                    frameLayout.setVisibility(4);
                }
                aM();
                return false;
            }
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.py();
            }
            FrameLayout frameLayout2 = this.bS;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            if (this.bI != null && fi()) {
                this.bI.pz();
            }
            a aVar = this.Cf;
            if (aVar != null) {
                aVar.a(this);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            bVar.setAdTemplate(this.mAdTemplate);
        }
    }

    public boolean bs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.bH == 1 : invokeV.booleanValue;
    }

    public final void bt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            clearJsInterfaceRegister();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void fh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.bS.removeAllViews();
            this.bS.setVisibility(4);
            this.BT = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.bS, getLayoutId(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.bS.findViewById(R.id.obfuscated_res_0x7f09131e);
            this.bF = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.bF.getBackground().setAlpha(0);
            this.bF.setClientConfig(this.bF.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
            fk();
        }
    }

    public boolean fi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void fk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void fl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void fm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public final long getLoadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            KsAdWebView ksAdWebView = this.bF;
            if (ksAdWebView != null) {
                return ksAdWebView.getLoadTime();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "PlayEndWebCard" : (String) invokeV.objValue;
    }

    public final void kV() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && com.kwad.sdk.b.kwai.a.a((View) this.bF, 50, false)) {
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.bS.setVisibility(4);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
        }
    }

    public final FrameLayout kW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.bS : (FrameLayout) invokeV.objValue;
    }

    public String l(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, adTemplate)) == null) {
            String str = this.Cd;
            return str == null ? com.kwad.sdk.core.response.a.b.bb(this.mAdTemplate) : str;
        }
        return (String) invokeL.objValue;
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            clearJsInterfaceRegister();
            this.Cg = null;
        }
    }
}
