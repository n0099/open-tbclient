package d.a.j0.z0;

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

    /* renamed from: i  reason: collision with root package name */
    public static m f50976i;

    /* renamed from: a  reason: collision with root package name */
    public int f50977a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f50978b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f50979c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f50980d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f50981e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50982f = false;

    /* renamed from: g  reason: collision with root package name */
    public Handler f50983g = new Handler(new a());

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50984h = new b();

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
            if (mVar.f50981e == null) {
                mVar.f50981e = new AtomicBoolean(false);
            }
            if (m.this.f50981e.get()) {
                return;
            }
            m.this.f50981e.set(true);
            if (m.this.j(true)) {
                TbadkCoreApplication.getInst().fixOppoTimeout();
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                TiebaStaticHelper.setCurrentActivity(null);
                TiebaStatic.save();
            }
        }
    }

    public static m g() {
        if (f50976i == null) {
            synchronized (m.class) {
                if (f50976i == null) {
                    f50976i = new m();
                }
            }
        }
        return f50976i;
    }

    public void a() {
        this.f50980d++;
        n();
        d.a.j0.r.p.a.c().b();
    }

    public void b() {
        this.f50980d--;
        n();
    }

    public boolean d() {
        if (j(false)) {
            if (this.f50982f) {
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
        this.f50977a = 0;
    }

    public int f() {
        return this.f50977a;
    }

    public int h() {
        return this.f50980d;
    }

    public boolean i() {
        AtomicBoolean atomicBoolean = this.f50981e;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public boolean j(boolean z) {
        return TbadkCoreApplication.getInst().isMainProcess(z);
    }

    public void k() {
        AsyncService.INSTANCE.sendRunnable(this.f50984h);
    }

    public void l() {
        AsyncService.INSTANCE.removeRunnable(this.f50984h);
        if (this.f50981e == null) {
            this.f50981e = new AtomicBoolean(true);
        }
        if (this.f50981e.get()) {
            this.f50981e.set(false);
            this.f50977a++;
            if (j(true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.f50978b;
                if (currentTimeMillis - j > VideoCloudSetting.HOUR_MILLISECOND || j == 0) {
                    this.f50978b = System.currentTimeMillis();
                    new EnterForePvThread().start();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public void m(boolean z) {
        this.f50982f = !z;
    }

    public void n() {
        if (this.f50980d < 0) {
            this.f50980d = 0;
        }
        if (j(true) && this.f50979c == 0 && this.f50980d > 0) {
            this.f50979c = System.nanoTime();
        }
        this.f50983g.removeMessages(5);
        if (this.f50980d == 0) {
            p();
            return;
        }
        AtomicBoolean atomicBoolean = this.f50981e;
        if (atomicBoolean == null || atomicBoolean.get()) {
            Handler handler = this.f50983g;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
        }
    }

    public final void o() {
        if (this.f50980d != 0 || this.f50979c <= 0) {
            return;
        }
        long nanoTime = ((System.nanoTime() - this.f50979c) / 1000000) / 1000;
        if (nanoTime >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
            new PvThread(TbConfig.ST_TYPE_USE, String.valueOf(nanoTime)).start();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_USE, null, 1, "st_param", String.valueOf(nanoTime));
        }
        this.f50979c = 0L;
    }

    public void p() {
        Handler handler = this.f50983g;
        handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
    }
}
