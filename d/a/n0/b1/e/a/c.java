package d.a.n0.b1.e.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.m0.b.d;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.b1.e.a.e.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {
    public static List<n> a(List<a2> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (a2 a2Var : list) {
            int[] p0 = a2Var.p0();
            if (a2Var.getType() == a2.J2) {
                a2Var.position = i2;
                z1 z1Var = new z1();
                z1Var.w = a2Var;
                z1Var.position = i2;
                z1Var.v = true;
                z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(z1Var);
                z1 z1Var2 = new z1();
                z1Var2.w = a2Var;
                z1Var2.position = i2;
                if (a2Var.R1()) {
                    z1Var2.j = true;
                } else if (a2Var.Z2() == 1) {
                    z1Var2.f50200h = true;
                    z1Var2.x = p0[0];
                    z1Var2.y = p0[1];
                } else if (a2Var.Z2() >= 2) {
                    z1Var2.f50201i = true;
                } else {
                    z1Var2.f50198f = true;
                }
                z1Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(z1Var2);
                z1 z1Var3 = new z1();
                z1Var3.k = true;
                z1Var3.w = a2Var;
                z1Var3.position = i2;
                z1Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(z1Var3);
            } else if (a2Var.getType() == a2.g3) {
                a2Var.position = i2;
                z1 z1Var4 = new z1();
                z1Var4.w = a2Var;
                z1Var4.position = i2;
                z1Var4.v = true;
                z1Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                arrayList.add(z1Var4);
                z1 z1Var5 = new z1();
                z1Var5.w = a2Var;
                z1Var5.position = i2;
                z1Var5.m = true;
                z1Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                arrayList.add(z1Var5);
                z1 z1Var6 = new z1();
                z1Var6.k = true;
                z1Var6.w = a2Var;
                z1Var6.position = i2;
                z1Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                arrayList.add(z1Var6);
            } else {
                a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            i2++;
            a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
        return arrayList;
    }

    public static List<n> b(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            a2 a2Var = new a2();
            a2Var.Z1 = true;
            a2Var.U2(threadInfo);
            f(a2Var);
            arrayList.add(a2Var);
        }
        return a(arrayList);
    }

    public static List<n> c(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ThreadInfo threadInfo = list.get(i3);
            if (threadInfo != null && !TextUtils.isEmpty(threadInfo.title)) {
                arrayList.add(new e(threadInfo, i2));
                i2++;
            }
        }
        return arrayList;
    }

    public static List<n> d(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
            return null;
        }
        boolean u = d.u();
        List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
        if (u) {
            return b(list);
        }
        return c(list);
    }

    public static d.a.n0.b1.e.a.e.b e(List<FrsTabInfo> list) {
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        ArrayList arrayList = new ArrayList();
        frsTabInfoData.tabList = arrayList;
        FrsTabItemData frsTabItemData = new FrsTabItemData();
        frsTabItemData.tabCode = "all";
        frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
        int i2 = 0;
        frsTabItemData.tabId = 0;
        arrayList.add(frsTabItemData);
        if (!ListUtils.isEmpty(list)) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !k.isEmpty(frsTabInfo.tab_code) && !k.isEmpty(frsTabInfo.tab_name)) {
                    i2++;
                    FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                    frsTabItemData2.tabId = i2;
                    arrayList.add(frsTabItemData2);
                }
            }
        }
        return new d.a.n0.b1.e.a.e.b(frsTabInfoData);
    }

    public static void f(a2 a2Var) {
        String G0 = a2Var.G0();
        String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(a2Var.C0() * 1000);
        if (!TextUtils.isEmpty(G0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
            G0 = G0 + "   " + formatTimeForHomeC;
        }
        a2Var.n4(G0);
    }
}
