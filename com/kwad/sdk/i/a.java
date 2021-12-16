package com.kwad.sdk.i;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59204b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f59205c;

    /* renamed from: d  reason: collision with root package name */
    public long f59206d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f59207e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59208f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f59209g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59211i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f59212j;

    /* renamed from: k  reason: collision with root package name */
    public InterfaceC2105a f59213k;
    public Handler l;
    public FrameLayout m;
    @Nullable
    public b.c n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2105a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    public a() {
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
        this.f59204b = true;
        this.l = new Handler(Looper.getMainLooper());
        this.p = false;
        this.q = false;
        this.r = false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.m.removeAllViews();
            this.m.setVisibility(4);
            this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.m, b(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.ksad_web_card_webView);
            this.f59209g = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            p.a aVar = new p.a();
            aVar.n = 1;
            this.f59209g.setClientParams(aVar);
            this.f59209g.setTemplateData(this.f59212j);
            this.f59209g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.i.a.1
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
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        this.a.f59204b = true;
                        if (this.a.o != null) {
                            this.a.o.a(this.a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.o == null) {
                        return;
                    }
                    this.a.o.a(this.a.f());
                }
            });
            this.f59209g.setDeepLinkEnabled(false);
            this.f59209g.setInsideDownloadEnable(false);
            this.f59209g.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.sdk.i.a.2
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

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        this.a.q = true;
                        if (this.a.o != null) {
                            this.a.o.a(this.a.f());
                        }
                    }
                }
            });
            this.f59209g.setDeepLinkListener(new KsAdWebView.b(this) { // from class: com.kwad.sdk.i.a.3
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

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.p = true;
                        if (this.a.o != null) {
                            this.a.o.a(this.a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.p = true;
                        if (this.a.o != null) {
                            this.a.o.a(this.a.f());
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.a.findViewById(R.id.ksad_end_close_btn);
            this.f59208f = imageView;
            imageView.setVisibility(8);
            this.f59208f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.i.a.4
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
                        this.a.e();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            KsAdWebView ksAdWebView = this.f59209g;
            if (ksAdWebView != null) {
                ksAdWebView.c();
            }
            InterfaceC2105a interfaceC2105a = this.f59213k;
            if (interfaceC2105a != null) {
                interfaceC2105a.a();
            }
            Activity activity = this.f59207e;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.r ? !this.f59204b : (this.f59204b || this.p || this.q) ? false : true : invokeV.booleanValue;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (!f()) {
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

    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f59211i = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) ? com.kwad.sdk.core.response.a.a.G(d.j(adTemplate)) : (String) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.setVisibility(4);
            String a = a(this.f59212j);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.f59209g.loadUrl(a);
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            this.f59207e = activity;
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.m = frameLayout;
            this.f59205c = adBaseFrameLayout;
            this.f59212j = adTemplate;
            d();
            this.f59204b = false;
        }
    }

    public void a(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void a(InterfaceC2105a interfaceC2105a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC2105a) == null) {
            this.f59213k = interfaceC2105a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.ksad_ad_landingpage_layout : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean g2 = g();
            this.r = true;
            if (g2 && this.f59207e != null) {
                this.f59209g.setDeepLinkEnabled(true);
                this.f59209g.setInsideDownloadEnable(true);
                this.f59205c.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.i.a.5
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

                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (motionEvent.getX() > this.a.f59208f.getX() && motionEvent.getX() - this.a.f59208f.getX() < this.a.f59208f.getWidth() && motionEvent.getY() > this.a.f59208f.getY() && motionEvent.getY() - this.a.f59208f.getY() < this.a.f59208f.getHeight()) {
                                com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.a.f59206d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.f59206d;
                                if (this.a.f59206d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.a.f59212j, (int) com.baidu.apollon.a.f33242e, this.a.f59205c.getTouchCoords());
                                    if (!this.a.f59210h) {
                                        this.a.f59210h = true;
                                        if (this.a.n != null) {
                                            b.a aVar = new b.a();
                                            aVar.f58569c = 3;
                                            this.a.n.a(aVar);
                                        }
                                    }
                                }
                                this.a.f59206d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long t = com.kwad.sdk.core.config.b.t() * 1000;
                if (t == 0 || !this.f59211i) {
                    this.f59208f.setVisibility(0);
                } else {
                    this.l.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.i.a.6
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
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f59207e == null || this.a.f59207e.isFinishing()) {
                                return;
                            }
                            this.a.f59208f.setVisibility(0);
                            this.a.f59208f.setAlpha(0.0f);
                            this.a.f59208f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, t);
                }
                KsAdWebView ksAdWebView = this.f59209g;
                if (ksAdWebView != null) {
                    ksAdWebView.b();
                }
            }
            return g2;
        }
        return invokeV.booleanValue;
    }
}
