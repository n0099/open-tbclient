package d.b.i0.x;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static t f62309b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f62310a;

    public static t b() {
        if (f62309b == null) {
            synchronized (t.class) {
                if (f62309b == null) {
                    f62309b = new t();
                }
            }
        }
        return f62309b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f62310a == null) {
            this.f62310a = new ArrayList();
        }
        this.f62310a.add(statisticItem);
    }

    public void c() {
        if (ListUtils.getCount(this.f62310a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f62310a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62310a.clear();
    }

    public void d(boolean z) {
        if (ListUtils.getCount(this.f62310a) == 0) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.f62310a) {
            if (statisticItem != null && i != statisticItem.getPosition()) {
                i = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62310a.clear();
    }

    public void e(boolean z) {
        if (ListUtils.getCount(this.f62310a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f62310a) {
            if (statisticItem != null) {
                statisticItem.param("obj_type", z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62310a.clear();
    }
}
