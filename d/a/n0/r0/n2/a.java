package d.a.n0.r0.n2;

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
    public static void a(d.a.n0.e.e.b bVar, ForumData forumData, List<d.a.c.k.e.n> list, boolean z, int i2) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(bVar, 5);
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
        bVar2.A(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
    }

    public static void b(d.a.n0.e.e.b bVar, FrsViewData frsViewData, List<d.a.c.k.e.n> list, int i2) {
        if (frsViewData != null) {
            a(bVar, frsViewData.getForum(), list, false, i2);
        }
    }

    public static void c(d.a.n0.e3.h0.f fVar, List<d.a.c.k.e.n> list, List<d.a.c.k.e.n> list2) {
        int[] iArr;
        int indexOf;
        if (fVar == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i2 : d.a.n0.e3.h0.f.f57690f) {
            d.a.c.k.e.n nVar = (d.a.c.k.e.n) ListUtils.getItem(list, i2);
            if (nVar != null && (indexOf = list2.indexOf(nVar)) >= 0) {
                fVar.a(i2, indexOf);
            }
        }
    }
}
