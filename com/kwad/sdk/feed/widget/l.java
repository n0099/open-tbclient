package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Long, Double> t;
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public int B;
    public ViewGroup.MarginLayoutParams C;
    public Handler D;
    public k.b E;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f37499f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f37500g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37501h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f37502i;
    public com.kwad.sdk.core.webview.a j;
    public int k;
    public double l;
    public List<Integer> m;
    public com.kwad.sdk.core.video.videoview.b n;
    public j o;
    public ImageView p;
    public boolean q;
    public RatioFrameLayout r;
    public p s;
    public boolean u;
    public String v;
    public boolean w;
    public int x;
    public com.kwad.sdk.feed.widget.base.a y;
    public KsAdVideoPlayConfig z;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(848531812, "Lcom/kwad/sdk/feed/widget/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(848531812, "Lcom/kwad/sdk/feed/widget/l;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = -1;
        this.q = false;
        this.w = false;
        this.D = new Handler(Looper.getMainLooper());
        this.E = new k.b(this) { // from class: com.kwad.sdk.feed.widget.l.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f37509a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37509a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f37509a.u) {
                    return;
                }
                this.f37509a.k = i4;
                if (this.f37509a.k != 1) {
                    this.f37509a.a("3");
                    return;
                }
                if (this.f37509a.y != null) {
                    this.f37509a.y.setVisibility(8);
                }
                this.f37509a.f37500g.setVisibility(0);
                com.kwad.sdk.core.report.e.m(((com.kwad.sdk.feed.widget.base.a) this.f37509a).f37439a);
                this.f37509a.D.removeCallbacksAndMessages(null);
                if (this.f37509a.A != null) {
                    this.f37509a.A.a();
                }
            }
        };
        this.B = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65555, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.m;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.m.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, bVar) == null) || bVar == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
        this.o.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.n);
        FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f37439a.type);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.J(this.f37440b)) {
            com.kwad.sdk.core.download.b.a.b(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37512a;

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
                    this.f37512a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37512a.k();
                    }
                }
            }, this.f37501h);
        } else {
            com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.l.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37513a;

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
                    this.f37513a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37513a.k();
                    }
                }
            }, this.f37501h);
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, gVar) == null) {
            this.s = new p();
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f37501h, new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37519a;

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
                    this.f37519a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.sdk.core.response.b.a.J(this.f37519a.f37440b) && (((com.kwad.sdk.feed.widget.base.a) this.f37519a).f37439a.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) this.f37519a).f37439a.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                            com.kwad.sdk.core.download.b.a.b(ao.a(this.f37519a), ((com.kwad.sdk.feed.widget.base.a) this.f37519a).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.l.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f37520a;

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
                                    this.f37520a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f37520a.f37519a.f37441c == null) {
                                        return;
                                    }
                                    this.f37520a.f37519a.f37441c.a();
                                }
                            }, this.f37519a.f37501h);
                        } else {
                            com.kwad.sdk.core.download.b.a.a(ao.a(this.f37519a), ((com.kwad.sdk.feed.widget.base.a) this.f37519a).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.l.9.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f37521a;

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
                                    this.f37521a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f37521a.f37519a.f37441c == null) {
                                        return;
                                    }
                                    this.f37521a.f37519a.f37441c.a();
                                }
                            }, this.f37519a.f37501h);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.j, new i.b(this) { // from class: com.kwad.sdk.feed.widget.l.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37504a;

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
                    this.f37504a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f37504a.f37500g.setVisibility(0);
                        if (this.f37504a.l == 0.0d) {
                            this.f37504a.l = aVar.f36868a;
                            double d2 = aVar.f36868a / this.f37504a.B;
                            this.f37504a.f37499f.setRatio((float) d2);
                            l.t.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) this.f37504a).f37439a.posId), Double.valueOf(d2));
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
            gVar.a(new WebCardVideoPositionHandler(this.j, new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.feed.widget.l.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37505a;

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
                    this.f37505a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && this.f37505a.f37440b != null && com.kwad.sdk.core.response.b.a.J(this.f37505a.f37440b)) {
                        l lVar = this.f37505a;
                        lVar.C = (ViewGroup.MarginLayoutParams) lVar.r.getLayoutParams();
                        int ceil = (int) Math.ceil(this.f37505a.l);
                        int i2 = this.f37505a.B;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.f37505a.C.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d2 = i2;
                        this.f37505a.C.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                        this.f37505a.C.width = (int) (d2 * videoPosition.widthRation);
                        this.f37505a.C.height = (int) (this.f37505a.C.width * videoPosition.heightWidthRation);
                        this.f37505a.r.setLayoutParams(this.f37505a.C);
                        l lVar2 = this.f37505a;
                        lVar2.a(lVar2.z);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.j, new b.a(this) { // from class: com.kwad.sdk.feed.widget.l.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37506a;

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
                    this.f37506a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37506a.D.post(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.12.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass12 f37507a;

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
                                this.f37507a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f37507a.f37506a.l();
                                }
                            }
                        });
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.j);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.feed.widget.l.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37508a;

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
                    this.f37508a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f36828b = 0;
                        aVar.f36827a = this.f37508a.B;
                        this.f37508a.w = true;
                    }
                }
            });
            gVar.a(cVar);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.E));
            gVar.a(new o(this.j, this.f37501h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.j));
            gVar.a(this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, str) == null) {
            com.kwad.sdk.core.d.a.a("FeedWebView", "handleWebViewError " + str);
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
            com.kwad.sdk.core.report.e.e(((com.kwad.sdk.feed.widget.base.a) this).f37439a, com.kwad.sdk.core.config.c.a().h5Url, str);
            if (this.y == null) {
                com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f37439a.type), com.kwad.sdk.core.response.b.a.L(this.f37440b));
                this.y = a2;
                if (a2 != null) {
                    this.y.setMargin(ao.a(getContext(), 16.0f));
                    this.f37499f.removeAllViews();
                    this.f37499f.setRatio(0.0f);
                    this.f37500g.setVisibility(8);
                    this.r.setVisibility(8);
                }
                this.f37499f.addView(this.y);
                this.y.a(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.y;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.z);
                }
            }
        }
    }

    private float c(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, adTemplate)) == null) {
            int i2 = adTemplate.type;
            if (i2 == 1) {
                return 0.6013f;
            }
            return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
        }
        return invokeL.floatValue;
    }

    public static /* synthetic */ int d(l lVar) {
        int i2 = lVar.x;
        lVar.x = i2 + 1;
        return i2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.j = aVar;
            aVar.f36790b = ((com.kwad.sdk.feed.widget.base.a) this).f37439a;
            aVar.f36789a = 0;
            aVar.f36791c = null;
            aVar.f36793e = this.f37499f;
            aVar.f36794f = this.f37500g;
            aVar.f36792d = null;
            aVar.f36795g = false;
        }
    }

    private void o() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65581, this) == null) || (gVar = this.f37502i) == null) {
            return;
        }
        gVar.a();
        this.f37502i = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, this, str) == null) {
            o();
            ar.b(this.f37500g);
            this.f37500g.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.feed.widget.l.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37515a;

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
                    this.f37515a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37515a.w = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.f37515a.a("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f37515a.w) {
                        return;
                    }
                    if (this.f37515a.x >= 2) {
                        this.f37515a.a("2");
                        return;
                    }
                    this.f37515a.f37500g.reload();
                    l.d(this.f37515a);
                }
            });
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f37500g);
            this.f37502i = gVar;
            a(gVar);
            this.f37500g.a(this.f37502i, "KwaiAd", new ValueCallback<String>(this, str) { // from class: com.kwad.sdk.feed.widget.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f37516a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ l f37517b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37517b = this;
                    this.f37516a = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.webkit.ValueCallback
                /* renamed from: a */
                public void onReceiveValue(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        ak.a(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.8.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass8 f37518a;

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
                                this.f37518a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f37518a.f37517b.f37500g.loadUrl(this.f37518a.f37516a);
                                    l.d(this.f37518a.f37517b);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.q = ksAdVideoPlayConfig.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.b.a.U(this.f37440b).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.p;
                i2 = 8;
            } else {
                this.p.setImageDrawable(null);
                KSImageLoader.loadImage(this.p, a2, ((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                imageView = this.p;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.m = com.kwad.sdk.core.response.b.a.M(this.f37440b);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f37442d);
            this.n = bVar;
            bVar.setTag(this.m);
            String a3 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.n.a(new d.a().a(a3).a(((com.kwad.sdk.feed.widget.base.a) this).f37439a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f37440b), System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.n.setVideoSoundEnable(this.q);
            j jVar = new j(this.f37442d, ((com.kwad.sdk.feed.widget.base.a) this).f37439a, this.n);
            this.o = jVar;
            jVar.setVideoPlayCallback(new a.InterfaceC0439a(this) { // from class: com.kwad.sdk.feed.widget.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37510a;

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
                    this.f37510a = this;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) this.f37510a).f37439a);
                        this.f37510a.s.a(3);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f37510a.a(j);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) this.f37510a).f37439a);
                        this.f37510a.s.a(9);
                        if (this.f37510a.r != null) {
                            this.f37510a.r.setVisibility(8);
                        }
                    }
                }
            });
            this.o.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.n.setController(this.o);
            if (this.r.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.r;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.r.setTag(null);
            }
            this.r.addView(this.n);
            this.r.setTag(this.n);
            this.r.setClickable(true);
            this.r.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37511a;

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
                    this.f37511a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f37511a.n.d()) {
                            l lVar = this.f37511a;
                            lVar.a(lVar.n);
                            return;
                        }
                        this.f37511a.n.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f37511a.f37440b), System.currentTimeMillis()));
                        this.f37511a.n.a();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            adTemplate.realShowType = 2;
            super.a(adTemplate);
            if (this.u) {
                com.kwad.sdk.feed.widget.base.a aVar = this.y;
                if (aVar != null) {
                    aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.y;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.z);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.k != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
            }
            String str = this.v;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f37500g.reload();
                } else {
                    f();
                }
            }
            this.v = adTemplate.mOriginJString;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, aVar) == null) {
            a aVar2 = this.A;
            if (aVar2 != null) {
                aVar2.a();
                this.A = null;
            }
            this.A = aVar;
            adTemplate.realShowType = 2;
            super.a(adTemplate);
            if (this.k != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
            }
            String str = this.v;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f37500g.reload();
                } else {
                    f();
                }
            }
            this.v = adTemplate.mOriginJString;
            this.D.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37503a;

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
                    this.f37503a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37503a.f37500g.stopLoading();
                        this.f37503a.f37500g.setVisibility(8);
                        this.f37503a.a("0");
                    }
                }
            }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        }
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
            this.f37501h = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
            ((com.kwad.sdk.feed.widget.base.a) this).f37439a = adTemplate;
            Double d2 = t.get(Long.valueOf(adTemplate.posId));
            if (d2 != null) {
                this.f37499f.setRatio(d2.floatValue());
            } else {
                double d3 = this.f37440b.adStyleInfo.feedAdInfo.heightRatio;
                if (d3 > 0.0d) {
                    ratioFrameLayout = this.f37499f;
                    c2 = (float) d3;
                } else if (this.f37499f.getRatio() == 0.0f) {
                    ratioFrameLayout = this.f37499f;
                    c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                }
                ratioFrameLayout.setRatio(c2);
            }
            m();
            n();
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
            this.f37500g = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.f37499f = (RatioFrameLayout) findViewById(R.id.ksad_container);
            this.r = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.p = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            File c2 = com.kwad.sdk.core.config.c.c(getContext());
            if (c2.exists() || c2.length() <= 0) {
                setupJsBridgeAndLoadUrl(Uri.fromFile(c2).toString());
            } else {
                a("0");
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k == 1 : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.ksad_feed_webview : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.D.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
        }
    }

    @Override // com.kwad.sdk.core.view.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            h();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (bVar = this.n) == null || (viewGroup = (ViewGroup) bVar.getParent()) == this.r) {
                return;
            }
            viewGroup.removeView(this.n);
            if (this.r.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.r;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.r.setTag(null);
            }
            this.r.addView(this.n);
            this.r.setTag(this.n);
            String a2 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
            this.n.setVideoSoundEnable(this.q);
            this.o.setVideoPlayCallback(new a.InterfaceC0439a(this) { // from class: com.kwad.sdk.feed.widget.l.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f37514a;

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
                    this.f37514a = this;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) this.f37514a).f37439a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f37514a.a(j);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) this.f37514a).f37439a);
                        if (this.f37514a.r != null) {
                            this.f37514a.r.setVisibility(8);
                        }
                    }
                }
            });
            this.o.m();
            this.o.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a2);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void setMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ksAdVideoPlayConfig) == null) {
            this.z = ksAdVideoPlayConfig;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.B = i2;
        }
    }
}
