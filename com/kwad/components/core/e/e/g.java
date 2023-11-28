package com.kwad.components.core.e.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class g {
    public final List<f> Lo;

    /* loaded from: classes10.dex */
    public static class a {
        public static final g Lp = new g((byte) 0);
    }

    public g() {
        this.Lo = new CopyOnWriteArrayList();
    }

    public static g oh() {
        return a.Lp;
    }

    public final void oi() {
        for (f fVar : this.Lo) {
            fVar.show();
        }
    }

    public final void oj() {
        for (f fVar : this.Lo) {
            fVar.dismiss();
        }
    }

    public /* synthetic */ g(byte b) {
        this();
    }

    public final void a(f fVar) {
        this.Lo.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Lo.remove(fVar);
        }
    }
}
