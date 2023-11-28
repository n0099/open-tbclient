package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public final class k implements t {
    public a.InterfaceC0677a aew;
    public a.c aex;
    public Queue<MessageSnapshot> aey;
    public boolean aez = false;

    public k(a.InterfaceC0677a interfaceC0677a, a.c cVar) {
        a(interfaceC0677a, cVar);
    }

    private void a(a.InterfaceC0677a interfaceC0677a, a.c cVar) {
        this.aew = interfaceC0677a;
        this.aex = cVar;
        this.aey = new LinkedBlockingQueue();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0677a interfaceC0677a, a.c cVar) {
        if (this.aew == null) {
            a(interfaceC0677a, cVar);
            return;
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("the messenger is working, can't re-appointment for %s", interfaceC0677a));
    }

    private void aX(int i) {
        if (com.kwad.framework.filedownloader.d.d.bA(i)) {
            if (!this.aey.isEmpty()) {
                MessageSnapshot peek = this.aey.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aey.size()), Byte.valueOf(peek.tL()));
            }
            this.aew = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.aew);
        }
        this.aex.uc();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.aew);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.aew);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.aew);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.aew, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.aew);
        }
        this.aex.uc();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            a.InterfaceC0677a interfaceC0677a = this.aew;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0677a, interfaceC0677a.tT().tN());
        }
        this.aex.uc();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.aew);
        }
        this.aex.uc();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0677a interfaceC0677a = this.aew;
        if (interfaceC0677a == null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tL()));
            }
        } else if (!this.aez && interfaceC0677a.tT().tI() != null) {
            this.aey.offer(messageSnapshot);
            j.ut().a(this);
        } else {
            if ((l.isValid() || this.aew.ua()) && messageSnapshot.tL() == 4) {
                this.aex.uc();
            }
            aX(messageSnapshot.tL());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a tT = this.aew.tT();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", tT, Long.valueOf(tT.tJ()), Long.valueOf(tT.tK()));
        }
        if (tT.tF() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.aew);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            a tT = this.aew.tT();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.aew, Integer.valueOf(tT.tO()), Integer.valueOf(tT.tP()), tT.tN());
        }
        p(messageSnapshot);
    }

    public final String toString() {
        int id;
        Object[] objArr = new Object[2];
        a.InterfaceC0677a interfaceC0677a = this.aew;
        if (interfaceC0677a == null) {
            id = -1;
        } else {
            id = interfaceC0677a.tT().getId();
        }
        objArr[0] = Integer.valueOf(id);
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.b("%d:%s", objArr);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void uA() {
        this.aez = true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uw() {
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.aew);
        }
        if (this.aew == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aey.size()));
            return false;
        }
        this.aex.onBegin();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uy() {
        return this.aew.tT().tQ();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uz() {
        if (this.aey.peek().tL() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void ux() {
        if (this.aez) {
            return;
        }
        MessageSnapshot poll = this.aey.poll();
        byte tL = poll.tL();
        a.InterfaceC0677a interfaceC0677a = this.aew;
        if (interfaceC0677a == null) {
            return;
        }
        a tT = interfaceC0677a.tT();
        i tI = tT.tI();
        x.a tU = interfaceC0677a.tU();
        aX(tL);
        if (tI == null) {
            return;
        }
        if (tL == 4) {
            try {
                tI.b(tT);
                o(((com.kwad.framework.filedownloader.message.a) poll).vN());
                return;
            } catch (Throwable th) {
                m(tU.h(th));
                return;
            }
        }
        g gVar = null;
        if (tI instanceof g) {
            gVar = (g) tI;
        }
        if (tL != -4) {
            if (tL != -3) {
                if (tL != -2) {
                    if (tL != -1) {
                        if (tL != 1) {
                            if (tL != 2) {
                                if (tL != 3) {
                                    if (tL != 5) {
                                        if (tL == 6) {
                                            tI.a(tT);
                                            return;
                                        }
                                        return;
                                    } else if (gVar != null) {
                                        poll.vT();
                                        poll.tP();
                                        poll.vS();
                                        return;
                                    } else {
                                        poll.vT();
                                        poll.tP();
                                        poll.vO();
                                        return;
                                    }
                                } else if (gVar != null) {
                                    poll.vS();
                                    return;
                                } else {
                                    tI.b(tT, poll.vO(), tT.getSmallFileTotalBytes());
                                    return;
                                }
                            } else if (gVar != null) {
                                poll.getEtag();
                                poll.vG();
                                poll.vQ();
                                return;
                            } else {
                                tI.a(tT, poll.getEtag(), poll.vG(), tT.getSmallFileSoFarBytes(), poll.vP());
                                return;
                            }
                        } else if (gVar != null) {
                            poll.vS();
                            poll.vQ();
                            return;
                        } else {
                            tI.a(tT, poll.vO(), poll.vP());
                            return;
                        }
                    }
                    tI.a(tT, poll.vT());
                    return;
                } else if (gVar != null) {
                    poll.vS();
                    poll.vQ();
                    return;
                } else {
                    tI.c(tT, poll.vO(), poll.vP());
                    return;
                }
            }
            tI.c(tT);
            return;
        }
        tI.d(tT);
    }
}
