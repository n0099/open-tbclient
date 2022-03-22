package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes7.dex */
public class f extends b implements a.b {
    public static long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public c f40274b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f40275c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f40276d;

    /* renamed from: e  reason: collision with root package name */
    public int f40277e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f40278b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40279c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40280d;

        public a() {
            this.f40278b = Integer.MIN_VALUE;
            this.f40279c = false;
            this.f40280d = false;
        }

        public void a(boolean z) {
            this.f40280d = z;
        }

        public void b(boolean z) {
            this.f40279c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f40280d) {
                return;
            }
            if (!this.f40279c) {
                if (this.f40278b == Integer.MIN_VALUE) {
                    this.f40278b = f.this.f40277e;
                }
                if (this.f40278b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f40278b);
                f.this.b(this.f40278b);
                this.f40278b = this.f40278b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        c cVar = this.f40274b;
        com.kwad.sdk.d.a.b bVar = cVar.f40250e;
        if (bVar == null) {
            return;
        }
        if (i != 0) {
            bVar.a(true, i);
        } else if (cVar.d()) {
        } else {
            this.f40274b.a(q(), this.f40275c);
            r();
            c cVar2 = this.f40274b;
            cVar2.a(true, cVar2.i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f40274b.i;
        if (bVar != null) {
            bVar.k();
        }
        this.f40274b.f40248c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f40274b.f40247b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f40274b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f40275c = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j2 = j.adInsertScreenInfo.autoCloseTime;
        if (j2 > 0) {
            this.f40277e = (int) Math.min(com.kwad.sdk.core.config.b.a(j), j2);
        } else {
            this.f40277e = com.kwad.sdk.core.config.b.a(j);
        }
        com.kwad.sdk.d.a.b bVar = this.f40274b.f40250e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j)) {
            a aVar = new a();
            this.f40276d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f40277e = (int) Math.min(this.f40277e, com.kwad.sdk.core.response.a.a.b(j));
        this.f40276d = null;
        this.f40274b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j) {
        b(this.f40277e - ((int) (j / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f40274b.b(this);
        a aVar = this.f40276d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f40276d);
            this.f40276d = null;
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
        this.f40274b.a(q(), this.f40275c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f40276d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f40276d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
