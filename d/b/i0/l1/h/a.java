package d.b.i0.l1.h;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f56718a;

    /* loaded from: classes2.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            BdLog.e("activity is " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            BdLog.e("activity is " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            BdLog.e("activity is " + activity);
            if (a.b(activity)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, activity));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            BdLog.e("activity is " + activity);
            if (a.b(activity) && TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, activity));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            BdLog.e("activity is " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            BdLog.e("activity is " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            BdLog.e("activity is " + activity);
        }
    }

    public static boolean b(Activity activity) {
        String className = activity.getComponentName().getClassName();
        if (className.contains("AlaMasterLiveRoomActivity") || className.contains("LivePlayerActivity") || className.contains("LiveShowActivity") || className.contains("AlaLiveEndActivity") || className.contains("LiveListActivity") || className.contains("BuyTBeanActivity") || className.contains("YuyinLivePlayerActivity") || className.contains("YuyinAlaCreateLiveRoomActivity")) {
            return true;
        }
        if (className.equals("com.baidu.megapp.proxy.activity.ActivityProxy")) {
            String stringExtra = activity.getIntent().getStringExtra("megapp_extra_target_activity");
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            return stringExtra.contains("AlaMasterLiveRoomActivity") || stringExtra.contains("LivePlayerActivity") || stringExtra.contains("AlaLiveEndActivity");
        }
        return false;
    }

    public static void c(Application application) {
        if (f56718a == null) {
            f56718a = new b();
        }
        application.registerActivityLifecycleCallbacks(f56718a);
    }
}
