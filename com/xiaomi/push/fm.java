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
/* loaded from: classes8.dex */
public abstract class fm {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f372a;

    /* renamed from: a  reason: collision with other field name */
    protected fn f375a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f377a;

    /* renamed from: a  reason: collision with other field name */
    protected int f373a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f374a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f382b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f385c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f380a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fp> f379a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fr, a> f381a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fr, a> f384b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected fy f376a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f378a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f383b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes8.dex */
    public static class a {
        private fr a;

        /* renamed from: a  reason: collision with other field name */
        private fz f386a;

        public a(fr frVar, fz fzVar) {
            this.a = frVar;
            this.f386a = fzVar;
        }

        public void a(ff ffVar) {
            this.a.a(ffVar);
        }

        public void a(gd gdVar) {
            if (this.f386a == null || this.f386a.a(gdVar)) {
                this.a.a(gdVar);
            }
        }
    }

    static {
        f372a = false;
        try {
            f372a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fs.m293a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fm(XMPushService xMPushService, fn fnVar) {
        this.f375a = fnVar;
        this.f377a = xMPushService;
        m286b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m280a(int i) {
        synchronized (this.f380a) {
            if (i == 1) {
                this.f380a.clear();
            } else {
                this.f380a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f380a.size() > 6) {
                    this.f380a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f373a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m281a() {
        return this.f385c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fn m282a() {
        return this.f375a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m283a() {
        return this.f375a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m47a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.ap.a(i2)));
        }
        if (as.b(this.f377a)) {
            m280a(i);
        }
        if (i == 1) {
            this.f377a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m47a("try set connected while not connecting.");
            }
            this.c = i;
            for (fp fpVar : this.f379a) {
                fpVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m47a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fp fpVar2 : this.f379a) {
                fpVar2.b(this);
            }
        } else if (i == 2) {
            this.f377a.a(10);
            if (this.c == 0) {
                for (fp fpVar3 : this.f379a) {
                    fpVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fp fpVar4 : this.f379a) {
                    fpVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fp fpVar) {
        if (fpVar == null || this.f379a.contains(fpVar)) {
            return;
        }
        this.f379a.add(fpVar);
    }

    public void a(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f381a.put(frVar, new a(frVar, fzVar));
    }

    public abstract void a(gd gdVar);

    public abstract void a(al.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m47a("setChallenge hash = " + ax.a(str).substring(0, 8));
            this.f378a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m47a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(ff[] ffVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m284a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m285b() {
        return this.f375a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m286b() {
        String str;
        Class<?> cls = null;
        if (this.f375a.m291a() && this.f376a == null) {
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
                this.f376a = new bi(this);
                return;
            }
            try {
                this.f376a = (fy) cls.getConstructor(fm.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(ff ffVar);

    public void b(fp fpVar) {
        this.f379a.remove(fpVar);
    }

    public void b(fr frVar, fz fzVar) {
        if (frVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f384b.put(frVar, new a(frVar, fzVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m287b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m288c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f380a) {
            this.f380a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m289d() {
        return System.currentTimeMillis() - this.e < ((long) fs.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fs.a() << 1));
    }
}
