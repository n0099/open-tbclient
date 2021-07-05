package d.a.s0.a3.f;

import android.os.Bundle;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.k;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i2, shareEntity) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
            int i3 = 6;
            if (i2 == 2) {
                i3 = 3;
            } else if (i2 == 3) {
                i3 = 2;
            } else if (i2 == 4) {
                i3 = 4;
            } else if (i2 != 6) {
                i3 = i2 != 8 ? 0 : 5;
            }
            if (i3 != 0) {
                statisticItem.param("obj_source", i3);
            }
            if (shareEntity == null) {
                TiebaStatic.log(statisticItem);
                return;
            }
            Bundle stats = shareEntity.getStats();
            if (stats != null) {
                statisticItem.param("tid", stats.getString("tid"));
                statisticItem.param("uid", stats.getString("uid"));
                statisticItem.param("fid", stats.getString("fid"));
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i2, ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, shareEntity) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
            int i3 = 6;
            if (i2 == 2) {
                i3 = 3;
            } else if (i2 == 3) {
                i3 = 2;
            } else if (i2 == 4) {
                i3 = 4;
            } else if (i2 != 6) {
                i3 = i2 != 8 ? 0 : 5;
            }
            if (i3 != 0) {
                statisticItem.param("obj_source", i3);
            }
            if (shareEntity == null) {
                TiebaStatic.log(statisticItem);
                return;
            }
            Bundle stats = shareEntity.getStats();
            if (stats != null) {
                int i4 = stats.getInt("obj_param1");
                if (i4 != 0) {
                    statisticItem.param("obj_param1", i4);
                    if (i4 == 2) {
                        statisticItem.param("fid", stats.getString("fid"));
                    } else if (i4 == 3) {
                        int i5 = stats.getInt("obj_type");
                        if (i5 != 0) {
                            statisticItem.param("obj_type", i5);
                        }
                        statisticItem.param("tid", stats.getString("tid")).param("fid", stats.getString("fid"));
                    }
                }
                String string = stats.getString(TiebaStatic.Params.OBJ_URL);
                if (!k.isEmpty(string)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_URL, string);
                }
                statisticItem.param("obj_locate", stats.getInt("obj_locate"));
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
