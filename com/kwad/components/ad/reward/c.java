package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class c {
    public final Set<com.kwad.components.ad.reward.e.m> on;

    /* loaded from: classes10.dex */
    public static class a {
        public static final c oq = new c((byte) 0);
    }

    public c() {
        this.on = new HashSet();
    }

    public static c fd() {
        return a.oq;
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable q qVar) {
        if (this.on.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.e.m mVar : this.on) {
            mVar.a(qVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.on.add(mVar);
        }
    }

    public final void c(@Nullable final q qVar) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.b(qVar);
            }
        });
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.on.remove(mVar);
    }
}
