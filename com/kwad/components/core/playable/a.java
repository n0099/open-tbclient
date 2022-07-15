package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.b;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class a implements a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final KsAdWebView a;
    public long b;
    public AdBaseFrameLayout c;
    public Context d;
    @Nullable
    public AdTemplate e;
    public b f;
    @Nullable
    public com.kwad.components.core.webview.a g;
    public x h;
    public int i;
    public PlayableSource j;
    public List<u.b> k;

    /* renamed from: com.kwad.components.core.playable.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0517a implements ad.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> a;

        public C0517a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.ad.b
        public final void a(int i) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (aVar = this.a.get()) == null) {
                return;
            }
            aVar.a(i);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdWebView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
        this.k = new CopyOnWriteArrayList();
        this.a = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.core.playable.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
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

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a.b = SystemClock.elapsedRealtime();
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
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) || f() == null) {
            return;
        }
        long ab = d.ab();
        if (ab <= 0 || SystemClock.elapsedRealtime() - this.b <= ab) {
            u.b bVar = new u.b();
            bVar.c = i;
            bVar.i = this.c.getTouchCoords();
            com.kwad.components.core.c.a.a.a(new a.C0507a(this.d).a(this.e).a(this.f).a(false).a(bVar).c(true));
        }
    }

    public static void a(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ksAdWebView) == null) && Build.VERSION.SDK_INT >= 17 && d.aa()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.webview.a aVar, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, bVar, aVar, bVar2) == null) {
            aVar.a(new ad(bVar, bVar2, new C0517a(this)));
            aVar.a(new com.kwad.components.core.webview.jshandler.u(new u.b(this) { // from class: com.kwad.components.core.playable.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                @Override // com.kwad.components.core.webview.jshandler.u.b
                public final void a(u.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        this.a.i = aVar2.a;
                        if (aVar2.a == 1 && this.a.e != null) {
                            com.kwad.sdk.core.report.a.n(this.a.e);
                        }
                        for (u.b bVar3 : this.a.k) {
                            bVar3.a(aVar2);
                        }
                    }
                }
            }, e()));
            aVar.a(new p(bVar));
            this.h = new x();
            aVar.a(new k());
            aVar.a(new j(bVar));
            aVar.a(new com.kwad.components.core.webview.b.j());
            aVar.a(this.h);
            aVar.a(new com.kwad.components.core.webview.jshandler.a(this));
        }
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            AdTemplate adTemplate = this.e;
            return adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.at(com.kwad.sdk.core.response.a.d.i(adTemplate));
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    private AdTemplate f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.e : (AdTemplate) invokeV.objValue;
    }

    private void g() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a();
        this.g = null;
    }

    public final void a() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.g) == null) {
            return;
        }
        aVar.a();
        this.g = null;
    }

    public final void a(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource) == null) {
            if (playableSource != null) {
                this.j = playableSource;
            }
            if (this.a == null) {
                return;
            }
            com.kwad.sdk.core.d.b.a("PlayableViewHelper", "showPlayable");
            x xVar = this.h;
            if (xVar != null) {
                xVar.c();
            }
            this.a.setVisibility(0);
            x xVar2 = this.h;
            if (xVar2 != null) {
                xVar2.d();
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, str) == null) && "playableSrc".equals(str)) {
            aVar.a(this.j);
        }
    }

    public final void a(@Nullable u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k.add(bVar);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, adTemplate, adBaseFrameLayout, bVar) == null) {
            if (this.a == null) {
                com.kwad.sdk.core.d.b.d("PlayableViewHelper", "registerJsBridge mPlayableView is null");
                return;
            }
            this.d = adBaseFrameLayout.getContext();
            this.c = adBaseFrameLayout;
            this.e = adTemplate;
            this.f = bVar;
            this.i = -1;
            com.kwad.sdk.core.webview.b bVar2 = new com.kwad.sdk.core.webview.b();
            bVar2.a(adTemplate);
            bVar2.a = 0;
            AdBaseFrameLayout adBaseFrameLayout2 = this.c;
            bVar2.b = adBaseFrameLayout2;
            bVar2.d = adBaseFrameLayout2;
            bVar2.e = this.a;
            g();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.a);
            this.g = aVar;
            a(bVar2, aVar, bVar);
            this.a.addJavascriptInterface(this.g, "KwaiAd");
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.e == null || this.a == null) {
            return;
        }
        String e = e();
        if (!TextUtils.isEmpty(e)) {
            this.a.loadUrl(e);
        }
        com.kwad.sdk.core.report.a.o(this.e);
    }

    public final void b(@Nullable u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.k.remove(bVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwad.sdk.core.d.b.a("PlayableViewHelper", "showPlayable");
            if (this.a == null) {
                return;
            }
            x xVar = this.h;
            if (xVar != null) {
                xVar.e();
            }
            this.a.setVisibility(8);
            x xVar2 = this.h;
            if (xVar2 != null) {
                xVar2.f();
            }
            this.a.reload();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a != null && this.i == 1 : invokeV.booleanValue;
    }
}
