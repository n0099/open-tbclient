package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes5.dex */
public class f extends b implements a.b {
    public static long a = 1000;
    public c b;
    public AdTemplate c;
    @Nullable
    public a d;
    public int e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public int b;
        public boolean c;
        public boolean d;

        public a() {
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public void b(boolean z) {
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                return;
            }
            if (!this.c) {
                if (this.b == Integer.MIN_VALUE) {
                    this.b = f.this.e;
                }
                if (this.b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", f.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.b);
                f.this.b(this.b);
                this.b = this.b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        c cVar = this.b;
        com.kwad.sdk.d.a.b bVar = cVar.e;
        if (bVar == null) {
            return;
        }
        if (i != 0) {
            bVar.a(true, i);
        } else if (cVar.d()) {
        } else {
            this.b.a(q(), this.c);
            r();
            c cVar2 = this.b;
            cVar2.a(true, cVar2.i);
        }
    }

    private void r() {
        com.kwad.sdk.core.video.videoview.b bVar = this.b.i;
        if (bVar != null) {
            bVar.k();
        }
        this.b.c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.b.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) p();
        this.b = cVar;
        AdTemplate adTemplate = cVar.a;
        this.c = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long j2 = j.adInsertScreenInfo.autoCloseTime;
        if (j2 > 0) {
            this.e = (int) Math.min(com.kwad.sdk.core.config.b.a(j), j2);
        } else {
            this.e = com.kwad.sdk.core.config.b.a(j);
        }
        com.kwad.sdk.d.a.b bVar = this.b.e;
        if (bVar != null) {
            bVar.a(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j)) {
            a aVar = new a();
            this.d = aVar;
            ax.a(aVar, null, 1000L);
            return;
        }
        this.e = (int) Math.min(this.e, com.kwad.sdk.core.response.a.a.b(j));
        this.d = null;
        this.b.a(this);
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j) {
        b(this.e - ((int) (j / 1000)));
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
        this.b.b(this);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(true);
            ax.b(this.d);
            this.d = null;
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
        this.b.a(q(), this.c);
        r();
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        a aVar = this.d;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        a aVar = this.d;
        if (aVar != null) {
            aVar.b(true);
        }
    }
}
