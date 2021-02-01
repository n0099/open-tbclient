package com.kwai.filedownloader;

import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.w;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements com.kwai.filedownloader.a, a.b, d.a {

    /* renamed from: b  reason: collision with root package name */
    private final w f10881b;
    private final w.a c;
    private int d;
    private ArrayList<a.InterfaceC1153a> e;
    private final String f;
    private String g;
    private String h;
    private boolean i;
    private com.kwai.filedownloader.d.b j;
    private i k;
    private Object l;
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private int p = 100;
    private int q = 10;
    private boolean r = false;

    /* renamed from: a  reason: collision with root package name */
    volatile int f10880a = 0;
    private boolean s = false;
    private final Object u = new Object();
    private volatile boolean v = false;
    private final Object t = new Object();

    /* loaded from: classes3.dex */
    private static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final c f10882a;

        private a(c cVar) {
            this.f10882a = cVar;
            this.f10882a.s = true;
        }

        @Override // com.kwai.filedownloader.a.c
        public int a() {
            int h = this.f10882a.h();
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(h));
            }
            h.a().c(this.f10882a);
            return h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f = str;
        d dVar = new d(this, this.t);
        this.f10881b = dVar;
        this.c = dVar;
    }

    private int T() {
        if (P()) {
            if (c()) {
                throw new IllegalStateException(com.kwai.filedownloader.f.f.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(h())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.f10881b.toString());
        }
        if (!d()) {
            J();
        }
        this.f10881b.e();
        return h();
    }

    private void U() {
        if (this.j == null) {
            synchronized (this.u) {
                if (this.j == null) {
                    this.j = new com.kwai.filedownloader.d.b();
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a
    public int A() {
        return this.m;
    }

    @Override // com.kwai.filedownloader.a
    public int B() {
        return this.f10881b.m();
    }

    @Override // com.kwai.filedownloader.a
    public boolean C() {
        return this.n;
    }

    @Override // com.kwai.filedownloader.a
    public boolean D() {
        return this.f10881b.n();
    }

    @Override // com.kwai.filedownloader.a
    public boolean E() {
        return this.o;
    }

    @Override // com.kwai.filedownloader.a.b
    public com.kwai.filedownloader.a F() {
        return this;
    }

    @Override // com.kwai.filedownloader.a.b
    public w.a G() {
        return this.c;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean H() {
        return com.kwai.filedownloader.d.d.a(v());
    }

    @Override // com.kwai.filedownloader.a.b
    public int I() {
        return this.f10880a;
    }

    @Override // com.kwai.filedownloader.a.b
    public void J() {
        this.f10880a = p() != null ? p().hashCode() : hashCode();
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean K() {
        return this.v;
    }

    @Override // com.kwai.filedownloader.a.b
    public void L() {
        this.v = true;
    }

    @Override // com.kwai.filedownloader.a.b
    public void M() {
        this.f10881b.o();
        if (h.a().a(this)) {
            this.v = false;
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public void N() {
        T();
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean O() {
        return this.e != null && this.e.size() > 0;
    }

    public boolean P() {
        return this.f10881b.g() != 0;
    }

    @Override // com.kwai.filedownloader.d.a
    public com.kwai.filedownloader.d.b Q() {
        return this.j;
    }

    @Override // com.kwai.filedownloader.d.a
    public a.b R() {
        return this;
    }

    @Override // com.kwai.filedownloader.d.a
    public ArrayList<a.InterfaceC1153a> S() {
        return this.e;
    }

    @Override // com.kwai.filedownloader.a
    public a.c a() {
        return new a();
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(int i) {
        this.m = i;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(i iVar) {
        this.k = iVar;
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(Object obj) {
        this.l = obj;
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str) {
        return a(str, false);
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str, String str2) {
        U();
        this.j.a(str, str2);
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(String str, boolean z) {
        this.g = str;
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.i = z;
        if (z) {
            this.h = null;
        } else {
            this.h = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(boolean z) {
        this.r = z;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a b(String str) {
        if (this.j == null) {
            synchronized (this.u) {
                if (this.j == null) {
                }
            }
            return this;
        }
        this.j.a(str);
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a b(boolean z) {
        this.o = z;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public boolean b() {
        if (c()) {
            com.kwai.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(h()));
            return false;
        }
        this.f10880a = 0;
        this.s = false;
        this.v = false;
        this.f10881b.i();
        return true;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean b(int i) {
        return h() == i;
    }

    @Override // com.kwai.filedownloader.d.a
    public void c(String str) {
        this.h = str;
    }

    @Override // com.kwai.filedownloader.a
    public boolean c() {
        if (q.a().e().a(this)) {
            return true;
        }
        return com.kwai.filedownloader.d.d.b(v());
    }

    @Override // com.kwai.filedownloader.a
    public boolean d() {
        return this.f10880a != 0;
    }

    @Override // com.kwai.filedownloader.a
    public int e() {
        if (this.s) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return T();
    }

    @Override // com.kwai.filedownloader.a
    public boolean f() {
        boolean f;
        synchronized (this.t) {
            f = this.f10881b.f();
        }
        return f;
    }

    @Override // com.kwai.filedownloader.a
    public boolean g() {
        return f();
    }

    @Override // com.kwai.filedownloader.a
    public int h() {
        if (this.d != 0) {
            return this.d;
        }
        if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f)) {
            return 0;
        }
        int a2 = com.kwai.filedownloader.f.f.a(this.f, this.g, this.i);
        this.d = a2;
        return a2;
    }

    @Override // com.kwai.filedownloader.a
    public String i() {
        return this.f;
    }

    @Override // com.kwai.filedownloader.a
    public int j() {
        return this.p;
    }

    @Override // com.kwai.filedownloader.a
    public int k() {
        return this.q;
    }

    @Override // com.kwai.filedownloader.a
    public String l() {
        return this.g;
    }

    @Override // com.kwai.filedownloader.a
    public boolean m() {
        return this.i;
    }

    @Override // com.kwai.filedownloader.a
    public String n() {
        return this.h;
    }

    @Override // com.kwai.filedownloader.a
    public String o() {
        return com.kwai.filedownloader.f.f.a(l(), m(), n());
    }

    @Override // com.kwai.filedownloader.a
    public i p() {
        return this.k;
    }

    @Override // com.kwai.filedownloader.a
    public int q() {
        if (this.f10881b.j() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.f10881b.j();
    }

    @Override // com.kwai.filedownloader.a
    public long r() {
        return this.f10881b.j();
    }

    @Override // com.kwai.filedownloader.a
    public int s() {
        if (this.f10881b.k() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.f10881b.k();
    }

    @Override // com.kwai.filedownloader.a
    public long t() {
        return this.f10881b.k();
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("%d@%s", Integer.valueOf(h()), super.toString());
    }

    @Override // com.kwai.filedownloader.a
    public int u() {
        return this.f10881b.b();
    }

    @Override // com.kwai.filedownloader.a
    public byte v() {
        return this.f10881b.g();
    }

    @Override // com.kwai.filedownloader.a
    public long w() {
        return this.f10881b.h();
    }

    @Override // com.kwai.filedownloader.a
    public boolean x() {
        return this.r;
    }

    @Override // com.kwai.filedownloader.a
    public Throwable y() {
        return this.f10881b.l();
    }

    @Override // com.kwai.filedownloader.a
    public Object z() {
        return this.l;
    }
}
