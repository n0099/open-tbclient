package d.a.k0.w1.j;

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
    public static a f63107d;

    /* renamed from: a  reason: collision with root package name */
    public long f63108a = 0;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f63109b = new HandlerC1723a();

    /* renamed from: c  reason: collision with root package name */
    public final c f63110c = new b(this, 303005);

    /* renamed from: d.a.k0.w1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1723a extends Handler {
        public HandlerC1723a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.f63108a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                a.this.f63109b.sendMessageDelayed(a.this.f63109b.obtainMessage(1), 1800000L);
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
                d.a.j0.s.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        d.a.k0.d3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f63107d = null;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.f63110c);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f63107d == null) {
                f63107d = new a();
            }
            aVar = f63107d;
        }
        return aVar;
    }

    public void c() {
        this.f63109b.removeMessages(1);
        this.f63109b.removeMessages(2);
    }

    public void e() {
        this.f63108a = 0L;
        c();
        f();
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis() - this.f63108a;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 1800000) {
            Handler handler = this.f63109b;
            handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
        } else {
            long j = 1800000 - currentTimeMillis;
            Handler handler2 = this.f63109b;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), j);
        }
        this.f63108a = System.currentTimeMillis();
    }
}
