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
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class b extends AbstractKsFeedAd {

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f33997a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33998b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34000d;

    /* renamed from: e  reason: collision with root package name */
    public int f34001e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34002f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34003g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f34004h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34009a;

        /* renamed from: b  reason: collision with root package name */
        public int f34010b;

        public a(int i2) {
            this.f34009a = i2;
        }

        public boolean a() {
            int i2 = this.f34010b + 1;
            this.f34010b = i2;
            return i2 == this.f34009a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0391b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f34004h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f34002f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f34003g = c.g(adTemplate);
        this.f34000d = z;
        this.f34001e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f34000d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f34002f.type), com.kwad.sdk.core.response.b.a.H(this.f34003g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f34004h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0392a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0392a
            public void a() {
                if (b.this.f33997a != null) {
                    b.this.f33997a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0392a
            public void b() {
                if (b.this.f33997a != null) {
                    b.this.f33997a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0392a
            public void c() {
                if (b.this.f33997a != null) {
                    b.this.f33997a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f34003g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0391b interfaceC0391b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0391b.a();
        }
        this.f33999c = a(context);
        this.f33999c.setMargin(an.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f33999c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f34001e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f34002f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f33999c);
                        InterfaceC0391b interfaceC0391b2 = interfaceC0391b;
                        if (interfaceC0391b2 != null) {
                            interfaceC0391b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f34002f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f33999c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f34004h);
                }
                a(this.f33999c);
            }
        }
        return this.f33999c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f34003g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f33998b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f33999c;
            if (aVar2 != null) {
                this.f33998b = aVar2;
                return aVar2;
            }
            this.f33998b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f33998b.getParent()).removeView(this.f33998b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f33998b;
        if (aVar3 != null) {
            aVar3.a(this.f34002f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f33998b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f34004h);
            }
            a(this.f33998b);
        }
        return this.f33998b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f33997a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f34002f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f34004h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f34002f;
                i2 = 2;
            } else {
                adTemplate = this.f34002f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f34004h.setVideoSoundEnable(z);
        if (this.f34004h.isVideoSoundEnable()) {
            adTemplate = this.f34002f;
            i2 = 2;
        } else {
            adTemplate = this.f34002f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
