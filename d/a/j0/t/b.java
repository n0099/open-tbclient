package d.a.j0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f60395b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f60396a;

    public static b b() {
        if (f60395b == null) {
            synchronized (b.class) {
                if (f60395b == null) {
                    f60395b = new b();
                }
            }
        }
        return f60395b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f60396a == null) {
            this.f60396a = new ArrayList();
        }
        List<StatisticItem> list = this.f60396a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f60396a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f60396a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f60396a.clear();
    }
}
