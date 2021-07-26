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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f35584a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35585b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f35586c;

    /* renamed from: d  reason: collision with root package name */
    public long f35587d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f35588e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35589f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f35590g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35591h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35592i;
    public AdTemplate j;
    public InterfaceC0435a k;
    public Handler l;
    public FrameLayout m;
    @Nullable
    public a.b n;
    public b o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: com.kwad.sdk.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0435a {
        void a();
    }

    /* loaded from: classes6.dex */
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
        this.f35585b = true;
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
            this.f35584a = av.a((ViewGroup) this.m, b(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.ksad_web_card_webView);
            this.f35590g = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            n.a aVar = new n.a();
            aVar.l = 1;
            this.f35590g.setClientParams(aVar);
            this.f35590g.setTemplateData(this.j);
            this.f35590g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f35593a;

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
                    this.f35593a = this;
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
                        this.f35593a.f35585b = true;
                        if (this.f35593a.o != null) {
                            this.f35593a.o.a(this.f35593a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35593a.o == null) {
                        return;
                    }
                    this.f35593a.o.a(this.f35593a.f());
                }
            });
            this.f35590g.setDeepLinkEnabled(false);
            this.f35590g.setInsideDownloadEnable(false);
            this.f35590g.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.sdk.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f35594a;

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
                    this.f35594a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        this.f35594a.q = true;
                        if (this.f35594a.o != null) {
                            this.f35594a.o.a(this.f35594a.f());
                        }
                    }
                }
            });
            this.f35590g.setDeepLinkListener(new KsAdWebView.b(this) { // from class: com.kwad.sdk.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f35595a;

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
                    this.f35595a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35595a.p = true;
                        if (this.f35595a.o != null) {
                            this.f35595a.o.a(this.f35595a.f());
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f35595a.p = true;
                        if (this.f35595a.o != null) {
                            this.f35595a.o.a(this.f35595a.f());
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.f35584a.findViewById(R.id.ksad_end_close_btn);
            this.f35589f = imageView;
            imageView.setVisibility(8);
            this.f35589f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f35596a;

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
                    this.f35596a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f35596a.e();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            KsAdWebView ksAdWebView = this.f35590g;
            if (ksAdWebView != null) {
                ksAdWebView.b();
            }
            InterfaceC0435a interfaceC0435a = this.k;
            if (interfaceC0435a != null) {
                interfaceC0435a.a();
            }
            Activity activity = this.f35588e;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.r ? !this.f35585b : (this.f35585b || this.p || this.q) ? false : true : invokeV.booleanValue;
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
            this.f35592i = z;
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
            this.f35590g.loadUrl(a2);
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            this.f35588e = activity;
        }
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.m = frameLayout;
            this.f35586c = adBaseFrameLayout;
            this.j = adTemplate;
            d();
            this.f35585b = false;
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void a(InterfaceC0435a interfaceC0435a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0435a) == null) {
            this.k = interfaceC0435a;
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
            if (g2 && this.f35588e != null) {
                this.f35590g.setDeepLinkEnabled(true);
                this.f35590g.setInsideDownloadEnable(true);
                ab.d(this.f35588e);
                this.f35586c.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.d.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f35597a;

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
                        this.f35597a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (motionEvent.getX() > this.f35597a.f35589f.getX() && motionEvent.getX() - this.f35597a.f35589f.getX() < this.f35597a.f35589f.getWidth() && motionEvent.getY() > this.f35597a.f35589f.getY() && motionEvent.getY() - this.f35597a.f35589f.getY() < this.f35597a.f35589f.getHeight()) {
                                com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.f35597a.f35587d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f35597a.f35587d;
                                if (this.f35597a.f35587d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.f35597a.j, 72, this.f35597a.f35586c.getTouchCoords());
                                    if (!this.f35597a.f35591h) {
                                        this.f35597a.f35591h = true;
                                        if (this.f35597a.n != null) {
                                            this.f35597a.n.a(null);
                                        }
                                    }
                                }
                                this.f35597a.f35587d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long v = com.kwad.sdk.core.config.c.v() * 1000;
                if (v == 0 || !this.f35592i) {
                    this.f35589f.setVisibility(0);
                } else {
                    this.l.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.d.a.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f35598a;

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
                            this.f35598a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35598a.f35588e == null || this.f35598a.f35588e.isFinishing()) {
                                return;
                            }
                            this.f35598a.f35589f.setVisibility(0);
                            this.f35598a.f35589f.setAlpha(0.0f);
                            this.f35598a.f35589f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, v);
                }
                KsAdWebView ksAdWebView = this.f35590g;
                if (ksAdWebView != null) {
                    ksAdWebView.a();
                }
            }
            return g2;
        }
        return invokeV.booleanValue;
    }
}
