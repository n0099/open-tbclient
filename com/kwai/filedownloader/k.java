package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.w;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
class k implements s {

    /* renamed from: a  reason: collision with root package name */
    private a.b f11241a;

    /* renamed from: b  reason: collision with root package name */
    private a.d f11242b;
    private Queue<MessageSnapshot> c;
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a.b bVar, a.d dVar) {
        b(bVar, dVar);
    }

    private void a(int i) {
        if (com.kwai.filedownloader.d.d.a(i)) {
            if (!this.c.isEmpty()) {
                MessageSnapshot peek = this.c.peek();
                com.kwai.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.m()), Integer.valueOf(this.c.size()), Byte.valueOf(peek.b()));
            }
            this.f11241a = null;
        }
    }

    private void b(a.b bVar, a.d dVar) {
        this.f11241a = bVar;
        this.f11242b = dVar;
        this.c = new LinkedBlockingQueue();
    }

    private void k(MessageSnapshot messageSnapshot) {
        if (this.f11241a == null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()));
            }
        } else if (!this.d && this.f11241a.F().p() != null) {
            this.c.offer(messageSnapshot);
            j.a().a(this);
        } else {
            if ((l.b() || this.f11241a.O()) && messageSnapshot.b() == 4) {
                this.f11242b.c();
            }
            a(messageSnapshot.b());
        }
    }

    @Override // com.kwai.filedownloader.s
    public void a(a.b bVar, a.d dVar) {
        if (this.f11241a != null) {
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("the messenger is working, can't re-appointment for %s", bVar));
        }
        b(bVar, dVar);
    }

    @Override // com.kwai.filedownloader.s
    public void a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify pending %s", this.f11241a);
        }
        this.f11242b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public boolean a() {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify begin %s", this.f11241a);
        }
        if (this.f11241a == null) {
            com.kwai.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.c.size()));
            return false;
        }
        this.f11242b.a();
        return true;
    }

    @Override // com.kwai.filedownloader.s
    public void b() {
        if (this.d) {
            return;
        }
        MessageSnapshot poll = this.c.poll();
        byte b2 = poll.b();
        a.b bVar = this.f11241a;
        if (bVar != null) {
            a F = bVar.F();
            i p = F.p();
            w.a G = bVar.G();
            a(b2);
            if (p == null || p.a()) {
                return;
            }
            if (b2 == 4) {
                try {
                    p.b(F);
                    j(((com.kwai.filedownloader.message.a) poll).g_());
                    return;
                } catch (Throwable th) {
                    h(G.a(th));
                    return;
                }
            }
            g gVar = p instanceof g ? (g) p : null;
            switch (b2) {
                case -4:
                    p.d(F);
                    return;
                case -3:
                    p.c(F);
                    return;
                case -2:
                    if (gVar != null) {
                        gVar.c(F, poll.i(), poll.d());
                        return;
                    } else {
                        p.c(F, poll.a(), poll.c());
                        return;
                    }
                case -1:
                    p.a(F, poll.j());
                    return;
                case 0:
                case 4:
                default:
                    return;
                case 1:
                    if (gVar != null) {
                        gVar.a(F, poll.i(), poll.d());
                        return;
                    } else {
                        p.a(F, poll.a(), poll.c());
                        return;
                    }
                case 2:
                    if (gVar != null) {
                        gVar.a(F, poll.h(), poll.g(), F.r(), poll.d());
                        return;
                    } else {
                        p.a(F, poll.h(), poll.g(), F.q(), poll.c());
                        return;
                    }
                case 3:
                    if (gVar != null) {
                        gVar.b(F, poll.i(), F.t());
                        return;
                    } else {
                        p.b(F, poll.a(), F.s());
                        return;
                    }
                case 5:
                    if (gVar != null) {
                        gVar.a(F, poll.j(), poll.k(), poll.i());
                        return;
                    } else {
                        p.a(F, poll.j(), poll.k(), poll.a());
                        return;
                    }
                case 6:
                    p.a(F);
                    return;
            }
        }
    }

    @Override // com.kwai.filedownloader.s
    public void b(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify started %s", this.f11241a);
        }
        this.f11242b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify connected %s", this.f11241a);
        }
        this.f11242b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public boolean c() {
        return this.f11241a.F().C();
    }

    @Override // com.kwai.filedownloader.s
    public void d(MessageSnapshot messageSnapshot) {
        a F = this.f11241a.F();
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify progress %s %d %d", F, Long.valueOf(F.r()), Long.valueOf(F.t()));
        }
        if (F.j() > 0) {
            this.f11242b.f_();
            k(messageSnapshot);
        } else if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.f11241a);
        }
    }

    @Override // com.kwai.filedownloader.s
    public boolean d() {
        return this.c.peek().b() == 4;
    }

    @Override // com.kwai.filedownloader.s
    public void e() {
        this.d = true;
    }

    @Override // com.kwai.filedownloader.s
    public void e(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify block completed %s %s", this.f11241a, Thread.currentThread().getName());
        }
        this.f11242b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void f(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            a F = this.f11241a.F();
            com.kwai.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.f11241a, Integer.valueOf(F.A()), Integer.valueOf(F.B()), F.y());
        }
        this.f11242b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void g(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify warn %s", this.f11241a);
        }
        this.f11242b.c();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void h(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify error %s %s", this.f11241a, this.f11241a.F().y());
        }
        this.f11242b.c();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void i(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify paused %s", this.f11241a);
        }
        this.f11242b.c();
        k(messageSnapshot);
    }

    public void j(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f11228a) {
            com.kwai.filedownloader.f.d.c(this, "notify completed %s", this.f11241a);
        }
        this.f11242b.c();
        k(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.f11241a == null ? -1 : this.f11241a.F().h());
        objArr[1] = super.toString();
        return com.kwai.filedownloader.f.f.a("%d:%s", objArr);
    }
}
