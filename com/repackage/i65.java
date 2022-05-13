package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i65 implements y55<AgreeEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i65() {
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
    @Override // com.repackage.y55
    /* renamed from: a */
    public boolean onEvent(AgreeEvent agreeEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, agreeEvent)) == null) {
            if (agreeEvent != null && agreeEvent.agreeData != null) {
                pj8 pj8Var = new pj8();
                pj8Var.b = agreeEvent.agreeData;
                String str = agreeEvent.agreeExtra;
                if (TbadkCoreApplication.isLogin() && TbadkCoreApplication.getInst().isMainProcess(true) && agreeEvent.agreeData.hasAgree) {
                    if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                        lh8.r().A(0, 3);
                        lh8.r().G();
                    }
                    lh8.r().z(StampMission.Type.LIKE_THREAD);
                }
                if (AgreeEvent.IS_THREAD.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, pj8Var));
                    return true;
                } else if (AgreeEvent.IS_POST.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, pj8Var));
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
