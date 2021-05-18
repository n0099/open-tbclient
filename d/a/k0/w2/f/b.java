package d.a.k0.w2.f;

import android.os.Bundle;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class b {
    public static void a(int i2, ShareEntity shareEntity) {
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
        Bundle l = shareEntity.l();
        if (l != null) {
            statisticItem.param("tid", l.getString("tid"));
            statisticItem.param("uid", l.getString("uid"));
            statisticItem.param("fid", l.getString("fid"));
        }
        TiebaStatic.log(statisticItem);
    }

    public static void b(int i2, ShareEntity shareEntity) {
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
        Bundle l = shareEntity.l();
        if (l != null) {
            int i4 = l.getInt("obj_param1");
            if (i4 != 0) {
                statisticItem.param("obj_param1", i4);
                if (i4 == 2) {
                    statisticItem.param("fid", l.getString("fid"));
                } else if (i4 == 3) {
                    int i5 = l.getInt("obj_type");
                    if (i5 != 0) {
                        statisticItem.param("obj_type", i5);
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
