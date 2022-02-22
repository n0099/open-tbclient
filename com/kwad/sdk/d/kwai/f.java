package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes4.dex */
public class f extends b implements a.b {
    public static long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public c f56857b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56858c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f56859d;

    /* renamed from: e  reason: collision with root package name */
    public int f56860e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f56861b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56862c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56863d;

        public a() {
            this.f56861b = Integer.MIN_VALUE;
            this.f56862c = false;
            this.f56863d = false;
        }

        public void a(boolean z) {
            this.f56863d = z;
        }

        public void b(boolean z) {
            this.f56862c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f56863d) {
                return;
            }
            if (!this.f56862c) {
                if (this.f56861b == Integer.MIN_VALUE) {
                    this.f56861b = f.this.f56860e;
                }
                if (this.f56861b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f56861b);
                f.this.b(this.f56861b);
                this.f56861b = this.f56861b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar = this.f56857b;
        com.kwad.sdk.d.a.b bVar = cVar.f56829e;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f56857b.a(q(), this.f56858c);
            r();
            c cVar2 = this.f56857b;
            cVar2.a(true, cVar2.f56833i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f56857b.f56833i;
        if (bVar != null) {
            bVar.k();
        }
        this.f56857b.f56827c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f56857b.f56826b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f56857b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f56858c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j3 = j2.adInsertScreenInfo.autoCloseTime;
        if (j3 > 0) {
            this.f56860e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
        } else {
            this.f56860e = com.kwad.sdk.core.config.b.a(j2);
        }
        com.kwad.sdk.d.a.b bVar = this.f56857b.f56829e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            a aVar = new a();
            this.f56859d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f56860e = (int) Math.min(this.f56860e, com.kwad.sdk.core.response.a.a.b(j2));
        this.f56859d = null;
        this.f56857b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        b(this.f56860e - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f56857b.b(this);
        a aVar = this.f56859d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f56859d);
            this.f56859d = null;
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
        this.f56857b.a(q(), this.f56858c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f56859d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f56859d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
