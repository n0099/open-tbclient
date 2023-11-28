package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public final class h {
    public final ArrayList<a.InterfaceC0677a> ael;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final h aem = new h((byte) 0);
    }

    public h() {
        this.ael = new ArrayList<>();
    }

    public static h ur() {
        return a.aem;
    }

    public final int size() {
        return this.ael.size();
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public final boolean a(a.InterfaceC0677a interfaceC0677a) {
        if (!this.ael.isEmpty() && this.ael.contains(interfaceC0677a)) {
            return false;
        }
        return true;
    }

    public final int aU(int i) {
        int i2;
        synchronized (this.ael) {
            Iterator<a.InterfaceC0677a> it = this.ael.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().aT(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final List<a.InterfaceC0677a> aW(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.ael) {
            Iterator<a.InterfaceC0677a> it = this.ael.iterator();
            while (it.hasNext()) {
                a.InterfaceC0677a next = it.next();
                if (next.aT(i) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void b(a.InterfaceC0677a interfaceC0677a) {
        if (!interfaceC0677a.tT().tE()) {
            interfaceC0677a.tW();
        }
        if (interfaceC0677a.tU().uj().uw()) {
            c(interfaceC0677a);
        }
    }

    public final void n(List<a.InterfaceC0677a> list) {
        synchronized (this.ael) {
            Iterator<a.InterfaceC0677a> it = this.ael.iterator();
            while (it.hasNext()) {
                a.InterfaceC0677a next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.ael.clear();
        }
    }

    public final boolean a(a.InterfaceC0677a interfaceC0677a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte tL = messageSnapshot.tL();
        synchronized (this.ael) {
            remove = this.ael.remove(interfaceC0677a);
        }
        if (com.kwad.framework.filedownloader.f.d.ahW && this.ael.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0677a, Byte.valueOf(tL), Integer.valueOf(this.ael.size()));
        }
        if (remove) {
            t uj = interfaceC0677a.tU().uj();
            if (tL != -4) {
                if (tL != -3) {
                    if (tL != -2) {
                        if (tL == -1) {
                            uj.m(messageSnapshot);
                        }
                    } else {
                        uj.n(messageSnapshot);
                    }
                } else {
                    uj.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
                }
            } else {
                uj.l(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0677a, Byte.valueOf(tL));
        }
        return remove;
    }

    public final List<a.InterfaceC0677a> aV(int i) {
        byte tL;
        ArrayList arrayList = new ArrayList();
        synchronized (this.ael) {
            Iterator<a.InterfaceC0677a> it = this.ael.iterator();
            while (it.hasNext()) {
                a.InterfaceC0677a next = it.next();
                if (next.aT(i) && !next.isOver() && (tL = next.tT().tL()) != 0 && tL != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0677a interfaceC0677a) {
        if (interfaceC0677a.tX()) {
            return;
        }
        synchronized (this.ael) {
            if (this.ael.contains(interfaceC0677a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0677a);
            } else {
                interfaceC0677a.tY();
                this.ael.add(interfaceC0677a);
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0677a, Byte.valueOf(interfaceC0677a.tT().tL()), Integer.valueOf(this.ael.size()));
                }
            }
        }
    }
}
