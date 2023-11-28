package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class b {
    public final Set<com.kwad.components.ad.reward.e.l> ok;

    /* loaded from: classes10.dex */
    public static class a {
        public static final b om = new b((byte) 0);
    }

    public b() {
        this.ok = new HashSet();
    }

    public static b fa() {
        return a.om;
    }

    private void fb() {
        if (this.ok.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.l lVar : this.ok) {
            lVar.onRewardVerify();
        }
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fb();
        } else {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.ok.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.ok.remove(lVar);
    }
}
