package com.kwad.components.ad.feed.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l extends com.kwad.components.core.widget.b<AdTemplate> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Long, Double> t;
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public int B;
    public ViewGroup.MarginLayoutParams C;
    public Handler D;
    public boolean E;
    public d F;
    public h.a G;
    public b.InterfaceC0528b H;
    public u.b I;
    public final a.InterfaceC0518a J;
    public RatioFrameLayout a;
    public KsAdWebView b;
    @Nullable
    public com.kwad.components.core.c.a.b c;
    public com.kwad.components.core.webview.a d;
    public com.kwad.sdk.core.webview.b e;
    public int f;
    public double g;
    public List<Integer> h;
    public com.kwad.sdk.core.video.videoview.a i;
    public com.kwad.components.core.video.c n;
    public ImageView o;
    public boolean p;
    public KSFrameLayout q;
    public aa r;
    public x s;
    public boolean u;
    public String v;
    public boolean w;
    public boolean x;
    public com.kwad.components.core.widget.b y;
    public KsAdVideoPlayConfig z;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2052014485, "Lcom/kwad/components/ad/feed/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2052014485, "Lcom/kwad/components/ad/feed/a/l;");
                return;
            }
        }
        t = new HashMap<>(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.p = false;
        this.w = false;
        this.x = false;
        this.D = new Handler(Looper.getMainLooper());
        this.G = new h.a(this) { // from class: com.kwad.components.ad.feed.a.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.E = false;
                    if (this.a.i != null) {
                        this.a.i.setVideoSoundEnable(false);
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.H = new b.InterfaceC0528b(this) { // from class: com.kwad.components.ad.feed.a.l.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.l == null) {
                    return;
                }
                this.a.l.a();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.l != null) {
                        this.a.l.b();
                    }
                    if (this.a.x) {
                        com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                        u.a aVar = new u.a();
                        FeedType fromInt = FeedType.fromInt(this.a.j.type);
                        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                        }
                        aVar.a = String.valueOf(fromInt.getType());
                        fVar.a(aVar);
                        com.kwad.components.core.l.c.a().a(this.a.j, null, fVar);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.l == null) {
                    return;
                }
                this.a.l.c();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.l == null) {
                    return;
                }
                this.a.l.d();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void e() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.l == null) {
                    return;
                }
                this.a.l.e();
            }
        };
        this.I = new u.b(this) { // from class: com.kwad.components.ad.feed.a.l.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.a.u) {
                    return;
                }
                this.a.f = aVar.a;
                if (this.a.f != 1) {
                    this.a.a("3");
                    return;
                }
                if (this.a.y != null) {
                    this.a.y.setVisibility(8);
                }
                this.a.b.setVisibility(0);
                com.kwad.components.core.i.a.a().a(this.a.j);
                this.a.D.removeCallbacksAndMessages(null);
                if (this.a.A != null) {
                    this.a.A.a();
                }
            }
        };
        this.J = new a.InterfaceC0518a(this) { // from class: com.kwad.components.ad.feed.a.l.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.components.core.video.a.InterfaceC0518a
            public final void a(int i3, y.a aVar) {
                int i4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, aVar) == null) {
                    int i5 = 2;
                    boolean z = false;
                    if (i3 == 1) {
                        i4 = 13;
                    } else if (i3 == 2) {
                        i4 = 82;
                    } else if (i3 != 3) {
                        i4 = 108;
                    } else {
                        i4 = 83;
                        i5 = 1;
                        z = true;
                    }
                    u.b bVar = new u.b();
                    bVar.i = aVar;
                    bVar.c = i4;
                    com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this.a.i)).a(this.a.j).a(this.a.c).a(i5).a(z).c(true).a(bVar).e(true).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.7.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass7 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.g();
                            }
                        }
                    }));
                }
            }
        };
        this.B = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65567, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.h;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.h.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.j, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, aVar) == null) {
            this.r = new aa();
            x xVar = new x();
            this.s = xVar;
            aVar.a(xVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.e, this.c, getClickListener()));
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.e, this.c, getClickListener()));
            aVar.a(new o(this.e, new o.b(this) { // from class: com.kwad.components.ad.feed.a.l.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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

                @Override // com.kwad.components.core.webview.jshandler.o.b
                public final void a(o.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        this.a.b.setVisibility(0);
                        if (this.a.g == 0.0d) {
                            this.a.g = aVar2.a;
                            double d = aVar2.a / this.a.B;
                            this.a.a.setRatio((float) d);
                            l.t.put(Long.valueOf(this.a.j.posId), Double.valueOf(d));
                        }
                    }
                }
            }));
            aVar.a(new com.kwad.components.core.webview.b.j());
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.e));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.components.ad.feed.a.l.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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

                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && this.a.k != null && com.kwad.sdk.core.response.a.a.W(this.a.k)) {
                        l lVar = this.a;
                        lVar.C = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                        int ceil = (int) Math.ceil(this.a.g);
                        int i = this.a.B;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.a.C.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d = i;
                        this.a.C.leftMargin = (int) (videoPosition.leftMarginRation * d);
                        this.a.C.width = (int) (d * videoPosition.widthRation);
                        this.a.C.height = (int) (this.a.C.width * videoPosition.heightWidthRation);
                        this.a.q.setRadius(videoPosition.borderRadius);
                        this.a.q.setLayoutParams(this.a.C);
                        l lVar2 = this.a;
                        lVar2.a(lVar2.z);
                    }
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.g(this.e, new g.a(this) { // from class: com.kwad.components.ad.feed.a.l.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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

                @Override // com.kwad.components.core.webview.jshandler.g.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.D.post(new Runnable(this) { // from class: com.kwad.components.ad.feed.a.l.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass13 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.h();
                                }
                            }
                        });
                    }
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.e));
            com.kwad.components.core.webview.jshandler.h hVar = new com.kwad.components.core.webview.jshandler.h(this.e);
            hVar.a(new h.b(this) { // from class: com.kwad.components.ad.feed.a.l.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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

                @Override // com.kwad.components.core.webview.jshandler.h.b
                public final void a(h.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        aVar2.b = 0;
                        aVar2.a = this.a.B;
                        this.a.w = true;
                    }
                }
            });
            aVar.a(hVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.u(this.I, com.kwad.sdk.core.response.a.b.p(this.j)));
            aVar.a(new z(this.e, this.c));
            aVar.a(new p(this.e));
            aVar.a(this.r);
            aVar.a(new t(getOpenNewPageListener()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, this, aVar) == null) || aVar == null) {
            return;
        }
        String b = com.kwad.sdk.core.response.a.a.b(this.k);
        boolean z = false;
        this.n.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(b, this.i);
        FeedType fromInt = FeedType.fromInt(this.j.type);
        a.C0507a a2 = new a.C0507a(com.kwad.sdk.b.kwai.a.a(this)).a(this.j).a(this.c).a(2);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.W(this.k)) {
            z = true;
        }
        com.kwad.components.core.c.a.a.a(a2.e(z).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.components.core.c.a.a.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.a(100);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, str) == null) {
            com.kwad.sdk.core.d.b.a("FeedWebView", "handleWebViewError " + str);
            this.D.removeCallbacksAndMessages(null);
            if (this.u) {
                return;
            }
            a aVar = this.A;
            if (aVar != null) {
                aVar.a();
            }
            this.A = null;
            this.u = true;
            com.kwad.components.core.i.a a2 = com.kwad.components.core.i.a.a();
            AdTemplate adTemplate = this.j;
            a2.c(adTemplate, com.kwad.sdk.core.response.a.b.p(adTemplate), str);
            if (this.y == null) {
                this.x = true;
                com.kwad.components.core.widget.b a3 = com.kwad.components.ad.feed.c.a(getContext(), FeedType.fromInt(this.j.type), com.kwad.sdk.core.response.a.a.Y(this.k));
                this.y = a3;
                if (a3 != null) {
                    this.y.setMargin(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
                    this.a.removeAllViews();
                    this.a.setRatio(0.0f);
                    this.b.setVisibility(8);
                    this.q.setVisibility(8);
                    this.y.setInnerAdInteractionListener(this.H);
                }
                this.a.addView(this.y);
                this.y.a((com.kwad.components.core.widget.b) this.j);
                com.kwad.components.core.widget.b bVar = this.y;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.z);
                }
            }
        }
    }

    public static boolean a(com.kwad.sdk.core.webview.a.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, aVar)) == null) ? aVar.a ? aVar.b : aVar.c == 1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65577, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.Z()) {
                    return !com.kwad.components.core.l.b.a(this.m).b() ? com.kwad.components.core.l.b.a(this.m).a(false) : !com.kwad.components.core.l.b.a(this.m).a();
                }
                if (!this.E) {
                    this.E = com.kwad.components.core.l.b.a(this.m).a(true);
                }
                return this.E;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public static float b(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, adTemplate)) == null) {
            int i = adTemplate.type;
            if (i == 1) {
                return 0.6013f;
            }
            return (i == 2 || i == 3) ? 0.283f : 0.968f;
        }
        return invokeL.floatValue;
    }

    private a.b b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65579, this, z)) == null) ? new a.b(this, z) { // from class: com.kwad.components.ad.feed.a.l.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ l b;
            public boolean c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = z;
                this.c = false;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                    this.b.a(j);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void f_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.report.a.h(this.b.j);
                    if (this.a) {
                        this.b.r.a(3);
                    }
                    if (this.b.F == null || !(this.b.F.getParent() instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) this.b.F.getParent()).removeView(this.b.F);
                    this.b.F.b();
                    this.b.F = null;
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void g_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    if (!this.c) {
                        this.c = true;
                        com.kwad.components.core.i.a.a().a(this.b.j, System.currentTimeMillis(), 1);
                    }
                    com.kwad.sdk.core.video.videoview.a aVar = this.b.i;
                    l lVar = this.b;
                    aVar.setVideoSoundEnable(lVar.a(lVar.p));
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void h_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.report.a.i(this.b.j);
                    if (this.a) {
                        this.b.r.a(9);
                    }
                    if (this.b.q != null) {
                        this.b.q.setVisibility(8);
                    }
                    if (com.kwad.components.ad.feed.kwai.b.a() && this.b.F == null) {
                        this.b.F = new d(this.b.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        l lVar = this.b;
                        lVar.addView(lVar.F, layoutParams);
                        this.b.F.a();
                    }
                }
            }
        } : (a.b) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.sdk.core.response.model.AdTemplate */
    /* JADX WARN: Multi-variable type inference failed */
    private void c(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, this, adTemplate) == null) {
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.j);
            this.c = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.c.a((DialogInterface.OnDismissListener) this);
            this.j = adTemplate;
            Double d = t.get(Long.valueOf(adTemplate.posId));
            if (d != null) {
                this.a.setRatio(d.floatValue());
            } else {
                if (com.kwad.sdk.core.response.a.b.q(this.j) > 0.0f) {
                    ratioFrameLayout = this.a;
                    b = com.kwad.sdk.core.response.a.b.q(this.j);
                } else if (this.a.getRatio() == 0.0f) {
                    ratioFrameLayout = this.a;
                    b = b(this.j);
                }
                ratioFrameLayout.setRatio(b);
            }
            i();
        }
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.feed.a.l.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    int i = aVar.c;
                    if (aVar.a) {
                        i = aVar.b ? 1 : 2;
                    }
                    boolean z = com.kwad.sdk.core.response.a.a.W(this.a.k) && (this.a.j.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || this.a.j.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                    u.b bVar = new u.b();
                    com.kwad.sdk.core.webview.a.a.c cVar = aVar.d;
                    if (cVar != null && !TextUtils.isEmpty(cVar.b)) {
                        bVar.j = aVar.d.b;
                    }
                    a.C0507a a2 = new a.C0507a(com.kwad.sdk.b.kwai.a.a(this.a)).a(this.a.j).a(this.a.c);
                    l lVar = this.a;
                    com.kwad.components.core.c.a.a.a(a2.a(l.a(aVar)).a(i).f(aVar.a).e(z).a(bVar).c(true).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 a;

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
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.a.l == null) {
                                return;
                            }
                            this.a.a.l.a();
                        }
                    }));
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    private t.a getOpenNewPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, this)) == null) ? new t.a(this) { // from class: com.kwad.components.ad.feed.a.l.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            @Override // com.kwad.components.core.webview.jshandler.t.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.a.m, new AdWebViewActivityProxy.a.C0514a().a(bVar.b).b(bVar.a).a(this.a.j).a());
                }
            }
        } : (t.a) invokeV.objValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.feed.a.l.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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
                    this.a.w = false;
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    this.a.a("1");
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.e = bVar;
            bVar.a(this.j);
            com.kwad.sdk.core.webview.b bVar2 = this.e;
            bVar2.a = 0;
            bVar2.b = null;
            bVar2.d = this.a;
            bVar2.e = this.b;
            bVar2.c = null;
            bVar2.g = false;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            if (com.kwad.sdk.core.response.a.b.r(this.j)) {
                k();
            } else {
                a("0");
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            l();
            this.b.setClientConfig(this.b.getClientConfig().a(this.j).a(getWebListener()));
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.b);
            this.d = aVar;
            a(aVar);
            this.b.addJavascriptInterface(this.d, "KwaiAd");
            this.b.loadUrl(com.kwad.sdk.core.response.a.b.p(this.j));
        }
    }

    private void l() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65602, this) == null) || (aVar = this.d) == null) {
            return;
        }
        aVar.a();
        this.d = null;
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, this)) == null) ? this.f == 1 : invokeV.booleanValue;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            this.D.removeCallbacksAndMessages(null);
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.p = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.ay(this.k) : ksAdVideoPlayConfig.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.a.a.ae(this.k).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.o;
                i = 8;
            } else {
                this.o.setImageDrawable(null);
                KSImageLoader.loadImage(this.o, a2, this.j);
                imageView = this.o;
                i = 0;
            }
            imageView.setVisibility(i);
            this.h = com.kwad.sdk.core.response.a.a.Z(this.k);
            com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.m);
            this.i = aVar;
            aVar.setTag(this.h);
            String b = com.kwad.sdk.core.response.a.a.b(this.k);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            this.i.a(new b.a(this.j).a(b).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.j(this.j))).a(this.j.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.j, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.i.setVideoSoundEnable(this.p);
            com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.m, this.j, this.i, ksAdVideoPlayConfig);
            this.n = cVar;
            cVar.setVideoPlayCallback(b(true));
            this.n.setAdClickListener(this.J);
            this.i.setController(this.n);
            if (this.q.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.q;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.i);
            this.q.setTag(this.i);
            this.q.setClickable(true);
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.feed.a.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (!this.a.i.d()) {
                            l lVar = this.a;
                            lVar.a(lVar.i);
                            return;
                        }
                        com.kwad.sdk.utils.k.b(this.a.j);
                        this.a.i.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a.j));
                        this.a.i.a();
                    }
                }
            });
            if (this.p) {
                com.kwad.components.core.l.b.a(this.m).a(this.G);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            adTemplate.realShowType = 2;
            super.a((l) adTemplate);
            if (this.u) {
                com.kwad.components.core.widget.b bVar = this.y;
                if (bVar != null) {
                    bVar.a((com.kwad.components.core.widget.b) this.j);
                    com.kwad.components.core.widget.b bVar2 = this.y;
                    if (bVar2 instanceof c) {
                        ((c) bVar2).a(this.z);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f != 1) {
                c(this.j);
            }
            String str = this.v;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (m()) {
                    this.b.reload();
                } else {
                    j();
                }
            }
            this.v = adTemplate.mOriginJString;
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, aVar) == null) {
            a aVar2 = this.A;
            if (aVar2 != null) {
                aVar2.a();
                this.A = null;
            }
            this.A = aVar;
            adTemplate.realShowType = 2;
            super.a((l) adTemplate);
            if (this.f != 1) {
                c(this.j);
            }
            String str = this.v;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (m()) {
                    this.b.reload();
                } else {
                    j();
                }
            }
            this.v = adTemplate.mOriginJString;
            this.D.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.feed.a.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.b.stopLoading();
                        this.a.b.setVisibility(8);
                        this.a.a("0");
                    }
                }
            }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a_();
            com.kwad.sdk.utils.k.a(this.j);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b_();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911ec);
            this.b = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.a = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09101b);
            this.q = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911c3);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911d3);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void e() {
        x xVar;
        b.InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.j.mPvReported && (interfaceC0528b = this.l) != null) {
                interfaceC0528b.b();
            }
            if (this.x || (xVar = this.s) == null) {
                return;
            }
            xVar.d();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d0424 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            n();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (aVar = this.i) == null || (viewGroup = (ViewGroup) aVar.getParent()) == this.q) {
                return;
            }
            viewGroup.removeView(this.i);
            if (this.q.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.q;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.i);
            this.q.setTag(this.i);
            String b = com.kwad.sdk.core.response.a.a.b(this.k);
            this.i.setVideoSoundEnable(this.p);
            this.n.setVideoPlayCallback(b(false));
            this.n.setAdClickListener(this.J);
            this.n.getAdTemplate().mAdWebVideoPageShowing = false;
            this.n.o();
            this.n.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(b);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ksAdVideoPlayConfig) == null) {
            this.z = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0 && this.i != null) {
                    boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                    this.p = isVideoSoundEnable;
                    this.i.setVideoSoundEnable(a(isVideoSoundEnable));
                    if (this.p) {
                        com.kwad.components.core.l.b.a(this.m).a(this.G);
                    }
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (cVar = this.n) == null) {
                    return;
                }
                cVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    public final void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.B = i;
        }
    }
}
