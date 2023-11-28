package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    public List<Integer> cB;
    public volatile boolean cC;
    public com.kwad.sdk.widget.j cD;
    public ImageView dE;
    public TextView dF;
    public TextView dM;
    public KsAdVideoPlayConfig dU;
    public TextView eB;
    public ImageView eD;
    public TextView eF;
    public TextView eG;
    public View eH;
    public DownloadProgressView eI;
    public KSRelativeLayout eL;
    public ImageView eM;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.core.video.e eO;
    public d eP;
    public boolean eQ;
    public TextView eR;
    public final a.InterfaceC0662a eS;
    public IAdLiveOfflineView eT;
    public com.kwad.components.core.n.a.a.a eU;
    public IAdLivePlayModule eV;
    public boolean eW;
    public View eX;
    public a.b eY;
    public final AdLivePlayStateListener eZ;
    public OfflineOnAudioConflictListener fa;
    public a.b fb;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mIsAudioEnable;
    public KsLogoView mLogoView;

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.cC = false;
        this.cD = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.b.c.1
            @Override // com.kwad.sdk.widget.j
            public final void ao() {
                com.kwad.sdk.utils.l.ek(c.this.mAdTemplate);
            }
        };
        this.eS = new a.InterfaceC0662a() { // from class: com.kwad.components.ad.feed.b.c.3
            @Override // com.kwad.components.core.video.a.InterfaceC0662a
            public final void a(int i, ac.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            i2 = 35;
                        } else {
                            i2 = 39;
                            i3 = 1;
                            z = true;
                        }
                    } else {
                        i2 = 16;
                    }
                } else {
                    i2 = 15;
                }
                y.b bVar = new y.b();
                bVar.km = aVar;
                bVar.kk = i2;
                c.this.ba();
                com.kwad.components.core.e.d.a.a(new a.C0644a(c.this.getContext()).aq(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).an(i3).ao(z).aq(true).al(5).am(i2).as(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.sZ();
                    }
                }));
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.c.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                c.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.eR.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.ow().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.ow().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.c.8
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.eN != null) {
                    c.this.eN.setVideoSoundEnable(false);
                }
                if (c.this.eV != null) {
                    c.this.eV.setAudioEnabled(false, false);
                }
            }
        };
        this.fb = new a.b() { // from class: com.kwad.components.ad.feed.b.c.10
            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                c.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                if (com.kwad.components.ad.feed.a.b.aW() && c.this.eP == null) {
                    c.this.eP = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.eP, layoutParams);
                    c.this.eP.bn();
                }
                com.kwad.sdk.core.report.a.bO(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                AdTemplate adTemplate = c.this.mAdTemplate;
                String K = com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo);
                com.kwad.components.ad.feed.monitor.b.a(adTemplate, 2, 1, K, i + " " + i2, SystemClock.elapsedRealtime() - c.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.ow().a(c.this.getCurrentVoiceItem());
                if (c.this.eP != null && (c.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.eP.getParent()).removeView(c.this.eP);
                    c.this.eP.bo();
                    c.this.eP = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ey);
                com.kwad.sdk.core.report.a.bN(c.this.mAdTemplate);
            }
        };
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.eQ = false;
        return false;
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, final int i) {
        int i2;
        long playDuration;
        if (aVar != null || this.eW) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.eW) {
                this.eO.setAutoRelease(false);
            }
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (!this.eW) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
            ba();
            a.C0644a ao = new a.C0644a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule == null) {
                playDuration = 0;
            } else {
                playDuration = iAdLivePlayModule.getPlayDuration();
            }
            com.kwad.components.core.e.d.a.a(ao.v(playDuration).an(i2).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.aH(i);
                }
            }));
        }
    }

    private void bd() {
        findViewById(R.id.obfuscated_res_0x7f0912ed).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f0912e4).setVisibility(8);
        this.eG = (TextView) findViewById(R.id.obfuscated_res_0x7f09136f);
        this.dM = (TextView) findViewById(R.id.obfuscated_res_0x7f091371);
        this.eH = findViewById(R.id.obfuscated_res_0x7f091372);
        this.eG.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.eH.setOnClickListener(this);
        this.eG.setOnClickListener(this);
        this.dM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.dM, this);
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.eW) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eT.getView().getParent();
        if (viewGroup != this.eL) {
            viewGroup.removeView(this.eT.getView());
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eT.getView());
            this.eL.setTag(this.eT.getView());
            this.eV.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(this.eT, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)));
            this.eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        }
        this.eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bi() {
        bj();
        IAdLiveOfflineView view2 = this.eU.getView(this.mContext, 3);
        this.eT = view2;
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(view2, ServiceProvider.Jo().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        final View view3 = this.eT.getView();
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(view3);
        this.eL.setTag(view3);
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.b.c.4
            @Override // java.lang.Runnable
            public final void run() {
                c.this.c(view3);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void be() {
        findViewById(R.id.obfuscated_res_0x7f0912e4).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f0912ed).setVisibility(8);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091306);
        this.dF = (TextView) findViewById(R.id.obfuscated_res_0x7f09130a);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091302);
        this.eF = textView;
        com.kwad.sdk.d.a.a.a(this, this.dE, this.dF, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.dE.setImageResource(R.drawable.obfuscated_res_0x7f080e6a);
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 8);
        this.eF.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        bb();
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bg() {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.oA() && com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
            this.eW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.c.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (c.this.eW) {
                        if (c.this.eV == null) {
                            c cVar = c.this;
                            cVar.eV = cVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                        c cVar2 = c.this;
                        iAdLivePlayModule.setAudioEnabled(cVar2.g(cVar2.mIsAudioEnable), false);
                    } else if (c.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                        c cVar3 = c.this;
                        aVar.setVideoSoundEnable(cVar3.g(cVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.video.e eVar = this.eO;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.fb);
        }
        com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
        if (!this.eW) {
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.eV = bi();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.ow().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.utils.l.ei(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
        com.kwad.components.core.j.a.ow().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(this.mContext).b(this.fa);
        }
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.c.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            return;
        }
        this.eM.setImageResource(R.drawable.obfuscated_res_0x7f080e61);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            Iterator<Integer> it = this.cB.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gq()) {
            if (!com.kwad.components.core.s.a.ah(this.mContext).qK()) {
                return com.kwad.components.core.s.a.ah(this.mContext).aM(false);
            }
            if (com.kwad.components.core.s.a.ah(this.mContext).qJ()) {
                return false;
            }
            return true;
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.ah(this.mContext).aM(true);
        }
        return this.eQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final View view2) {
        view2.post(new Runnable() { // from class: com.kwad.components.ad.feed.b.c.6
            @Override // java.lang.Runnable
            public final void run() {
                int width = c.this.eL.getWidth();
                int height = c.this.eL.getHeight();
                if (width != 0 && height != 0) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                    layoutParams.addRule(13, -1);
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        onClick(view2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        boolean z;
        if (com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (view2 == this.eI) {
                z = true;
            } else {
                z = false;
            }
            a(aVar, z, 153);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String ef;
        this.dU = ksAdVideoPlayConfig;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.mIsAudioEnable = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
        }
        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
        this.cB = com.kwad.sdk.core.response.b.a.bm(this.mAdInfo);
        if (this.eW) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eN = aVar;
        aVar.setVisibleListener(this.cD);
        this.eN.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eN, this);
        this.eN.setTag(this.cB);
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
                this.eN.a(new b.a(this.mAdTemplate).cD(K).cE(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate)).Ah(), null);
                this.eN.setVideoSoundEnable(g(this.mIsAudioEnable));
                com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
                this.eO = eVar;
                eVar.setAdClickListener(this.eS);
                this.ey = SystemClock.elapsedRealtime();
                this.eO.setVideoPlayCallback(this.fb);
                this.eN.setController(this.eO);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                this.eL.setClickable(true);
                this.eL.setOnClickListener(this);
                new com.kwad.sdk.widget.f(getContext(), this.eL, this);
                if (this.mIsAudioEnable) {
                    com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
                }
            }
        } else {
            if (yE != 0) {
                com.kwad.sdk.core.videocache.f bl = com.kwad.sdk.core.videocache.c.a.bl(this.mContext);
                if (com.kwad.sdk.core.config.d.Ap()) {
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

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((c) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.mLogoView.aD(this.mAdTemplate);
        bg();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            be();
        } else {
            bd();
        }
        this.eB.setOnClickListener(this);
        this.eL.setOnClickListener(this);
        this.eD.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eL, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.obfuscated_res_0x7f0912df);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0914e7);
        this.eL = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.eD = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e2);
        this.eM = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f7);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912e3);
        this.eI = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091304);
        this.eR = (TextView) findViewById(R.id.obfuscated_res_0x7f0913bf);
        this.eX = findViewById(R.id.obfuscated_res_0x7f0913b2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:
        if (r5 == r4.eN) goto L24;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view2) {
        com.kwad.sdk.core.video.videoview.a aVar;
        if (view2 == this.eD) {
            ta();
        } else if (view2 == this.eL && (aVar = this.eN) != null && aVar.isIdle()) {
            com.kwad.sdk.utils.l.ej(this.mAdTemplate);
            this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate));
            this.eN.start();
        } else {
            int i = 35;
            boolean z = true;
            if (view2 == this.eB) {
                i = 25;
            } else {
                if (view2 != this.eL) {
                    if (view2 != this.eI && view2 != this.dM && view2 != this.eH) {
                        if (view2 == this.dE) {
                            i = 13;
                        } else if (view2 == this.dF) {
                            i = 14;
                        } else if (view2 == this.eF || view2 == this.eG) {
                            i = 101;
                        }
                    } else {
                        i = 1;
                    }
                }
                i = 100;
            }
            com.kwad.sdk.core.video.videoview.a aVar2 = this.eN;
            if (view2 != this.eI) {
                z = false;
            }
            a(aVar2, z, i);
        }
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
                iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
            } else {
                com.kwad.sdk.core.video.videoview.a aVar = this.eN;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 && (eVar = this.eO) != null) {
                eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && this.eO != null) {
                ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                if (this.eN.getParent() != this.eL) {
                    viewGroup.removeView(this.eN);
                    if (this.eL.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.eL;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.eL.setTag(null);
                    }
                    this.eL.addView(this.eN);
                    this.eL.setTag(this.eN);
                    com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
                    this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                    this.eO.setAdClickListener(this.eS);
                    this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.eO.rz();
                    this.eO.setAutoRelease(true);
                }
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null) {
            this.eV.onPause();
        }
    }
}
