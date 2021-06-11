package d.a.n0.v;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f65120b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f65121a;

    public static b b() {
        if (f65120b == null) {
            synchronized (b.class) {
                if (f65120b == null) {
                    f65120b = new b();
                }
            }
        }
        return f65120b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f65121a == null) {
            this.f65121a = new ArrayList();
        }
        List<StatisticItem> list = this.f65121a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f65121a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f65121a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f65121a.clear();
    }
}
