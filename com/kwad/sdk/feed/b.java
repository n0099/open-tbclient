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
    public KsFeedAd.AdInteractionListener f33171a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33172b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33173c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33174d;

    /* renamed from: e  reason: collision with root package name */
    public int f33175e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33176f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33177g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f33178h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33183a;

        /* renamed from: b  reason: collision with root package name */
        public int f33184b;

        public a(int i2) {
            this.f33183a = i2;
        }

        public boolean a() {
            int i2 = this.f33184b + 1;
            this.f33184b = i2;
            return i2 == this.f33183a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0379b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f33178h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f33176f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f33177g = c.g(adTemplate);
        this.f33174d = z;
        this.f33175e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f33174d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f33176f.type), com.kwad.sdk.core.response.b.a.H(this.f33177g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f33178h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0380a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0380a
            public void a() {
                if (b.this.f33171a != null) {
                    b.this.f33171a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0380a
            public void b() {
                if (b.this.f33171a != null) {
                    b.this.f33171a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0380a
            public void c() {
                if (b.this.f33171a != null) {
                    b.this.f33171a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f33177g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0379b interfaceC0379b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0379b.a();
        }
        this.f33173c = a(context);
        this.f33173c.setMargin(an.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f33173c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f33175e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f33176f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f33173c);
                        InterfaceC0379b interfaceC0379b2 = interfaceC0379b;
                        if (interfaceC0379b2 != null) {
                            interfaceC0379b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f33176f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f33173c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f33178h);
                }
                a(this.f33173c);
            }
        }
        return this.f33173c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f33177g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f33172b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f33173c;
            if (aVar2 != null) {
                this.f33172b = aVar2;
                return aVar2;
            }
            this.f33172b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f33172b.getParent()).removeView(this.f33172b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f33172b;
        if (aVar3 != null) {
            aVar3.a(this.f33176f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f33172b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f33178h);
            }
            a(this.f33172b);
        }
        return this.f33172b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f33171a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33176f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f33178h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f33176f;
                i2 = 2;
            } else {
                adTemplate = this.f33176f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f33178h.setVideoSoundEnable(z);
        if (this.f33178h.isVideoSoundEnable()) {
            adTemplate = this.f33176f;
            i2 = 2;
        } else {
            adTemplate = this.f33176f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
