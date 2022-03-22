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
/* loaded from: classes7.dex */
public class b extends AbstractKsFeedAd {
    public KsFeedAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f40473b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f40474c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40475d;

    /* renamed from: e  reason: collision with root package name */
    public int f40476e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40477f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f40478g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f40479h;

    /* loaded from: classes7.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f40482b;

        public a(int i) {
            this.a = i;
        }

        public boolean a() {
            int i = this.f40482b + 1;
            this.f40482b = i;
            return i == this.a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1982b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.f40479h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(com.kwad.sdk.core.config.b.o()).build();
        this.f40477f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f40478g = d.j(adTemplate);
        this.f40475d = z;
        this.f40476e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!this.f40475d || !com.kwad.sdk.core.response.a.b.m(this.f40477f)) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f40477f.type), com.kwad.sdk.core.response.a.a.R(this.f40478g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f40479h);
        return lVar;
    }

    private void a() {
        if (this.f40477f != null) {
            com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
            a2.d("feed_ad_cache_" + this.f40477f.posId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setInnerAdInteractionListener(new a.InterfaceC1983a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1983a
            public void a() {
                if (b.this.a != null) {
                    b.this.a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1983a
            public void b() {
                if (b.this.a != null) {
                    b.this.a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1983a
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

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1983a
            public void d() {
                if (b.this.a != null) {
                    try {
                        b.this.a.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1983a
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC1982b interfaceC1982b) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            interfaceC1982b.a();
            return null;
        }
        com.kwad.sdk.feed.widget.base.a a2 = a(context);
        this.f40474c = a2;
        if (a2 != null) {
            this.f40474c.setMargin(com.kwad.sdk.a.kwai.a.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f40474c;
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.f40476e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f40477f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f40474c);
                        InterfaceC1982b interfaceC1982b2 = interfaceC1982b;
                        if (interfaceC1982b2 != null) {
                            interfaceC1982b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f40477f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f40474c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f40479h);
                }
                a(this.f40474c);
            }
        }
        return this.f40474c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.f40478g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f40473b;
        if (aVar == null) {
            a();
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f40474c;
            if (aVar2 != null) {
                this.f40473b = aVar2;
                return aVar2;
            } else if (context == null) {
                return null;
            } else {
                this.f40473b = a(context);
            }
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f40473b.getParent()).removeView(this.f40473b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f40473b;
        if (aVar3 != null) {
            aVar3.a(this.f40477f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f40473b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f40479h);
            }
            a(this.f40473b);
        }
        return this.f40473b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.f40478g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.f40478g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.f40477f, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f40477f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.f40479h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.f40479h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            com.kwad.sdk.feed.widget.base.a aVar = this.f40474c;
            if (aVar instanceof l) {
                ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
            }
            if (this.f40479h.isVideoSoundEnable()) {
                adTemplate = this.f40477f;
                i = 2;
            } else {
                adTemplate = this.f40477f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
            if (this.f40477f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
                return;
            }
            as.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f40477f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.f40479h.setVideoSoundEnable(z);
        if (this.f40479h.isVideoSoundEnable()) {
            adTemplate = this.f40477f;
            i = 2;
        } else {
            adTemplate = this.f40477f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
