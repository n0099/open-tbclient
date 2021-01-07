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
/* loaded from: classes5.dex */
public class b extends AbstractKsFeedAd {

    /* renamed from: a  reason: collision with root package name */
    private KsFeedAd.AdInteractionListener f10144a;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.feed.widget.base.a f10145b;
    private com.kwad.sdk.feed.widget.base.a c;
    private boolean d;
    private int e;
    @NonNull
    private AdTemplate f;
    private AdInfo g;
    private KsAdVideoPlayConfig h;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f10150a;

        /* renamed from: b  reason: collision with root package name */
        int f10151b;

        public a(int i) {
            this.f10150a = i;
        }

        public int a() {
            return this.f10151b;
        }

        public boolean b() {
            this.f10151b++;
            return this.f10151b == this.f10150a;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1130b {
        void a();
    }

    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
    }

    public b(@NonNull AdTemplate adTemplate, int i, boolean z) {
        this.h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f = adTemplate;
        this.f.mInitVoiceStatus = 1;
        this.g = c.j(adTemplate);
        this.d = z;
        this.e = i;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        if (!com.kwad.sdk.core.config.c.c(context).exists() || !a() || !this.d) {
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f.type), com.kwad.sdk.core.response.b.a.L(this.g));
        }
        l lVar = new l(context);
        lVar.setVideoPlayConfig(this.h);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.feed.widget.base.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC1131a() { // from class: com.kwad.sdk.feed.b.2
            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1131a
            public void a() {
                if (b.this.f10144a != null) {
                    b.this.f10144a.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1131a
            public void b() {
                if (b.this.f10144a != null) {
                    b.this.f10144a.onAdShow();
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC1131a
            public void c() {
                if (b.this.f10144a != null) {
                    b.this.f10144a.onDislikeClicked();
                    try {
                        if (aVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) aVar.getParent()).removeView(aVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        });
    }

    private boolean a() {
        return !TextUtils.isEmpty(this.g.adStyleInfo.feedAdInfo.templateConfig);
    }

    public com.kwad.sdk.feed.widget.base.a a(final InterfaceC1130b interfaceC1130b) {
        Context context = KsAdSDK.getContext();
        if (context == null) {
            interfaceC1130b.a();
        }
        this.c = a(context);
        this.c.setMargin(ao.a(context, 16.0f));
        if (this.c != null) {
            if (this.c instanceof l) {
                l lVar = (l) this.c;
                if (this.e > 0) {
                    lVar.setWidth(this.e);
                }
                lVar.a(this.f, new l.a() { // from class: com.kwad.sdk.feed.b.1
                    @Override // com.kwad.sdk.feed.widget.l.a
                    public void a() {
                        b.this.a(b.this.c);
                        if (interfaceC1130b != null) {
                            interfaceC1130b.a();
                        }
                    }
                });
            } else {
                this.c.a(this.f);
                if (this.c instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) this.c).a(this.h);
                }
                a(this.c);
                if (interfaceC1130b != null) {
                    interfaceC1130b.a();
                }
            }
        } else if (interfaceC1130b != null) {
            interfaceC1130b.a();
        }
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.g);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        if (this.f10145b == null) {
            if (this.c != null) {
                this.f10145b = this.c;
                return this.f10145b;
            }
            this.f10145b = a(context);
        } else if (this.f10145b.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f10145b.getParent()).removeView(this.f10145b);
        }
        if (this.f10145b != null) {
            this.f10145b.a(this.f);
            if (this.f10145b instanceof com.kwad.sdk.feed.widget.a) {
                ((com.kwad.sdk.feed.widget.a) this.f10145b).a(this.h);
            }
            a(this.f10145b);
        }
        return this.f10145b;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.f10144a = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i) {
        this.f.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(this.f);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig != null) {
            this.h = ksAdVideoPlayConfig;
            if (this.h.isVideoSoundEnable()) {
                this.f.mInitVoiceStatus = 2;
            } else {
                this.f.mInitVoiceStatus = 1;
            }
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        this.h.setVideoSoundEnable(z);
        if (this.h.isVideoSoundEnable()) {
            this.f.mInitVoiceStatus = 2;
        } else {
            this.f.mInitVoiceStatus = 1;
        }
    }
}
