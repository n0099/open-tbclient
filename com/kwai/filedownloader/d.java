package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.w;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d implements a.d, w, w.a, w.b {

    /* renamed from: a  reason: collision with root package name */
    public s f36893a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f36894b;

    /* renamed from: c  reason: collision with root package name */
    public final a f36895c;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f36897e;

    /* renamed from: g  reason: collision with root package name */
    public final r.b f36899g;

    /* renamed from: h  reason: collision with root package name */
    public final r.a f36900h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte f36896d = 0;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f36898f = null;
    public boolean o = false;

    /* loaded from: classes6.dex */
    public interface a {
        com.kwai.filedownloader.d.b Q();

        a.b R();

        ArrayList<a.InterfaceC0440a> S();

        void c(String str);
    }

    public d(a aVar, Object obj) {
        this.f36894b = obj;
        this.f36895c = aVar;
        b bVar = new b();
        this.f36899g = bVar;
        this.f36900h = bVar;
        this.f36893a = new k(aVar.R(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        s sVar;
        com.kwai.filedownloader.a F = this.f36895c.R().F();
        byte b2 = messageSnapshot.b();
        a(b2);
        this.l = messageSnapshot.n();
        if (b2 == -4) {
            this.f36899g.a();
            int a2 = h.a().a(F.h());
            if (a2 + ((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.f.f.b(F.i(), F.o()))) <= 1) {
                byte b3 = m.a().b(F.h());
                com.kwai.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b3));
                if (com.kwai.filedownloader.d.d.b(b3)) {
                    a((byte) 1);
                    this.j = messageSnapshot.d();
                    long i = messageSnapshot.i();
                    this.i = i;
                    this.f36899g.a(i);
                    sVar = this.f36893a;
                    messageSnapshot = ((MessageSnapshot.a) messageSnapshot).l();
                    sVar.a(messageSnapshot);
                    return;
                }
            }
            h.a().a(this.f36895c.R(), messageSnapshot);
        }
        if (b2 == -3) {
            this.o = messageSnapshot.e();
            this.i = messageSnapshot.d();
            this.j = messageSnapshot.d();
        } else if (b2 != -1) {
            if (b2 == 1) {
                this.i = messageSnapshot.i();
                this.j = messageSnapshot.d();
                sVar = this.f36893a;
                sVar.a(messageSnapshot);
                return;
            } else if (b2 == 2) {
                this.j = messageSnapshot.d();
                this.m = messageSnapshot.g();
                this.n = messageSnapshot.h();
                String f2 = messageSnapshot.f();
                if (f2 != null) {
                    if (F.n() != null) {
                        com.kwai.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.n(), f2);
                    }
                    this.f36895c.c(f2);
                }
                this.f36899g.a(this.i);
                this.f36893a.c(messageSnapshot);
                return;
            } else if (b2 == 3) {
                this.i = messageSnapshot.i();
                this.f36899g.c(messageSnapshot.i());
                this.f36893a.d(messageSnapshot);
                return;
            } else if (b2 != 5) {
                if (b2 != 6) {
                    return;
                }
                this.f36893a.b(messageSnapshot);
                return;
            } else {
                this.i = messageSnapshot.i();
                this.f36898f = messageSnapshot.j();
                this.k = messageSnapshot.k();
                this.f36899g.a();
                this.f36893a.f(messageSnapshot);
                return;
            }
        } else {
            this.f36898f = messageSnapshot.j();
            this.i = messageSnapshot.i();
        }
        h.a().a(this.f36895c.R(), messageSnapshot);
    }

    private void q() {
        File file;
        com.kwai.filedownloader.a F = this.f36895c.R().F();
        if (F.l() == null) {
            F.a(com.kwai.filedownloader.f.f.b(F.i()));
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.c(this, "save Path is null to %s", F.l());
            }
        }
        if (F.m()) {
            file = new File(F.l());
        } else {
            String h2 = com.kwai.filedownloader.f.f.h(F.l());
            if (h2 == null) {
                throw new InvalidParameterException(com.kwai.filedownloader.f.f.a("the provided mPath[%s] is invalid, can't find its directory", F.l()));
            }
            file = new File(h2);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwai.filedownloader.f.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    private int r() {
        return this.f36895c.R().F().h();
    }

    @Override // com.kwai.filedownloader.w.a
    public MessageSnapshot a(Throwable th) {
        a((byte) -1);
        this.f36898f = th;
        return com.kwai.filedownloader.message.f.a(r(), j(), th);
    }

    @Override // com.kwai.filedownloader.a.d
    public void a() {
        if (l.b()) {
            l.a().b(this.f36895c.R().F());
        }
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
        }
    }

    public void a(byte b2) {
        this.f36896d = b2;
        this.f36897e = System.currentTimeMillis();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(g(), messageSnapshot.b())) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f36896d), Byte.valueOf(g()), Integer.valueOf(r()));
        }
        return false;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f36900h.b();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean b(MessageSnapshot messageSnapshot) {
        byte g2 = g();
        byte b2 = messageSnapshot.b();
        if (-2 == g2 && com.kwai.filedownloader.d.d.b(b2)) {
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(r()));
            }
            return true;
        } else if (com.kwai.filedownloader.d.d.b(g2, b2)) {
            e(messageSnapshot);
            return true;
        } else {
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f36896d), Byte.valueOf(g()), Integer.valueOf(r()));
            }
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void c() {
        com.kwai.filedownloader.a F = this.f36895c.R().F();
        if (l.b()) {
            l.a().d(F);
        }
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
        }
        this.f36899g.b(this.i);
        if (this.f36895c.S() != null) {
            ArrayList arrayList = (ArrayList) this.f36895c.S().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((a.InterfaceC0440a) arrayList.get(i)).a(F);
            }
        }
        q.a().e().b(this.f36895c.R());
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(this.f36895c.R().F())) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w.a
    public s d() {
        return this.f36893a;
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean d(MessageSnapshot messageSnapshot) {
        if (this.f36895c.R().F().m() && messageSnapshot.b() == -4 && g() == 2) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w
    public void e() {
        boolean z;
        synchronized (this.f36894b) {
            if (this.f36896d != 0) {
                com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(r()), Byte.valueOf(this.f36896d));
                return;
            }
            a((byte) 10);
            a.b R = this.f36895c.R();
            com.kwai.filedownloader.a F = R.F();
            if (l.b()) {
                l.a().a(F);
            }
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", F.i(), F.l(), F.p(), F.z());
            }
            try {
                q();
                z = true;
            } catch (Throwable th) {
                h.a().b(R);
                h.a().a(R, a(th));
                z = false;
            }
            if (z) {
                p.a().a(this);
            }
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(r()));
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public boolean f() {
        if (com.kwai.filedownloader.d.d.a(g())) {
            if (com.kwai.filedownloader.f.d.f37012a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.f36895c.R().F().h()));
            }
            return false;
        }
        a((byte) -2);
        a.b R = this.f36895c.R();
        com.kwai.filedownloader.a F = R.F();
        p.a().b(this);
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(r()));
        }
        if (q.a().c()) {
            m.a().a(F.h());
        } else if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.h()));
        }
        h.a().b(R);
        h.a().a(R, com.kwai.filedownloader.message.f.a(F));
        q.a().e().b(R);
        return true;
    }

    @Override // com.kwai.filedownloader.a.d
    public void f_() {
        if (l.b() && g() == 6) {
            l.a().c(this.f36895c.R().F());
        }
    }

    @Override // com.kwai.filedownloader.w
    public byte g() {
        return this.f36896d;
    }

    @Override // com.kwai.filedownloader.w
    public long h() {
        return this.f36897e;
    }

    @Override // com.kwai.filedownloader.w
    public void i() {
        this.f36898f = null;
        this.n = null;
        this.m = false;
        this.k = 0;
        this.o = false;
        this.l = false;
        this.i = 0L;
        this.j = 0L;
        this.f36899g.a();
        if (com.kwai.filedownloader.d.d.a(this.f36896d)) {
            this.f36893a.e();
            this.f36893a = new k(this.f36895c.R(), this);
        } else {
            this.f36893a.a(this.f36895c.R(), this);
        }
        a((byte) 0);
    }

    @Override // com.kwai.filedownloader.w
    public long j() {
        return this.i;
    }

    @Override // com.kwai.filedownloader.w
    public long k() {
        return this.j;
    }

    @Override // com.kwai.filedownloader.w
    public Throwable l() {
        return this.f36898f;
    }

    @Override // com.kwai.filedownloader.w
    public int m() {
        return this.k;
    }

    @Override // com.kwai.filedownloader.w
    public boolean n() {
        return this.l;
    }

    @Override // com.kwai.filedownloader.w
    public void o() {
        if (com.kwai.filedownloader.f.d.f37012a) {
            com.kwai.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(r()), Byte.valueOf(this.f36896d));
        }
        a((byte) 0);
    }

    @Override // com.kwai.filedownloader.w.b
    public void p() {
        if (this.f36896d != 10) {
            com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f36896d));
            return;
        }
        a.b R = this.f36895c.R();
        com.kwai.filedownloader.a F = R.F();
        u e2 = q.a().e();
        try {
            if (e2.c(R)) {
                return;
            }
            synchronized (this.f36894b) {
                if (this.f36896d != 10) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f36896d));
                    return;
                }
                a((byte) 11);
                h.a().b(R);
                if (com.kwai.filedownloader.f.c.a(F.h(), F.o(), F.x(), true)) {
                    return;
                }
                boolean a2 = m.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.f36895c.Q(), F.E());
                if (this.f36896d == -2) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(r()));
                    if (a2) {
                        m.a().a(r());
                    }
                } else if (a2) {
                    e2.b(R);
                } else if (e2.c(R)) {
                } else {
                    MessageSnapshot a3 = a(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.a().a(R)) {
                        e2.b(R);
                        h.a().b(R);
                    }
                    h.a().a(R, a3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.a().a(R, a(th));
        }
    }
}
