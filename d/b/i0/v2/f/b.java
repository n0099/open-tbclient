package d.b.i0.v2.f;

import android.os.Bundle;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.b.b.e.p.k;
/* loaded from: classes5.dex */
public class b {
    public static void a(int i, ShareEntity shareEntity) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
        int i2 = 6;
        if (i == 2) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 2;
        } else if (i == 4) {
            i2 = 4;
        } else if (i != 6) {
            i2 = i != 8 ? 0 : 5;
        }
        if (i2 != 0) {
            statisticItem.param("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(statisticItem);
            return;
        }
        Bundle l = shareEntity.l();
        if (l != null) {
            statisticItem.param("tid", l.getString("tid"));
            statisticItem.param("uid", l.getString("uid"));
            statisticItem.param("fid", l.getString("fid"));
        }
        TiebaStatic.log(statisticItem);
    }

    public static void b(int i, ShareEntity shareEntity) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
        int i2 = 6;
        if (i == 2) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 2;
        } else if (i == 4) {
            i2 = 4;
        } else if (i != 6) {
            i2 = i != 8 ? 0 : 5;
        }
        if (i2 != 0) {
            statisticItem.param("obj_source", i2);
        }
        if (shareEntity == null) {
            TiebaStatic.log(statisticItem);
            return;
        }
        Bundle l = shareEntity.l();
        if (l != null) {
            int i3 = l.getInt("obj_param1");
            if (i3 != 0) {
                statisticItem.param("obj_param1", i3);
                if (i3 == 2) {
                    statisticItem.param("fid", l.getString("fid"));
                } else if (i3 == 3) {
                    int i4 = l.getInt("obj_type");
                    if (i4 != 0) {
                        statisticItem.param("obj_type", i4);
                    }
                    statisticItem.param("tid", l.getString("tid")).param("fid", l.getString("fid"));
                }
            }
            String string = l.getString(TiebaStatic.Params.OBJ_URL);
            if (!k.isEmpty(string)) {
                statisticItem.param(TiebaStatic.Params.OBJ_URL, string);
            }
            statisticItem.param("obj_locate", l.getInt("obj_locate"));
        }
        TiebaStatic.log(statisticItem);
    }
}
