package com.kwai.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.w;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements a.d, w, w.a, w.b {

    /* renamed from: a  reason: collision with root package name */
    private s f7187a;
    private final Object b;
    private final a c;
    private volatile long e;
    private final r.b g;
    private final r.a h;
    private long i;
    private long j;
    private int k;
    private boolean l;
    private boolean m;
    private String n;
    private volatile byte d = 0;
    private Throwable f = null;
    private boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        com.kwai.filedownloader.d.b Q();

        a.b R();

        ArrayList<a.InterfaceC1172a> S();

        void c(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Object obj) {
        this.b = obj;
        this.c = aVar;
        b bVar = new b();
        this.g = bVar;
        this.h = bVar;
        this.f7187a = new k(aVar.R(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        com.kwai.filedownloader.a F = this.c.R().F();
        byte b = messageSnapshot.b();
        a(b);
        this.l = messageSnapshot.n();
        switch (b) {
            case -4:
                this.g.a();
                int a2 = h.a().a(F.h());
                if (((a2 > 1 || !F.m()) ? 0 : h.a().a(com.kwai.filedownloader.f.f.b(F.i(), F.o()))) + a2 <= 1) {
                    byte b2 = m.a().b(F.h());
                    com.kwai.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(F.h()), Integer.valueOf(b2));
                    if (com.kwai.filedownloader.d.d.b(b2)) {
                        a((byte) 1);
                        this.j = messageSnapshot.d();
                        this.i = messageSnapshot.i();
                        this.g.a(this.i);
                        this.f7187a.a(((MessageSnapshot.a) messageSnapshot).l());
                        return;
                    }
                }
                h.a().a(this.c.R(), messageSnapshot);
                return;
            case -3:
                this.o = messageSnapshot.e();
                this.i = messageSnapshot.d();
                this.j = messageSnapshot.d();
                h.a().a(this.c.R(), messageSnapshot);
                return;
            case -2:
            case 0:
            case 4:
            default:
                return;
            case -1:
                this.f = messageSnapshot.j();
                this.i = messageSnapshot.i();
                h.a().a(this.c.R(), messageSnapshot);
                return;
            case 1:
                this.i = messageSnapshot.i();
                this.j = messageSnapshot.d();
                this.f7187a.a(messageSnapshot);
                return;
            case 2:
                this.j = messageSnapshot.d();
                this.m = messageSnapshot.g();
                this.n = messageSnapshot.h();
                String f = messageSnapshot.f();
                if (f != null) {
                    if (F.n() != null) {
                        com.kwai.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", F.n(), f);
                    }
                    this.c.c(f);
                }
                this.g.a(this.i);
                this.f7187a.c(messageSnapshot);
                return;
            case 3:
                this.i = messageSnapshot.i();
                this.g.c(messageSnapshot.i());
                this.f7187a.d(messageSnapshot);
                return;
            case 5:
                this.i = messageSnapshot.i();
                this.f = messageSnapshot.j();
                this.k = messageSnapshot.k();
                this.g.a();
                this.f7187a.f(messageSnapshot);
                return;
            case 6:
                this.f7187a.b(messageSnapshot);
                return;
        }
    }

    private void q() {
        File file;
        com.kwai.filedownloader.a F = this.c.R().F();
        if (F.l() == null) {
            F.a(com.kwai.filedownloader.f.f.b(F.i()));
            if (com.kwai.filedownloader.f.d.f7212a) {
                com.kwai.filedownloader.f.d.c(this, "save Path is null to %s", F.l());
            }
        }
        if (F.m()) {
            file = new File(F.l());
        } else {
            String h = com.kwai.filedownloader.f.f.h(F.l());
            if (h == null) {
                throw new InvalidParameterException(com.kwai.filedownloader.f.f.a("the provided mPath[%s] is invalid, can't find its directory", F.l()));
            }
            file = new File(h);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwai.filedownloader.f.f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    private int r() {
        return this.c.R().F().h();
    }

    @Override // com.kwai.filedownloader.w.a
    public MessageSnapshot a(Throwable th) {
        a((byte) -1);
        this.f = th;
        return com.kwai.filedownloader.message.f.a(r(), j(), th);
    }

    @Override // com.kwai.filedownloader.a.d
    public void a() {
        if (l.b()) {
            l.a().b(this.c.R().F());
        }
        if (com.kwai.filedownloader.f.d.f7212a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
        }
    }

    protected void a(byte b) {
        this.d = b;
        this.e = System.currentTimeMillis();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(g(), messageSnapshot.b())) {
            e(messageSnapshot);
            return true;
        } else if (com.kwai.filedownloader.f.d.f7212a) {
            com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(g()), Integer.valueOf(r()));
            return false;
        } else {
            return false;
        }
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.h.b();
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean b(MessageSnapshot messageSnapshot) {
        byte g = g();
        byte b = messageSnapshot.b();
        if (-2 == g && com.kwai.filedownloader.d.d.b(b)) {
            if (com.kwai.filedownloader.f.d.f7212a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(r()));
                return true;
            }
            return true;
        } else if (com.kwai.filedownloader.d.d.b(g, b)) {
            e(messageSnapshot);
            return true;
        } else {
            if (com.kwai.filedownloader.f.d.f7212a) {
                com.kwai.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(g()), Integer.valueOf(r()));
            }
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.d
    public void c() {
        com.kwai.filedownloader.a F = this.c.R().F();
        if (l.b()) {
            l.a().d(F);
        }
        if (com.kwai.filedownloader.f.d.f7212a) {
            com.kwai.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
        }
        this.g.b(this.i);
        if (this.c.S() != null) {
            ArrayList arrayList = (ArrayList) this.c.S().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((a.InterfaceC1172a) arrayList.get(i)).a(F);
            }
        }
        q.a().e().b(this.c.R());
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean c(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.d.d.a(this.c.R().F())) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w.a
    public s d() {
        return this.f7187a;
    }

    @Override // com.kwai.filedownloader.w.a
    public boolean d(MessageSnapshot messageSnapshot) {
        if (this.c.R().F().m() && messageSnapshot.b() == -4 && g() == 2) {
            e(messageSnapshot);
            return true;
        }
        return false;
    }

    @Override // com.kwai.filedownloader.w
    public void e() {
        boolean z;
        synchronized (this.b) {
            if (this.d != 0) {
                com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(r()), Byte.valueOf(this.d));
                return;
            }
            a((byte) 10);
            a.b R = this.c.R();
            com.kwai.filedownloader.a F = R.F();
            if (l.b()) {
                l.a().a(F);
            }
            if (com.kwai.filedownloader.f.d.f7212a) {
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
            if (com.kwai.filedownloader.f.d.f7212a) {
                com.kwai.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(r()));
            }
        }
    }

    @Override // com.kwai.filedownloader.w
    public boolean f() {
        if (com.kwai.filedownloader.d.d.a(g())) {
            if (com.kwai.filedownloader.f.d.f7212a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.c.R().F().h()));
                return false;
            }
            return false;
        }
        a((byte) -2);
        a.b R = this.c.R();
        com.kwai.filedownloader.a F = R.F();
        p.a().b(this);
        if (com.kwai.filedownloader.f.d.f7212a) {
            com.kwai.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(r()));
        }
        if (q.a().c()) {
            m.a().a(F.h());
        } else if (com.kwai.filedownloader.f.d.f7212a) {
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
            l.a().c(this.c.R().F());
        }
    }

    @Override // com.kwai.filedownloader.w
    public byte g() {
        return this.d;
    }

    @Override // com.kwai.filedownloader.w
    public long h() {
        return this.e;
    }

    @Override // com.kwai.filedownloader.w
    public void i() {
        this.f = null;
        this.n = null;
        this.m = false;
        this.k = 0;
        this.o = false;
        this.l = false;
        this.i = 0L;
        this.j = 0L;
        this.g.a();
        if (com.kwai.filedownloader.d.d.a(this.d)) {
            this.f7187a.e();
            this.f7187a = new k(this.c.R(), this);
        } else {
            this.f7187a.a(this.c.R(), this);
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
        return this.f;
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
        if (com.kwai.filedownloader.f.d.f7212a) {
            com.kwai.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(r()), Byte.valueOf(this.d));
        }
        a((byte) 0);
    }

    @Override // com.kwai.filedownloader.w.b
    public void p() {
        if (this.d != 10) {
            com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.d));
            return;
        }
        a.b R = this.c.R();
        com.kwai.filedownloader.a F = R.F();
        u e = q.a().e();
        try {
            if (e.c(R)) {
                return;
            }
            synchronized (this.b) {
                if (this.d != 10) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(r()), Byte.valueOf(this.d));
                    return;
                }
                a(Constants.GZIP_CAST_TYPE);
                h.a().b(R);
                if (com.kwai.filedownloader.f.c.a(F.h(), F.o(), F.x(), true)) {
                    return;
                }
                boolean a2 = m.a().a(F.i(), F.l(), F.m(), F.j(), F.k(), F.A(), F.x(), this.c.Q(), F.E());
                if (this.d == -2) {
                    com.kwai.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(r()));
                    if (a2) {
                        m.a().a(r());
                    }
                } else if (a2) {
                    e.b(R);
                } else if (e.c(R)) {
                } else {
                    MessageSnapshot a3 = a(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.a().a(R)) {
                        e.b(R);
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
