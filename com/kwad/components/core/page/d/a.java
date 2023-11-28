package com.kwad.components.core.page.d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a implements com.kwad.components.core.l.a.a {
    public b Hr;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public boolean nn;
    public l np;
    public String xK;
    public boolean xM = false;
    public final List<h.a> xN = new ArrayList();
    public OfflineOnAudioConflictListener xP = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Hr != null) {
                a.this.Hr.setAudioEnabled(false);
            }
            synchronized (a.this.xN) {
                for (h.a aVar : a.this.xN) {
                    aVar.onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.xN) {
                for (h.a aVar : a.this.xN) {
                    aVar.onAudioBeReleased();
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.xK = j.f(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.Hr = new b(detailVideoView, adTemplate);
        aL();
        l lVar = new l() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.pX().c(adTemplate, i, i2);
            }
        };
        this.np = lVar;
        this.Hr.c(lVar);
        this.Hr.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                a.this.Hr.start();
            }
        });
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xP);
    }

    @Override // com.kwad.components.core.l.a.a
    public final void c(com.kwad.components.core.proxy.c cVar) {
        resume();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void d(com.kwad.components.core.proxy.c cVar) {
        pause();
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xM = true;
        return true;
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.nn = z;
        this.Hr.setAudioEnabled(z);
    }

    private void aL() {
        this.Hr.a(new b.a(this.mAdTemplate).cD(this.xK).cE(com.kwad.sdk.core.response.b.h.b(e.dQ(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate)).Ah(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hr.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Hr.pause();
    }

    private void resume() {
        this.Hr.resume();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fN() {
        this.xM = false;
        if (this.Hr.rf() == null) {
            aL();
        }
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fO() {
        this.xM = false;
        com.kwad.components.core.video.b bVar = this.Hr;
        if (bVar != null) {
            bVar.d(this.np);
            this.Hr.release();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.Hr;
        if (bVar != null) {
            bVar.clear();
            this.Hr.release();
        }
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xP);
    }

    @MainThread
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hr.c(kVar);
    }

    @MainThread
    public final void b(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hr.d(kVar);
    }
}
