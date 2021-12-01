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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58623b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f58624c;

    /* renamed from: d  reason: collision with root package name */
    public long f58625d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f58626e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58627f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f58628g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58629h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58630i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f58631j;

    /* renamed from: k  reason: collision with root package name */
    public InterfaceC2044a f58632k;
    public Handler l;
    public FrameLayout m;
    @Nullable
    public b.c n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2044a {
        void a();
    }

    /* loaded from: classes2.dex */
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
        this.f58623b = true;
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
            this.f58628g = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            p.a aVar = new p.a();
            aVar.n = 1;
            this.f58628g.setClientParams(aVar);
            this.f58628g.setTemplateData(this.f58631j);
            this.f58628g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.i.a.1
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
                        this.a.f58623b = true;
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
            this.f58628g.setDeepLinkEnabled(false);
            this.f58628g.setInsideDownloadEnable(false);
            this.f58628g.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.sdk.i.a.2
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
            this.f58628g.setDeepLinkListener(new KsAdWebView.b(this) { // from class: com.kwad.sdk.i.a.3
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
            this.f58627f = imageView;
            imageView.setVisibility(8);
            this.f58627f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.i.a.4
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
            KsAdWebView ksAdWebView = this.f58628g;
            if (ksAdWebView != null) {
                ksAdWebView.c();
            }
            InterfaceC2044a interfaceC2044a = this.f58632k;
            if (interfaceC2044a != null) {
                interfaceC2044a.a();
            }
            Activity activity = this.f58626e;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.r ? !this.f58623b : (this.f58623b || this.p || this.q) ? false : true : invokeV.booleanValue;
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
            this.f58630i = z;
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
            String a = a(this.f58631j);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.f58628g.loadUrl(a);
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            this.f58626e = activity;
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.m = frameLayout;
            this.f58624c = adBaseFrameLayout;
            this.f58631j = adTemplate;
            d();
            this.f58623b = false;
        }
    }

    public void a(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void a(InterfaceC2044a interfaceC2044a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC2044a) == null) {
            this.f58632k = interfaceC2044a;
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
            if (g2 && this.f58626e != null) {
                this.f58628g.setDeepLinkEnabled(true);
                this.f58628g.setInsideDownloadEnable(true);
                this.f58624c.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.i.a.5
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
                            if (motionEvent.getX() > this.a.f58627f.getX() && motionEvent.getX() - this.a.f58627f.getX() < this.a.f58627f.getWidth() && motionEvent.getY() > this.a.f58627f.getY() && motionEvent.getY() - this.a.f58627f.getY() < this.a.f58627f.getHeight()) {
                                com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.a.f58625d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.f58625d;
                                if (this.a.f58625d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.a.f58631j, (int) com.baidu.apollon.a.f32872e, this.a.f58624c.getTouchCoords());
                                    if (!this.a.f58629h) {
                                        this.a.f58629h = true;
                                        if (this.a.n != null) {
                                            b.a aVar = new b.a();
                                            aVar.f57988c = 3;
                                            this.a.n.a(aVar);
                                        }
                                    }
                                }
                                this.a.f58625d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long t = com.kwad.sdk.core.config.b.t() * 1000;
                if (t == 0 || !this.f58630i) {
                    this.f58627f.setVisibility(0);
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
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f58626e == null || this.a.f58626e.isFinishing()) {
                                return;
                            }
                            this.a.f58627f.setVisibility(0);
                            this.a.f58627f.setAlpha(0.0f);
                            this.a.f58627f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, t);
                }
                KsAdWebView ksAdWebView = this.f58628g;
                if (ksAdWebView != null) {
                    ksAdWebView.b();
                }
            }
            return g2;
        }
        return invokeV.booleanValue;
    }
}
