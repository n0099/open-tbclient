package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class c {
    @NonNull
    public List<b> Mb = new CopyOnWriteArrayList();
    public boolean Mc = false;
    public boolean Md = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mb.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mb.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.Md);
        if (this.Md) {
            return;
        }
        for (b bVar : this.Mb) {
            bVar.c(aVar);
        }
        this.Md = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.Mc);
        if (this.Mc) {
            return;
        }
        for (b bVar : this.Mb) {
            bVar.d(aVar);
        }
        this.Mc = true;
    }
}
