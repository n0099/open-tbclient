package com.kwad.sdk.l.a;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public final List<b> aLv = new ArrayList();

    public final boolean onBackPressed() {
        for (b bVar : this.aLv) {
            if (bVar.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aLv.add(bVar);
        }
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aLv.remove(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.aLv.add(i, bVar);
        }
    }
}
