package com.kwad.sdk.core.view;

import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class c {
    public List<b> aCE = new CopyOnWriteArrayList();

    public final void a(b bVar) {
        this.aCE.add(bVar);
    }

    public final void b(b bVar) {
        this.aCE.remove(bVar);
    }

    public final void j(View view2, boolean z) {
        for (b bVar : this.aCE) {
            bVar.i(view2, z);
        }
    }
}
