package d.a.m0.r.t;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import d.a.c.e.m.f;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f53992a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f53993b = new HandlerC1204a();

    /* renamed from: d.a.m0.r.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1204a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    if (a.f53992a) {
                        return;
                    }
                    a.f53993b.sendEmptyMessageDelayed(1, 10000L);
                    return;
                }
                a.f53993b.removeMessages(1);
                a.g();
            }
        }
    }

    public static void d() {
        MessageManager.getInstance().registerListener(new b(2001011));
    }

    public static void e(boolean z) {
        f53992a = z;
    }

    public static void f() {
        f.c(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void g() {
        f.d(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }
}
