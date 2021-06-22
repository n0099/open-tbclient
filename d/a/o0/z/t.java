package d.a.o0.z;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static t f67420b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f67421a;

    public static t b() {
        if (f67420b == null) {
            synchronized (t.class) {
                if (f67420b == null) {
                    f67420b = new t();
                }
            }
        }
        return f67420b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f67421a == null) {
            this.f67421a = new ArrayList();
        }
        this.f67421a.add(statisticItem);
    }

    public void c() {
        if (ListUtils.getCount(this.f67421a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f67421a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f67421a.clear();
    }

    public void d(boolean z) {
        if (ListUtils.getCount(this.f67421a) == 0) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f67421a) {
            if (statisticItem != null && i2 != statisticItem.getPosition()) {
                i2 = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f67421a.clear();
    }

    public void e(boolean z) {
        if (ListUtils.getCount(this.f67421a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f67421a) {
            if (statisticItem != null) {
                if (statisticItem.getKey() != null && !statisticItem.getKey().equals("c13756") && !statisticItem.getKey().equals("c13750") && !statisticItem.getKey().equals("c13751")) {
                    statisticItem.param("obj_type", z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.f67421a.clear();
    }
}
