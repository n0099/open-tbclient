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
/* loaded from: classes6.dex */
public abstract class fm {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f374a;

    /* renamed from: a  reason: collision with other field name */
    protected fn f377a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f379a;

    /* renamed from: a  reason: collision with other field name */
    protected int f375a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f376a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f384b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f387c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f382a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fp> f381a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fr, a> f383a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fr, a> f386b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected fy f378a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f380a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f385b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes6.dex */
    public static class a {
        private fr a;

        /* renamed from: a  reason: collision with other field name */
        private fz f388a;

        public a(fr frVar, fz fzVar) {
            this.a = frVar;
            this.f388a = fzVar;
        }

        public void a(ff ffVar) {
            this.a.a(ffVar);
        }

        public void a(gd gdVar) {
            if (this.f388a == null || this.f388a.a(gdVar)) {
                this.a.a(gdVar);
            }
        }
    }

    static {
        f374a = false;
        try {
            f374a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fs.m288a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fm(XMPushService xMPushService, fn fnVar) {
        this.f377a = fnVar;
        this.f379a = xMPushService;
        m281b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m275a(int i) {
        synchronized (this.f382a) {
            if (i == 1) {
                this.f382a.clear();
            } else {
                this.f382a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f382a.size() > 6) {
                    this.f382a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f375a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m276a() {
        return this.f387c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fn m277a() {
        return this.f377a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m278a() {
        return this.f377a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m42a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.ap.a(i2)));
        }
        if (as.b(this.f379a)) {
            m275a(i);
        }
        if (i == 1) {
            this.f379a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m42a("try set connected while not connecting.");
            }
            this.c = i;
            for (fp fpVar : this.f381a) {
                fpVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m42a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fp fpVar2 : this.f381a) {
                fpVar2.b(this);
            }
        } else if (i == 2) {
            this.f379a.a(10);
            if (this.c == 0) {
                for (fp fpVar3 : this.f381a) {
                    fpVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fp fpVar4 : this.f381a) {
                    fpVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fp fpVar) {
        if (fpVar == null || this.f381a.contains(fpVar)) {
            return;
        }
        this.f381a.add(fpVar);
    }

    public void a(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f383a.put(frVar, new a(frVar, fzVar));
    }

    public abstract void a(gd gdVar);

    public abstract void a(al.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m42a("setChallenge hash = " + ax.a(str).substring(0, 8));
            this.f380a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m42a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(ff[] ffVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m279a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m280b() {
        return this.f377a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m281b() {
        String str;
        Class<?> cls = null;
        if (this.f377a.m286a() && this.f378a == null) {
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
                this.f378a = new bi(this);
                return;
            }
            try {
                this.f378a = (fy) cls.getConstructor(fm.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(ff ffVar);

    public void b(fp fpVar) {
        this.f381a.remove(fpVar);
    }

    public void b(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f386b.put(frVar, new a(frVar, fzVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m282b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m283c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f382a) {
            this.f382a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m284d() {
        return System.currentTimeMillis() - this.e < ((long) fs.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fs.a() << 1));
    }
}
