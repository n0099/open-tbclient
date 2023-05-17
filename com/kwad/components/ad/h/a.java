package com.kwad.components.ad.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public class a {
    public b BL;
    public boolean BM = false;
    public g BN = new h() { // from class: com.kwad.components.ad.h.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            if (!a.this.BM) {
                a.this.kR();
            } else if (d.sv()) {
                a.this.kR();
            }
        }
    };
    @NonNull
    public AdTemplate mAdTemplate;
    public DetailVideoView mDetailVideoView;

    public a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.mDetailVideoView = detailVideoView;
        this.BL = new b(this.mDetailVideoView);
        kP();
    }

    private void kP() {
        this.BL.c(this.BN);
    }

    private void kQ() {
        g gVar;
        b bVar = this.BL;
        if (bVar == null || (gVar = this.BN) == null) {
            return;
        }
        bVar.d(gVar);
        this.BN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR() {
        com.kwad.components.core.j.a.og().e(this.mAdTemplate, 21008);
        this.BM = true;
    }

    @WorkerThread
    public void release() {
        this.BM = false;
        kQ();
    }

    @WorkerThread
    public void releaseSync() {
        this.BM = false;
        kQ();
    }
}
