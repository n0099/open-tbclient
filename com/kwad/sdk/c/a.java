package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
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
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34257b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f34258c;

    /* renamed from: d  reason: collision with root package name */
    public long f34259d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f34260e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34261f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f34262g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34263h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34264i;
    public AdTemplate j;
    public InterfaceC0405a k;
    public Handler l;

    /* renamed from: com.kwad.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0405a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34257b = false;
        this.l = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            InterfaceC0405a interfaceC0405a = this.k;
            if (interfaceC0405a != null) {
                interfaceC0405a.a();
            }
            Activity activity = this.f34260e;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.kwad.sdk.c.c
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_ad_landingpage_layout : invokeV.intValue;
    }

    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.f34264i = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    @Override // com.kwad.sdk.c.c
    public String a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate)) == null) ? com.kwad.sdk.core.response.b.a.B(com.kwad.sdk.core.response.b.c.j(adTemplate)) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.c.c
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            this.f34260e = activity;
        }
    }

    @Override // com.kwad.sdk.c.c
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{frameLayout, adBaseFrameLayout, adTemplate, bVar, Integer.valueOf(i2)}) == null) {
            super.a(frameLayout, adBaseFrameLayout, adTemplate, bVar, i2);
            this.j = adTemplate;
            this.f34258c = adBaseFrameLayout;
            ImageView imageView = (ImageView) this.f34271a.findViewById(R.id.ksad_end_close_btn);
            this.f34261f = imageView;
            imageView.setVisibility(8);
            f().setBackgroundColor(-1);
            if (f() instanceof KsAdWebView) {
                o.a aVar = new o.a();
                aVar.l = 1;
                ((KsAdWebView) f()).setClientParams(aVar);
            }
            WebView f2 = f();
            if (f2 instanceof KsAdWebView) {
                KsAdWebView ksAdWebView = (KsAdWebView) f2;
                this.f34262g = ksAdWebView;
                ksAdWebView.setTemplateData(adTemplate);
                this.f34262g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f34265a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34265a = this;
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a(int i3, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str, str2) == null) {
                            this.f34265a.f34257b = true;
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }
                });
            } else {
                f2.setWebViewClient(new com.kwad.sdk.core.page.widget.webview.c(this) { // from class: com.kwad.sdk.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f34266a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34266a = this;
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i3, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLILL(1048576, this, webView, i3, str, str2) == null) {
                            super.onReceivedError(webView, i3, str, str2);
                            this.f34266a.f34257b = true;
                        }
                    }
                });
            }
            this.f34261f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.c.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34267a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34267a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34267a.j();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0405a interfaceC0405a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0405a) == null) {
            this.k = interfaceC0405a;
        }
    }

    @Override // com.kwad.sdk.c.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f34257b : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.c.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.c();
            this.l.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.c.c
    public boolean d() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            boolean d2 = super.d();
            if (d2 && (activity = this.f34260e) != null) {
                x.d(activity);
                this.f34258c.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.c.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f34268a;

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
                        this.f34268a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (motionEvent.getX() > this.f34268a.f34261f.getX() && motionEvent.getX() - this.f34268a.f34261f.getX() < this.f34268a.f34261f.getWidth() && motionEvent.getY() > this.f34268a.f34261f.getY() && motionEvent.getY() - this.f34268a.f34261f.getY() < this.f34268a.f34261f.getHeight()) {
                                com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.f34268a.f34259d = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f34268a.f34259d;
                                if (this.f34268a.f34259d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.b.a(this.f34268a.j, 72, this.f34268a.f34258c.getTouchCoords());
                                    if (!this.f34268a.f34263h) {
                                        this.f34268a.f34263h = true;
                                        if (this.f34268a.e() != null) {
                                            this.f34268a.e().a();
                                        }
                                    }
                                }
                                this.f34268a.f34259d = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long P = com.kwad.sdk.core.config.c.P() * 1000;
                if (P == 0 || !this.f34264i) {
                    this.f34261f.setVisibility(0);
                } else {
                    this.l.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.c.a.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f34269a;

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
                            this.f34269a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34269a.f34260e == null || this.f34269a.f34260e.isFinishing()) {
                                return;
                            }
                            this.f34269a.f34261f.setVisibility(0);
                            this.f34269a.f34261f.setAlpha(0.0f);
                            this.f34269a.f34261f.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, P);
                }
                KsAdWebView ksAdWebView = this.f34262g;
                if (ksAdWebView != null) {
                    ksAdWebView.d();
                }
            }
            return d2;
        }
        return invokeV.booleanValue;
    }
}
