package d.b.j0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f62218b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f62219a;

    public static b b() {
        if (f62218b == null) {
            synchronized (b.class) {
                if (f62218b == null) {
                    f62218b = new b();
                }
            }
        }
        return f62218b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f62219a == null) {
            this.f62219a = new ArrayList();
        }
        List<StatisticItem> list = this.f62219a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f62219a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f62219a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f62219a.clear();
    }
}
