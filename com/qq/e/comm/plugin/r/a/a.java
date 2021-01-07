package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.live.tbadk.pay.PayHelper;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12659a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f12660b;
    private e d;
    private com.qq.e.comm.plugin.r.b.a e;
    private com.qq.e.comm.plugin.r.b.c g;
    private boolean p;
    private int q;
    private final d r;
    private List<com.qq.e.comm.plugin.r.b.c> f = new ArrayList();
    private AtomicInteger h = new AtomicInteger(0);
    private AtomicInteger i = new AtomicInteger(0);
    private Map<com.qq.e.comm.plugin.r.b.c, T> j = new HashMap();
    private Map<T, com.qq.e.comm.plugin.r.b.c> k = new HashMap();
    private T l = null;
    private boolean m = true;
    protected Handler c = new Handler(Looper.getMainLooper());
    private Object n = new Object();
    private b o = b.IDLE;

    /* renamed from: com.qq.e.comm.plugin.r.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected interface InterfaceC1218a {
        void a();

        boolean a(ADEvent aDEvent);

        void b();

        void b(ADEvent aDEvent);

        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum b {
        IDLE,
        LOADING
    }

    public a(Context context, String str) {
        this.r = d.a(context);
        this.e = this.r.a(str);
        this.f12659a = context.getApplicationContext();
        this.f12660b = context;
        if (this.e == null) {
            u.a(70002, 0, new com.qq.e.comm.plugin.y.c().a(str));
            GDTLogger.e("Mediator do not get layer config");
        }
        this.d = new e(this.r.a(), this.r.b(), this.e.e());
        GDTLogger.d("init mediator: posId = " + str + " isSerial = " + i());
        this.q = this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Map<String, Object> map) {
        com.qq.e.comm.plugin.y.d dVar = map == null ? new com.qq.e.comm.plugin.y.d() : new com.qq.e.comm.plugin.y.d(new JSONObject(map));
        dVar.a("isSerial", Boolean.valueOf(i()));
        dVar.a("layer_timeout", Integer.valueOf(this.e == null ? 0 : this.e.b()));
        GDTLogger.d("埋点=" + dVar.toString());
        u.a(i, 0, new com.qq.e.comm.plugin.y.c().a(this.e == null ? "" : this.e.a()), dVar);
    }

    private void e(final T t) {
        this.c.postAtTime(new Runnable() { // from class: com.qq.e.comm.plugin.r.a.a.2
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.qq.e.comm.plugin.r.a.a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int b2 = a.this.b((a) t);
                GDTLogger.d("加载广告=" + t.getClass().getSimpleName());
                HashMap hashMap = new HashMap();
                hashMap.put("adapter", t.getClass().getSimpleName());
                a.this.a(b2, hashMap);
            }
        }, this.n, SystemClock.uptimeMillis());
    }

    private void l() {
        for (Map.Entry<com.qq.e.comm.plugin.r.b.c, T> entry : this.j.entrySet()) {
            e(entry.getValue());
            entry.getKey().c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.o = b.IDLE;
        this.c.removeCallbacksAndMessages(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.o == b.LOADING) {
            g();
            m();
            if (this.g != null) {
                a((a<T>) this.j.get(this.g));
            } else {
                a((a<T>) null);
            }
        }
    }

    protected abstract void a();

    public void a(int i) {
        if (i > 0) {
            this.q = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.qq.e.comm.plugin.r.b.c cVar) {
        HashMap hashMap = new HashMap();
        if (cVar != null) {
            hashMap.put("config_name", cVar.a());
            hashMap.put("config_class_name", cVar.e());
            hashMap.put("identity", cVar.b());
        }
        a(i, hashMap);
    }

    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t, int i) {
        if (this.d != null) {
            this.d.a(this.k.get(t));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t.getClass().getSimpleName());
        a(i, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t, int i, boolean z, int i2) {
        com.qq.e.comm.plugin.r.b.c cVar = this.k.get(t);
        if (cVar != null) {
            cVar.a(i);
            cVar.a(z);
            cVar.b(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t, long j, boolean z, int i) {
        com.qq.e.comm.plugin.r.b.c cVar = this.k.get(t);
        if (cVar != null) {
            cVar.d(z);
            GDTLogger.d("广告拉取完毕，" + t.getClass().getSimpleName() + "加载" + (z ? "成功" : PayHelper.STATUS_FAIL_DESC) + "，耗时=" + j);
            cVar.b(!j() && z);
            try {
                cVar.c((int) j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int incrementAndGet = this.i.incrementAndGet();
        if (i() && z && c((a<T>) t)) {
            m();
        }
        if (!i() && incrementAndGet == this.j.size()) {
            n();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t.getClass().getSimpleName());
        if (cVar != null) {
            hashMap.put("adapter_timeout", Integer.valueOf(cVar.h()));
            hashMap.put("adapter_duration", Integer.valueOf(cVar.p()));
        }
        a(i, hashMap);
    }

    protected abstract int b(T t);

    protected abstract T b(com.qq.e.comm.plugin.r.b.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(T t, int i) {
        if (this.d != null) {
            this.d.b(this.k.get(t));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t.getClass().getSimpleName());
        a(i, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        boolean z = false;
        if (this.h.get() >= this.f.size() || this.o != b.LOADING) {
            this.g = null;
        } else {
            com.qq.e.comm.plugin.r.b.c cVar = this.f.get(this.h.get());
            final T t = this.j.get(cVar);
            this.l = t;
            e(t);
            if (this.m && cVar.h() > 0) {
                this.c.postAtTime(new Runnable() { // from class: com.qq.e.comm.plugin.r.a.a.1
                    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.qq.e.comm.plugin.r.a.a */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.c((a) t) || a.this.b()) {
                            return;
                        }
                        a.this.a();
                    }
                }, this.n, SystemClock.uptimeMillis() + cVar.h());
            }
            cVar.c(true);
            this.g = cVar;
            z = true;
        }
        this.h.getAndIncrement();
        if (!z) {
            if (this.o == b.LOADING) {
                h();
            }
            m();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.e == null || b.IDLE != this.o) {
            GDTLogger.w("Mediator last loading not finish");
            return;
        }
        GDTLogger.d(this.e.a() + " preLoadAd");
        if (i()) {
            a(70082, (Map<String, Object>) null);
        } else {
            a(70092, (Map<String, Object>) null);
        }
        e();
        f();
        Iterator<com.qq.e.comm.plugin.r.b.c> it = this.f.iterator();
        while (it.hasNext()) {
            com.qq.e.comm.plugin.r.b.c next = it.next();
            if (!this.j.containsKey(next) || this.j.get(next) == null) {
                T b2 = b(next);
                if (b2 == null) {
                    it.remove();
                } else {
                    this.j.put(next, b2);
                    this.k.put(b2, next);
                }
            }
        }
        this.r.a(false, true);
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(T t) {
        if (t == null || this.l == null || t != this.l) {
            return false;
        }
        b bVar = this.o;
        b bVar2 = this.o;
        return bVar == b.LOADING;
    }

    protected void d() {
        this.o = b.LOADING;
        if (!i()) {
            l();
        } else if (!b()) {
            a();
        }
        this.c.postAtTime(new Runnable() { // from class: com.qq.e.comm.plugin.r.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.i()) {
                    a.this.p = true;
                    if (a.this.o == b.LOADING) {
                        a.this.a();
                        a.this.g = null;
                        a.this.h();
                    }
                } else {
                    a.this.n();
                }
                a.this.m();
            }
        }, this.n, SystemClock.uptimeMillis() + (this.q > 0 ? this.q : 5000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(T t) {
        return (t == null || this.g == null || this.g != this.k.get(t)) ? false : true;
    }

    protected void e() {
        this.p = false;
        this.g = null;
        this.h.set(0);
        this.i.set(0);
        this.f.clear();
        this.c.removeCallbacksAndMessages(this.n);
    }

    protected void f() {
        if (i()) {
            this.f = com.qq.e.comm.plugin.r.a.b.a(this.e.f());
        } else {
            this.f = this.e.f();
        }
    }

    protected void g() {
        this.f = com.qq.e.comm.plugin.r.a.b.b(this.f);
        if (this.f.size() > 0) {
            this.g = this.f.get(0);
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        String d;
        if (this.d != null) {
            com.qq.e.comm.plugin.r.b.c cVar = this.g;
            Collection<com.qq.e.comm.plugin.r.b.c> values = this.k.values();
            if (cVar != null) {
                d = cVar.f();
                if (i()) {
                    a(70062, (Map<String, Object>) null);
                } else {
                    a(70042, (Map<String, Object>) null);
                }
            } else {
                d = this.e.d();
                if (i()) {
                    a(70072, (Map<String, Object>) null);
                } else {
                    a(70052, (Map<String, Object>) null);
                }
            }
            this.d.a(new ArrayList(values), d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        return this.e == null || this.e.c() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        if (this.g != null) {
            return this.g.a();
        }
        return null;
    }
}
