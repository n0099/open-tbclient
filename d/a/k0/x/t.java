package d.a.k0.x;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static t f63297b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f63298a;

    public static t b() {
        if (f63297b == null) {
            synchronized (t.class) {
                if (f63297b == null) {
                    f63297b = new t();
                }
            }
        }
        return f63297b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f63298a == null) {
            this.f63298a = new ArrayList();
        }
        this.f63298a.add(statisticItem);
    }

    public void c() {
        if (ListUtils.getCount(this.f63298a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f63298a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63298a.clear();
    }

    public void d(boolean z) {
        if (ListUtils.getCount(this.f63298a) == 0) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f63298a) {
            if (statisticItem != null && i2 != statisticItem.getPosition()) {
                i2 = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63298a.clear();
    }

    public void e(boolean z) {
        if (ListUtils.getCount(this.f63298a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f63298a) {
            if (statisticItem != null) {
                statisticItem.param("obj_type", z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.f63298a.clear();
    }
}
