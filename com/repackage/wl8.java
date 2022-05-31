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
public class wl8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final hk8 b;

    /* loaded from: classes7.dex */
    public class a extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(wl8 wl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl8Var};
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
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(l97.u()) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl8 a;

        public b(wl8 wl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && !bool.booleanValue()) {
                    l97 k = l97.k(this.a.a);
                    k.m(true);
                    this.a.b.g().b = k.A("1", this.a.a.mCurrentTabIndex.intValue(), 0, this.a.a.mAppBackgroundTime, new zj8(this.a.a), false);
                    k.m(false);
                    return;
                }
                l97.y(1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl8(MainTabActivity mainTabActivity) {
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
        hk8 hk8Var = this.b;
        if (hk8Var != null && hk8Var.g() != null) {
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                pc5.b(new a(this), new b(this));
            } else {
                lk8 g = this.b.g();
                l97 k = l97.k(this.a);
                int intValue = this.a.mCurrentTabIndex.intValue();
                MainTabActivity mainTabActivity = this.a;
                g.b = k.A("1", intValue, 0, mainTabActivity.mAppBackgroundTime, new zj8(mainTabActivity), false);
            }
        }
        if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.a.mIsSplashClick) {
            hk8 hk8Var2 = this.b;
            if (hk8Var2 != null && hk8Var2.b() != null) {
                this.b.b().b();
            }
            hk8 hk8Var3 = this.b;
            if (hk8Var3 != null && hk8Var3.g() != null) {
                this.b.g().a();
            }
        }
        yc5.a(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        hk8 hk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            c();
            MainTabActivity.syncHasFinish = true;
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            if (!this.a.mIsSplashClick && (hk8Var = this.b) != null && hk8Var.c() != null) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.b.c().d();
                } else {
                    this.b.c().a();
                }
            }
            hk8 hk8Var2 = this.b;
            if (hk8Var2 == null || hk8Var2.i() == null) {
                return;
            }
            this.b.i().b();
        }
    }
}
