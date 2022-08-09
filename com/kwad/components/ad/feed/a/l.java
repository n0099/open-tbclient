package com.kwad.components.ad.feed.a;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.h;
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
    public static final HashMap<Long, Double> dQ;
    public transient /* synthetic */ FieldHolder $fh;
    public int bH;
    public x.b bM;
    public List<Integer> bv;
    public KsAdVideoPlayConfig cN;
    public RatioFrameLayout dL;
    public double dM;
    public KSFrameLayout dN;
    public ad dO;
    public aa dP;
    public boolean dR;
    public String dS;
    public boolean dT;
    public boolean dU;
    public com.kwad.components.core.widget.b dV;
    public a dW;
    public ViewGroup.MarginLayoutParams dX;
    public b.InterfaceC0376b dY;

    /* renamed from: do  reason: not valid java name */
    public ImageView f5do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.video.c dq;
    public d dr;
    public boolean ds;
    public boolean dt;
    public final a.InterfaceC0363a du;
    public h.a dv;
    public KsAdWebView mAdWebView;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Handler mHandler;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public int mWidth;

    /* loaded from: classes5.dex */
    public interface a {
        void aZ();
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
        dQ = new HashMap<>(8);
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
        this.bH = -1;
        this.ds = false;
        this.dT = false;
        this.dU = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.feed.a.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.dZ.dt = false;
                    if (this.dZ.dp != null) {
                        this.dZ.dp.setVideoSoundEnable(false);
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.dY = new b.InterfaceC0376b(this) { // from class: com.kwad.components.ad.feed.a.l.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onAdClicked() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.dZ.lp == null) {
                    return;
                }
                this.dZ.lp.onAdClicked();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onAdShow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.dZ.lp != null) {
                        this.dZ.lp.onAdShow();
                    }
                    if (this.dZ.dU) {
                        com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                        u.a aVar = new u.a();
                        FeedType fromInt = FeedType.fromInt(this.dZ.mAdTemplate.type);
                        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                        }
                        aVar.templateId = String.valueOf(fromInt.getType());
                        fVar.a(aVar);
                        com.kwad.components.core.m.c.ox().a(this.dZ.mAdTemplate, null, fVar);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDislikeClicked() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.dZ.lp == null) {
                    return;
                }
                this.dZ.lp.onDislikeClicked();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDownloadTipsDialogDismiss() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.dZ.lp == null) {
                    return;
                }
                this.dZ.lp.onDownloadTipsDialogDismiss();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDownloadTipsDialogShow() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.dZ.lp == null) {
                    return;
                }
                this.dZ.lp.onDownloadTipsDialogShow();
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.ad.feed.a.l.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.dZ.dR) {
                    return;
                }
                this.dZ.bH = aVar.status;
                if (this.dZ.bH != 1) {
                    this.dZ.t("3");
                    return;
                }
                if (this.dZ.dV != null) {
                    this.dZ.dV.setVisibility(8);
                }
                this.dZ.mAdWebView.setVisibility(0);
                com.kwad.components.core.j.a.og().O(this.dZ.mAdTemplate);
                this.dZ.mHandler.removeCallbacksAndMessages(null);
                if (this.dZ.dW != null) {
                    this.dZ.dW.aZ();
                }
            }
        };
        this.du = new a.InterfaceC0363a(this) { // from class: com.kwad.components.ad.feed.a.l.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0363a
            public final void a(int i3, aa.a aVar) {
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
                    bVar.gL = aVar;
                    bVar.gJ = i4;
                    com.kwad.components.core.c.a.a.a(new a.C0352a(com.kwad.sdk.b.kwai.a.x(this.dZ.dp)).L(this.dZ.mAdTemplate).b(this.dZ.mApkDownloadHelper).ae(i5).aj(z).al(true).a(bVar).an(true).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.7.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass7 ec;

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
                            this.ec = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.ec.dZ.dx();
                            }
                        }
                    }));
                }
            }
        };
        this.mWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, aVar) == null) {
            this.dO = new ad();
            com.kwad.components.core.webview.jshandler.aa aaVar = new com.kwad.components.core.webview.jshandler.aa();
            this.dP = aaVar;
            aVar.a(aaVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
            aVar.a(new r(this.mJsBridgeContext, new r.b(this) { // from class: com.kwad.components.ad.feed.a.l.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.r.b
                public final void a(r.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        this.dZ.mAdWebView.setVisibility(0);
                        if (this.dZ.dM == 0.0d) {
                            this.dZ.dM = aVar2.height;
                            double d = aVar2.height / this.dZ.mWidth;
                            this.dZ.dL.setRatio((float) d);
                            l.dQ.put(Long.valueOf(this.dZ.mAdTemplate.posId), Double.valueOf(d));
                        }
                    }
                }
            }));
            aVar.a(new com.kwad.components.core.webview.b.kwai.c());
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a(this) { // from class: com.kwad.components.ad.feed.a.l.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, videoPosition) == null) && this.dZ.mAdInfo != null && com.kwad.sdk.core.response.a.a.aB(this.dZ.mAdInfo)) {
                        l lVar = this.dZ;
                        lVar.dX = (ViewGroup.MarginLayoutParams) lVar.dN.getLayoutParams();
                        int ceil = (int) Math.ceil(this.dZ.dM);
                        int i = this.dZ.mWidth;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        this.dZ.dX.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d = i;
                        this.dZ.dX.leftMargin = (int) (videoPosition.leftMarginRation * d);
                        this.dZ.dX.width = (int) (d * videoPosition.widthRation);
                        this.dZ.dX.height = (int) (this.dZ.dX.width * videoPosition.heightWidthRation);
                        this.dZ.dN.setRadius(videoPosition.borderRadius);
                        this.dZ.dN.setLayoutParams(this.dZ.dX);
                        l lVar2 = this.dZ;
                        lVar2.a(lVar2.cN);
                    }
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, new j.a(this) { // from class: com.kwad.components.ad.feed.a.l.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.j.a
                public final void bx() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.dZ.mHandler.post(new Runnable(this) { // from class: com.kwad.components.ad.feed.a.l.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass13 ed;

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
                                this.ed = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.ed.dZ.pX();
                                }
                            }
                        });
                    }
                }
            }));
            aVar.a(new o(this.mJsBridgeContext));
            com.kwad.components.core.webview.jshandler.k kVar = new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext);
            kVar.a(new k.b(this) { // from class: com.kwad.components.ad.feed.a.l.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.k.b
                public final void a(k.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        aVar2.height = 0;
                        aVar2.width = this.dZ.mWidth;
                        this.dZ.dT = true;
                    }
                }
            });
            aVar.a(kVar);
            aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.bi(this.mAdTemplate)));
            aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
            aVar.a(new s(this.mJsBridgeContext));
            aVar.a(this.dO);
            aVar.a(new w(getOpenNewPageListener()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, aVar) == null) || aVar == null) {
            return;
        }
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        boolean z = false;
        this.dq.setAutoRelease(false);
        AdVideoPlayerViewCache.getInstance().a(A, this.dp);
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        a.C0352a ae = new a.C0352a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(2);
        if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
            z = true;
        }
        com.kwad.components.core.c.a.a.a(ae.an(z).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.dZ.aq(100);
                }
            }
        }));
    }

    private void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)) {
                bq();
            } else {
                t("0");
            }
        }
    }

    public static boolean b(com.kwad.sdk.core.webview.a.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, aVar)) == null) ? aVar.DS ? aVar.Mv : aVar.Mx == 1 : invokeL.booleanValue;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            clearJsInterfaceRegister();
            this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
            this.mJsInterface = aVar;
            a(aVar);
            this.mAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
            this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bi(this.mAdTemplate));
        }
    }

    private boolean bs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) ? this.bH == 1 : invokeV.booleanValue;
    }

    private void bt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65584, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.bv;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.bv.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65586, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    public static float e(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, adTemplate)) == null) {
            int i = adTemplate.type;
            if (i == 1) {
                return 0.6013f;
            }
            return (i == 2 || i == 3) ? 0.283f : 0.968f;
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.sdk.core.response.model.AdTemplate */
    /* JADX WARN: Multi-variable type inference failed */
    private void f(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, this, adTemplate) == null) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mAdTemplate = adTemplate;
            Double d = dQ.get(Long.valueOf(adTemplate.posId));
            if (d != null) {
                this.dL.setRatio(d.floatValue());
            } else {
                if (com.kwad.sdk.core.response.a.b.bj(this.mAdTemplate) > 0.0f) {
                    ratioFrameLayout = this.dL;
                    e = com.kwad.sdk.core.response.a.b.bj(this.mAdTemplate);
                } else if (this.dL.getRatio() == 0.0f) {
                    ratioFrameLayout = this.dL;
                    e = e(this.mAdTemplate);
                }
                ratioFrameLayout.setRatio(e);
            }
            inflateJsBridgeContext();
        }
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.feed.a.l.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    int i = aVar.Mx;
                    if (aVar.DS) {
                        i = aVar.Mv ? 1 : 2;
                    }
                    boolean z = com.kwad.sdk.core.response.a.a.aB(this.dZ.mAdInfo) && (this.dZ.mAdTemplate.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || this.dZ.mAdTemplate.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                    u.b bVar = new u.b();
                    com.kwad.sdk.core.webview.a.a.c cVar = aVar.My;
                    if (cVar != null && !TextUtils.isEmpty(cVar.Mn)) {
                        bVar.Mn = aVar.My.Mn;
                    }
                    a.C0352a b = new a.C0352a(com.kwad.sdk.b.kwai.a.x(this.dZ)).L(this.dZ.mAdTemplate).b(this.dZ.mApkDownloadHelper);
                    l lVar = this.dZ;
                    com.kwad.components.core.c.a.a.a(b.aj(l.b(aVar)).ae(i).ao(aVar.DS).an(z).a(bVar).al(true).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.l.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 ea;

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
                            this.ea = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.ea.dZ.lp == null) {
                                return;
                            }
                            this.ea.dZ.lp.onAdClicked();
                        }
                    }));
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    private w.a getOpenNewPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) ? new w.a(this) { // from class: com.kwad.components.ad.feed.a.l.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.dZ.mContext, new AdWebViewActivityProxy.a.C0359a().ao(bVar.title).ap(bVar.url).N(this.dZ.mAdTemplate).nx());
                }
            }
        } : (w.a) invokeV.objValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.feed.a.l.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l dZ;

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
                this.dZ = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.dZ.t("1");
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.dZ.dT = false;
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65597, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.fY()) {
                    return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
                }
                if (!this.dt) {
                    this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
                }
                return this.dt;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private a.b i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65598, this, z)) == null) ? new a.b(this, z) { // from class: com.kwad.components.ad.feed.a.l.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean bw;
            public final /* synthetic */ l dZ;
            public final /* synthetic */ boolean eb;

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
                this.dZ = this;
                this.eb = z;
                this.bw = false;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.report.a.ax(this.dZ.mAdTemplate);
                    if (this.eb) {
                        this.dZ.dO.at(9);
                    }
                    if (this.dZ.dN != null) {
                        this.dZ.dN.setVisibility(8);
                    }
                    if (com.kwad.components.ad.feed.kwai.b.bc() && this.dZ.dr == null) {
                        this.dZ.dr = new d(this.dZ.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        l lVar = this.dZ;
                        lVar.addView(lVar.dr, layoutParams);
                        this.dZ.dr.bn();
                    }
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                    this.dZ.c(j);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.sdk.core.report.a.aw(this.dZ.mAdTemplate);
                    if (this.eb) {
                        this.dZ.dO.at(3);
                    }
                    if (this.dZ.dr == null || !(this.dZ.dr.getParent() instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) this.dZ.dr.getParent()).removeView(this.dZ.dr);
                    this.dZ.dr.bo();
                    this.dZ.dr = null;
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if (!this.bw) {
                        this.bw = true;
                        com.kwad.components.core.j.a.og().a(this.dZ.mAdTemplate, System.currentTimeMillis(), 1);
                    }
                    com.kwad.sdk.core.video.videoview.a aVar = this.dZ.dp;
                    l lVar = this.dZ;
                    aVar.setVideoSoundEnable(lVar.h(lVar.ds));
                }
            }
        } : (a.b) invokeZ.objValue;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            bVar2.agd = null;
            bVar2.Gl = this.dL;
            bVar2.Fv = this.mAdWebView;
            bVar2.mReportExtData = null;
            bVar2.agf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, this, str) == null) {
            com.kwad.sdk.core.e.b.d("FeedWebView", "handleWebViewError " + str);
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.dR) {
                return;
            }
            a aVar = this.dW;
            if (aVar != null) {
                aVar.aZ();
            }
            this.dW = null;
            this.dR = true;
            com.kwad.components.core.j.a og = com.kwad.components.core.j.a.og();
            AdTemplate adTemplate = this.mAdTemplate;
            og.c(adTemplate, com.kwad.sdk.core.response.a.b.bi(adTemplate), str);
            if (this.dV == null) {
                this.dU = true;
                com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.c.a(getContext(), FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aD(this.mAdInfo));
                this.dV = a2;
                if (a2 != null) {
                    this.dV.setMargin(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
                    this.dL.removeAllViews();
                    this.dL.setRatio(0.0f);
                    this.mAdWebView.setVisibility(8);
                    this.dN.setVisibility(8);
                    this.dV.setInnerAdInteractionListener(this.dY);
                }
                this.dL.addView(this.dV);
                this.dV.c((com.kwad.components.core.widget.b) this.mAdTemplate);
                com.kwad.components.core.widget.b bVar = this.dV;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.cN);
                }
            }
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.ds = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
            String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                imageView = this.f5do;
                i = 8;
            } else {
                this.f5do.setImageDrawable(null);
                KSImageLoader.loadImage(this.f5do, url, this.mAdTemplate);
                imageView = this.f5do;
                i = 0;
            }
            imageView.setVisibility(i);
            this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
            com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            this.dp = aVar;
            aVar.setTag(this.bv);
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            if (TextUtils.isEmpty(A)) {
                return;
            }
            this.dp.a(new b.a(this.mAdTemplate).bk(A).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), (Map<String, String>) null);
            this.dp.setVideoSoundEnable(this.ds);
            com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
            this.dq = cVar;
            cVar.setVideoPlayCallback(i(true));
            this.dq.setAdClickListener(this.du);
            this.dp.setController(this.dq);
            if (this.dN.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.dN;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.dN.setTag(null);
            }
            this.dN.addView(this.dp);
            this.dN.setTag(this.dp);
            this.dN.setClickable(true);
            this.dN.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.feed.a.l.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (!this.dZ.dp.isIdle()) {
                            l lVar = this.dZ;
                            lVar.a(lVar.dp);
                            return;
                        }
                        com.kwad.sdk.utils.k.ci(this.dZ.mAdTemplate);
                        this.dZ.dp.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.dZ.mAdTemplate));
                        this.dZ.dp.start();
                    }
                }
            });
            if (this.ds) {
                com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
            }
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            a aVar2 = this.dW;
            if (aVar2 != null) {
                aVar2.aZ();
                this.dW = null;
            }
            this.dW = aVar;
            adTemplate.realShowType = 2;
            super.c((l) adTemplate);
            if (this.bH != 1) {
                f(this.mAdTemplate);
            }
            String str = this.dS;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (bs()) {
                    this.mAdWebView.reload();
                } else {
                    aE();
                }
            }
            this.dS = adTemplate.mOriginJString;
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.feed.a.l.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l dZ;

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
                    this.dZ = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.dZ.mAdWebView.stopLoading();
                        this.dZ.mAdWebView.setVisibility(8);
                        this.dZ.t("0");
                    }
                }
            }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.am();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.an();
            com.kwad.sdk.utils.k.ch(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09121e);
            this.mAdWebView = ksAdWebView;
            ksAdWebView.setVisibility(4);
            this.dL = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091068);
            this.dN = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911f5);
            this.f5do = (ImageView) findViewById(R.id.obfuscated_res_0x7f091205);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void br() {
        com.kwad.components.core.webview.jshandler.aa aaVar;
        b.InterfaceC0376b interfaceC0376b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.mAdTemplate.mPvReported && (interfaceC0376b = this.lp) != null) {
                interfaceC0376b.onAdShow();
            }
            if (this.dU || (aaVar = this.dP) == null) {
                return;
            }
            aaVar.pz();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adTemplate) == null) {
            adTemplate.realShowType = 2;
            super.c((l) adTemplate);
            if (this.dR) {
                com.kwad.components.core.widget.b bVar = this.dV;
                if (bVar != null) {
                    bVar.c((com.kwad.components.core.widget.b) this.mAdTemplate);
                    com.kwad.components.core.widget.b bVar2 = this.dV;
                    if (bVar2 instanceof c) {
                        ((c) bVar2).a(this.cN);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.bH != 1) {
                f(this.mAdTemplate);
            }
            String str = this.dS;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (bs()) {
                    this.mAdWebView.reload();
                } else {
                    aE();
                }
            }
            this.dS = adTemplate.mOriginJString;
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d0427 : invokeV.intValue;
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
            bt();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (aVar = this.dp) == null || (viewGroup = (ViewGroup) aVar.getParent()) == this.dN) {
                return;
            }
            viewGroup.removeView(this.dp);
            if (this.dN.getTag() != null) {
                KSFrameLayout kSFrameLayout = this.dN;
                kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                this.dN.setTag(null);
            }
            this.dN.addView(this.dp);
            this.dN.setTag(this.dp);
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            this.dp.setVideoSoundEnable(this.ds);
            this.dq.setVideoPlayCallback(i(false));
            this.dq.setAdClickListener(this.du);
            this.dq.getAdTemplate().mAdWebVideoPageShowing = false;
            this.dq.pe();
            this.dq.setAutoRelease(true);
            AdVideoPlayerViewCache.getInstance().remove(A);
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
            this.cN = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0 && this.dp != null) {
                    boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                    this.ds = isVideoSoundEnable;
                    this.dp.setVideoSoundEnable(h(isVideoSoundEnable));
                    if (this.ds) {
                        com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
                    }
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (cVar = this.dq) == null) {
                    return;
                }
                cVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    public final void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mWidth = i;
        }
    }
}
