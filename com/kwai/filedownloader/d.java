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
    public s f34994a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f34995b;

    /* renamed from: c  reason: collision with root package name */
    public final a f34996c;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f34998e;

    /* renamed from: g  reason: collision with root package name */
    public final r.b f35000g;

    /* renamed from: h  reason: collision with root package name */
    public final r.a f35001h;

    /* renamed from: i  reason: collision with root package name */
    public long f35002i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte f34997d = 0;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f34999f = null;
    public boolean o = false;

    /* loaded from: classes6.dex */
    public interface a {
        com.kwai.filedownloader.d.b Q();

        a.b R();

        ArrayList<a.InterfaceC0402a> S();

        void c(String str);
    }

    public d(a aVar, Object obj) {
        this.f34995b = obj;
        this.f34996c = aVar;
        b bVar = new b();
        this.f35000g = bVar;
        this.f35001h = bVar;
        this.f34994a = new k(aVar.R(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        s sVar;
        com.kwai.filedownloader.a F = this.f34996c.R().F();
        byte b2 = messageSnapshot.b();
        a(b2);
        this.l = messageSnapshot.n();
        if (b2 == -4) {
            this.f35000g.a();
            int a2 = h.a().a(F.h());
            if (a2 + ((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.f.f.b(F.i(), F.o()))) <= 1) {
                byte b3 = m.a().b(F.h());
                com.kwai.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b3));
                if (com.kwai.filedownloader.d.d.b(b3)) {
                    a((byte) 1);
                    this.j = messageSnapshot.d();
                    long i2 = messageSnapshot.i();
                    this.f35002i = i2;
                    this.f35000g.a(i2);
                    sVar = this.f34994a;
                    messageSnapshot = ((MessageSnapshot.a) messageSnapshot).l();
                    sVar.a(messageSnapshot);
                    return;
                }
            }
            h.a().a(this.f34996c.R(), messageSnapshot);
        }
        if (b2 == -3) {
            this.o = messageSnapshot.e();
            this.f35002i = messageSnapshot.d();
            this.j = messageSnapshot.d();
        } else if (b2 != -1) {
            if (b2 == 1) {
                this.f35002i = messageSnapshot.i();
                this.j = messageSnapshot.d();
                sVar = this.f34994a;
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
                    this.f34996c.c(f2);
                }
                this.f35000g.a(this.f35002i);
                this.f34994a.c(messageSnapshot);
                return;
            } else if (b2 == 3) {
                this.f35002i = messageSnapshot.i();
                this.f35000g.c(messageSnapshot.i());
                this.f34994a.d(messageSnapshot);
                return;
            } else if (b2 != 5) {
                if (b2 != 6) {
                    return;
                }
                this.f34994a.b(messageSnapshot);
                return;
            } else {
                this.f35002i = messageSnapshot.i();
                this.f34999f = messageSnapshot.j();
                this.k = messageSnapshot.k();
                this.f35000g.a();
                this.f34994a.f(messageSnapshot);
                return;
            }
        } else {
            this.f34999f = messageSnapshot.j();
            this.f35002i = messageSnapshot.i();
        }
        h.a().a(this.f34996c.R(), messageSnapshot);
    }

    private void q() {
        File file;
        com.kwai.filedownloader.a F = this.f34996c.R().F();
        if (F.l() == null) {
            F.a(com.kwai.filedownloader.f.f.b(F.i()));
            if (com.kwai.filedownloader.f.d.f35118a) {
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
        return this.f34996c.R().F().h();
    }

    @Override // com.kwai.filedownloader.w.a
    public MessageSnapshot a(Throwable th) {
        a((byte) -1);
        this.f34999f = th;
        return com.kwai.filedownloader.message.f.a(r(), j(), th);
    }

    @Override // com.kwai.filedownloader.a.d
    public void a() {
        if (l.b()) {
            l.a().b(this.f34996c.R().F());
        }
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
        }
    }

    public void a(byte b2) {
        this.f34997d = b2;
        this.f34998e = System.currentTimeMillis();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(g(), messageSnapshot.b())) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f34997d), Byte.valueOf(g()), Integer.valueOf(r()));
        }
        return false;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f35001h.b();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean b(MessageSnapshot messageSnapshot) {
        byte g2 = g();
        byte b2 = messageSnapshot.b();
        if (-2 == g2 && com.kwai.filedownloader.d.d.b(b2)) {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(r()));
            }
            return true;
        } else if (com.kwai.filedownloader.d.d.b(g2, b2)) {
            e(messageSnapshot);
            return true;
        } else {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f34997d), Byte.valueOf(g()), Integer.valueOf(r()));
            }
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void b_() {
        if (l.b() && g() == 6) {
            l.a().c(this.f34996c.R().F());
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void c() {
        com.kwai.filedownloader.a F = this.f34996c.R().F();
        if (l.b()) {
            l.a().d(F);
        }
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
        }
        this.f35000g.b(this.f35002i);
        if (this.f34996c.S() != null) {
            ArrayList arrayList = (ArrayList) this.f34996c.S().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.InterfaceC0402a) arrayList.get(i2)).a(F);
            }
        }
        q.a().e().b(this.f34996c.R());
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(this.f34996c.R().F())) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w.a
    public s d() {
        return this.f34994a;
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean d(MessageSnapshot messageSnapshot) {
        if (this.f34996c.R().F().m() && messageSnapshot.b() == -4 && g() == 2) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w
    public void e() {
        boolean z;
        synchronized (this.f34995b) {
            if (this.f34997d != 0) {
                com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(r()), Byte.valueOf(this.f34997d));
                return;
            }
            a((byte) 10);
            a.b R = this.f34996c.R();
            com.kwai.filedownloader.a F = R.F();
            if (l.b()) {
                l.a().a(F);
            }
            if (com.kwai.filedownloader.f.d.f35118a) {
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
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(r()));
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public boolean f() {
        if (com.kwai.filedownloader.d.d.a(g())) {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.f34996c.R().F().h()));
            }
            return false;
        }
        a((byte) -2);
        a.b R = this.f34996c.R();
        com.kwai.filedownloader.a F = R.F();
        p.a().b(this);
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(r()));
        }
        if (q.a().c()) {
            m.a().a(F.h());
        } else if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(F.h()));
        }
        h.a().b(R);
        h.a().a(R, com.kwai.filedownloader.message.f.a(F));
        q.a().e().b(R);
        return true;
    }

    @Override // com.kwai.filedownloader.w
    public byte g() {
        return this.f34997d;
    }

    @Override // com.kwai.filedownloader.w
    public long h() {
        return this.f34998e;
    }

    @Override // com.kwai.filedownloader.w
    public void i() {
        this.f34999f = null;
        this.n = null;
        this.m = false;
        this.k = 0;
        this.o = false;
        this.l = false;
        this.f35002i = 0L;
        this.j = 0L;
        this.f35000g.a();
        if (com.kwai.filedownloader.d.d.a(this.f34997d)) {
            this.f34994a.e();
            this.f34994a = new k(this.f34996c.R(), this);
        } else {
            this.f34994a.a(this.f34996c.R(), this);
        }
        a((byte) 0);
    }

    @Override // com.kwai.filedownloader.w
    public long j() {
        return this.f35002i;
    }

    @Override // com.kwai.filedownloader.w
    public long k() {
        return this.j;
    }

    @Override // com.kwai.filedownloader.w
    public Throwable l() {
        return this.f34999f;
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
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(r()), Byte.valueOf(this.f34997d));
        }
        a((byte) 0);
    }

    @Override // com.kwai.filedownloader.w.b
    public void p() {
        if (this.f34997d != 10) {
            com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f34997d));
            return;
        }
        a.b R = this.f34996c.R();
        com.kwai.filedownloader.a F = R.F();
        u e2 = q.a().e();
        try {
            if (e2.c(R)) {
                return;
            }
            synchronized (this.f34995b) {
                if (this.f34997d != 10) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.f34997d));
                    return;
                }
                a((byte) 11);
                h.a().b(R);
                if (com.kwai.filedownloader.f.c.a(F.h(), F.o(), F.x(), true)) {
                    return;
                }
                boolean a2 = m.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.f34996c.Q(), F.E());
                if (this.f34997d == -2) {
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
