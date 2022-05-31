package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cl8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* loaded from: classes5.dex */
    public class a extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cl8 cl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl8Var};
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

    /* loaded from: classes5.dex */
    public class b implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl8 a;

        public b(cl8 cl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cl8Var;
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
                    k.A("2", this.a.a.mCurrentTabIndex.intValue(), 0, this.a.a.mAppBackgroundTime, new zj8(this.a.a), false);
                    k.m(false);
                    return;
                }
                l97.y(1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl8(MainTabActivity mainTabActivity, uj8 uj8Var) {
        super(2921666);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, uj8Var};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                MainTabActivity mainTabActivity = this.a;
                mainTabActivity.mOnResumeHotForSplashCount = 0;
                mainTabActivity.mAppBackgroundTime = System.currentTimeMillis();
                TbSingleton.getInstance().setExceptInsertAdDiaShow(false);
                l97.o = false;
                l97.p = false;
                return;
            }
            l97.m = false;
            if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                pc5.b(new a(this), new b(this));
            } else {
                l97 k = l97.k(this.a);
                int intValue = this.a.mCurrentTabIndex.intValue();
                MainTabActivity mainTabActivity2 = this.a;
                k.A("2", intValue, 0, mainTabActivity2.mAppBackgroundTime, new zj8(mainTabActivity2), false);
            }
            yc5.a(2);
        }
    }
}
