package d.c.b;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class x1 implements Handler.Callback, Comparator<z> {
    public static x1 o;

    /* renamed from: e  reason: collision with root package name */
    public t1 f65102e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65103f;

    /* renamed from: g  reason: collision with root package name */
    public Application f65104g;

    /* renamed from: h  reason: collision with root package name */
    public i f65105h;
    public final ArrayList<z> i = new ArrayList<>(32);
    public a0 j;
    public j k;
    public Handler l;
    public e2 m;
    public Handler n;

    public static void b() {
        x1 x1Var = o;
        if (x1Var != null) {
            x1Var.g(null);
        }
    }

    public static void d(z zVar) {
        int size;
        Handler handler;
        x1 x1Var = o;
        if (x1Var == null) {
            r0.c("Init comes First!", null);
            g2.b(zVar);
            return;
        }
        if (zVar.f65111e == 0) {
            r0.b(null);
        }
        if (zVar instanceof i0) {
            ((i0) zVar).o = x1Var.f65105h.E();
        }
        synchronized (x1Var.i) {
            size = x1Var.i.size();
            x1Var.i.add(zVar);
        }
        if (size % 10 != 0 || (handler = x1Var.n) == null) {
            return;
        }
        handler.removeMessages(4);
        x1Var.n.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void e(String[] strArr) {
        x1 x1Var = o;
        if (x1Var == null) {
            r0.b(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = x1Var.n;
        if (handler != null) {
            handler.removeMessages(4);
            x1Var.n.obtainMessage(5, strArr).sendToTarget();
        }
    }

    public static x1 f() {
        if (o == null) {
            synchronized (x1.class) {
                if (o == null) {
                    o = new x1();
                }
            }
        }
        return o;
    }

    public static String h() {
        return i().f64978e;
    }

    public static e2 i() {
        x1 x1Var = o;
        if (x1Var != null) {
            return x1Var.m;
        }
        r0.b(null);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(z zVar, z zVar2) {
        long j = zVar.f65111e - zVar2.f65111e;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public void c(Application application, i iVar, j jVar, s1 s1Var) {
        this.f65104g = application;
        this.j = new a0(application, jVar, iVar);
        this.f65105h = iVar;
        this.k = jVar;
        this.m = new e2(jVar, iVar);
        this.f65104g.registerActivityLifecycleCallbacks(s1Var);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.n = handler;
        handler.sendEmptyMessage(1);
        q0.b(iVar.E() != 0);
    }

    public final void g(String[] strArr) {
        ArrayList<z> arrayList;
        synchronized (this.i) {
            arrayList = (ArrayList) this.i.clone();
            this.i.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(z.b(str));
            }
        }
        boolean v = this.f65105h.v(arrayList);
        if (arrayList.size() > 0) {
            if (this.f65105h.N()) {
                if (!v && arrayList.size() <= 100) {
                    synchronized (this.i) {
                        this.i.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<z> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<z> it = arrayList.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    z next = it.next();
                    if (this.m.f(next, arrayList2)) {
                        l();
                    }
                    if (next instanceof h0) {
                        z = e2.e(next);
                        i = 1;
                    }
                }
                if (i != 0) {
                    if (z) {
                        this.n.removeMessages(7);
                    } else {
                        this.n.sendEmptyMessageDelayed(7, this.f65105h.T());
                    }
                }
                this.j.j(arrayList2);
                if (this.f65103f || !this.m.h() || this.l == null || !a.e()) {
                    return;
                }
                j();
                return;
            }
            Intent intent = new Intent(this.f65104g, Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i2 = 0;
            while (i < size) {
                strArr2[i] = arrayList.get(i).l().toString();
                i2 += strArr2[i].length();
                i++;
            }
            if (i2 >= 307200) {
                r0.b(null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f65104g.sendBroadcast(intent);
            } catch (Exception e2) {
                r0.b(e2);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            r0.f65062a = this.f65105h.S();
            if (this.k.o()) {
                if (this.f65105h.N()) {
                    HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper(), this);
                    this.l = handler;
                    handler.sendEmptyMessage(2);
                    if (this.i.size() > 0) {
                        this.n.removeMessages(4);
                        this.n.sendEmptyMessageDelayed(4, 1000L);
                    }
                    r0.e("net|worker start", null);
                }
            } else {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageDelayed(1, 1000L);
            }
            g2.a();
        } else if (i == 2) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(new b2(this.f65104g, this.k, this.m));
            arrayList.add(new w1(this.f65104g, this.k, this.f65105h));
            arrayList.add(new a2(this.f65104g, this.k, this.j));
            arrayList.add(new d2(this.f65104g, this.j, this.f65105h, this.k));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                v1 v1Var = (v1) it.next();
                long h2 = v1Var.h();
                if (h2 < ImageLoader.f3672d) {
                    this.l.sendMessageDelayed(this.n.obtainMessage(6, v1Var), h2);
                }
            }
            k();
        } else if (i == 4) {
            g(null);
        } else if (i == 5) {
            g((String[]) message.obj);
        } else if (i == 6) {
            v1 v1Var2 = (v1) message.obj;
            if (!v1Var2.g()) {
                long h3 = v1Var2.h();
                if (h3 < ImageLoader.f3672d) {
                    this.l.sendMessageDelayed(this.n.obtainMessage(6, v1Var2), h3);
                }
                k();
            }
        } else if (i != 7) {
            r0.b(null);
        } else {
            synchronized (this.i) {
                this.i.add(e2.j());
            }
            g(null);
        }
        return true;
    }

    public boolean j() {
        this.f65103f = true;
        u1 u1Var = new u1(this.f65104g, this.k);
        Handler handler = this.l;
        if (handler != null) {
            handler.obtainMessage(6, u1Var).sendToTarget();
            return true;
        }
        return false;
    }

    public final void k() {
        if (this.f65105h.R()) {
            if (this.f65102e == null) {
                t1 t1Var = new t1(this.f65104g, this.k, this.f65105h);
                this.f65102e = t1Var;
                this.l.obtainMessage(6, t1Var).sendToTarget();
                return;
            }
            return;
        }
        t1 t1Var2 = this.f65102e;
        if (t1Var2 != null) {
            t1Var2.f();
            this.f65102e = null;
        }
    }

    public final void l() {
        if (r0.f65063b) {
            r0.a("packAndSend once, " + this.m.f64978e + ", hadUI:" + this.m.h(), null);
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.sendMessage(this.n.obtainMessage(6, new y1(this.f65104g, this.k, this.j)));
            this.l.sendMessage(this.n.obtainMessage(6, new z1(this.f65104g, this.j, this.f65105h, this.k)));
        }
    }
}
