package d.b.i0.m1.l;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, Map<String, String> map) {
        if (k.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.param(str2, map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public static void b(Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String remove = map.remove("key");
        for (String str : map.keySet()) {
            hashMap.put(str, map.get(str));
        }
        a(remove, hashMap);
    }
}
