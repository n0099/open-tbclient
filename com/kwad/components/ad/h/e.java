package com.kwad.components.ad.h;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class e {
    public final AtomicBoolean oc;
    public final List<com.kwad.components.ad.b.a.b> od;

    /* loaded from: classes10.dex */
    public static class a {
        public static final e oe = new e((byte) 0);
    }

    public e() {
        this.oc = new AtomicBoolean();
        this.od = new CopyOnWriteArrayList();
    }

    public static e eU() {
        return a.oe;
    }

    public final boolean S() {
        return this.oc.get();
    }

    public final void eQ() {
        this.oc.set(true);
        for (com.kwad.components.ad.b.a.b bVar : this.od) {
            bVar.T();
        }
    }

    public final void eS() {
        this.oc.set(false);
        for (com.kwad.components.ad.b.a.b bVar : this.od) {
            bVar.U();
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.od.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.od.remove(bVar);
        }
    }
}
