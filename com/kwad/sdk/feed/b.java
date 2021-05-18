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
    public KsFeedAd.AdInteractionListener f33242a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33243b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f33244c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33245d;

    /* renamed from: e  reason: collision with root package name */
    public int f33246e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33247f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33248g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f33249h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33254a;

        /* renamed from: b  reason: collision with root package name */
        public int f33255b;

        public a(int i2) {
            this.f33254a = i2;
        }

        public boolean a() {
            int i2 = this.f33255b + 1;
            this.f33255b = i2;
            return i2 == this.f33254a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0378b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f33249h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f33247f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f33248g = c.g(adTemplate);
        this.f33245d = z;
        this.f33246e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f33245d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f33247f.type), com.kwad.sdk.core.response.b.a.H(this.f33248g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f33249h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0379a
            public void a() {
                if (b.this.f33242a != null) {
                    b.this.f33242a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0379a
            public void b() {
                if (b.this.f33242a != null) {
                    b.this.f33242a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0379a
            public void c() {
                if (b.this.f33242a != null) {
                    b.this.f33242a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f33248g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0378b interfaceC0378b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0378b.a();
        }
        this.f33244c = a(context);
        this.f33244c.setMargin(an.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f33244c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f33246e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f33247f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f33244c);
                        InterfaceC0378b interfaceC0378b2 = interfaceC0378b;
                        if (interfaceC0378b2 != null) {
                            interfaceC0378b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f33247f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f33244c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f33249h);
                }
                a(this.f33244c);
            }
        }
        return this.f33244c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f33248g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f33243b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f33244c;
            if (aVar2 != null) {
                this.f33243b = aVar2;
                return aVar2;
            }
            this.f33243b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f33243b.getParent()).removeView(this.f33243b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f33243b;
        if (aVar3 != null) {
            aVar3.a(this.f33247f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f33243b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f33249h);
            }
            a(this.f33243b);
        }
        return this.f33243b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f33242a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33247f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f33249h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f33247f;
                i2 = 2;
            } else {
                adTemplate = this.f33247f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f33249h.setVideoSoundEnable(z);
        if (this.f33249h.isVideoSoundEnable()) {
            adTemplate = this.f33247f;
            i2 = 2;
        } else {
            adTemplate = this.f33247f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
