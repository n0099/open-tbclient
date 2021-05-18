package d.a.k0.f1.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imMessageCenter.mention.MsgReminderHttpRespMessage;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: d  reason: collision with root package name */
    public static j f54877d;

    /* renamed from: a  reason: collision with root package name */
    public final HttpMessageListener f54878a = new a(this, CmdConfigHttp.MSG_REMINDER_CMD);

    /* renamed from: b  reason: collision with root package name */
    public long f54879b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f54880c = new b();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(j jVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            i msgData;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage) && (msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData()) != null) {
                if (msgData.b() >= 0) {
                    d.a.j0.s.d.b.g0().Z(msgData.b());
                }
                if (msgData.e() >= 0) {
                    d.a.j0.s.d.b.g0().e0(msgData.e());
                }
                if (msgData.d() >= 0) {
                    d.a.j0.s.d.b.g0().c0(msgData.d());
                }
                if (msgData.a() >= 0) {
                    d.a.j0.s.d.b.g0().Y(msgData.a());
                }
                if (msgData.c() >= 0) {
                    d.a.j0.s.d.b.g0().a0(msgData.c());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i2 = message.arg1;
                j.this.f54879b = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().v();
                if (i2 == 2 || (z && d.a.c.e.p.j.z())) {
                    j.this.h();
                }
                j.this.g(1, 600000L);
            }
        }
    }

    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public j() {
        MessageManager.getInstance().registerListener(this.f54878a);
    }

    public static synchronized j e() {
        j jVar;
        synchronized (j.class) {
            if (f54877d == null) {
                f54877d = new j();
            }
            jVar = f54877d;
        }
        return jVar;
    }

    public void d() {
        this.f54880c.removeMessages(1);
    }

    public void f() {
        this.f54879b = 0L;
        d();
        i();
    }

    public final void g(int i2, long j) {
        Message obtainMessage = this.f54880c.obtainMessage(1);
        obtainMessage.arg1 = i2;
        this.f54880c.sendMessageDelayed(obtainMessage, j);
    }

    public final void h() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
    }

    public void i() {
        long j;
        int i2;
        long currentTimeMillis = System.currentTimeMillis() - this.f54879b;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 600000) {
            i2 = 2;
            j = 10000;
        } else {
            j = 600000 - currentTimeMillis;
            i2 = 1;
        }
        g(i2, j);
        this.f54879b = System.currentTimeMillis();
    }
}
