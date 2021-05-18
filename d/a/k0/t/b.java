package d.a.k0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f61119b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f61120a;

    public static b b() {
        if (f61119b == null) {
            synchronized (b.class) {
                if (f61119b == null) {
                    f61119b = new b();
                }
            }
        }
        return f61119b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f61120a == null) {
            this.f61120a = new ArrayList();
        }
        List<StatisticItem> list = this.f61120a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f61120a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f61120a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f61120a.clear();
    }
}
