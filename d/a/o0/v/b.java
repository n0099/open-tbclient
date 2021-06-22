package d.a.o0.v;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f65245b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f65246a;

    public static b b() {
        if (f65245b == null) {
            synchronized (b.class) {
                if (f65245b == null) {
                    f65245b = new b();
                }
            }
        }
        return f65245b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f65246a == null) {
            this.f65246a = new ArrayList();
        }
        List<StatisticItem> list = this.f65246a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f65246a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f65246a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f65246a.clear();
    }
}
