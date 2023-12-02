package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f extends b implements com.kwad.sdk.widget.c {
    public List<Integer> cB;
    @NonNull
    public KsAdVideoPlayConfig dU;
    public ImageView eM;
    public com.kwad.sdk.core.video.videoview.a eN;
    public c jK;
    public KSFrameLayout kJ;
    public KSFrameLayout kK;
    public com.kwad.components.core.video.f kL;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    @NonNull
    public Context mContext;
    @Nullable
    public boolean mIsAudioEnable = false;
    public final a.InterfaceC0662a eS = new a.InterfaceC0662a() { // from class: com.kwad.components.ad.interstitial.e.f.3
        /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
        @Override // com.kwad.components.core.video.a.InterfaceC0662a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(int i, ac.a aVar) {
            final int i2;
            int i3;
            int i4 = 2;
            boolean z = false;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        i2 = 108;
                    } else {
                        i2 = 83;
                        z = true;
                        i3 = 1;
                        y.b bVar = new y.b();
                        bVar.km = aVar;
                        bVar.kk = i2;
                        f.this.getContext();
                        if (!ai.Kx()) {
                            i4 = 1;
                        }
                        bVar.axt = i4;
                        com.kwad.components.ad.interstitial.report.a.dM().a(f.this.mAdTemplate, 1L, i2);
                        com.kwad.components.core.e.d.a.a(new a.C0644a(f.this.getContext()).aq(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).an(i3).ao(z).aq(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.f.3.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                f.this.h(i2);
                            }
                        }));
                    }
                } else {
                    i2 = 82;
                }
            } else {
                i2 = 13;
            }
            i3 = 2;
            y.b bVar2 = new y.b();
            bVar2.km = aVar;
            bVar2.kk = i2;
            f.this.getContext();
            if (!ai.Kx()) {
            }
            bVar2.axt = i4;
            com.kwad.components.ad.interstitial.report.a.dM().a(f.this.mAdTemplate, 1L, i2);
            com.kwad.components.core.e.d.a.a(new a.C0644a(f.this.getContext()).aq(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).an(i3).ao(z).aq(true).a(bVar2).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.f.3.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    f.this.h(i2);
                }
            }));
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jK.jT = null;
    }

    private c.b a(View view2, boolean z) {
        return new c.b(view2.getContext()).k(z).a(this.kJ.getTouchCoords()).z(3).A(85);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j) {
        c cVar = this.jK;
        cVar.jM = true;
        cVar.b(1L, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            Iterator<Integer> it = this.cB.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dv() {
        String ef;
        this.mIsAudioEnable = this.dU.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        int yE = com.kwad.sdk.core.config.d.yE();
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        if (yE < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(K);
            if (bO != null && bO.exists()) {
                ef = bO.getAbsolutePath();
                K = ef;
                if (TextUtils.isEmpty(K)) {
                }
            } else {
                K = null;
                if (TextUtils.isEmpty(K)) {
                    return;
                }
                this.eN.a(new b.a(this.mAdTemplate).cD(K).cE(h.b(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ah(), null);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                final long currentTimeMillis = System.currentTimeMillis();
                com.kwad.components.ad.interstitial.report.d.dS().v(this.mAdTemplate);
                this.kL.setVideoPlayCallback(new f.a() { // from class: com.kwad.components.ad.interstitial.e.f.1
                    public boolean cC = false;

                    @Override // com.kwad.components.core.video.f.a
                    public final void onVideoPlayError(int i, int i2) {
                        com.kwad.components.ad.interstitial.report.d.dS().b(f.this.mAdTemplate, i, String.valueOf(i2));
                        if (f.this.jK.ie != null) {
                            f.this.jK.ie.onVideoPlayError(i, i2);
                        }
                    }

                    @Override // com.kwad.components.core.video.a.c
                    public final void bl() {
                        if (!this.cC) {
                            this.cC = true;
                            com.kwad.components.core.o.a.pX().b(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                        }
                        for (a.c cVar : f.this.jK.jV) {
                            cVar.bl();
                        }
                    }

                    @Override // com.kwad.components.core.video.a.c
                    public final void bm() {
                        com.kwad.sdk.core.report.a.bO(f.this.mAdTemplate);
                        if (!f.this.jK.jO && f.this.jK.ie != null) {
                            f.this.jK.ie.onVideoPlayEnd();
                        }
                        for (a.c cVar : f.this.jK.jV) {
                            cVar.bm();
                        }
                        f.this.jK.jX = true;
                    }

                    @Override // com.kwad.components.core.video.a.c
                    public final void e(long j) {
                        f.this.c(j);
                        for (a.c cVar : f.this.jK.jV) {
                            cVar.e(j);
                        }
                    }

                    @Override // com.kwad.components.core.video.a.c
                    public final void onVideoPlayStart() {
                        com.kwad.sdk.core.report.a.bN(f.this.mAdTemplate);
                        com.kwad.components.ad.interstitial.report.d.dS().a(f.this.mAdTemplate, System.currentTimeMillis() - currentTimeMillis);
                        com.kwad.components.ad.interstitial.report.b.dO().o(f.this.mAdTemplate);
                        if (!f.this.jK.jO && f.this.jK.ie != null) {
                            f.this.jK.ie.onVideoPlayStart();
                        }
                        for (a.c cVar : f.this.jK.jV) {
                            cVar.onVideoPlayStart();
                        }
                        f.this.jK.jX = false;
                    }
                });
                this.eN.setController(this.kL);
                this.kK.setClickable(true);
                new com.kwad.sdk.widget.f(this.kK.getContext(), this.kK, this);
                this.kK.addView(this.eN);
                this.jK.jT = new c.d() { // from class: com.kwad.components.ad.interstitial.e.f.2
                    @Override // com.kwad.components.ad.interstitial.e.c.d
                    public final void da() {
                        if (f.this.eN != null) {
                            f.this.eN.restart();
                        }
                    }
                };
            }
        } else {
            if (yE != 0) {
                com.kwad.sdk.core.videocache.f bl = com.kwad.sdk.core.videocache.c.a.bl(this.mContext);
                if (com.kwad.sdk.core.config.d.Ar()) {
                    int yE2 = com.kwad.sdk.core.config.d.yE();
                    if (!bl.eh(K)) {
                        if (bl.a(K, yE2 * 1024, new a.C0709a(), null)) {
                            ef = bl.ef(K);
                        }
                    } else {
                        ef = bl.ef(K);
                    }
                    K = ef;
                } else {
                    K = bl.ef(K);
                }
            }
            if (TextUtils.isEmpty(K)) {
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        this.jK.a(a(view2, true));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        this.jK.a(a(view2, false));
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) HU();
        this.jK = cVar;
        this.dU = cVar.dU;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.mAdInfo = dP;
        List<Integer> bm = com.kwad.sdk.core.response.b.a.bm(dP);
        this.cB = bm;
        com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
        this.eN = aVar;
        aVar.setTag(bm);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.eN);
        this.kL = fVar;
        fVar.setDataFlowAutoStart(this.dU.isDataFlowAutoStart());
        this.kL.setAdClickListener(this.eS);
        this.kL.re();
        this.mApkDownloadHelper = this.jK.mApkDownloadHelper;
        dv();
        float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704d0);
        this.kK.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kJ = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f09133c);
        this.kK = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f0914e8);
        this.eM = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f0914f8);
        this.kK.setVisibility(4);
        this.mContext = getContext();
    }
}
