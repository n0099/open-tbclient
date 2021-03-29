package d.b.b.c.e.c.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.b.c.e.c.h;
import d.b.b.c.e.c.i;
import d.b.b.e.p.j;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41539a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f41540b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f41541c = new a(Looper.getMainLooper());

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
            d.this.f41541c.removeMessages(1);
            BdLog.i("this is reconn time:" + d.this.f41540b);
            BdSocketLinkService.startService(true, "time to reconnStragety");
            d.c(d.this);
            if (j.z()) {
                if (d.this.f41540b >= d.b.b.e.n.k.a.o().q("alert_im", 3)) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.alert("alert_im", "Socket_Reconnect_" + String.valueOf(d.this.f41540b) + "_times");
                }
            }
            int[] c2 = h.c();
            if (c2 != null && d.this.f41540b < c2.length) {
                BdLog.i("Next will be delay:" + c2[d.this.f41540b]);
                d.this.f41541c.sendMessageDelayed(d.this.f41541c.obtainMessage(1), (long) (c2[d.this.f41540b] * 1000));
                return;
            }
            d.this.f("reconnStragety to the end");
        }
    }

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.f41540b;
        dVar.f41540b = i + 1;
        return i;
    }

    public final void d() {
    }

    public void e(String str) {
        if (!BdSocketLinkService.isAvailable()) {
            f("online failed 5");
        } else if (!this.f41539a) {
            this.f41539a = true;
            this.f41541c.removeMessages(1);
            if (d.b.b.e.r.h.j().l()) {
                BdLog.d("启动重连策略失败，  WebSocketClient opened");
                f("in Opened");
                return;
            }
            d();
            BdLog.d("启动重连策略");
            this.f41540b = 0;
            int[] c2 = h.c();
            if (c2 != null && c2.length >= 1) {
                BdLog.i("start reconnStrategy... the first will be delay" + c2[0]);
                int i = BdSocketLinkService.STOP_RECONN;
                i.a("reconn", 0, 0, "reconn", i, str + " retryTimes=" + String.valueOf(this.f41540b));
                Handler handler = this.f41541c;
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
        if (this.f41539a) {
            i.a("reconn", 0, 0, IntentConfig.STOP, BdSocketLinkService.STOP_RECONN, str);
            this.f41539a = false;
            this.f41540b = 0;
            BdLog.i("stop reconnStrategy");
            this.f41541c.removeMessages(1);
        }
    }
}
