package d.a.m0.i0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f53102c;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f53103a = i(d.a.m0.r.d0.b.j().p("key_need_add_source_stat_list", ""));

    /* renamed from: b  reason: collision with root package name */
    public List<String> f53104b = i("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");

    public static void b(Context context, StatisticItem statisticItem, d.a.m0.k0.d dVar) {
        if (dVar == null || statisticItem == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        c k = dVar.k();
        if (k == null || k.e()) {
            k = TbPageExtraHelper.k(context);
        }
        if (k != null && !k.e()) {
            c(statisticItem, k);
        }
        TbPageExtraHelper.r(statisticItem.toString());
    }

    public static void c(StatisticItem statisticItem, c cVar) {
        if (statisticItem == null || cVar == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        String a2 = cVar.a();
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a2);
        }
        String a3 = d.a(cVar.c(), a2, 6);
        if (TextUtils.isEmpty(a3) || statisticItem.hasParam("page_source")) {
            return;
        }
        statisticItem.param("page_source", a3);
    }

    public static e f() {
        if (f53102c == null) {
            synchronized (e.class) {
                if (f53102c == null) {
                    f53102c = new e();
                }
            }
        }
        return f53102c;
    }

    public final void a(StatisticItem statisticItem) {
        Activity currentActivity;
        c k;
        if (statisticItem == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (k = TbPageExtraHelper.k(currentActivity)) == null) {
            return;
        }
        String a2 = k.a();
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a2);
        }
        String a3 = d.a(k.c(), a2, 6);
        if (!TextUtils.isEmpty(a3) && !statisticItem.hasParam("page_source")) {
            statisticItem.param("page_source", a3);
        }
        TbPageExtraHelper.r(statisticItem.toString());
    }

    public final <T> List<T> d(T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            if (t != null && !TextUtils.isEmpty(t.toString())) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public void e(StatisticItem statisticItem) {
        if (statisticItem == null || statisticItem.hasParam("page_source")) {
            return;
        }
        if (h(statisticItem.getKey()) || g(statisticItem.getKey())) {
            a(statisticItem);
        }
    }

    public boolean g(String str) {
        if (!ListUtils.isEmpty(this.f53104b) && !k.isEmpty(str)) {
            for (String str2 : this.f53104b) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean h(String str) {
        if (!ListUtils.isEmpty(this.f53103a) && !k.isEmpty(str)) {
            for (String str2 : this.f53103a) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List<String> i(String str) {
        if (k.isEmpty(str)) {
            return null;
        }
        return d(str.split(","));
    }

    public void j(String str) {
        this.f53103a = i(str);
        if (str == null) {
            str = "";
        }
        d.a.m0.r.d0.b.j().x("key_need_add_source_stat_list", str);
    }
}
