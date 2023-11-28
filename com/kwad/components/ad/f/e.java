package com.kwad.components.ad.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.f.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.h.c {
    public com.kwad.components.core.widget.a.b bQ;
    public List<Integer> cB;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public int cP;
    public aq.b cU;
    public KSRelativeLayout eL;
    public boolean eQ;
    public IAdLiveOfflineView eT;
    public com.kwad.components.core.n.a.a.a eU;
    public IAdLivePlayModule eV;
    public a.b eY;
    public final AdLivePlayStateListener eZ;
    public ba fC;
    public aw fD;
    public WebCardRegisterLiveMessageListener fE;
    public WebCardRegisterLiveShopListener fF;
    public ax.b fJ;
    public ax.a fK;
    public OfflineOnAudioConflictListener fa;
    public IAdLiveEndRequest ga;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public Context mContext;
    public ImageView mF;
    public RelativeLayout mG;
    public AdBasePvFrameLayout mH;
    public KSAdVideoPlayConfigImpl mI;
    public boolean mIsAudioEnable;
    public final l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    public KsNativeAd.VideoPlayListener mq;
    public int ms;
    public int mt;
    public d.a mv;

    public e(@NonNull Context context) {
        super(context);
        this.ms = 0;
        this.mt = 0;
        this.cU = new aq.b() { // from class: com.kwad.components.ad.f.e.10
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                e.this.cP = aVar.status;
                if (e.this.cP != 1) {
                    e.this.mAdWebView.setVisibility(8);
                } else {
                    e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.12
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @NonNull
            public static AdLiveEndCommonResultData p(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return p(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bC */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.ga);
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.f.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                e.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    e.this.mq.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.ow().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                try {
                    e.this.mq.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.ow().a(e.this.getCurrentVoiceItem());
                e eVar = e.this;
                eVar.eV.setAudioEnabled(eVar.g(eVar.mIsAudioEnable), false);
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.j.a.ow().a(e.this.getCurrentVoiceItem());
                try {
                    e.this.mq.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayComplete();
                }
                String bg = com.kwad.sdk.core.response.b.a.bg(e.this.mAdInfo);
                if (!TextUtils.isEmpty(bg)) {
                    com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                    if (aVar != null) {
                        e.this.ga = aVar.getAdLiveEndRequest(bg);
                    }
                    e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.f.e.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a */
                        public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                            super.onStartRequest(aVar2);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a */
                        public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i, String str) {
                            super.onError(aVar2, i, str);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a */
                        public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                            super.onSuccess(aVar2, adLiveEndCommonResultData);
                            ax.a aVar3 = new ax.a();
                            aVar3.status = 9;
                            aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                            aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                            aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                            aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                            aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                            aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                            if (e.this.fJ == null) {
                                e.this.fK = aVar3;
                            } else {
                                e.this.fJ.a(aVar3);
                            }
                        }
                    });
                }
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule != null) {
                    iAdLivePlayModule.setAudioEnabled(false, false);
                }
            }
        };
        initView();
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mv = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mq = videoPlayListener;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fC = new ba();
        aw awVar = new aw();
        this.fD = awVar;
        aVar.a(awVar);
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.b.cF(this.mAdTemplate)));
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aVar.a(this.fC);
        aVar.a(new ao(getOpenNewPageListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.e(this.ms, this.mt));
        this.fF = new WebCardRegisterLiveShopListener();
        this.fE = new WebCardRegisterLiveMessageListener();
        aVar.a(this.fF);
        aVar.a(this.fE);
        aVar.a(new ax(getRegisterLiveListener()));
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.aCG = null;
        bVar2.Ov = this.mH;
        bVar2.NP = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.aCI = false;
    }

    private void ay() {
        if (!com.kwad.sdk.core.response.b.b.cP(this.mAdTemplate)) {
            return;
        }
        es();
    }

    private boolean bx() {
        if (this.cP == 1) {
            return true;
        }
        return false;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.f.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.fE != null) {
                    e.this.fE.m(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.f.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.fF != null) {
                    e.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    private void en() {
        try {
            this.ms = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.mt = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void er() {
        this.mAdWebView.setVisibility(8);
        ax();
        if (bx()) {
            this.mAdWebView.reload();
        } else {
            ay();
        }
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.f.e.11
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                long playDuration;
                int i = aVar.Xn;
                if (aVar.Kq) {
                    if (aVar.Xl) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
                boolean bc = com.kwad.sdk.core.response.b.a.bc(e.this.mAdInfo);
                y.b bVar = new y.b();
                com.kwad.sdk.core.webview.d.b.c cVar = aVar.Xo;
                if (cVar != null && !TextUtils.isEmpty(cVar.Xd)) {
                    bVar.Xd = aVar.Xo.Xd;
                }
                a.C0644a as = new a.C0644a(e.this.getContext()).aq(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).ao(false).an(i).au(aVar.Kq).as(bc);
                IAdLivePlayModule iAdLivePlayModule = e.this.eV;
                if (iAdLivePlayModule == null) {
                    playDuration = 0;
                } else {
                    playDuration = iAdLivePlayModule.getPlayDuration();
                }
                com.kwad.components.core.e.d.a.a(as.v(playDuration).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.f.e.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (e.this.mv != null) {
                            e.this.mv.l(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.f.e.4
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    e eVar = e.this;
                    if (eVar.eV == null) {
                        eVar.eV = eVar.bi();
                    }
                    e eVar2 = e.this;
                    eVar2.eV.setAudioEnabled(eVar2.g(eVar2.mIsAudioEnable), false);
                }
            });
        }
        return this.eY;
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.f.e.9
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0655a().al(bVar.title).am(bVar.url).as(e.this.mAdTemplate).pa());
            }
        };
    }

    private ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.f.e.8
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                e.this.fJ = bVar;
                if (e.this.fK != null) {
                    e.this.fJ.a(e.this.fK);
                    e.this.fK = null;
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.eV = bi();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.ow().c(this.eY);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ac() {
        super.ac();
        this.bQ.tm();
        this.bQ.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ad() {
        super.ad();
        this.bQ.tm();
        this.bQ.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        com.kwad.components.core.j.a.ow().c(this.eY);
        this.fK = null;
        this.fJ = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
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
        this.mG.removeAllViews();
        this.mG.addView(view3);
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.c(view3);
            }
        });
        by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void initView() {
        com.kwad.sdk.m.l.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04ee, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148f);
        this.mH = adBasePvFrameLayout;
        this.mF = (ImageView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f0913b0);
        this.eL = (KSRelativeLayout) this.mH.findViewById(R.id.obfuscated_res_0x7f0913b1);
        this.mG = (RelativeLayout) this.mH.findViewById(R.id.obfuscated_res_0x7f0913d1);
        KsAdWebView ksAdWebView = (KsAdWebView) this.mH.findViewById(R.id.obfuscated_res_0x7f091516);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.eU = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.mF.setImageDrawable(null);
            KSImageLoader.loadImage(this.mF, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.f.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.mF.setVisibility(0);
            return;
        }
        this.mF.setVisibility(8);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void es() {
        aA();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().eh(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cN = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cN, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cH(this.mAdTemplate));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view2) {
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width != 0 && height != 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
            layoutParams.addRule(13, -1);
            view2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.ow();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
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

    public final void a(Context context, AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        View view2;
        this.mAdTemplate = adTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.mAdInfo = dP;
        this.mContext = context;
        this.mI = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.cB = com.kwad.sdk.core.response.b.a.bm(dP);
        if (getParent() == null) {
            view2 = this;
        } else {
            view2 = (View) getParent();
        }
        this.bQ = new com.kwad.components.core.widget.a.b(view2, 30);
        if (this.mI.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.mI.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
        }
        en();
        er();
    }
}
