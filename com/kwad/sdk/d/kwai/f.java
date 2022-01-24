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
    public c f56690b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56691c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f56692d;

    /* renamed from: e  reason: collision with root package name */
    public int f56693e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f56694b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56695c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56696d;

        public a() {
            this.f56694b = Integer.MIN_VALUE;
            this.f56695c = false;
            this.f56696d = false;
        }

        public void a(boolean z) {
            this.f56696d = z;
        }

        public void b(boolean z) {
            this.f56695c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f56696d) {
                return;
            }
            if (!this.f56695c) {
                if (this.f56694b == Integer.MIN_VALUE) {
                    this.f56694b = f.this.f56693e;
                }
                if (this.f56694b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f56694b);
                f.this.b(this.f56694b);
                this.f56694b = this.f56694b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar = this.f56690b;
        com.kwad.sdk.d.a.b bVar = cVar.f56662e;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f56690b.a(q(), this.f56691c);
            r();
            c cVar2 = this.f56690b;
            cVar2.a(true, cVar2.f56666i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f56690b.f56666i;
        if (bVar != null) {
            bVar.k();
        }
        this.f56690b.f56660c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f56690b.f56659b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f56690b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f56691c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j3 = j2.adInsertScreenInfo.autoCloseTime;
        if (j3 > 0) {
            this.f56693e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
        } else {
            this.f56693e = com.kwad.sdk.core.config.b.a(j2);
        }
        com.kwad.sdk.d.a.b bVar = this.f56690b.f56662e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            a aVar = new a();
            this.f56692d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f56693e = (int) Math.min(this.f56693e, com.kwad.sdk.core.response.a.a.b(j2));
        this.f56692d = null;
        this.f56690b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        b(this.f56693e - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f56690b.b(this);
        a aVar = this.f56692d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f56692d);
            this.f56692d = null;
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
        this.f56690b.a(q(), this.f56691c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f56692d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f56692d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
