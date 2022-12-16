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
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.b;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int FR;
    public final KsAdWebView Hq;
    public long Hr;
    public PlayableSource Hs;
    public List<x.b> Ht;
    public List<KsAdWebView.d> Hu;
    public aa bI;
    @Nullable
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public Context mContext;
    @Nullable
    public com.kwad.components.core.webview.a mJsInterface;
    public AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0604a implements ag.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> Hw;

        public C0604a(a aVar) {
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
            this.Hw = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.b
        public final void al(int i) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (aVar = this.Hw.get()) == null) {
                return;
            }
            aVar.ak(i);
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
        this.Hs = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
        this.Ht = new CopyOnWriteArrayList();
        this.Hu = new CopyOnWriteArrayList();
        this.Hq = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.components.core.playable.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a Hv;

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
                this.Hv = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.Hv.Hr = SystemClock.elapsedRealtime();
                        return false;
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
        c(this.Hq);
    }

    private void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, aVar, cVar) == null) {
            aVar.a(new ag(bVar, cVar, new C0604a(this)));
            aVar.a(new x(new x.b(this) { // from class: com.kwad.components.core.playable.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a Hv;

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
                    this.Hv = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.x.b
                public final void a(x.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        this.Hv.FR = aVar2.status;
                        if (aVar2.status == 1 && this.Hv.mAdTemplate != null) {
                            com.kwad.sdk.core.report.a.aC(this.Hv.mAdTemplate);
                        }
                        for (x.b bVar2 : this.Hv.Ht) {
                            bVar2.a(aVar2);
                        }
                    }
                }
            }, getUrl()));
            aVar.a(new s(bVar));
            this.bI = new aa();
            aVar.a(new n());
            aVar.a(new m(bVar));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(this.bI);
            aVar.a(new com.kwad.components.core.webview.jshandler.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, this, i) == null) || getAdTemplate() == null) {
            return;
        }
        long so = d.so();
        if (so <= 0 || SystemClock.elapsedRealtime() - this.Hr <= so) {
            u.b bVar = new u.b();
            bVar.gJ = i;
            bVar.gL = this.mRootContainer.getTouchCoords();
            com.kwad.components.core.c.a.a.a(new a.C0594a(this.mContext).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).a(bVar).al(true));
        }
    }

    public static void c(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, ksAdWebView) == null) && Build.VERSION.SDK_INT >= 17 && d.sn()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    private String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            return adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        }
        return (String) invokeV.objValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.core.playable.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a Hv;

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
                this.Hv = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    for (KsAdWebView.d dVar : this.Hv.Hu) {
                        dVar.a(i, str, str2);
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    for (KsAdWebView.d dVar : this.Hv.Hu) {
                        dVar.bv();
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    for (KsAdWebView.d dVar : this.Hv.Hu) {
                        dVar.bw();
                    }
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.Hu.add(dVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.b
    public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str) == null) {
            if ("playableSrc".equals(str)) {
                aVar.f(this.Hs);
            }
            if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
                return;
            }
            aVar.as(adTemplate.adStyle);
        }
    }

    public final void a(@Nullable x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.Ht.add(bVar);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, adTemplate, adBaseFrameLayout, cVar) == null) {
            if (this.Hq == null) {
                com.kwad.sdk.core.e.b.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
                return;
            }
            this.mContext = adBaseFrameLayout.getContext();
            this.mRootContainer = adBaseFrameLayout;
            this.mAdTemplate = adTemplate;
            this.mApkDownloadHelper = cVar;
            this.FR = -1;
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            bVar.setAdTemplate(adTemplate);
            bVar.mScreenOrientation = 0;
            AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
            bVar.agd = adBaseFrameLayout2;
            bVar.Gl = adBaseFrameLayout2;
            bVar.Fv = this.Hq;
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Hq);
            this.mJsInterface = aVar;
            a(bVar, aVar, cVar);
            this.Hq.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    public final void b(@Nullable x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.Ht.remove(bVar);
        }
    }

    public final void e(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, playableSource) == null) {
            if (playableSource != null) {
                this.Hs = playableSource;
            }
            if (this.Hq == null) {
                return;
            }
            com.kwad.sdk.core.e.b.d("PlayableViewHelper", "showPlayable");
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.py();
            }
            this.Hq.setVisibility(0);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pz();
            }
        }
    }

    public final long getLoadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            KsAdWebView ksAdWebView = this.Hq;
            if (ksAdWebView != null) {
                return ksAdWebView.getLoadTime();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public final void ha() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.kwad.sdk.core.e.b.d("PlayableViewHelper", "showPlayable");
            if (this.Hq == null) {
                return;
            }
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.Hq.setVisibility(8);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
            this.Hq.reload();
        }
    }

    public final void ob() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    public final void oc() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mAdTemplate == null || this.Hq == null) {
            return;
        }
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.Hq.loadUrl(url);
        }
        com.kwad.sdk.core.report.a.aD(this.mAdTemplate);
    }

    public final boolean od() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.Hq != null && this.FR == 1 : invokeV.booleanValue;
    }
}
