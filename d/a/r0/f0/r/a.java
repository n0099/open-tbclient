package d.a.r0.f0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.a.d;
import d.a.r0.f0.b;
/* loaded from: classes9.dex */
public class a implements b<MissionEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.r0.f0.b
    /* renamed from: a */
    public boolean onEvent(MissionEvent missionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, missionEvent)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                int i2 = missionEvent.pageId;
                int i3 = missionEvent.pageType;
                long j = missionEvent.tid;
                String str = missionEvent.actionType;
                if (MissionEvent.MESSAGE_RESUME.equals(str)) {
                    d.y().K(i2, j);
                    d.y().P(i3, j);
                } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
                    d.y().E();
                } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
                    d.y().F();
                } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
                    d.y().K(i2, j);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
