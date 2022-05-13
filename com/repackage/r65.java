package com.repackage;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.replay.ReplayEvent;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r65 implements y55<ReplayEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r65() {
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
    public boolean onEvent(ReplayEvent replayEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replayEvent)) == null) {
            if (replayEvent != null && TbadkCoreApplication.isLogin() && TbadkCoreApplication.getInst().isMainProcess(true)) {
                if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                    lh8.r().A(0, 3);
                    lh8.r().G();
                }
                lh8.r().z(StampMission.Type.REPLAY_THREAD);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
