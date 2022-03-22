package com.kwad.sdk.h.kwai;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public final List<b> a = new ArrayList();

    public void a(b bVar) {
        if (bVar != null) {
            this.a.add(bVar);
        }
    }

    public void a(b bVar, int i) {
        if (bVar != null) {
            this.a.add(i, bVar);
        }
    }

    public boolean a() {
        for (b bVar : this.a) {
            if (bVar.a_()) {
                return true;
            }
        }
        return false;
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.a.remove(bVar);
        }
    }
}
