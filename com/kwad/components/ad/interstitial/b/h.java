package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h extends b implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> bv;
    @NonNull
    public KsAdVideoPlayConfig cN;
    public KSFrameLayout dN;

    /* renamed from: do  reason: not valid java name */
    public ImageView f7do;
    public com.kwad.sdk.core.video.videoview.a dp;
    @Nullable
    public boolean ds;
    public final a.InterfaceC0365a du;
    public KSFrameLayout gS;
    public c gh;
    public com.kwad.components.core.video.d hz;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    @NonNull
    public Context mContext;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ds = false;
        this.du = new a.InterfaceC0365a(this) { // from class: com.kwad.components.ad.interstitial.b.h.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h hA;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.hA = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
            @Override // com.kwad.components.core.video.a.InterfaceC0365a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(int i3, aa.a aVar) {
                int i4;
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, aVar) == null) {
                    boolean z = false;
                    if (i3 == 1) {
                        i4 = 13;
                    } else if (i3 == 2) {
                        i4 = 82;
                    } else if (i3 == 3) {
                        i4 = 83;
                        z = true;
                        i5 = 1;
                        u.b bVar = new u.b();
                        bVar.gL = aVar;
                        bVar.gJ = i4;
                        bVar.abH = ag.cB(this.hA.getContext()) ? 2 : 1;
                        com.kwad.components.core.c.a.a.a(new a.C0354a(com.kwad.sdk.b.kwai.a.x(this.hA.dp)).L(this.hA.mAdTemplate).b(this.hA.mApkDownloadHelper).ae(i5).aj(z).al(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.b.h.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 hB;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i6 = newInitContext2.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.hB = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.hB.hA.dx();
                                }
                            }
                        }));
                    } else {
                        i4 = 108;
                    }
                    i5 = 2;
                    u.b bVar2 = new u.b();
                    bVar2.gL = aVar;
                    bVar2.gJ = i4;
                    bVar2.abH = ag.cB(this.hA.getContext()) ? 2 : 1;
                    com.kwad.components.core.c.a.a.a(new a.C0354a(com.kwad.sdk.b.kwai.a.x(this.hA.dp)).L(this.hA.mAdTemplate).b(this.hA.mApkDownloadHelper).ae(i5).aj(z).al(true).a(bVar2).a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.b.h.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass3 hB;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.hB = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.hB.hA.dx();
                            }
                        }
                    }));
                }
            }
        };
    }

    private c.b a(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, view2, z)) == null) ? new c.b(view2.getContext()).l(z).a(this.gS.getTouchCoords()).y(3).z(85) : (c.b) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, this, j) == null) {
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

    private void dw() {
        ImageView imageView;
        int i;
        String A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.ds = this.cN.isVideoSoundEnable();
            String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                imageView = this.f7do;
                i = 8;
            } else {
                this.f7do.setImageDrawable(null);
                KSImageLoader.loadImage(this.f7do, url, this.mAdTemplate);
                imageView = this.f7do;
                i = 0;
            }
            imageView.setVisibility(i);
            int sc = com.kwad.sdk.core.config.d.sc();
            if (sc < 0) {
                File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.A(this.mAdInfo));
                A = (ad == null || !ad.exists()) ? null : ad.getAbsolutePath();
            } else {
                A = sc == 0 ? com.kwad.sdk.core.response.a.a.A(this.mAdInfo) : com.kwad.sdk.core.videocache.b.a.bC(this.mContext).cA(com.kwad.sdk.core.response.a.a.A(this.mAdInfo));
            }
            if (TextUtils.isEmpty(A)) {
                return;
            }
            this.dp.a(new b.a(this.mAdTemplate).bk(A).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), (Map<String, String>) null);
            this.dp.setVideoSoundEnable(this.ds);
            this.hz.setVideoPlayCallback(new d.a(this) { // from class: com.kwad.components.ad.interstitial.b.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean bw;
                public final /* synthetic */ h hA;

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
                    this.hA = this;
                    this.bw = false;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void bm() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.ax(this.hA.mAdTemplate);
                        if (!this.hA.gh.gn && this.hA.gh.fo != null) {
                            this.hA.gh.fo.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.hA.gh.gu) {
                            bVar.bm();
                        }
                        this.hA.gh.gw = true;
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void d(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.hA.c(j);
                        for (a.b bVar : this.hA.gh.gu) {
                            bVar.d(j);
                        }
                    }
                }

                @Override // com.kwad.components.core.video.d.a
                public final void onVideoPlayError(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                        com.kwad.components.ad.interstitial.monitor.b.cr().a(this.hA.mAdTemplate, i2, String.valueOf(i3));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.aw(this.hA.mAdTemplate);
                        if (!this.hA.gh.gn && this.hA.gh.fo != null) {
                            this.hA.gh.fo.onVideoPlayStart();
                        }
                        for (a.b bVar : this.hA.gh.gu) {
                            bVar.onVideoPlayStart();
                        }
                        this.hA.gh.gw = false;
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        if (!this.bw) {
                            this.bw = true;
                            com.kwad.components.core.j.a.og().a(this.hA.mAdTemplate, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.hA.gh.gu) {
                            bVar.onVideoPlaying();
                        }
                    }
                }
            });
            this.dp.setController(this.hz);
            this.dN.setClickable(true);
            new com.kwad.sdk.widget.f(this.dN.getContext(), this.dN, this);
            this.dN.addView(this.dp);
            this.gh.gr = new c.d(this) { // from class: com.kwad.components.ad.interstitial.b.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h hA;

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
                    this.hA = this;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.d
                public final void cI() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.hA.dp == null) {
                        return;
                    }
                    this.hA.dp.restart();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            c cVar = this.gh;
            if (!cVar.gn && (adInteractionListener = cVar.fo) != null) {
                adInteractionListener.onAdClicked();
            }
            c cVar2 = this.gh;
            cVar2.gl = true;
            if (cVar2.gn) {
                return;
            }
            cVar2.cy();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            c cVar = (c) xR();
            this.gh = cVar;
            this.cN = cVar.cN;
            AdTemplate adTemplate = cVar.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mAdInfo = bQ;
            List<Integer> aF = com.kwad.sdk.core.response.a.a.aF(bQ);
            this.bv = aF;
            com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
            this.dp = aVar;
            aVar.setTag(aF);
            com.kwad.components.core.video.d dVar = new com.kwad.components.core.video.d(this.mContext, this.mAdTemplate, this.dp);
            this.hz = dVar;
            dVar.setDataFlowAutoStart(this.cN.isDataFlowAutoStart());
            this.hz.setAdClickListener(this.du);
            this.hz.oS();
            this.mApkDownloadHelper = this.gh.mApkDownloadHelper;
            dw();
            float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070372);
            this.dN.setRadius(dimension, dimension, 0.0f, 0.0f);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.gh.a(a(view2, true));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.gh.a(a(view2, false));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.gS = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f091068);
            this.dN = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f0911f5);
            this.f7do = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f091205);
            this.dN.setVisibility(4);
            this.mContext = getContext();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            this.gh.gr = null;
        }
    }
}
