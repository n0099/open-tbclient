package d.b.h0.n0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.R;
import d.b.b.e.m.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Runnable f50370a = new RunnableC1069a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50371b = false;

    /* renamed from: d.b.h0.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1069a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.d();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.e();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.d();
        }
    }

    public static void c() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.a().post(f50370a);
            MessageManager.getInstance().registerListener(new b(2000993));
            MessageManager.getInstance().registerListener(new c(2000988));
        }
    }

    public static final void d() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            f50371b = false;
            e.a().removeCallbacks(f50370a);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public static final void e() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.a().removeCallbacks(f50370a);
            e.a().postDelayed(f50370a, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (f50371b) {
                return;
            }
            f50371b = true;
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.plugin_tip_installing);
            NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
        }
    }
}
