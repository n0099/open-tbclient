package d.b.h0.z0;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class m {
    public static m i;

    /* renamed from: a  reason: collision with root package name */
    public int f52141a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f52142b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f52143c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f52144d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f52145e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52146f = false;

    /* renamed from: g  reason: collision with root package name */
    public Handler f52147g = new Handler(new a());

    /* renamed from: h  reason: collision with root package name */
    public Runnable f52148h = new b();

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 5) {
                return false;
            }
            if (Boolean.TRUE.equals(message.obj)) {
                m.this.o();
                m.this.k();
                return false;
            }
            m.this.l();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            if (mVar.f52145e == null) {
                mVar.f52145e = new AtomicBoolean(false);
            }
            if (m.this.f52145e.get()) {
                return;
            }
            m.this.f52145e.set(true);
            if (m.this.j(true)) {
                TbadkCoreApplication.getInst().fixOppoTimeout();
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                TiebaStaticHelper.setCurrentActivity(null);
                TiebaStatic.save();
            }
        }
    }

    public static m g() {
        if (i == null) {
            synchronized (m.class) {
                if (i == null) {
                    i = new m();
                }
            }
        }
        return i;
    }

    public void a() {
        this.f52144d++;
        n();
        d.b.h0.r.p.a.c().b();
    }

    public void b() {
        this.f52144d--;
        n();
    }

    public boolean d() {
        if (j(false)) {
            if (this.f52146f) {
                Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra("message", true);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
                return false;
            }
            return true;
        }
        Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent2.putExtra("message", false);
        TbadkCoreApplication.getInst().sendBroadcast(intent2);
        return false;
    }

    public void e() {
        this.f52141a = 0;
    }

    public int f() {
        return this.f52141a;
    }

    public int h() {
        return this.f52144d;
    }

    public boolean i() {
        AtomicBoolean atomicBoolean = this.f52145e;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public boolean j(boolean z) {
        return TbadkCoreApplication.getInst().isMainProcess(z);
    }

    public void k() {
        AsyncService.INSTANCE.sendRunnable(this.f52148h);
    }

    public void l() {
        AsyncService.INSTANCE.removeRunnable(this.f52148h);
        if (this.f52145e == null) {
            this.f52145e = new AtomicBoolean(true);
        }
        if (this.f52145e.get()) {
            this.f52145e.set(false);
            this.f52141a++;
            if (j(true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.f52142b;
                if (currentTimeMillis - j > VideoCloudSetting.HOUR_MILLISECOND || j == 0) {
                    this.f52142b = System.currentTimeMillis();
                    new EnterForePvThread().start();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public void m(boolean z) {
        this.f52146f = !z;
    }

    public void n() {
        if (this.f52144d < 0) {
            this.f52144d = 0;
        }
        if (j(true) && this.f52143c == 0 && this.f52144d > 0) {
            this.f52143c = System.nanoTime();
        }
        this.f52147g.removeMessages(5);
        if (this.f52144d == 0) {
            p();
            return;
        }
        AtomicBoolean atomicBoolean = this.f52145e;
        if (atomicBoolean == null || atomicBoolean.get()) {
            Handler handler = this.f52147g;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
        }
    }

    public final void o() {
        if (this.f52144d != 0 || this.f52143c <= 0) {
            return;
        }
        long nanoTime = ((System.nanoTime() - this.f52143c) / 1000000) / 1000;
        if (nanoTime >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
            new PvThread(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
        }
        this.f52143c = 0L;
    }

    public void p() {
        Handler handler = this.f52147g;
        handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
    }
}
