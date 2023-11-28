package com.kwad.components.ad.j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public abstract class a<L extends h> {
    public AdTemplate mAdTemplate;

    @MainThread
    public abstract void a(L l);

    @MainThread
    public abstract void b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean jF() {
        return false;
    }

    public abstract void pause();

    @WorkerThread
    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
