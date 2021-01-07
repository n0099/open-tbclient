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
/* loaded from: classes6.dex */
public abstract class fs {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f14327a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f438a;

    /* renamed from: a  reason: collision with other field name */
    protected ft f441a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f443a;

    /* renamed from: a  reason: collision with other field name */
    protected int f439a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f440a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f448b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f451c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f446a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fv> f445a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fx, a> f447a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fx, a> f450b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected ge f442a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f444a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f449b = "";
    private int c = 2;

    /* renamed from: b  reason: collision with root package name */
    protected final int f14328b = f14327a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private fx f14329a;

        /* renamed from: a  reason: collision with other field name */
        private gf f452a;

        public a(fx fxVar, gf gfVar) {
            this.f14329a = fxVar;
            this.f452a = gfVar;
        }

        public void a(fl flVar) {
            this.f14329a.a(flVar);
        }

        public void a(gj gjVar) {
            if (this.f452a == null || this.f452a.a(gjVar)) {
                this.f14329a.a(gjVar);
            }
        }
    }

    static {
        f438a = false;
        try {
            f438a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fy.m334a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fs(XMPushService xMPushService, ft ftVar) {
        this.f441a = ftVar;
        this.f443a = xMPushService;
        m327b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m321a(int i) {
        synchronized (this.f446a) {
            if (i == 1) {
                this.f446a.clear();
            } else {
                this.f446a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f446a.size() > 6) {
                    this.f446a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f439a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m322a() {
        return this.f451c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ft m323a() {
        return this.f441a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m324a() {
        return this.f441a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m84a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.at.a(i2)));
        }
        if (az.b(this.f443a)) {
            m321a(i);
        }
        if (i == 1) {
            this.f443a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m84a("try set connected while not connecting.");
            }
            this.c = i;
            for (fv fvVar : this.f445a) {
                fvVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m84a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fv fvVar2 : this.f445a) {
                fvVar2.b(this);
            }
        } else if (i == 2) {
            this.f443a.a(10);
            if (this.c == 0) {
                for (fv fvVar3 : this.f445a) {
                    fvVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fv fvVar4 : this.f445a) {
                    fvVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fv fvVar) {
        if (fvVar == null || this.f445a.contains(fvVar)) {
            return;
        }
        this.f445a.add(fvVar);
    }

    public void a(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f447a.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void a(gj gjVar);

    public abstract void a(ap.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m84a("setChallenge hash = " + be.a(str).substring(0, 8));
            this.f444a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m84a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m325a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m326b() {
        return this.f441a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m327b() {
        String str;
        Class<?> cls = null;
        if (this.f441a.m332a() && this.f442a == null) {
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
                this.f442a = new bn(this);
                return;
            }
            try {
                this.f442a = (ge) cls.getConstructor(fs.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fv fvVar) {
        this.f445a.remove(fvVar);
    }

    public void b(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f450b.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m328b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m329c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f446a) {
            this.f446a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m330d() {
        return System.currentTimeMillis() - this.e < ((long) fy.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fy.a() << 1));
    }
}
