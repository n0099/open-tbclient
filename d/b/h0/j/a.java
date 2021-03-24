package d.b.h0.j;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.facebook.common.util.UriUtil;
import d.b.h0.m0.o.b;
/* loaded from: classes3.dex */
public class a extends Thread {

    /* renamed from: d.b.h0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1065a implements MessageQueue.IdleHandler {
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
        Looper.myQueue().addIdleHandler(new C1065a());
    }

    public final void b() {
        double nanoTime = System.nanoTime();
        float f2 = 10.0f;
        for (int i = 0; i < 1000000; i++) {
            f2 = f2 + 1.9509029f + 98.90882f + 1998.158f + 989.98895f + 1.1599002f + 16.2098f + 8899.087f + i;
        }
        double nanoTime2 = System.nanoTime();
        Double.isNaN(nanoTime2);
        Double.isNaN(nanoTime);
        BdLog.e(UriUtil.LOCAL_RESOURCE_SCHEME + f2);
        TbSingleton.getInstance().setCpuFlopsDuration((int) ((nanoTime2 - nanoTime) / 1000000.0d));
        b.a();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this) {
            b();
        }
    }
}
