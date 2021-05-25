package d.a.n0.x1.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
import d.a.c.c.g.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f63292d;

    /* renamed from: a  reason: collision with root package name */
    public long f63293a = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f63294b = new HandlerC1740a();

    /* renamed from: c  reason: collision with root package name */
    public final c f63295c = new b(this, 303005);

    /* renamed from: d.a.n0.x1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1740a extends Handler {
        public HandlerC1740a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.f63293a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.f63294b.sendMessageDelayed(a.this.f63294b.obtainMessage(1), 1800000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c {
        public b(a aVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                d.a.m0.s.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        d.a.n0.e3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f63292d = null;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f63295c);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f63292d == null) {
                f63292d = new a();
            }
            aVar = f63292d;
        }
        return aVar;
    }

    public void c() {
        this.f63294b.removeMessages(1);
        this.f63294b.removeMessages(2);
    }

    public void e() {
        this.f63293a = 0L;
        c();
        f();
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis() - this.f63293a;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 1800000) {
            Handler handler = this.f63294b;
            handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
        } else {
            long j = 1800000 - currentTimeMillis;
            Handler handler2 = this.f63294b;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), j);
        }
        this.f63293a = System.currentTimeMillis();
    }
}
