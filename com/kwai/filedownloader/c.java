package com.kwai.filedownloader;

import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.w;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c implements com.kwai.filedownloader.a, a.b, d.a {

    /* renamed from: b  reason: collision with root package name */
    public final w f34228b;

    /* renamed from: c  reason: collision with root package name */
    public final w.a f34229c;

    /* renamed from: d  reason: collision with root package name */
    public int f34230d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<a.InterfaceC0389a> f34231e;

    /* renamed from: f  reason: collision with root package name */
    public final String f34232f;

    /* renamed from: g  reason: collision with root package name */
    public String f34233g;

    /* renamed from: h  reason: collision with root package name */
    public String f34234h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34235i;
    public com.kwai.filedownloader.d.b j;
    public i k;
    public Object l;
    public final Object t;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public int p = 100;
    public int q = 10;
    public boolean r = false;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f34227a = 0;
    public boolean s = false;
    public final Object u = new Object();
    public volatile boolean v = false;

    /* loaded from: classes6.dex */
    public static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final c f34236a;

        public a(c cVar) {
            this.f34236a = cVar;
            cVar.s = true;
        }

        @Override // com.kwai.filedownloader.a.c
        public int a() {
            int h2 = this.f34236a.h();
            if (com.kwai.filedownloader.f.d.f34363a) {
                com.kwai.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(h2));
            }
            h.a().c(this.f34236a);
            return h2;
        }
    }

    public c(String str) {
        this.f34232f = str;
        Object obj = new Object();
        this.t = obj;
        d dVar = new d(this, obj);
        this.f34228b = dVar;
        this.f34229c = dVar;
    }

    private int T() {
        if (!P()) {
            if (!d()) {
                J();
            }
            this.f34228b.e();
            return h();
        } else if (c()) {
            throw new IllegalStateException(com.kwai.filedownloader.f.f.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(h())));
        } else {
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.f34228b.toString());
        }
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
        return this.f34228b.m();
    }

    @Override // com.kwai.filedownloader.a
    public boolean C() {
        return this.n;
    }

    @Override // com.kwai.filedownloader.a
    public boolean D() {
        return this.f34228b.n();
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
        return this.f34229c;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean H() {
        return com.kwai.filedownloader.d.d.a(v());
    }

    @Override // com.kwai.filedownloader.a.b
    public int I() {
        return this.f34227a;
    }

    @Override // com.kwai.filedownloader.a.b
    public void J() {
        this.f34227a = p() != null ? p().hashCode() : hashCode();
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
        this.f34228b.o();
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
        ArrayList<a.InterfaceC0389a> arrayList = this.f34231e;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean P() {
        return this.f34228b.g() != 0;
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
    public ArrayList<a.InterfaceC0389a> S() {
        return this.f34231e;
    }

    @Override // com.kwai.filedownloader.a
    public a.c a() {
        return new a();
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(int i2) {
        this.m = i2;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(i iVar) {
        this.k = iVar;
        if (com.kwai.filedownloader.f.d.f34363a) {
            com.kwai.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public com.kwai.filedownloader.a a(Object obj) {
        this.l = obj;
        if (com.kwai.filedownloader.f.d.f34363a) {
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
        this.f34233g = str;
        if (com.kwai.filedownloader.f.d.f34363a) {
            com.kwai.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.f34235i = z;
        this.f34234h = z ? null : new File(str).getName();
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
                    return this;
                }
            }
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
        this.f34227a = 0;
        this.s = false;
        this.v = false;
        this.f34228b.i();
        return true;
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean b(int i2) {
        return h() == i2;
    }

    @Override // com.kwai.filedownloader.d.a
    public void c(String str) {
        this.f34234h = str;
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
        return this.f34227a != 0;
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
        boolean f2;
        synchronized (this.t) {
            f2 = this.f34228b.f();
        }
        return f2;
    }

    @Override // com.kwai.filedownloader.a
    public boolean g() {
        return f();
    }

    @Override // com.kwai.filedownloader.a
    public int h() {
        int i2 = this.f34230d;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(this.f34233g) || TextUtils.isEmpty(this.f34232f)) {
            return 0;
        }
        int a2 = com.kwai.filedownloader.f.f.a(this.f34232f, this.f34233g, this.f34235i);
        this.f34230d = a2;
        return a2;
    }

    @Override // com.kwai.filedownloader.a
    public String i() {
        return this.f34232f;
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
        return this.f34233g;
    }

    @Override // com.kwai.filedownloader.a
    public boolean m() {
        return this.f34235i;
    }

    @Override // com.kwai.filedownloader.a
    public String n() {
        return this.f34234h;
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
        if (this.f34228b.j() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.f34228b.j();
    }

    @Override // com.kwai.filedownloader.a
    public long r() {
        return this.f34228b.j();
    }

    @Override // com.kwai.filedownloader.a
    public int s() {
        if (this.f34228b.k() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.f34228b.k();
    }

    @Override // com.kwai.filedownloader.a
    public long t() {
        return this.f34228b.k();
    }

    public String toString() {
        return com.kwai.filedownloader.f.f.a("%d@%s", Integer.valueOf(h()), super.toString());
    }

    @Override // com.kwai.filedownloader.a
    public int u() {
        return this.f34228b.b();
    }

    @Override // com.kwai.filedownloader.a
    public byte v() {
        return this.f34228b.g();
    }

    @Override // com.kwai.filedownloader.a
    public long w() {
        return this.f34228b.h();
    }

    @Override // com.kwai.filedownloader.a
    public boolean x() {
        return this.r;
    }

    @Override // com.kwai.filedownloader.a
    public Throwable y() {
        return this.f34228b.l();
    }

    @Override // com.kwai.filedownloader.a
    public Object z() {
        return this.l;
    }
}
