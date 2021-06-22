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
    public KsFeedAd.AdInteractionListener f35645a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35646b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35647c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35648d;

    /* renamed from: e  reason: collision with root package name */
    public int f35649e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35650f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35651g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f35652h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35657a;

        /* renamed from: b  reason: collision with root package name */
        public int f35658b;

        public a(int i2) {
            this.f35657a = i2;
        }

        public int a() {
            return this.f35658b;
        }

        public boolean b() {
            int i2 = this.f35658b + 1;
            this.f35658b = i2;
            return i2 == this.f35657a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0407b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        this.f35652h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f35650f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f35651g = c.j(adTemplate);
        this.f35648d = z;
        this.f35649e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f35648d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f35650f.type), com.kwad.sdk.core.response.b.a.L(this.f35651g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f35652h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0408a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0408a
            public void a() {
                if (b.this.f35645a != null) {
                    b.this.f35645a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0408a
            public void b() {
                if (b.this.f35645a != null) {
                    b.this.f35645a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0408a
            public void c() {
                if (b.this.f35645a != null) {
                    b.this.f35645a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f35651g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0407b interfaceC0407b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0407b.a();
        }
        this.f35647c = a(context);
        this.f35647c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f35647c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i2 = this.f35649e;
                if (i2 > 0) {
                    lVar.setWidth(i2);
                }
                lVar.a(this.f35650f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f35647c);
                        InterfaceC0407b interfaceC0407b2 = interfaceC0407b;
                        if (interfaceC0407b2 != null) {
                            interfaceC0407b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f35650f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f35647c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f35652h);
                }
                a(this.f35647c);
            }
        }
        return this.f35647c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f35651g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f35646b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f35647c;
            if (aVar2 != null) {
                this.f35646b = aVar2;
                return aVar2;
            }
            this.f35646b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f35646b.getParent()).removeView(this.f35646b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f35646b;
        if (aVar3 != null) {
            aVar3.a(this.f35650f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f35646b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f35652h);
            }
            a(this.f35646b);
        }
        return this.f35646b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f35645a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f35650f;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        if (ksAdVideoPlayConfig != null) {
            this.f35652h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f35650f;
                i2 = 2;
            } else {
                adTemplate = this.f35650f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        this.f35652h.setVideoSoundEnable(z);
        if (this.f35652h.isVideoSoundEnable()) {
            adTemplate = this.f35650f;
            i2 = 2;
        } else {
            adTemplate = this.f35650f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }
}
