package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class d {
    public final Set<com.kwad.components.ad.reward.d.i> lB;

    /* loaded from: classes8.dex */
    public static class a {
        public static final d lE = new d((byte) 0);
    }

    public d() {
        this.lB = new HashSet();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable com.kwad.components.core.webview.b.a.n nVar) {
        if (this.lB.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.i iVar : this.lB) {
            iVar.a(nVar);
        }
    }

    public static d fc() {
        return a.lE;
    }

    public final void a(com.kwad.components.ad.reward.d.i iVar) {
        if (iVar != null) {
            this.lB.add(iVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.i iVar) {
        this.lB.remove(iVar);
    }

    public final void c(@Nullable final com.kwad.components.core.webview.b.a.n nVar) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(nVar);
            }
        });
    }
}
