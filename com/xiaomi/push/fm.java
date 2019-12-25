package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public abstract class fm {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f376a;

    /* renamed from: a  reason: collision with other field name */
    protected fn f379a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f381a;

    /* renamed from: a  reason: collision with other field name */
    protected int f377a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f378a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f386b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f389c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f384a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fp> f383a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fr, a> f385a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fr, a> f388b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected fy f380a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f382a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f387b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes5.dex */
    public static class a {
        private fr a;

        /* renamed from: a  reason: collision with other field name */
        private fz f390a;

        public a(fr frVar, fz fzVar) {
            this.a = frVar;
            this.f390a = fzVar;
        }

        public void a(ff ffVar) {
            this.a.a(ffVar);
        }

        public void a(gd gdVar) {
            if (this.f390a == null || this.f390a.a(gdVar)) {
                this.a.a(gdVar);
            }
        }
    }

    static {
        f376a = false;
        try {
            f376a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fs.m279a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fm(XMPushService xMPushService, fn fnVar) {
        this.f379a = fnVar;
        this.f381a = xMPushService;
        m272b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m266a(int i) {
        synchronized (this.f384a) {
            if (i == 1) {
                this.f384a.clear();
            } else {
                this.f384a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f384a.size() > 6) {
                    this.f384a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f377a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m267a() {
        return this.f389c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fn m268a() {
        return this.f379a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m269a() {
        return this.f379a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m33a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.ap.a(i2)));
        }
        if (as.b(this.f381a)) {
            m266a(i);
        }
        if (i == 1) {
            this.f381a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m33a("try set connected while not connecting.");
            }
            this.c = i;
            for (fp fpVar : this.f383a) {
                fpVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m33a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fp fpVar2 : this.f383a) {
                fpVar2.b(this);
            }
        } else if (i == 2) {
            this.f381a.a(10);
            if (this.c == 0) {
                for (fp fpVar3 : this.f383a) {
                    fpVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fp fpVar4 : this.f383a) {
                    fpVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fp fpVar) {
        if (fpVar == null || this.f383a.contains(fpVar)) {
            return;
        }
        this.f383a.add(fpVar);
    }

    public void a(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f385a.put(frVar, new a(frVar, fzVar));
    }

    public abstract void a(gd gdVar);

    public abstract void a(al.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m33a("setChallenge hash = " + ax.a(str).substring(0, 8));
            this.f382a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m33a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(ff[] ffVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m270a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m271b() {
        return this.f379a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m272b() {
        String str;
        Class<?> cls = null;
        if (this.f379a.m277a() && this.f380a == null) {
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable th) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f380a = new bi(this);
                return;
            }
            try {
                this.f380a = (fy) cls.getConstructor(fm.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(ff ffVar);

    public void b(fp fpVar) {
        this.f383a.remove(fpVar);
    }

    public void b(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f388b.put(frVar, new a(frVar, fzVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m273b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m274c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f384a) {
            this.f384a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m275d() {
        return System.currentTimeMillis() - this.e < ((long) fs.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fs.a() << 1));
    }
}
