package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.w;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public class k implements s {

    /* renamed from: a  reason: collision with root package name */
    public a.b f37901a;

    /* renamed from: b  reason: collision with root package name */
    public a.d f37902b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<MessageSnapshot> f37903c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37904d = false;

    public k(a.b bVar, a.d dVar) {
        b(bVar, dVar);
    }

    private void a(int i2) {
        if (com.kwai.filedownloader.d.d.a(i2)) {
            if (!this.f37903c.isEmpty()) {
                MessageSnapshot peek = this.f37903c.peek();
                com.kwai.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.m()), Integer.valueOf(this.f37903c.size()), Byte.valueOf(peek.b()));
            }
            this.f37901a = null;
        }
    }

    private void b(a.b bVar, a.d dVar) {
        this.f37901a = bVar;
        this.f37902b = dVar;
        this.f37903c = new LinkedBlockingQueue();
    }

    private void k(MessageSnapshot messageSnapshot) {
        a.b bVar = this.f37901a;
        if (bVar == null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()));
            }
        } else if (!this.f37904d && bVar.F().p() != null) {
            this.f37903c.offer(messageSnapshot);
            j.a().a(this);
        } else {
            if ((l.b() || this.f37901a.O()) && messageSnapshot.b() == 4) {
                this.f37902b.c();
            }
            a(messageSnapshot.b());
        }
    }

    @Override // com.kwai.filedownloader.s
    public void a(a.b bVar, a.d dVar) {
        if (this.f37901a != null) {
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("the messenger is working, can't re-appointment for %s", bVar));
        }
        b(bVar, dVar);
    }

    @Override // com.kwai.filedownloader.s
    public void a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify pending %s", this.f37901a);
        }
        this.f37902b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public boolean a() {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify begin %s", this.f37901a);
        }
        if (this.f37901a == null) {
            com.kwai.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f37903c.size()));
            return false;
        }
        this.f37902b.a();
        return true;
    }

    @Override // com.kwai.filedownloader.s
    public void b() {
        if (this.f37904d) {
            return;
        }
        MessageSnapshot poll = this.f37903c.poll();
        byte b2 = poll.b();
        a.b bVar = this.f37901a;
        if (bVar == null) {
            return;
        }
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
        if (b2 == -4) {
            p.d(F);
        } else if (b2 == -3) {
            p.c(F);
        } else if (b2 == -2) {
            if (gVar != null) {
                gVar.c(F, poll.i(), poll.d());
            } else {
                p.c(F, poll.a(), poll.c());
            }
        } else if (b2 == -1) {
            p.a(F, poll.j());
        } else if (b2 == 1) {
            if (gVar != null) {
                gVar.a(F, poll.i(), poll.d());
            } else {
                p.a(F, poll.a(), poll.c());
            }
        } else if (b2 == 2) {
            String h2 = poll.h();
            boolean g2 = poll.g();
            if (gVar != null) {
                gVar.a(F, h2, g2, F.r(), poll.d());
            } else {
                p.a(F, h2, g2, F.q(), poll.c());
            }
        } else if (b2 == 3) {
            if (gVar != null) {
                gVar.b(F, poll.i(), F.t());
            } else {
                p.b(F, poll.a(), F.s());
            }
        } else if (b2 != 5) {
            if (b2 != 6) {
                return;
            }
            p.a(F);
        } else if (gVar != null) {
            gVar.a(F, poll.j(), poll.k(), poll.i());
        } else {
            p.a(F, poll.j(), poll.k(), poll.a());
        }
    }

    @Override // com.kwai.filedownloader.s
    public void b(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify started %s", this.f37901a);
        }
        this.f37902b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify connected %s", this.f37901a);
        }
        this.f37902b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public boolean c() {
        return this.f37901a.F().C();
    }

    @Override // com.kwai.filedownloader.s
    public void d(MessageSnapshot messageSnapshot) {
        a F = this.f37901a.F();
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify progress %s %d %d", F, Long.valueOf(F.r()), Long.valueOf(F.t()));
        }
        if (F.j() > 0) {
            this.f37902b.f_();
            k(messageSnapshot);
        } else if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.f37901a);
        }
    }

    @Override // com.kwai.filedownloader.s
    public boolean d() {
        return this.f37903c.peek().b() == 4;
    }

    @Override // com.kwai.filedownloader.s
    public void e() {
        this.f37904d = true;
    }

    @Override // com.kwai.filedownloader.s
    public void e(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify block completed %s %s", this.f37901a, Thread.currentThread().getName());
        }
        this.f37902b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void f(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            a F = this.f37901a.F();
            com.kwai.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.f37901a, Integer.valueOf(F.A()), Integer.valueOf(F.B()), F.y());
        }
        this.f37902b.f_();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void g(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify warn %s", this.f37901a);
        }
        this.f37902b.c();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void h(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            a.b bVar = this.f37901a;
            com.kwai.filedownloader.f.d.c(this, "notify error %s %s", bVar, bVar.F().y());
        }
        this.f37902b.c();
        k(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.s
    public void i(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify paused %s", this.f37901a);
        }
        this.f37902b.c();
        k(messageSnapshot);
    }

    public void j(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "notify completed %s", this.f37901a);
        }
        this.f37902b.c();
        k(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        a.b bVar = this.f37901a;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.F().h());
        objArr[1] = super.toString();
        return com.kwai.filedownloader.f.f.a("%d:%s", objArr);
    }
}
