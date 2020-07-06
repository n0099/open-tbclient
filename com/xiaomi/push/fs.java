package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
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
public abstract class fs {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f364a;

    /* renamed from: a  reason: collision with other field name */
    protected ft f367a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f369a;

    /* renamed from: a  reason: collision with other field name */
    protected int f365a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f366a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f374b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f377c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f372a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fv> f371a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fx, a> f373a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fx, a> f376b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected ge f368a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f370a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f375b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes8.dex */
    public static class a {
        private fx a;

        /* renamed from: a  reason: collision with other field name */
        private gf f378a;

        public a(fx fxVar, gf gfVar) {
            this.a = fxVar;
            this.f378a = gfVar;
        }

        public void a(fl flVar) {
            this.a.a(flVar);
        }

        public void a(gj gjVar) {
            if (this.f378a == null || this.f378a.a(gjVar)) {
                this.a.a(gjVar);
            }
        }
    }

    static {
        f364a = false;
        try {
            f364a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fy.m298a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fs(XMPushService xMPushService, ft ftVar) {
        this.f367a = ftVar;
        this.f369a = xMPushService;
        m291b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m285a(int i) {
        synchronized (this.f372a) {
            if (i == 1) {
                this.f372a.clear();
            } else {
                this.f372a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f372a.size() > 6) {
                    this.f372a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f365a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m286a() {
        return this.f377c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ft m287a() {
        return this.f367a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m288a() {
        return this.f367a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m48a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.at.a(i2)));
        }
        if (az.b(this.f369a)) {
            m285a(i);
        }
        if (i == 1) {
            this.f369a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m48a("try set connected while not connecting.");
            }
            this.c = i;
            for (fv fvVar : this.f371a) {
                fvVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fv fvVar2 : this.f371a) {
                fvVar2.b(this);
            }
        } else if (i == 2) {
            this.f369a.a(10);
            if (this.c == 0) {
                for (fv fvVar3 : this.f371a) {
                    fvVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fv fvVar4 : this.f371a) {
                    fvVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fv fvVar) {
        if (fvVar == null || this.f371a.contains(fvVar)) {
            return;
        }
        this.f371a.add(fvVar);
    }

    public void a(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f373a.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void a(gj gjVar);

    public abstract void a(ap.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m48a("setChallenge hash = " + be.a(str).substring(0, 8));
            this.f370a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m48a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m289a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m290b() {
        return this.f367a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m291b() {
        String str;
        Class<?> cls = null;
        if (this.f367a.m296a() && this.f368a == null) {
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
                this.f368a = new bn(this);
                return;
            }
            try {
                this.f368a = (ge) cls.getConstructor(fs.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fv fvVar) {
        this.f371a.remove(fvVar);
    }

    public void b(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f376b.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m292b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m293c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f372a) {
            this.f372a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m294d() {
        return System.currentTimeMillis() - this.e < ((long) fy.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fy.a() << 1));
    }
}
