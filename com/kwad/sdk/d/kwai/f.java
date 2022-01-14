package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class f extends b implements a.b {
    public static long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public c f56645b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56646c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f56647d;

    /* renamed from: e  reason: collision with root package name */
    public int f56648e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f56649b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56650c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56651d;

        public a() {
            this.f56649b = Integer.MIN_VALUE;
            this.f56650c = false;
            this.f56651d = false;
        }

        public void a(boolean z) {
            this.f56651d = z;
        }

        public void b(boolean z) {
            this.f56650c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f56651d) {
                return;
            }
            if (!this.f56650c) {
                if (this.f56649b == Integer.MIN_VALUE) {
                    this.f56649b = f.this.f56648e;
                }
                if (this.f56649b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f56649b);
                f.this.b(this.f56649b);
                this.f56649b = this.f56649b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar = this.f56645b;
        com.kwad.sdk.d.a.b bVar = cVar.f56617e;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f56645b.a(q(), this.f56646c);
            r();
            c cVar2 = this.f56645b;
            cVar2.a(true, cVar2.f56621i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f56645b.f56621i;
        if (bVar != null) {
            bVar.k();
        }
        this.f56645b.f56615c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f56645b.f56614b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f56645b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f56646c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j3 = j2.adInsertScreenInfo.autoCloseTime;
        if (j3 > 0) {
            this.f56648e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
        } else {
            this.f56648e = com.kwad.sdk.core.config.b.a(j2);
        }
        com.kwad.sdk.d.a.b bVar = this.f56645b.f56617e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            a aVar = new a();
            this.f56647d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f56648e = (int) Math.min(this.f56648e, com.kwad.sdk.core.response.a.a.b(j2));
        this.f56647d = null;
        this.f56645b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        b(this.f56648e - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f56645b.b(this);
        a aVar = this.f56647d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f56647d);
            this.f56647d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void e() {
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void f() {
        this.f56645b.a(q(), this.f56646c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f56647d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f56647d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
