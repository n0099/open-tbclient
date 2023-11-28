package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class e {
    public g qn;
    @Nullable
    public com.kwad.components.ad.reward.f.a xS;
    @Nullable
    public d xT;
    @Nullable
    public b xU;
    @NonNull
    public com.kwad.components.ad.j.a xV;
    public int xR = 0;
    public int xW = 0;
    public List<l> xX = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.qn = gVar;
        this.xV = new a(gVar.mAdTemplate);
    }

    public final void a(@Nullable l lVar) {
        if (jJ().jF()) {
            this.xX.add(lVar);
        } else {
            jJ().b(lVar);
        }
    }

    public final void b(@Nullable l lVar) {
        jJ().a(lVar);
        if (lVar != null) {
            this.xX.remove(lVar);
        }
    }

    private com.kwad.components.ad.j.a jJ() {
        return this.xV;
    }

    public final long getPlayDuration() {
        return jJ().getPlayDuration();
    }

    public final void jG() {
        d dVar = this.xT;
        if (dVar != null) {
            dVar.jG();
        } else {
            b bVar = this.xU;
            if (bVar != null) {
                bVar.jG();
            }
        }
        this.qn.fx();
    }

    public final void jH() {
        d dVar = this.xT;
        if (dVar != null) {
            dVar.jH();
        }
    }

    public final boolean jK() {
        if (this.xS != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a jL() {
        return this.xS;
    }

    @Nullable
    public final b jM() {
        return this.xU;
    }

    public final void pause() {
        jJ().pause();
    }

    public final void release() {
        jJ().release();
    }

    public final void resume() {
        int i;
        boolean z;
        jJ().resume();
        com.kwad.components.ad.reward.f.a aVar = this.xS;
        if (aVar != null && (i = this.xW) > 0) {
            if (i == 2) {
                z = true;
            } else {
                z = false;
            }
            aVar.setAudioEnabled(z, false);
        }
    }

    public final void skipToEnd() {
        jJ().skipToEnd();
    }

    public final void a(int i, com.kwad.components.ad.j.a aVar) {
        this.xR = i;
        if (i == 1) {
            this.xT = (d) aVar;
        } else if (i == 2) {
            this.xS = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i == 3) {
            this.xU = (b) aVar;
        }
        this.xV = aVar;
        for (l lVar : this.xX) {
            this.xV.b(lVar);
        }
        this.xX.clear();
    }

    public final void a(h.a aVar) {
        d dVar = this.xT;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public final void b(h.a aVar) {
        d dVar = this.xT;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        this.xW = i;
        jJ().setAudioEnabled(z, z2);
    }
}
