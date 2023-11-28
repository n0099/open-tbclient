package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class z extends e implements v {
    public final ArrayList<a.InterfaceC0677a> aeR = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0677a interfaceC0677a) {
        if (!this.aeR.isEmpty() && this.aeR.contains(interfaceC0677a)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0677a interfaceC0677a) {
        if (!this.aeR.isEmpty()) {
            synchronized (this.aeR) {
                this.aeR.remove(interfaceC0677a);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0677a interfaceC0677a) {
        r.uK();
        if (!r.uM()) {
            synchronized (this.aeR) {
                r.uK();
                if (!r.uM()) {
                    if (com.kwad.framework.filedownloader.f.d.ahW) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0677a.tT().getId()));
                    }
                    n.uC().ak(com.kwad.framework.filedownloader.f.c.wB());
                    if (!this.aeR.contains(interfaceC0677a)) {
                        interfaceC0677a.free();
                        this.aeR.add(interfaceC0677a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0677a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void um() {
        w uN = r.uK().uN();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aeR) {
            this.aeR.clear();
            ArrayList arrayList = new ArrayList(uN.uR());
            for (a.InterfaceC0677a interfaceC0677a : (List) this.aeR.clone()) {
                int tV = interfaceC0677a.tV();
                if (uN.bc(tV)) {
                    interfaceC0677a.tT().tC().ub();
                    if (!arrayList.contains(Integer.valueOf(tV))) {
                        arrayList.add(Integer.valueOf(tV));
                    }
                } else {
                    interfaceC0677a.tZ();
                }
            }
            uN.o(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void un() {
        if (uo() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w uN = r.uK().uN();
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.ur().size()));
            }
            if (h.ur().size() > 0) {
                synchronized (this.aeR) {
                    h.ur().n(this.aeR);
                    Iterator<a.InterfaceC0677a> it = this.aeR.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    uN.uQ();
                }
                r.uK().uL();
            }
        } else if (h.ur().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.ur().size()));
        }
    }
}
