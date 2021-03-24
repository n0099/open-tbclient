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
    public KsFeedAd.AdInteractionListener f34883a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f34884b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f34885c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34886d;

    /* renamed from: e  reason: collision with root package name */
    public int f34887e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34888f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34889g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f34890h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34895a;

        /* renamed from: b  reason: collision with root package name */
        public int f34896b;

        public a(int i) {
            this.f34895a = i;
        }

        public int a() {
            return this.f34896b;
        }

        public boolean b() {
            int i = this.f34896b + 1;
            this.f34896b = i;
            return i == this.f34895a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0403b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.f34890h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f34888f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f34889g = c.j(adTemplate);
        this.f34886d = z;
        this.f34887e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f34886d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f34888f.type), com.kwad.sdk.core.response.b.a.L(this.f34889g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f34890h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0404a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0404a
            public void a() {
                if (b.this.f34883a != null) {
                    b.this.f34883a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0404a
            public void b() {
                if (b.this.f34883a != null) {
                    b.this.f34883a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0404a
            public void c() {
                if (b.this.f34883a != null) {
                    b.this.f34883a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f34889g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0403b interfaceC0403b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0403b.a();
        }
        this.f34885c = a(context);
        this.f34885c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f34885c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.f34887e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f34888f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f34885c);
                        InterfaceC0403b interfaceC0403b2 = interfaceC0403b;
                        if (interfaceC0403b2 != null) {
                            interfaceC0403b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f34888f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f34885c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f34890h);
                }
                a(this.f34885c);
            }
        }
        return this.f34885c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f34889g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f34884b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f34885c;
            if (aVar2 != null) {
                this.f34884b = aVar2;
                return aVar2;
            }
            this.f34884b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f34884b.getParent()).removeView(this.f34884b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f34884b;
        if (aVar3 != null) {
            aVar3.a(this.f34888f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f34884b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f34890h);
            }
            a(this.f34884b);
        }
        return this.f34884b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f34883a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f34888f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.f34890h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f34888f;
                i = 2;
            } else {
                adTemplate = this.f34888f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.f34890h.setVideoSoundEnable(z);
        if (this.f34890h.isVideoSoundEnable()) {
            adTemplate = this.f34888f;
            i = 2;
        } else {
            adTemplate = this.f34888f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
