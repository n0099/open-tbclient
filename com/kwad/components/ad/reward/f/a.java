package com.kwad.components.ad.reward.f;

import androidx.annotation.NonNull;
import com.kwad.components.core.video.g;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.j.a<g> {
    public IAdLivePlayModule eV;
    public List<g> rA;
    public long rB;
    public AdLivePlayStateListener rC;

    public a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.rA = new CopyOnWriteArrayList();
        this.rC = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(g gVar) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: c */
                    public void accept(g gVar) {
                        gVar.onMediaPlayProgress(a.this.rB, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    public static void c(g gVar) {
                        gVar.onMediaPlayCompleted();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    public static void c(g gVar) {
                        gVar.onLivePlayEnd();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    public static void c(g gVar) {
                        gVar.onMediaPlayPaused();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    public static void c(g gVar) {
                        gVar.onLivePlayResume();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    public static void c(g gVar) {
                        gVar.onMediaPlayStart();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    public static void c(g gVar) {
                        gVar.onMediaPrepared();
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }
        };
        this.eV = iAdLivePlayModule;
        this.rB = com.kwad.sdk.core.response.b.a.ag(e.dP(adTemplate));
        this.eV.registerAdLivePlayStateListener(this.rC);
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.eV.setAudioEnabled(z, z2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.j.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(g gVar) {
        if (gVar != null) {
            this.rA.remove(gVar);
        }
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.eV.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.eV.removeInterceptor(onAdLiveResumeInterceptor);
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.eV.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.j.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(g gVar) {
        if (gVar != null) {
            this.rA.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.g.a<g> aVar) {
        if (aVar != null) {
            for (g gVar : this.rA) {
                aVar.accept(gVar);
            }
        }
    }

    private void gS() {
        try {
            this.rA.clear();
            this.eV.unRegisterAdLivePlayStateListener(this.rC);
            this.eV.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.eV.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        return this.eV.getPlayDuration();
    }

    public final void onPause() {
        this.eV.onPause();
    }

    public final void onResume() {
        this.eV.onResume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void pause() {
        this.eV.pause();
    }

    @Override // com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        gS();
    }

    @Override // com.kwad.components.ad.j.a
    public final void resume() {
        this.eV.resume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void skipToEnd() {
        this.eV.skipToEnd();
    }
}
