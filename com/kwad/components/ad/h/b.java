package com.kwad.components.ad.h;

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
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.b.j;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.b;
import com.kwad.components.core.webview.jshandler.d;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView a;
    public AdTemplate b;
    public View c;
    public boolean d;
    public AdBaseFrameLayout e;
    public FrameLayout f;
    @Nullable
    public JSONObject g;
    public int h;
    public List<AdTemplate> i;
    @NonNull
    public List<com.kwad.components.core.c.a.b> j;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a k;
    public com.kwad.components.core.webview.a l;
    public com.kwad.sdk.core.webview.b m;
    public int n;
    public x o;
    public ab p;
    public String q;
    public b.a r;
    public a s;
    public n.b t;
    public u.b u;

    /* loaded from: classes5.dex */
    public interface a {
        void a(b bVar);
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
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.n = -1;
        this.d = false;
        this.t = new n.b(this) { // from class: com.kwad.components.ad.h.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.f();
                }
            }
        };
        this.u = new u.b(this) { // from class: com.kwad.components.ad.h.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.n = aVar.a;
                    com.kwad.sdk.core.d.b.c("PlayEndWebCard", this.a.b() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + this.a.q);
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
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.n = -1;
        this.d = false;
        this.t = new n.b(this) { // from class: com.kwad.components.ad.h.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.n.b
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.f();
                }
            }
        };
        this.u = new u.b(this) { // from class: com.kwad.components.ad.h.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.n = aVar.a;
                    com.kwad.sdk.core.d.b.c("PlayEndWebCard", this.a.b() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + this.a.q);
                }
            }
        };
        this.g = jSONObject;
        this.q = str;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? R.layout.obfuscated_res_0x7f0d0405 : invokeV.intValue;
    }

    private KsAdWebView.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.h.b.1
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
                    this.a.d = false;
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.d = true;
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.m = bVar;
            bVar.a(this.b);
            com.kwad.sdk.core.webview.b bVar2 = this.m;
            bVar2.a = this.h;
            bVar2.b = this.e;
            bVar2.d = this.f;
            bVar2.e = this.a;
            bVar2.c = this.g;
            a(bVar2);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            n();
            this.a.getSettings().setAllowFileAccess(true);
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.a);
            this.l = aVar;
            a(aVar);
            this.a.addJavascriptInterface(this.l, "KwaiAd");
        }
    }

    private void n() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.a();
        this.l = null;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int i = this.n;
            String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.d.b.d("PlayEndWebCard", "show webCard fail, reason: " + str);
        }
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
            String str = this.q;
            return str == null ? com.kwad.sdk.core.response.a.b.l(this.b) : str;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.removeAllViews();
            this.f.setVisibility(4);
            this.c = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.f, j(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.f.findViewById(R.id.obfuscated_res_0x7f0911ec);
            this.a = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.a.getBackground().setAlpha(0);
            this.a.setClientConfig(this.a.getClientConfig().a(this.b).a(k()));
        }
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, frameLayout, adBaseFrameLayout, adTemplate, bVar) == null) {
            a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
        }
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i)}) == null) {
            this.j.add(bVar);
            this.e = adBaseFrameLayout;
            this.f = frameLayout;
            this.h = i;
            this.b = adTemplate;
            a();
            l();
        }
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<com.kwad.components.core.c.a.b> list2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{frameLayout, adBaseFrameLayout, list, list2, Integer.valueOf(i)}) == null) {
            this.j = list2;
            this.e = adBaseFrameLayout;
            this.f = frameLayout;
            this.h = i;
            if (list != null && list.size() > 0) {
                this.i = list;
                this.b = list.get(0);
            }
            a();
            l();
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.j.size() <= 1 || this.i.size() <= 1) {
                com.kwad.components.core.c.a.b bVar = this.j.get(0);
                aVar.a(new f(this.m, bVar, this.k));
                aVar.a(new d(this.m, bVar, this.k));
                aVar.a(new z(this.m, bVar));
            } else {
                aVar.a(new f(this.m, this.j.get(0), this.k));
                aVar.a(new d(this.m, this.j, this.k));
                aVar.a(new r(this.i, this.j));
            }
            ab abVar = new ab();
            this.p = abVar;
            aVar.a(abVar);
            aVar.a(new i(this.m));
            aVar.a(new j());
            aVar.a(new l(this.m));
            aVar.a(new h(this.m));
            aVar.a(new u(this.u, a(this.b)));
            x xVar = new x();
            this.o = xVar;
            aVar.a(xVar);
            aVar.a(new n(this.t));
            aVar.a(new p(this.m));
            com.kwad.components.core.webview.jshandler.b bVar2 = new com.kwad.components.core.webview.jshandler.b();
            bVar2.a(new b.a(this) { // from class: com.kwad.components.ad.h.b.2
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

                @Override // com.kwad.components.core.webview.jshandler.b.a
                public final void onPlayAgainClick() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.r == null) {
                        return;
                    }
                    this.a.r.onPlayAgainClick();
                }
            });
            aVar.a(bVar2);
        }
    }

    public final void a(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.r = aVar;
        }
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            bVar.a(this.b);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "PlayEndWebCard" : (String) invokeV.objValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p.a(true);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n == 1 : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.setVisibility(4);
            this.n = -1;
            String a2 = a(this.b);
            com.kwad.sdk.core.d.b.a("PlayEndWebCard", "startPreloadWebView url : " + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            m();
            this.a.loadUrl(a2);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!c()) {
                FrameLayout frameLayout = this.f;
                if (frameLayout != null) {
                    frameLayout.setVisibility(4);
                }
                o();
                return false;
            }
            x xVar = this.o;
            if (xVar != null) {
                xVar.c();
            }
            FrameLayout frameLayout2 = this.f;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            x xVar2 = this.o;
            if (xVar2 != null) {
                xVar2.d();
            }
            a aVar = this.s;
            if (aVar != null) {
                aVar.a(this);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && com.kwad.sdk.b.kwai.a.a((View) this.a, 50, false)) {
            x xVar = this.o;
            if (xVar != null) {
                xVar.e();
            }
            this.f.setVisibility(4);
            x xVar2 = this.o;
            if (xVar2 != null) {
                xVar2.f();
            }
        }
    }

    public final FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f : (FrameLayout) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            n();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            n();
        }
    }
}
