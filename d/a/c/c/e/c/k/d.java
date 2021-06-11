package d.a.c.c.e.c.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.c.c.e.c.h;
import d.a.c.c.e.c.i;
import d.a.c.e.p.j;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42027a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f42028b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f42029c = new a(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            d.this.f42029c.removeMessages(1);
            BdLog.i("this is reconn time:" + d.this.f42028b);
            BdSocketLinkService.startService(true, "time to reconnStragety");
            d.c(d.this);
            if (j.z()) {
                if (d.this.f42028b >= d.a.c.e.n.k.a.o().q("alert_im", 3)) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.f42028b) + "_times");
                }
            }
            int[] c2 = h.c();
            if (c2 != null && d.this.f42028b < c2.length) {
                BdLog.i("Next will be delay:" + c2[d.this.f42028b]);
                d.this.f42029c.sendMessageDelayed(d.this.f42029c.obtainMessage(1), (long) (c2[d.this.f42028b] * 1000));
                return;
            }
            d.this.f("reconnStragety to the end");
        }
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f42028b;
        dVar.f42028b = i2 + 1;
        return i2;
    }

    public final void d() {
    }

    public void e(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            f("online failed 5");
        } else if (!this.f42027a) {
            this.f42027a = true;
            this.f42029c.removeMessages(1);
            if (d.a.c.e.r.h.j().l()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                f("in Opened");
                return;
            }
            d();
            BdLog.d("启动重连策略");
            this.f42028b = 0;
            int[] c2 = h.c();
            if (c2 != null && c2.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + c2[0]);
                int i2 = BdSocketLinkService.STOP_RECONN;
                i.a("reconn", 0, 0, "reconn", i2, str + " retryTimes=" + String.valueOf(this.f42028b));
                Handler handler = this.f42029c;
                handler.sendMessageDelayed(handler.obtainMessage(1), (long) (c2[0] * 1000));
                return;
            }
            BdLog.i("don't have reconnStrategy!");
        } else {
            BdLog.d("重连策略正在运行中， 再次启动无效");
            i.a("reconn", 0, 0, IntentConfig.START, BdSocketLinkService.ALLREADY, "have in Running,so invalid");
        }
    }

    public void f(String str) {
        if (this.f42027a) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.f42027a = false;
            this.f42028b = 0;
            BdLog.i("stop reconnStrategy");
            this.f42029c.removeMessages(1);
        }
    }
}
