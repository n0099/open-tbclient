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
/* loaded from: classes10.dex */
public class d extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f71011a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f71012b;

    /* renamed from: c  reason: collision with root package name */
    public a f71013c;

    /* renamed from: d  reason: collision with root package name */
    public g f71014d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f71015e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f71016f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71017g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.MarginLayoutParams f71018h;

    /* renamed from: i  reason: collision with root package name */
    public RatioFrameLayout f71019i;

    /* renamed from: j  reason: collision with root package name */
    public RatioFrameLayout f71020j;
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
            public final /* synthetic */ d f71035a;

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
                this.f71035a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f71035a.f71017g) {
                    return;
                }
                this.f71035a.o = i4;
                if (this.f71035a.o != 1) {
                    this.f71035a.b("3");
                    return;
                }
                this.f71035a.m.setVisibility(0);
                com.kwad.sdk.core.report.d.a(this.f71035a.f71016f);
                this.f71035a.k.removeCallbacksAndMessages(null);
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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f71015e, this.n, new a.b(this) { // from class: com.kwad.sdk.a.a.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71038a;

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
                    this.f71038a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2000a c2000a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) {
                        this.f71038a.f71013c.a(this.f71038a.m, c2000a != null && c2000a.f72479a, false);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.b.g());
            gVar.a(new i(this.f71015e, new i.b(this) { // from class: com.kwad.sdk.a.a.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71022a;

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
                    this.f71022a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    }
                }
            }));
            gVar.a(new e(this.f71015e));
            f fVar = new f();
            this.u = new k(this) { // from class: com.kwad.sdk.a.a.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71023a;

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
                    this.f71023a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.i, com.kwad.sdk.core.webview.a.a
                public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        if (this.f71023a.q.i()) {
                            f fVar2 = new f();
                            fVar2.f72454b = false;
                            fVar2.f72455c = true;
                            fVar2.f72453a = com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.i(this.f71023a.f71015e.f72423b));
                            cVar.a(fVar2);
                        }
                    }
                }
            };
            gVar.a(new j(this) { // from class: com.kwad.sdk.a.a.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71024a;

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
                    this.f71024a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.i, com.kwad.sdk.core.webview.a.a
                public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                        super.a(str, cVar);
                        com.kwad.sdk.core.webview.b.a.b bVar = new com.kwad.sdk.core.webview.b.a.b();
                        bVar.f72447a = !this.f71024a.r.isVideoSoundEnable();
                        cVar.a(bVar);
                    }
                }
            });
            com.kwad.sdk.core.webview.b.m mVar = new com.kwad.sdk.core.webview.b.m();
            mVar.a(new m.a(this) { // from class: com.kwad.sdk.a.a.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71025a;

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
                    this.f71025a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        this.f71025a.q.setVideoSoundEnable(!bVar.f72447a);
                    }
                }
            });
            gVar.a(mVar);
            l lVar = new l();
            lVar.a(new l.a(this) { // from class: com.kwad.sdk.a.a.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71026a;

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
                    this.f71026a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) || this.f71026a.q == null) {
                        return;
                    }
                    this.f71026a.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.14.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass14 f71027a;

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
                            this.f71027a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f71027a.f71026a.q.i()) {
                                return;
                            }
                            this.f71027a.f71026a.q.j();
                        }
                    });
                }
            });
            gVar.a(lVar);
            gVar.a(new h(new h.a(this) { // from class: com.kwad.sdk.a.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71028a;

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
                    this.f71028a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f71028a.l == null) {
                        return;
                    }
                    this.f71028a.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f71029a;

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
                            this.f71029a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f71029a.f71028a.l.dismiss();
                                com.kwad.sdk.core.report.a.a(this.f71029a.f71028a.f71016f, 1, (JSONObject) null);
                                if (this.f71029a.f71028a.f71013c.f70967b != null) {
                                    this.f71029a.f71028a.f71013c.f70967b.onAdClosed();
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
                public final /* synthetic */ f f71030a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f71031b;

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
                    this.f71031b = this;
                    this.f71030a = fVar;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f fVar2 = this.f71030a;
                        fVar2.f72454b = false;
                        fVar2.f72455c = false;
                        fVar2.f72453a = 0;
                        this.f71031b.u.a(this.f71030a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        f fVar2 = this.f71030a;
                        fVar2.f72454b = false;
                        fVar2.f72455c = false;
                        fVar2.f72453a = (int) Math.ceil(((float) j2) / 1000.0f);
                        this.f71031b.u.a(this.f71030a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (this.f71031b.s.getVisibility() == 0) {
                            this.f71031b.s.setVisibility(8);
                        }
                        f fVar2 = this.f71030a;
                        fVar2.f72454b = false;
                        fVar2.f72455c = false;
                        fVar2.f72453a = (int) Math.ceil(((float) this.f71031b.q.getCurrentPosition()) / 1000.0f);
                        this.f71031b.u.a(this.f71030a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        f fVar2 = this.f71030a;
                        fVar2.f72454b = false;
                        fVar2.f72455c = true;
                        this.f71030a.f72453a = com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.i(this.f71031b.f71015e.f72423b));
                        this.f71031b.u.a(this.f71030a);
                    }
                }
            };
            this.t = bVar;
            this.f71013c.a(bVar);
            gVar.a(this.u);
            gVar.a(new WebCardVideoPositionHandler(this.f71015e, new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.a.a.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71032a;

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
                    this.f71032a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    AdInfo adInfo;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && (adInfo = this.f71032a.f71012b) != null && com.kwad.sdk.core.response.b.a.F(adInfo)) {
                        d dVar = this.f71032a;
                        dVar.f71018h = (ViewGroup.MarginLayoutParams) dVar.f71020j.getLayoutParams();
                        int i2 = this.f71032a.f71011a.getResources().getDisplayMetrics().heightPixels;
                        int i3 = this.f71032a.f71011a.getResources().getDisplayMetrics().widthPixels;
                        this.f71032a.f71018h.topMargin = (int) Math.round(videoPosition.topMarginRation * i2);
                        double d2 = i3;
                        this.f71032a.f71018h.leftMargin = (int) Math.round(videoPosition.leftMarginRation * d2);
                        this.f71032a.f71018h.width = (int) Math.ceil(d2 * videoPosition.widthRation);
                        this.f71032a.f71018h.height = (int) Math.round(this.f71032a.f71018h.width * videoPosition.heightWidthRation);
                        this.f71032a.f71020j.setLayoutParams(this.f71032a.f71018h);
                        this.f71032a.f71020j.setRatio(this.f71032a.f71018h.height / this.f71032a.f71018h.width);
                        this.f71032a.f71020j.setVisibility(0);
                        this.f71032a.m.setVisibility(0);
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f71032a.f71020j.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.kwad.sdk.a.a.d.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f71033a;

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
                                    this.f71033a = this;
                                }

                                @Override // android.view.ViewOutlineProvider
                                public void getOutline(View view, Outline outline) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeLL(1048576, this, view, outline) == null) {
                                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), av.a(this.f71033a.f71032a.m(), 4.0f));
                                    }
                                }
                            });
                            this.f71032a.f71020j.setClipToOutline(true);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f71015e));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f71015e);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.a.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71034a;

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
                    this.f71034a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f72487b = this.f71034a.f71011a.getResources().getDisplayMetrics().heightPixels;
                        aVar.f72486a = this.f71034a.f71011a.getResources().getDisplayMetrics().widthPixels;
                    }
                }
            });
            gVar.a(cVar);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.m(this.v));
            gVar.a(new q(this.f71015e, this.n));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f71015e));
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
                public final /* synthetic */ d f71036a;

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
                    this.f71036a = this;
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
                        this.f71036a.b("1");
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
            this.f71014d = gVar;
            a(gVar);
            this.m.addJavascriptInterface(this.f71014d, "KwaiAd");
            this.m.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "handleWebViewError " + str);
            this.k.removeCallbacksAndMessages(null);
            if (this.f71017g) {
                return;
            }
            this.f71017g = true;
            if (com.kwad.sdk.core.config.c.e() != null && com.kwad.sdk.core.config.c.e().h5Url != null) {
                com.kwad.sdk.core.report.d.c(this.f71016f, com.kwad.sdk.core.config.c.e().h5Url, str);
            }
            this.k.post(new Runnable(this) { // from class: com.kwad.sdk.a.a.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71037a;

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
                    this.f71037a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71037a.o();
                        this.f71037a.f71013c.b();
                    }
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f71015e = aVar;
            aVar.f72423b = this.f71013c.f70966a;
            aVar.f72422a = 0;
            aVar.f72424c = null;
            aVar.f72426e = this.f71019i;
            aVar.f72427f = this.m;
            aVar.f72425d = null;
            aVar.f72429h = false;
        }
    }

    private void n() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f71014d) == null) {
            return;
        }
        gVar.a();
        this.f71014d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r0.height > r0.width) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = com.kwad.sdk.utils.ab.e(r6.f71011a);
        r5 = r6.f71013c.f70970e;
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
        r0 = r6.f71011a.getResources().getDisplayMetrics().widthPixels;
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
        r0 = r6.f71011a.getResources().getDisplayMetrics().widthPixels;
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
        r6.f71020j.setVisibility(8);
        r3 = (android.view.ViewGroup) r6.f71019i.findViewById(com.kwad.sdk.R.id.ksad_interstitial_native);
        r3.setVisibility(0);
        r3.addView(r6.f71013c.f70970e);
        r2 = (android.view.ViewGroup.MarginLayoutParams) r6.f71013c.f70970e.getLayoutParams();
        r2.width = r0;
        r2.height = (int) r1;
        r6.f71013c.f70970e.setLayoutParams(r2);
        r6.f71013c.f70970e.requestLayout();
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
        if (com.kwad.sdk.core.response.b.a.F(this.f71012b)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f71012b);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f71012b);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f71013c = aVar;
            this.l = aVar.f70968c;
            this.r = aVar.f70971f;
            this.n = aVar.f70969d;
            AdTemplate adTemplate = aVar.f70966a;
            this.f71016f = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f71012b = i2;
            this.p = com.kwad.sdk.core.response.b.a.I(i2);
            this.q = this.f71013c.f70973h;
            f();
            e();
            this.f71013c.a(new a.b(this) { // from class: com.kwad.sdk.a.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f71021a;

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
                    this.f71021a = this;
                }

                @Override // com.kwad.sdk.a.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f71021a.o == 1) {
                        this.f71021a.m.reload();
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
            this.f71019i = (RatioFrameLayout) j().findViewById(R.id.ksad_container);
            this.f71020j = (RatioFrameLayout) j().findViewById(R.id.ksad_video_container);
            this.s = (ImageView) j().findViewById(R.id.ksad_video_first_frame_container);
            this.f71011a = m();
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
            String a2 = a(this.f71011a);
            if (TextUtils.isEmpty(a2)) {
                b("1");
            } else {
                a(a2);
            }
        }
    }
}
