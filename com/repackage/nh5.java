package com.repackage;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
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
import java.io.PrintStream;
/* loaded from: classes6.dex */
public class nh5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nh5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public dm4 c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nh5 nh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh5Var, Integer.valueOf(i)};
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || ja8.l().i() == null) {
                return;
            }
            ja8.l().i().b();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nh5 nh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh5Var, Integer.valueOf(i)};
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
            this.a = nh5Var;
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

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(nh5 nh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh5Var, Integer.valueOf(i)};
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
            this.a = nh5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.a.a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.E) || (data instanceof LogoActivity) || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            boolean f = this.a.f();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - this.a.a > 5) {
                new StatisticItem(TbadkCoreStatisticKey.HOT_SPLASH_APP_START).param("obj_param1", f ? 1 : 0).param(TiebaStatic.Params.OBJ_PARAM2, currentTimeMillis - this.a.a).param(TiebaStatic.Params.OBJ_PARAM3, us4.b ? 1 : 0).eventStat();
                if (us4.b) {
                    us4.b = false;
                }
            }
            if (f) {
                TbSingleton.getInstance().isCanShowHotSplash = true;
                if (data instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                    intent.setFlags(65536);
                    baseActivity.startActivity(intent);
                } else if (data instanceof BaseFragmentActivity) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
                TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                return;
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(1);
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(nh5 nh5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh5Var, Integer.valueOf(i)};
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
            this.a = nh5Var;
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
                        nh5 nh5Var = this.a;
                        nh5Var.b = currentTimeMillis - nh5Var.a <= 1;
                    }
                }
            }
        }
    }

    public nh5() {
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
        if (ja8.l().i() != null) {
            ja8.l().i().c();
        }
    }

    public static nh5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (h == null) {
                synchronized (nh5.class) {
                    if (h == null) {
                        h = new nh5();
                    }
                }
            }
            return h;
        }
        return (nh5) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis() / 1000;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int h2 = h();
            int i = i();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.b) {
                this.b = false;
                return false;
            }
            long j = this.a;
            if (currentTimeMillis - j > 2 && currentTimeMillis - j > h2) {
                ea8 i2 = ja8.l().i();
                int a2 = i2 != null ? i2.a() : i;
                PrintStream printStream = System.out;
                printStream.println("TestTest => hotSplashMaxTime: " + i + " currentTime: " + a2 + " interval: " + h2);
                return a2 < i;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (lc5.a()) {
                return 3;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, dm4.class)) != null) {
                this.c = (dm4) runTask.getData();
            }
            dm4 dm4Var = this.c;
            if (dm4Var != null) {
                return (int) (dm4Var.a() * 60.0f);
            }
            uw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
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

    public final int i() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (lc5.a()) {
                return 1000000;
            }
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921564, dm4.class)) != null) {
                this.c = (dm4) runTask.getData();
            }
            dm4 dm4Var = this.c;
            if (dm4Var != null) {
                return dm4Var.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}
