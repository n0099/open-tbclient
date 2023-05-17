package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class c {
    public final Set<com.kwad.components.ad.reward.d.h> ly;

    /* loaded from: classes9.dex */
    public static class a {
        public static final c lA = new c((byte) 0);
    }

    public c() {
        this.ly = new HashSet();
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c eZ() {
        return a.lA;
    }

    private void fa() {
        if (this.ly.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.h hVar : this.ly) {
            hVar.onRewardVerify();
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.h hVar) {
        if (hVar != null) {
            this.ly.add(hVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.h hVar) {
        this.ly.remove(hVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fa();
        } else {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.notifyRewardVerify();
                }
            });
        }
    }
}
