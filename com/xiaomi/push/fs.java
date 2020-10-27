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
/* loaded from: classes12.dex */
public abstract class fs {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f4909a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f356a;

    /* renamed from: a  reason: collision with other field name */
    protected ft f359a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f361a;

    /* renamed from: a  reason: collision with other field name */
    protected int f357a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f358a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f366b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f369c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f364a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fv> f363a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<fx, a> f365a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<fx, a> f368b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected ge f360a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f362a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f367b = "";
    private int c = 2;
    protected final int b = f4909a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private fx f4910a;

        /* renamed from: a  reason: collision with other field name */
        private gf f370a;

        public a(fx fxVar, gf gfVar) {
            this.f4910a = fxVar;
            this.f370a = gfVar;
        }

        public void a(fl flVar) {
            this.f4910a.a(flVar);
        }

        public void a(gj gjVar) {
            if (this.f370a == null || this.f370a.a(gjVar)) {
                this.f4910a.a(gjVar);
            }
        }
    }

    static {
        f356a = false;
        try {
            f356a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        fy.m304a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fs(XMPushService xMPushService, ft ftVar) {
        this.f359a = ftVar;
        this.f361a = xMPushService;
        m297b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m291a(int i) {
        synchronized (this.f364a) {
            if (i == 1) {
                this.f364a.clear();
            } else {
                this.f364a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f364a.size() > 6) {
                    this.f364a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f357a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m292a() {
        return this.f369c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ft m293a() {
        return this.f359a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m294a() {
        return this.f359a.c();
    }

    public void a(int i, int i2, Exception exc) {
        if (i != this.c) {
            com.xiaomi.channel.commonutils.logger.b.m54a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(this.c), a(i), com.xiaomi.push.service.at.a(i2)));
        }
        if (az.b(this.f361a)) {
            m291a(i);
        }
        if (i == 1) {
            this.f361a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m54a("try set connected while not connecting.");
            }
            this.c = i;
            for (fv fvVar : this.f363a) {
                fvVar.a(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m54a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fv fvVar2 : this.f363a) {
                fvVar2.b(this);
            }
        } else if (i == 2) {
            this.f361a.a(10);
            if (this.c == 0) {
                for (fv fvVar3 : this.f363a) {
                    fvVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.c == 1) {
                for (fv fvVar4 : this.f363a) {
                    fvVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fv fvVar) {
        if (fvVar == null || this.f363a.contains(fvVar)) {
            return;
        }
        this.f363a.add(fvVar);
    }

    public void a(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f365a.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void a(gj gjVar);

    public abstract void a(ap.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m54a("setChallenge hash = " + be.a(str).substring(0, 8));
            this.f362a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m54a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m295a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m296b() {
        return this.f359a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m297b() {
        String str;
        Class<?> cls = null;
        if (this.f359a.m302a() && this.f360a == null) {
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
                this.f360a = new bn(this);
                return;
            }
            try {
                this.f360a = (ge) cls.getConstructor(fs.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fv fvVar) {
        this.f363a.remove(fvVar);
    }

    public void b(fx fxVar, gf gfVar) {
        if (fxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f368b.put(fxVar, new a(fxVar, gfVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m298b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = System.currentTimeMillis();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m299c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f364a) {
            this.f364a.clear();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public synchronized boolean m300d() {
        return System.currentTimeMillis() - this.e < ((long) fy.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.d < ((long) (fy.a() << 1));
    }
}
