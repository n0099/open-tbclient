package d.b.c.c.e.c.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.c.c.e.c.h;
import d.b.c.c.e.c.i;
import d.b.c.e.p.j;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42276a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f42277b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f42278c = new a(Looper.getMainLooper());

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
            d.this.f42278c.removeMessages(1);
            BdLog.i("this is reconn time:" + d.this.f42277b);
            BdSocketLinkService.startService(true, "time to reconnStragety");
            d.c(d.this);
            if (j.z()) {
                if (d.this.f42277b >= d.b.c.e.n.k.a.o().q("alert_im", 3)) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.f42277b) + "_times");
                }
            }
            int[] c2 = h.c();
            if (c2 != null && d.this.f42277b < c2.length) {
                BdLog.i("Next will be delay:" + c2[d.this.f42277b]);
                d.this.f42278c.sendMessageDelayed(d.this.f42278c.obtainMessage(1), (long) (c2[d.this.f42277b] * 1000));
                return;
            }
            d.this.f("reconnStragety to the end");
        }
    }

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.f42277b;
        dVar.f42277b = i + 1;
        return i;
    }

    public final void d() {
    }

    public void e(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            f("online failed 5");
        } else if (!this.f42276a) {
            this.f42276a = true;
            this.f42278c.removeMessages(1);
            if (d.b.c.e.r.h.j().l()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                f("in Opened");
                return;
            }
            d();
            BdLog.d("启动重连策略");
            this.f42277b = 0;
            int[] c2 = h.c();
            if (c2 != null && c2.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + c2[0]);
                int i = BdSocketLinkService.STOP_RECONN;
                i.a("reconn", 0, 0, "reconn", i, str + " retryTimes=" + String.valueOf(this.f42277b));
                Handler handler = this.f42278c;
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
        if (this.f42276a) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.f42276a = false;
            this.f42277b = 0;
            BdLog.i("stop reconnStrategy");
            this.f42278c.removeMessages(1);
        }
    }
}
