package d.a.r0.m0.o;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c13395");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
            statisticItem.param("obj_type", Build.MODEL);
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, Build.VERSION.RELEASE);
            statisticItem.param("aid", TbSingleton.getInstance().getCpuFlopsDuration());
            statisticItem.param("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
            TiebaStatic.log(statisticItem);
        }
    }
}
