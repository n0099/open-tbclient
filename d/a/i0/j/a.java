package d.a.i0.j;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.facebook.common.util.UriUtil;
import d.a.i0.m0.o.b;
/* loaded from: classes3.dex */
public class a extends Thread {

    /* renamed from: d.a.i0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1040a implements MessageQueue.IdleHandler {
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            try {
                new a("BenchmarkThread").start();
                return false;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
    }

    public a(String str) {
        super(str);
    }

    public static void a() {
        Looper.myQueue().addIdleHandler(new C1040a());
    }

    public final void b() {
        double nanoTime = System.nanoTime();
        float f2 = 10.0f;
        for (int i2 = 0; i2 < 1000000; i2++) {
            f2 = f2 + 1.9509029f + 98.90882f + 1998.158f + 989.98895f + 1.1599002f + 16.2098f + 8899.087f + i2;
        }
        BdLog.e(UriUtil.LOCAL_RESOURCE_SCHEME + f2);
        TbSingleton.getInstance().setCpuFlopsDuration((int) ((((double) System.nanoTime()) - nanoTime) / 1000000.0d));
        b.a();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this) {
            b();
        }
    }
}
