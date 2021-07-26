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
/* loaded from: classes6.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Long, Double> s;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup.MarginLayoutParams A;
    public Handler B;
    public m.b C;
    public final a.InterfaceC0425a D;

    /* renamed from: a  reason: collision with root package name */
    public RatioFrameLayout f35836a;

    /* renamed from: f  reason: collision with root package name */
    public KsAdWebView f35837f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35838g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f35839h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f35840i;
    public int j;
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

    /* loaded from: classes6.dex */
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
        this.j = -1;
        this.p = false;
        this.v = false;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new m.b(this) { // from class: com.kwad.sdk.feed.widget.l.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f35846a;

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
                this.f35846a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) || this.f35846a.t) {
                    return;
                }
                this.f35846a.j = i4;
                if (this.f35846a.j != 1) {
                    this.f35846a.a("3");
                    return;
                }
                if (this.f35846a.w != null) {
                    this.f35846a.w.setVisibility(8);
                }
                this.f35846a.f35837f.setVisibility(0);
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f35846a).f35779b);
                this.f35846a.B.removeCallbacksAndMessages(null);
                if (this.f35846a.y != null) {
                    this.f35846a.y.a();
                }
            }
        };
        this.D = new a.InterfaceC0425a(this) { // from class: com.kwad.sdk.feed.widget.l.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f35854a;

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
                this.f35854a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0425a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35854a.l();
                }
            }
        };
        this.z = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65557, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.l;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.l.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f35779b, ceil, null);
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
        String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f35780c);
        this.n.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.m);
        FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f35779b.type);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this).f35780c)) {
            com.kwad.sdk.core.download.b.a.b(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35779b, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.feed.widget.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35850a;

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
                    this.f35850a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35850a.k();
                    }
                }
            }, this.f35838g, z);
        } else {
            com.kwad.sdk.core.download.b.a.a(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35779b, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.feed.widget.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35851a;

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
                    this.f35851a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35851a.k();
                    }
                }
            }, this.f35838g, z);
        }
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, gVar) == null) {
            this.r = new r();
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f35840i, this.f35838g, new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35856a;

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
                    this.f35856a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C0429a c0429a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0429a) == null) {
                        if (com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this.f35856a).f35780c) && (((com.kwad.sdk.feed.widget.base.a) this.f35856a).f35779b.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) this.f35856a).f35779b.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType())) {
                            com.kwad.sdk.core.download.b.a.b(av.a(this.f35856a), ((com.kwad.sdk.feed.widget.base.a) this.f35856a).f35779b, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.feed.widget.l.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f35857a;

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
                                    this.f35857a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || ((com.kwad.sdk.feed.widget.base.a) this.f35857a.f35856a).f35781d == null) {
                                        return;
                                    }
                                    ((com.kwad.sdk.feed.widget.base.a) this.f35857a.f35856a).f35781d.a();
                                }
                            }, this.f35856a.f35838g, c0429a != null ? c0429a.f35344a : false);
                        } else {
                            com.kwad.sdk.core.download.b.a.a(av.a(this.f35856a), ((com.kwad.sdk.feed.widget.base.a) this.f35856a).f35779b, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.feed.widget.l.8.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f35858a;

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
                                    this.f35858a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || ((com.kwad.sdk.feed.widget.base.a) this.f35858a.f35856a).f35781d == null) {
                                        return;
                                    }
                                    ((com.kwad.sdk.feed.widget.base.a) this.f35858a.f35856a).f35781d.a();
                                }
                            }, this.f35856a.f35838g, c0429a != null ? c0429a.f35344a : false);
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.i(this.f35840i, new i.b(this) { // from class: com.kwad.sdk.feed.widget.l.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35859a;

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
                    this.f35859a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f35859a.f35837f.setVisibility(0);
                        if (this.f35859a.k == 0.0d) {
                            this.f35859a.k = aVar.f35403a;
                            double d2 = aVar.f35403a / this.f35859a.z;
                            this.f35859a.f35836a.setRatio((float) d2);
                            l.s.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) this.f35859a).f35779b.posId), Double.valueOf(d2));
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f35840i));
            gVar.a(new WebCardVideoPositionHandler(this.f35840i, new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.feed.widget.l.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35842a;

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
                    this.f35842a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && ((com.kwad.sdk.feed.widget.base.a) this.f35842a).f35780c != null && com.kwad.sdk.core.response.b.a.F(((com.kwad.sdk.feed.widget.base.a) this.f35842a).f35780c)) {
                        l lVar = this.f35842a;
                        lVar.A = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                        int ceil = (int) Math.ceil(this.f35842a.k);
                        int i2 = this.f35842a.z;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.f35842a.A.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d2 = i2;
                        this.f35842a.A.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                        this.f35842a.A.width = (int) (d2 * videoPosition.widthRation);
                        this.f35842a.A.height = (int) (this.f35842a.A.width * videoPosition.heightWidthRation);
                        this.f35842a.q.setLayoutParams(this.f35842a.A);
                        l lVar2 = this.f35842a;
                        lVar2.a(lVar2.x);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f35840i, new b.a(this) { // from class: com.kwad.sdk.feed.widget.l.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35843a;

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
                    this.f35843a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35843a.B.post(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.11.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass11 f35844a;

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
                                this.f35844a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f35844a.f35843a.m();
                                }
                            }
                        });
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f35840i));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f35840i);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.feed.widget.l.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35845a;

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
                    this.f35845a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f35352b = 0;
                        aVar.f35351a = this.f35845a.z;
                        this.f35845a.v = true;
                    }
                }
            });
            gVar.a(cVar);
            gVar.a(new m(this.C));
            gVar.a(new q(this.f35840i, this.f35838g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f35840i));
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
            com.kwad.sdk.core.report.d.c(((com.kwad.sdk.feed.widget.base.a) this).f35779b, com.kwad.sdk.core.config.c.a().h5Url, str);
            if (this.w == null) {
                com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f35779b.type), com.kwad.sdk.core.response.b.a.H(((com.kwad.sdk.feed.widget.base.a) this).f35780c));
                this.w = a2;
                if (a2 != null) {
                    this.w.setMargin(av.a(getContext(), 16.0f));
                    this.f35836a.removeAllViews();
                    this.f35836a.setRatio(0.0f);
                    this.f35837f.setVisibility(8);
                    this.q.setVisibility(8);
                }
                this.f35836a.addView(this.w);
                this.w.a(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
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
            this.f35840i = aVar;
            aVar.f35288b = ((com.kwad.sdk.feed.widget.base.a) this).f35779b;
            aVar.f35287a = 0;
            aVar.f35289c = null;
            aVar.f35291e = this.f35836a;
            aVar.f35292f = this.f35837f;
            aVar.f35290d = null;
            aVar.f35294h = false;
        }
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65585, this) == null) || (gVar = this.f35839h) == null) {
            return;
        }
        gVar.a();
        this.f35839h = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridgeAndLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, this, str) == null) {
            q();
            ay.b(this.f35837f);
            this.f35837f.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.feed.widget.l.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35855a;

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
                    this.f35855a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35855a.v = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, str3) == null) {
                        this.f35855a.a("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35855a.v) {
                        return;
                    }
                    this.f35855a.a("2");
                }
            });
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f35837f);
            this.f35839h = gVar;
            a(gVar);
            this.f35837f.addJavascriptInterface(this.f35839h, "KwaiAd");
            this.f35837f.loadUrl(str);
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
            String a2 = com.kwad.sdk.core.response.b.a.T(((com.kwad.sdk.feed.widget.base.a) this).f35780c).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.o;
                i2 = 8;
            } else {
                this.o.setImageDrawable(null);
                KSImageLoader.loadImage(this.o, a2, ((com.kwad.sdk.feed.widget.base.a) this).f35779b);
                imageView = this.o;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l = com.kwad.sdk.core.response.b.a.I(((com.kwad.sdk.feed.widget.base.a) this).f35780c);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f35782e);
            this.m = bVar;
            bVar.setTag(this.l);
            String a3 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f35780c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.m.a(new c.a().a(a3).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.feed.widget.base.a) this).f35779b))).a(((com.kwad.sdk.feed.widget.base.a) this).f35779b.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f35779b, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.m.setVideoSoundEnable(this.p);
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f35782e, ((com.kwad.sdk.feed.widget.base.a) this).f35779b, this.m);
            this.n = jVar;
            jVar.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35847a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f35848b;

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
                    this.f35847a = this;
                    this.f35848b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f35847a).f35779b);
                        this.f35847a.r.a(3);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f35847a.a(j);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35848b) {
                        return;
                    }
                    this.f35848b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f35847a).f35779b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f35847a).f35779b);
                        this.f35847a.r.a(9);
                        if (this.f35847a.q != null) {
                            this.f35847a.q.setVisibility(8);
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
                public final /* synthetic */ l f35849a;

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
                    this.f35849a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f35849a.m.d()) {
                            l lVar = this.f35849a;
                            lVar.a(lVar.m, false);
                            return;
                        }
                        com.kwad.sdk.utils.j.b(((com.kwad.sdk.feed.widget.base.a) this.f35849a).f35779b);
                        this.f35849a.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this.f35849a).f35779b));
                        this.f35849a.m.a();
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
                    aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f35837f.reload();
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
            if (this.j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f35837f.reload();
                } else {
                    d();
                }
            }
            this.u = adTemplate.mOriginJString;
            this.B.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35841a;

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
                    this.f35841a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35841a.f35837f.stopLoading();
                        this.f35841a.f35837f.setVisibility(8);
                        this.f35841a.a("0");
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
            com.kwad.sdk.utils.j.a(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
        }
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adTemplate) == null) {
            this.f35838g = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
            ((com.kwad.sdk.feed.widget.base.a) this).f35779b = adTemplate;
            Double d2 = s.get(Long.valueOf(adTemplate.posId));
            if (d2 != null) {
                this.f35836a.setRatio(d2.floatValue());
            } else {
                double d3 = ((com.kwad.sdk.feed.widget.base.a) this).f35780c.adStyleInfo.feedAdInfo.heightRatio;
                if (d3 > 0.0d) {
                    ratioFrameLayout = this.f35836a;
                    c2 = (float) d3;
                } else if (this.f35836a.getRatio() == 0.0f) {
                    ratioFrameLayout = this.f35836a;
                    c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f35779b);
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
            this.f35837f = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.f35836a = (RatioFrameLayout) findViewById(R.id.ksad_container);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j == 1 : invokeV.booleanValue;
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
            String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f35780c);
            this.m.setVideoSoundEnable(this.p);
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.x;
            if (ksAdVideoPlayConfig != null) {
                this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            }
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f35852a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f35853b;

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
                    this.f35852a = this;
                    this.f35853b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f35852a).f35779b);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f35852a.a(j);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35853b) {
                        return;
                    }
                    this.f35853b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f35852a).f35779b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f35852a).f35779b);
                        if (this.f35852a.q != null) {
                            this.f35852a.q.setVisibility(8);
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
