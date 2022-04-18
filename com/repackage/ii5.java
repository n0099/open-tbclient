package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.async.appcreate.InitSwanAppTask;
import com.baidu.searchbox.task.async.homeready.GetYYCloudTask;
import com.baidu.searchbox.task.async.homeready.InitCookieTask;
import com.baidu.searchbox.task.async.homeready.InitCyberPlayerTask;
import com.baidu.searchbox.task.async.homeready.InitFlutterFragmentTask;
import com.baidu.searchbox.task.async.homeready.InitMaintabFragmentTask;
import com.baidu.searchbox.task.async.homeready.InitUnionIDTask;
import com.baidu.searchbox.task.async.homeready.MainTabLoadFinishTask;
import com.baidu.searchbox.task.async.homeready.MaintabAsyncInitTask;
import com.baidu.searchbox.task.sync.appcreate.InitBearTask;
import com.baidu.searchbox.task.sync.appcreate.InitPrologueAdTask;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ii5 extends an4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ii5 b;

        /* renamed from: com.repackage.ii5$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0446a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LaunchTask a;

            public RunnableC0446a(a aVar, LaunchTask launchTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, launchTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = launchTask;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.run();
                }
            }
        }

        public a(ii5 ii5Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii5Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii5Var;
            this.a = activity;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this.a, ks4.a().b == 1, ks4.a().c);
                if (lt7.a().b()) {
                    for (LaunchTask launchTask : this.b.f()) {
                        nb.b().a(launchTask.getName(), new RunnableC0446a(this, launchTask));
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public ii5() {
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

    public List<LaunchTask> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new InitPrologueAdTask());
            arrayList.add(new InitBearTask());
            arrayList.add(new MainTabLoadFinishTask());
            arrayList.add(new GetYYCloudTask());
            arrayList.add(new InitCookieTask());
            arrayList.add(new InitMaintabFragmentTask());
            arrayList.add(new InitFlutterFragmentTask());
            arrayList.add(new InitUnionIDTask());
            arrayList.add(new MaintabAsyncInitTask());
            arrayList.add(new InitCyberPlayerTask());
            arrayList.add(new InitSwanAppTask());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void g(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null && ks4.a().a) {
            String name = activity.getClass().getName();
            if (!ls4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || "com.baidu.tieba.yunpush.YunPushProxyActivity".equals(name) || SpeedRuntimeProvider.SCHEMA_ACTIVITY_NAME.equals(name)) {
                return;
            }
            if (!SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) || SchemeActionHelper.isToMaintab(activity.getIntent())) {
                ks4.a().e(new a(this, activity));
            }
        }
    }

    @Override // com.repackage.an4, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            super.onActivityCreated(activity, bundle);
            g(activity);
        }
    }
}
