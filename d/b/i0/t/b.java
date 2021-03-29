package d.b.i0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f60233b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f60234a;

    public static b b() {
        if (f60233b == null) {
            synchronized (b.class) {
                if (f60233b == null) {
                    f60233b = new b();
                }
            }
        }
        return f60233b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f60234a == null) {
            this.f60234a = new ArrayList();
        }
        List<StatisticItem> list = this.f60234a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f60234a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f60234a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f60234a.clear();
    }
}
