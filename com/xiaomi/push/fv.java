package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class fv {
    public static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f402a;

    /* renamed from: a  reason: collision with other field name */
    public fw f405a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f407a;

    /* renamed from: a  reason: collision with other field name */
    public int f403a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f404a = -1;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f412b = 0;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f415c = 0;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f410a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fy> f409a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Map<ga, a> f411a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    public final Map<ga, a> f414b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public gh f406a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f408a = "";

    /* renamed from: b  reason: collision with other field name */
    public String f413b = "";
    public int c = 2;
    public final int b = a.getAndIncrement();
    public long e = 0;
    public long d = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public ga a;

        /* renamed from: a  reason: collision with other field name */
        public gi f416a;

        public a(ga gaVar, gi giVar) {
            this.a = gaVar;
            this.f416a = giVar;
        }

        public void a(fk fkVar) {
            this.a.a(fkVar);
        }

        public void a(gm gmVar) {
            gi giVar = this.f416a;
            if (giVar == null || giVar.mo510a(gmVar)) {
                this.a.a(gmVar);
            }
        }
    }

    static {
        f402a = false;
        try {
            f402a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        gb.m532a();
    }

    public fv(XMPushService xMPushService, fw fwVar) {
        this.f405a = fwVar;
        this.f407a = xMPushService;
        m517b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m511a(int i) {
        synchronized (this.f410a) {
            if (i == 1) {
                this.f410a.clear();
            } else {
                this.f410a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f410a.size() > 6) {
                    this.f410a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f403a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m512a() {
        return this.f415c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m513a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo514a() {
        return this.f405a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<ga, a> m515a() {
        return this.f411a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m190a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bi.b(this.f407a)) {
            m511a(i);
        }
        if (i == 1) {
            this.f407a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m190a("try set connected while not connecting.");
            }
            this.c = i;
            for (fy fyVar : this.f409a) {
                fyVar.b(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m190a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fy fyVar2 : this.f409a) {
                fyVar2.a(this);
            }
        } else if (i == 2) {
            this.f407a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fy fyVar3 : this.f409a) {
                    fyVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fy fyVar4 : this.f409a) {
                    fyVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fy fyVar) {
        if (fyVar == null || this.f409a.contains(fyVar)) {
            return;
        }
        this.f409a.add(fyVar);
    }

    public void a(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f411a.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void a(gm gmVar);

    public abstract void a(bg.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m190a("setChallenge hash = " + bn.a(str).substring(0, 8));
            this.f408a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m190a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fk[] fkVarArr);

    /* renamed from: a */
    public boolean mo506a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m516b() {
        return this.f405a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m517b() {
        String str;
        if (this.f405a.m521a() && this.f406a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
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
                this.f406a = new ft(this);
                return;
            }
            try {
                this.f406a = (gh) cls.getConstructor(fv.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fk fkVar);

    public void b(fy fyVar) {
        this.f409a.remove(fyVar);
    }

    public void b(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f414b.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m518b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m519c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f410a) {
            this.f410a.clear();
        }
    }
}
