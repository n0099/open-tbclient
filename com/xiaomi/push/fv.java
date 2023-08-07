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
    public static boolean f406a;

    /* renamed from: a  reason: collision with other field name */
    public fw f409a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f411a;

    /* renamed from: a  reason: collision with other field name */
    public int f407a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f408a = -1;

    /* renamed from: b  reason: collision with other field name */
    public volatile long f416b = 0;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f419c = 0;

    /* renamed from: a  reason: collision with other field name */
    public LinkedList<Pair<Integer, Long>> f414a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Collection<fy> f413a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Map<ga, a> f415a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    public final Map<ga, a> f418b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public gh f410a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f412a = "";

    /* renamed from: b  reason: collision with other field name */
    public String f417b = "";
    public int c = 2;
    public final int b = a.getAndIncrement();
    public long e = 0;
    public long d = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public ga a;

        /* renamed from: a  reason: collision with other field name */
        public gi f420a;

        public a(ga gaVar, gi giVar) {
            this.a = gaVar;
            this.f420a = giVar;
        }

        public void a(fk fkVar) {
            this.a.a(fkVar);
        }

        public void a(gm gmVar) {
            gi giVar = this.f420a;
            if (giVar == null || giVar.mo498a(gmVar)) {
                this.a.a(gmVar);
            }
        }
    }

    static {
        f406a = false;
        try {
            f406a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        gb.m520a();
    }

    public fv(XMPushService xMPushService, fw fwVar) {
        this.f409a = fwVar;
        this.f411a = xMPushService;
        m505b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m499a(int i) {
        synchronized (this.f414a) {
            if (i == 1) {
                this.f414a.clear();
            } else {
                this.f414a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f414a.size() > 6) {
                    this.f414a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f407a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m500a() {
        return this.f419c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m501a() {
        return this.f409a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo502a() {
        return this.f409a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<ga, a> m503a() {
        return this.f415a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m178a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bi.b(this.f411a)) {
            m499a(i);
        }
        if (i == 1) {
            this.f411a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m178a("try set connected while not connecting.");
            }
            this.c = i;
            for (fy fyVar : this.f413a) {
                fyVar.b(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m178a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fy fyVar2 : this.f413a) {
                fyVar2.a(this);
            }
        } else if (i == 2) {
            this.f411a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fy fyVar3 : this.f413a) {
                    fyVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fy fyVar4 : this.f413a) {
                    fyVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fy fyVar) {
        if (fyVar == null || this.f413a.contains(fyVar)) {
            return;
        }
        this.f413a.add(fyVar);
    }

    public void a(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f415a.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void a(gm gmVar);

    public abstract void a(bg.b bVar);

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m178a("setChallenge hash = " + bn.a(str).substring(0, 8));
            this.f412a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m178a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fk[] fkVarArr);

    /* renamed from: a */
    public boolean mo494a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m504b() {
        return this.f409a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m505b() {
        String str;
        if (this.f409a.m509a() && this.f410a == null) {
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
                this.f410a = new ft(this);
                return;
            }
            try {
                this.f410a = (gh) cls.getConstructor(fv.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fk fkVar);

    public void b(fy fyVar) {
        this.f413a.remove(fyVar);
    }

    public void b(ga gaVar, gi giVar) {
        if (gaVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f418b.put(gaVar, new a(gaVar, giVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m506b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m507c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f414a) {
            this.f414a.clear();
        }
    }
}
