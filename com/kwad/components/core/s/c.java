package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class c {
    public Set<b> SQ;

    /* loaded from: classes10.dex */
    public interface b {
        void onPageClose();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static c SR = new c((byte) 0);
    }

    public c() {
        this.SQ = new HashSet();
    }

    public static c qM() {
        return a.SR;
    }

    public final void qN() {
        if (this.SQ.size() == 0) {
            return;
        }
        for (b bVar : this.SQ) {
            bVar.onPageClose();
        }
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public final void a(b bVar) {
        this.SQ.add(bVar);
    }

    public final void b(b bVar) {
        this.SQ.remove(bVar);
    }
}
