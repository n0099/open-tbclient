package d.b.i0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f60232b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f60233a;

    public static b b() {
        if (f60232b == null) {
            synchronized (b.class) {
                if (f60232b == null) {
                    f60232b = new b();
                }
            }
        }
        return f60232b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f60233a == null) {
            this.f60233a = new ArrayList();
        }
        List<StatisticItem> list = this.f60233a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f60233a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f60233a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f60233a.clear();
    }
}
