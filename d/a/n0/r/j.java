package d.a.n0.r;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes3.dex */
public class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public static int f53638e;

    public final void a(Activity activity) {
    }

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
        if (activity != null && !activity.getClass().getSimpleName().equals("LogoActivity")) {
            d.a.n0.a.e.y().A(activity);
        }
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f53638e++;
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (!PermissionUtil.isAgreePrivacyPolicy() || confignation == null || confignation.isAgreeDangerousProtocol()) {
            return;
        }
        confignation.setAgreeDangerousProtocol(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        TbadkCoreApplication.getInst().setStartType(1);
        int i2 = f53638e - 1;
        f53638e = i2;
        if (i2 == 0) {
            d.a.c.e.i.a.k().r();
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                return;
            }
            confignation.setAgreeDangerousProtocol(false);
        }
    }
}
