package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.j.a<h> implements g.a {
    public com.kwad.components.core.g.c xJ;

    @Override // com.kwad.components.ad.reward.g.a
    public final void fS() {
    }

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c();
        this.xJ = cVar;
        cVar.y(M);
    }

    public final FrameLayout O(Context context) {
        FrameLayout imagePlayerView = this.xJ.getImagePlayerView(context);
        this.xJ.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.j.a
    public final void a(h hVar) {
        this.xJ.d(hVar);
    }

    @Override // com.kwad.components.ad.j.a
    public final void b(h hVar) {
        this.xJ.c(hVar);
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fT() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        this.xJ.destroy();
    }

    @Override // com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        return this.xJ.getPlayDuration();
    }

    public final void jG() {
        this.xJ.setURLs(com.kwad.sdk.core.response.b.a.ba(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)));
        this.xJ.play();
    }

    @Override // com.kwad.components.ad.j.a
    public final void pause() {
        this.xJ.pause();
    }

    @Override // com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        this.xJ.destroy();
    }

    @Override // com.kwad.components.ad.j.a
    public final void resume() {
        this.xJ.resume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void skipToEnd() {
        this.xJ.skipToEnd();
    }
}
