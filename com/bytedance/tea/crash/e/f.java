package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements Handler.Callback {
    private static Printer pqi = null;
    private static f pqj = null;
    private static final Printer pqk = new Printer() { // from class: com.bytedance.tea.crash.e.f.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str != null) {
                if (str.startsWith(">>>>> Dispatching")) {
                    f.esA().a(str);
                } else if (str.startsWith("<<<<< Finished")) {
                    f.esA().b(str);
                }
                if (f.pqi != null && f.pqi != f.pqk) {
                    f.pqi.println(str);
                }
            }
        }
    };
    private long e;
    private long f;
    private boolean l;
    private int d = 0;
    private final SparseArray<List<Runnable>> g = new SparseArray<>();
    private final List<Printer> h = new LinkedList();
    private final List<Printer> i = new LinkedList();
    private boolean k = false;
    private Handler c = new Handler(h.a().getLooper(), this);

    private f() {
        b();
    }

    public static f esA() {
        if (pqj == null) {
            synchronized (f.class) {
                if (pqj == null) {
                    pqj = new f();
                }
            }
        }
        return pqj;
    }

    public void b() {
        if (!this.k) {
            this.k = true;
            pqi = esB();
            if (pqi == pqk) {
                pqi = null;
            }
            Looper.getMainLooper().setMessageLogging(pqk);
        }
    }

    private Printer esB() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            com.bytedance.tea.crash.g.j.b(e);
            return null;
        }
    }

    public void a(long j, Runnable runnable) {
        a(j, runnable, 1, 0L);
    }

    public void a(long j, Runnable runnable, int i, long j2) {
        if (j >= 0) {
            for (int i2 = 0; i2 < i; i2++) {
                List<Runnable> list = this.g.get((int) j);
                if (list == null) {
                    synchronized (this.g) {
                        list = this.g.get((int) j);
                        if (list == null) {
                            list = new LinkedList<>();
                            this.g.put((int) j, list);
                        }
                    }
                }
                list.add(runnable);
                j += j2;
            }
        }
    }

    public void a(Printer printer) {
        this.i.add(printer);
    }

    public synchronized void b(Printer printer) {
        this.h.add(printer);
    }

    void a(String str) {
        if (!this.l) {
            g.a(32L);
            this.l = true;
        }
        this.e = SystemClock.uptimeMillis();
        try {
            a(this.h, str);
            this.c.sendEmptyMessage(0);
        } catch (Exception e) {
            com.bytedance.tea.crash.g.j.a(e);
        }
    }

    void b(String str) {
        this.f = SystemClock.uptimeMillis();
        try {
            this.c.removeMessages(2);
            a(this.i, str);
            this.c.sendEmptyMessage(1);
        } catch (Exception e) {
            com.bytedance.tea.crash.g.j.b(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        if (!this.c.hasMessages(0)) {
            switch (message.what) {
                case 0:
                    this.d = 0;
                    if (this.g.size() != 0 && this.g.keyAt(0) == 0) {
                        a(this.g.valueAt(0));
                        this.d++;
                    }
                    if (this.d < this.g.size()) {
                        long keyAt = this.g.keyAt(this.d);
                        if (keyAt != 2147483647L) {
                            this.c.sendEmptyMessageAtTime(2, keyAt + this.e);
                            break;
                        }
                    }
                    break;
                case 1:
                    this.c.removeMessages(2);
                    if (this.g.size() != 0 && this.g.keyAt(this.g.size() - 1) == 0) {
                        a(this.g.get(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
                        break;
                    }
                    break;
                case 2:
                    a(this.g.valueAt(this.d));
                    this.d++;
                    if (this.d < this.g.size()) {
                    }
                    break;
                default:
                    if (this.d < this.g.size()) {
                    }
                    break;
            }
        }
        return true;
    }

    private static void a(List<? extends Runnable> list) {
        if (list != null && !list.isEmpty()) {
            try {
                for (Runnable runnable : list) {
                    runnable.run();
                }
            } catch (Exception e) {
                com.bytedance.tea.crash.g.j.a(e);
            }
        }
    }

    private synchronized void a(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    for (Printer printer : list) {
                        printer.println(str);
                    }
                } catch (Exception e) {
                    com.bytedance.tea.crash.g.j.a(e);
                }
            }
        }
    }
}
