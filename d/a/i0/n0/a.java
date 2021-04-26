package d.a.i0.n0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Runnable f48717a = new RunnableC1043a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f48718b = false;

    /* renamed from: d.a.i0.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1043a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.d();
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
            a.e();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.d();
        }
    }

    public static void c() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.a().post(f48717a);
            MessageManager.getInstance().registerListener(new b(2000993));
            MessageManager.getInstance().registerListener(new c(2000988));
        }
    }

    public static final void d() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            f48718b = false;
            e.a().removeCallbacks(f48717a);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public static final void e() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.a().removeCallbacks(f48717a);
            e.a().postDelayed(f48717a, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (f48718b) {
                return;
            }
            f48718b = true;
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.plugin_tip_installing);
            NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
        }
    }
}
