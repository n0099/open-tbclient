package d.b.i0.x;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static t f63884b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f63885a;

    public static t b() {
        if (f63884b == null) {
            synchronized (t.class) {
                if (f63884b == null) {
                    f63884b = new t();
                }
            }
        }
        return f63884b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f63885a == null) {
            this.f63885a = new ArrayList();
        }
        this.f63885a.add(statisticItem);
    }

    public void c() {
        if (ListUtils.getCount(this.f63885a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f63885a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63885a.clear();
    }

    public void d(boolean z) {
        if (ListUtils.getCount(this.f63885a) == 0) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.f63885a) {
            if (statisticItem != null && i != statisticItem.getPosition()) {
                i = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63885a.clear();
    }

    public void e(boolean z) {
        if (ListUtils.getCount(this.f63885a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f63885a) {
            if (statisticItem != null) {
                statisticItem.param("obj_type", z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63885a.clear();
    }
}
