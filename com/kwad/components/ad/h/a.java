package com.kwad.components.ad.h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public boolean b;
    public AdBaseFrameLayout c;
    public long d;
    public Activity e;
    public ImageView f;
    public KsAdWebView g;
    public boolean h;
    public boolean i;
    public AdTemplate j;
    public InterfaceC0467a k;
    public Handler l;
    public FrameLayout m;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;
    public c.a s;
    public c t;

    /* renamed from: com.kwad.components.ad.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0467a {
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void d();
    }

    public a() {
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
        this.b = true;
        this.l = new Handler(Looper.getMainLooper());
        this.p = false;
        this.q = false;
        this.r = false;
    }

    public static String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.a.N(d.i(adTemplate)) : (String) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.m.removeAllViews();
            this.m.setVisibility(4);
            this.a = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.m, f(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.obfuscated_res_0x7f0911ec);
            this.g = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            u.b bVar = new u.b();
            bVar.p = 1;
            c.a a = this.g.getClientConfig().a(false).b(false).a(bVar).a(this.j).a(e()).a(d());
            this.s = a;
            this.g.setClientConfig(a);
            this.g.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.components.ad.h.a.1
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

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        this.a.q = true;
                        if (this.a.o != null) {
                            this.a.o.a(this.a.g());
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09103d);
            this.f = imageView;
            imageView.setVisibility(8);
            this.f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.h.a.2
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

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.t == null) {
                        return;
                    }
                    this.a.t.d();
                }
            });
        }
    }

    private KsAdWebView.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.h.a.3
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
                    this.a.b = true;
                    if (this.a.o != null) {
                        this.a.o.a(this.a.g());
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.o == null) {
                    return;
                }
                this.a.o.a(this.a.g());
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private KsAdWebView.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? new KsAdWebView.b(this) { // from class: com.kwad.components.ad.h.a.4
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

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.p = true;
                    if (this.a.o != null) {
                        this.a.o.a(this.a.g());
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.p = true;
                    if (this.a.o != null) {
                        this.a.o.a(this.a.g());
                    }
                }
            }
        } : (KsAdWebView.b) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? R.layout.obfuscated_res_0x7f0d0404 : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? this.r ? !this.b : (this.b || this.p || this.q) ? false : true : invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (!g()) {
                FrameLayout frameLayout = this.m;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                return false;
            }
            FrameLayout frameLayout2 = this.m;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.setVisibility(4);
            String a = a(this.j);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.g.loadUrl(a);
        }
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            this.e = activity;
        }
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.m = frameLayout;
            this.c = adBaseFrameLayout;
            this.j = adTemplate;
            c();
            this.b = false;
        }
    }

    public final void a(InterfaceC0467a interfaceC0467a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC0467a) == null) {
            this.k = interfaceC0467a;
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            boolean h = h();
            this.r = true;
            if (h && this.e != null) {
                if (this.g.getClientConfig() != null) {
                    this.g.getClientConfig().a(true);
                    this.g.getClientConfig().b(true);
                }
                this.c.a(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.h.a.5
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

                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            if (motionEvent.getX() > this.a.f.getX() && motionEvent.getX() - this.a.f.getX() < this.a.f.getWidth() && motionEvent.getY() > this.a.f.getY() && motionEvent.getY() - this.a.f.getY() < this.a.f.getHeight()) {
                                com.kwad.sdk.core.d.b.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.a.d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.d;
                                if (this.a.d > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.a.j, 155, this.a.c.getTouchCoords());
                                    if (!this.a.h) {
                                        this.a.h = true;
                                        if (this.a.n != null) {
                                            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
                                            aVar.c = 3;
                                            this.a.n.a(aVar);
                                        }
                                    }
                                }
                                this.a.d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long u = com.kwad.sdk.core.response.a.a.u(d.i(this.j));
                if (u == 0 || !this.i) {
                    this.f.setVisibility(0);
                } else {
                    this.l.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.h.a.6
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

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.e.isFinishing()) {
                                return;
                            }
                            this.a.f.setVisibility(0);
                            this.a.f.setAlpha(0.0f);
                            this.a.f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, u);
                }
                KsAdWebView ksAdWebView = this.g;
                if (ksAdWebView != null) {
                    ksAdWebView.b();
                }
            }
            return h;
        }
        return invokeV.booleanValue;
    }
}
