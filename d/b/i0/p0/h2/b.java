package d.b.i0.p0.h2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.b.b.j.e.n;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    public static boolean a(ArrayList<n> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        if (cardHListViewData != null && !ListUtils.isEmpty(arrayList) && !StringUtils.isNull(str) && i >= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = arrayList.get(i2);
                if ((nVar instanceof CardHListViewData) && str.equals(((CardHListViewData) nVar).threadId)) {
                    return false;
                }
            }
            int i3 = i + 1;
            if (i3 > 0) {
                ListUtils.add(arrayList, i3, cardHListViewData);
                return true;
            }
        }
        return false;
    }

    public static boolean b(FrsRequestData frsRequestData) {
        return frsRequestData != null && frsRequestData.w() == 1;
    }
}
