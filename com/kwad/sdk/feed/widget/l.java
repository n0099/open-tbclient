package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.contentalliance.detail.video.c;
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
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.core.webview.jshandler.r;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Long, Double> s;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup.MarginLayoutParams A;
    public Handler B;
    public m.b C;
    public final a.InterfaceC1996a D;

    /* renamed from: a  reason: collision with root package name */
    public RatioFrameLayout f72811a;

    /* renamed from: f  reason: collision with root package name */
    public KsAdWebView f72812f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72813g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f72814h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f72815i;

    /* renamed from: j  reason: collision with root package name */
    public int f72816j;
    public double k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public ImageView o;
    public boolean p;
    public RatioFrameLayout q;
    public r r;
    public boolean t;
    public String u;
    public boolean v;
    public com.kwad.sdk.feed.widget.base.a w;
    public KsAdVideoPlayConfig x;
    public a y;
    public int z;

    /* loaded from: classes10.dex */
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
        s = new HashMap<>(8);
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
        this.f72816j = -1;
        this.p = false;
        this.v = false;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new m.b(this) { // from class: com.kwad.sdk.feed.widget.l.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f72822a;

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
                this.f72822a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f72822a.t) {
                    return;
                }
                this.f72822a.f72816j = i4;
                if (this.f72822a.f72816j != 1) {
                    this.f72822a.a("3");
                    return;
                }
                if (this.f72822a.w != null) {
                    this.f72822a.w.setVisibility(8);
                }
                this.f72822a.f72812f.setVisibility(0);
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f72822a).f72749b);
                this.f72822a.B.removeCallbacksAndMessages(null);
                if (this.f72822a.y != null) {
                    this.f72822a.y.a();
                }
            }
        };
        this.D = new a.InterfaceC1996a(this) { // from class: com.kwad.sdk.feed.widget.l.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f72830a;

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
                this.f72830a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1996a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f72830a.l();
                }
            }
        };
        this.z = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65557, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.l;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.l.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f72749b, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65558, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
        this.n.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.m);
        FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f72749b.type);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this).f72750c)) {
            com.kwad.sdk.core.download.b.a.b(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f72749b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72826a;

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
                    this.f72826a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72826a.k();
                    }
                }
            }, this.f72813g, z);
        } else {
            com.kwad.sdk.core.download.b.a.a(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f72749b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72827a;

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
                    this.f72827a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72827a.k();
                    }
                }
            }, this.f72813g, z);
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, gVar) == null) {
            this.r = new r();
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f72815i, this.f72813g, new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72832a;

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
                    this.f72832a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2000a c2000a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) {
                        if (com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this.f72832a).f72750c) && (((com.kwad.sdk.feed.widget.base.a) this.f72832a).f72749b.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) this.f72832a).f72749b.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                            com.kwad.sdk.core.download.b.a.b(av.a(this.f72832a), ((com.kwad.sdk.feed.widget.base.a) this.f72832a).f72749b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.l.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f72833a;

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
                                    this.f72833a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || ((com.kwad.sdk.feed.widget.base.a) this.f72833a.f72832a).f72751d == null) {
                                        return;
                                    }
                                    ((com.kwad.sdk.feed.widget.base.a) this.f72833a.f72832a).f72751d.a();
                                }
                            }, this.f72832a.f72813g, c2000a != null ? c2000a.f72299a : false);
                        } else {
                            com.kwad.sdk.core.download.b.a.a(av.a(this.f72832a), ((com.kwad.sdk.feed.widget.base.a) this.f72832a).f72749b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.l.8.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f72834a;

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
                                    this.f72834a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || ((com.kwad.sdk.feed.widget.base.a) this.f72834a.f72832a).f72751d == null) {
                                        return;
                                    }
                                    ((com.kwad.sdk.feed.widget.base.a) this.f72834a.f72832a).f72751d.a();
                                }
                            }, this.f72832a.f72813g, c2000a != null ? c2000a.f72299a : false);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.f72815i, new i.b(this) { // from class: com.kwad.sdk.feed.widget.l.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72835a;

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
                    this.f72835a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f72835a.f72812f.setVisibility(0);
                        if (this.f72835a.k == 0.0d) {
                            this.f72835a.k = aVar.f72360a;
                            double d2 = aVar.f72360a / this.f72835a.z;
                            this.f72835a.f72811a.setRatio((float) d2);
                            l.s.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) this.f72835a).f72749b.posId), Double.valueOf(d2));
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f72815i));
            gVar.a(new WebCardVideoPositionHandler(this.f72815i, new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.feed.widget.l.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72818a;

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
                    this.f72818a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && ((com.kwad.sdk.feed.widget.base.a) this.f72818a).f72750c != null && com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this.f72818a).f72750c)) {
                        l lVar = this.f72818a;
                        lVar.A = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                        int ceil = (int) Math.ceil(this.f72818a.k);
                        int i2 = this.f72818a.z;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.f72818a.A.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d2 = i2;
                        this.f72818a.A.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                        this.f72818a.A.width = (int) (d2 * videoPosition.widthRation);
                        this.f72818a.A.height = (int) (this.f72818a.A.width * videoPosition.heightWidthRation);
                        this.f72818a.q.setLayoutParams(this.f72818a.A);
                        l lVar2 = this.f72818a;
                        lVar2.a(lVar2.x);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f72815i, new b.a(this) { // from class: com.kwad.sdk.feed.widget.l.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72819a;

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
                    this.f72819a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72819a.B.post(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.11.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass11 f72820a;

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
                                this.f72820a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f72820a.f72819a.m();
                                }
                            }
                        });
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f72815i));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f72815i);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.feed.widget.l.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72821a;

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
                    this.f72821a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f72307b = 0;
                        aVar.f72306a = this.f72821a.z;
                        this.f72821a.v = true;
                    }
                }
            });
            gVar.a(cVar);
            gVar.a(new m(this.C));
            gVar.a(new q(this.f72815i, this.f72813g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f72815i));
            gVar.a(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            com.kwad.sdk.core.d.a.a("FeedWebView", "handleWebViewError " + str);
            this.B.removeCallbacksAndMessages(null);
            if (this.t) {
                return;
            }
            a aVar = this.y;
            if (aVar != null) {
                aVar.a();
            }
            this.y = null;
            this.t = true;
            com.kwad.sdk.core.report.d.c(((com.kwad.sdk.feed.widget.base.a) this).f72749b, com.kwad.sdk.core.config.c.a().h5Url, str);
            if (this.w == null) {
                com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f72749b.type), com.kwad.sdk.core.response.b.a.H(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
                this.w = a2;
                if (a2 != null) {
                    this.w.setMargin(av.a(getContext(), 16.0f));
                    this.f72811a.removeAllViews();
                    this.f72811a.setRatio(0.0f);
                    this.f72812f.setVisibility(8);
                    this.q.setVisibility(8);
                }
                this.f72811a.addView(this.w);
                this.w.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                }
            }
        }
    }

    private float c(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, adTemplate)) == null) {
            int i2 = adTemplate.type;
            if (i2 == 1) {
                return 0.6013f;
            }
            return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
        }
        return invokeL.floatValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f72815i = aVar;
            aVar.f72243b = ((com.kwad.sdk.feed.widget.base.a) this).f72749b;
            aVar.f72242a = 0;
            aVar.f72244c = null;
            aVar.f72246e = this.f72811a;
            aVar.f72247f = this.f72812f;
            aVar.f72245d = null;
            aVar.f72249h = false;
        }
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65585, this) == null) || (gVar = this.f72814h) == null) {
            return;
        }
        gVar.a();
        this.f72814h = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, this, str) == null) {
            q();
            ay.b(this.f72812f);
            this.f72812f.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.feed.widget.l.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72831a;

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
                    this.f72831a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72831a.v = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.f72831a.a("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72831a.v) {
                        return;
                    }
                    this.f72831a.a("2");
                }
            });
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f72812f);
            this.f72814h = gVar;
            a(gVar);
            this.f72812f.addJavascriptInterface(this.f72814h, "KwaiAd");
            this.f72812f.loadUrl(str);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksAdVideoPlayConfig) == null) {
            this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.b.a.T(((com.kwad.sdk.feed.widget.base.a) this).f72750c).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.o;
                i2 = 8;
            } else {
                this.o.setImageDrawable(null);
                KSImageLoader.loadImage(this.o, a2, ((com.kwad.sdk.feed.widget.base.a) this).f72749b);
                imageView = this.o;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l = com.kwad.sdk.core.response.b.a.I(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f72752e);
            this.m = bVar;
            bVar.setTag(this.l);
            String a3 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.m.a(new c.a().a(a3).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.feed.widget.base.a) this).f72749b))).a(((com.kwad.sdk.feed.widget.base.a) this).f72749b.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f72749b, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.m.setVideoSoundEnable(this.p);
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f72752e, ((com.kwad.sdk.feed.widget.base.a) this).f72749b, this.m);
            this.n = jVar;
            jVar.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72823a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f72824b;

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
                    this.f72823a = this;
                    this.f72824b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f72823a).f72749b);
                        this.f72823a.r.a(3);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f72823a.a(j2);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72824b) {
                        return;
                    }
                    this.f72824b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f72823a).f72749b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f72823a).f72749b);
                        this.f72823a.r.a(9);
                        if (this.f72823a.q != null) {
                            this.f72823a.q.setVisibility(8);
                        }
                    }
                }
            });
            this.n.setVideoClickListener(this.D);
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.m.setController(this.n);
            if (this.q.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.q;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.m);
            this.q.setTag(this.m);
            this.q.setClickable(true);
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72825a;

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
                    this.f72825a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f72825a.m.d()) {
                            l lVar = this.f72825a;
                            lVar.a(lVar.m, false);
                            return;
                        }
                        com.kwad.sdk.utils.j.b(((com.kwad.sdk.feed.widget.base.a) this.f72825a).f72749b);
                        this.f72825a.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this.f72825a).f72749b));
                        this.f72825a.m.a();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            adTemplate.realShowType = 2;
            super.a(adTemplate);
            if (this.t) {
                com.kwad.sdk.feed.widget.base.a aVar = this.w;
                if (aVar != null) {
                    aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f72816j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f72812f.reload();
                } else {
                    d();
                }
            }
            this.u = adTemplate.mOriginJString;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adTemplate, aVar) == null) {
            a aVar2 = this.y;
            if (aVar2 != null) {
                aVar2.a();
                this.y = null;
            }
            this.y = aVar;
            adTemplate.realShowType = 2;
            super.a(adTemplate);
            if (this.f72816j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f72812f.reload();
                } else {
                    d();
                }
            }
            this.u = adTemplate.mOriginJString;
            this.B.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72817a;

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
                    this.f72817a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72817a.f72812f.stopLoading();
                        this.f72817a.f72812f.setVisibility(8);
                        this.f72817a.a("0");
                    }
                }
            }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b();
            com.kwad.sdk.utils.j.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
        }
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adTemplate) == null) {
            this.f72813g = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
            ((com.kwad.sdk.feed.widget.base.a) this).f72749b = adTemplate;
            Double d2 = s.get(Long.valueOf(adTemplate.posId));
            if (d2 != null) {
                this.f72811a.setRatio(d2.floatValue());
            } else {
                double d3 = ((com.kwad.sdk.feed.widget.base.a) this).f72750c.adStyleInfo.feedAdInfo.heightRatio;
                if (d3 > 0.0d) {
                    ratioFrameLayout = this.f72811a;
                    c2 = (float) d3;
                } else if (this.f72811a.getRatio() == 0.0f) {
                    ratioFrameLayout = this.f72811a;
                    c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
                }
                ratioFrameLayout.setRatio(c2);
            }
            o();
            p();
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_card_webView);
            this.f72812f = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.f72811a = (RatioFrameLayout) findViewById(R.id.ksad_container);
            this.q = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.o = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            File e2 = com.kwad.sdk.core.config.c.e(getContext());
            if (e2.exists() || e2.length() <= 0) {
                setupJsBridgeAndLoadUrl(Uri.fromFile(e2).toString());
            } else {
                a("0");
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72816j == 1 : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.ksad_feed_webview : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.B.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            h();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (bVar = this.m) == null || (viewGroup = (ViewGroup) bVar.getParent()) == this.q) {
                return;
            }
            viewGroup.removeView(this.m);
            if (this.q.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.q;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.m);
            this.q.setTag(this.m);
            String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
            this.m.setVideoSoundEnable(this.p);
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.x;
            if (ksAdVideoPlayConfig != null) {
                this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            }
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f72828a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f72829b;

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
                    this.f72828a = this;
                    this.f72829b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f72828a).f72749b);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f72828a.a(j2);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72829b) {
                        return;
                    }
                    this.f72829b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f72828a).f72749b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f72828a).f72749b);
                        if (this.f72828a.q != null) {
                            this.f72828a.q.setVisibility(8);
                        }
                    }
                }
            });
            this.n.setVideoClickListener(this.D);
            this.n.o();
            this.n.setAutoRelease(true);
            AdVideoPlayerViewCache.a().a(a2);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void setMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ksAdVideoPlayConfig) == null) {
            this.x = ksAdVideoPlayConfig;
            com.kwad.sdk.core.video.videoview.b bVar = this.m;
            if (bVar != null) {
                bVar.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            }
            j jVar = this.n;
            if (jVar != null) {
                jVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            }
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.z = i2;
        }
    }
}
