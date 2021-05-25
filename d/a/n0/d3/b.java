package d.a.n0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<BdUniqueId, ArrayList<StatisticItem>> f52723a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f52724b = {TiebaStatic.Params.OBJ_FLOOR, TiebaStatic.Params.OBJ_ISAD, "obj_id", "tid", "pid", "thread_type", "fid", TiebaStatic.Params.POST_TYPE, TiebaStatic.Params.IS_OFFICIAL, TiebaStatic.Params.OBJ_AD_LOCATE, TiebaStatic.Params.RECOM_WEIGHT, "recom_source", TiebaStatic.Params.RECOM_AB_TAG, TiebaStatic.Params.RECOM_EXTRA, TiebaStatic.Params.RECOM_TYPE, TiebaStatic.Params.UGC_VID, TiebaStatic.Params.UGC_NID, TiebaStatic.Params.UGC_TYPE, "obj_locate", TiebaStatic.Params.LIST_ORDER};

    public b() {
        if (this.f52723a == null) {
            this.f52723a = new LinkedHashMap();
        }
    }

    public void a(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        if (statisticItem == null || bdUniqueId == null) {
            return;
        }
        ArrayList<StatisticItem> arrayList = this.f52723a.get(bdUniqueId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f52723a.put(bdUniqueId, arrayList);
        }
        arrayList.add(statisticItem);
    }

    public final String b(List<Object> list, String str) {
        int indexOf;
        int i2;
        if (ListUtils.getCount(list) == 0 || StringUtils.isNull(str) || (indexOf = list.indexOf(str)) < 0 || list.size() <= (i2 = indexOf + 1)) {
            return "";
        }
        String valueOf = String.valueOf(list.get(i2));
        return StringUtils.isNull(valueOf, true) ? "" : valueOf;
    }

    public boolean c(BdUniqueId bdUniqueId) {
        return this.f52723a.containsKey(bdUniqueId);
    }

    public void d(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId == null) {
            return;
        }
        ArrayList<StatisticItem> arrayList = this.f52723a.get(bdUniqueId);
        if (ListUtils.getCount(arrayList) == 0) {
            return;
        }
        e(arrayList);
        arrayList.clear();
    }

    public final void e(ArrayList<StatisticItem> arrayList) {
        if (arrayList == null || ListUtils.getCount(arrayList) == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (ListUtils.getCount(arrayList) == 1) {
            TiebaStatic.log((StatisticItem) ListUtils.getItem(arrayList, 0));
        } else {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                StatisticItem statisticItem = arrayList.get(i2);
                if (hashMap.containsKey(statisticItem.getKey())) {
                    ((List) hashMap.get(statisticItem.getKey())).add(statisticItem);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(statisticItem);
                    hashMap.put(statisticItem.getKey(), arrayList2);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                List list = (List) entry.getValue();
                if (ListUtils.getCount(list) != 0) {
                    StatisticItem statisticItem2 = (StatisticItem) list.get(0);
                    for (int i3 = 0; i3 < this.f52724b.length; i3++) {
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            sb.append(b(((StatisticItem) list.get(i4)).getParams(), this.f52724b[i3]));
                            sb.append(FieldBuilder.SE);
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        statisticItem2.delete(this.f52724b[i3]);
                        statisticItem2.param(this.f52724b[i3] + "s", sb.toString());
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
            if (!hashMap.isEmpty()) {
                hashMap.clear();
            }
        }
        if (BdLog.isDebugMode()) {
            BdLog.e("logStatisticByKey->" + (System.currentTimeMillis() - currentTimeMillis) + "|size=" + arrayList.size());
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f52723a.put(bdUniqueId, null);
    }

    public void g() {
        if (this.f52723a.size() == 0) {
            return;
        }
        for (Map.Entry<BdUniqueId, ArrayList<StatisticItem>> entry : this.f52723a.entrySet()) {
            ArrayList<StatisticItem> value = entry.getValue();
            if (value != null) {
                value.clear();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.f52723a.remove(bdUniqueId);
    }
}
