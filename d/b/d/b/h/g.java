package d.b.d.b.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import d.b.d.b.l;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g implements Handler.Callback {
    public static Printer m;
    public static g n;
    public static final Printer o = new a();

    /* renamed from: g  reason: collision with root package name */
    public long f65209g;
    public boolean l;

    /* renamed from: f  reason: collision with root package name */
    public int f65208f = 0;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<List<Runnable>> f65210h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    public final List<Printer> f65211i = new LinkedList();
    public final List<Printer> j = new LinkedList();
    public boolean k = false;

    /* renamed from: e  reason: collision with root package name */
    public Handler f65207e = new Handler(i.a().getLooper(), this);

    /* loaded from: classes5.dex */
    public static class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                g.a().e(str);
            } else if (str.startsWith("<<<<< Finished")) {
                g.a().j(str);
            }
            if (g.m == null || g.m == g.o) {
                return;
            }
            g.m.println(str);
        }
    }

    public g() {
        h();
    }

    public static g a() {
        if (n == null) {
            synchronized (g.class) {
                if (n == null) {
                    n = new g();
                }
            }
        }
        return n;
    }

    public static void f(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            for (Runnable runnable : list) {
                runnable.run();
            }
        } catch (Exception e2) {
            l.k.b(e2);
        }
    }

    public void b(long j, Runnable runnable) {
        c(j, runnable, 1, 0L);
    }

    public void c(long j, Runnable runnable, int i2, long j2) {
        if (j < 0) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) j;
            List<Runnable> list = this.f65210h.get(i4);
            if (list == null) {
                synchronized (this.f65210h) {
                    list = this.f65210h.get(i4);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f65210h.put(i4, list);
                    }
                }
            }
            list.add(runnable);
            j += j2;
        }
    }

    public void d(Printer printer) {
        this.j.add(printer);
    }

    public void e(String str) {
        if (!this.l) {
            h.a(32L);
            this.l = true;
        }
        this.f65209g = SystemClock.uptimeMillis();
        try {
            g(this.f65211i, str);
            this.f65207e.sendEmptyMessage(0);
        } catch (Exception e2) {
            l.k.b(e2);
        }
    }

    public final synchronized void g(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    for (Printer printer : list) {
                        printer.println(str);
                    }
                } catch (Exception e2) {
                    l.k.b(e2);
                }
            }
        }
    }

    public void h() {
        if (this.k) {
            return;
        }
        this.k = true;
        Printer m2 = m();
        m = m2;
        if (m2 == o) {
            m = null;
        }
        Looper.getMainLooper().setMessageLogging(o);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f65207e.hasMessages(0)) {
            return true;
        }
        int i2 = message.what;
        if (i2 == 0) {
            this.f65208f = 0;
            if (this.f65210h.size() != 0 && this.f65210h.keyAt(0) == 0) {
                f(this.f65210h.valueAt(0));
                this.f65208f++;
            }
        } else if (i2 == 1) {
            this.f65207e.removeMessages(2);
            if (this.f65210h.size() != 0) {
                SparseArray<List<Runnable>> sparseArray = this.f65210h;
                if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    f(this.f65210h.get(Integer.MAX_VALUE));
                }
            }
            return true;
        } else if (i2 == 2) {
            f(this.f65210h.valueAt(this.f65208f));
            this.f65208f++;
        }
        if (this.f65208f >= this.f65210h.size()) {
            return true;
        }
        long keyAt = this.f65210h.keyAt(this.f65208f);
        if (keyAt != 2147483647L) {
            this.f65207e.sendEmptyMessageAtTime(2, this.f65209g + keyAt);
        }
        return true;
    }

    public synchronized void i(Printer printer) {
        this.f65211i.add(printer);
    }

    public void j(String str) {
        SystemClock.uptimeMillis();
        try {
            this.f65207e.removeMessages(2);
            g(this.j, str);
            this.f65207e.sendEmptyMessage(1);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    public final Printer m() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e2) {
            l.k.c(e2);
            return null;
        }
    }
}
