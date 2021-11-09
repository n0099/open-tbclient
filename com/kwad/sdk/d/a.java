package com.kwad.sdk.d;

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
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.av;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f65522a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65523b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f65524c;

    /* renamed from: d  reason: collision with root package name */
    public long f65525d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f65526e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f65527f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f65528g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65529h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65530i;
    public AdTemplate j;
    public InterfaceC1922a k;
    public Handler l;
    public FrameLayout m;
    @Nullable
    public a.b n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: com.kwad.sdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1922a {
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
        this.f65523b = true;
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
            this.f65522a = av.a((ViewGroup) this.m, b(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.ksad_web_card_webView);
            this.f65528g = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            n.a aVar = new n.a();
            aVar.l = 1;
            this.f65528g.setClientParams(aVar);
            this.f65528g.setTemplateData(this.j);
            this.f65528g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65531a;

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
                    this.f65531a = this;
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
                        this.f65531a.f65523b = true;
                        if (this.f65531a.o != null) {
                            this.f65531a.o.a(this.f65531a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f65531a.o == null) {
                        return;
                    }
                    this.f65531a.o.a(this.f65531a.f());
                }
            });
            this.f65528g.setDeepLinkEnabled(false);
            this.f65528g.setInsideDownloadEnable(false);
            this.f65528g.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.sdk.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65532a;

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
                    this.f65532a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        this.f65532a.q = true;
                        if (this.f65532a.o != null) {
                            this.f65532a.o.a(this.f65532a.f());
                        }
                    }
                }
            });
            this.f65528g.setDeepLinkListener(new KsAdWebView.b(this) { // from class: com.kwad.sdk.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65533a;

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
                    this.f65533a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65533a.p = true;
                        if (this.f65533a.o != null) {
                            this.f65533a.o.a(this.f65533a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f65533a.p = true;
                        if (this.f65533a.o != null) {
                            this.f65533a.o.a(this.f65533a.f());
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.f65522a.findViewById(R.id.ksad_end_close_btn);
            this.f65527f = imageView;
            imageView.setVisibility(8);
            this.f65527f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65534a;

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
                    this.f65534a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f65534a.e();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            KsAdWebView ksAdWebView = this.f65528g;
            if (ksAdWebView != null) {
                ksAdWebView.b();
            }
            InterfaceC1922a interfaceC1922a = this.k;
            if (interfaceC1922a != null) {
                interfaceC1922a.a();
            }
            Activity activity = this.f65526e;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.r ? !this.f65523b : (this.f65523b || this.p || this.q) ? false : true : invokeV.booleanValue;
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
            this.f65530i = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) ? com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.i(adTemplate)) : (String) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.setVisibility(4);
            String a2 = a(this.j);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.f65528g.loadUrl(a2);
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            this.f65526e = activity;
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.m = frameLayout;
            this.f65524c = adBaseFrameLayout;
            this.j = adTemplate;
            d();
            this.f65523b = false;
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void a(InterfaceC1922a interfaceC1922a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1922a) == null) {
            this.k = interfaceC1922a;
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
            if (g2 && this.f65526e != null) {
                this.f65528g.setDeepLinkEnabled(true);
                this.f65528g.setInsideDownloadEnable(true);
                ab.d(this.f65526e);
                this.f65524c.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.d.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65535a;

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
                        this.f65535a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (motionEvent.getX() > this.f65535a.f65527f.getX() && motionEvent.getX() - this.f65535a.f65527f.getX() < this.f65535a.f65527f.getWidth() && motionEvent.getY() > this.f65535a.f65527f.getY() && motionEvent.getY() - this.f65535a.f65527f.getY() < this.f65535a.f65527f.getHeight()) {
                                com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.f65535a.f65525d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f65535a.f65525d;
                                if (this.f65535a.f65525d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.f65535a.j, 72, this.f65535a.f65524c.getTouchCoords());
                                    if (!this.f65535a.f65529h) {
                                        this.f65535a.f65529h = true;
                                        if (this.f65535a.n != null) {
                                            this.f65535a.n.a(null);
                                        }
                                    }
                                }
                                this.f65535a.f65525d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long v = com.kwad.sdk.core.config.c.v() * 1000;
                if (v == 0 || !this.f65530i) {
                    this.f65527f.setVisibility(0);
                } else {
                    this.l.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.d.a.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f65536a;

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
                            this.f65536a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65536a.f65526e == null || this.f65536a.f65526e.isFinishing()) {
                                return;
                            }
                            this.f65536a.f65527f.setVisibility(0);
                            this.f65536a.f65527f.setAlpha(0.0f);
                            this.f65536a.f65527f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, v);
                }
                KsAdWebView ksAdWebView = this.f65528g;
                if (ksAdWebView != null) {
                    ksAdWebView.a();
                }
            }
            return g2;
        }
        return invokeV.booleanValue;
    }
}
