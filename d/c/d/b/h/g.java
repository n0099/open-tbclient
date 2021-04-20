package d.c.d.b.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import d.c.d.b.l;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class g implements Handler.Callback {
    public static Printer m;
    public static g n;
    public static final Printer o = new a();

    /* renamed from: g  reason: collision with root package name */
    public long f66709g;
    public boolean l;

    /* renamed from: f  reason: collision with root package name */
    public int f66708f = 0;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<List<Runnable>> f66710h = new SparseArray<>();
    public final List<Printer> i = new LinkedList();
    public final List<Printer> j = new LinkedList();
    public boolean k = false;

    /* renamed from: e  reason: collision with root package name */
    public Handler f66707e = new Handler(i.a().getLooper(), this);

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

    public void c(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> list = this.f66710h.get(i3);
            if (list == null) {
                synchronized (this.f66710h) {
                    list = this.f66710h.get(i3);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f66710h.put(i3, list);
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
        this.f66709g = SystemClock.uptimeMillis();
        try {
            g(this.i, str);
            this.f66707e.sendEmptyMessage(0);
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
        if (this.f66707e.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.f66708f = 0;
            if (this.f66710h.size() != 0 && this.f66710h.keyAt(0) == 0) {
                f(this.f66710h.valueAt(0));
                this.f66708f++;
            }
        } else if (i == 1) {
            this.f66707e.removeMessages(2);
            if (this.f66710h.size() != 0) {
                SparseArray<List<Runnable>> sparseArray = this.f66710h;
                if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    f(this.f66710h.get(Integer.MAX_VALUE));
                }
            }
            return true;
        } else if (i == 2) {
            f(this.f66710h.valueAt(this.f66708f));
            this.f66708f++;
        }
        if (this.f66708f >= this.f66710h.size()) {
            return true;
        }
        long keyAt = this.f66710h.keyAt(this.f66708f);
        if (keyAt != 2147483647L) {
            this.f66707e.sendEmptyMessageAtTime(2, this.f66709g + keyAt);
        }
        return true;
    }

    public synchronized void i(Printer printer) {
        this.i.add(printer);
    }

    public void j(String str) {
        SystemClock.uptimeMillis();
        try {
            this.f66707e.removeMessages(2);
            g(this.j, str);
            this.f66707e.sendEmptyMessage(1);
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
