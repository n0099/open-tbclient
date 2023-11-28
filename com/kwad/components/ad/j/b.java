package com.kwad.components.ad.j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class b extends a<k> {
    public com.kwad.components.core.video.b Hr;
    public boolean Hs;
    public k Ht;
    public DetailVideoView mDetailVideoView;

    public b(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.Hs = false;
        this.Ht = new l() { // from class: com.kwad.components.ad.j.b.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                if (!b.this.Hs) {
                    b.this.lZ();
                } else if (d.Bn()) {
                    b.this.lZ();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.Hr = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        lX();
    }

    private void lX() {
        this.Hr.c(this.Ht);
    }

    private void lY() {
        k kVar;
        com.kwad.components.core.video.b bVar = this.Hr;
        if (bVar != null && (kVar = this.Ht) != null) {
            bVar.d(kVar);
            this.Ht = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ() {
        com.kwad.components.core.o.a.pX().f(this.mAdTemplate, 21008);
        this.Hs = true;
    }

    @Override // com.kwad.components.ad.j.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.Hr;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.j.a
    public void pause() {
        this.Hr.pause();
    }

    @Override // com.kwad.components.ad.j.a
    @WorkerThread
    public void release() {
        super.release();
        this.Hs = false;
        lY();
        com.kwad.components.core.video.b bVar = this.Hr;
        if (bVar != null) {
            bVar.clear();
            this.Hr.release();
        }
    }

    @Override // com.kwad.components.ad.j.a
    public void resume() {
        this.Hr.resume();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.ad.j.a
    @MainThread
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void b(k kVar) {
        com.kwad.components.core.video.b bVar;
        if (kVar != null && (bVar = this.Hr) != null) {
            bVar.c(kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.ad.j.a
    @MainThread
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hr.d(kVar);
    }
}
