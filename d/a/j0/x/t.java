package d.a.j0.x;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static t f62573b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f62574a;

    public static t b() {
        if (f62573b == null) {
            synchronized (t.class) {
                if (f62573b == null) {
                    f62573b = new t();
                }
            }
        }
        return f62573b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f62574a == null) {
            this.f62574a = new ArrayList();
        }
        this.f62574a.add(statisticItem);
    }

    public void c() {
        if (ListUtils.getCount(this.f62574a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f62574a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62574a.clear();
    }

    public void d(boolean z) {
        if (ListUtils.getCount(this.f62574a) == 0) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f62574a) {
            if (statisticItem != null && i2 != statisticItem.getPosition()) {
                i2 = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62574a.clear();
    }

    public void e(boolean z) {
        if (ListUtils.getCount(this.f62574a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f62574a) {
            if (statisticItem != null) {
                statisticItem.param("obj_type", z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62574a.clear();
    }
}
