package d.a.k0.q0.h2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.c.j.e.n;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    public static boolean a(ArrayList<n> arrayList, String str, CardHListViewData cardHListViewData, int i2) {
        if (cardHListViewData != null && !ListUtils.isEmpty(arrayList) && !StringUtils.isNull(str) && i2 >= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                n nVar = arrayList.get(i3);
                if ((nVar instanceof CardHListViewData) && str.equals(((CardHListViewData) nVar).threadId)) {
                    return false;
                }
            }
            int i4 = i2 + 1;
            if (i4 > 0) {
                ListUtils.add(arrayList, i4, cardHListViewData);
                return true;
            }
        }
        return false;
    }

    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.w() == 1;
    }
}
