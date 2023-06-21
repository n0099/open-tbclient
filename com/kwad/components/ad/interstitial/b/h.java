package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public final class h extends b implements com.kwad.sdk.widget.c {
    public List<Integer> bv;
    @NonNull
    public KsAdVideoPlayConfig cN;
    public KSFrameLayout dN;

    /* renamed from: do  reason: not valid java name */
    public ImageView f7do;
    public com.kwad.sdk.core.video.videoview.a dp;
    @Nullable
    public boolean ds = false;
    public final a.InterfaceC0642a du = new a.InterfaceC0642a() { // from class: com.kwad.components.ad.interstitial.b.h.3
        /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
        @Override // com.kwad.components.core.video.a.InterfaceC0642a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(int i, aa.a aVar) {
            int i2;
            int i3;
            boolean z = false;
            if (i == 1) {
                i2 = 13;
            } else if (i == 2) {
                i2 = 82;
            } else if (i == 3) {
                i2 = 83;
                z = true;
                i3 = 1;
                u.b bVar = new u.b();
                bVar.gL = aVar;
                bVar.gJ = i2;
                bVar.abH = ag.cB(h.this.getContext()) ? 2 : 1;
                com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(h.this.dp)).L(h.this.mAdTemplate).b(h.this.mApkDownloadHelper).ae(i3).aj(z).al(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.interstitial.b.h.3.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        h.this.dx();
                    }
                }));
            } else {
                i2 = 108;
            }
            i3 = 2;
            u.b bVar2 = new u.b();
            bVar2.gL = aVar;
            bVar2.gJ = i2;
            bVar2.abH = ag.cB(h.this.getContext()) ? 2 : 1;
            com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(h.this.dp)).L(h.this.mAdTemplate).b(h.this.mApkDownloadHelper).ae(i3).aj(z).al(true).a(bVar2).a(new a.b() { // from class: com.kwad.components.ad.interstitial.b.h.3.1
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    h.this.dx();
                }
            }));
        }
    };
    public KSFrameLayout gS;
    public c gh;
    public com.kwad.components.core.video.d hz;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    @NonNull
    public Context mContext;

    private c.b a(View view2, boolean z) {
        return new c.b(view2.getContext()).l(z).a(this.gS.getTouchCoords()).y(3).z(85);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
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

    private void dw() {
        ImageView imageView;
        int i;
        String A;
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
        this.hz.setVideoPlayCallback(new d.a() { // from class: com.kwad.components.ad.interstitial.b.h.1
            public boolean bw = false;

            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                com.kwad.sdk.core.report.a.ax(h.this.mAdTemplate);
                if (!h.this.gh.gn && h.this.gh.fo != null) {
                    h.this.gh.fo.onVideoPlayEnd();
                }
                for (a.b bVar : h.this.gh.gu) {
                    bVar.bm();
                }
                h.this.gh.gw = true;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                h.this.c(j);
                for (a.b bVar : h.this.gh.gu) {
                    bVar.d(j);
                }
            }

            @Override // com.kwad.components.core.video.d.a
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.interstitial.monitor.b.cr().a(h.this.mAdTemplate, i2, String.valueOf(i3));
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.aw(h.this.mAdTemplate);
                if (!h.this.gh.gn && h.this.gh.fo != null) {
                    h.this.gh.fo.onVideoPlayStart();
                }
                for (a.b bVar : h.this.gh.gu) {
                    bVar.onVideoPlayStart();
                }
                h.this.gh.gw = false;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                if (!this.bw) {
                    this.bw = true;
                    com.kwad.components.core.j.a.og().a(h.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                for (a.b bVar : h.this.gh.gu) {
                    bVar.onVideoPlaying();
                }
            }
        });
        this.dp.setController(this.hz);
        this.dN.setClickable(true);
        new com.kwad.sdk.widget.f(this.dN.getContext(), this.dN, this);
        this.dN.addView(this.dp);
        this.gh.gr = new c.d() { // from class: com.kwad.components.ad.interstitial.b.h.2
            @Override // com.kwad.components.ad.interstitial.b.c.d
            public final void cI() {
                if (h.this.dp != null) {
                    h.this.dp.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
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

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
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
        float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704bb);
        this.dN.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        this.gh.a(a(view2, true));
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        this.gh.a(a(view2, false));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gS = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f09125c);
        this.dN = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f0913e6);
        this.f7do = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f0913f6);
        this.dN.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.gh.gr = null;
    }
}
