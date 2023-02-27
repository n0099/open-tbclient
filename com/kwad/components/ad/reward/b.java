package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class b {
    public final Set<com.kwad.components.ad.reward.d.f> lt;

    /* loaded from: classes8.dex */
    public static class a {
        public static final b lx = new b((byte) 0);
    }

    public b() {
        this.lt = new HashSet();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
        if (this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.a(playableSource, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.bP();
        }
    }

    public static b eV() {
        return a.lx;
    }

    private void eX() {
        if (this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.bO();
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.f fVar) {
        if (fVar != null) {
            this.lt.add(fVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(com.kwad.components.ad.reward.d.f fVar) {
        this.lt.remove(fVar);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c(playableSource);
                }
            });
        }
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.d.j jVar) {
        if (isMainThread()) {
            b(playableSource, jVar);
        } else {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(playableSource, jVar);
                }
            });
        }
    }

    public final void eW() {
        if (isMainThread()) {
            eX();
        } else {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.eW();
                }
            });
        }
    }
}
