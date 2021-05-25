package d.a.m0.r;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes3.dex */
public class j implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (PermissionUtil.isAgreePrivacyPolicy() || activity == null || activity.getClass().getSimpleName().equals("LogoActivity") || !activity.getClass().getPackage().getName().startsWith("com.baidu.tieba") || !TbadkCoreApplication.getInst().isMainProcess(false) || TbSingleton.getInstance().isBrowseMode()) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(activity, activity.getIntent())));
        activity.finish();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == null || activity.getClass().getSimpleName().equals("LogoActivity")) {
            return;
        }
        d.a.m0.a.d.y().A(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        TbadkCoreApplication.getInst().setStartType(1);
    }
}
