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
    public KsFeedAd.AdInteractionListener f35173a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35174b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35175c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35176d;

    /* renamed from: e  reason: collision with root package name */
    public int f35177e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35178f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35179g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f35180h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35185a;

        /* renamed from: b  reason: collision with root package name */
        public int f35186b;

        public a(int i) {
            this.f35185a = i;
        }

        public int a() {
            return this.f35186b;
        }

        public boolean b() {
            int i = this.f35186b + 1;
            this.f35186b = i;
            return i == this.f35185a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0418b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.f35180h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f35178f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f35179g = c.j(adTemplate);
        this.f35176d = z;
        this.f35177e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.f35176d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f35178f.type), com.kwad.sdk.core.response.b.a.L(this.f35179g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.f35180h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0419a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0419a
            public void a() {
                if (b.this.f35173a != null) {
                    b.this.f35173a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0419a
            public void b() {
                if (b.this.f35173a != null) {
                    b.this.f35173a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0419a
            public void c() {
                if (b.this.f35173a != null) {
                    b.this.f35173a.onDislikeClicked();
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
        return !TextUtils.isEmpty(this.f35179g.adStyleInfo.feedAdInfo.templateConfig);
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
    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC0418b interfaceC0418b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC0418b.a();
        }
        this.f35175c = a(context);
        this.f35175c.setMargin(ao.a(context, 16.0f));
        com.kwad.sdk.feed.widget.base.a aVar = this.f35175c;
        if (aVar != null) {
            if (aVar instanceof l) {
                l lVar = (l) aVar;
                int i = this.f35177e;
                if (i > 0) {
                    lVar.setWidth(i);
                }
                lVar.a(this.f35178f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b bVar = b.this;
                        bVar.a(bVar.f35175c);
                        InterfaceC0418b interfaceC0418b2 = interfaceC0418b;
                        if (interfaceC0418b2 != null) {
                            interfaceC0418b2.a();
                        }
                    }
                });
            } else {
                aVar.a(this.f35178f);
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f35175c;
                if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f35180h);
                }
                a(this.f35175c);
            }
        }
        return this.f35175c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f35179g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        com.kwad.sdk.feed.widget.base.a aVar = this.f35174b;
        if (aVar == null) {
            com.kwad.sdk.feed.widget.base.a aVar2 = this.f35175c;
            if (aVar2 != null) {
                this.f35174b = aVar2;
                return aVar2;
            }
            this.f35174b = a(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f35174b.getParent()).removeView(this.f35174b);
        }
        com.kwad.sdk.feed.widget.base.a aVar3 = this.f35174b;
        if (aVar3 != null) {
            aVar3.a(this.f35178f);
            com.kwad.sdk.feed.widget.base.a aVar4 = this.f35174b;
            if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f35180h);
            }
            a(this.f35174b);
        }
        return this.f35174b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f35173a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f35178f;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig != null) {
            this.f35180h = ksAdVideoPlayConfig;
            if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
                adTemplate = this.f35178f;
                i = 2;
            } else {
                adTemplate = this.f35178f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.f35180h.setVideoSoundEnable(z);
        if (this.f35180h.isVideoSoundEnable()) {
            adTemplate = this.f35178f;
            i = 2;
        } else {
            adTemplate = this.f35178f;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
