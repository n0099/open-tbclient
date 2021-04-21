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
    public KsFeedAd.AdInteractionListener f35268a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35269b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35270c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35271d;

    /* renamed from: e  reason: collision with root package name */
    public int f35272e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35273f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35274g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f35275h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35280a;

        /* renamed from: b  reason: collision with root package name */
        public int f35281b;

        public a(int i) {
            this.f35280a = i;
        }

        public int a() {
            return this.f35281b;
        }

        public boolean b() {
            int i = this.f35281b + 1;
            this.f35281b = i;
            return i == this.f35280a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0421b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.f35275h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f35273f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f35274g = c.j(adTemplate);
        this.f35271d = z;
        this.f35272e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f35271d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f35273f.type), com.kwad.sdk.core.response.b.a.L(this.f35274g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f35275h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0422a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0422a
            public void a() {
                if (b.this.f35268a != null) {
                    b.this.f35268a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0422a
            public void b() {
                if (b.this.f35268a != null) {
                    b.this.f35268a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0422a
            public void c() {
                if (b.this.f35268a != null) {
                    b.this.f35268a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f35274g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0421b interfaceC0421b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0421b.a();
        }
        this.f35270c = a(context);
        this.f35270c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f35270c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.f35272e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f35273f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f35270c);
                        InterfaceC0421b interfaceC0421b2 = interfaceC0421b;
                        if (interfaceC0421b2 != null) {
                            interfaceC0421b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f35273f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f35270c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f35275h);
                }
                a(this.f35270c);
            }
        }
        return this.f35270c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f35274g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f35269b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f35270c;
            if (aVar2 != null) {
                this.f35269b = aVar2;
                return aVar2;
            }
            this.f35269b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f35269b.getParent()).removeView(this.f35269b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f35269b;
        if (aVar3 != null) {
            aVar3.a(this.f35273f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f35269b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f35275h);
            }
            a(this.f35269b);
        }
        return this.f35269b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f35268a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f35273f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.f35275h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f35273f;
                i = 2;
            } else {
                adTemplate = this.f35273f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.f35275h.setVideoSoundEnable(z);
        if (this.f35275h.isVideoSoundEnable()) {
            adTemplate = this.f35273f;
            i = 2;
        } else {
            adTemplate = this.f35273f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
