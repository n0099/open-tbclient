package com.kwad.sdk.core.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class h {
    public static volatile h atH;
    public List<a> atG = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(f fVar, int i);
    }

    public static h CC() {
        if (atH == null) {
            synchronized (h.class) {
                if (atH == null) {
                    atH = new h();
                }
            }
        }
        return atH;
    }

    public final void a(a aVar) {
        this.atG.add(aVar);
    }

    public final void b(f fVar, int i) {
        for (a aVar : this.atG) {
            aVar.a(fVar, i);
        }
    }
}
