package com.repackage;

import android.app.Application;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.LogoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eh5;
import java.io.PrintStream;
/* loaded from: classes5.dex */
public class dh5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dh5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public al4 c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dh5 dh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || x88.l().i() == null) {
                return;
            }
            x88.l().i().b();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dh5 dh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof LogoActivity)) {
                    this.a.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dh5 dh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.a.a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.E) || (data instanceof LogoActivity)) {
                return;
            }
            this.a.f(data);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(dh5 dh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        dh5 dh5Var = this.a;
                        dh5Var.b = currentTimeMillis - dh5Var.a <= 1;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements eh5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh5 a;

        public e(dh5 dh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh5Var;
        }

        @Override // com.repackage.eh5.c
        public void a(Application application) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, application) == null) && UbsABTestHelper.isFixHotSplashRule()) {
                this.a.e();
            }
        }

        @Override // com.repackage.eh5.c
        public void b(Application application) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) && UbsABTestHelper.isFixHotSplashRule()) {
                this.a.f(application);
            }
        }
    }

    public dh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, 2016522);
        this.e = new b(this, 2016521);
        this.f = new c(this, 2016520);
        this.g = new d(this, 2016523);
        this.b = false;
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.g);
        if (x88.l().i() != null) {
            x88.l().i().c();
        }
        eh5.b().c(new e(this));
    }

    public static dh5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (h == null) {
                synchronized (dh5.class) {
                    if (h == null) {
                        h = new dh5();
                    }
                }
            }
            return h;
        }
        return (dh5) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis() / 1000;
        }
    }

    public final void f(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            return;
        }
        boolean g = g();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - this.a > 5) {
            new StatisticItem(TbadkCoreStatisticKey.HOT_SPLASH_APP_START).param("obj_param1", g ? 1 : 0).param(TiebaStatic.Params.OBJ_PARAM2, currentTimeMillis - this.a).param(TiebaStatic.Params.OBJ_PARAM3, tr4.b ? 1 : 0).eventStat();
            if (tr4.b) {
                tr4.b = false;
            }
        }
        if (g) {
            TbSingleton.getInstance().isCanShowHotSplash = true;
            if (obj instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) obj;
                Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                intent.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent.setFlags(65536);
                baseActivity.startActivity(intent);
            } else if (obj instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) obj;
                Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                intent2.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent2.setFlags(65536);
                baseFragmentActivity.getActivity().startActivity(intent2);
            } else if (obj instanceof Application) {
                Application application = (Application) obj;
                Intent intent3 = new Intent(application, LogoActivity.class);
                intent3.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                intent3.setFlags(268500992);
                application.startActivity(intent3);
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(2);
            return;
        }
        TbadkCoreApplication.getInst().setCanShowHotSplash(1);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = i();
            int j = j();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.b) {
                this.b = false;
                return false;
            }
            long j2 = this.a;
            if (currentTimeMillis - j2 > 2 && currentTimeMillis - j2 > i) {
                s88 i2 = x88.l().i();
                int a2 = i2 != null ? i2.a() : j;
                PrintStream printStream = System.out;
                printStream.println("TestTest => hotSplashMaxTime: " + j + " currentTime: " + a2 + " interval: " + i);
                return a2 < j;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int i() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (sb5.a()) {
                return 3;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, al4.class)) != null) {
                this.c = (al4) runTask.getData();
            }
            al4 al4Var = this.c;
            if (al4Var != null) {
                return (int) (al4Var.a() * 60.0f);
            }
            uv4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                int b2 = adAdSense.b();
                if (b2 <= 0) {
                    return 86400;
                }
                return b2;
            }
            return 300;
        }
        return invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (sb5.a()) {
                return 1000000;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, al4.class)) != null) {
                this.c = (al4) runTask.getData();
            }
            al4 al4Var = this.c;
            if (al4Var != null) {
                return al4Var.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}
