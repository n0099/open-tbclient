package com.kwad.components.core.m;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class d {
    public Set<b> IT;

    /* loaded from: classes9.dex */
    public static class a {
        public static d IU = new d((byte) 0);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onPageClose();
    }

    public d() {
        this.IT = new HashSet();
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public static d oy() {
        return a.IU;
    }

    public final void a(b bVar) {
        this.IT.add(bVar);
    }

    public final void b(b bVar) {
        this.IT.remove(bVar);
    }

    public final void oz() {
        if (this.IT.size() == 0) {
            return;
        }
        for (b bVar : this.IT) {
            bVar.onPageClose();
        }
    }
}
