package com.repackage;

import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j65 implements j55<ThirdPartyActivityLifecycleEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j65() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.j55
    /* renamed from: a */
    public boolean onEvent(ThirdPartyActivityLifecycleEvent thirdPartyActivityLifecycleEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thirdPartyActivityLifecycleEvent)) == null) {
            if (thirdPartyActivityLifecycleEvent == null || thirdPartyActivityLifecycleEvent.event == null || !TbadkCoreApplication.getInst().isMainProcess(false) || !UbsABTestHelper.isFixHotSplashRule()) {
                return true;
            }
            if (thirdPartyActivityLifecycleEvent.event.equals(Lifecycle.Event.ON_PAUSE)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, TbadkCoreApplication.getInst()));
            } else if (thirdPartyActivityLifecycleEvent.event.equals(Lifecycle.Event.ON_RESUME) && TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, TbadkCoreApplication.getInst()));
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
