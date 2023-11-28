package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class m extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    public static final HashMap<Long, Double> fG = new HashMap<>(8);
    public List<Integer> cB;
    public int cP;
    public KsAdVideoPlayConfig dU;
    public KSRelativeLayout eL;
    public ImageView eM;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.core.video.e eO;
    public d eP;
    public boolean eQ;
    public final a.InterfaceC0662a eS;
    public IAdLiveOfflineView eT;
    public com.kwad.components.core.n.a.a.a eU;
    public IAdLivePlayModule eV;
    public boolean eW;
    public View eX;
    public a.b eY;
    public final AdLivePlayStateListener eZ;
    public d.b ek;
    public long ey;
    public LinearLayout fA;
    public TextView fB;
    public ba fC;
    public aw fD;
    public WebCardRegisterLiveMessageListener fE;
    public WebCardRegisterLiveShopListener fF;
    public boolean fH;
    public String fI;
    public ax.b fJ;
    public ax.a fK;
    public boolean fL;
    public com.kwad.components.core.widget.b fM;
    public float fN;
    public float fO;
    public boolean fP;
    public a fQ;
    public ViewGroup.MarginLayoutParams fR;
    public Handler fS;
    public e fT;
    public ar fU;
    public boolean fV;
    public boolean fW;
    public com.kwad.components.core.webview.b fX;
    public com.kwad.components.core.webview.c fY;
    public b.a fZ;
    public OfflineOnAudioConflictListener fa;
    public RatioFrameLayout fy;
    public double fz;
    public IAdLiveEndRequest ga;
    public KsAdWebView mAdWebView;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mIsAudioEnable;
    public final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    public int mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void c(int i, String str);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04d5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$11  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass11 extends com.kwad.components.core.webview.c {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ac.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aCI = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.f(m.this.mAdTemplate.loadType));
            m.this.fC = new ba();
            aVar.a(m.this.fC);
            aVar.a(new ao(m.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (m.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo) || m.this.eW) {
                            m mVar = m.this;
                            mVar.fR = (ViewGroup.MarginLayoutParams) mVar.eL.getLayoutParams();
                            int ceil = (int) Math.ceil(m.this.fz);
                            int i = m.this.mWidth;
                            if (videoPosition.widthRation == 0.0d) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            m.this.fR.topMargin = (int) (videoPosition.topMarginRation * ceil);
                            double d = i;
                            m.this.fR.leftMargin = (int) (videoPosition.leftMarginRation * d);
                            m.this.fR.width = (int) (d * videoPosition.widthRation);
                            m.this.fR.height = (int) (m.this.fR.width * videoPosition.heightWidthRation);
                            m.this.eL.setRadius(videoPosition.borderRadius);
                            m.this.eL.setLayoutParams(m.this.fR);
                            m.this.eL.setVisibility(0);
                            if ((m.this.dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) m.this.dU).getVideoSoundValue() != 0) {
                                m mVar2 = m.this;
                                mVar2.mIsAudioEnable = mVar2.dU.isVideoSoundEnable();
                            } else {
                                m mVar3 = m.this;
                                mVar3.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(mVar3.mAdInfo);
                            }
                            m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                            m mVar4 = m.this;
                            mVar4.cB = com.kwad.sdk.core.response.b.a.bm(mVar4.mAdInfo);
                            if (!m.this.eW) {
                                m mVar5 = m.this;
                                mVar5.a(mVar5.dU);
                            } else if (m.this.eV == null) {
                            } else {
                                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                                m mVar6 = m.this;
                                iAdLivePlayModule.setAudioEnabled(mVar6.g(mVar6.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ab(bVar, new ab.a() { // from class: com.kwad.components.ad.feed.b.m.11.2
                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void bA() {
                    m.this.fS.post(new Runnable() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            m.this.ta();
                        }
                    });
                }
            }));
            aVar.a(new ay(new ay.a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    m.d(m.this, true);
                    m.this.bu();
                }
            }));
            m.this.fU = new ar();
            aVar.a(m.this.fU);
            if (m.this.eW) {
                aVar.a(new com.kwad.components.core.webview.jshandler.e(1, 1));
                m.this.fF = new WebCardRegisterLiveShopListener();
                m.this.fE = new WebCardRegisterLiveMessageListener();
                aVar.a(m.this.fF);
                aVar.a(m.this.fE);
                aVar.a(new ax(m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aj.a aVar) {
            double d;
            if (m.this.fL) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.fz == 0.0d) {
                m.this.fz = aVar.height;
                m.this.fy.setRatio((float) d);
                m.fG.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            if (m.this.fH) {
                return;
            }
            m.this.cP = aVar.status;
            if (m.this.cP == 1) {
                m.this.fS.removeCallbacksAndMessages(null);
                if (m.this.fM != null) {
                    m.this.fM.setVisibility(8);
                }
                m.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.o.a.pX().au(m.this.mAdTemplate);
                if (m.this.fQ != null) {
                    m.this.fQ.c(2, "");
                    return;
                }
                return;
            }
            m.this.f("3", 3);
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            m.this.fD = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            long playDuration;
            m.this.bw();
            int i = aVar.Xn;
            if (aVar.Kq) {
                if (aVar.Xl) {
                    i = 1;
                } else {
                    i = 2;
                }
            }
            boolean bc = com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo);
            y.b bVar = new y.b();
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.Xo;
            if (cVar != null && !TextUtils.isEmpty(cVar.Xd)) {
                bVar.Xd = aVar.Xo.Xd;
            }
            a.C0644a as = new a.C0644a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).an(i).am(aVar.kk).al(5).au(aVar.Kq).as(bc);
            if (m.this.eV == null) {
                playDuration = 0;
            } else {
                playDuration = m.this.eV.getPlayDuration();
            }
            com.kwad.components.core.e.d.a.a(as.v(playDuration).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (m.this.aaZ != null) {
                        m.this.aaZ.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i, String str) {
            m.this.f("1", 2);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.ad.feed.b.m.11.4
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (m.this.aaZ != null && !m.this.fL) {
                        m.this.aaZ.onAdShow();
                        com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cF(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }
    }

    private void bt() {
        this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.feed.b.m.12
            @Override // java.lang.Runnable
            public final void run() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.f("0", 1);
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        d.b bVar = new d.b() { // from class: com.kwad.components.ad.feed.b.m.17
            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(final double d) {
                if (!bq.o(m.this.fy, (int) (com.kwad.sdk.core.config.d.Bb() * 100.0f))) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0644a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(2).ao(false).aq(false).am(Cea708Decoder.COMMAND_DF5).al(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.e.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.dZ(m.this.mAdTemplate));
                        com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
                        jVar.l(d);
                        jVar.cA(Cea708Decoder.COMMAND_DF5);
                        m.this.c(jVar);
                    }
                }));
                return true;
            }
        };
        this.ek = bVar;
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cK(this.mAdTemplate), this.mContext, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bx() {
        if (this.cP == 1) {
            return true;
        }
        return false;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fE != null) {
                    m.this.fE.m(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fF != null) {
                    m.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.m.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (m.this.eW) {
                        if (m.this.eV == null) {
                            m mVar = m.this;
                            mVar.eV = mVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                        m mVar2 = m.this;
                        iAdLivePlayModule.setAudioEnabled(mVar2.g(mVar2.mIsAudioEnable), false);
                    } else if (m.this.eN == null) {
                    } else {
                        com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                        m mVar3 = m.this;
                        aVar.setVideoSoundEnable(mVar3.g(mVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.feed.b.m.18
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0655a().al(bVar.title).am(bVar.url).aB(true).as(m.this.mAdTemplate).pa());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.feed.b.m.14
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                m.this.fJ = bVar;
                if (m.this.fK != null) {
                    m.this.fJ.a(m.this.fK);
                    m.this.fK = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.b.m.7
            public boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j) {
                m.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.pX().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.report.a.bO(m.this.mAdTemplate);
                m.this.fC.aL(9);
                m.this.eL.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.aW() && m.this.eP == null && !m.this.fV) {
                    m.this.eP = new d(m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.eP, layoutParams);
                    m.this.eP.bn();
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                AdTemplate adTemplate = m.this.mAdTemplate;
                String K = com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo);
                com.kwad.components.ad.feed.monitor.b.a(adTemplate, 2, 1, K, i + " " + i2, SystemClock.elapsedRealtime() - m.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.ow().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ey);
                com.kwad.sdk.core.report.a.bN(m.this.mAdTemplate);
                m.this.fC.aL(3);
                if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                    m.this.eP.bo();
                    m.this.eP = null;
                }
                if (m.this.fT == null && com.kwad.sdk.core.response.b.b.cI(m.this.mAdTemplate) && m.this.fV) {
                    m.this.fT = new e(m.this.mContext);
                    m.this.eL.addView(m.this.fT, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fT.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view2) {
                            if (com.kwad.sdk.core.response.b.b.cJ(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v((int) Cea708Decoder.COMMAND_DF6);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view2) {
                            if (com.kwad.sdk.core.response.b.b.cJ(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dE(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(153);
                        }
                    });
                    m.this.fT.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fU.aK(1);
                            m.this.eL.removeView(m.this.fT);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
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
        if (this.ek != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cK(this.mAdTemplate), this.mContext, this.ek);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        if (this.cP != 1 && !this.fH) {
            this.mAdWebView.stopLoading();
            this.mAdWebView.setVisibility(8);
            f("0", 1);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        aw awVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aaZ) != null && this.fL) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (!this.fL && (awVar = this.fD) != null) {
            awVar.sh();
        }
    }

    public m(@NonNull Context context) {
        super(context);
        this.cP = -1;
        this.mIsAudioEnable = false;
        this.fL = false;
        this.fS = new Handler(Looper.getMainLooper());
        this.fV = false;
        this.fW = false;
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eN != null) {
                    m.this.eN.setVideoSoundEnable(false);
                }
                if (m.this.eV != null) {
                    m.this.eV.setAudioEnabled(false, false);
                }
            }
        };
        this.fY = new AnonymousClass11();
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.m.13
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.aaZ != null) {
                    m.this.aaZ.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.aaZ != null) {
                    m.this.aaZ.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.aaZ != null) {
                    m.this.aaZ.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.aaZ != null) {
                    m.this.aaZ.onDownloadTipsDialogShow();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.aaZ != null && m.this.fL) {
                    m.this.aaZ.onAdShow();
                }
                if (m.this.fL) {
                    com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
                    y.a aVar = new y.a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    jVar.a(aVar);
                    jVar.x((int) Math.ceil(m.this.fz), m.this.mWidth);
                    com.kwad.components.core.s.b.qL().a(m.this.mAdTemplate, null, jVar);
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
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
                return new com.kwad.components.core.liveEnd.a(m.this.ga);
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                m.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bg = com.kwad.sdk.core.response.b.a.bg(m.this.mAdInfo);
                if (!TextUtils.isEmpty(bg)) {
                    com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                    if (aVar != null) {
                        m.this.ga = aVar.getAdLiveEndRequest(bg);
                    }
                    m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
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
                            if (m.this.fJ != null) {
                                m.this.fJ.a(aVar3);
                            } else {
                                m.this.fK = aVar3;
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.j.a.ow().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.j.a.ow().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eV.setAudioEnabled(false, false);
            }
        };
        this.eS = new a.InterfaceC0662a() { // from class: com.kwad.components.ad.feed.b.m.10
            @Override // com.kwad.components.core.video.a.InterfaceC0662a
            public final void a(int i, ac.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            i2 = 108;
                        } else {
                            i2 = 83;
                            i3 = 1;
                            z = true;
                        }
                    } else {
                        i2 = 82;
                    }
                } else {
                    i2 = 13;
                }
                y.b bVar = new y.b();
                bVar.km = aVar;
                bVar.kk = i2;
                m.this.bw();
                com.kwad.components.core.e.d.a.a(new a.C0644a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(i3).ao(z).aq(true).a(bVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        m.this.sZ();
                    }
                }));
            }
        };
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
    public void v(final int i) {
        bw();
        com.kwad.components.core.e.d.a.a(new a.C0644a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(1).ao(true).am(i).al(5).aq(false).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.8
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.aH(i);
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        if (view2 == this.eL) {
            if (this.eN.isIdle()) {
                com.kwad.sdk.utils.l.ej(this.mAdTemplate);
                this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate));
                this.eN.start();
                return;
            }
            a(this.eN, 100);
        } else if (view2 == this.fB) {
            a(this.eN, 25);
        }
    }

    public static float h(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        if (i != 2 && i != 3) {
            return 0.968f;
        }
        return 0.283f;
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fQ;
        if (aVar2 != null) {
            int i = 1;
            if (this.cP == 1) {
                i = 2;
            }
            aVar2.c(i, "");
        }
        this.fQ = aVar;
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    public static /* synthetic */ boolean d(m mVar, boolean z) {
        mVar.fV = true;
        return true;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.fN = motionEvent.getX();
            this.fO = motionEvent.getY();
        }
    }

    public static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.Kq) {
            return aVar.Xl;
        }
        if (aVar.Xn == 1) {
            return true;
        }
        return false;
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

    private void g(AdTemplate adTemplate) {
        if (this.fW) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cJ(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091513);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091517);
        }
        this.fW = true;
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            FeedType.fromInt(this.mAdTemplate.type);
            bw();
            com.kwad.components.core.e.d.a.a(new a.C0644a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).as(com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.aH(i);
                }
            }));
        }
    }

    public static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(m mVar, boolean z) {
        mVar.eQ = false;
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void ay() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jn();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().az(this.mAdTemplate).ay(com.kwad.sdk.core.response.b.b.cF(this.mAdTemplate)).d(this.mAdWebView).k(this.fy).f(this.mApkDownloadHelper).a(this.fY));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cF(this.mAdTemplate));
        R r = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.b.b.cF(r));
        bt();
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eV == null) {
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
            this.eV.setAudioEnabled(g(this.mIsAudioEnable), false);
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
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.b.m.3
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(view3);
            }
        });
        by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
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

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.fS.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.ei(this.mAdTemplate);
        d.b bVar = this.ek;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
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
        this.fJ = null;
        this.fK = null;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        com.kwad.components.ad.feed.monitor.b.aZ();
        this.fy = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09133b);
        this.eL = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0914e7);
        this.fA = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914fa);
        this.fB = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f9);
        this.eM = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f7);
        this.eX = findViewById(R.id.obfuscated_res_0x7f0913b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i) {
        int i2;
        com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError " + str);
        this.fS.removeCallbacksAndMessages(null);
        if (this.fH) {
            return;
        }
        this.fH = true;
        if (this.mAdWebView != null) {
            R r = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r, com.kwad.sdk.core.response.b.b.cF(r), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i);
        }
        com.kwad.components.core.o.a pX = com.kwad.components.core.o.a.pX();
        AdTemplate adTemplate = this.mAdTemplate;
        pX.b(adTemplate, com.kwad.sdk.core.response.b.b.cF(adTemplate), str);
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i2 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.f(i2, com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
        a aVar = this.fQ;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fQ = null;
        if (this.fM == null) {
            this.fL = true;
            com.kwad.components.core.widget.b.c(this);
            int be = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eV.onDestroy();
                this.eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eT = null;
            }
            com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), be);
            this.fM = a2;
            if (a2 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(this.mContext, 16.0f));
                this.fy.removeAllViews();
                this.fy.setRatio(0.0d);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eL.setVisibility(8);
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.fy.addView(this.fM);
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
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

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r = this.mAdTemplate;
                if (r != 0) {
                    r.mIsAudioEnable = isVideoSoundEnable;
                }
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0 && (eVar = this.eO) != null) {
                eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.sdk.core.response.model.AdTemplate */
    /* JADX WARN: Multi-variable type inference failed */
    private void i(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Double d = fG.get(Long.valueOf(this.mAdTemplate.posId));
        if (d != null) {
            this.fy.setRatio(d.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate) > 0.0d) {
            this.fy.setRatio(com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate));
        } else if (this.fy.getRatio() == 0.0d) {
            this.fy.setRatio(h(this.mAdTemplate));
        }
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.oA() && com.kwad.sdk.core.response.b.a.cJ(this.mAdInfo)) {
            this.eW = true;
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        g(m);
        m.realShowType = 2;
        super.b((m) adResultData);
        if (this.fH) {
            com.kwad.components.core.widget.b bVar = this.fM;
            if (bVar != null) {
                bVar.b((com.kwad.components.core.widget.b) adResultData);
                com.kwad.components.core.widget.b bVar2 = this.fM;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dU);
                }
            }
        } else if (!com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate)) {
            f("0", 0);
        } else {
            if (!bx()) {
                i(this.mAdTemplate);
            }
            try {
                if (this.fI == null || !this.fI.equals(m.mOriginJString)) {
                    if (bx()) {
                        this.mAdWebView.reload();
                    } else {
                        this.cP = -2;
                        ay();
                    }
                }
            } catch (Throwable unused) {
                f("0", 0);
            }
            this.fI = m.mOriginJString;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FeedSlideConf ce;
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.d.Be() && com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.ce(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            a(motionEvent);
            if ((action == 2 || action == 3) && this.mAdWebView != null && !this.fL && Math.abs(motionEvent.getX() - this.fN) > 0.0f) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.fN);
                double abs2 = Math.abs(motionEvent.getY() - this.fO);
                if (Math.tan(ce.maxRange) * abs < abs2 || Math.tan(ce.minRange) * abs < abs2) {
                    this.mAdWebView.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (z) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eL) {
                viewGroup.removeView(this.eN);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.eO.setVideoPlayCallback(getVideoPlayCallback());
                this.eO.setAdClickListener(this.eS);
                this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eO.rz();
                this.eO.setAutoRelease(true);
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
            iAdLivePlayModule.onPause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String ef;
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eN = aVar;
        aVar.setTag(this.cB);
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
                this.eN.a(new b.a(this.mAdTemplate).cD(K).cE(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ah(), null);
                this.eN.setVideoSoundEnable(g(this.mIsAudioEnable));
                this.eO = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
                this.ey = SystemClock.elapsedRealtime();
                this.eO.setVideoPlayCallback(getVideoPlayCallback());
                this.eO.setAdClickListener(this.eS);
                this.eN.setController(this.eO);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN, 1);
                this.eL.setTag(this.eN);
                this.eL.setClickable(true);
                new com.kwad.sdk.widget.f(this.eL, this);
                if (this.mIsAudioEnable) {
                    com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
                }
                int i = this.mAdTemplate.type;
                if (i == 1 || i == 19) {
                    this.fA.setVisibility(0);
                    this.fB.setVisibility(0);
                    this.fB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
                    new com.kwad.sdk.widget.f(this.fB, this);
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

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (!com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            return;
        }
        if (view2 == this.eL || view2 == this.fB) {
            a(this.eN, 153);
        }
    }
}
