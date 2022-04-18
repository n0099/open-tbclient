package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xp8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final jo8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xp8(MainTabActivity mainTabActivity) {
        super(2001371);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.mLogicController;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || MainTabActivity.syncHasFinish) {
            return;
        }
        jo8 jo8Var = this.b;
        if (jo8Var != null && jo8Var.g() != null) {
            no8 g = this.b.g();
            qb7 k = qb7.k(this.a);
            int intValue = this.a.mCurrentTabIndex.intValue();
            MainTabActivity mainTabActivity = this.a;
            g.b = k.y("1", intValue, 0, mainTabActivity.mAppBackgroundTime, new bo8(mainTabActivity), false);
        }
        if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.a.mIsSplashClick) {
            jo8 jo8Var2 = this.b;
            if (jo8Var2 != null && jo8Var2.b() != null) {
                this.b.b().b();
            }
            jo8 jo8Var3 = this.b;
            if (jo8Var3 != null && jo8Var3.g() != null) {
                this.b.g().a();
            }
        }
        ld5.a(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        jo8 jo8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            a();
            MainTabActivity.syncHasFinish = true;
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            if (!this.a.mIsSplashClick && (jo8Var = this.b) != null && jo8Var.c() != null) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.b.c().d();
                } else {
                    this.b.c().a();
                }
            }
            jo8 jo8Var2 = this.b;
            if (jo8Var2 == null || jo8Var2.i() == null) {
                return;
            }
            this.b.i().b();
        }
    }
}
