package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class a {
    public final Set<com.kwad.components.ad.reward.e.j> of;

    /* renamed from: com.kwad.components.ad.reward.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0607a {
        public static final a oj = new a((byte) 0);
    }

    public a() {
        this.of = new HashSet();
    }

    public static a eW() {
        return C0607a.oj;
    }

    private void eY() {
        if (this.of.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.of) {
            jVar.bY();
        }
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void eX() {
        if (isMainThread()) {
            eY();
        } else {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.eX();
                }
            });
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.of.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.of) {
            jVar.bZ();
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.of.add(jVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.of.remove(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.of.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.j jVar : this.of) {
            jVar.a(playableSource, nVar);
        }
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
