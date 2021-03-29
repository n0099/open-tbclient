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
/* loaded from: classes6.dex */
public class b extends AbstractKsFeedAd {

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f34884a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f34885b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f34886c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34887d;

    /* renamed from: e  reason: collision with root package name */
    public int f34888e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34889f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34890g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f34891h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34896a;

        /* renamed from: b  reason: collision with root package name */
        public int f34897b;

        public a(int i) {
            this.f34896a = i;
        }

        public int a() {
            return this.f34897b;
        }

        public boolean b() {
            int i = this.f34897b + 1;
            this.f34897b = i;
            return i == this.f34896a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0404b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.f34891h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f34889f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f34890g = c.j(adTemplate);
        this.f34887d = z;
        this.f34888e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f34887d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f34889f.type), com.kwad.sdk.core.response.b.a.L(this.f34890g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f34891h);
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
                if (b.this.f34884a != null) {
                    b.this.f34884a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0405a
            public void b() {
                if (b.this.f34884a != null) {
                    b.this.f34884a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0405a
            public void c() {
                if (b.this.f34884a != null) {
                    b.this.f34884a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f34890g.adStyleInfo.feedAdInfo.templateConfig);
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
        this.f34886c = a(context);
        this.f34886c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f34886c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.f34888e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f34889f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f34886c);
                        InterfaceC0404b interfaceC0404b2 = interfaceC0404b;
                        if (interfaceC0404b2 != null) {
                            interfaceC0404b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f34889f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f34886c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f34891h);
                }
                a(this.f34886c);
            }
        }
        return this.f34886c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f34890g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f34885b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f34886c;
            if (aVar2 != null) {
                this.f34885b = aVar2;
                return aVar2;
            }
            this.f34885b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f34885b.getParent()).removeView(this.f34885b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f34885b;
        if (aVar3 != null) {
            aVar3.a(this.f34889f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f34885b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f34891h);
            }
            a(this.f34885b);
        }
        return this.f34885b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f34884a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f34889f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.f34891h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f34889f;
                i = 2;
            } else {
                adTemplate = this.f34889f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.f34891h.setVideoSoundEnable(z);
        if (this.f34891h.isVideoSoundEnable()) {
            adTemplate = this.f34889f;
            i = 2;
        } else {
            adTemplate = this.f34889f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
