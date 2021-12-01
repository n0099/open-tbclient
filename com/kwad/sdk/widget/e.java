package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.z;
import com.kwad.sdk.utils.be;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final KsAdWebView a;

    /* renamed from: b  reason: collision with root package name */
    public long f59779b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f59780c;

    /* renamed from: d  reason: collision with root package name */
    public Context f59781d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59782e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59783f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59784g;

    /* renamed from: h  reason: collision with root package name */
    public s f59785h;

    /* renamed from: i  reason: collision with root package name */
    public int f59786i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public p.b f59787j;

    /* loaded from: classes2.dex */
    public static class a implements z.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<e> a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(eVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.z.b
        public void a(int i2) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (eVar = this.a.get()) == null) {
                return;
            }
            eVar.a(i2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public e(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdWebView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.widget.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a.f59779b = SystemClock.elapsedRealtime();
                        return false;
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
        a(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || f() == null) {
            return;
        }
        long X = com.kwad.sdk.core.config.b.X();
        if (X <= 0 || SystemClock.elapsedRealtime() - this.f59779b <= X) {
            p.a aVar = new p.a();
            aVar.f57681b = i2;
            aVar.f57686g = this.f59780c.getTouchCoords();
            com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.f59781d).a(this.f59782e).a(this.f59783f).a(false).a(aVar).c(true));
        }
    }

    private void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, ksAdWebView) == null) {
            WebSettings a2 = be.a(ksAdWebView);
            a2.setCacheMode(2);
            if (Build.VERSION.SDK_INT >= 17 && com.kwad.sdk.core.config.b.I()) {
                a2.setMediaPlaybackRequiresUserGesture(false);
            }
            ksAdWebView.setWebChromeClient(new WebChromeClient(this) { // from class: com.kwad.sdk.widget.e.2
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

                @Override // android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, consoleMessage)) == null) {
                        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "onConsoleMessage: " + consoleMessage.message());
                        return super.onConsoleMessage(consoleMessage);
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private void a(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.webview.kwai.g gVar, com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, aVar, gVar, bVar) == null) {
            gVar.a(new z(aVar, bVar, new a(this)));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.p(new p.b(this) { // from class: com.kwad.sdk.widget.e.3
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

                @Override // com.kwad.sdk.core.webview.jshandler.p.b
                public void a(p.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        this.a.f59786i = aVar2.a;
                        if (aVar2.a == 1 && this.a.f59782e != null) {
                            com.kwad.sdk.core.report.a.o(this.a.f59782e);
                        }
                        if (this.a.f59787j != null) {
                            this.a.f59787j.a(aVar2);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.k(aVar));
            s sVar = new s();
            this.f59785h = sVar;
            gVar.a(sVar);
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (gVar = this.f59784g) == null) {
            return;
        }
        gVar.a();
        this.f59784g = null;
    }

    public void a() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f59784g) == null) {
            return;
        }
        gVar.a();
        this.f59784g = null;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, adBaseFrameLayout, bVar) == null) {
            if (this.a == null) {
                com.kwad.sdk.core.d.a.d("PlayableViewHelper", "registerJsBridge mPlayableView is null");
                return;
            }
            this.f59781d = adBaseFrameLayout.getContext();
            this.f59780c = adBaseFrameLayout;
            this.f59782e = adTemplate;
            this.f59783f = bVar;
            this.f59786i = -1;
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            aVar.a(adTemplate);
            aVar.a = 0;
            AdBaseFrameLayout adBaseFrameLayout2 = this.f59780c;
            aVar.f57955b = adBaseFrameLayout2;
            aVar.f57957d = adBaseFrameLayout2;
            aVar.f57958e = this.a;
            aVar.f57959f = bVar;
            g();
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.a);
            this.f59784g = gVar;
            a(aVar, gVar, bVar);
            this.a.addJavascriptInterface(this.f59784g, "KwaiAd");
        }
    }

    public void a(@Nullable p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f59787j = bVar;
        }
    }

    public void b() {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (adTemplate = this.f59782e) == null || this.a == null) {
            return;
        }
        String ap = com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.j(adTemplate));
        if (!TextUtils.isEmpty(ap)) {
            this.a.loadUrl(ap);
        }
        com.kwad.sdk.core.report.a.p(this.f59782e);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
        s sVar = this.f59785h;
        if (sVar != null) {
            sVar.c();
        }
        this.a.setVisibility(0);
        s sVar2 = this.f59785h;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
            if (this.a == null) {
                return;
            }
            s sVar = this.f59785h;
            if (sVar != null) {
                sVar.e();
            }
            this.a.setVisibility(8);
            s sVar2 = this.f59785h;
            if (sVar2 != null) {
                sVar2.f();
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a != null && this.f59786i == 1 : invokeV.booleanValue;
    }

    @Nullable
    public AdTemplate f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59782e : (AdTemplate) invokeV.objValue;
    }
}
