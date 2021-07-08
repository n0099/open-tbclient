package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.a.a.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.b.a.f;
import com.kwad.sdk.core.webview.b.j;
import com.kwad.sdk.core.webview.b.k;
import com.kwad.sdk.core.webview.b.l;
import com.kwad.sdk.core.webview.b.m;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f33717a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33718b;

    /* renamed from: c  reason: collision with root package name */
    public a f33719c;

    /* renamed from: d  reason: collision with root package name */
    public g f33720d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33721e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33722f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33723g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.MarginLayoutParams f33724h;

    /* renamed from: i  reason: collision with root package name */
    public RatioFrameLayout f33725i;
    public RatioFrameLayout j;
    public Handler k;
    public Dialog l;
    public KsAdWebView m;
    @Nullable
    public com.kwad.sdk.core.download.b.b n;
    public int o;
    public List<Integer> p;
    public com.kwad.sdk.core.video.videoview.b q;
    @NonNull
    public KsAdVideoPlayConfig r;
    public ImageView s;
    public a.b t;
    public k u;
    public m.b v;

    public d() {
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
        this.k = new Handler(Looper.getMainLooper());
        this.o = -1;
        this.v = new m.b(this) { // from class: com.kwad.sdk.a.a.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f33740a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f33740a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f33740a.f33723g) {
                    return;
                }
                this.f33740a.o = i4;
                if (this.f33740a.o != 1) {
                    this.f33740a.b("3");
                    return;
                }
                this.f33740a.m.setVisibility(0);
                com.kwad.sdk.core.report.d.a(this.f33740a.f33722f);
                this.f33740a.k.removeCallbacksAndMessages(null);
            }
        };
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File d2 = com.kwad.sdk.core.config.c.d(context);
            if (d2.exists()) {
                str = Uri.fromFile(d2).toString();
                sb = new StringBuilder();
                str2 = "getPreloadUrl preloadUrl ";
            } else if (com.kwad.sdk.core.config.c.e() == null) {
                return null;
            } else {
                str = com.kwad.sdk.core.config.c.e().h5Url;
                sb = new StringBuilder();
                str2 = "getPreloadUrl getDownloadPopWindowConfig ";
            }
            sb.append(str2);
            sb.append(str);
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", sb.toString());
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33721e, this.n, new a.b(this) { // from class: com.kwad.sdk.a.a.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33743a;

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
                    this.f33743a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C0427a c0427a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0427a) == null) {
                        this.f33743a.f33719c.a(this.f33743a.m, c0427a != null && c0427a.f35155a, false);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.b.g());
            gVar.a(new i(this.f33721e, new i.b(this) { // from class: com.kwad.sdk.a.a.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33727a;

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
                    this.f33727a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    }
                }
            }));
            gVar.a(new e(this.f33721e));
            f fVar = new f();
            this.u = new k(this) { // from class: com.kwad.sdk.a.a.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33728a;

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
                    this.f33728a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.i, com.kwad.sdk.core.webview.a.a
                public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        if (this.f33728a.q.i()) {
                            f fVar2 = new f();
                            fVar2.f35130b = false;
                            fVar2.f35131c = true;
                            fVar2.f35129a = com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.i(this.f33728a.f33721e.f35099b));
                            cVar.a(fVar2);
                        }
                    }
                }
            };
            gVar.a(new j(this) { // from class: com.kwad.sdk.a.a.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33729a;

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
                    this.f33729a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.i, com.kwad.sdk.core.webview.a.a
                public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        com.kwad.sdk.core.webview.b.a.b bVar = new com.kwad.sdk.core.webview.b.a.b();
                        bVar.f35123a = !this.f33729a.r.isVideoSoundEnable();
                        cVar.a(bVar);
                    }
                }
            });
            com.kwad.sdk.core.webview.b.m mVar = new com.kwad.sdk.core.webview.b.m();
            mVar.a(new m.a(this) { // from class: com.kwad.sdk.a.a.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33730a;

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
                    this.f33730a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        this.f33730a.q.setVideoSoundEnable(!bVar.f35123a);
                    }
                }
            });
            gVar.a(mVar);
            l lVar = new l();
            lVar.a(new l.a(this) { // from class: com.kwad.sdk.a.a.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33731a;

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
                    this.f33731a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) || this.f33731a.q == null) {
                        return;
                    }
                    this.f33731a.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.14.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass14 f33732a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f33732a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f33732a.f33731a.q.i()) {
                                return;
                            }
                            this.f33732a.f33731a.q.j();
                        }
                    });
                }
            });
            gVar.a(lVar);
            gVar.a(new h(new h.a(this) { // from class: com.kwad.sdk.a.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33733a;

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
                    this.f33733a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f33733a.l == null) {
                        return;
                    }
                    this.f33733a.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f33734a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f33734a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f33734a.f33733a.l.dismiss();
                                com.kwad.sdk.core.report.a.a(this.f33734a.f33733a.f33722f, 1, (JSONObject) null);
                                if (this.f33734a.f33733a.f33719c.f33676b != null) {
                                    this.f33734a.f33733a.f33719c.f33676b.onAdClosed();
                                }
                            }
                        }
                    });
                }
            }));
            a.b bVar = new a.b(this, fVar) { // from class: com.kwad.sdk.a.a.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f33735a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f33736b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33736b = this;
                    this.f33735a = fVar;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f fVar2 = this.f33735a;
                        fVar2.f35130b = false;
                        fVar2.f35131c = false;
                        fVar2.f35129a = 0;
                        this.f33736b.u.a(this.f33735a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        f fVar2 = this.f33735a;
                        fVar2.f35130b = false;
                        fVar2.f35131c = false;
                        fVar2.f35129a = (int) Math.ceil(((float) j) / 1000.0f);
                        this.f33736b.u.a(this.f33735a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (this.f33736b.s.getVisibility() == 0) {
                            this.f33736b.s.setVisibility(8);
                        }
                        f fVar2 = this.f33735a;
                        fVar2.f35130b = false;
                        fVar2.f35131c = false;
                        fVar2.f35129a = (int) Math.ceil(((float) this.f33736b.q.getCurrentPosition()) / 1000.0f);
                        this.f33736b.u.a(this.f33735a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        f fVar2 = this.f33735a;
                        fVar2.f35130b = false;
                        fVar2.f35131c = true;
                        this.f33735a.f35129a = com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.i(this.f33736b.f33721e.f35099b));
                        this.f33736b.u.a(this.f33735a);
                    }
                }
            };
            this.t = bVar;
            this.f33719c.a(bVar);
            gVar.a(this.u);
            gVar.a(new WebCardVideoPositionHandler(this.f33721e, new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.a.a.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33737a;

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
                    this.f33737a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    AdInfo adInfo;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && (adInfo = this.f33737a.f33718b) != null && com.kwad.sdk.core.response.b.a.F(adInfo)) {
                        d dVar = this.f33737a;
                        dVar.f33724h = (ViewGroup.MarginLayoutParams) dVar.j.getLayoutParams();
                        int i2 = this.f33737a.f33717a.getResources().getDisplayMetrics().heightPixels;
                        int i3 = this.f33737a.f33717a.getResources().getDisplayMetrics().widthPixels;
                        this.f33737a.f33724h.topMargin = (int) Math.round(videoPosition.topMarginRation * i2);
                        double d2 = i3;
                        this.f33737a.f33724h.leftMargin = (int) Math.round(videoPosition.leftMarginRation * d2);
                        this.f33737a.f33724h.width = (int) Math.ceil(d2 * videoPosition.widthRation);
                        this.f33737a.f33724h.height = (int) Math.round(this.f33737a.f33724h.width * videoPosition.heightWidthRation);
                        this.f33737a.j.setLayoutParams(this.f33737a.f33724h);
                        this.f33737a.j.setRatio(this.f33737a.f33724h.height / this.f33737a.f33724h.width);
                        this.f33737a.j.setVisibility(0);
                        this.f33737a.m.setVisibility(0);
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f33737a.j.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.kwad.sdk.a.a.d.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f33738a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f33738a = this;
                                }

                                @Override // android.view.ViewOutlineProvider
                                public void getOutline(View view, Outline outline) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeLL(1048576, this, view, outline) == null) {
                                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), av.a(this.f33738a.f33737a.m(), 4.0f));
                                    }
                                }
                            });
                            this.f33737a.j.setClipToOutline(true);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f33721e));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f33721e);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.a.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33739a;

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
                    this.f33739a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f35163b = this.f33739a.f33717a.getResources().getDisplayMetrics().heightPixels;
                        aVar.f35162a = this.f33739a.f33717a.getResources().getDisplayMetrics().widthPixels;
                    }
                }
            });
            gVar.a(cVar);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.m(this.v));
            gVar.a(new q(this.f33721e, this.n));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f33721e));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            n();
            ay.b(this.m);
            this.m.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.a.a.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33741a;

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
                    this.f33741a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.f33741a.b("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            g gVar = new g(this.m);
            this.f33720d = gVar;
            a(gVar);
            this.m.addJavascriptInterface(this.f33720d, "KwaiAd");
            this.m.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "handleWebViewError " + str);
            this.k.removeCallbacksAndMessages(null);
            if (this.f33723g) {
                return;
            }
            this.f33723g = true;
            if (com.kwad.sdk.core.config.c.e() != null && com.kwad.sdk.core.config.c.e().h5Url != null) {
                com.kwad.sdk.core.report.d.c(this.f33722f, com.kwad.sdk.core.config.c.e().h5Url, str);
            }
            this.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33742a;

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
                    this.f33742a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f33742a.o();
                        this.f33742a.f33719c.b();
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f33721e = aVar;
            aVar.f35099b = this.f33719c.f33675a;
            aVar.f35098a = 0;
            aVar.f35100c = null;
            aVar.f35102e = this.f33725i;
            aVar.f35103f = this.m;
            aVar.f35101d = null;
            aVar.f35105h = false;
        }
    }

    private void n() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f33720d) == null) {
            return;
        }
        gVar.a();
        this.f33720d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r0.height > r0.width) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = com.kwad.sdk.utils.ab.e(r6.f33717a);
        r5 = r6.f33719c.f33679e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        r5.setRatio(1.7777778f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        r5.setRatio(0.714f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        r0 = r6.f33717a.getResources().getDisplayMetrics().widthPixels;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r1 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
        r1 = 0.61f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        r1 = 0.768f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r0 = r6.f33717a.getResources().getDisplayMetrics().widthPixels;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (r1 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        r1 = 0.287f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        r0 = (int) (r0 * r1);
        r1 = r0 * 1.7777778f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
        r1 = 0.506f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        r0 = (int) (r0 * r1);
        r1 = r0 * 0.714f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
        r6.m.setVisibility(8);
        r6.j.setVisibility(8);
        r3 = (android.view.ViewGroup) r6.f33725i.findViewById(com.kwad.sdk.R.id.ksad_interstitial_native);
        r3.setVisibility(0);
        r3.addView(r6.f33719c.f33679e);
        r2 = (android.view.ViewGroup.MarginLayoutParams) r6.f33719c.f33679e.getLayoutParams();
        r2.width = r0;
        r2.height = (int) r1;
        r6.f33719c.f33679e.setLayoutParams(r2);
        r6.f33719c.f33679e.requestLayout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r0.height > r0.width) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65561, this) != null) {
            return;
        }
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.F(this.f33718b)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f33718b);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f33718b);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f33719c = aVar;
            this.l = aVar.f33677c;
            this.r = aVar.f33680f;
            this.n = aVar.f33678d;
            AdTemplate adTemplate = aVar.f33675a;
            this.f33722f = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f33718b = i2;
            this.p = com.kwad.sdk.core.response.b.a.I(i2);
            this.q = this.f33719c.f33682h;
            f();
            e();
            this.f33719c.a(new a.b(this) { // from class: com.kwad.sdk.a.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f33726a;

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
                    this.f33726a = this;
                }

                @Override // com.kwad.sdk.a.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f33726a.o == 1) {
                        this.f33726a.m.reload();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            KsAdWebView ksAdWebView = (KsAdWebView) j().findViewById(R.id.ksad_web_card_webView);
            this.m = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.m.setVisibility(4);
            this.f33725i = (RatioFrameLayout) j().findViewById(R.id.ksad_container);
            this.j = (RatioFrameLayout) j().findViewById(R.id.ksad_video_container);
            this.s = (ImageView) j().findViewById(R.id.ksad_video_first_frame_container);
            this.f33717a = m();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.k.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String a2 = a(this.f33717a);
            if (TextUtils.isEmpty(a2)) {
                b("1");
            } else {
                a(a2);
            }
        }
    }
}
