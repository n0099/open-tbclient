package d.b.h0.s.j;

import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.widget.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
/* loaded from: classes3.dex */
public class e extends Handler implements d.b.b.c.e.c.b {
    public static e j;

    /* renamed from: e  reason: collision with root package name */
    public long f51426e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51427f = TiebaStatic.MAX_COST_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f51428g = 900000;

    /* renamed from: h  reason: collision with root package name */
    public int f51429h = 900000;
    public PingMessage i = null;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.c {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null) {
                return;
            }
            e.this.l(socketResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            e.this.h((BackgroundSwitchMessage) customResponsedMessage);
        }
    }

    public static e j() {
        if (j == null) {
            synchronized (e.class) {
                if (j == null) {
                    j = new e();
                }
            }
        }
        return j;
    }

    @Override // d.b.b.c.e.c.b
    public void a(String str) {
        if (BdSocketLinkService.isClose()) {
            d.b.h0.c0.a.b(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            c(false, str);
        }
    }

    @Override // d.b.b.c.e.c.b
    public void b() {
        removeMessages(1);
    }

    @Override // d.b.b.c.e.c.b
    public boolean c(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.f51426e >= 180000) && BdSocketLinkService.isOpen()) {
            this.f51426e = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.i);
            PingMessage pingMessage = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("-");
            sb.append(this.f51429h == this.f51428g ? j.j : "fore");
            d.b.b.c.e.c.i.c("PingManager", pingMessage, 0, "send_ping", 0, sb.toString());
            return true;
        }
        return false;
    }

    @Override // d.b.b.c.e.c.b
    public int d() {
        return 1003;
    }

    @Override // d.b.b.c.e.c.b
    public void e() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.f51429h);
        this.f51426e = System.currentTimeMillis();
    }

    public final void h(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage == null) {
            return;
        }
        if (backgroundSwitchMessage.getData().booleanValue()) {
            this.f51429h = this.f51428g;
            return;
        }
        this.f51429h = this.f51427f;
        a("switchToForeground");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        e();
        c(true, "regular time send");
    }

    public int i() {
        return this.f51427f;
    }

    public void k() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.h(false);
        bVar.setPriority(-3);
        bVar.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.e(false);
        MessageManager.getInstance().registerTask(bVar);
        this.i = new PingMessage();
        m();
        a aVar = new a(1003);
        MessageManager.getInstance().registerListener(new b(2001011));
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void l(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        int error = responsedMessage.getError();
        if (error == 0) {
            com.baidu.adp.framework.message.Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            int i = d.b.h0.r.h.f50619a;
            d.b.b.c.e.c.i.c("PingManager", orginalMessage, 0, "ping_succ", i, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f51426e));
            return;
        }
        BdSocketLinkService.close(7, "ping error");
        int cmd = this.i.getCmd();
        long clientLogID = this.i.getClientLogID();
        d.b.b.c.e.c.i.b("PingManager", cmd, clientLogID, 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f51426e));
    }

    public void m() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            int i = socketHeartBeatStratgy[0] * 1000;
            this.f51427f = i;
            this.f51428g = socketHeartBeatStratgy[1] * 1000;
            if (i < 180000) {
                this.f51427f = TiebaStatic.MAX_COST_VALUE;
            }
            if (this.f51428g < 180000) {
                this.f51428g = TiebaStatic.MAX_COST_VALUE;
            }
        }
    }
}
