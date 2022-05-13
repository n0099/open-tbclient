package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uo8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final gn8 b;

    /* loaded from: classes7.dex */
    public class a extends sd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(uo8 uo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.sd5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(xb7.u()) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo8 a;

        public b(uo8 uo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && !bool.booleanValue()) {
                    xb7 k = xb7.k(this.a.a);
                    k.m(true);
                    this.a.b.g().b = k.A("1", this.a.a.mCurrentTabIndex.intValue(), 0, this.a.a.mAppBackgroundTime, new ym8(this.a.a), false);
                    k.m(false);
                    return;
                }
                xb7.y(1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo8(MainTabActivity mainTabActivity) {
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || MainTabActivity.syncHasFinish) {
            return;
        }
        gn8 gn8Var = this.b;
        if (gn8Var != null && gn8Var.g() != null) {
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                vd5.b(new a(this), new b(this));
            } else {
                kn8 g = this.b.g();
                xb7 k = xb7.k(this.a);
                int intValue = this.a.mCurrentTabIndex.intValue();
                MainTabActivity mainTabActivity = this.a;
                g.b = k.A("1", intValue, 0, mainTabActivity.mAppBackgroundTime, new ym8(mainTabActivity), false);
            }
        }
        if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.a.mIsSplashClick) {
            gn8 gn8Var2 = this.b;
            if (gn8Var2 != null && gn8Var2.b() != null) {
                this.b.b().b();
            }
            gn8 gn8Var3 = this.b;
            if (gn8Var3 != null && gn8Var3.g() != null) {
                this.b.g().a();
            }
        }
        ee5.a(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            c();
            MainTabActivity.syncHasFinish = true;
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            if (!this.a.mIsSplashClick && (gn8Var = this.b) != null && gn8Var.c() != null) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.b.c().d();
                } else {
                    this.b.c().a();
                }
            }
            gn8 gn8Var2 = this.b;
            if (gn8Var2 == null || gn8Var2.i() == null) {
                return;
            }
            this.b.i().b();
        }
    }
}
