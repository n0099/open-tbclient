package com.kwad.components.core.j;

import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class a {
    public CopyOnWriteArrayList<b> Me = new CopyOnWriteArrayList<>();
    public volatile boolean Mf;

    /* loaded from: classes10.dex */
    public interface c {
        void bk();
    }

    /* renamed from: com.kwad.components.core.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0650a {
        public static final a Mg = new a();
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final c Mh;
        public boolean Mi;

        public b(c cVar) {
            this.Mh = cVar;
        }
    }

    public static a ow() {
        return C0650a.Mg;
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Mi;
    }

    public final void a(b bVar) {
        if (this.Me.contains(bVar)) {
            return;
        }
        if (!this.Mf) {
            this.Mf = true;
            bVar.Mi = true;
        }
        this.Me.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Mi) {
            bVar.Mi = false;
            this.Mf = false;
        }
        this.Me.remove(bVar);
        if (this.Me.size() == 0 || this.Mf) {
            return;
        }
        this.Me.get(0).Mi = true;
        this.Mf = true;
        this.Me.get(0).Mh.bk();
    }
}
