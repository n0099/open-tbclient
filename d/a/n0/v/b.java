package d.a.n0.v;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f61407b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f61408a;

    public static b b() {
        if (f61407b == null) {
            synchronized (b.class) {
                if (f61407b == null) {
                    f61407b = new b();
                }
            }
        }
        return f61407b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f61408a == null) {
            this.f61408a = new ArrayList();
        }
        List<StatisticItem> list = this.f61408a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f61408a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f61408a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f61408a.clear();
    }
}
