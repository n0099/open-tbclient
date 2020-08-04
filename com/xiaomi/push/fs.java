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
/* loaded from: classes9.dex */
public abstract class fs {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f363a;

    /* renamed from: a  reason: collision with other field name */
    protected ft f366a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f368a;

    /* renamed from: a  reason: collision with other field name */
    protected int f364a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f365a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f373b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f376c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f371a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fv> f370a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fx, a> f372a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fx, a> f375b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected ge f367a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f369a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f374b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes9.dex */
    public static class a {
        private fx a;

        /* renamed from: a  reason: collision with other field name */
        private gf f377a;

        public a(fx fxVar, gf gfVar) {
            this.a = fxVar;
            this.f377a = gfVar;
        }

        public void a(fl flVar) {
            this.a.a(flVar);
        }

        public void a(gj gjVar) {
            if (this.f377a == null || this.f377a.a(gjVar)) {
                this.a.a(gjVar);
            }
        }
    }

    static {
        f363a = false;
        try {
            f363a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fy.m299a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fs(XMPushService xMPushService, ft ftVar) {
        this.f366a = ftVar;
        this.f368a = xMPushService;
        m292b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m286a(int i) {
        synchronized (this.f371a) {
            if (i == 1) {
                this.f371a.clear();
            } else {
                this.f371a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f371a.size() > 6) {
                    this.f371a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f364a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m287a() {
        return this.f376c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ft m288a() {
        return this.f366a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m289a() {
        return this.f366a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m49a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.at.a(i2)));
        }
        if (az.b(this.f368a)) {
            m286a(i);
        }
        if (i == 1) {
            this.f368a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m49a("try set connected while not connecting.");
            }
            this.c = i;
            for (fv fvVar : this.f370a) {
                fvVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m49a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fv fvVar2 : this.f370a) {
                fvVar2.b(this);
            }
        } else if (i == 2) {
            this.f368a.a(10);
            if (this.c == 0) {
                for (fv fvVar3 : this.f370a) {
                    fvVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fv fvVar4 : this.f370a) {
                    fvVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fv fvVar) {
        if (fvVar == null || this.f370a.contains(fvVar)) {
            return;
        }
        this.f370a.add(fvVar);
    }

    public void a(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f372a.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void a(gj gjVar);

    public abstract void a(ap.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m49a("setChallenge hash = " + be.a(str).substring(0, 8));
            this.f369a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m49a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m290a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m291b() {
        return this.f366a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m292b() {
        String str;
        Class<?> cls = null;
        if (this.f366a.m297a() && this.f367a == null) {
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
                this.f367a = new bn(this);
                return;
            }
            try {
                this.f367a = (ge) cls.getConstructor(fs.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fv fvVar) {
        this.f370a.remove(fvVar);
    }

    public void b(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f375b.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m293b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m294c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f371a) {
            this.f371a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m295d() {
        return System.currentTimeMillis() - this.e < ((long) fy.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fy.a() << 1));
    }
}
