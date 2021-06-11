package com.kwad.sdk.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.feed.widget.l;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends AbstractKsFeedAd {

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f35547a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35548b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35549c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35550d;

    /* renamed from: e  reason: collision with root package name */
    public int f35551e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35552f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35553g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f35554h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35559a;

        /* renamed from: b  reason: collision with root package name */
        public int f35560b;

        public a(int i2) {
            this.f35559a = i2;
        }

        public int a() {
            return this.f35560b;
        }

        public boolean b() {
            int i2 = this.f35560b + 1;
            this.f35560b = i2;
            return i2 == this.f35559a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0404b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f35554h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f35552f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f35553g = c.j(adTemplate);
        this.f35550d = z;
        this.f35551e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f35550d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f35552f.type), com.kwad.sdk.core.response.b.a.L(this.f35553g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f35554h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0405a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0405a
            public void a() {
                if (b.this.f35547a != null) {
                    b.this.f35547a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0405a
            public void b() {
                if (b.this.f35547a != null) {
                    b.this.f35547a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0405a
            public void c() {
                if (b.this.f35547a != null) {
                    b.this.f35547a.onDislikeClicked();
                    try {
                        if (aVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aVar.getParent()).removeView(aVar);
                        }
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }
        });
    }

    private boolean a() {
        return !TextUtils.isEmpty(this.f35553g.adStyleInfo.feedAdInfo.templateConfig);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r4 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r4 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
        r4.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0404b interfaceC0404b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0404b.a();
        }
        this.f35549c = a(context);
        this.f35549c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f35549c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f35551e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f35552f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f35549c);
                        InterfaceC0404b interfaceC0404b2 = interfaceC0404b;
                        if (interfaceC0404b2 != null) {
                            interfaceC0404b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f35552f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f35549c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f35554h);
                }
                a(this.f35549c);
            }
        }
        return this.f35549c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f35553g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f35548b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f35549c;
            if (aVar2 != null) {
                this.f35548b = aVar2;
                return aVar2;
            }
            this.f35548b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f35548b.getParent()).removeView(this.f35548b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f35548b;
        if (aVar3 != null) {
            aVar3.a(this.f35552f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f35548b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f35554h);
            }
            a(this.f35548b);
        }
        return this.f35548b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f35547a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f35552f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f35554h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f35552f;
                i2 = 2;
            } else {
                adTemplate = this.f35552f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f35554h.setVideoSoundEnable(z);
        if (this.f35554h.isVideoSoundEnable()) {
            adTemplate = this.f35552f;
            i2 = 2;
        } else {
            adTemplate = this.f35552f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
