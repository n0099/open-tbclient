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
    public static boolean f407a;

    /* renamed from: a  reason: collision with other field name */
    public fw f410a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f412a;

    /* renamed from: a  reason: collision with other field name */
    public int f408a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f409a = -1;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f417b = 0;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f420c = 0;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f415a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fy> f414a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Map<ga, a> f416a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    public final Map<ga, a> f419b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public gh f411a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f413a = "";

    /* renamed from: b  reason: collision with other field name */
    public String f418b = "";
    public int c = 2;
    public final int b = a.getAndIncrement();
    public long e = 0;
    public long d = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public ga a;

        /* renamed from: a  reason: collision with other field name */
        public gi f421a;

        public a(ga gaVar, gi giVar) {
            this.a = gaVar;
            this.f421a = giVar;
        }

        public void a(fk fkVar) {
            this.a.a(fkVar);
        }

        public void a(gm gmVar) {
            gi giVar = this.f421a;
            if (giVar == null || giVar.mo500a(gmVar)) {
                this.a.a(gmVar);
            }
        }
    }

    static {
        f407a = false;
        try {
            f407a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        gb.m522a();
    }

    public fv(XMPushService xMPushService, fw fwVar) {
        this.f410a = fwVar;
        this.f412a = xMPushService;
        m507b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m501a(int i) {
        synchronized (this.f415a) {
            if (i == 1) {
                this.f415a.clear();
            } else {
                this.f415a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f415a.size() > 6) {
                    this.f415a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f408a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m502a() {
        return this.f420c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m503a() {
        return this.f410a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo504a() {
        return this.f410a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<ga, a> m505a() {
        return this.f416a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m180a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bi.b(this.f412a)) {
            m501a(i);
        }
        if (i == 1) {
            this.f412a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m180a("try set connected while not connecting.");
            }
            this.c = i;
            for (fy fyVar : this.f414a) {
                fyVar.b(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m180a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fy fyVar2 : this.f414a) {
                fyVar2.a(this);
            }
        } else if (i == 2) {
            this.f412a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fy fyVar3 : this.f414a) {
                    fyVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fy fyVar4 : this.f414a) {
                    fyVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fy fyVar) {
        if (fyVar == null || this.f414a.contains(fyVar)) {
            return;
        }
        this.f414a.add(fyVar);
    }

    public void a(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f416a.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void a(gm gmVar);

    public abstract void a(bg.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m180a("setChallenge hash = " + bn.a(str).substring(0, 8));
            this.f413a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m180a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fk[] fkVarArr);

    /* renamed from: a */
    public boolean mo496a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m506b() {
        return this.f410a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m507b() {
        String str;
        if (this.f410a.m511a() && this.f411a == null) {
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
                this.f411a = new ft(this);
                return;
            }
            try {
                this.f411a = (gh) cls.getConstructor(fv.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fk fkVar);

    public void b(fy fyVar) {
        this.f414a.remove(fyVar);
    }

    public void b(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f419b.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m508b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m509c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f415a) {
            this.f415a.clear();
        }
    }
}
