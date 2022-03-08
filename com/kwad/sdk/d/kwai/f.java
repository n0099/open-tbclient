package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public class f extends b implements a.b {
    public static long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public c f55207b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f55208c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f55209d;

    /* renamed from: e  reason: collision with root package name */
    public int f55210e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f55211b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55212c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55213d;

        public a() {
            this.f55211b = Integer.MIN_VALUE;
            this.f55212c = false;
            this.f55213d = false;
        }

        public void a(boolean z) {
            this.f55213d = z;
        }

        public void b(boolean z) {
            this.f55212c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f55213d) {
                return;
            }
            if (!this.f55212c) {
                if (this.f55211b == Integer.MIN_VALUE) {
                    this.f55211b = f.this.f55210e;
                }
                if (this.f55211b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f55211b);
                f.this.b(this.f55211b);
                this.f55211b = this.f55211b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar = this.f55207b;
        com.kwad.sdk.d.a.b bVar = cVar.f55179e;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f55207b.a(q(), this.f55208c);
            r();
            c cVar2 = this.f55207b;
            cVar2.a(true, cVar2.f55183i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f55207b.f55183i;
        if (bVar != null) {
            bVar.k();
        }
        this.f55207b.f55177c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f55207b.f55176b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f55207b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f55208c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j3 = j2.adInsertScreenInfo.autoCloseTime;
        if (j3 > 0) {
            this.f55210e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
        } else {
            this.f55210e = com.kwad.sdk.core.config.b.a(j2);
        }
        com.kwad.sdk.d.a.b bVar = this.f55207b.f55179e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            a aVar = new a();
            this.f55209d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f55210e = (int) Math.min(this.f55210e, com.kwad.sdk.core.response.a.a.b(j2));
        this.f55209d = null;
        this.f55207b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        b(this.f55210e - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f55207b.b(this);
        a aVar = this.f55209d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f55209d);
            this.f55209d = null;
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
        this.f55207b.a(q(), this.f55208c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f55209d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f55209d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
