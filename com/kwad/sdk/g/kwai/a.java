package com.kwad.sdk.g.kwai;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class a {
    public final List<b> amG = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.amG.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.amG.add(i, bVar);
        }
    }

    public final boolean bG() {
        for (b bVar : this.amG) {
            if (bVar.bG()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.amG.remove(bVar);
        }
    }
}
