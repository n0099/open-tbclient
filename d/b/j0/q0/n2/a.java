package d.b.j0.q0.n2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static void a(d.b.j0.e.e.b bVar, ForumData forumData, List<d.b.c.j.e.n> list, boolean z, int i) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.b.j0.e.f.b bVar2 = new d.b.j0.e.f.b(bVar, 5);
        bVar2.E(list);
        if (forumData != null) {
            bVar2.v(forumData.getId());
            bVar2.u(forumData.getFirst_class());
            bVar2.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            bVar2.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        bVar2.y(z);
        bVar2.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
    }

    public static void b(d.b.j0.e.e.b bVar, FrsViewData frsViewData, List<d.b.c.j.e.n> list, int i) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i);
        }
    }

    public static void c(d.b.j0.d3.h0.f fVar, List<d.b.c.j.e.n> list, List<d.b.c.j.e.n> list2) {
        int[] iArr;
        int indexOf;
        if (fVar == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : d.b.j0.d3.h0.f.f55244f) {
            d.b.c.j.e.n nVar = (d.b.c.j.e.n) ListUtils.getItem(list, i);
            if (nVar != null && (indexOf = list2.indexOf(nVar)) >= 0) {
                fVar.a(i, indexOf);
            }
        }
    }
}
