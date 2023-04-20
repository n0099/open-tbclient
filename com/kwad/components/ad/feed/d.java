package com.kwad.components.ad.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.a.l;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class d extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    public KsFeedAd.AdInteractionListener cJ;
    public com.kwad.components.core.widget.b cK;
    public com.kwad.components.core.widget.b cL;
    public boolean cM;
    public KsAdVideoPlayConfig cN = new KsAdVideoPlayConfig.Builder().build();
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public int mWidth;

    /* loaded from: classes8.dex */
    public static class a {
        public int cS;
        public int size;

        public a(int i) {
            this.size = i;
        }

        public final int ba() {
            return this.cS;
        }

        public final boolean bb() {
            int i = this.cS + 1;
            this.cS = i;
            return i == this.size;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aZ();
    }

    public d(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.mAdTemplate = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.cM = z;
        this.mWidth = i;
    }

    @Nullable
    private com.kwad.components.core.widget.b F(Context context) {
        if (!this.cM || !com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)) {
            return c.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aD(this.mAdInfo));
        }
        l lVar = null;
        try {
            l lVar2 = new l(context);
            try {
                lVar2.setVideoPlayConfig(this.cN);
                return lVar2;
            } catch (Throwable th) {
                th = th;
                lVar = lVar2;
                com.kwad.components.core.b.a.b(th);
                return lVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.InterfaceC0617b() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.components.core.widget.b.InterfaceC0617b
            public final void onAdClicked() {
                if (d.this.cJ != null) {
                    d.this.cJ.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0617b
            public final void onAdShow() {
                if (d.this.cJ != null) {
                    d.this.cJ.onAdShow();
                }
                if (z) {
                    com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                    u.a aVar = new u.a();
                    FeedType fromInt = FeedType.fromInt(d.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    fVar.a(aVar);
                    com.kwad.components.core.m.c.ox().a(d.this.mAdTemplate, null, fVar);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0617b
            public final void onDislikeClicked() {
                if (d.this.cJ != null) {
                    d.this.cJ.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0617b
            public final void onDownloadTipsDialogDismiss() {
                if (d.this.cJ != null) {
                    try {
                        d.this.cJ.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0617b
            public final void onDownloadTipsDialogShow() {
                if (d.this.cJ != null) {
                    try {
                        d.this.cJ.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    private void aY() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.a.a sS = com.kwad.sdk.core.diskcache.a.a.sS();
            sS.remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.a.a.bh(this.mAdInfo);
    }

    public final com.kwad.components.core.widget.b a(final b bVar) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            bVar.aZ();
            return null;
        }
        com.kwad.components.core.widget.b F = F(context);
        this.cL = F;
        if (F != null) {
            this.cL.setMargin(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
            com.kwad.components.core.widget.b bVar2 = this.cL;
            if (bVar2 instanceof l) {
                l lVar = (l) bVar2;
                int i = this.mWidth;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.mAdTemplate, new l.a() { // from class: com.kwad.components.ad.feed.d.1
                    @Override // com.kwad.components.ad.feed.a.l.a
                    public final void aZ() {
                        d dVar = d.this;
                        dVar.a(dVar.cL, false);
                        b bVar3 = bVar;
                        if (bVar3 != null) {
                            bVar3.aZ();
                        }
                    }
                });
                return this.cL;
            }
            bVar2.c((com.kwad.components.core.widget.b) this.mAdTemplate);
            com.kwad.components.core.widget.b bVar3 = this.cL;
            if (bVar3 instanceof com.kwad.components.ad.feed.a.c) {
                ((com.kwad.components.ad.feed.a.c) bVar3).a(this.cN);
            }
            a(this.cL, true);
        }
        bVar.aZ();
        return this.cL;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        com.kwad.components.core.widget.b bVar = this.cK;
        if (bVar == null) {
            aY();
            com.kwad.components.core.widget.b bVar2 = this.cL;
            if (bVar2 != null) {
                this.cK = bVar2;
                return bVar2;
            } else if (context == null) {
                return null;
            } else {
                this.cK = F(context);
            }
        } else if (bVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.cK.getParent()).removeView(this.cK);
        }
        com.kwad.components.core.widget.b bVar3 = this.cK;
        if (bVar3 != null) {
            bVar3.c((com.kwad.components.core.widget.b) this.mAdTemplate);
            com.kwad.components.core.widget.b bVar4 = this.cK;
            if (bVar4 instanceof com.kwad.components.ad.feed.a.c) {
                ((com.kwad.components.ad.feed.a.c) bVar4).a(this.cN);
            }
            com.kwad.components.core.widget.b bVar5 = this.cK;
            a(bVar5, !(bVar5 instanceof l));
        }
        return this.cK;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        try {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.cJ = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.aA(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.cN.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.cN.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.cN.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            }
            com.kwad.components.core.widget.b bVar = this.cL;
            if (bVar instanceof l) {
                ((l) bVar).setVideoPlayConfig(this.cN);
            }
        }
        if (isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.cN.setVideoSoundEnable(z);
        if (this.cN.isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
