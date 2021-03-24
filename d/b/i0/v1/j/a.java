package d.b.i0.v1.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
import d.b.b.c.g.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f62040d;

    /* renamed from: a  reason: collision with root package name */
    public long f62041a = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f62042b = new HandlerC1640a();

    /* renamed from: c  reason: collision with root package name */
    public final c f62043c = new b(this, 303005);

    /* renamed from: d.b.i0.v1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1640a extends Handler {
        public HandlerC1640a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.f62041a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.f62042b.sendMessageDelayed(a.this.f62042b.obtainMessage(1), 1800000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c {
        public b(a aVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                d.b.h0.s.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        d.b.i0.c3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f62040d = null;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f62043c);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f62040d == null) {
                f62040d = new a();
            }
            aVar = f62040d;
        }
        return aVar;
    }

    public void c() {
        this.f62042b.removeMessages(1);
        this.f62042b.removeMessages(2);
    }

    public void e() {
        this.f62041a = 0L;
        c();
        f();
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis() - this.f62041a;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 1800000) {
            Handler handler = this.f62042b;
            handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
        } else {
            long j = 1800000 - currentTimeMillis;
            Handler handler2 = this.f62042b;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), j);
        }
        this.f62041a = System.currentTimeMillis();
    }
}
