package d.a.j0.t.d.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f60652b;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f60653a;

    public static a c() {
        if (f60652b == null) {
            synchronized (a.class) {
                if (f60652b == null) {
                    f60652b = new a();
                }
            }
        }
        return f60652b;
    }

    public void a(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        if (this.f60653a == null) {
            this.f60653a = new ArrayList();
        }
        List<StatisticItem> list = this.f60653a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void b(String str) {
        if (str == null) {
            return;
        }
        if (this.f60653a == null) {
            this.f60653a = new ArrayList();
        }
        List<StatisticItem> list = this.f60653a;
        if (list != null) {
            list.add(new StatisticItem(str));
        }
    }

    public final long d(a2 a2Var) {
        if (a2Var == null || a2Var.q1() == null) {
            return -1L;
        }
        return a2Var.q1().live_id;
    }

    public StatisticItem e(int i2, String str, int i3, String str2, a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        String str3 = (a2Var.q1() == null || StringUtils.isNull(a2Var.q1().appId)) ? "" : a2Var.q1().appId;
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_id", d(a2Var));
        statisticItem.param("tid", a2Var.o0());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
        statisticItem.param("entryid", i3);
        statisticItem.param("name", str2);
        statisticItem.param("is_small_follow", i2);
        return statisticItem;
    }

    public void f(String str, int i2, int i3, String str2) {
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", i2);
        statisticItem.param("obj_type", i3);
        statisticItem.param("tid", str2);
        TiebaStatic.log(statisticItem);
    }

    public void g() {
        if (ListUtils.getCount(this.f60653a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f60653a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f60653a.clear();
    }

    public void h(boolean z) {
        if (ListUtils.getCount(this.f60653a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f60653a) {
            if (statisticItem != null) {
                if (!statisticItem.getParams().contains(TiebaStatic.Params.OBJ_PARAM2)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.f60653a.clear();
    }
}
