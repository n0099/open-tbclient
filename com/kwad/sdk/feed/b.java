package com.kwad.sdk.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.feed.widget.l;
import com.kwad.sdk.utils.as;
/* loaded from: classes3.dex */
public class b extends AbstractKsFeedAd {
    public KsFeedAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f59088b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f59089c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59090d;

    /* renamed from: e  reason: collision with root package name */
    public int f59091e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59092f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59093g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f59094h;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f59097b;

        public a(int i2) {
            this.a = i2;
        }

        public boolean a() {
            int i2 = this.f59097b + 1;
            this.f59097b = i2;
            return i2 == this.a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2109b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f59094h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(com.kwad.sdk.core.config.b.o()).build();
        this.f59092f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f59093g = d.j(adTemplate);
        this.f59090d = z;
        this.f59091e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!this.f59090d || !com.kwad.sdk.core.response.a.b.m(this.f59092f)) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f59092f.type), com.kwad.sdk.core.response.a.a.R(this.f59093g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f59094h);
        return lVar;
    }

    private void a() {
        if (this.f59092f != null) {
            com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
            a2.d("feed_ad_cache_" + this.f59092f.posId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setInnerAdInteractionListener(new a.InterfaceC2110a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2110a
            public void a() {
                if (b.this.a != null) {
                    b.this.a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2110a
            public void b() {
                if (b.this.a != null) {
                    b.this.a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2110a
            public void c() {
                if (b.this.a != null) {
                    b.this.a.onDislikeClicked();
                    try {
                        if (aVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aVar.getParent()).removeView(aVar);
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2110a
            public void d() {
                if (b.this.a != null) {
                    try {
                        b.this.a.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2110a
            public void e() {
                if (b.this.a != null) {
                    try {
                        b.this.a.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r4 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r4 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        r4.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC2109b interfaceC2109b) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            interfaceC2109b.a();
            return null;
        }
        com.kwad.sdk.feed.widget.base.a a2 = a(context);
        this.f59089c = a2;
        if (a2 != null) {
            this.f59089c.setMargin(com.kwad.sdk.a.kwai.a.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f59089c;
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f59091e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f59092f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f59089c);
                        InterfaceC2109b interfaceC2109b2 = interfaceC2109b;
                        if (interfaceC2109b2 != null) {
                            interfaceC2109b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f59092f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f59089c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f59094h);
                }
                a(this.f59089c);
            }
        }
        return this.f59089c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.f59093g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f59088b;
        if (aVar == null) {
            a();
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f59089c;
            if (aVar2 != null) {
                this.f59088b = aVar2;
                return aVar2;
            } else if (context == null) {
                return null;
            } else {
                this.f59088b = a(context);
            }
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f59088b.getParent()).removeView(this.f59088b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f59088b;
        if (aVar3 != null) {
            aVar3.a(this.f59092f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f59088b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f59094h);
            }
            a(this.f59088b);
        }
        return this.f59088b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.f59093g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.f59093g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.f59092f, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f59092f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f59094h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.f59094h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            com.kwad.sdk.feed.widget.base.a aVar = this.f59089c;
            if (aVar instanceof l) {
                ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
            }
            if (this.f59094h.isVideoSoundEnable()) {
                adTemplate = this.f59092f;
                i2 = 2;
            } else {
                adTemplate = this.f59092f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
            if (this.f59092f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
                return;
            }
            as.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f59092f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f59094h.setVideoSoundEnable(z);
        if (this.f59094h.isVideoSoundEnable()) {
            adTemplate = this.f59092f;
            i2 = 2;
        } else {
            adTemplate = this.f59092f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
