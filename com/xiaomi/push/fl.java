package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class fl {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f37588a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f388a;

    /* renamed from: a  reason: collision with other field name */
    public fm f391a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f393a;

    /* renamed from: a  reason: collision with other field name */
    public int f389a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f390a = -1;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f398b = 0;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f401c = 0;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f396a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fo> f395a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Map<fq, a> f397a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    public final Map<fq, a> f400b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public fx f392a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f394a = "";

    /* renamed from: b  reason: collision with other field name */
    public String f399b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f37590c = 2;

    /* renamed from: b  reason: collision with root package name */
    public final int f37589b = f37588a.getAndIncrement();

    /* renamed from: e  reason: collision with root package name */
    public long f37592e = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f37591d = 0;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public fq f37593a;

        /* renamed from: a  reason: collision with other field name */
        public fy f402a;

        public a(fq fqVar, fy fyVar) {
            this.f37593a = fqVar;
            this.f402a = fyVar;
        }

        public void a(fa faVar) {
            this.f37593a.a(faVar);
        }

        public void a(gc gcVar) {
            fy fyVar = this.f402a;
            if (fyVar == null || fyVar.a(gcVar)) {
                this.f37593a.a(gcVar);
            }
        }
    }

    static {
        f388a = false;
        try {
            f388a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fr.m318a();
    }

    public fl(XMPushService xMPushService, fm fmVar) {
        this.f391a = fmVar;
        this.f393a = xMPushService;
        m312b();
    }

    private String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m305a(int i2) {
        synchronized (this.f396a) {
            if (i2 == 1) {
                this.f396a.clear();
            } else {
                this.f396a.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.f396a.size() > 6) {
                    this.f396a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f389a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m306a() {
        return this.f401c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fm m307a() {
        return this.f391a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m308a() {
        return this.f391a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<fq, a> m309a() {
        return this.f397a;
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.f37590c;
        if (i2 != i4) {
            com.xiaomi.channel.commonutils.logger.b.m57a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), com.xiaomi.push.service.az.a(i3)));
        }
        if (bg.b(this.f393a)) {
            m305a(i2);
        }
        if (i2 == 1) {
            this.f393a.a(10);
            if (this.f37590c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m57a("try set connected while not connecting.");
            }
            this.f37590c = i2;
            for (fo foVar : this.f395a) {
                foVar.b(this);
            }
        } else if (i2 == 0) {
            if (this.f37590c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m57a("try set connecting while not disconnected.");
            }
            this.f37590c = i2;
            for (fo foVar2 : this.f395a) {
                foVar2.a(this);
            }
        } else if (i2 == 2) {
            this.f393a.a(10);
            int i5 = this.f37590c;
            if (i5 == 0) {
                for (fo foVar3 : this.f395a) {
                    foVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                for (fo foVar4 : this.f395a) {
                    foVar4.a(this, i3, exc);
                }
            }
            this.f37590c = i2;
        }
    }

    public void a(fo foVar) {
        if (foVar == null || this.f395a.contains(foVar)) {
            return;
        }
        this.f395a.add(foVar);
    }

    public void a(fq fqVar, fy fyVar) {
        if (fqVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f397a.put(fqVar, new a(fqVar, fyVar));
    }

    public abstract void a(gc gcVar);

    public abstract void a(av.b bVar);

    public synchronized void a(String str) {
        if (this.f37590c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m57a("setChallenge hash = " + bl.a(str).substring(0, 8));
            this.f394a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m57a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fa[] faVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m310a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.f37592e >= j;
    }

    public int b() {
        return this.f37590c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m311b() {
        return this.f391a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m312b() {
        String str;
        if (this.f391a.m316a() && this.f392a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f392a = new fj(this);
                return;
            }
            try {
                this.f392a = (fx) cls.getConstructor(fl.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public abstract void b(int i2, Exception exc);

    public abstract void b(fa faVar);

    public void b(fo foVar) {
        this.f395a.remove(foVar);
    }

    public void b(fq fqVar, fy fyVar) {
        if (fqVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f400b.put(fqVar, new a(fqVar, fyVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m313b() {
        return this.f37590c == 0;
    }

    public synchronized void c() {
        this.f37592e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m314c() {
        return this.f37590c == 1;
    }

    public void d() {
        synchronized (this.f396a) {
            this.f396a.clear();
        }
    }
}
