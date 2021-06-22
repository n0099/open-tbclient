package d.a.o0.x1.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
import d.a.c.c.g.c;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f67132d;

    /* renamed from: a  reason: collision with root package name */
    public long f67133a = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f67134b = new HandlerC1801a();

    /* renamed from: c  reason: collision with root package name */
    public final c f67135c = new b(this, 303005);

    /* renamed from: d.a.o0.x1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1801a extends Handler {
        public HandlerC1801a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.f67133a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.f67134b.sendMessageDelayed(a.this.f67134b.obtainMessage(1), 1800000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c {
        public b(a aVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                d.a.n0.s.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        d.a.o0.e3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f67132d = null;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f67135c);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f67132d == null) {
                f67132d = new a();
            }
            aVar = f67132d;
        }
        return aVar;
    }

    public void c() {
        this.f67134b.removeMessages(1);
        this.f67134b.removeMessages(2);
    }

    public void e() {
        this.f67133a = 0L;
        c();
        f();
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis() - this.f67133a;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 1800000) {
            Handler handler = this.f67134b;
            handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
        } else {
            long j = 1800000 - currentTimeMillis;
            Handler handler2 = this.f67134b;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), j);
        }
        this.f67133a = System.currentTimeMillis();
    }
}
