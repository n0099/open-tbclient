package d.a.i0.s.j;

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
public class e extends Handler implements d.a.c.c.e.c.b {
    public static e j;

    /* renamed from: e  reason: collision with root package name */
    public long f49844e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f49845f = TiebaStatic.MAX_COST_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f49846g = 900000;

    /* renamed from: h  reason: collision with root package name */
    public int f49847h = 900000;

    /* renamed from: i  reason: collision with root package name */
    public PingMessage f49848i = null;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
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
        public b(int i2) {
            super(i2);
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

    @Override // d.a.c.c.e.c.b
    public void a() {
        removeMessages(1);
    }

    @Override // d.a.c.c.e.c.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.f49844e >= 180000) && BdSocketLinkService.isOpen()) {
            this.f49844e = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.f49848i);
            PingMessage pingMessage = this.f49848i;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("-");
            sb.append(this.f49847h == this.f49846g ? j.j : "fore");
            d.a.c.c.e.c.i.c("PingManager", pingMessage, 0, "send_ping", 0, sb.toString());
            return true;
        }
        return false;
    }

    @Override // d.a.c.c.e.c.b
    public int c() {
        return 1003;
    }

    @Override // d.a.c.c.e.c.b
    public void d(String str) {
        if (BdSocketLinkService.isClose()) {
            d.a.i0.c0.a.b(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // d.a.c.c.e.c.b
    public void e() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.f49847h);
        this.f49844e = System.currentTimeMillis();
    }

    public final void h(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage == null) {
            return;
        }
        if (backgroundSwitchMessage.getData().booleanValue()) {
            this.f49847h = this.f49846g;
            return;
        }
        this.f49847h = this.f49845f;
        d("switchToForeground");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        e();
        b(true, "regular time send");
    }

    public int i() {
        return this.f49845f;
    }

    public void k() {
        d.a.i0.v0.b bVar = new d.a.i0.v0.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.h(false);
        bVar.setPriority(-3);
        bVar.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.e(false);
        MessageManager.getInstance().registerTask(bVar);
        this.f49848i = new PingMessage();
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
            int i2 = d.a.i0.r.h.f48979a;
            d.a.c.c.e.c.i.c("PingManager", orginalMessage, 0, "ping_succ", i2, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f49844e));
            return;
        }
        BdSocketLinkService.close(7, "ping error");
        int cmd = this.f49848i.getCmd();
        long clientLogID = this.f49848i.getClientLogID();
        d.a.c.c.e.c.i.b("PingManager", cmd, clientLogID, 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.f49844e));
    }

    public void m() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            int i2 = socketHeartBeatStratgy[0] * 1000;
            this.f49845f = i2;
            this.f49846g = socketHeartBeatStratgy[1] * 1000;
            if (i2 < 180000) {
                this.f49845f = TiebaStatic.MAX_COST_VALUE;
            }
            if (this.f49846g < 180000) {
                this.f49846g = TiebaStatic.MAX_COST_VALUE;
            }
        }
    }
}
