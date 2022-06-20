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
/* loaded from: classes5.dex */
public class b extends AbstractKsFeedAd {
    public KsFeedAd.AdInteractionListener a;
    public com.kwad.sdk.feed.widget.base.a b;
    public com.kwad.sdk.feed.widget.base.a c;
    public boolean d;
    public int e;
    @NonNull
    public AdTemplate f;
    public AdInfo g;
    public KsAdVideoPlayConfig h;

    /* loaded from: classes5.dex */
    public static class a {
        public int a;
        public int b;

        public a(int i) {
            this.a = i;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            return i == this.a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0330b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(com.kwad.sdk.core.config.b.o()).build();
        this.f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.g = d.j(adTemplate);
        this.d = z;
        this.e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!this.d || !com.kwad.sdk.core.response.a.b.m(this.f)) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f.type), com.kwad.sdk.core.response.a.a.R(this.g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.h);
        return lVar;
    }

    private void a() {
        if (this.f != null) {
            com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
            a2.d("feed_ad_cache_" + this.f.posId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setInnerAdInteractionListener(new a.InterfaceC0331a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0331a
            public void a() {
                if (b.this.a != null) {
                    b.this.a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0331a
            public void b() {
                if (b.this.a != null) {
                    b.this.a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0331a
            public void c() {
                if (b.this.a != null) {
                    b.this.a.onDislikeClicked();
                    try {
                        if (aVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aVar.getParent()).removeView(aVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0331a
            public void d() {
                if (b.this.a != null) {
                    try {
                        b.this.a.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0331a
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0330b interfaceC0330b) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            interfaceC0330b.a();
            return null;
        }
        com.kwad.sdk.feed.widget.base.a a2 = a(context);
        this.c = a2;
        if (a2 != null) {
            this.c.setMargin(com.kwad.sdk.a.kwai.a.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.c;
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.c);
                        InterfaceC0330b interfaceC0330b2 = interfaceC0330b;
                        if (interfaceC0330b2 != null) {
                            interfaceC0330b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.h);
                }
                a(this.c);
            }
        }
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.b;
        if (aVar == null) {
            a();
            com.kwad.sdk.feed.widget.base.a aVar2 = this.c;
            if (aVar2 != null) {
                this.b = aVar2;
                return aVar2;
            } else if (context == null) {
                return null;
            } else {
                this.b = a(context);
            }
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.b;
        if (aVar3 != null) {
            aVar3.a(this.f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.h);
            }
            a(this.b);
        }
        return this.b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.g);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.f, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            com.kwad.sdk.feed.widget.base.a aVar = this.c;
            if (aVar instanceof l) {
                ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
            }
            if (this.h.isVideoSoundEnable()) {
                adTemplate = this.f;
                i = 2;
            } else {
                adTemplate = this.f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
            if (this.f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
                return;
            }
            as.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.h.setVideoSoundEnable(z);
        if (this.h.isVideoSoundEnable()) {
            adTemplate = this.f;
            i = 2;
        } else {
            adTemplate = this.f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
