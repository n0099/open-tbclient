package com.kwad.sdk.core.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class i {
    public static volatile i Yo;
    public List<a> Yn = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(g gVar, int i);
    }

    public static i tB() {
        if (Yo == null) {
            synchronized (i.class) {
                if (Yo == null) {
                    Yo = new i();
                }
            }
        }
        return Yo;
    }

    public final void a(a aVar) {
        this.Yn.add(aVar);
    }

    public final void b(g gVar, int i) {
        for (a aVar : this.Yn) {
            aVar.a(gVar, i);
        }
    }
}
