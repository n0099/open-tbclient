package d.a.s0.u0.a2.h;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "ItemTabLogUtil")
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
            StatisticItem statisticItem = new StatisticItem();
            switch (aVar.f()) {
                case 1:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_ALBUM_CLICK).param("obj_name", aVar.b()).param("obj_locate", aVar.c()).param("obj_type", aVar.e()).param("fid", aVar.a()).param("uid", aVar.g());
                    break;
                case 2:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_TAG_CLICK).param("obj_name", aVar.b()).param("obj_locate", aVar.c()).param("fid", aVar.a());
                    break;
                case 3:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RECOMMEND_CLICK).param("obj_name", aVar.b()).param("obj_locate", aVar.c()).param("obj_type", aVar.e()).param("fid", aVar.a());
                    break;
                case 4:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK).param("obj_name", aVar.b()).param("obj_locate", aVar.c()).param("obj_type", aVar.e()).param("fid", aVar.a());
                    break;
                case 5:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_SHOW).param("obj_name", aVar.b()).param("obj_source", aVar.d()).param("fid", aVar.a());
                    break;
                case 6:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RANKING).param("obj_name", aVar.b()).param("obj_type", aVar.e()).param("fid", aVar.a());
                    break;
                case 7:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_EXPORT).param("obj_name", aVar.b()).param("obj_type", aVar.e()).param("fid", aVar.a()).param("uid", aVar.g());
                    break;
                case 8:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_CLICK).param("obj_name", aVar.b()).param("obj_type", aVar.e()).param("fid", aVar.a()).param("uid", aVar.g());
                    break;
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
