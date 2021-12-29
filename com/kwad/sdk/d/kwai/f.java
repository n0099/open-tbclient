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
    public c f58863b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f58864c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f58865d;

    /* renamed from: e  reason: collision with root package name */
    public int f58866e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f58867b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58868c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f58869d;

        public a() {
            this.f58867b = Integer.MIN_VALUE;
            this.f58868c = false;
            this.f58869d = false;
        }

        public void a(boolean z) {
            this.f58869d = z;
        }

        public void b(boolean z) {
            this.f58868c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f58869d) {
                return;
            }
            if (!this.f58868c) {
                if (this.f58867b == Integer.MIN_VALUE) {
                    this.f58867b = f.this.f58866e;
                }
                if (this.f58867b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f58867b);
                f.this.b(this.f58867b);
                this.f58867b = this.f58867b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar = this.f58863b;
        com.kwad.sdk.d.a.b bVar = cVar.f58833e;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f58863b.a(q(), this.f58864c);
            r();
            c cVar2 = this.f58863b;
            cVar2.a(true, cVar2.f58837i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.f58863b.f58837i;
        if (bVar != null) {
            bVar.k();
        }
        this.f58863b.f58831c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f58863b.f58830b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.f58863b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.f58864c = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j3 = j2.adInsertScreenInfo.autoCloseTime;
        if (j3 > 0) {
            this.f58866e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
        } else {
            this.f58866e = com.kwad.sdk.core.config.b.a(j2);
        }
        com.kwad.sdk.d.a.b bVar = this.f58863b.f58833e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            a aVar = new a();
            this.f58865d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.f58866e = (int) Math.min(this.f58866e, com.kwad.sdk.core.response.a.a.b(j2));
        this.f58865d = null;
        this.f58863b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        b(this.f58866e - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.f58863b.b(this);
        a aVar = this.f58865d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.f58865d);
            this.f58865d = null;
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
        this.f58863b.a(q(), this.f58864c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.f58865d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.f58865d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
