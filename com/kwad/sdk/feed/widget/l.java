package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.v;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class l extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Long, Double> s;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup.MarginLayoutParams A;
    public Handler B;
    public p.b C;
    public final a.InterfaceC2027a D;
    public RatioFrameLayout a;

    /* renamed from: f  reason: collision with root package name */
    public KsAdWebView f58570f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58571g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f58572h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58573i;

    /* renamed from: j  reason: collision with root package name */
    public int f58574j;

    /* renamed from: k  reason: collision with root package name */
    public double f58575k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public ImageView o;
    public boolean p;
    public KSFrameLayout q;
    public v r;
    public boolean t;
    public String u;
    public boolean v;
    public com.kwad.sdk.feed.widget.base.a w;
    public KsAdVideoPlayConfig x;
    public a y;
    public int z;

    /* loaded from: classes2.dex */
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
        this.f58574j = -1;
        this.p = false;
        this.v = false;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new p.b(this) { // from class: com.kwad.sdk.feed.widget.l.12
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.a.t) {
                    return;
                }
                this.a.f58574j = aVar.a;
                if (this.a.f58574j != 1) {
                    this.a.a("3");
                    return;
                }
                if (this.a.w != null) {
                    this.a.w.setVisibility(8);
                }
                this.a.f58570f.setVisibility(0);
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                this.a.B.removeCallbacksAndMessages(null);
                if (this.a.y != null) {
                    this.a.y.a();
                }
            }
        };
        this.D = new a.InterfaceC2027a(this) { // from class: com.kwad.sdk.feed.widget.l.5
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2027a
            public void a(int i4, z.a aVar) {
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, aVar) == null) {
                    int i6 = 2;
                    boolean z = false;
                    if (i4 == 1) {
                        i5 = 13;
                    } else if (i4 == 2) {
                        i5 = 82;
                    } else if (i4 != 3) {
                        i5 = 108;
                    } else {
                        i5 = 83;
                        i6 = 1;
                        z = true;
                    }
                    p.a aVar2 = new p.a();
                    aVar2.f57686g = aVar;
                    aVar2.f57681b = i5;
                    com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this.a.m)).a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b).a(this.a.f58571g).a(i6).a(z).c(true).a(aVar2).e(true).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass5 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i7 = newInitContext2.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.l();
                            }
                        }
                    }));
                }
            }
        };
        this.z = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65554, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.l;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.l.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, bVar) == null) || bVar == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
        boolean z = false;
        this.n.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.m);
        FeedType fromInt = FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f58528b.type);
        a.C2015a a3 = new a.C2015a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(this.f58571g).a(2);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) this).f58529c)) {
            z = true;
        }
        com.kwad.sdk.core.download.a.a.a(a3.e(z).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.3
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

            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.k();
                }
            }
        }));
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, gVar) == null) {
            this.r = new v();
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f58573i, this.f58571g, getClickListener()));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f58573i, this.f58571g, getClickListener()));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f58573i, new j.b(this) { // from class: com.kwad.sdk.feed.widget.l.7
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

                @Override // com.kwad.sdk.core.webview.jshandler.j.b
                public void a(j.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.a.f58570f.setVisibility(0);
                        if (this.a.f58575k == 0.0d) {
                            this.a.f58575k = aVar.a;
                            double d2 = aVar.a / this.a.z;
                            this.a.a.setRatio((float) d2);
                            l.s.put(Long.valueOf(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b.posId), Double.valueOf(d2));
                        }
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f58573i));
            gVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.sdk.feed.widget.l.8
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

                @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
                public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && ((com.kwad.sdk.feed.widget.base.a) this.a).f58529c != null && com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) this.a).f58529c)) {
                        l lVar = this.a;
                        lVar.A = (ViewGroup.MarginLayoutParams) lVar.q.getLayoutParams();
                        int ceil = (int) Math.ceil(this.a.f58575k);
                        int i2 = this.a.z;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.a.A.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d2 = i2;
                        this.a.A.leftMargin = (int) (videoPosition.leftMarginRation * d2);
                        this.a.A.width = (int) (d2 * videoPosition.widthRation);
                        this.a.A.height = (int) (this.a.A.width * videoPosition.heightWidthRation);
                        this.a.q.setRadius(videoPosition.borderRadius);
                        this.a.q.setLayoutParams(this.a.A);
                        l lVar2 = this.a;
                        lVar2.a(lVar2.x);
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f58573i, new c.a(this) { // from class: com.kwad.sdk.feed.widget.l.9
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

                @Override // com.kwad.sdk.core.webview.jshandler.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.B.post(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.9.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass9 a;

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

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.m();
                                }
                            }
                        });
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58573i));
            com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.f58573i);
            dVar.a(new d.b(this) { // from class: com.kwad.sdk.feed.widget.l.10
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

                @Override // com.kwad.sdk.core.webview.jshandler.d.b
                public void a(d.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        aVar.f57994b = 0;
                        aVar.a = this.a.z;
                        this.a.v = true;
                    }
                }
            });
            gVar.a(dVar);
            gVar.a(new com.kwad.sdk.core.webview.jshandler.p(this.C));
            gVar.a(new t(this.f58573i, this.f58571g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f58573i));
            gVar.a(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
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
            AdTemplate adTemplate = ((com.kwad.sdk.feed.widget.base.a) this).f58528b;
            com.kwad.sdk.core.report.d.c(adTemplate, com.kwad.sdk.core.response.a.b.k(adTemplate), str);
            if (this.w == null) {
                com.kwad.sdk.feed.widget.base.a a2 = com.kwad.sdk.feed.a.a(getContext(), FeedType.fromInt(((com.kwad.sdk.feed.widget.base.a) this).f58528b.type), com.kwad.sdk.core.response.a.a.R(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
                this.w = a2;
                if (a2 != null) {
                    this.w.setMargin(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
                    this.a.removeAllViews();
                    this.a.setRatio(0.0f);
                    this.f58570f.setVisibility(8);
                    this.q.setVisibility(8);
                }
                this.a.addView(this.w);
                this.w.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, this, aVar)) == null) ? aVar.a ? aVar.f57987b : aVar.f57988c == 1 : invokeL.booleanValue;
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

    @NonNull
    private b.c getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) ? new b.c(this) { // from class: com.kwad.sdk.feed.widget.l.11
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

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    int i2 = aVar.f57988c;
                    if (aVar.a) {
                        i2 = aVar.f57987b ? 1 : 2;
                    }
                    boolean z = com.kwad.sdk.core.response.a.a.P(((com.kwad.sdk.feed.widget.base.a) this.a).f58529c) && (((com.kwad.sdk.feed.widget.base.a) this.a).f58528b.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || ((com.kwad.sdk.feed.widget.base.a) this.a).f58528b.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                    p.a aVar2 = new p.a();
                    b.C2032b c2032b = aVar.f57989d;
                    if (c2032b != null && !TextUtils.isEmpty(c2032b.a)) {
                        aVar2.f57687h = aVar.f57989d.a;
                    }
                    com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this.a)).a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b).a(this.a.f58571g).a(this.a.a(aVar)).a(i2).f(aVar.a).e(z).a(aVar2).c(true).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.11.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass11 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || ((com.kwad.sdk.feed.widget.base.a) this.a.a).f58530d == null) {
                                return;
                            }
                            ((com.kwad.sdk.feed.widget.base.a) this.a.a).f58530d.a();
                        }
                    }));
                }
            }
        } : (b.c) invokeV.objValue;
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
            this.f58573i = aVar;
            aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            com.kwad.sdk.core.webview.a aVar2 = this.f58573i;
            aVar2.a = 0;
            aVar2.f57955b = null;
            aVar2.f57957d = this.a;
            aVar2.f57958e = this.f58570f;
            aVar2.f57956c = null;
            aVar2.f57961h = false;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            r();
            be.b(this.f58570f);
            this.f58570f.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.feed.widget.l.6
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

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.v = false;
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        this.a.a("1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.v) {
                        return;
                    }
                    this.a.a("2");
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f58570f);
            this.f58572h = gVar;
            a(gVar);
            this.f58570f.addJavascriptInterface(this.f58572h, "KwaiAd");
            this.f58570f.loadUrl(com.kwad.sdk.core.response.a.b.k(((com.kwad.sdk.feed.widget.base.a) this).f58528b));
        }
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (gVar = this.f58572h) == null) {
            return;
        }
        gVar.a();
        this.f58572h = null;
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
            String a2 = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f58529c).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.o;
                i2 = 8;
            } else {
                this.o.setImageDrawable(null);
                KSImageLoader.loadImage(this.o, a2, ((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                imageView = this.o;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f58531e);
            this.m = bVar;
            bVar.setTag(this.l);
            String a3 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(a3).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f58528b))).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.m.setVideoSoundEnable(this.p);
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f58531e, ((com.kwad.sdk.feed.widget.base.a) this).f58528b, this.m);
            this.n = jVar;
            jVar.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f58576b;

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
                    this.a = this;
                    this.f58576b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                        this.a.a(j2);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                        this.a.r.a(3);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58576b) {
                        return;
                    }
                    this.f58576b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                        this.a.r.a(9);
                        if (this.a.q != null) {
                            this.a.q.setVisibility(8);
                        }
                    }
                }
            });
            this.n.setAdClickListener(this.D);
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.m.setController(this.n);
            if (this.q.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.q;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.m);
            this.q.setTag(this.m);
            this.q.setClickable(true);
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.l.2
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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
                        if (!this.a.m.d()) {
                            l lVar = this.a;
                            lVar.a(lVar.m);
                            return;
                        }
                        m.b(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                        this.a.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b));
                        this.a.m.a();
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
                    aVar.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.w;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.x);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f58574j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f58570f.reload();
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
            if (this.f58574j != 1) {
                b(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            }
            String str = this.u;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (g()) {
                    this.f58570f.reload();
                } else {
                    d();
                }
            }
            this.u = adTemplate.mOriginJString;
            this.B.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.feed.widget.l.1
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.f58570f.stopLoading();
                        this.a.f58570f.setVisibility(8);
                        this.a.a("0");
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
            m.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
        }
    }

    public void b(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adTemplate) == null) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            this.f58571g = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.f58571g.a((DialogInterface.OnDismissListener) this);
            ((com.kwad.sdk.feed.widget.base.a) this).f58528b = adTemplate;
            Double d2 = s.get(Long.valueOf(adTemplate.posId));
            if (d2 != null) {
                this.a.setRatio(d2.floatValue());
            } else {
                if (com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).f58528b) > 0.0f) {
                    ratioFrameLayout = this.a;
                    c2 = com.kwad.sdk.core.response.a.b.l(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                } else if (this.a.getRatio() == 0.0f) {
                    ratioFrameLayout = this.a;
                    c2 = c(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
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
            this.f58570f = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.a = (RatioFrameLayout) findViewById(R.id.ksad_container);
            this.q = (KSFrameLayout) findViewById(R.id.ksad_video_container);
            this.o = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (com.kwad.sdk.core.response.a.b.m(((com.kwad.sdk.feed.widget.base.a) this).f58528b)) {
                q();
            } else {
                a("0");
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58574j == 1 : invokeV.booleanValue;
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
                KSFrameLayout kSFrameLayout = this.q;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.q.setTag(null);
            }
            this.q.addView(this.m);
            this.q.setTag(this.m);
            String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            this.m.setVideoSoundEnable(this.p);
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.x;
            if (ksAdVideoPlayConfig != null) {
                this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            }
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.feed.widget.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f58577b;

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
                    this.f58577b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                        this.a.a(j2);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58577b) {
                        return;
                    }
                    this.f58577b = true;
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                        if (this.a.q != null) {
                            this.a.q.setVisibility(8);
                        }
                    }
                }
            });
            this.n.setAdClickListener(this.D);
            this.n.getAdTemplate().mAdWebVideoPageShowing = false;
            this.n.p();
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
