package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z55 implements i55<MissionEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z55() {
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
    @Override // com.repackage.i55
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, missionEvent)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                int i = missionEvent.pageId;
                int i2 = missionEvent.pageType;
                long j = missionEvent.tid;
                String str = missionEvent.actionType;
                if ("onResume".equals(str)) {
                    oi4.y().M(i, j);
                    oi4.y().R(i2, j);
                } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                    oi4.y().G();
                } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                    oi4.y().H();
                } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                    oi4.y().M(i, j);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
