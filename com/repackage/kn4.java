package com.repackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginAdpBaseFragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kn4 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!ys4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || SpeedStats.PUSH_ACTIVITY.equals(name) || "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                ys4.a().k(true);
                return;
            } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                return;
            }
        }
        ys4.a().h(name);
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!ys4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || SpeedStats.PUSH_ACTIVITY.equals(name) || "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                ys4.a().l(true);
                return;
            } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                return;
            }
        }
        ys4.a().g(name);
    }

    public final void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && activity != null && PermissionUtil.isAgreePrivacyPolicy()) {
            if (activity.getClass().getName().equals(mi.v())) {
                CurrentPageTypeHelper.PageType pageType = CurrentPageTypeHelper.PageType.OTHER;
                if (TbWebViewActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.WEB;
                } else if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
                    pageType = CurrentPageTypeHelper.PageType.SMART_APP;
                } else if (activity.getClass().getName().contains("FlutterPageActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.FLUTTER;
                } else if (activity.getClass().getName().contains("NewSquareSearchActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE_WEB;
                } else if (BaseActivity.class.isAssignableFrom(activity.getClass()) || BaseFragmentActivity.class.isAssignableFrom(activity.getClass()) || PluginAdpBaseActivity.class.isAssignableFrom(activity.getClass()) || PluginAdpBaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE;
                }
                e65.i(new CurrentPageTypeEvent(pageType));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, activity, bundle) == null) || activity == null) {
            return;
        }
        fu4.q().w(activity);
        if (fu4.q().v(activity)) {
            return;
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && ((!"com.baidu.tieba.pb.pb.main.PbActivity".equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name)) || !xs4.a().a)) {
            nb.b().d();
        }
        if (!PermissionUtil.isAgreePrivacyPolicy() && activity != null && !activity.getClass().getSimpleName().equals("LogoActivity") && activity.getClass().getPackage().getName().startsWith("com.baidu.tieba") && TbadkCoreApplication.getInst().isMainProcess(false) && !TbSingleton.getInstance().isBrowseMode()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(activity, activity.getIntent())));
            activity.finish();
        }
        if (w55.b().e(name)) {
            w55.b().a();
        } else if (w55.b().h(activity)) {
            w55.b().c();
            if (w55.b().g(name)) {
                w55.b().l(true);
            }
        } else if (w55.b().f(name)) {
            w55.b().o();
            if (!w55.b().g(name)) {
                w55.b().l(false);
            } else {
                w55.b().l(true);
            }
        }
        xs4.a().e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity == null || currentActivity == null || !w55.b().h(activity) || w55.b().h(currentActivity)) {
                return;
            }
            w55.b().o();
            if (w55.b().g(currentActivity.getClass().getName())) {
                return;
            }
            w55.b().l(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    aj4.C().F(UtilHelper.isActivityStartFromScheme(activity));
                }
                String name = activity.getClass().getName();
                if (w55.b().e(name)) {
                    w55.b().a();
                } else if (w55.b().h(activity)) {
                    w55.b().c();
                    if (w55.b().g(name)) {
                        w55.b().l(true);
                    }
                }
            }
            c(activity);
            b(activity);
            a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            fu4.q().x(activity);
        }
    }
}
