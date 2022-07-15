package com.kwad.sdk.h.kwai;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a {
    public final List<b> a = new ArrayList();

    public final void a(b bVar) {
        if (bVar != null) {
            this.a.add(bVar);
        }
    }

    public final void a(b bVar, int i) {
        if (bVar != null) {
            this.a.add(i, bVar);
        }
    }

    public final boolean a() {
        for (b bVar : this.a) {
            if (bVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.a.remove(bVar);
        }
    }
}
