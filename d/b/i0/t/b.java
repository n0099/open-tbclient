package d.b.i0.t;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f61797b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f61798a;

    public static b b() {
        if (f61797b == null) {
            synchronized (b.class) {
                if (f61797b == null) {
                    f61797b = new b();
                }
            }
        }
        return f61797b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f61798a == null) {
            this.f61798a = new ArrayList();
        }
        List<StatisticItem> list = this.f61798a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        if (ListUtils.getCount(this.f61798a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f61798a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f61798a.clear();
    }
}
